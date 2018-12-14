package com.geek.winter.init;

import com.geek.winter.Winter;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class FluidsRegistry {
	/**
	 *
	 */
	public static final Fluid FluidSnow = new Fluid("FluidSnow",
			new ResourceLocation(Winter.MODID, "blocks/FluidSnow_still"),
			new ResourceLocation(Winter.MODID, "blocks/FluidSnow_flow"));

	/**
	 *
	 */

	public static void init() {
		FluidSnow.setDensity(1);
		FluidSnow.setViscosity(1);
		FluidSnow.setTemperature(0);
		FluidSnow.setLuminosity(200);
		FluidSnow.setUnlocalizedName(Winter.MODID + "." + "FluidSnow");
		FluidRegistry.registerFluid(FluidSnow);
		FluidRegistry.addBucketForFluid(FluidSnow);
	}
}
