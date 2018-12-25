package geek.legendarywinter.items.tools;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class WinterToolPickaxe extends ItemPickaxe {

	protected WinterToolPickaxe(ToolMaterial material, int level, String toolClass, ItemStack stack, int damage) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		this.setDamage(stack, damage);
	}

}
