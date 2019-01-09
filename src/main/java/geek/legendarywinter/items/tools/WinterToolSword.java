package geek.legendarywinter.items.tools;

import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {
ToolMaterial toolMaterial = ToolMaterial.DIAMOND;
	public WinterToolSword() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("sword", 3);
		this.setDamage(new ItemStack(this), 8);
		this.setCreativeTab(GeekTab.instance);
		this.toolMaterial.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	}

	
	
}
