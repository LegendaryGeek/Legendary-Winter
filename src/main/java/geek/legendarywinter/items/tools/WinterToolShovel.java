package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class WinterToolShovel extends ItemSpade {
	
	public WinterToolShovel() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL);
		this.setHarvestLevel("shovel", 3);
		this.setCreativeTab(GeekTab.instance);
		
	}
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        toRepair = new ItemStack(ItemsRegistery.polarium_shovel);
        repair = new ItemStack(ItemsRegistery.polarium_ingot);
        return true;
    }
}
