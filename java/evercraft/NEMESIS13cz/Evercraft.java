package evercraft.NEMESIS13cz;


import java.io.File;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldAditional;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldBase;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_WorldMegaVeins;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedElectrolyzerRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.AlloyFurnaceRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.CentrifugeRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.CrusherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.CuttingMachineRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.ElectrolyzerRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.EnricherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.HammeringMachineRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.HighPressureFurnaceRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.ParticleMergerRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.PlateMillRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.RepulsiveCrusherRecipes;
import evercraft.NEMESIS13cz.Main.Achievements;
import evercraft.NEMESIS13cz.Main.CommonProxy;
import evercraft.NEMESIS13cz.Main.Dictionary;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.ECDungeonLoot;
import evercraft.NEMESIS13cz.Main.ECFuelHandler;
import evercraft.NEMESIS13cz.Main.ECGuiHandler;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Entity;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Main.Evercraft_Recipes;
import evercraft.NEMESIS13cz.Main.Evercraft_TileEntity;
import evercraft.NEMESIS13cz.Tabs.ECCrafttab;
import evercraft.NEMESIS13cz.Tabs.ECDecotab;
import evercraft.NEMESIS13cz.Tabs.ECMachinetab;
import evercraft.NEMESIS13cz.Tabs.ECMetaMaterialsTab;
import evercraft.NEMESIS13cz.Tabs.ECMisctab;
import evercraft.NEMESIS13cz.Tabs.ECTooltab;
import evercraft.NEMESIS13cz.Tabs.ECWGtab;
import evercraft.NEMESIS13cz.Utils.ECLog;
import evercraft.NEMESIS13cz.World.ECWorldGenerator_Aditional;
import evercraft.NEMESIS13cz.World.ECWorldGenerator_FloatingOres;
import evercraft.NEMESIS13cz.World.ECWorldGenerator_MegaVeins;
import evercraft.NEMESIS13cz.World.ECWorldGenerator_Primary;
import evercraft.NEMESIS13cz.World.ECWorldGenerator_Secondary;
import evercraft.NEMESIS13cz.misc.ECAchievementTrigger;
import evercraft.NEMESIS13cz.misc.ECCraftingHandler;

/**
 * 
 * @author NEMESIS13cz
 *
 */

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, guiFactory = ModInformation.GUI_FACTORY)
public class Evercraft {
	
	
	@Mod.Instance(ModInformation.ID)
	private static Evercraft instance;
	
	public static Evercraft getEvercraft() {
		return instance;
	}
	
	@SidedProxy(clientSide = ModInformation.PROXY_CLIENT, serverSide = ModInformation.PROXY_COMMON)
	public static CommonProxy proxy;

    public static File config_base;
    public static File config_worldBase;
    public static File config_worldAditional;
    public static File config_worldMegaVeins;
    public static File config_machines;
    
    public static ECLog log;
    
	private static ECGuiHandler guihandler = new ECGuiHandler();
	
	public static CreativeTabs tabECMisc = new ECMisctab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_MiscStuff");
	public static CreativeTabs tabECWGMaterials = new ECWGtab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_WorldGen_Materials");
	public static CreativeTabs tabECDeco = new ECDecotab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_Decoratoion");
	public static CreativeTabs tabECMachines = new ECMachinetab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_Machines");
	public static CreativeTabs tabECTools = new ECTooltab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_Tools");
	public static CreativeTabs tabECCraft = new ECCrafttab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_Crafting_Materials");
	public static CreativeTabs tabECMetaMaterials = new ECMetaMaterialsTab(CreativeTabs.getNextID(), "NEMESIS13cz_Evercraft_Metadata_Materials");
	
	public Object[] advCrusherRecipes;
	public Object[] crusherRecipes;
	public Object[] electrolyzerRecipes;
	public Object[] advElectrolyzerRecipes;
	public Object[] cuttingMachineRecipes;
	public Object[] alloyFurnaceRecipes;
	public Object[] centrifugeRecipes;
	public Object[] hammeringMachineRecipes;
	public Object[] highPressureFurnaceRecipes;
	public Object[] particleMergerRecipes;
	public Object[] plateMillRecipes;
	public Object[] repCrusherRecipes;
	public Object[] enricherRecipes;
	
	private ArrayList<Long> networkIDs = new ArrayList<Long>();
	
	public long getNextID() {
		return this.networkIDs.size();
	}
	
	public void registerNewNetwork(long Id) {
		this.networkIDs.add(Id);
	}
	
	public void removeNetwork(long Id) {
		for (int i = 0; i < this.networkIDs.size(); i++) {
			if (this.networkIDs.get(i) == Id) {
				this.networkIDs.remove(i);
				break;
			}
		}
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		long time = System.currentTimeMillis();
		long timeN = System.nanoTime();
			Evercraft.log.info("Pre Initialization started");
		
		config_base = new File("config/Evercraft/Evercraft_Base.cfg");
		config_worldBase = new File("config/Evercraft/Evercraft_WorldGen-Base.cfg");
		config_worldAditional = new File("config/Evercraft/Evercraft_WorldGen-Aditional.cfg");
		config_worldMegaVeins = new File("config/Evercraft/Evercraft_WorldGen-BigVeins.cfg");
		config_machines = new File("config/Evercraft/Evercraft_Machinery.cfg");

		Evercraft_Config_Base.InitConfiguration(config_base);
		Evercraft_Config_WorldBase.InitConfiguration(config_worldBase);
		Evercraft_Config_WorldAditional.InitConfiguration(config_worldAditional);
		Evercraft_Config_WorldMegaVeins.InitConfiguration(config_worldMegaVeins);
		Evercraft_Config_Machines.InitConfiguration(config_machines);
		
		FMLCommonHandler.instance().bus().register(new Evercraft_Config_Base());
		FMLCommonHandler.instance().bus().register(new Evercraft_Config_WorldBase());
		FMLCommonHandler.instance().bus().register(new Evercraft_Config_WorldAditional());
		FMLCommonHandler.instance().bus().register(new Evercraft_Config_WorldMegaVeins());
		FMLCommonHandler.instance().bus().register(new Evercraft_Config_Machines());
		
		Evercraft_Items.init();
		Evercraft_Blocks.init();
		
		GameRegistry.registerWorldGenerator(new ECWorldGenerator_Primary(), 0);
		GameRegistry.registerWorldGenerator(new ECWorldGenerator_Secondary(), 1);
		GameRegistry.registerWorldGenerator(new ECWorldGenerator_Aditional(), 0);
		GameRegistry.registerWorldGenerator(new ECWorldGenerator_MegaVeins(), 1);
		GameRegistry.registerWorldGenerator(new ECWorldGenerator_FloatingOres(), 1);

			Evercraft.log.info("World Generator registered");
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this.getEvercraft(), guihandler);
		GameRegistry.registerFuelHandler(new ECFuelHandler());

			Evercraft.log.info("GUI and fuel handlers registered");
		 
		Evercraft_Entity.registerEntity();
		
		Achievements.init();
		
		Evercraft_TileEntity.init();
		
		proxy.initSounds();
		proxy.initRenderers();
		
			Evercraft.log.info("Pre Initialization completed in: " + (System.currentTimeMillis() - time) + "ms (" + (System.nanoTime() - timeN) + " nanoseconds)");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event) {
		long time = System.currentTimeMillis();
		long timeN = System.nanoTime();
			Evercraft.log.info("Initialization started");
		
		Dictionary.registerOre();
		FMLCommonHandler.instance().bus().register(new ECAchievementTrigger());
		FMLCommonHandler.instance().bus().register(new ECCraftingHandler());

			Evercraft.log.info("Crafting handlers registered");
		
		Evercraft_Recipes.init();
		ECDungeonLoot.addLoot();
		ECDungeonLoot.addMobs();

			Evercraft.log.info("Initialization completed in: " + (System.currentTimeMillis() - time) + "ms (" + (System.nanoTime() - timeN) + " nanoseconds)");
	}
	
	@Mod.EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		long time = System.currentTimeMillis();
		long timeN = System.nanoTime();
			Evercraft.log.info("Post Initialization started");
		
		DictionaryExtractor.extractOreLists();
		
		this.advCrusherRecipes = AdvancedCrusherRecipes.advancedCrushing().getSmeltingList().keySet().toArray();
		this.crusherRecipes = CrusherRecipes.crushing().getSmeltingList().keySet().toArray();
		this.electrolyzerRecipes = ElectrolyzerRecipes.electrolyzing().getSmeltingList().keySet().toArray();
		this.advElectrolyzerRecipes = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingList().keySet().toArray();
		this.cuttingMachineRecipes = CuttingMachineRecipes.cutting().getSmeltingList().keySet().toArray();
		this.alloyFurnaceRecipes = AlloyFurnaceRecipes.smelting().getSmeltingList().keySet().toArray();
		this.centrifugeRecipes = CentrifugeRecipes.centrifuging().getSmeltingList().keySet().toArray();
		this.hammeringMachineRecipes = HammeringMachineRecipes.hammering().getSmeltingList().keySet().toArray();
		this.highPressureFurnaceRecipes = HighPressureFurnaceRecipes.smelting().getSmeltingList().keySet().toArray();
		this.particleMergerRecipes = ParticleMergerRecipes.compacting().getSmeltingList().keySet().toArray();
		this.plateMillRecipes = PlateMillRecipes.plating().getSmeltingList().keySet().toArray();
		this.repCrusherRecipes = RepulsiveCrusherRecipes.crushing().getSmeltingList().keySet().toArray();
		this.enricherRecipes = EnricherRecipes.enriching().getSmeltingList().keySet().toArray();
		
			Evercraft.log.info("Post Initialization completed in: " + (System.currentTimeMillis() - time) + "ms (" + (System.nanoTime() - timeN) + " nanoseconds)");
	}
}