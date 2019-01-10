package geek.legendarywinter.items.armor;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.util.GeekTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * @author Cadiboo
 */
public class ItemPolariumHorseArmor extends Item {

	public ItemPolariumHorseArmor() {
		this.setMaxStackSize(1);
		this.setCreativeTab(GeekTab.instance);
	}

	@Override
	@Nonnull
	public HorseArmorType getHorseArmorType(final ItemStack stack) {
		return LegendaryWinter.POLARIUM_HORSE_ARMOR;
	}

	@Override
	public void onHorseArmorTick(final World world, final EntityLiving horse, final ItemStack armor) {
		//TODO: maybe a freezing enchantment for the horse?
		super.onHorseArmorTick(world, horse, armor);
	}

}
