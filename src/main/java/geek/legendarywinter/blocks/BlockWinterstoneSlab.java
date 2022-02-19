package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import javax.annotation.Nonnull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

/**
 * @author Cadiboo
 */
public abstract class BlockWinterstoneSlab extends BlockSlab {

  public static final PropertyEnum<EnumVariant> VARIANT = PropertyEnum.<EnumVariant>create(
    "variant",
    EnumVariant.class
  );

  public BlockWinterstoneSlab() {
    // TODO: keep this material in sync with Winterstone's material
    super(Material.ROCK);
    // TODO: keep this hardness in sync with Winterstone's hardness
    this.setHardness(0.2F);
    this.setCreativeTab(GeekTab.instance);
    IBlockState state =
      this.blockState.getBaseState().withProperty(VARIANT, EnumVariant.DEFAULT);
    if (!this.isDouble()) {
      state = state.withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
    }
    this.setDefaultState(state);
    this.useNeighborBrightness = !this.isDouble();
  }

  protected BlockStateContainer createBlockState() {
    return this.isDouble()
      ? new BlockStateContainer(this, new IProperty[] { VARIANT })
      : new BlockStateContainer(this, new IProperty[] { HALF, VARIANT });
  }

  //   @Override
  //   @Nonnull
  //   public String getTranslationKey(final int meta) {
  //     return this.getTranslationKey(meta);
  //   }

  @Override
  public boolean isDouble() {
    return false;
  }

  @Override
  @Nonnull
  public IProperty<?> getVariantProperty() {
    return VARIANT;
  }

  @Override
  @Nonnull
  public Comparable<?> getTypeForItem(final ItemStack stack) {
    return EnumVariant.DEFAULT;
  }

  public enum EnumVariant implements IStringSerializable {
    DEFAULT();

    @Override
    @Nonnull
    public String getName() {
      return "default";
    }
  }

  @Override
  public int getMetaFromState(final IBlockState state) {
    if (this.isDouble()) {
      return 0;
    } else {
      return state.getValue(HALF).ordinal();
    }
  }

  @Override
  @Nonnull
  public IBlockState getStateFromMeta(final int meta) {
    if (this.isDouble()) {
      return this.getDefaultState();
    } else {
      // % 2 to be nice & not crash if somehow there's a higher number than 1
      return this.getDefaultState()
        .withProperty(HALF, BlockSlab.EnumBlockHalf.values()[meta % 2]);
    }
  }

  public static class Double extends BlockWinterstoneSlab {

    @Override
    public boolean isDouble() {
      return true;
    }

    @Override
    public String getUnlocalizedName(int meta) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  public static class Half extends BlockWinterstoneSlab {

    @Override
    public boolean isDouble() {
      return false;
    }

    @Override
    public String getUnlocalizedName(int meta) {
      // TODO Auto-generated method stub
      return null;
    }
  }
}
