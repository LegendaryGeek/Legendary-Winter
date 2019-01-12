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
import net.minecraft.block.BlockSlab;
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

	@ObjectHolder("legendarywinter:winterstone_slab")
	public static final BlockSlab WINTERSTONE_SLAB_HALF = new BlockWinterstoneSlab.Half();
	
	@ObjectHolder("legendarywinter:winterstone_double_slab")
	public static final BlockSlab WINTERSTONE_SLAB_DOUBLE = new BlockWinterstoneSlab.Double();

	@ObjectHolder("legendarywinter:winterstone_stairs")
	public static final Block WinterstoneStairs = new BlockWinterstoneStairs(BlocksRegistry.WinterStone);

	@ObjectHolder("legendarywinter:winterstone_wall")
	public static final Block WinterstoneWall = new BlockWinterstoneWall(BlocksRegistry.WinterStone.getDefaultState());

	public static final Block POLARIUM_BLOCK = null;

}
