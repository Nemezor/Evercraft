package evercraft.NEMESIS13cz.Main;

import java.util.ArrayList;

import evercraft.NEMESIS13cz.Evercraft;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class DictionaryExtractor {

	public static ArrayList<ItemStack> copperOre;
	public static ArrayList<ItemStack> tinOre;
	public static ArrayList<ItemStack> silverOre;
	public static ArrayList<ItemStack> zincOre;
	public static ArrayList<ItemStack> spheneOre;
	public static ArrayList<ItemStack> bauxiteOre;
	public static ArrayList<ItemStack> leadOre;
	public static ArrayList<ItemStack> aluminiumOre;
	public static ArrayList<ItemStack> uraniumOre;

	public static ArrayList<ItemStack> copperIngot;
	public static ArrayList<ItemStack> tinIngot;
	public static ArrayList<ItemStack> silverIngot;
	public static ArrayList<ItemStack> zincIngot;
	public static ArrayList<ItemStack> leadIngot;
	public static ArrayList<ItemStack> bronzeIngot;
	public static ArrayList<ItemStack> steelIngot;
	public static ArrayList<ItemStack> aluminiumIngot;
	public static ArrayList<ItemStack> titaniumIngot;
	public static ArrayList<ItemStack> obsidianIngot;
	public static ArrayList<ItemStack> hardenedRedstoneIngot;
	public static ArrayList<ItemStack> hardenedLapisIngot;
	public static ArrayList<ItemStack> electrumIngot;
	public static ArrayList<ItemStack> brassIngot;
	public static ArrayList<ItemStack> hardenedIronIngot;
	public static ArrayList<ItemStack> redstoniteIngot;
	public static ArrayList<ItemStack> uraniumIngot;
	public static ArrayList<ItemStack> nickelIngot;
	
	public static ArrayList<ItemStack> bauxiteDust;
	public static ArrayList<ItemStack> steelDust;
	public static ArrayList<ItemStack> titaniumDust;
	public static ArrayList<ItemStack> spheneDust;
	public static ArrayList<ItemStack> obsidianDust;
	public static ArrayList<ItemStack> aluminiumDust;
	public static ArrayList<ItemStack> lapisDust;
	public static ArrayList<ItemStack> quartzDust;
	public static ArrayList<ItemStack> emeraldDust;
	public static ArrayList<ItemStack> diamondDust;
	public static ArrayList<ItemStack> ironDust;
	public static ArrayList<ItemStack> coalDust;
	public static ArrayList<ItemStack> goldDust;
	public static ArrayList<ItemStack> silverDust;
	public static ArrayList<ItemStack> zincDust;
	public static ArrayList<ItemStack> copperDust;
	public static ArrayList<ItemStack> tinDust;
	public static ArrayList<ItemStack> sandDust;
	public static ArrayList<ItemStack> sandDustHydrated;
	public static ArrayList<ItemStack> hardenedIronDust;
	public static ArrayList<ItemStack> uraniumDust;
	public static ArrayList<ItemStack> brassDust;
	public static ArrayList<ItemStack> bronzeDust;
	public static ArrayList<ItemStack> electrumDust;
	public static ArrayList<ItemStack> whitestoneDust;
	public static ArrayList<ItemStack> cobaltDust;
	public static ArrayList<ItemStack> chromeDust;
	public static ArrayList<ItemStack> nickelDust;
	
	public static ArrayList<ItemStack> diamond;
	public static ArrayList<ItemStack> woodPlank;
	public static ArrayList<ItemStack> diamondStick;
	public static ArrayList<ItemStack> obsidianStick;
	public static ArrayList<ItemStack> glass;
	
	public static ArrayList<ItemStack> blackDye;
	public static ArrayList<ItemStack> redDye;
	public static ArrayList<ItemStack> greenDye;
	public static ArrayList<ItemStack> brownDye;
	public static ArrayList<ItemStack> blueDye;
	public static ArrayList<ItemStack> purpleDye;
	public static ArrayList<ItemStack> cyanDye;
	public static ArrayList<ItemStack> lightGrayDye;
	public static ArrayList<ItemStack> grayDye;
	public static ArrayList<ItemStack> pinkDye;
	public static ArrayList<ItemStack> lightGreenDye;
	public static ArrayList<ItemStack> yellowDye;
	public static ArrayList<ItemStack> lightBlueDye;
	public static ArrayList<ItemStack> magentaDye;
	public static ArrayList<ItemStack> orangeDye;
	public static ArrayList<ItemStack> whiteDye;

	//Sublists
	public static ArrayList<ItemStack> naturalAluminumOre;
	public static ArrayList<ItemStack> aluminumOre;
	public static ArrayList<ItemStack> aluminumIngot;
	public static ArrayList<ItemStack> naturalAluminumIngot;
	public static ArrayList<ItemStack> aluminumDust;
	public static ArrayList<ItemStack> diamondRod;
	public static ArrayList<ItemStack> StickDiamond;
	public static ArrayList<ItemStack> obsidianRod;
	public static ArrayList<ItemStack> StickObsidian;
	
	public static void extractOreLists() { //TODO oredictionary modifications!!
		Evercraft.log.info("Extracting OreDictionary Items...");
		
		//Sublists
		naturalAluminumOre = OreDictionary.getOres("oreNaturalAluminum");
		aluminumOre = OreDictionary.getOres("oreAluminum");
		aluminumIngot = OreDictionary.getOres("ingotAluminum");
		naturalAluminumIngot = OreDictionary.getOres("ingotNaturalAluminum");
		aluminumDust = OreDictionary.getOres("dustAluminum");
		obsidianRod = OreDictionary.getOres("rodObsidian");
		StickObsidian = OreDictionary.getOres("obsidianRod");
		diamondRod = OreDictionary.getOres("rodDiamond");
		StickDiamond = OreDictionary.getOres("diamondRod");
		
		//Ores
		copperOre = OreDictionary.getOres("oreCopper");
		Evercraft.log.info("Extracted " + copperOre.size() + " items of type: " + "oreCopper");
		tinOre = OreDictionary.getOres("oreTin");
		Evercraft.log.info("Extracted " + tinOre.size() + " items of type: " + "oreTin");
		silverOre = OreDictionary.getOres("oreSilver");
		Evercraft.log.info("Extracted " + silverOre.size() + " items of type: " + "oreSilver");
		zincOre = OreDictionary.getOres("oreZinc");
		Evercraft.log.info("Extracted " + zincOre.size() + " items of type: " + "oreZinc");
		leadOre = OreDictionary.getOres("oreLead");
		Evercraft.log.info("Extracted " + leadOre.size() + " items of type: " + "oreLead");
		spheneOre = OreDictionary.getOres("oreSphene");
		Evercraft.log.info("Extracted " + spheneOre.size() + " items of type: " + "oreSphene");
		bauxiteOre = OreDictionary.getOres("oreBauxite");
		Evercraft.log.info("Extracted " + bauxiteOre.size() + " items of type: " + "oreBauxite");
		aluminiumOre = OreDictionary.getOres("oreAluminium");
		Evercraft.log.info("Extracted " + aluminiumOre.size() + " items of type: " + "oreAluminium");
		//aluminiumOre.addAll(naturalAluminumOre);
		//aluminiumOre.addAll(aluminumOre);
		uraniumOre = OreDictionary.getOres("oreUranium");
		Evercraft.log.info("Extracted " + uraniumOre.size() + " items of type: " + "oreUranium");
	
		//Ingots
		copperIngot = OreDictionary.getOres("ingotCopper");
		Evercraft.log.info("Extracted " + copperIngot.size() + " items of type: " + "ingotCopper");
		tinIngot = OreDictionary.getOres("ingotTin");
		Evercraft.log.info("Extracted " + tinIngot.size() + " items of type: " + "ingotTin");
		silverIngot = OreDictionary.getOres("ingotSilver");
		Evercraft.log.info("Extracted " + silverIngot.size() + " items of type: " + "ingotSilver");
		zincIngot = OreDictionary.getOres("ingotZinc");
		Evercraft.log.info("Extracted " + zincIngot.size() + " items of type: " + "ingotZinc");
		leadIngot = OreDictionary.getOres("ingotLead");
		Evercraft.log.info("Extracted " + leadIngot.size() + " items of type: " + "ingotLead");
		bronzeIngot = OreDictionary.getOres("ingotBronze");
		Evercraft.log.info("Extracted " + bronzeIngot.size() + " items of type: " + "ingotBronze");
		steelIngot = OreDictionary.getOres("ingotSteel");
		Evercraft.log.info("Extracted " + steelIngot.size() + " items of type: " + "ingotSteel");
		aluminiumIngot = OreDictionary.getOres("ingotAluminium");
		Evercraft.log.info("Extracted " + aluminiumIngot.size() + " items of type: " + "ingotAluminium");
		titaniumIngot = OreDictionary.getOres("ingotTitanium");
		Evercraft.log.info("Extracted " + titaniumIngot.size() + " items of type: " + "ingotTitanium");
		obsidianIngot = OreDictionary.getOres("ingotObsidian");
		Evercraft.log.info("Extracted " + obsidianIngot.size() + " items of type: " + "ingotObsidian");
		hardenedRedstoneIngot = OreDictionary.getOres("ingotHardenedRedstone");
		Evercraft.log.info("Extracted " + hardenedRedstoneIngot.size() + " items of type: " + "ingotHardenedRedstone");
		hardenedLapisIngot = OreDictionary.getOres("ingotHardenedLapis");
		Evercraft.log.info("Extracted " + hardenedLapisIngot.size() + " items of type: " + "ingotHardenedLapis");
		electrumIngot = OreDictionary.getOres("ingotElectrum");
		Evercraft.log.info("Extracted " + electrumIngot.size() + " items of type: " + "ingotElectrum");
		brassIngot = OreDictionary.getOres("ingotBrass");
		Evercraft.log.info("Extracted " + brassIngot.size() + " items of type: " + "ingotBrass");
		hardenedIronIngot = OreDictionary.getOres("ingotHardenedIron");
		Evercraft.log.info("Extracted " + hardenedIronIngot.size() + " items of type: " + "ingotHardenedIron");
		//aluminiumIngot.addAll(aluminumIngot);
		//aluminiumIngot.addAll(naturalAluminumIngot);
		redstoniteIngot = OreDictionary.getOres("ingotRedstonite");
		Evercraft.log.info("Extracted " + redstoniteIngot.size() + " items of type: " + "ingotRedstonite");
		uraniumIngot = OreDictionary.getOres("ingotUranium");
		Evercraft.log.info("Extracted " + uraniumIngot.size() + " items of type: " + "ingotUranium");
		nickelIngot = OreDictionary.getOres("ingotNickel");
		Evercraft.log.info("Extracted " + nickelIngot.size() + " items of type: " + "ingotNickel");
	
		//Dusts
		bauxiteDust = OreDictionary.getOres("dustBauxite");
		Evercraft.log.info("Extracted " + bauxiteDust.size() + " items of type: " + "dustBauxite");
		steelDust = OreDictionary.getOres("dustSteel");
		Evercraft.log.info("Extracted " + steelDust.size() + " items of type: " + "dustSteel");
		titaniumDust = OreDictionary.getOres("dustTitanium");
		Evercraft.log.info("Extracted " + titaniumDust.size() + " items of type: " + "dustTitanium");
		spheneDust = OreDictionary.getOres("dustSphene");
		Evercraft.log.info("Extracted " + spheneDust.size() + " items of type: " + "dustSphene");
		obsidianDust = OreDictionary.getOres("dustObsidian");
		Evercraft.log.info("Extracted " + obsidianDust.size() + " items of type: " + "dustObsidian");
		aluminiumDust = OreDictionary.getOres("dustAluminium");
		Evercraft.log.info("Extracted " + aluminiumDust.size() + " items of type: " + "dustAluminium");
		lapisDust = OreDictionary.getOres("dustLapis");
		Evercraft.log.info("Extracted " + lapisDust.size() + " items of type: " + "dustLapis");
		quartzDust = OreDictionary.getOres("dustQuartz");
		Evercraft.log.info("Extracted " + quartzDust.size() + " items of type: " + "dustQuartz");
		emeraldDust = OreDictionary.getOres("dustEmerald");
		Evercraft.log.info("Extracted " + emeraldDust.size() + " items of type: " + "dustEmerald");
		diamondDust = OreDictionary.getOres("dustDiamond");
		Evercraft.log.info("Extracted " + diamondDust.size() + " items of type: " + "dustDiamond");
		ironDust = OreDictionary.getOres("dustIron");
		Evercraft.log.info("Extracted " + ironDust.size() + " items of type: " + "dustIron");
		coalDust = OreDictionary.getOres("dustCoal");
		Evercraft.log.info("Extracted " + coalDust.size() + " items of type: " + "dustCoal");
		goldDust = OreDictionary.getOres("dustGold");
		Evercraft.log.info("Extracted " + goldDust.size() + " items of type: " + "dustGold");
		silverDust = OreDictionary.getOres("dustSilver");
		Evercraft.log.info("Extracted " + silverDust.size() + " items of type: " + "dustSilver");
		zincDust = OreDictionary.getOres("dustZinc");
		Evercraft.log.info("Extracted " + zincDust.size() + " items of type: " + "dustZinc");
		tinDust = OreDictionary.getOres("dustTin");
		Evercraft.log.info("Extracted " + tinDust.size() + " items of type: " + "dustTin");
		copperDust = OreDictionary.getOres("dustCopper");
		Evercraft.log.info("Extracted " + copperDust.size() + " items of type: " + "dustCopper");
		hardenedIronDust = OreDictionary.getOres("dustHardenedIron");
		Evercraft.log.info("Extracted " + hardenedIronDust.size() + " items of type: " + "dustHardenedIron");
		//aluminiumDust.addAll(aluminumDust);
		sandDust = OreDictionary.getOres("dustSand");
		Evercraft.log.info("Extracted " + sandDust.size() + " items of type: " + "dustSand");
		sandDustHydrated = OreDictionary.getOres("dustHydratedSand");
		Evercraft.log.info("Extracted " + sandDustHydrated.size() + " items of type: " + "dustHydratedSand");
		uraniumDust = OreDictionary.getOres("dustUranium");
		Evercraft.log.info("Extracted " + uraniumDust.size() + " items of type: " + "dustUranium");
		brassDust = OreDictionary.getOres("dustBrass");
		Evercraft.log.info("Extracted " + brassDust.size() + " items of type: " + "dustBrass");
		bronzeDust = OreDictionary.getOres("dustBronze");
		Evercraft.log.info("Extracted " + bronzeDust.size() + " items of type: " + "dustBronze");
		electrumDust = OreDictionary.getOres("dustElectrum");
		Evercraft.log.info("Extracted " + electrumDust.size() + " items of type: " + "dustElectrum");
		whitestoneDust = OreDictionary.getOres("dustWhitestone");
		Evercraft.log.info("Extracted " + whitestoneDust.size() + " items of type: " + "dustWhitestone");
		chromeDust = OreDictionary.getOres("dustChrome");
		Evercraft.log.info("Extracted: " + chromeDust.size() + " items of type: " + "dustChrome");
		cobaltDust = OreDictionary.getOres("dustCobalt");
		Evercraft.log.info("Extracted: " + cobaltDust.size() + " items of type: " + "dustCobalt");
		nickelDust = OreDictionary.getOres("dustNickel");
		Evercraft.log.info("Extracted: " + nickelDust.size() + " items of type: " + "dustNickel");
	
		//Misc
		diamond = OreDictionary.getOres("gemDiamond");
		Evercraft.log.info("Extracted " + diamond.size() + " items of type: " + "gemDiamond");
		woodPlank = OreDictionary.getOres("plankWood");
		Evercraft.log.info("Extracted " + woodPlank.size() + " items of type: " + "plankWood");
		diamondStick = OreDictionary.getOres("stickDiamond");
		Evercraft.log.info("Extracted " + diamondStick.size() + " items of type: " + "stickDiamond");
		//diamondStick.addAll(diamondRod);
		//diamondStick.addAll(StickDiamond);
		obsidianStick = OreDictionary.getOres("stickObsidian");
		Evercraft.log.info("Extracted " + obsidianStick.size() + " items of type: " + "stickObsidian");
		//obsidianStick.addAll(obsidianRod);
		//obsidianStick.addAll(StickObsidian);
		glass = OreDictionary.getOres("glass");
		Evercraft.log.info("Extracted " + glass.size() + " items of type: " + "glass");
		
		//Dyes
		blackDye = OreDictionary.getOres("dyeBlack");
		Evercraft.log.info("Extracted " + blackDye.size() + " items of type: " + "dyeBlack");
		redDye = OreDictionary.getOres("dyeRed");
		Evercraft.log.info("Extracted " + redDye.size() + " items of type: " + "dyeRed");
		greenDye = OreDictionary.getOres("dyeGreen");
		Evercraft.log.info("Extracted " + greenDye.size() + " items of type: " + "dyeGreen");
		brownDye = OreDictionary.getOres("dyeBrown");
		Evercraft.log.info("Extracted " + brownDye.size() + " items of type: " + "dyeBrown");
		blueDye = OreDictionary.getOres("dyeBlue");
		Evercraft.log.info("Extracted " + blueDye.size() + " items of type: " + "dyeBlue");
		purpleDye = OreDictionary.getOres("dyePurple");
		Evercraft.log.info("Extracted " + purpleDye.size() + " items of type: " + "dyePurple");
		cyanDye = OreDictionary.getOres("dyeCyan");
		Evercraft.log.info("Extracted " + cyanDye.size() + " items of type: " + "dyeCyan");
		lightGrayDye = OreDictionary.getOres("dyeLightGray");
		Evercraft.log.info("Extracted " + lightGrayDye.size() + " items of type: " + "dyeLightGray");
		grayDye = OreDictionary.getOres("dyeGray");
		Evercraft.log.info("Extracted " + grayDye.size() + " items of type: " + "dyeGray");
		pinkDye = OreDictionary.getOres("dyePink");
		Evercraft.log.info("Extracted " + pinkDye.size() + " items of type: " + "dyePink");
		lightGreenDye = OreDictionary.getOres("dyeLime");
		Evercraft.log.info("Extracted " + lightGreenDye.size() + " items of type: " + "dyeLime");
		yellowDye = OreDictionary.getOres("dyeYellow");
		Evercraft.log.info("Extracted " + yellowDye.size() + " items of type: " + "dyeYellow");
		lightBlueDye = OreDictionary.getOres("dyeLightBlue");
		Evercraft.log.info("Extracted " + lightBlueDye.size() + " items of type: " + "dyeLightBlue");
		magentaDye = OreDictionary.getOres("dyeMagenta");
		Evercraft.log.info("Extracted " + magentaDye.size() + " items of type: " + "dyeMagenta");
		orangeDye = OreDictionary.getOres("dyeOrange");
		Evercraft.log.info("Extracted " + orangeDye.size() + " items of type: " + "dyeOrange");
		whiteDye = OreDictionary.getOres("dyeWhite");
		Evercraft.log.info("Extracted " + whiteDye.size() + " items of type: " + "dyeWhite");
	}
}
