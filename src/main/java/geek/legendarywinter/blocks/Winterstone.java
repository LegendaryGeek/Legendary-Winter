package geek.legendarywinter.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Winterstone extends Block {

	public Winterstone() {
		super(Material.ROCK);
		this.setLightLevel(1);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		// TODO Auto-generated constructor stub
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getByNameOrId("legendarywinter:winterstone");
	    }
}
