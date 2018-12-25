package com.geek.winter.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class WinterStone extends Block {

	public WinterStone() {
		super(Material.ROCK);
		this.setLightLevel(1);
		// TODO Auto-generated constructor stub
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getByNameOrId("winter:winterstone");
	    }
}
