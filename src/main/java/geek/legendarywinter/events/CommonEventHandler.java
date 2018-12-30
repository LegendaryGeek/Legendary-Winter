package geek.legendarywinter.events;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.blocks.Polarium_Ore;
import geek.legendarywinter.blocks.Strange_Snow;
import geek.legendarywinter.blocks.Winter_Furnace;
import geek.legendarywinter.blocks.Winterstone;
import geek.legendarywinter.init.BlocksRegistry;
import geek.legendarywinter.items.Polarium_Ingot;
import geek.legendarywinter.items.Strange_Snowball;
import geek.legendarywinter.items.tools.*;
import geek.legendarywinter.tileentity.TEWinter_Furnace;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = {Side.CLIENT, Side.SERVER}, modid = LegendaryWinter.MODID)
public final class CommonEventHandler {

	/**
	 *
	 */
	
	
	
	private CommonEventHandler() {
		
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(setupBlock(new Polarium_Ore(), "polarium_ore"));
		event.getRegistry().register(setupBlock(new Strange_Snow(), "strange_snow"));
		event.getRegistry().register(setupBlock(new Winterstone(), "winterstone"));
		event.getRegistry().register(setupBlock(new Winter_Furnace(false), "winterfurnace"));
		event.getRegistry().register(setupBlock(new Winter_Furnace(true), "lit_winterfurnace"));
		GameRegistry.registerTileEntity(TEWinter_Furnace.class, new ResourceLocation(LegendaryWinter.MODID + ":winterfurnace"));
		//event.getRegistry().register(setupBlock(new BlockFluidClassic(FluidsRegistry.FluidSnow, Material.WATER), "fluidsnow"));
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(setupItemBlock(BlocksRegistry.Polarium_Ore));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.WinterStone));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.StrangeSnow));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.SnowFurnace));
	  //event.getRegistry().register(setupItemBlock(BlocksRegistry.FluidSnow));
		event.getRegistry().register(setupItem(new Strange_Snowball(), "strange_snowball"));
		event.getRegistry().register(setupItem(new Polarium_Ingot(), "polarium_ingot"));
		event.getRegistry().register(setupItem(new WinterToolSword(), "polarium_sword"));
		event.getRegistry().register(setupItem(new WinterToolShovel(), "polarium_shovel"));
		event.getRegistry().register(setupItem(new WinterToolPickaxe(), "polarium_pickaxe"));
		event.getRegistry().register(setupItem(new WinterToolAxe(), "polarium_axe"));
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		//
	}

	/**
	 *
	 * @param block The Block.
	 * @param name The Name.
	 * @return The Block
	 */
	private static Block setupBlock(final Block block, final String name) {
		block.setRegistryName(name);
		block.setTranslationKey(LegendaryWinter.MODID + "." + name);
		return block;
	}

	/**
	 *
	 * @param block The Block.
	 * @return The ItemBlock.
	 */
	private static ItemBlock setupItemBlock(final Block block) {
		final ItemBlock itemBlock = new ItemBlock(block);
		final ResourceLocation name = block.getRegistryName();
		itemBlock.setRegistryName(name);
		LegendaryWinter.logger.fatal("!#!#!#! block registered as " + block.getRegistryName());

		return itemBlock;
	}

	/**
	 *
	 * @param item The Item.
	 * @param name The Name.
	 * @return The Item.
	 */
	private static Item setupItem(final Item item, final String name) {
		item.setRegistryName(name);
		item.setTranslationKey(LegendaryWinter.MODID + "." + name);
		LegendaryWinter.logger.fatal("!#!#!#! item registered as " + item.getRegistryName());

		return item;
	}
	
	
}
