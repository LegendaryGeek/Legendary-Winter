package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class WinterToolAxe extends ItemAxe {
	
	public WinterToolAxe() {
		super(LegendaryWinter.POLARIUM, 8.1f, 90);
		this.setHarvestLevel("axe", 3);
		this.setCreativeTab(GeekTab.instance);
		
	}

}
