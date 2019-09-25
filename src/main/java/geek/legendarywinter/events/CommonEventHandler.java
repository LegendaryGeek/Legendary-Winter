package geek.legendarywinter.events;

import static geek.legendarywinter.LegendaryWinter.MODID;
import static geek.legendarywinter.init.BlocksRegistry.WINTERSTONE_SLAB_DOUBLE;
import static geek.legendarywinter.init.BlocksRegistry.WINTERSTONE_SLAB_HALF;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.blocks.BlockWinterstoneSlab;
import geek.legendarywinter.blocks.BlockWinterstoneStairs;
import geek.legendarywinter.blocks.BlockWinterstoneWall;
import geek.legendarywinter.blocks.Polarium_Ore;
import geek.legendarywinter.blocks.Strange_Snow;
import geek.legendarywinter.blocks.Winter_Furnace;
import geek.legendarywinter.blocks.Winterstone;
import geek.legendarywinter.enchantments.EnchantmentWinterWalker;
import geek.legendarywinter.init.BlocksRegistry;
import geek.legendarywinter.items.PolariumNugget;
import geek.legendarywinter.items.Polarium_Ingot;
import geek.legendarywinter.items.Strange_Snowball;
import geek.legendarywinter.items.WinterJam;
import geek.legendarywinter.items.armor.ItemPolariumHorseArmor;
import geek.legendarywinter.items.armor.PolariumBooties;
import geek.legendarywinter.items.armor.PolariumChestplate;
import geek.legendarywinter.items.armor.PolariumHelmet;
import geek.legendarywinter.items.armor.PolariumLeggings;
import geek.legendarywinter.items.tools.WinterToolAxe;
import geek.legendarywinter.items.tools.WinterToolHoe;
import geek.legendarywinter.items.tools.WinterToolPickaxe;
import geek.legendarywinter.items.tools.WinterToolShovel;
import geek.legendarywinter.items.tools.WinterToolSword;
import geek.legendarywinter.tileentity.TEWinter_Furnace;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(value = { Side.CLIENT, Side.SERVER }, modid = MODID)
public final class CommonEventHandler {

	private CommonEventHandler() {

	}

	/**
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(setupBlock(new Polarium_Ore(), "polarium_ore"));
		registry.register(setupBlock(new Strange_Snow(), "strange_snow"));
		registry.register(setupBlock(new Winterstone(), "winterstone"));
		registry.register(setupBlock(new Winter_Furnace(false), "winterfurnace"));
		registry.register(setupBlock(new Winter_Furnace(true), "lit_winterfurnace"));
		GameRegistry.registerTileEntity(TEWinter_Furnace.class, new ResourceLocation(MODID, "winterfurnace"));

		// Fix enchantment placing null blocks
		// registry.register(setupBlock(new Snowstone_Block(), "snowstone_block"));

		registry.register(setupBlock(new BlockWinterstoneSlab.Half(), "winterstone_slab"));
		registry.register(setupBlock(new BlockWinterstoneSlab.Double(), "winterstone_double_slab"));

		// registry.register(setupBlock(new BlockPolariumBlock(), "polarium_block"));

		// event.getRegistry().register(setupBlock(new
		// BlockFluidClassic(FluidsRegistry.FluidSnow, Material.WATER), "fluidsnow"));
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public static void registerBlocksAfter(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();
		// TODO: watchout for changes to winterstone's registry name!
		final Block winterstone = registry.getValue(new ResourceLocation(MODID, "winterstone"));
		assert winterstone != null;
		// register these later so if mods override Snow Stone we get the overridden
		// version
		registry.register(setupBlock(new BlockWinterstoneStairs(winterstone), "winterstone_stairs"));
		registry.register(setupBlock(new BlockWinterstoneWall(winterstone.getDefaultState()), "winterstone_wall"));

	}

	@SubscribeEvent
	public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().register(setupEnchant(new EnchantmentWinterWalker(Enchantment.Rarity.RARE,
				new EntityEquipmentSlot[] { EntityEquipmentSlot.FEET }), "winter_walker"));
	}

	/**
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(setupItemBlock(BlocksRegistry.Polarium_Ore));
		registry.register(setupItemBlock(BlocksRegistry.WinterStone));
		// registry.register(setupItemBlock(BlocksRegistry.SnowStone));//TODO: should
		// this have an item?
		registry.register(setupItemBlock(BlocksRegistry.StrangeSnow));
		registry.register(setupItemBlock(BlocksRegistry.SnowFurnace));
		registry.register(setupItemBlock(BlocksRegistry.WinterstoneStairs));
		registry.register(setupItemBlock(BlocksRegistry.WinterstoneWall));
		// registry.register(setupItemBlock(BlocksRegistry.POLARIUM_BLOCK));
		// event.getRegistry().register(setupItemBlock(BlocksRegistry.FluidSnow));

		registry.register(setupItem(new Strange_Snowball(), "strange_snowball"));
		registry.register(setupItem(new Polarium_Ingot(), "polarium_ingot"));
		registry.register(setupItem(new PolariumNugget(), "polarium_nugget"));
		registry.register(setupItem(new WinterToolSword(), "polarium_sword"));
		registry.register(setupItem(new WinterToolShovel(), "polarium_shovel"));
		registry.register(setupItem(new WinterToolPickaxe(), "polarium_pickaxe"));
		registry.register(setupItem(new WinterToolAxe(), "polarium_axe"));
		registry.register(setupItem(new WinterToolHoe(), "polarium_hoe"));
		registry.register(setupItem(new WinterJam(), "winterjam"));
		registry.register(setupItem(new PolariumHelmet(), "polarium_helmet"));
		registry.register(setupItem(new PolariumChestplate(), "polarium_chestplate"));
		registry.register(setupItem(new PolariumLeggings(), "polarium_leggings"));
		registry.register(setupItem(new PolariumBooties(), "polarium_booties"));
		registry.register(setupItem(new ItemPolariumHorseArmor(), "polarium_horse_armor"));

		{
			final ItemSlab itemSlab = new ItemSlab(WINTERSTONE_SLAB_HALF, WINTERSTONE_SLAB_HALF,
					WINTERSTONE_SLAB_DOUBLE);
			final ResourceLocation name = WINTERSTONE_SLAB_HALF.getRegistryName();
			itemSlab.setRegistryName(name);
			LegendaryWinter.LOGGER.debug("!#!#!#! block registered as " + itemSlab.getRegistryName());
			registry.register(itemSlab);
		}
	}

	/**
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		//
	}

	/**
	 * @param block The Block.
	 * @param name  The Name.
	 * @return The Block
	 */
	private static Block setupBlock(final Block block, final String name) {
		block.setRegistryName(name);
		block.setTranslationKey(MODID + "." + name);
		return block;
	}

	/**
	 * @param block The Block.
	 * @return The ItemBlock.
	 */
	private static ItemBlock setupItemBlock(final Block block) {
		final ItemBlock itemBlock = new ItemBlock(block);
		final ResourceLocation name = block.getRegistryName();
		itemBlock.setRegistryName(name);
		LegendaryWinter.LOGGER.debug("!#!#!#! block registered as " + block.getRegistryName());

		return itemBlock;
	}

	/**
	 * @param item The Item.
	 * @param name The Name.
	 * @return The Item.
	 */
	private static Item setupItem(final Item item, final String name) {
		item.setRegistryName(name);
		item.setTranslationKey(MODID + "." + name);
		LegendaryWinter.LOGGER.debug("!#!#!#! item registered as " + item.getRegistryName());

		return item;
	}

	/**
	 * @param ench The Enchantment.
	 * @param name The Name.
	 * @return The Item.
	 */
	private static Enchantment setupEnchant(final Enchantment ench, final String name) {
		ench.setRegistryName(name);
		LegendaryWinter.LOGGER.debug("!#!#!#! Enchantment registered as " + ench.getRegistryName());

		return ench;
	}

}
