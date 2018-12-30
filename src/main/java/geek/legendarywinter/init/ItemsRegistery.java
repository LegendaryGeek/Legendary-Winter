package geek.legendarywinter.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import geek.legendarywinter.items.*;
import geek.legendarywinter.items.tools.*;

public class ItemsRegistery {
	
	/**
	 *
	 */
	@ObjectHolder("legendarywinter:strange_snowball")
	public static final Item strangesnowball = new Strange_Snowball();
	
	@ObjectHolder("legendarywinter:polarium_ingot")
	public static final Item polarium_ingot = new Polarium_Ingot();
	
	@ObjectHolder("legendarywinter:polarium_sword")
	public static final Item polarium_sword = new WinterToolSword();
	
	@ObjectHolder("legendarywinter:polarium_shovel")
	public static final Item polarium_shovel = new WinterToolShovel();
	
	@ObjectHolder("legendarywinter:polarium_pickaxe")
	public static final Item polarium_pickaxe = new WinterToolPickaxe();
	
	@ObjectHolder("legendarywinter:polarium_axe")
	public static final Item polarium_axe = new WinterToolAxe();
	
}
