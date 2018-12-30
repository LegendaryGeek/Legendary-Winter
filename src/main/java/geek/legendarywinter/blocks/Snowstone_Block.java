package geek.legendarywinter.blocks;

import com.google.gson.GsonBuilder;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Snowstone_Block extends Block {

	public Snowstone_Block() {
		super(Material.ROCK);
		//this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(GeekTab.instance);
		this.setHarvestLevel("pickaxe" , 0);
		// TODO Auto-generated constructor stub
	}

}
