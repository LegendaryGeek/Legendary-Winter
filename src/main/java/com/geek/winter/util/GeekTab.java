package com.geek.winter.util;

import com.geek.winter.init.ItemsRegistery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GeekTab extends CreativeTabs {


	private static final String label = "Legendary Winter";

	public GeekTab() {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemsRegistery.IngotSnowy);
	}
	
	public CreativeTabs getCTab() {
		return this;
	}

}
