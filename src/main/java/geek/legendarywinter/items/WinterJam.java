package geek.legendarywinter.items;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemFood;

public class WinterJam extends ItemFood{

	public WinterJam() {
		super(6, 6, false);
		this.maxStackSize = 16;
		this.setCreativeTab(GeekTab.instance);
	}

}
