package geek.legendarywinter.blocks;

import java.util.Random;

import geek.legendarywinter.init.ItemsRegistery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FakeSnow extends Block {

	public FakeSnow() {
		super(Material.ROCK);
		//this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ItemsRegistery.FakeSnowBallItem;
	    }
}
