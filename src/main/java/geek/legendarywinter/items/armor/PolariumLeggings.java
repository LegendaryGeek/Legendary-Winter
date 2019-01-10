package geek.legendarywinter.items.armor;

import geek.legendarywinter.init.ItemsRegistery;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PolariumLeggings extends ItemArmor {

	public PolariumLeggings() {
		super(ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.LEGS);
		this.getArmorMaterial().repairMaterial = new ItemStack(ItemsRegistery.polarium_ingot);
	}

@Override
public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
{
    toRepair = new ItemStack(ItemsRegistery.polarium_shovel);
    repair = new ItemStack(ItemsRegistery.polarium_ingot);
    return true;
}
}
  