package geek.legendarywinter.blocks;

import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SnowStoneBlock extends Block {

	public SnowStoneBlock() {
		super(Material.ROCK);
		//this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		// TODO Auto-generated constructor stub
	}

}
