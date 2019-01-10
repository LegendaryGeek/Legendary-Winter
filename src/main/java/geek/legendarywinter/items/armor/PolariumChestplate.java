package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PolariumChestplate extends ItemArmor {

	public PolariumChestplate() {
		super(LegendaryWinter.POLARIUM_ARMOR_MATERIAL, 3, EntityEquipmentSlot.CHEST);
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
