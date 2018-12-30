package geek.legendarywinter.blocks;

import java.util.Random;

import geek.legendarywinter.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Polarium_Ore extends Block{

	public Polarium_Ore() {
		super(Material.ROCK);
		//this.setRegistryName(WinterCraft.MODID + "." + "oresnow");
		this.setCreativeTab(GeekTab.instance);
		String toolClass = "pickaxe";
		this.setHarvestLevel(toolClass , 0);
		
		
		
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getByNameOrId("lw:snowstone_ore");
	    }
	public int quantityDropped(Random rand) {
		return 1;
	}
	
}
