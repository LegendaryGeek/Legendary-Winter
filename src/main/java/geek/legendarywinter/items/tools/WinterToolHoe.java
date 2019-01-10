package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemHoe;

/**
 * @author Cadiboo
 */
public class WinterToolHoe extends ItemHoe {

	public WinterToolHoe() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL);
		this.setHarvestLevel("hoe", 3);
		this.setCreativeTab(GeekTab.instance);
	}

}
