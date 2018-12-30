package geek.legendarywinter.items.tools;

import net.minecraft.item.ItemSpade;

public class WinterToolShovel extends ItemSpade {

	public WinterToolShovel() {
		super(ToolMaterial.DIAMOND);
		this.setHarvestLevel("shovel", 3);
		
	}

}
