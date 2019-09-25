package geek.legendarywinter.items.recipe;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import geek.legendarywinter.init.ItemsRegistery;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Winter_Furnace_Recipes {

	private static final Winter_Furnace_Recipes SMELTING_BASE = new Winter_Furnace_Recipes();
	/** The list of smelting results. */
	private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
	/**
	 * A list which contains how many experience points each recipe output will
	 * give.
	 */
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

	public static Winter_Furnace_Recipes instance() {
		return SMELTING_BASE;
	}

	private Winter_Furnace_Recipes() {
		this.addFreezingRecipeForBlock(Blocks.SNOW, new ItemStack(ItemsRegistery.polarium_ingot, 2), 5.5f);
		this.addFreezingRecipe(new ItemStack(ItemsRegistery.strangesnowball),
				new ItemStack(ItemsRegistery.polarium_ingot), 10000.5f);
		this.addFreezingRecipeForBlock(Blocks.ICE, new ItemStack(Blocks.PACKED_ICE), 5.5f);
	}

	/**
	 * Adds a smelting recipe, where the input item is an instance of Block.
	 */
	public void addFreezingRecipeForBlock(Block input, ItemStack stack, float experience) {
		this.addFreeze(Item.getItemFromBlock(input), stack, experience);
	}

	/**
	 * Adds a smelting recipe using an Item as the input item.
	 */
	public void addFreeze(Item input, ItemStack stack, float experience) {
		this.addFreezingRecipe(new ItemStack(input, 1, 32767), stack, experience);
	}

	/**
	 * Adds a smelting recipe using an ItemStack as the input for the recipe.
	 */
	public void addFreezingRecipe(ItemStack input, ItemStack stack, float experience) {
		if (getFreezingResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored Freezing recipe with conflicting input: {} = {}",
					input, stack);
			return;
		}
		this.smeltingList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
	}

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getFreezingResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}

	/**
	 * Compares two itemstacks to ensure that they are the same. This checks both
	 * the item and the metadata of the item.
	 */
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem()
				&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getSmeltingList() {
		return this.smeltingList;
	}

	public float getSmeltingExperience(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return ((Float) entry.getValue()).floatValue();
			}
		}

		return 0.0F;
	}
}
