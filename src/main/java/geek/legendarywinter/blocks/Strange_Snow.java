package geek.legendarywinter.blocks;

import java.util.Random;

import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class Strange_Snow extends Block {

	public Strange_Snow() {
		super(Material.ROCK);
		this.setHardness(0.2F);// snow hardness
		// this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(GeekTab.instance);
		this.setHarvestLevel("shovel", 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemsRegistery.strangesnowball;
	}
}
