package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * @author Cadiboo
 */
public class BlockPolariumBlock extends Block {

	public BlockPolariumBlock() {
		super(Material.IRON);
		setHardness(5.0F);//iron block hardness
		this.setCreativeTab(GeekTab.instance);
	}

	@Override
	public boolean isBeaconBase(final IBlockAccess worldObj, final BlockPos pos, final BlockPos beacon) {
		return true;
	}

}
