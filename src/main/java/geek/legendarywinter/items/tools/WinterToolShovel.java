package geek.legendarywinter.items.tools;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemSpade;

public class WinterToolShovel extends ItemSpade {

	public WinterToolShovel() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("shovel", 3);
		this.setCreativeTab(new GeekTab());
	}

}
