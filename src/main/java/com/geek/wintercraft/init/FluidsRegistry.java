package com.geek.wintercraft.init;

import com.geek.wintercraft.WinterCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidsRegistry {
	/**
	 *
	 */
	public static final Fluid FluidSnow = new Fluid("FluidSnow",
			new ResourceLocation(WinterCraft.MODID, "blocks/FluidSnow_still"),
			new ResourceLocation(WinterCraft.MODID, "blocks/FluidSnow_flow"));

	/**
	 *
	 */
	public static void init() {
		FluidSnow.setDensity(1);
		FluidSnow.setViscosity(1);
		FluidSnow.setTemperature(1);
		FluidSnow.setLuminosity(1);
		FluidSnow.setUnlocalizedName(WinterCraft.MODID + "." + "FluidSnow");
		FluidRegistry.registerFluid(FluidSnow);
		FluidRegistry.addBucketForFluid(FluidSnow);
	}
}
