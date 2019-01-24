package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.enchantments.EnchantmentWinterWalker;
import geek.legendarywinter.init.ItemsRegistery;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolariumBooties extends ItemArmor {

	public PolariumBooties() {
		super(LegendaryWinter.POLARIUM_ARMOR_MATERIAL, 3, EntityEquipmentSlot.FEET);
		this.setCreativeTab(GeekTab.instance);
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		//TODO FIXME: This is meant to be an enchantment right?
		if(!player.isSpectator()) {
			EnchantmentWinterWalker.freezeNearby(player, world, player.getPosition());
		}
	}

}
