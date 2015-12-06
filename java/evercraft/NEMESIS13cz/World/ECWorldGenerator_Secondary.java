package evercraft.NEMESIS13cz.World;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldBase;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.misc.ECWorldGenMineableEnd;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inDIRT;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inSAND;

public class ECWorldGenerator_Secondary implements IWorldGenerator {
	
	
@Override
public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	switch (world.provider.dimensionId) {
		case 1:
			generateEnd(random,chunkX*16,chunkZ*16,world);
			break;
		case -1:
			generateNether(random,chunkX*16,chunkZ*16,world);
			break;
		case 0:
			generateSurface(random,chunkX*16,chunkZ*16,world);
			break;
		}
	}
//OVERWORLD
	private void generateSurface(Random random, int x, int z, World w) {

		//BASE ORES
		if (Evercraft_Config_WorldBase.GeneratePowerSand == true) {
			this.addSandSpawn(Evercraft_Blocks.blockpowersand, w, random, x, z, 16, 16, 10 + random.nextInt(15), 2, 55, 256);
		}
		if (Evercraft_Config_WorldBase.GenerateMossyStone == true) {
			this.addOreSpawn(Evercraft_Blocks.blockmossystone, w, random, x, z, 16, 16, 4 + random.nextInt(10), 100, 1, 80);
		}
		if (Evercraft_Config_WorldBase.GenerateSandstone == true) {
			this.addSandSpawn(Blocks.sandstone, w, random, x, z, 16, 16, 80 + random.nextInt(40), 1, 50, 80);
		}
		if (Evercraft_Config_WorldBase.GenerateWhiteStone == true) {
			this.addOreSpawn(Evercraft_Blocks.blockwhitestone, w, random, x, z, 16, 16, 10 + random.nextInt(20), 20, 10, 200);
		}
		if (Evercraft_Config_WorldBase.GenerateClaydirt == true) {
			this.addDirtSpawn(Evercraft_Blocks.blockclaydirt, w, random, x, z, 16, 16, 10 + random.nextInt(15), 10, 30, 128);
		}

			
	}
	//NETHER
	private void generateNether(Random random, int x, int z, World w) {
	}
	
	//END
		private void generateEnd(Random random, int x, int z, World w) {
			if (Evercraft_Config_WorldBase.GenerateEndOre == true) {
				for(int i = 0; i < 16; i++)
				{
					int Xcoord = x + random.nextInt(16);
					int Ycoord = 0 + random.nextInt(100);
					int Zcoord = z + random.nextInt(16);
					
					new ECWorldGenMineableEnd(Evercraft_Blocks.blockendore, 1 + random.nextInt(5)).generate(w, random, Xcoord, Ycoord, Zcoord);
				}
			}
		}
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++)
	       {
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	       }
	}
	
	
	public void addSandSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++)
	       {
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable_inSAND(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	       }
	}
	
	public void addDirtSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++)
	       {
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable_inDIRT(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	       }
	}
}



