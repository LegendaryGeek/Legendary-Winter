package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolariumChestplate extends ItemArmor {

	public PolariumChestplate() {
		super(LegendaryWinter.POLARIUM_ARMOR_MATERIAL, 3, EntityEquipmentSlot.CHEST);
		this.setCreativeTab(GeekTab.instance);
	}
	@Override
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if(player.isBurning() == true) {
			player.extinguish();
		}
	}
}
