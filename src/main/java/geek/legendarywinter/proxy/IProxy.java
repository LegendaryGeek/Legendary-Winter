package geek.legendarywinter.proxy;

import geek.legendarywinter.init.FluidsRegistry;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {

	/**
	 * @param event The Event.
	 */
	default void preInit(final FMLPreInitializationEvent event) {
		FluidsRegistry.init();
	}

	/**
	 * @param event The Event.
	 */
	default void init(final FMLInitializationEvent event) {
		//
	}

	/**
	 * @param event The Event.
	 */
	default void receiveIMC(final IMCEvent event) {
		//
	}

	/**
	 * @param event The Event.
	 */
	default void postInit(final FMLPostInitializationEvent event) {
		//
	}

	World getWorld();

}
