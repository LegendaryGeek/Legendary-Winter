package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSpade;

public class WinterToolShovel extends ItemSpade {

	public WinterToolShovel() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL);
		this.setHarvestLevel("shovel", 3);
		this.setCreativeTab(GeekTab.instance);

	}

}
