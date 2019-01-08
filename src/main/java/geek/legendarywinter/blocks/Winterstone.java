package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Winterstone extends Block {

	public Winterstone() {
		super(Material.ROCK);
		this.setHardness(3.0f);
		this.setLightLevel(1);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(GeekTab.instance);
		// TODO Auto-generated constructor stub
	}

}
