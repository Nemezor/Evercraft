package evercraft.NEMESIS13cz.Config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;



public class Evercraft_Config_WorldBase {

	public static Configuration config;
	
	//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static boolean GenerateCopper;
	public static boolean GenerateTin;
	public static boolean GenerateSilver;
	public static boolean GenerateSphene;
	public static boolean GenerateBauxite;
	public static boolean GenerateSandstone;
	public static boolean GenerateNetherrack;
	public static boolean GenerateClaydirt;
	public static boolean GenerateZinc;
	public static boolean GenerateMossyStone;
	public static boolean GeneratePowerSand;
	public static boolean GenerateMagnetite;
	public static boolean GenerateEndOre;
	public static boolean GenerateLeadOre;
	public static boolean GenerateWhiteStone;
	public static boolean GenerateNuggetOres;
	
	public static int endstoneRARITY;
	
	public static int enderoreDROP;
	public static boolean generateendstoneISLANDS;

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
	
		GenerateCopper = config.getBoolean("Copper Ore", Configuration.CATEGORY_GENERAL, true, "Generate Copper Ore");
		GenerateTin = config.getBoolean("Tin Ore", Configuration.CATEGORY_GENERAL, true, "Generate Silver Ore");
		GenerateSilver = config.getBoolean("Silver Ore", Configuration.CATEGORY_GENERAL, true, "Generate Copper Ore");
		GenerateSphene = config.getBoolean("Sphene Ore", Configuration.CATEGORY_GENERAL, true, "Generate Sphene Ore");
		GenerateBauxite = config.getBoolean("Bauxite Ore", Configuration.CATEGORY_GENERAL, true, "Generate Bauxite Ore");
		GenerateSandstone = config.getBoolean("Sandstone", Configuration.CATEGORY_GENERAL, true, "Generate Sandstone");
		GenerateNetherrack = config.getBoolean("Netherrack", Configuration.CATEGORY_GENERAL, true, "Generate Netherrack");
		GenerateClaydirt = config.getBoolean("Claydirt", Configuration.CATEGORY_GENERAL, true, "Generate Claydirt");
		GenerateZinc = config.getBoolean("Zinc Ore", Configuration.CATEGORY_GENERAL, true, "Generate Zinc Ore");
		GenerateMossyStone = config.getBoolean("Mossystone", Configuration.CATEGORY_GENERAL, true, "Generate Mossystone");
		GeneratePowerSand = config.getBoolean("Power Sand", Configuration.CATEGORY_GENERAL, true, "Generate Power Sand");
		GenerateMagnetite = config.getBoolean("Magnetite", Configuration.CATEGORY_GENERAL, true, "Generate Magnetite");
		GenerateEndOre = config.getBoolean("End Ore", Configuration.CATEGORY_GENERAL, true, "Generate End Ore");
		GenerateLeadOre = config.getBoolean("Lead Ore", Configuration.CATEGORY_GENERAL, true, "Generate Lead Ore");
		GenerateWhiteStone = config.getBoolean("Whitestone", Configuration.CATEGORY_GENERAL, true, "Generate Whitestone");
		GenerateNuggetOres = config.getBoolean("Nugget Ores", Configuration.CATEGORY_GENERAL, true, "Generate Metal Nuggets in Gravel Under Water");
		
		generateendstoneISLANDS = config.getBoolean("Endstone Islands", Configuration.CATEGORY_GENERAL, true, "Generate Endstone Inslands in The End");
		endstoneRARITY = config.getInt("Endstone Islands Spawn", Configuration.CATEGORY_GENERAL, 2, 0, Integer.MAX_VALUE, "How many chances to generate Endstone Islands in The End per Chunk");
		enderoreDROP = config.getInt("End Ore Drops", Configuration.CATEGORY_GENERAL, 3, 0, Integer.MAX_VALUE, "How many random items will be dropped by the End Ore");

		if (config.hasChanged()) {
			config.save();
		}
	}
}
