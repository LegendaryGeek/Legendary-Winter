package geek.legendarywinter.items.tools;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.item.ItemAxe;

public class WinterToolAxe extends ItemAxe {

	public WinterToolAxe() {
		super(ToolMaterial.DIAMOND, 8.1f, 90);
		this.setHarvestLevel("axe", 3);
		this.setCreativeTab();
	}

}
