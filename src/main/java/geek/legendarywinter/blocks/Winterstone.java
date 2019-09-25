package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Winterstone extends Block {

	public Winterstone() {
		super(Material.ROCK);
//		setHardness(1.5F);//stone hardness
		this.setHardness(0.2F);// snow hardness
		this.setLightLevel(1);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(GeekTab.instance);
		// TODO Auto-generated constructor stub
	}

}
