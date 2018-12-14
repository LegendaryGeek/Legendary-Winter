package com.geek.winter.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreSnow extends Block{

	public OreSnow() {
		super(Material.SNOW);
		//this.setRegistryName(WinterCraft.MODID + "." + "oresnow");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		String toolClass = "pickaxe";
		this.setHarvestLevel(toolClass , 0);
		
		
		
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getByNameOrId("winter:fakesnowballitem");
	    }
	public int quantityDropped(Random rand) {
		return 2;
	}
	
}
