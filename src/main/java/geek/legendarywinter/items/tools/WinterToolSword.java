package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {
	
	public WinterToolSword() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL);
		this.setHarvestLevel("sword", 3);
		this.setCreativeTab(GeekTab.instance);
		
	}

}
