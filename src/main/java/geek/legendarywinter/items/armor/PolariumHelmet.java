package geek.legendarywinter.items.armor;

import geek.legendarywinter.init.ItemsRegistery;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PolariumHelmet extends ItemArmor {

	public PolariumHelmet() {
		super(ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.HEAD);
		this.getArmorMaterial().repairMaterial = new ItemStack(ItemsRegistery.polarium_ingot);
	}

}
