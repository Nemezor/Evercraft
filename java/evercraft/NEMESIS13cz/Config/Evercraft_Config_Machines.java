package evercraft.NEMESIS13cz.Config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;



public class Evercraft_Config_Machines {

	public static Configuration config;
	
	//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static int minerSpeed;
	public static int minerCostPerBlock;
	public static int travellingItemBounceCounter;
	
	public static boolean fancyRender;

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
	
		minerSpeed = config.getInt("Miner Speed", Configuration.CATEGORY_GENERAL, 100, 0, Integer.MAX_VALUE, "How many ticks it takes to mine a layer of blocks for the Miner (1 second = 20 ticks)");
		minerCostPerBlock = config.getInt("Miner Cost", Configuration.CATEGORY_GENERAL, 40, 0, Integer.MAX_VALUE, "How much EE does it take to mine a SINGLE block");
		fancyRender = config.getBoolean("Rendering", Configuration.CATEGORY_GENERAL, true, "Fancy, more detailed machine models");
		travellingItemBounceCounter = config.getInt("Item Bounce Counter", Configuration.CATEGORY_GENERAL, 10, 1, Integer.MAX_VALUE, "How many times can an item in pipes bounce back before it gets dropped");
		
		if (config.hasChanged()) {
			config.save();
		}
	}		
}
