package geek.legendarywinter.items.tools;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class WinterToolPickaxe extends ItemPickaxe {

	public WinterToolPickaxe() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("pickaxe", 3);
		this.setDamage(new ItemStack(this), 8);
	}

}
