package evercraft.NEMESIS13cz.Config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;



public class Evercraft_Config_WorldMegaVeins {

	public static Configuration config;
	
	//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static int megaVeinsRARITY;
	public static boolean generateMegaVeins;
	public static boolean generateEmeraldInExtremeHillsOnly;
	
	public static boolean totalyCrazyWG;

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
	
		generateMegaVeins = config.getBoolean("Giant Veins", Configuration.CATEGORY_GENERAL, false, "Generates GIANT ore veins");
		generateEmeraldInExtremeHillsOnly = config.getBoolean("Emerald Veins", Configuration.CATEGORY_GENERAL, true, "Forces Emerald Mega Veins to generate only in Extreme Hills biome (Applies ONLY for giant veins)");
		megaVeinsRARITY = config.getInt("Giant Veins Spawn", Configuration.CATEGORY_GENERAL, 1000, 0, Integer.MAX_VALUE, "Per how many chunks will a giant vein be generated");

		totalyCrazyWG = config.getBoolean("Crazy WorldGenerator", Configuration.CATEGORY_GENERAL, false, "Generates giant ore veins... very often... and in the air...");
		
		if (config.hasChanged()) {
			config.save();
		}
	}
}
