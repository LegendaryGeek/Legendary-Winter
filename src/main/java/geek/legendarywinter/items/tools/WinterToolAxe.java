package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemAxe;

public class WinterToolAxe extends ItemAxe {

	public WinterToolAxe() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL, 10f, 10);
		this.setHarvestLevel("axe", 3);
		this.setCreativeTab(GeekTab.instance);

	}

}
