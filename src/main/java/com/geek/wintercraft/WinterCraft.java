package com.geek.wintercraft;

import org.apache.logging.log4j.Logger;

import com.geek.wintercraft.proxy.Proxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WinterCraft.MODID, 
name = WinterCraft.NAME, 
acceptedMinecraftVersions = "[1.12.2]",
dependencies = "required-after:forge@[14.23.4.2739,)",
version = WinterCraft.VERSION)
public class WinterCraft
{
    public static final String MODID = "wintercraft";
    public static final String NAME = "Winter Craft";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
        logger = event.getModLog();
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    private static final class InstanceHolder {

		/**
		 * The Instance.
		 */
		private static final WinterCraft INSTANCE = new WinterCraft();
	}
    
    /**
	 *
	 * @return The Mod's Instance.
	 */
	@Mod.InstanceFactory
	public static WinterCraft instance() {
		return InstanceHolder.INSTANCE;
	}
	
	/**
	 *
	 */
	@SidedProxy(
				clientSide = "com.geek.wintercraft.proxy.ClientProxy",
				serverSide = "com.geek.wintercraft.proxy.ServerProxy")
	private static Proxy proxy = null;
	
	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}
}
