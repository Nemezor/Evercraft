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
import evercraft.NEMESIS13cz.misc.ECWorldGenMineableNetherMeta;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_END_inAIR;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_NuggetOre;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inDIRT;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inSAND;

public class ECWorldGenerator_Primary implements IWorldGenerator {
	
	
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
		if (Evercraft_Config_WorldBase.GenerateCopper == true) {
			this.addOreSpawn(Evercraft_Blocks.blockcopperore, w, random, x, z, 16, 16, 10 + random.nextInt(10), 5, 28, 80);
		}
		if (Evercraft_Config_WorldBase.GenerateTin == true) {
			this.addOreSpawn(Evercraft_Blocks.blocktinore, w, random, x, z, 16, 16, 10 + random.nextInt(7), 4, 10, 50);
		}
		if (Evercraft_Config_WorldBase.GenerateSilver == true) {
			this.addOreSpawn(Evercraft_Blocks.blocksilverore, w, random, x, z, 16, 16, 3 + random.nextInt(4), 3, 5, 25);
		}
		if (Evercraft_Config_WorldBase.GenerateBauxite == true) {
			this.addOreSpawn(Evercraft_Blocks.blockbauxiteore, w, random, x, z, 16, 16, 5 + random.nextInt(5), 5, 20, 40);
		}
		if (Evercraft_Config_WorldBase.GenerateMagnetite == true) {
			this.addOreSpawn(Evercraft_Blocks.blockmagneticstone, w, random, x, z, 16, 16, 1 + random.nextInt(2), 1, 1, 256);
		}
		if (Evercraft_Config_WorldBase.GenerateZinc == true) {
			this.addOreSpawn(Evercraft_Blocks.blockzincore, w, random, x, z, 16, 16, 6 + random.nextInt(3), 6, 1, 35);
		}
		if (Evercraft_Config_WorldBase.GenerateSphene == true) {
			this.addOreSpawn(Evercraft_Blocks.blockspheneore, w, random, x, z, 16, 16, 2 + random.nextInt(10), 6, 0, 30);
		}
		if (Evercraft_Config_WorldBase.GenerateLeadOre == true) {
			this.addOreSpawn(Evercraft_Blocks.blockleadore, w, random, x, z, 16, 16, 3 + random.nextInt(3), 10, 20, 35);
		}
		if (Evercraft_Config_WorldBase.GenerateNuggetOres == true) {
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 0, w, random, x, z, 16, 16, 8 + random.nextInt(32), 1, 20, 100, false, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 1, w, random, x, z, 16, 16, 8 + random.nextInt(32), 3, 20, 64, false, false);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 2, w, random, x, z, 16, 16, 8 + random.nextInt(32), 2, 20, 64, false, false);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 3, w, random, x, z, 16, 16, 8 + random.nextInt(32), 2, 20, 64, false, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 4, w, random, x, z, 16, 16, 8 + random.nextInt(32), 2, 20, 64, false, false);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 5, w, random, x, z, 16, 16, 8 + random.nextInt(32), 3, 20, 64, false, false);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 6, w, random, x, z, 16, 16, 8 + random.nextInt(32), 1, 20, 64, false, true);

			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 0, w, random, x, z, 16, 16, 4 + random.nextInt(16), 1, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 1, w, random, x, z, 16, 16, 4 + random.nextInt(16), 3, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 2, w, random, x, z, 16, 16, 4 + random.nextInt(16), 2, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 3, w, random, x, z, 16, 16, 4 + random.nextInt(16), 2, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 4, w, random, x, z, 16, 16, 4 + random.nextInt(16), 2, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 5, w, random, x, z, 16, 16, 4 + random.nextInt(16), 3, 50, 100, true, true);
			this.addNuggetOreSpawn(Evercraft_Blocks.blocknuggetOre, 6, w, random, x, z, 16, 16, 4 + random.nextInt(16), 1, 50, 100, true, true);
		}
	}
//NETHER
	private void generateNether(Random random, int x, int z, World w) {
		if (Evercraft_Config_WorldBase.GenerateNetherrack == true) {
			for(int i = 0; i < 20; i++)
			{
				int Xcoord = x + random.nextInt(16);
				int Ycoord = 10 + random.nextInt(100);
				int Zcoord = z + random.nextInt(16);
				
				new ECWorldGenMineableNetherMeta(Evercraft_Blocks.blockfireblock,1 , 10 + random.nextInt(10)).generate(w, random, Xcoord, Ycoord, Zcoord);
			}
			for(int i = 0; i < 25; i++)
			{
				int Xcoord = x + random.nextInt(16);
				int Ycoord = 20 + random.nextInt(128);
				int Zcoord = z + random.nextInt(16);
				
				new ECWorldGenMineableNetherMeta(Evercraft_Blocks.blockfireblock,0 , 15 + random.nextInt(15)).generate(w, random, Xcoord, Ycoord, Zcoord);
			}
		}
	
	
	
	}
	//END
		private void generateEnd(Random random, int x, int z, World w) {

			if (Evercraft_Config_WorldBase.generateendstoneISLANDS == true) {
				for(int i = 0; i < Evercraft_Config_WorldBase.endstoneRARITY; i++)
				{
					int Xcoord = x + random.nextInt(16);
					int Ycoord = 15 + random.nextInt(50);
					int Zcoord = z + random.nextInt(16);
					
					new WorldGenMinable_END_inAIR(Blocks.end_stone, 15 + random.nextInt(30)).generate(w, random, Xcoord, Ycoord, Zcoord);
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
	       for(int x = 0; x < chancesToSpawn; x++){
	    	   
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	       }
	}

	public void addNuggetOreSpawn(Block block, int meta, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, boolean checkForGrass, boolean rare)
	{		
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++){
	    	   
	    	   if (rare) {
	    		   if (random.nextInt(50) == 1) {
		    		   int posX = blockXPos + random.nextInt(maxX);
		    		   int posY = minY + random.nextInt(diffBtwnMinMaxY);
		    		   int posZ = blockZPos + random.nextInt(maxZ);
		    		   (new WorldGenMinable_NuggetOre(block, meta, maxVeinSize, checkForGrass)).generate(world, random, posX, posY, posZ);
	    		   }
	    	   }else{
	    		   int posX = blockXPos + random.nextInt(maxX);
	    		   int posY = minY + random.nextInt(diffBtwnMinMaxY);
	    		   int posZ = blockZPos + random.nextInt(maxZ);
	    		   (new WorldGenMinable_NuggetOre(block, meta, maxVeinSize, checkForGrass)).generate(world, random, posX, posY, posZ);
	    	   }
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



