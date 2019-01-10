package geek.legendarywinter.items.armor;

import geek.legendarywinter.enchantments.EnchantmentWinterWalker;
import geek.legendarywinter.init.ItemsRegistery;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolariumBooties extends ItemArmor {

	public PolariumBooties() {
		super(ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.FEET);
		this.getArmorMaterial().repairMaterial = new ItemStack(ItemsRegistery.polarium_ingot);
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		EnchantmentWinterWalker.freezeNearby(player, world, player.getPosition());
	}
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        toRepair = new ItemStack(ItemsRegistery.polarium_shovel);
        repair = new ItemStack(ItemsRegistery.polarium_ingot);
        return true;
    }
}
