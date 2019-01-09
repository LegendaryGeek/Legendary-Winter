package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class WinterToolShovel extends ItemSpade {
	static ToolMaterial material = LegendaryWinter.POLARIUM;
	public WinterToolShovel() {
		super(material);
		this.setHarvestLevel("shovel", 3);
		this.setCreativeTab(GeekTab.instance);
		this.toolMaterial.setRepairItem(new ItemStack(ItemsRegistery.polarium_ingot));
	}

}
