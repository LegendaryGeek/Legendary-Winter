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
// <<<<<<< master

// =======
//     @Override
//     public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
//     {
//         toRepair = new ItemStack(ItemsRegistery.polarium_sword);
//         repair = new ItemStack(ItemsRegistery.polarium_ingot);
//         return true;
//     }
// >>>>>>> master
}
