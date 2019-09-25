package geek.legendarywinter.init;

import static geek.legendarywinter.LegendaryWinter.MODID;

import geek.legendarywinter.items.Polarium_Ingot;
import geek.legendarywinter.items.Strange_Snowball;
import geek.legendarywinter.items.WinterJam;
import geek.legendarywinter.items.armor.PolariumBooties;
import geek.legendarywinter.items.armor.PolariumChestplate;
import geek.legendarywinter.items.armor.PolariumHelmet;
import geek.legendarywinter.items.armor.PolariumLeggings;
import geek.legendarywinter.items.tools.WinterToolAxe;
import geek.legendarywinter.items.tools.WinterToolPickaxe;
import geek.legendarywinter.items.tools.WinterToolShovel;
import geek.legendarywinter.items.tools.WinterToolSword;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(MODID)
public class ItemsRegistery {

	/**
	 *
	 */
	@ObjectHolder("legendarywinter:strange_snowball")
	public static final Item strangesnowball = new Strange_Snowball();

	@ObjectHolder("legendarywinter:winterjam")
	public static final Item winterjam = new WinterJam();

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

	@ObjectHolder("legendarywinter:polarium_helmet")
	public static final Item polarium_helmet = new PolariumHelmet();

	@ObjectHolder("legendarywinter:polarium_chestplate")
	public static final Item polarium_chestplate = new PolariumChestplate();

	@ObjectHolder("legendarywinter:polarium_leggings")
	public static final Item polarium_leggings = new PolariumLeggings();

	@ObjectHolder("legendarywinter:polarium_booties")
	public static final Item polarium_booties = new PolariumBooties();

	public static final Item POLARIUM_HOE = null;

	public static final Item POLARIUM_NUGGET = null;

	public static final Item POLARIUM_HORSE_ARMOR = null;

}
