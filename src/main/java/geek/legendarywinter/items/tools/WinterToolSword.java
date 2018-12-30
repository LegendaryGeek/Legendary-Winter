package geek.legendarywinter.items.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {

	public WinterToolSword() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("pickaxe", 3);
		this.setDamage(new ItemStack(this), 8);
		// TODO Auto-generated constructor stub
	}

	
	
}
