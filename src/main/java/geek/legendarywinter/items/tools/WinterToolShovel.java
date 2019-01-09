package geek.legendarywinter.items.tools;

import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class WinterToolShovel extends ItemSpade {

	public WinterToolShovel() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("shovel", 3);
		this.setCreativeTab(GeekTab.instance);
		this.toolMaterial.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	}

}
