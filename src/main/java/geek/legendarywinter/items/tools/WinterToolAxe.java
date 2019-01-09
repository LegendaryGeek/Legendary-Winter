package geek.legendarywinter.items.tools;

import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class WinterToolAxe extends ItemAxe {

	public WinterToolAxe() {
		super(ToolMaterial.DIAMOND, 8.1f, 90);
		this.setHarvestLevel("axe", 3);
		this.setCreativeTab(GeekTab.instance);
		this.toolMaterial.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	}

}
