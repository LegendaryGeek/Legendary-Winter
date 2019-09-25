package geek.legendarywinter.blocks;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Snowstone_Block extends Block {

	public Snowstone_Block() {
		super(Material.CRAFTED_SNOW);
//		setHardness(1.5F);//stone hardness
		this.setHardness(0.2F);// snow hardness
		// this.setRegistryName(WinterCraft.MODID + "." + "fakesnow");
		this.setCreativeTab(GeekTab.instance);
		this.setHarvestLevel("pickaxe", 0);
	}

}
