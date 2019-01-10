package geek.legendarywinter.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public final class ClientProxy implements IProxy {

	@Override
	public World getWorld() {
		return Minecraft.getMinecraft().world;
	}

}
