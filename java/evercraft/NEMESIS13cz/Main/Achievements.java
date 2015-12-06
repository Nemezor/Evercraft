package evercraft.NEMESIS13cz.Main;

import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Utils.MetaInterface;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;


public class Achievements {

	
	public static Achievement hammer;
	public static Achievement electrolyzer;
	public static Achievement hammeringMachine;
	public static Achievement crusher;
	public static Achievement alloyFurnace;
	public static Achievement cables;
	public static Achievement heatGenerator;
	public static Achievement solarGenerator;
	public static Achievement ethericGenerator;
	public static Achievement HTFurnace;
	public static Achievement plateMill;
	public static Achievement advCrusher;
	public static Achievement advFurnace;
	public static Achievement repCrusher;
	public static Achievement pressurizer;
	public static Achievement derpyIngot;
	public static Achievement mixingTable;
	public static Achievement wirelessRedstone;
	public static Achievement advCrafter;
	public static Achievement CapArray;
	public static Achievement centrifuge;
	public static Achievement oreProcessPlant;
	public static Achievement miner;
	public static Achievement cuttingMachine;
	public static Achievement advElectrolyzer;
	public static Achievement potionMatrix;
	
	public static AchievementPage EvercraftAchievementPage;
	
	public static void init() {
		
	hammer = new Achievement("ec.achievement.hammer", "hammer", 0, -2, Evercraft_Items.hammer, AchievementList.acquireIron).registerStat();
	mixingTable = new Achievement("ec.achievement.mixingTable", "mixingTable", 1, -1, Evercraft_Blocks.blockmixingtable, hammer).registerStat();
	electrolyzer = new Achievement("ec.achievement.electrolyzer", "electrolyzer", 0, 2, Evercraft_Items.aluminiumingot, mixingTable).registerStat();
	hammeringMachine = new Achievement("ec.achievement.hammeringMachine", "hammeringMachine", 0, 4, new ItemStack(Evercraft_Items.plate, 1, MetaInterface.plateHardenedIron), electrolyzer).registerStat();
	crusher = new Achievement("ec.achievement.crusher", "crusher", -2, 4, Evercraft_Items.golddust, hammeringMachine).registerStat();
	alloyFurnace = new Achievement("ec.achievement.alloyFurnace", "alloyFurnace", 2, 4, Evercraft_Items.bronzeingot, hammeringMachine).registerStat();
	cables = new Achievement("ec.achievement.cables", "cables", 2, 2, Evercraft_Blocks.blockredstonitecable, alloyFurnace).registerStat();
	plateMill = new Achievement("ec.achievement.plateMill", "plateMill", 3, 1, new ItemStack(Evercraft_Items.largeplate, 1, 7), cables).registerStat();
	HTFurnace = new Achievement("ec.achievement.HTFurnace", "HTFurnace", 7, 1, Evercraft_Items.titaniumingot, plateMill).registerStat();
	heatGenerator = new Achievement("ec.achievement.heatGenerator", "heatGenerator", -2, 0, Evercraft_Items.ash, electrolyzer).registerStat();
	solarGenerator = new Achievement("ec.achievement.solarGenerator", "solarGenerator", 7, 5, Evercraft_Items.photovoltaicpanel, HTFurnace).registerStat();
	ethericGenerator = new Achievement("ec.achievement.ethericGenerator", "ethericGenerator", -2, 1, Items.glowstone_dust, electrolyzer).registerStat();
	advCrusher = new Achievement("ec.achievement.advCrusher", "advCrusher", 9, 0, Evercraft_Items.diamonddust, HTFurnace).registerStat();
	advFurnace = new Achievement("ec.achievement.advFurnace", "advFurnace", -3, 3, Items.iron_ingot, electrolyzer).registerStat();
	repCrusher = new Achievement("ec.achievement.repCrusher", "repCrusher", 9, 3, Evercraft_Items.ironpowder, HTFurnace).registerStat();
	pressurizer = new Achievement("ec.achievement.pressurizer", "pressurizer", 9, -1, Items.diamond, HTFurnace).registerStat();
	derpyIngot = new Achievement("ec.achievement.derpyIngot", "derpyIngot", -2, -2, Evercraft_Items.derpyingot, (Achievement)null).initIndependentStat().setSpecial().registerStat();
	wirelessRedstone = new Achievement("ec.achievement.wirelessRedstone", "wirelessRedstone", 5, 4, Evercraft_Items.WRScoordinator, alloyFurnace).registerStat();
	advCrafter = new Achievement("ec.achievement.advCrafter", "advCrafter", -4, 0, new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth, 1, 15), AchievementList.acquireIron).registerStat();
	CapArray = new Achievement("ec.achievement.CapArray", "CapArray", 4, 0, new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), cables).registerStat();
	centrifuge = new Achievement("ec.achievement.centrifuge", "centrifuge", 9, 2, Evercraft_Blocks.blockcentrifugeOff, HTFurnace).registerStat();
	oreProcessPlant = new Achievement("ec.achievement.oreProcessPlant", "oreProcessPlant", 9, -2, Evercraft_Blocks.blockorefactoryOff, HTFurnace).setSpecial().registerStat();
	miner = new Achievement("ec.achievement.miner", "miner", -2, 2, Items.diamond_pickaxe, electrolyzer).registerStat();
	cuttingMachine = new Achievement("ec.achievement.cuttingMachine", "cuttingMachine", 4, 3, Blocks.planks, alloyFurnace).registerStat();
	advElectrolyzer = new Achievement("ec.achievement.advElectrolyzer", "advElectrolyzer", 9, 1, Evercraft_Blocks.blockadvancedelectrolyzerOff, HTFurnace).registerStat();
	potionMatrix = new Achievement("ec.achievement.potionMatrix", "potionMatrix", 4, 5, Evercraft_Items.potionmatrix, alloyFurnace).setSpecial().registerStat();
	
	EvercraftAchievementPage = new AchievementPage("Evercraft", new Achievement[] {hammer, electrolyzer, hammeringMachine, crusher, alloyFurnace, cables, heatGenerator, solarGenerator, 	ethericGenerator, HTFurnace, plateMill, advCrusher, advFurnace, repCrusher, pressurizer, derpyIngot, mixingTable, wirelessRedstone, advCrafter, CapArray, centrifuge, oreProcessPlant, miner, cuttingMachine, advElectrolyzer, potionMatrix});
	AchievementPage.registerAchievementPage(EvercraftAchievementPage);

	Evercraft.log.info("Achievements created");
	}
}