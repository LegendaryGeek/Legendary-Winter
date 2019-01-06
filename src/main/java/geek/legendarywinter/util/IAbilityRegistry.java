package geek.legendarywinter.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface IAbilityRegistry extends IForgeRegistryEntry<IAbilityRegistry>{
	
	public List<Block> getInputBlock();
	
	public Block getOutputBlock();
	
}
