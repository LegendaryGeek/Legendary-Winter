package geek.legendarywinter.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Winterstone extends Block {

	public Winterstone() {
		super(Material.ROCK);
		this.setLightLevel(1);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		// TODO Auto-generated constructor stub
	}

}
