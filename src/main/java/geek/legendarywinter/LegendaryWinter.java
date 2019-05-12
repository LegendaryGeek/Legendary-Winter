package geek.legendarywinter;

import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.proxy.IProxy;
import geek.legendarywinter.util.GeekTab;
import geek.legendarywinter.world.OreGenerator;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = LegendaryWinter.MODID,
name = LegendaryWinter.NAME,
acceptedMinecraftVersions = "[1.12.2]",
dependencies = "required-after:forge@[14.23.4.2739,)",
version = LegendaryWinter.VERSION)
public class LegendaryWinter
{
    public static final String MODID = "legendarywinter";
    public static final String NAME = "Legendary Winter";
    // replaced by build.gradle
    public static final String VERSION = "1.0";
    @Instance
    public static LegendaryWinter instance = null;
    public static final Item.ToolMaterial POLARIUM_TOOL_MATERIAL;
    public static final ItemArmor.ArmorMaterial POLARIUM_ARMOR_MATERIAL;
	public static final HorseArmorType POLARIUM_HORSE_ARMOR;

    static {
	    POLARIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial(new ResourceLocation(MODID, "polarium").toString(),
			    // DIAMOND(3, 1561, 8.0F, 3.0F, 10),
			    3, 1561, 12F, 5F, 30);
	    POLARIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(new ResourceLocation(MODID, "polarium").toString(),
			    new ResourceLocation(MODID, "polarium").toString(),
			    // DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
			    33, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	    POLARIUM_HORSE_ARMOR = EnumHelper.addHorseArmor(new ResourceLocation(MODID, "polarium").toString(),
			    //DIAMOND(11, "diamond", "dio");
			    new ResourceLocation(MODID, "textures/entities/horse/armor/horse_armor_polarium.png").toString(), 12);
    }

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	GeekTab.init();
        GameRegistry.registerWorldGenerator(new OreGenerator(), 3);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);
    	// in here to make sure polarium_ingot exists (registry events are fired right before init)
	    POLARIUM_TOOL_MATERIAL.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	    POLARIUM_ARMOR_MATERIAL.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	    
	    
    }

	/**
	 *
	 */
	@SidedProxy(
				clientSide = "geek.legendarywinter.proxy.ClientProxy",
				serverSide = "geek.legendarywinter.proxy.ServerProxy")
	public static IProxy proxy = null;

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}
}
