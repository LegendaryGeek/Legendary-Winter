package geek.legendarywinter;

import org.apache.logging.log4j.Logger;

import geek.legendarywinter.proxy.Proxy;
import geek.legendarywinter.util.GeekTab;
import geek.legendarywinter.world.OreGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LegendaryWinter.MODID,
name = LegendaryWinter.NAME,
acceptedMinecraftVersions = "[1.12.2]",
dependencies = "required-after:forge@[14.23.4.2739,)",
version = LegendaryWinter.VERSION)
public class LegendaryWinter
{
    public static final String MODID = "legendarywinter";
    public static final String NAME = "Legendary Winter";
    public static final String VERSION = "1.0";
    public static final Item.ToolMaterial POLARIUM = EnumHelper.addToolMaterial("polarium", 3, 1561, 9.5f, 5.1f, 30);
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    	GeekTab.init();
        logger = event.getModLog();
        GameRegistry.registerWorldGenerator(new OreGenerator(), 3);
        
        
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
		private static final LegendaryWinter INSTANCE = new LegendaryWinter();
	}
    
    /**
	 *
	 * @return The Mod's Instance.
	 */
	@Mod.InstanceFactory
	public static LegendaryWinter instance() {
		return InstanceHolder.INSTANCE;
	}
	
	/**
	 *
	 */
	@SidedProxy(
				clientSide = "geek.legendarywinter.proxy.ClientProxy",
				serverSide = "geek.legendarywinter.proxy.ServerProxy")
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
