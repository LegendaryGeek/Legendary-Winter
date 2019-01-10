package geek.legendarywinter.blocks;

import com.google.gson.GsonBuilder;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class Snowstone_Block extends Block {

	public Snowstone_Block() {
		super(Material.CRAFTED_SNOW);
//		setHardness(1.5F);//stone hardness
		this.setHardness(0.2F);//snow hardness
		//this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(GeekTab.instance);
		this.setHarvestLevel("pickaxe" , 0);
	}

}
