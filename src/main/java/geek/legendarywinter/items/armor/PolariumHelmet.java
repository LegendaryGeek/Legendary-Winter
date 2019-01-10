package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PolariumHelmet extends ItemArmor {

	public PolariumHelmet() {
		super(LegendaryWinter.POLARIUM_ARMOR_MATERIAL, 3, EntityEquipmentSlot.HEAD);
		this.setCreativeTab(GeekTab.instance);
	}

}
