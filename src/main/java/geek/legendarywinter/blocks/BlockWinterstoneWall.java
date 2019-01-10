package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.state.IBlockState;

/**
 * @author Cadiboo
 */
public class BlockWinterstoneWall extends BlockModWall {

	public BlockWinterstoneWall(final IBlockState winterstone) {
		super(winterstone.getMaterial());
		//TODO: keep this hardness in sync with Winterstone's hardness
		this.setHardness(0.2F);
		this.setCreativeTab(GeekTab.instance);
	}

}
