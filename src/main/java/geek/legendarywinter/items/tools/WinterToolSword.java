package geek.legendarywinter.items.tools;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {

	public WinterToolSword() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("sword", 3);
		this.setDamage(new ItemStack(this), 8);
		this.setCreativeTab(GeekTab.instance);
	}

	
	
}
