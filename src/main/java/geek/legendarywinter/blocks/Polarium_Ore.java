package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.Random;

public class Polarium_Ore extends Block {

	public Polarium_Ore() {
		super(Material.ROCK);
		//this.setRegistryName(WinterCraft.MODID + "." + "oresnow");
		this.setCreativeTab(GeekTab.instance);
		setHardness(1.5F);//stone hardness
		this.setHarvestLevel("pickaxe", 0);
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

}
