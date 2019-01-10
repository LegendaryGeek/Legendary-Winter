package geek.legendarywinter.init;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.blocks.BlockWinterstoneSlab;
import geek.legendarywinter.blocks.BlockWinterstoneStairs;
import geek.legendarywinter.blocks.BlockWinterstoneWall;
import geek.legendarywinter.blocks.Polarium_Ore;
import geek.legendarywinter.blocks.Snowstone_Block;
import geek.legendarywinter.blocks.Strange_Snow;
import geek.legendarywinter.blocks.Winter_Furnace;
import geek.legendarywinter.blocks.Winterstone;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@GameRegistry.ObjectHolder(LegendaryWinter.MODID)
public class BlocksRegistry {

	private BlocksRegistry() {
		//
	}

	@ObjectHolder("legendarywinter:strange_snow")
	public static final Block StrangeSnow = new Strange_Snow();

	@ObjectHolder("legendarywinter:snowstone_block")
	public static final Block SnowStone = new Snowstone_Block();

	@ObjectHolder("legendarywinter:polarium_ore")
	public static final Block Polarium_Ore = new Polarium_Ore();

	@ObjectHolder("legendarywinter:winterstone")
	public static final Block WinterStone = new Winterstone();

	@ObjectHolder("legendarywinter:winterfurnace")
	public static final Block SnowFurnace = new Winter_Furnace(false);

	@ObjectHolder("legendarywinter:lit_winterfurnace")
	public static final Block Lit_SnowFurnace = new Winter_Furnace(true);

	@ObjectHolder("legendarywinter:fluidsnow")
	public static final Block FluidSnow = null;

	public static final BlockWinterstoneSlab.Half WINTERSTONE_SLAB_HALF = null;

	public static final BlockWinterstoneSlab.Double WINTERSTONE_SLAB_DOUBLE = null;

	public static final BlockWinterstoneStairs WINTERSTONE_STAIRS = null;

	public static final BlockWinterstoneWall WINTERSTONE_WALL = null;

	public static final Block POLARIUM_BLOCK = null;

}
