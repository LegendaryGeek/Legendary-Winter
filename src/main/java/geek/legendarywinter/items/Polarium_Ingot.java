package geek.legendarywinter.items;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Polarium_Ingot extends Item {

	public Polarium_Ingot() {
		super();
		this.setCreativeTab(GeekTab.instance);
	}

	@Override
	public boolean isBeaconPayment(final ItemStack stack) {
		return true;
	}

}
