package geek.legendarywinter.init;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.blocks.*;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@GameRegistry.ObjectHolder(LegendaryWinter.MODID)
public class BlocksRegistry {

	private BlocksRegistry() {
		//
	}
	@ObjectHolder("legendarywinter:fakesnow")
	public static final Block FakeSnow = new FakeSnow();
	
	@ObjectHolder("legendarywinter:snowstone_ore")
	public static final Block OreSnow = new OreSnowstone();
	
	@ObjectHolder("legendarywinter:winterstone")
	public static final Block WinterStone = new Winterstone();
	
	@ObjectHolder("legendarywinter:snowfurnace")
	public static final Block SnowFurnace = new SnowFurnace(false);
	
	@ObjectHolder("legendarywinter:lit_snowfurnace")
	public static final Block Lit_SnowFurnace = new SnowFurnace(true);
	
	@ObjectHolder("legendarywinter:fluidsnow")
	public static final Block FluidSnow = null;
	
}
