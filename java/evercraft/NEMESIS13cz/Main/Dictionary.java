package evercraft.NEMESIS13cz.Main;

import java.util.ArrayList;

import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Utils.MetaInterface;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Dictionary {

	private static MetaInterface meta;
	
	public static void registerOre() {
		
		OreDictionary.registerOre("stickIron", Evercraft_Items.ironstick);
		OreDictionary.registerOre("stickStone", Evercraft_Items.stonestick);
		OreDictionary.registerOre("stickGold", Evercraft_Items.goldstick);
		OreDictionary.registerOre("stickDiamond", Evercraft_Items.diamondstick);
		OreDictionary.registerOre("stickObsidian", Evercraft_Items.obsidianstick);
		OreDictionary.registerOre("stickNether", Evercraft_Items.netherbrickstick);
		OreDictionary.registerOre("rodIron", Evercraft_Items.ironstick);
		OreDictionary.registerOre("rodStone", Evercraft_Items.stonestick);
		OreDictionary.registerOre("rodGold", Evercraft_Items.goldstick);
		OreDictionary.registerOre("rodDiamond", Evercraft_Items.diamondstick);
		OreDictionary.registerOre("rodObsidian", Evercraft_Items.obsidianstick);
		OreDictionary.registerOre("rodNether", Evercraft_Items.netherbrickstick);
		OreDictionary.registerOre("ironRod", Evercraft_Items.ironstick);
		OreDictionary.registerOre("stoneRod", Evercraft_Items.stonestick);
		OreDictionary.registerOre("goldRod", Evercraft_Items.goldstick);
		OreDictionary.registerOre("diamondRod", Evercraft_Items.diamondstick);
		OreDictionary.registerOre("obsidianRod", Evercraft_Items.obsidianstick);
		OreDictionary.registerOre("netherRod", Evercraft_Items.netherbrickstick);
		
		OreDictionary.registerOre("ingotSilver", Evercraft_Items.silveringot);
		OreDictionary.registerOre("ingotCopper", Evercraft_Items.copperingot);
		OreDictionary.registerOre("ingotTin", Evercraft_Items.tiningot);
		OreDictionary.registerOre("ingotZinc", Evercraft_Items.zincingot);
		OreDictionary.registerOre("ingotBronze", Evercraft_Items.bronzeingot);
		OreDictionary.registerOre("ingotSteel", Evercraft_Items.steelingot);
		OreDictionary.registerOre("ingotAluminum", Evercraft_Items.aluminiumingot);
		OreDictionary.registerOre("ingotAluminium", Evercraft_Items.aluminiumingot);
		OreDictionary.registerOre("ingotTitanium", Evercraft_Items.titaniumingot);
		OreDictionary.registerOre("ingotObsidian", Evercraft_Items.obsidianingot);
		OreDictionary.registerOre("ingotHardenedRedstone", Evercraft_Items.hardenedredstoneingot);
		OreDictionary.registerOre("ingotHardenedLapis", Evercraft_Items.hardenedlapisingot);
		OreDictionary.registerOre("ingotElectrum", Evercraft_Items.electrumingot);
		OreDictionary.registerOre("ingotBrass", Evercraft_Items.brassingot);
		OreDictionary.registerOre("ingotLead", Evercraft_Items.leadingot);
		OreDictionary.registerOre("ingotHardenedIron", Evercraft_Items.hardenedironingot);
		OreDictionary.registerOre("ingotRedstonite", Evercraft_Items.redstoniteingot);
		OreDictionary.registerOre("ingotNickel", Evercraft_Items.nickelIngot);
		
		OreDictionary.registerOre("dustSilver", Evercraft_Items.silverdust);
		OreDictionary.registerOre("dustCopper", Evercraft_Items.copperdust);
		OreDictionary.registerOre("dustCoal", Evercraft_Items.coaldust);
		OreDictionary.registerOre("dustTin", Evercraft_Items.tindust);
		OreDictionary.registerOre("dustZinc", Evercraft_Items.zincdust);
		OreDictionary.registerOre("dustBronze", Evercraft_Items.bronzedust);
		OreDictionary.registerOre("dustSteel", Evercraft_Items.steeldust);
		OreDictionary.registerOre("dustQuartz", Evercraft_Items.quartzdust);
		OreDictionary.registerOre("dustAluminum", Evercraft_Items.aluminiumdust);
		OreDictionary.registerOre("dustAluminium", Evercraft_Items.aluminiumdust);
		OreDictionary.registerOre("dustObsidian", Evercraft_Items.obsidiandust);
		OreDictionary.registerOre("dustDiamond", Evercraft_Items.diamonddust);
		OreDictionary.registerOre("dustEmerald", Evercraft_Items.emeralddust);
		OreDictionary.registerOre("dustLapis", Evercraft_Items.lapislazulidust);
		OreDictionary.registerOre("dustIron", Evercraft_Items.irondust);
		OreDictionary.registerOre("dustGold", Evercraft_Items.golddust);
		OreDictionary.registerOre("dustBauxite", Evercraft_Items.bauxitedust);
		OreDictionary.registerOre("dustTitanium", Evercraft_Items.titaniumdust);
		OreDictionary.registerOre("dustSlime", Evercraft_Items.stickydust);
		OreDictionary.registerOre("dustElectrum", Evercraft_Items.electrumdust);
		OreDictionary.registerOre("dustBrass", Evercraft_Items.brassdust);
		OreDictionary.registerOre("dustSphene", Evercraft_Items.sphenedust);
		OreDictionary.registerOre("dustLead", Evercraft_Items.leaddust);
		OreDictionary.registerOre("dustSand", new ItemStack(Evercraft_Items.sanddust,1,0));
		OreDictionary.registerOre("dustHydratedSand", new ItemStack(Evercraft_Items.sanddust,1,1));
		OreDictionary.registerOre("dustHardenedIron", Evercraft_Items.hardenedirondust);
		OreDictionary.registerOre("dustHardenedLapis", Evercraft_Items.hardenedlapisdust);
		OreDictionary.registerOre("dustHardenedRedstone", Evercraft_Items.hardenedredstonedust);
		OreDictionary.registerOre("dustStone", Evercraft_Items.stonedust);
		OreDictionary.registerOre("dustWhitestone", Evercraft_Items.whitestonedust);
		OreDictionary.registerOre("dustAsh", Evercraft_Items.ash);
		OreDictionary.registerOre("dustCobalt", Evercraft_Items.cobaltDust);
		OreDictionary.registerOre("dustChrome", Evercraft_Items.chromiumDust);
		OreDictionary.registerOre("dustNickel", Evercraft_Items.nickelDust);
		
		OreDictionary.registerOre("dustSmallSilver", Evercraft_Items.silverpowder);
		OreDictionary.registerOre("dustSmallCopper", Evercraft_Items.copperpowder);
		OreDictionary.registerOre("dustSmallTin", Evercraft_Items.tinpowder);
		OreDictionary.registerOre("dustSmallZinc", Evercraft_Items.zincpowder);
		OreDictionary.registerOre("dustSmallBronze", Evercraft_Items.bronzepowder);
		OreDictionary.registerOre("dustSmallSteel", Evercraft_Items.steelpowder);
		OreDictionary.registerOre("dustSmallObsidian", Evercraft_Items.obsidianpowder);
		OreDictionary.registerOre("dustSmallCoal", Evercraft_Items.coalpowder);
		OreDictionary.registerOre("dustSmallDiamond", Evercraft_Items.diamondpowder);
		OreDictionary.registerOre("dustSmallEmerald", Evercraft_Items.emeraldpowder);
		OreDictionary.registerOre("dustSmallLapis", Evercraft_Items.lapispowder);
		OreDictionary.registerOre("dustSmallIron", Evercraft_Items.ironpowder);
		OreDictionary.registerOre("dustSmallGold", Evercraft_Items.goldpowder);
		OreDictionary.registerOre("dustSmallRedstone", Evercraft_Items.redstonepowder);
		OreDictionary.registerOre("dustSmallBauxite", Evercraft_Items.bauxitepowder);
		OreDictionary.registerOre("dustSmallTitanium", Evercraft_Items.titaniumpowder);
		OreDictionary.registerOre("dustSmallAluminium", Evercraft_Items.aluminiumpowder);
		OreDictionary.registerOre("dustSmallAluminum", Evercraft_Items.aluminiumpowder);
		OreDictionary.registerOre("dustSmallQuartz", Evercraft_Items.quartzpowder);
		OreDictionary.registerOre("dustSmallElectrum", Evercraft_Items.electrumpowder);
		OreDictionary.registerOre("dustSmallBrass", Evercraft_Items.brasspowder);
		OreDictionary.registerOre("dustSmallSphene", Evercraft_Items.sphenepowder);
		OreDictionary.registerOre("dustSmallLead", Evercraft_Items.leadpowder);
		OreDictionary.registerOre("dustSmallHardenedIron", Evercraft_Items.hardenedironpowder);
		OreDictionary.registerOre("dustSmallHardenedLapis", Evercraft_Items.hardenedlapispowder);
		OreDictionary.registerOre("dustSmallHardenedRedstone", Evercraft_Items.hardenedredstonepowder);
		OreDictionary.registerOre("dustSmallNickel", Evercraft_Items.nickelPowder);
		
		OreDictionary.registerOre("plateIron", new ItemStack(Evercraft_Items.plate, 1, 0));
		OreDictionary.registerOre("plateGold", new ItemStack(Evercraft_Items.plate, 1, 1));
		OreDictionary.registerOre("plateZinc", new ItemStack(Evercraft_Items.plate, 1, 2));
		OreDictionary.registerOre("plateEmerald", new ItemStack(Evercraft_Items.plate, 1, 3));
		OreDictionary.registerOre("plateDiamond", new ItemStack(Evercraft_Items.plate, 1, 4));
		OreDictionary.registerOre("plateAluminium", new ItemStack(Evercraft_Items.plate, 1, 5));
		OreDictionary.registerOre("plateBronze", new ItemStack(Evercraft_Items.plate, 1, 6));
		OreDictionary.registerOre("plateSteel", new ItemStack(Evercraft_Items.plate, 1, 7));
		OreDictionary.registerOre("plateTin", new ItemStack(Evercraft_Items.plate, 1, 8));
		OreDictionary.registerOre("plateCopper", new ItemStack(Evercraft_Items.plate, 1, 9));
		OreDictionary.registerOre("plateQuartz", new ItemStack(Evercraft_Items.plate, 1, 10));
		OreDictionary.registerOre("plateSilver", new ItemStack(Evercraft_Items.plate, 1, 11));
		OreDictionary.registerOre("plateTitanium", new ItemStack(Evercraft_Items.plate, 1, 12));
		OreDictionary.registerOre("plateBrass", new ItemStack(Evercraft_Items.plate, 1, 13));
		OreDictionary.registerOre("plateElectrum", new ItemStack(Evercraft_Items.plate, 1, 14));
		OreDictionary.registerOre("plateHardenedIron", new ItemStack(Evercraft_Items.plate, 1, 15));
		OreDictionary.registerOre("plateHardenedRedstone", new ItemStack(Evercraft_Items.plate, 1, 16));
		OreDictionary.registerOre("plateHardenedLapis", new ItemStack(Evercraft_Items.plate, 1, 17));
		OreDictionary.registerOre("plateLapis", new ItemStack(Evercraft_Items.plate, 1, 18));
		OreDictionary.registerOre("plateRedstone", new ItemStack(Evercraft_Items.plate, 1, 19));
		OreDictionary.registerOre("plateGlowstone", new ItemStack(Evercraft_Items.plate, 1, 20));
		OreDictionary.registerOre("plateRedstonite", new ItemStack(Evercraft_Items.plate, 1, 21));
		OreDictionary.registerOre("plateObsidian", new ItemStack(Evercraft_Items.plate, 1, 22));
		OreDictionary.registerOre("plateNickel", new ItemStack(Evercraft_Items.plate, 1, meta.plateNickel));
		
		OreDictionary.registerOre("nuggetIron", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetIron));
		OreDictionary.registerOre("nuggetZinc", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetZinc));
		OreDictionary.registerOre("nuggetTin", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetTin));
		OreDictionary.registerOre("nuggetCopper", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetCopper));
		OreDictionary.registerOre("nuggetLead", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetLead));
		OreDictionary.registerOre("nuggetTitanium", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetTitanium));
		OreDictionary.registerOre("nuggetSteel", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetSteel));
		OreDictionary.registerOre("nuggetSilver", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetSilver));
		OreDictionary.registerOre("nuggetObsidian", new ItemStack(Evercraft_Items.metaNugget, 1, MetaInterface.nuggetObsidian));
		
		OreDictionary.registerOre("oreSilver", Evercraft_Blocks.blocksilverore);
		OreDictionary.registerOre("oreCopper", Evercraft_Blocks.blockcopperore);
		OreDictionary.registerOre("oreTin", Evercraft_Blocks.blocktinore);
		OreDictionary.registerOre("oreZinc", Evercraft_Blocks.blockzincore);
		OreDictionary.registerOre("oreBauxite", Evercraft_Blocks.blockbauxiteore);
		OreDictionary.registerOre("oreSphene", Evercraft_Blocks.blockspheneore);
		OreDictionary.registerOre("oreLead", Evercraft_Blocks.blockleadore);
		
		OreDictionary.registerOre("craftingHardHammer", new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("craftingGrinder", Evercraft_Items.diamondgrinder);
		OreDictionary.registerOre("craftingWorkBench", Evercraft_Blocks.blockfurniturecrafter);
		OreDictionary.registerOre("craftingElectricFurnace", Evercraft_Blocks.blockindustrialfurnaceOff);
		OreDictionary.registerOre("craftingElectricFurnace", Evercraft_Blocks.blockindustrialfurnaceOn);
		OreDictionary.registerOre("dyeBlue", Evercraft_Items.lapislazulidust);
		OreDictionary.registerOre("glass", Blocks.glass);
		OreDictionary.registerOre("glass", Evercraft_Blocks.blockclearglass);
		OreDictionary.registerOre("glass", Evercraft_Blocks.blockclearglassglowing);
		OreDictionary.registerOre("glass", Evercraft_Blocks.blockvanillaglassglowing);
		for (int i = 0; i < 16; i++) {
			OreDictionary.registerOre("glass", new ItemStack(Evercraft_Blocks.blockcoloredglassclear, 1, i));
			OreDictionary.registerOre("glass", new ItemStack(Evercraft_Blocks.blockcoloredglassclearglowing, 1, i));
			OreDictionary.registerOre("glass", new ItemStack(Evercraft_Blocks.blockcoloredglassglowing, 1, i));
		}
		OreDictionary.registerOre("blockGlass", Evercraft_Blocks.blockclearglass);
		OreDictionary.registerOre("blockGlass", Evercraft_Blocks.blockclearglassglowing);
		OreDictionary.registerOre("blockGlass", Evercraft_Blocks.blockvanillaglassglowing);
		for (int i = 0; i < 16; i++) {
			OreDictionary.registerOre("blockGlass", new ItemStack(Evercraft_Blocks.blockcoloredglassclear, 1, i));
			OreDictionary.registerOre("blockGlass", new ItemStack(Evercraft_Blocks.blockcoloredglassclearglowing, 1, i));
			OreDictionary.registerOre("blockGlass", new ItemStack(Evercraft_Blocks.blockcoloredglassglowing, 1, i));
		}
		OreDictionary.registerOre("stone", new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 0));
		OreDictionary.registerOre("cobblestone", new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 1));
		OreDictionary.registerOre("logOak", new ItemStack(Blocks.log, 1, 0));
		OreDictionary.registerOre("logBirch", new ItemStack(Blocks.log, 1, 1));
		OreDictionary.registerOre("logSpruce", new ItemStack(Blocks.log, 1, 2));
		OreDictionary.registerOre("logJungle", new ItemStack(Blocks.log, 1, 3));
		OreDictionary.registerOre("logAcacia", new ItemStack(Blocks.log2, 1, 0));
		OreDictionary.registerOre("logDarkOak", new ItemStack(Blocks.log2, 1, 1));
		OreDictionary.registerOre("plankOak", new ItemStack(Blocks.planks, 1, 0));
		OreDictionary.registerOre("plankBirch", new ItemStack(Blocks.planks, 1, 1));
		OreDictionary.registerOre("plankSpruce", new ItemStack(Blocks.planks, 1, 2));
		OreDictionary.registerOre("plankJungle", new ItemStack(Blocks.planks, 1, 3));
		OreDictionary.registerOre("plankAcacia", new ItemStack(Blocks.planks, 1, 4));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(Blocks.planks, 1, 5));
		
		if (Evercraft_Config_Base.gregTechMODE == false) {
			OreDictionary.registerOre("craftingRawMachineTier00", Evercraft_Blocks.blockcasing1);
			OreDictionary.registerOre("craftingRawMachineTier01", Evercraft_Blocks.blockcasing1);
			OreDictionary.registerOre("craftingRawMachineTier02", Evercraft_Blocks.blockcasing2);
			OreDictionary.registerOre("craftingRawMachineTier03", Evercraft_Blocks.blockcasing3);
		}
		
		Evercraft.log.info("Ore Dictionary registered");
	}
}
