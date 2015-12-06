package evercraft.NEMESIS13cz.Config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;



public class Evercraft_Config_Base {

	public static Configuration config;
	
	//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public static int bronzetoolsUSES;
	public static int obsidiumtoolsUSES;
	public static int coppertoolsUSES;	
	public static int steeltoolsUSES;
	public static int redstonetoolsUSES;
	public static int lapistoolsUSES;
	public static int derpytoolsUSES;
	public static int glowstoneharvesterUSES;
	public static int obsidianharvesterUSES;
	public static int woolcardUSES;
	public static int wrenchUSES;
	public static int hammerUSES;
	
	public static int bronzearmorUSES;
	public static int obsidiumarmorUSES;
	public static int copperarmorUSES;	
	public static int steelarmorUSES;
	public static int redstonearmorUSES;
	public static int lapisarmorUSES;
	public static int derpyarmorUSES;
	
	public static int copperbowUSES;
	public static int bronzebowUSES;
	public static int steelbowUSES;
	public static int lapisbowUSES;
	public static int redstonebowUSES;
	public static int obsidiumbowUSES;
	public static int derpybowUSES;
	public static int ironbowUSES;
	public static int goldbowUSES;
	public static int diamondbowUSES;
	
	public static boolean hardmode;
	public static boolean horsearmor;
	public static boolean nametag;
	public static boolean saddle;
	public static boolean dungeonLoot;
	public static boolean creeperDungeons;
	
	public static boolean gregTechMODE;
	

	
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
	
	private static void loadConfiguration(){		
		
		//Misc ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		obsidiumtoolsUSES = config.getInt("Obsidium Tools Uses", Configuration.CATEGORY_GENERAL, 2048, 0, Integer.MAX_VALUE, "Amount of uses that Obsidium tools have");
		bronzetoolsUSES = config.getInt("Bronze Tools Uses", Configuration.CATEGORY_GENERAL, 400, 0, Integer.MAX_VALUE, "Amount of uses that Bronze tools have");
		coppertoolsUSES = config.getInt("Copper Tools Uses", Configuration.CATEGORY_GENERAL, 200, 0, Integer.MAX_VALUE, "Amount of uses that Copper tools have");
		derpytoolsUSES = config.getInt("Derpy Tools Uses", Configuration.CATEGORY_GENERAL, 32000, 0, Integer.MAX_VALUE, "Amount of uses that Derpy tools have");
		lapistoolsUSES = config.getInt("Lapis Tools Uses", Configuration.CATEGORY_GENERAL, 600, 0, Integer.MAX_VALUE, "Amount of uses that Lapis Lazuli tools have");
		redstonetoolsUSES = config.getInt("Redstone Tools Uses", Configuration.CATEGORY_GENERAL, 500, 0, Integer.MAX_VALUE, "Amount of uses that Redstone tools have");
		steeltoolsUSES = config.getInt("Steel Tools Uses", Configuration.CATEGORY_GENERAL, 1024, 0, Integer.MAX_VALUE, "Amount of uses that Steel tools have");
		glowstoneharvesterUSES = config.getInt("Glowstone Harvester Uses", Configuration.CATEGORY_GENERAL, 64, 0, Integer.MAX_VALUE, "Amount of uses that Glowstone Harvester has");
		obsidianharvesterUSES = config.getInt("Obsidian Harvester Uses", Configuration.CATEGORY_GENERAL, 128, 0, Integer.MAX_VALUE, "Amount of uses that Obsidian Harvester has");
		woolcardUSES = config.getInt("Wool Card Uses", Configuration.CATEGORY_GENERAL, 64, 0, Integer.MAX_VALUE, "Amount of uses that Wool Card has");
		wrenchUSES = config.getInt("Wrench Uses", Configuration.CATEGORY_GENERAL, 64, 0, Integer.MAX_VALUE, "Amount of uses that Wrench has");
		hammerUSES = config.getInt("Hammer Uses", Configuration.CATEGORY_GENERAL, 64, 0, Integer.MAX_VALUE, "Amount of uses that Hammer has");
		
		obsidiumarmorUSES = config.getInt("Obsidium Armor Uses", Configuration.CATEGORY_GENERAL, 42, 0, Integer.MAX_VALUE, "Amount of uses that Obsidium armor has");
		bronzearmorUSES = config.getInt("Bronze Armor Uses", Configuration.CATEGORY_GENERAL, 17, 0, Integer.MAX_VALUE, "Amount of uses that Bronze armor has");
		copperarmorUSES = config.getInt("Copper Armor Uses", Configuration.CATEGORY_GENERAL, 12, 0, Integer.MAX_VALUE, "Amount of uses that Copper armor has");
		derpyarmorUSES = config.getInt("Derpy Armor Uses", Configuration.CATEGORY_GENERAL, 300, 0, Integer.MAX_VALUE, "Amount of uses that Derpy armor has");
		lapisarmorUSES = config.getInt("Lapis Armor Uses", Configuration.CATEGORY_GENERAL, 19, 0, Integer.MAX_VALUE, "Amount of uses that Lapis Lazuli armor has");
		redstonearmorUSES = config.getInt("Redstone Armor Uses", Configuration.CATEGORY_GENERAL, 18, 0, Integer.MAX_VALUE, "Amount of uses that Redstone armor has");
		steelarmorUSES = config.getInt("Steel Armor Uses", Configuration.CATEGORY_GENERAL, 22, 0, Integer.MAX_VALUE, "Amount of uses that Steel armor has");
		
		copperbowUSES = config.getInt("Copper Bow Uses", Configuration.CATEGORY_GENERAL, 400, 0, Integer.MAX_VALUE, "Amount of uses that Copper Bow has");
		bronzebowUSES = config.getInt("Bronze Bow Uses", Configuration.CATEGORY_GENERAL, 500, 0, Integer.MAX_VALUE, "Amount of uses that Bronze Bow has");
		steelbowUSES = config.getInt("Steel Bow Uses", Configuration.CATEGORY_GENERAL, 1600, 0, Integer.MAX_VALUE, "Amount of uses that Steel Bow has");
		lapisbowUSES = config.getInt("Lapis Bow Uses", Configuration.CATEGORY_GENERAL, 760, 0, Integer.MAX_VALUE, "Amount of uses that Lapis Lazuli Bow has");
		redstonebowUSES = config.getInt("Redstone Bow Uses", Configuration.CATEGORY_GENERAL, 700, 0, Integer.MAX_VALUE, "Amount of uses that Redstone Bow has");
		obsidiumbowUSES = config.getInt("Obsidium Bow Uses", Configuration.CATEGORY_GENERAL, 2700, 0, Integer.MAX_VALUE, "Amount of uses that Obsidium Bow has");
		derpybowUSES = config.getInt("Derpy Bow Uses", Configuration.CATEGORY_GENERAL, 40000, 0, Integer.MAX_VALUE, "Amount of uses that Derpy Bow has");
		ironbowUSES = config.getInt("Iron Bow Uses", Configuration.CATEGORY_GENERAL, 620, 0, Integer.MAX_VALUE, "Amount of uses that Iron Bow has");
		goldbowUSES = config.getInt("Gold Bow Uses", Configuration.CATEGORY_GENERAL, 200, 0, Integer.MAX_VALUE, "Amount of uses that Gold Bow has");
		diamondbowUSES = config.getInt("Diamond Bow Uses", Configuration.CATEGORY_GENERAL, 2200, 0, Integer.MAX_VALUE, "Amount of uses that Diamond Bow has");
		
		hardmode = config.getBoolean("Hardmode", Configuration.CATEGORY_GENERAL, false, "Changes some recipes to their harder variants");
		horsearmor = config.getBoolean("Horse Armor", Configuration.CATEGORY_GENERAL, true, "Adds crafting recipes for Horse Armor");
		nametag = config.getBoolean("Name Tag", Configuration.CATEGORY_GENERAL, true, "Adds crafting recipe for Name Tag");
		saddle = config.getBoolean("Saddle", Configuration.CATEGORY_GENERAL, true, "Adds crafting recipe for Saddle");
		dungeonLoot = config.getBoolean("Dungeon Loot", Configuration.CATEGORY_GENERAL, true, "Adds Evercraft related items into loot chests (Dungeons, Pyramids, Jungle Temples, Strongholds, Mineshafts)");
		creeperDungeons = config.getBoolean("Creeper Dungeons", Configuration.CATEGORY_GENERAL, true, "Adds Creeper Dungeons with spawn chance of 100 (zombie: 200, skeleton: 100, spider: 100)");
		
		gregTechMODE = config.getBoolean("GregTech Compat", Configuration.CATEGORY_GENERAL, false, "Enables very high compatibility with Gregtech-Addon for Industrial Craft 2 (Dont use without GregTech-Addon installed!!!)");

		if (config.hasChanged()) {
			config.save();
		}
	}
}
