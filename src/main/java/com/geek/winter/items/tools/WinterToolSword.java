package com.geek.winter.items.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {

	public WinterToolSword(ToolMaterial material, int damage, ItemStack stack) {
		super(material);
		this.setDamage(stack, damage);
		this.setHarvestLevel(getToolMaterialName(), 0);
		// TODO Auto-generated constructor stub
	}

	
	
}
