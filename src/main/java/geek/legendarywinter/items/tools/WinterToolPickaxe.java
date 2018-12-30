package geek.legendarywinter.items.tools;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class WinterToolPickaxe extends ItemPickaxe {

	public WinterToolPickaxe() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("pickaxe", 3);
		this.setDamage(new ItemStack(this), 8);
		this.setCreativeTab(new GeekTab());
	}

}
