package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PolariumHelmet extends ItemArmor {

	public PolariumHelmet() {
		super(LegendaryWinter.POLARIUM_ARMOR_MATERIAL, 3, EntityEquipmentSlot.HEAD);
		this.setCreativeTab(GeekTab.instance);
		
	}
	@Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn){
		stack.addEnchantment(Enchantments.RESPIRATION, 1);
    }
    
	@Override
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	}

}
