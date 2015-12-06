package evercraft.NEMESIS13cz.World;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldAditional;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inDIRT;
import evercraft.NEMESIS13cz.misc.materialMinables.WorldGenMinable_inSAND;

public class ECWorldGenerator_Aditional implements IWorldGenerator {
	
	
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

		
		//ADITIONAL ORES
			if (Evercraft_Config_WorldAditional.AditionalCoal == true) {
			this.addOreSpawn(Blocks.coal_ore, w, random, x, z, 16, 16, 6 + random.nextInt(10), Evercraft_Config_WorldAditional.AditionalCoalRARITY, Evercraft_Config_WorldAditional.AditionalCoalMIN, Evercraft_Config_WorldAditional.AditionalCoalMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalIron == true) {
			this.addOreSpawn(Blocks.iron_ore, w, random, x, z, 16, 16, 4 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalIronRARITY, Evercraft_Config_WorldAditional.AditionalIronMIN, Evercraft_Config_WorldAditional.AditionalIronMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalGold == true) {
			this.addOreSpawn(Blocks.gold_ore, w, random, x, z, 16, 16, 2 + random.nextInt(3), Evercraft_Config_WorldAditional.AditionalGoldRARITY, Evercraft_Config_WorldAditional.AditionalGoldMIN, Evercraft_Config_WorldAditional.AditionalGoldMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalRedstone == true) {
			this.addOreSpawn(Blocks.redstone_ore, w, random, x, z, 16, 16, 4 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalRedstoneRARITY, Evercraft_Config_WorldAditional.AditionalRedstoneMIN, Evercraft_Config_WorldAditional.AditionalRedstoneMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalDiamonds == true) {
			this.addOreSpawn(Blocks.diamond_ore, w, random, x, z, 16, 16, 2 + random.nextInt(2), Evercraft_Config_WorldAditional.AditionalDiamondsRARITY, Evercraft_Config_WorldAditional.AditionalDiamondsMIN, Evercraft_Config_WorldAditional.AditionalDiamondsMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalEmeralds == true) {
			this.addOreSpawn(Blocks.emerald_ore, w, random, x, z, 16, 16, 1 + random.nextInt(3), Evercraft_Config_WorldAditional.AditionalEmeraldsRARITY, Evercraft_Config_WorldAditional.AditionalEmeraldsMIN, Evercraft_Config_WorldAditional.AditionalEmeraldsMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalQuartz == true) {
			this.addOreSpawn(Evercraft_Blocks.blockoverworldquartzore, w, random, x, z, 16, 16, 2 + random.nextInt(8), Evercraft_Config_WorldAditional.AditionalQuartzRARITY, Evercraft_Config_WorldAditional.AditionalQuartzMIN, Evercraft_Config_WorldAditional.AditionalQuartzMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalLapis == true) {
			this.addOreSpawn(Blocks.lapis_ore, w, random, x, z, 16, 16, 3 + random.nextInt(1), Evercraft_Config_WorldAditional.AditionalLapisRARITY, Evercraft_Config_WorldAditional.AditionalLapisMIN, Evercraft_Config_WorldAditional.AditionalLapisMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalCopper == true) {
			this.addOreSpawn(Evercraft_Blocks.blockcopperore, w, random, x, z, 16, 16, 8 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalCopperRARITY, Evercraft_Config_WorldAditional.AditionalCopperMIN, Evercraft_Config_WorldAditional.AditionalCopperMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalTin == true) {
			this.addOreSpawn(Evercraft_Blocks.blocktinore, w, random, x, z, 16, 16, 4 + random.nextInt(6), Evercraft_Config_WorldAditional.AditionalTinRARITY, Evercraft_Config_WorldAditional.AditionalTinMIN, Evercraft_Config_WorldAditional.AditionalTinMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalSilver == true) {
			this.addOreSpawn(Evercraft_Blocks.blocksilverore, w, random, x, z, 16, 16, 2 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalSilverRARITY, Evercraft_Config_WorldAditional.AditionalSilverMIN, Evercraft_Config_WorldAditional.AditionalSilverMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalBauxite == true) {
			this.addOreSpawn(Evercraft_Blocks.blockbauxiteore, w, random, x, z, 16, 16, 6 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalBauxiteRARITY, Evercraft_Config_WorldAditional.AditionalBauxiteMIN, Evercraft_Config_WorldAditional.AditionalBauxiteMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalZinc == true) {
			this.addOreSpawn(Evercraft_Blocks.blockzincore, w, random, x, z, 16, 16, 6 + random.nextInt(4), Evercraft_Config_WorldAditional.AditionalZincRARITY, Evercraft_Config_WorldAditional.AditionalZincMIN, Evercraft_Config_WorldAditional.AditionalZincMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalSphene == true) {
			this.addOreSpawn(Evercraft_Blocks.blockspheneore, w, random, x, z, 16, 16, 4 + random.nextInt(6), Evercraft_Config_WorldAditional.AditionalSpheneRARITY, Evercraft_Config_WorldAditional.AditionalSpheneMIN, Evercraft_Config_WorldAditional.AditionalSpheneMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalMagnetite == true) {
			this.addOreSpawn(Evercraft_Blocks.blockmagneticstone, w, random, x, z, 16, 16, 2 + random.nextInt(2), Evercraft_Config_WorldAditional.AditionalMagnetiteRARITY, Evercraft_Config_WorldAditional.AditionalMagnetiteMIN, Evercraft_Config_WorldAditional.AditionalMagnetiteMAX);
			}
			if (Evercraft_Config_WorldAditional.AditionalLead == true) {
			this.addOreSpawn(Evercraft_Blocks.blockleadore, w, random, x, z, 16, 16, 4 + random.nextInt(2), Evercraft_Config_WorldAditional.AditionalLeadRARITY, Evercraft_Config_WorldAditional.AditionalLeadMIN, Evercraft_Config_WorldAditional.AditionalLeadMAX);
			}
			
	}
	//NETHER
	private void generateNether(Random random, int x, int z, World w) {
	}
	//END
		private void generateEnd(Random random, int x, int z, World w) {
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



