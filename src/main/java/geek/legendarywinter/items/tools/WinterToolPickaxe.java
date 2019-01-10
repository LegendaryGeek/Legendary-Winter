package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class WinterToolPickaxe extends ItemPickaxe {
	
	public WinterToolPickaxe() {
		super(LegendaryWinter.POLARIUM_TOOL_MATERIAL);
		this.setHarvestLevel("pickaxe", 3);
		this.setDamage(new ItemStack(this), 10);
		this.setCreativeTab(GeekTab.instance);
	}
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        toRepair = new ItemStack(ItemsRegistery.polarium_pickaxe);
        repair = new ItemStack(ItemsRegistery.polarium_ingot);
        return true;
    }

}
