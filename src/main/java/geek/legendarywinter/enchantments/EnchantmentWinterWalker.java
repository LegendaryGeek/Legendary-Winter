package geek.legendarywinter.enchantments;

import geek.legendarywinter.init.BlocksRegistry;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentFrostWalker;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;

import static net.minecraft.util.math.BlockPos.*;

public class EnchantmentWinterWalker extends Enchantment {
	
    public EnchantmentWinterWalker(Enchantment.Rarity rarityIn, EntityEquipmentSlot... slots)
    {
        super(rarityIn, EnumEnchantmentType.ARMOR_FEET, slots);
        this.setName("WinterWalker");
        
    }


    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return enchantmentLevel * 20;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return this.getMinEnchantability(enchantmentLevel) + 60;
    }
    @Override
    public boolean isTreasureEnchantment()
    {
        return true;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    @Override
    public int getMaxLevel()
    {
        return 1;
    }
  
    public static void freezeNearby(EntityPlayer living, World worldIn, BlockPos pos)
    {
        final PooledMutableBlockPos pooledMutableBlockPos = PooledMutableBlockPos.retain();
        try {
            if (living != null) {
                float f = (float) Math.min(16, 5);
                for (MutableBlockPos blockPos : getAllInBoxMutable(pos.add((double) (-f), -1.0D, (double) (-f)), pos.add((double) f, -1.0D, (double) f))) {
                    if (blockPos.distanceSqToCenter(living.posX, living.posY, living.posZ) <= (double) (f * f)) {
	                    pooledMutableBlockPos.setPos(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
                        IBlockState iblockstate = worldIn.getBlockState(pooledMutableBlockPos);

                        if (iblockstate.getMaterial() == Material.AIR) {
	                            IBlockState iblockstate1 = worldIn.getBlockState(blockPos);

                            if (iblockstate1.getMaterial() == Material.WATER && (iblockstate1.getBlock() == Blocks.WATER || iblockstate1.getBlock() == Blocks.FLOWING_WATER) && ((Integer) iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0 && worldIn.mayPlace(Blocks.ICE, blockPos, false, EnumFacing.DOWN, (Entity) null)) {
                                worldIn.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                                worldIn.scheduleUpdate(blockPos.toImmutable(), Blocks.ICE, MathHelper.getInt(living.getRNG(), 60, 120));
                            } else if (iblockstate1.getMaterial() == Material.LAVA && (iblockstate1.getBlock() == Blocks.LAVA || iblockstate1.getBlock() == Blocks.FLOWING_LAVA) && ((Integer) iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0 && worldIn.mayPlace(Blocks.MAGMA, blockPos, false, EnumFacing.DOWN, (Entity) null)) {
                                worldIn.setBlockState(blockPos, Blocks.MAGMA.getDefaultState());
                                worldIn.scheduleUpdate(blockPos.toImmutable(), Blocks.MAGMA, MathHelper.getInt(living.getRNG(), 60, 120));
                            }
                        } else if (iblockstate.getMaterial() != Material.AIR) {
                        	  IBlockState iblockstate1 = worldIn.getBlockState(blockPos);
                        	if (iblockstate1.getBlock() == Blocks.SNOW) {
                        		worldIn.setBlockState(pooledMutableBlockPos, Blocks.PACKED_ICE.getDefaultState());
                        		worldIn.scheduleUpdate(blockPos.toImmutable(), Blocks.PACKED_ICE, MathHelper.getInt(living.getRNG(), 60, 120));
                        	} else if (iblockstate1.getBlock() == Blocks.STONE) {
                        		worldIn.setBlockState(pooledMutableBlockPos, BlocksRegistry.WinterStone.getDefaultState());
                        		worldIn.scheduleUpdate(blockPos.toImmutable(), BlocksRegistry.WinterStone, MathHelper.getInt(living.getRNG(), 60, 120));
                        }
                        }
                    }
                }
            }
        }finally {
	        pooledMutableBlockPos.release();
        }
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    @Override
    public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && ench != Enchantments.DEPTH_STRIDER && ench != Enchantments.FROST_WALKER;
    }
}
