package evercraft.NEMESIS13cz.Config;

import java.io.File; 

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;



public class Evercraft_Config_WorldAditional {

	public static Configuration config;
	
	//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static boolean AditionalCoal;
	public static boolean AditionalIron;
	public static boolean AditionalGold;
	public static boolean AditionalRedstone;
	public static boolean AditionalDiamonds;
	public static boolean AditionalEmeralds;
	public static boolean AditionalCopper;
	public static boolean AditionalTin;
	public static boolean AditionalBauxite;
	public static boolean AditionalSilver;
	public static boolean AditionalQuartz;
	public static boolean AditionalLapis;
	public static boolean AditionalZinc;
	public static boolean AditionalSphene;
	public static boolean AditionalMagnetite;
	public static boolean AditionalLead;
	
	public static int AditionalCoalRARITY;
	public static int AditionalIronRARITY;
	public static int AditionalGoldRARITY;
	public static int AditionalRedstoneRARITY;
	public static int AditionalDiamondsRARITY;
	public static int AditionalEmeraldsRARITY;
	public static int AditionalCopperRARITY;
	public static int AditionalTinRARITY;
	public static int AditionalBauxiteRARITY;
	public static int AditionalSilverRARITY;
	public static int AditionalQuartzRARITY;
	public static int AditionalLapisRARITY;
	public static int AditionalZincRARITY;
	public static int AditionalSpheneRARITY;
	public static int AditionalMagnetiteRARITY;
	public static int AditionalLeadRARITY;
	
	public static int AditionalCoalMIN;
	public static int AditionalIronMIN;
	public static int AditionalGoldMIN;
	public static int AditionalRedstoneMIN;
	public static int AditionalDiamondsMIN;
	public static int AditionalEmeraldsMIN;
	public static int AditionalCopperMIN;
	public static int AditionalTinMIN;
	public static int AditionalBauxiteMIN;
	public static int AditionalSilverMIN;
	public static int AditionalQuartzMIN;
	public static int AditionalLapisMIN;
	public static int AditionalZincMIN;
	public static int AditionalSpheneMIN;
	public static int AditionalMagnetiteMIN;
	public static int AditionalLeadMIN;
	
	public static int AditionalCoalMAX;
	public static int AditionalIronMAX;
	public static int AditionalGoldMAX;
	public static int AditionalRedstoneMAX;
	public static int AditionalDiamondsMAX;
	public static int AditionalEmeraldsMAX;
	public static int AditionalCopperMAX;
	public static int AditionalTinMAX;
	public static int AditionalBauxiteMAX;
	public static int AditionalSilverMAX;
	public static int AditionalQuartzMAX;
	public static int AditionalLapisMAX;
	public static int AditionalZincMAX;
	public static int AditionalSpheneMAX;
	public static int AditionalMagnetiteMAX;
	public static int AditionalLeadMAX;
	
	public static void InitConfiguration(File configuration){		
		
		if (config == null) {
			config = new Configuration(configuration);
			loadConfiguration();
			Evercraft.log.info("Loaded configuration file at: " + configuration.toString());
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equals(ModInformation.ID)) {
			loadConfiguration();
		}
	}

	private static void loadConfiguration() {		
		
		//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		AditionalCoal = config.getBoolean("Aditional Coal", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Coal");
		AditionalIron = config.getBoolean("Aditional Iron", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Iron");
		AditionalGold = config.getBoolean("Aditional Gold", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Gold");
		AditionalRedstone = config.getBoolean("Aditional Redstone", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Redstone");
		AditionalDiamonds = config.getBoolean("Aditional Diamonds", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Diamonds");
		AditionalEmeralds = config.getBoolean("Aditional Emeralds", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Emeralds");
		AditionalCopper = config.getBoolean("Aditional Copper", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Copper");
		AditionalTin = config.getBoolean("Aditional Tin", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Tin");
		AditionalBauxite = config.getBoolean("Aditional Bauxite", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Bauxite");
		AditionalSilver = config.getBoolean("Aditional Silver", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Silver");
		AditionalQuartz = config.getBoolean("Aditional Quartz", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Quartz");
		AditionalLapis = config.getBoolean("Aditional Lapis", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Lapis Lazuli");
		AditionalZinc = config.getBoolean("Aditional Zinc", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Zinc");
		AditionalSphene = config.getBoolean("Aditional Sphene", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Sphene");
		AditionalMagnetite = config.getBoolean("Aditional Magnetite", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Magnetite");
		AditionalLead = config.getBoolean("Aditional Lead", Configuration.CATEGORY_GENERAL, false, "Generate Aditional Lead");
		
		AditionalCoalRARITY = config.getInt("Coal Spawn", Configuration.CATEGORY_GENERAL, 20, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalIronRARITY = config.getInt("Iron Spawn", Configuration.CATEGORY_GENERAL, 25, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalGoldRARITY = config.getInt("Gold Spawn", Configuration.CATEGORY_GENERAL, 16, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalRedstoneRARITY = config.getInt("Redstone Spawn", Configuration.CATEGORY_GENERAL, 20, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalDiamondsRARITY = config.getInt("Diamond Spawn", Configuration.CATEGORY_GENERAL, 6, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalEmeraldsRARITY = config.getInt("Emerald Spawn", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalCopperRARITY = config.getInt("Copper Spawn", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalTinRARITY = config.getInt("Tin Spawn", Configuration.CATEGORY_GENERAL, 10, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalBauxiteRARITY = config.getInt("Bauxite Spawn", Configuration.CATEGORY_GENERAL, 20, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalSilverRARITY = config.getInt("Silver Spawn", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalQuartzRARITY = config.getInt("Quartz Spawn", Configuration.CATEGORY_GENERAL, 16, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalLapisRARITY = config.getInt("Lapis Spawn", Configuration.CATEGORY_GENERAL, 18, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalZincRARITY = config.getInt("Zinc Spawn", Configuration.CATEGORY_GENERAL, 25, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalSpheneRARITY = config.getInt("Sphene Spawn", Configuration.CATEGORY_GENERAL, 16, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalMagnetiteRARITY = config.getInt("Magnetite Spawn", Configuration.CATEGORY_GENERAL, 8, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		AditionalLeadRARITY = config.getInt("Lead Spawn", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "How many aditional veins per chunk");
		
		AditionalCoalMIN = config.getInt("Coal Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalIronMIN = config.getInt("Iron Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalGoldMIN = config.getInt("Gold Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalRedstoneMIN = config.getInt("Redstone Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalDiamondsMIN = config.getInt("Diamond Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalEmeraldsMIN = config.getInt("Emerald Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalCopperMIN = config.getInt("Copper Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalTinMIN = config.getInt("Tin Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalBauxiteMIN = config.getInt("Bauxite Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalSilverMIN = config.getInt("Silver Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalQuartzMIN = config.getInt("Quartz Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalLapisMIN = config.getInt("Lapis Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalZincMIN = config.getInt("Zinc Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalSpheneMIN = config.getInt("Sphene Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalMagnetiteMIN = config.getInt("Magnetite Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");
		AditionalLeadMIN = config.getInt("Lead Height Min.", Configuration.CATEGORY_GENERAL, 0, 0, 256, "The minimum height that the ore can generate at");

		AditionalCoalMAX = config.getInt("Coal Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalIronMAX = config.getInt("Iron Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalGoldMAX = config.getInt("Gold Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalRedstoneMAX = config.getInt("Redstone Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalDiamondsMAX = config.getInt("Diamond Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalEmeraldsMAX = config.getInt("Emerald Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalCopperMAX = config.getInt("Copper Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalTinMAX = config.getInt("Tin Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalBauxiteMAX = config.getInt("Bauxite Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalSilverMAX = config.getInt("Silver Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalQuartzMAX = config.getInt("Quartz Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalLapisMAX = config.getInt("Lapis Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalZincMAX = config.getInt("Zinc Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalSpheneMAX = config.getInt("Sphene Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalMagnetiteMAX = config.getInt("Magnetite Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");
		AditionalLeadMAX = config.getInt("Lead Height Max.", Configuration.CATEGORY_GENERAL, 256, 0, 256, "The maximum height that the ore can generate at");

		if (config.hasChanged()) {
			config.save();
		}
	}
}
