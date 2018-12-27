package geek.legendarywinter.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import geek.legendarywinter.items.*;

public class ItemsRegistery {
	
	/**
	 *
	 */
	@ObjectHolder("legendarywinter:strangesnowball")
	public static final Item strangesnowball = new Strange_Snowball();
	
	@ObjectHolder("legendarywinter:polarium_ingot")
	public static final Item polarium_ingot = new Polarium_Ingot();

}
