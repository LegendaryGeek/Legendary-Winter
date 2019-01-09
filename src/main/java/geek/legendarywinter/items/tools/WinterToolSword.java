package geek.legendarywinter.items.tools;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class WinterToolSword extends ItemSword {
	static ToolMaterial material = LegendaryWinter.POLARIUM;
	public WinterToolSword() {
		super(material);
		this.setHarvestLevel("sword", 3);
		this.setDamage(new ItemStack(this), 8);
		this.setCreativeTab(GeekTab.instance);
		
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
		toRepair = new ItemStack(ItemsRegistery.polarium_sword);
		repair = new ItemStack(ItemsRegistery.polarium_ingot);
		return true;
    }
	
}
