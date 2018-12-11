package com.geek.wintercraft.proxy;

import com.geek.wintercraft.init.FluidsRegistry;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class Proxy {
	/**
	 *
	 * @param event The Event.
	 */
	public void preInit(final FMLPreInitializationEvent event) {
		FluidsRegistry.init();
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void init(final FMLInitializationEvent event) {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void receiveIMC(final IMCEvent event) {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void postInit(final FMLPostInitializationEvent event) {
		//
	}

	public World getWorld() { return null; }
}
