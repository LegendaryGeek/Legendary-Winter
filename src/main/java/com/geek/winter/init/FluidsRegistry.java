package com.geek.winter.init;

import com.geek.winter.Winter;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


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
		FluidSnow.setTemperature(1);
		FluidSnow.setLuminosity(1);
		FluidSnow.setUnlocalizedName(Winter.MODID + "." + "FluidSnow");
		FluidRegistry.registerFluid(FluidSnow);
		FluidRegistry.addBucketForFluid(FluidSnow);
	}
}
