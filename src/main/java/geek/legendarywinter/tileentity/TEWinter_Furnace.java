package geek.legendarywinter.tileentity;

import geek.legendarywinter.blocks.Winter_Furnace;
import geek.legendarywinter.init.BlocksRegistry;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.inventory.containerSnowFurnace;
import geek.legendarywinter.inventory.slotSnowFurnaceFuel;
import geek.legendarywinter.items.recipe.Winter_Furnace_Recipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TEWinter_Furnace
  extends TileEntity
  implements ITickable, ISidedInventory {

  private static final int[] SLOTS_TOP = new int[] { 0 };
  private static final int[] SLOTS_BOTTOM = new int[] { 2, 1 };
  private static final int[] SLOTS_SIDES = new int[] { 1 };
  /** The ItemStacks that hold the items currently being used in the furnace */
  private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(
    3,
    ItemStack.EMPTY
  );
  /** The number of ticks that the furnace will keep burning */
  private int furnaceBurnTime;
  /**
   * The number of ticks that a fresh copy of the currently-burning item would
   * keep the furnace burning for
   */
  private int currentItemBurnTime;
  private int cookTime;
  private int totalCookTime;
  private String furnaceCustomName;

  /**
   * Returns the number of slots in the inventory.
   */
  public int getSizeInventory() {
    return this.furnaceItemStacks.size();
  }

  public boolean isEmpty() {
    for (ItemStack itemstack : this.furnaceItemStacks) {
      if (!itemstack.isEmpty()) {
        return false;
      }
    }

    return true;
  }

  /**
   * Returns the stack in the given slot.
   */
  public ItemStack getStackInSlot(int index) {
    return this.furnaceItemStacks.get(index);
  }

  /**
   * Removes up to a specified number of items from an inventory slot and returns
   * them in a new stack.
   */
  public ItemStack decrStackSize(int index, int count) {
    return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
  }

  /**
   * Removes a stack from the given slot and returns it.
   */
  public ItemStack removeStackFromSlot(int index) {
    return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
  }

  /**
   * Sets the given item stack to the specified slot in the inventory (can be
   * crafting or armor sections).
   */
  public void setInventorySlotContents(int index, ItemStack stack) {
    ItemStack itemstack = this.furnaceItemStacks.get(index);
    boolean flag =
      !stack.isEmpty() &&
      stack.isItemEqual(itemstack) &&
      ItemStack.areItemStackTagsEqual(stack, itemstack);
    this.furnaceItemStacks.set(index, stack);

    if (stack.getCount() > this.getInventoryStackLimit()) {
      stack.setCount(this.getInventoryStackLimit());
    }

    if (index == 0 && !flag) {
      this.totalCookTime = this.getCookTime(stack);
      this.cookTime = 0;
      this.markDirty();
    }
  }

  public String getName() {
    return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
  }

  public boolean hasCustomName() {
    return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
  }

  public void setCustomInventoryName(String p_145951_1_) {
    this.furnaceCustomName = p_145951_1_;
  }

  public static void registerFixesFurnace(DataFixer fixer) {
    fixer.registerWalker(
      FixTypes.BLOCK_ENTITY,
      new ItemStackDataLists(TEWinter_Furnace.class, new String[] { "Items" })
    );
  }

  public void readFromNBT(NBTTagCompound compound) {
    super.readFromNBT(compound);
    this.furnaceItemStacks =
      NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
    ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
    this.furnaceBurnTime = compound.getInteger("BurnTime");
    this.cookTime = compound.getInteger("CookTime");
    this.totalCookTime = compound.getInteger("CookTimeTotal");
    this.currentItemBurnTime = getItemFreezeTime(this.furnaceItemStacks.get(1));

    if (compound.hasKey("CustomName", 8)) {
      this.furnaceCustomName = compound.getString("CustomName");
    }
  }

  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    super.writeToNBT(compound);
    compound.setInteger("BurnTime", (short) this.furnaceBurnTime);
    compound.setInteger("CookTime", (short) this.cookTime);
    compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
    ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

    if (this.hasCustomName()) {
      compound.setString("CustomName", this.furnaceCustomName);
    }

    return compound;
  }

  /**
   * Returns the maximum stack size for a inventory slot. Seems to always be 64,
   * possibly will be extended.
   */
  public int getInventoryStackLimit() {
    return 64;
  }

  /**
   * Furnace isBurning
   */
  public boolean isBurning() {
    return this.furnaceBurnTime > 0;
  }

  @SideOnly(Side.CLIENT)
  public static boolean isBurning(IInventory inventory) {
    return inventory.getField(0) > 0;
  }

  /**
   * Like the old updateEntity(), except more generic.
   */
  public void update() {
    boolean flag = this.isBurning();
    boolean flag1 = false;

    if (this.isBurning()) {
      --this.furnaceBurnTime;
    }

    if (!this.world.isRemote) {
      ItemStack itemstack = this.furnaceItemStacks.get(1);

      if (
        this.isBurning() ||
        !itemstack.isEmpty() &&
        !((ItemStack) this.furnaceItemStacks.get(0)).isEmpty()
      ) {
        if (!this.isBurning() && this.canSmelt()) {
          this.furnaceBurnTime = getItemFreezeTime(itemstack);
          this.currentItemBurnTime = this.furnaceBurnTime;

          if (this.isBurning()) {
            flag1 = true;

            if (!itemstack.isEmpty()) {
              Item item = itemstack.getItem();
              itemstack.shrink(1);

              if (itemstack.isEmpty()) {
                ItemStack item1 = item.getContainerItem(itemstack);
                this.furnaceItemStacks.set(1, item1);
              }
            }
          }
        }

        if (this.isBurning() && this.canSmelt()) {
          ++this.cookTime;

          if (this.cookTime == this.totalCookTime) {
            this.cookTime = 0;
            this.totalCookTime =
              this.getCookTime(this.furnaceItemStacks.get(0));
            this.smeltItem();
            flag1 = true;
          }
        } else {
          this.cookTime = 0;
        }
      } else if (!this.isBurning() && this.cookTime > 0) {
        this.cookTime =
          MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
      }

      if (flag != this.isBurning()) {
        flag1 = true;
        Winter_Furnace.setState(this.isBurning(), this.world, this.pos);
      }
    }

    if (flag1) {
      this.markDirty();
    }
  }

  public int getCookTime(ItemStack stack) {
    return 200;
  }

  /**
   * Returns true if the furnace can smelt an item, i.e. has a source item,
   * destination stack isn't full, etc.
   */
  private boolean canSmelt() {
    if (((ItemStack) this.furnaceItemStacks.get(0)).isEmpty()) {
      return false;
    } else {
      ItemStack itemstack = Winter_Furnace_Recipes
        .instance()
        .getFreezingResult(this.furnaceItemStacks.get(0));

      if (itemstack.isEmpty()) {
        return false;
      } else {
        ItemStack itemstack1 = this.furnaceItemStacks.get(2);

        if (itemstack1.isEmpty()) {
          return true;
        } else if (!itemstack1.isItemEqual(itemstack)) {
          return false;
        } else if (
          itemstack1.getCount() +
          itemstack.getCount() <=
          this.getInventoryStackLimit() &&
          itemstack1.getCount() +
          itemstack.getCount() <=
          itemstack1.getMaxStackSize()
        ) // sizes in // stack // respect // furnace // make // Forge fix:
        // furnace
        // recipes
        {
          return true;
        } else {
          return (
            itemstack1.getCount() +
            itemstack.getCount() <=
            itemstack.getMaxStackSize()
          ); // Forge fix:
          // make furnace
          // respect stack
          // sizes in
          // furnace
          // recipes
        }
      }
    }
  }

  /**
   * Turn one item from the furnace source stack into the appropriate smelted item
   * in the furnace result stack
   */

  public void smeltItem() {
    if (this.canSmelt()) {
      ItemStack itemstack = this.furnaceItemStacks.get(0);
      ItemStack itemstack1 = Winter_Furnace_Recipes
        .instance()
        .getFreezingResult(itemstack);
      ItemStack itemstack2 = this.furnaceItemStacks.get(2);

      if (itemstack2.isEmpty()) {
        this.furnaceItemStacks.set(2, itemstack1.copy());
      } else if (itemstack2.getItem() == itemstack1.getItem()) {
        itemstack2.grow(itemstack1.getCount());
      }

      if (
        itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) &&
        itemstack.getMetadata() == 1 &&
        !((ItemStack) this.furnaceItemStacks.get(1)).isEmpty() &&
        ((ItemStack) this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET
      ) {
        this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
      }

      itemstack.shrink(1);
    }
  }

  /*
  /**
   * Returns the number of ticks that the supplied fuel item will keep the furnace
   * burning, or 0 if the item isn't fuel
   */
  public static int getItemFreezeTime(ItemStack stack) {
    if (stack.isEmpty()) {
      return 0;
    } else {
      int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(
        stack
      );
      if (burnTime >= 0) return burnTime;
      Item item = stack.getItem();

      if (item == Items.SNOWBALL) {
        return 100;
      } else if (item == Item.getItemFromBlock(BlocksRegistry.StrangeSnow)) {
        return 300;
      } else if (item == ItemsRegistery.strangesnowball) {
        return 2400;
      }
    }
    return 0;
  }

  public static boolean isItemFuel(ItemStack stack) {
    return getItemFreezeTime(stack) > 0;
  }

  /**
   * Don't rename this method to canInteractWith due to conflicts with Container
   */
  /*
  public boolean isUsableByPlayer(EntityPlayer player) {
    if (this.world.getTileEntity(this.pos) != this) {
      return false;
    } else {
      return (
        player.getDistanceSq(
          (double) this.pos.getX() + 0.5D,
          (double) this.pos.getY() + 0.5D,
          (double) this.pos.getZ() + 0.5D
        ) <=
        64.0D
      );
    }
  }

  public void openInventory(EntityPlayer player) {}

  public void closeInventory(EntityPlayer player) {}

  /**
   * Returns true if automation is allowed to insert the given stack (ignoring
   * stack size) into the given slot. For guis use Slot.isItemValid
   */
  /*
  public boolean isItemValidForSlot(int index, ItemStack stack) {
    if (index == 2) {
      return false;
    } else if (index != 1) {
      return true;
    } else {
      ItemStack itemstack = this.furnaceItemStacks.get(1);
      return (
        isItemFuel(stack) ||
        slotSnowFurnaceFuel.isBucket(stack) &&
        itemstack.getItem() != Items.BUCKET
      );
    }
  }

  public int[] getSlotsForFace(EnumFacing side) {
    if (side == EnumFacing.DOWN) {
      return SLOTS_BOTTOM;
    } else {
      return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
    }
  }

  /**
   * Returns true if automation can insert the given item in the given slot from
   * the given side.
   */
  /*
  public boolean canInsertItem(
    int index,
    ItemStack itemStackIn,
    EnumFacing direction
  ) {
    return this.isItemValidForSlot(index, itemStackIn);
  }

  /**
   * Returns true if automation can extract the given item in the given slot from
   * the given side.
   *//*
  public boolean canExtractItem(
    int index,
    ItemStack stack,
    EnumFacing direction
  ) {
    if (direction == EnumFacing.DOWN && index == 1) {
      Item item = stack.getItem();

      if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
        return false;
      }
    }

    return true;
  }

  public String getGuiID() {
    return "minecraft:furnace";
  }

  public Container createContainer(
    InventoryPlayer playerInventory,
    EntityPlayer playerIn
  ) {
    return new containerSnowFurnace(playerInventory, this);
  }

  public int getField(int id) {
    switch (id) {
      case 0:
        return this.furnaceBurnTime;
      case 1:
        return this.currentItemBurnTime;
      case 2:
        return this.cookTime;
      case 3:
        return this.totalCookTime;
      default:
        return 0;
    }
  }

  public void setField(int id, int value) {
    switch (id) {
      case 0:
        this.furnaceBurnTime = value;
        break;
      case 1:
        this.currentItemBurnTime = value;
        break;
      case 2:
        this.cookTime = value;
        break;
      case 3:
        this.totalCookTime = value;
    }
  }

  public int getFieldCount() {
    return 4;
  }

  public void clear() {
    this.furnaceItemStacks.clear();
  }

  net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(
    this,
    net.minecraft.util.EnumFacing.UP
  );
  net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(
    this,
    net.minecraft.util.EnumFacing.DOWN
  );
  net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(
    this,
    net.minecraft.util.EnumFacing.WEST
  );

  @SuppressWarnings("unchecked")
  @Override
  @javax.annotation.Nullable
  public <T> T getCapability(
    net.minecraftforge.common.capabilities.Capability<T> capability,
    @javax.annotation.Nullable net.minecraft.util.EnumFacing facing
  ) {
    if (
      facing != null &&
      capability ==
      net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
    ) if (facing == EnumFacing.DOWN) return (T) handlerBottom; else if (
      facing == EnumFacing.UP
    ) return (T) handlerTop; else return (T) handlerSide;
    return super.getCapability(capability, facing);
  }
}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item
	 * in the furnace result stack
	 *//*
	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack = this.furnaceItemStacks.get(0);
			ItemStack itemstack1 = Winter_Furnace_Recipes.instance().getFreezingResult(itemstack);
			ItemStack itemstack2 = this.furnaceItemStacks.get(2);

			if (itemstack2.isEmpty()) {
				this.furnaceItemStacks.set(2, itemstack1.copy());
			} else if (itemstack2.getItem() == itemstack1.getItem()) {
				itemstack2.grow(itemstack1.getCount());
			}

			if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1
					&& !((ItemStack) this.furnaceItemStacks.get(1)).isEmpty()
					&& ((ItemStack) this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET) {
				this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
			}

			itemstack.shrink(1);
		}
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the furnace
	 * burning, or 0 if the item isn't fuel
	 *//*
	public static int getItemFreezeTime(ItemStack stack) {
		if (stack.isEmpty()) {
			return 0;
		} else {
			int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
			if (burnTime >= 0)
				return burnTime;
			Item item = stack.getItem();

			if (item == Items.SNOWBALL) {
				return 100;
			} else if (item == Item.getItemFromBlock(BlocksRegistry.StrangeSnow)) {
				return 300;
			} else if (item == ItemsRegistery.strangesnowball) {
				return 2400;
			}

		}
		return 0;
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemFreezeTime(stack) > 0;
	}

	/**
	 * Don't rename this method to canInteractWith due to conflicts with Container
	 *//*
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	public void openInventory(EntityPlayer player) {
	}

	public void closeInventory(EntityPlayer player) {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot. For guis use Slot.isItemValid
	 *//*
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 2) {
			return false;
		} else if (index != 1) {
			return true;
		} else {
			ItemStack itemstack = this.furnaceItemStacks.get(1);
			return isItemFuel(stack) || slotSnowFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
		}
	}

	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN) {
			return SLOTS_BOTTOM;
		} else {
			return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
		}
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from
	 * the given side.
	 *//*
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from
	 * the given side.
	 *//*
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	public String getGuiID() {
		return "minecraft:furnace";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new containerSnowFurnace(playerInventory, this);
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.furnaceBurnTime;
		case 1:
			return this.currentItemBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.furnaceBurnTime = value;
			break;
		case 1:
			this.currentItemBurnTime = value;
			break;
		case 2:
			this.cookTime = value;
			break;
		case 3:
			this.totalCookTime = value;
		}
	}

	public int getFieldCount() {
		return 4;
	}

	public void clear() {
		this.furnaceItemStacks.clear();
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.WEST);

	@SuppressWarnings("unchecked")
	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability,
			@javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
	*/

  @Override
  public boolean isUsableByPlayer(EntityPlayer player) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void openInventory(EntityPlayer player) {
    // TODO Auto-generated method stub

  }

  @Override
  public void closeInventory(EntityPlayer player) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isItemValidForSlot(int index, ItemStack stack) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getField(int id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setField(int id, int value) {
    // TODO Auto-generated method stub

  }

  @Override
  public int getFieldCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

  //   @Override
  //   public Container createContainer(
  //     InventoryPlayer playerInventory,
  //     EntityPlayer playerIn
  //   ) {
  //     // TODO Auto-generated method stub
  //     return null;
  //   }

  //   @Override
  public String getGuiID() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int[] getSlotsForFace(EnumFacing side) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean canInsertItem(
    int index,
    ItemStack itemStackIn,
    EnumFacing direction
  ) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canExtractItem(
    int index,
    ItemStack stack,
    EnumFacing direction
  ) {
    // TODO Auto-generated method stub
    return false;
  }
}
