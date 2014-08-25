package pdox.KCraft.KCraftmod.core;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class KCWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case 0: generateSurface(random, chunkX*16, chunkZ*16, world); break;
			case 1: generateEnd(random, chunkX*16, chunkZ*16, world); break;
			case -1: generateNether(random, chunkX*16, chunkZ*16, world); break;
		}
	}

	public void generateSurface(Random random, int cx, int cz, World world){
		addOreSpawnS(KCraft.orePeridot, world, random, cx, cz, 1, 6, 5, 4, 10);
        addOreSpawnS(KCraft.orePyrope, world, random, cx, cz, 1, 6, 5, 4, 10);
        addOreSpawnS(KCraft.oreRhodolite, world, random, cx, cz, 1, 6, 5, 4, 10);
	}

	public void generateEnd(Random random, int cx, int cz, World world){

	}

	public void generateNether(Random random, int cx, int cz, World world){

	}

	public void addOreSpawnS(Block block, World world, Random random, int bxPos, int bzPos, int minVainSize, int maxVainSize, int CTS, int minY, int maxY ){
		for(int i = 0; i<CTS; i++){
			int posX = bxPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = bzPos + random.nextInt(16);
			new WorldGenMinable(block, (minVainSize + random.nextInt(maxVainSize - minVainSize)), Blocks.stone).generate(world, random, posX, posY, posZ);
		}
	}

}
