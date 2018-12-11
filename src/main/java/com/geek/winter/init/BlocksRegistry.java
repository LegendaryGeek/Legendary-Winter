package com.geek.winter.init;

import com.geek.winter.WinterCraft;
import com.geek.winter.blocks.FakeSnow;
import com.geek.winter.blocks.OreSnow;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@GameRegistry.ObjectHolder(WinterCraft.MODID)
public class BlocksRegistry {

	private BlocksRegistry() {
		//
	}
	@ObjectHolder("wintercraft:fakesnow")
	public static final Block FakeSnow = new FakeSnow();
	
	@ObjectHolder("wintercraft:oresnow")
	public static final Block OreSnow = new OreSnow();
	
	@ObjectHolder("wintercraft:fluidsnow")
	public static final Block FluidSnow = null;
	
}
