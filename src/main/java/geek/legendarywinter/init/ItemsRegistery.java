package geek.legendarywinter.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import geek.legendarywinter.items.*;

public class ItemsRegistery {
	
	/**
	 *
	 */
	@ObjectHolder("legendarywinter:fakesnowballitem")
	public static final Item FakeSnowBallItem = new FakeSnowball();
	
	@ObjectHolder("legendarywinter:snowstone_ingot")
	public static final Item IngotSnowy = new IngotSnowstone();

}
