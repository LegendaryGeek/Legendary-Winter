package com.geek.winter;

import org.apache.logging.log4j.Logger;

import com.geek.winter.proxy.Proxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Winter.MODID, 
name = Winter.NAME, 
acceptedMinecraftVersions = "[1.12.2]",
dependencies = "required-after:forge@[14.23.4.2739,)",
version = Winter.VERSION)
public class Winter
{
    public static final String MODID = "winter";
    public static final String NAME = "Legendary Winter";
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
		private static final Winter INSTANCE = new Winter();
	}
    
    /**
	 *
	 * @return The Mod's Instance.
	 */
	@Mod.InstanceFactory
	public static Winter instance() {
		return InstanceHolder.INSTANCE;
	}
	
	/**
	 *
	 */
	@SidedProxy(
				clientSide = "com.geek.winter.proxy.ClientProxy",
				serverSide = "com.geek.winter.proxy.ServerProxy")
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
