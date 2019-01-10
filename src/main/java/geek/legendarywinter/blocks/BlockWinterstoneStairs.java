package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * @author Cadiboo
 */
public class BlockWinterstoneStairs extends BlockStairs {

	public BlockWinterstoneStairs(final Block winterstone) {
		super(winterstone.getDefaultState());
		this.setCreativeTab(GeekTab.instance);
	}

}
