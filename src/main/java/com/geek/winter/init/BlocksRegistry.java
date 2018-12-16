package com.geek.winter.init;

import com.geek.winter.Winter;
import com.geek.winter.blocks.FakeSnow;
import com.geek.winter.blocks.OreSnow;
import com.geek.winter.blocks.SnowFurnace;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@GameRegistry.ObjectHolder(Winter.MODID)
public class BlocksRegistry {

	private BlocksRegistry() {
		//
	}
	@ObjectHolder("winter:fakesnow")
	public static final Block FakeSnow = new FakeSnow();
	
	@ObjectHolder("winter:oresnow")
	public static final Block OreSnow = new OreSnow();
	
	@ObjectHolder("winter:snowfurnace")
	public static final Block SnowFurnace = new SnowFurnace(false);
	
	@ObjectHolder("winter:lit_snowfurnace")
	public static final Block Lit_SnowFurnace = new SnowFurnace(true);
	
	@ObjectHolder("winter:fluidsnow")
	public static final Block FluidSnow = null;
	
}
