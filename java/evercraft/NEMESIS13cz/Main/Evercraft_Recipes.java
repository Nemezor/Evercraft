package evercraft.NEMESIS13cz.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Utils.MetaInterface;


public class Evercraft_Recipes {
	
	private static MetaInterface meta;

	public static void init() {

	//ORE SENSITIVE
		//SHAPED
	
	//temporary!!!
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockHyperenergeticRepeater, 4), new Object[] {" g ", "rrr", "sss", 's', new ItemStack(Blocks.stone_slab, 1, 0), 'r', Items.redstone, 'g', "plateGlowstone"}));
	//
		
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machineSieve, 1), new Object[] {"iii", "iii", "iii", 'i', "stickIron"}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machineSieve, 1), new Object[] {"iii", "iii", "iii", 'i', "rodIron"}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machineSieve, 1), new Object[] {"iii", "iii", "iii", 'i', "ironRod"}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockEnricherOff, 1), new Object[] {"iii", "CgC", "csa", 'i', "plateIron", 'C', "craftingRawMachineTier02", 's', Evercraft_Items.machineSieve, 'g', Evercraft_Items.irongrinder, 'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), 'a', Evercraft_Items.energyabsorber}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockorefactoryOff, 1), new Object[] {"ttt", "CFE", "cSc", 'F', "craftingElectricFurnace", 'C', Evercraft_Blocks.blockadvancedcrusherOff, 'E', Evercraft_Blocks.blockadvancedelectrolyzerOff, 't', new ItemStack(Evercraft_Items.smallplate, 1, 12), 'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 0), 'S', new ItemStack(Evercraft_Items.mediumplate, 1, 7)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeFast, 6), new Object[] {"ppp", "ggg", "ppp", 'p', "plateRedstonite", 'g', Blocks.glass_pane}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeNormal_1, 8), new Object[] {"ppp", "ggg", "ppp", 'p', "plateBrass", 'g', Blocks.glass_pane}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeNormal_2, 8), new Object[] {"ppp", "ggg", "ppp", 'p', "plateBronze", 'g', Blocks.glass_pane}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeCrossing, 6), new Object[] {"ppp", "ggg", "ppp", 'p', "plateHardenedIron", 'g', Blocks.glass_pane}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeExtraction1, 4), new Object[] {"ppp", "hgh", "ppp", 'p', "plateIron", 'g', Blocks.glass_pane, 'h', Blocks.hopper}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockItemPipeExtraction2, 4), new Object[] {"ppp", "hgh", "ppp", 'p', "plateSteel", 'g', Blocks.glass_pane, 'h', Blocks.hopper}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockCapStorage, 1), new Object[] {"iki", "ccc", "CiC", 'i', "plateIron", 'C', "craftingRawMachineTier02", 'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 2), 'k', Evercraft_Blocks.blockredstonitecable}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcuttingmachineOff, 1), new Object[] {"iii", "Ppg", "cCa", 'i', "plateTitanium", 'p', "plateHardenedIron", 'P', Blocks.piston, 'g', "craftingGrinder", 'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 2), 'C', "craftingRawMachineTier02", 'a', Evercraft_Items.energyabsorber}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new Object[] {"r l", " o ", "l r", 'o', "plateObsidian", 'r', "plateRedstone", 'l', "plateLapis"}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockpotionspreader, 1), new Object[] {"pbp", "sCs", "psp", 'p', "plateHardenedIron", 's', "stone", 'C', "craftingRawMachineTier03", 'b', Items.glass_bottle}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockalloyfurnaceOff, 1), new Object[] {"iii", "FhF", "cca", 'i', "plateIron", 'h', "plateHardenedIron", 'F', "craftingElectricFurnace", 'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), 'a', Evercraft_Items.energyabsorber}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.electromagnet,1), new Object[]{"pmp"," c ",'m',Evercraft_Items.magnet,'p',"plateTin",'c',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockbasicspawner,1), new Object[]{"ggg","gSg","ggg",'g',"stickStone",'S',Blocks.iron_bars,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockbasicspawner,1), new Object[]{"ggg","gSg","ggg",'g',"rodStone",'S',Blocks.iron_bars,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockbasicspawner,1), new Object[]{"ggg","gSg","ggg",'g',"stoneRod",'S',Blocks.iron_bars,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockironspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockbasicspawner,'S',"stickIron",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockgoldspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockironspawner,'S',"stickGold",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockdiamondspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockgoldspawner,'S',"stickDiamond",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockobsidianspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockdiamondspawner,'S',"stickObsidian",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockironspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockbasicspawner,'S',"rodIron",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockgoldspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockironspawner,'S',"rodGold",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockdiamondspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockgoldspawner,'S',"rodDiamond",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockobsidianspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockdiamondspawner,'S',"rodObsidian",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockironspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockbasicspawner,'S',"ironRod",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockgoldspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockironspawner,'S',"goldRod",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockdiamondspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockgoldspawner,'S',"diamondRod",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockobsidianspawner,1), new Object[]{"SSS","SBS","SSS",'B',Evercraft_Blocks.blockdiamondspawner,'S',"obsidianRod",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockfurniturecrafter,1), new Object[]{"www","PpA","ppp",'p',"plankWood",'w',"logWood",'P',Items.iron_pickaxe,'A',Items.iron_axe,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockfurniturecrafter,1), new Object[]{"www","ApP","ppp",'p',"plankWood",'w',"logWood",'P',Items.iron_pickaxe,'A',Items.iron_axe,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.stopsign,5), new Object[]{"sds"," s ","s s",'s',"stickWood",'d',"dyeRed",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.derpyingot,1,0), new Object[]{"tot","oDo","tot",'t', "ingotTitanium",'o', "dustObsidian",'D',Blocks.diamond_block,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.glowstoneharvester,1), new Object[]{"sR "," sR","w s",'w',"stickWood",'s',"stickStone",'R',Blocks.redstone_block, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.glowstoneharvester,1), new Object[]{"sR "," sR","w s",'w',"stickWood",'s',"rodStone",'R',Blocks.redstone_block, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.glowstoneharvester,1), new Object[]{"sR "," sR","w s",'w',"stickWood",'s',"stoneRod",'R',Blocks.redstone_block, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.stonestick,4), new Object[]{"i","i",'i',Blocks.cobblestone, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ironstick,4), new Object[]{"i","i",'i',Items.iron_ingot, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.goldstick,4), new Object[]{"i","i",'i',Items.gold_ingot, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondstick,4), new Object[]{"i","i",'i',Items.diamond, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.netherbrickstick,4), new Object[]{"i","i",'i',Items.netherbrick, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidianstick,4), new Object[]{"i","i",'i',Blocks.obsidian, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidianharvester,1), new Object[]{"  r"," s ","s  ",'s',"stickGold",'r',Evercraft_Items.redstoniteingot, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidianharvester,1), new Object[]{"  r"," s ","s  ",'s',"rodGold",'r',Evercraft_Items.redstoniteingot, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidianharvester,1), new Object[]{"  r"," s ","s  ",'s',"goldRod",'r',Evercraft_Items.redstoniteingot, }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperhelmet,1), new Object[]{"iii","i i",'i',"ingotCopper", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelhelmet,1), new Object[]{"iii","i i",'i',"ingotSteel", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzehelmet,1), new Object[]{"iii","i i",'i',"ingotBronze", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperchestplate,1), new Object[]{"i i","iii","iii",'i',"ingotCopper", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelchestplate,1), new Object[]{"i i","iii","iii",'i',"ingotSteel", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzechestplate,1), new Object[]{"i i","iii","iii", 'i',"ingotBronze", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperleggings,1), new Object[]{"iii","i i","i i",'i',"ingotCopper", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelleggings,1), new Object[]{"iii","i i","i i",'i',"ingotSteel", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzeleggings,1), new Object[]{"iii","i i","i i", 'i',"ingotBronze", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperboots,1), new Object[]{"i i","i i",'i',"ingotCopper", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelboots,1), new Object[]{"i i","i i",'i',"ingotSteel", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzeboots,1), new Object[]{"i i","i i", 'i',"ingotBronze", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonehelmet,1), new Object[]{"iii","i i",'i',"ingotHardenedRedstone", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapishelmet,1), new Object[]{"iii","i i",'i',"ingotHardenedLapis", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonechestplate,1), new Object[]{"i i","iii","iii",'i',"ingotHardenedRedstone", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapischestplate,1), new Object[]{"i i","iii","iii",'i',"ingotHardenedLapis", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstoneleggings,1), new Object[]{"iii","i i","i i",'i',"ingotHardenedRedstone", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisleggings,1), new Object[]{"iii","i i","i i",'i',"ingotHardenedLapis", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstoneboots,1), new Object[]{"i i","i i",'i',"ingotHardenedRedstone", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisboots,1), new Object[]{"i i","i i",'i',"ingotHardenedLapis", }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ironarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', Items.iron_ingot}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.goldarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', Items.gold_ingot}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "gemDiamond"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "ingotCopper"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzearrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "ingotBronze"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "ingotSteel"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonearrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "ingotHardenedRedstone"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', "ingotHardenedLapis"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', Evercraft_Items.obsidiumgem}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperpickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzepickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',"ingotBronze",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelpickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',"ingotSteel",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonepickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',"ingotHardenedRedstone",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapispickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',"ingotHardenedLapis",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.coppershovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzeshovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',"ingotBronze",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelshovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',"ingotSteel",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstoneshovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',"ingotHardenedRedstone",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisshovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',"ingotHardenedLapis",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzeaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',"ingotBronze",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',"ingotSteel",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstoneaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',"ingotHardenedRedstone",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',"ingotHardenedLapis",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.coppersword,1), new Object[]{"i","i","s",'s',"stickWood",'i',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzesword,1), new Object[]{"i","i","s",'s',"stickWood",'i',"ingotBronze",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelsword,1), new Object[]{"i","i","s",'s',"stickWood",'i',"ingotSteel",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonesword,1), new Object[]{"i","i","s",'s',"stickWood",'i',"ingotHardenedRedstone",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapissword,1), new Object[]{"i","i","s",'s',"stickWood",'i',"ingotHardenedLapis",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperhoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',"ingotCopper",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzehoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',"ingotBronze",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelhoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',"ingotSteel",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonehoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',"ingotHardenedRedstone",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapishoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',"ingotHardenedLapis",	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.photovoltaicpanel,1), new Object[]{"ppp","ppp","ppp",'p', Evercraft_Items.photovoltaiccell	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.photovoltaiccell, 1), new Object[]{"ggg", "rlr", "sss", 'g', "glass", 's', Evercraft_Items.siliconwafer, 'r', Evercraft_Items.redstonitewire, 'l', "dustLapis"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.photovoltaiccell, 1), new Object[]{"ggg", "rlr", "sss", 'g', "blockGlass", 's', Evercraft_Items.siliconwafer, 'r', Evercraft_Items.redstonitewire, 'l', "dustLapis"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.woolcard, 1), new Object[]{"si ", " si", "s s", 's',"stickWood",'i', Items.iron_ingot }));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.upgradePipeRouting, 12), new Object[]{"RiR", "iii", "RiR", 'R', "dyeRed", 'i', "plateHardenedIron"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.upgradeRedstone, 1), new Object[]{"RiR", "iii", "RiR", 'R', Blocks.redstone_block, 'i', "plateHardenedIron"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.upgradeMining, 1), new Object[]{"RiR", "iii", "RiR", 'R', new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE), 'i', "plateHardenedIron"}));
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateIron), new Object[]{"h", "i", "i", 'i', Items.iron_ingot, 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateGold), new Object[]{"h", "i", "i", 'i', Items.gold_ingot, 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)});
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateSilver), new Object[]{"h", "i", "i", 'i', "ingotSilver", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateZinc), new Object[]{"h", "i", "i", 'i', "ingotZinc", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateCopper), new Object[]{"h", "i", "i", 'i', "ingotCopper", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateTin), new Object[]{"h", "i", "i", 'i', "ingotTin", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateBrass), new Object[]{"h", "i", "i", 'i', "ingotBrass", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.plate, 1, meta.plateBronze), new Object[]{"h", "i", "i", 'i', "ingotBronze", 'h', new ItemStack(Evercraft_Items.hammer, 1, OreDictionary.WILDCARD_VALUE)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.hammer, 1), new Object[]{"iii", "iii", " s ", 'i', Items.iron_ingot, 's', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockWRSreceiverOff, 1), new Object[] {"prp", "rer", "prp", 'p', "plateHardenedIron", 'e', Items.ender_pearl, 'r', Items.redstone,}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockWRStransmitter, 1), new Object[] {"ppp", "pep", "prp", 'p', "plateHardenedIron", 'e', Items.ender_pearl, 'r', Items.redstone,}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.WRScoordinator, 1), new Object[] {"rg", "pp", "pp", 'p', "plateHardenedIron", 'g', Items.glowstone_dust, 'r', Items.redstone,}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.iron_ingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetIron"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.silveringot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetSilver"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetSteel"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidianingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetObsidian"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.zincingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetZinc"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetCopper"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.tiningot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetTin"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.leadingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetLead"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.titaniumingot, 1), new Object[] {"nnn", "nnn", "nnn", 'n', "nuggetTitanium"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ashFilter, 1), new Object[] {" pp", "ppp", "pp ", 'p', "plateIron"}));

	Evercraft.log.info("Recipes registered: phase 1");
	
	//ORE SENSITIVE
		//SHAPELESS
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,0), new Object[]{	"dyeBlack", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,1), new Object[]{	"dyeRed", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,2), new Object[]{	"dyeGreen", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,3), new Object[]{	"dyeBrown", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,4), new Object[]{	"dyeBlue", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,5), new Object[]{	"dyePurple", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,6), new Object[]{	"dyeCyan", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,7), new Object[]{	"dyeLightGray", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,8), new Object[]{	"dyeGray", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,9), new Object[]{	"dyePink", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,10), new Object[]{	"dyeLime", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,11), new Object[]{	"dyeYellow", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,12), new Object[]{	"dyeLightBlue", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,13), new Object[]{	"dyeMagenta", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,14), new Object[]{	"dyeOrange", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.coloredslimeball,1,15), new Object[]{	"dyeWhite", Evercraft_Items.stickydust, Evercraft_Items.stickydust,	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.copperpowder, 2), new Object[]{	 Items.flint, "oreCopper"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.tinpowder, 2), new Object[]{	 Items.flint, "oreTin"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.sphenepowder, 3), new Object[]{	 Items.flint, "oreSphene"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.leadpowder, 2), new Object[]{	 Items.flint, "oreLead"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.silverpowder, 2), new Object[]{	 Items.flint, "oreSilver"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.bauxitepowder, 2), new Object[]{	 Items.flint, "oreBauxite"	}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Evercraft_Items.zincpowder, 2), new Object[]{	 Items.flint, "oreZinc"	}));

	Evercraft.log.info("Recipes registered: phase 2");
	
	//NORMAL
		//SHAPED
	GameRegistry.addRecipe(new ItemStack(Evercraft_Blocks.blockobsidiumblock,1), new Object[]{"iii","iii","iii",'i',Evercraft_Items.obsidiumingot,	});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Blocks.blockderpyblock,1), new Object[]{"iii","iii","iii",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),	});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.magnet,4), new Object[]{"mm",'m',Evercraft_Items.magneticlump,	});
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumpickaxe,1), new Object[]{"iii"," s "," s ",'s',"stickWood",'i',Evercraft_Items.obsidiumgem,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumshovel,1), new Object[]{"i","s","s",'s',"stickWood",'i',Evercraft_Items.obsidiumgem,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumaxe,1), new Object[]{"ii","is"," s",'s',"stickWood",'i',Evercraft_Items.obsidiumgem,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumsword,1), new Object[]{"i","i","s",'s',"stickWood",'i',Evercraft_Items.obsidiumgem,	}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.obsidiumhoe,1), new Object[]{"ii"," s"," s",'s',"stickWood",'i',Evercraft_Items.obsidiumgem,	}));
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.obsidiumhelmet,1), new Object[]{"iii","i i",'i',Evercraft_Items.obsidiumgem});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.obsidiumchestplate,1), new Object[]{"i i","iii","iii",'i',Evercraft_Items.obsidiumgem});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.obsidiumleggings,1), new Object[]{"iii","i i","i i",'i',Evercraft_Items.obsidiumgem});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.obsidiumboots,1), new Object[]{"i i","i i",'i',Evercraft_Items.obsidiumgem});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.obsidiumbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', Evercraft_Items.obsidiumgem});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Blocks.blockredstoniteblock,1), new Object[]{"iii","iii","iii",'i',Evercraft_Items.redstoniteingot,	});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Blocks.blocksmileblock, 1), new Object[]{"ii","ii",'i',Evercraft_Items.smilespawner,	});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Blocks.blockwhitestone, 4, 2), new Object[]{"ii","ii",'i',new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 0),	});
	GameRegistry.addRecipe(new ItemStack(Evercraft_Items.glassTube, 5), new Object[] {"g g", "g g", " g ", 'g', Evercraft_Items.moltenglass});
	
	Evercraft.log.info("Recipes registered: phase 3");
	
	//NORMAL
		//SHAPELESS
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.ironpowder,4), new Object[]{	Evercraft_Items.irondust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.leadpowder,4), new Object[]{	Evercraft_Items.leaddust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.goldpowder,4), new Object[]{	Evercraft_Items.golddust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.diamondpowder,4), new Object[]{	Evercraft_Items.diamonddust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.emeraldpowder,4), new Object[]{	Evercraft_Items.emeralddust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.coalpowder,4), new Object[]{	Evercraft_Items.coaldust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.tinpowder,4), new Object[]{	Evercraft_Items.tindust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.copperpowder,4), new Object[]{	Evercraft_Items.copperdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.silverpowder,4), new Object[]{	Evercraft_Items.silverdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.bauxitepowder,4), new Object[]{	Evercraft_Items.bauxitedust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.aluminiumpowder,4), new Object[]{	Evercraft_Items.aluminiumdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.titaniumpowder,4), new Object[]{	Evercraft_Items.titaniumdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.redstonepowder,4), new Object[]{	Items.redstone,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.leaddust,1), new Object[]{	Evercraft_Items.leadpowder,Evercraft_Items.leadpowder,Evercraft_Items.leadpowder,Evercraft_Items.leadpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.irondust,1), new Object[]{	Evercraft_Items.ironpowder,Evercraft_Items.ironpowder,Evercraft_Items.ironpowder,Evercraft_Items.ironpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.golddust,1), new Object[]{	Evercraft_Items.goldpowder,Evercraft_Items.goldpowder,Evercraft_Items.goldpowder,Evercraft_Items.goldpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.diamonddust,1), new Object[]{	Evercraft_Items.diamondpowder,Evercraft_Items.diamondpowder,Evercraft_Items.diamondpowder,Evercraft_Items.diamondpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.emeralddust,1), new Object[]{	Evercraft_Items.emeraldpowder,Evercraft_Items.emeraldpowder,Evercraft_Items.emeraldpowder,Evercraft_Items.emeraldpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.coaldust,1), new Object[]{	Evercraft_Items.coalpowder,Evercraft_Items.coalpowder,Evercraft_Items.coalpowder,Evercraft_Items.coalpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.tindust,1), new Object[]{	Evercraft_Items.tinpowder,Evercraft_Items.tinpowder,Evercraft_Items.tinpowder,Evercraft_Items.tinpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.copperdust,1), new Object[]{	Evercraft_Items.copperpowder,Evercraft_Items.copperpowder,Evercraft_Items.copperpowder,Evercraft_Items.copperpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.silverdust,1), new Object[]{	Evercraft_Items.silverpowder,Evercraft_Items.silverpowder,Evercraft_Items.silverpowder,Evercraft_Items.silverpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.bauxitedust,1), new Object[]{	Evercraft_Items.bauxitepowder,Evercraft_Items.bauxitepowder,Evercraft_Items.bauxitepowder,Evercraft_Items.bauxitepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.aluminiumdust,1), new Object[]{	Evercraft_Items.aluminiumpowder,Evercraft_Items.aluminiumpowder,Evercraft_Items.aluminiumpowder,Evercraft_Items.aluminiumpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.titaniumdust,1), new Object[]{	Evercraft_Items.titaniumpowder,Evercraft_Items.titaniumpowder,Evercraft_Items.titaniumpowder,Evercraft_Items.titaniumpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone,1), new Object[]{	Evercraft_Items.redstonepowder,Evercraft_Items.redstonepowder,Evercraft_Items.redstonepowder,Evercraft_Items.redstonepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.lapislazulidust,1), new Object[]{	Evercraft_Items.lapispowder,Evercraft_Items.lapispowder,Evercraft_Items.lapispowder,Evercraft_Items.lapispowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.lapispowder,4), new Object[]{	Evercraft_Items.lapislazulidust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.steelpowder,4), new Object[]{	Evercraft_Items.steeldust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.quartzpowder,4), new Object[]{	Evercraft_Items.quartzdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.steeldust,1), new Object[]{	Evercraft_Items.steelpowder,Evercraft_Items.steelpowder,Evercraft_Items.steelpowder,Evercraft_Items.steelpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.quartzdust,1), new Object[]{	Evercraft_Items.quartzpowder,Evercraft_Items.quartzpowder,Evercraft_Items.quartzpowder,Evercraft_Items.quartzpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.bronzepowder,4), new Object[]{	Evercraft_Items.bronzedust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.bronzedust,1), new Object[]{	Evercraft_Items.bronzepowder,Evercraft_Items.bronzepowder,Evercraft_Items.bronzepowder,Evercraft_Items.bronzepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.derpyingot,9,0), new Object[]{	 Evercraft_Blocks.blockderpyblock,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.obsidiumingot,9), new Object[]{	 Evercraft_Blocks.blockobsidiumblock,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.obsidianpowder,4), new Object[]{	Evercraft_Items.obsidiandust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.obsidiandust,1), new Object[]{	Evercraft_Items.obsidianpowder,Evercraft_Items.obsidianpowder,Evercraft_Items.obsidianpowder,Evercraft_Items.obsidianpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.zincpowder,4), new Object[]{	Evercraft_Items.zincdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.zincdust,1), new Object[]{	Evercraft_Items.zincpowder,Evercraft_Items.zincpowder,Evercraft_Items.zincpowder,Evercraft_Items.zincpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball,16), new Object[]{	Items.flint,Items.clay_ball,Evercraft_Blocks.blockclaydirt,Evercraft_Blocks.blockclaydirt,Evercraft_Blocks.blockclaydirt,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.electrumpowder,4), new Object[]{	Evercraft_Items.electrumdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.electrumdust,1), new Object[]{	Evercraft_Items.electrumpowder,Evercraft_Items.electrumpowder,Evercraft_Items.electrumpowder,Evercraft_Items.electrumpowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.brasspowder,4), new Object[]{	Evercraft_Items.brassdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.brassdust,1), new Object[]{	Evercraft_Items.brasspowder,Evercraft_Items.brasspowder,Evercraft_Items.brasspowder,Evercraft_Items.brasspowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.redstonitepowder,4), new Object[]{	Evercraft_Items.redstonitedust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.redstonitedust,1), new Object[]{	Evercraft_Items.redstonitepowder,Evercraft_Items.redstonitepowder,Evercraft_Items.redstonitepowder,Evercraft_Items.redstonitepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.sphenepowder,4), new Object[]{	Evercraft_Items.sphenedust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.sphenedust,1), new Object[]{	Evercraft_Items.sphenepowder,Evercraft_Items.sphenepowder,Evercraft_Items.sphenepowder,Evercraft_Items.sphenepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedironpowder,4), new Object[]{	Evercraft_Items.hardenedirondust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedirondust,1), new Object[]{	Evercraft_Items.hardenedironpowder,Evercraft_Items.hardenedironpowder,Evercraft_Items.hardenedironpowder,Evercraft_Items.hardenedironpowder,	});
	for(int i = 0;i < 16;i++){
		GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockhardenedbarscolored,1,i), new Object[]{	new ItemStack(Evercraft_Items.coloredslimeball,1,i),Evercraft_Blocks.blockbasicspawner,	});
	}
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,0), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,0),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,1), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,12),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,2), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,8),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,3), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,7),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,4), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,11),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,5), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,1),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,6), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,4),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,7), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,3),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,8), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,9),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,9), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,6),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,10), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,5),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,11), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,10),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Blocks.blockplatedblock,1,12), new Object[]{	new ItemStack(Evercraft_Items.largeplate,1,2),	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.redstoniteingot,9), new Object[]{	 Evercraft_Blocks.blockredstoniteblock,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.ironpowder, 2), new Object[]{	 Items.flint, Blocks.iron_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.goldpowder, 2), new Object[]{	 Items.flint, Blocks.gold_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.coalpowder, 2), new Object[]{	 Items.flint, Blocks.coal_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.redstonepowder, 4), new Object[]{	 Items.flint, Blocks.redstone_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.lapispowder, 3), new Object[]{	 Items.flint, Blocks.lapis_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.diamondpowder, 1), new Object[]{	 Items.flint, Blocks.diamond_ore	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.emeraldpowder, 1), new Object[]{	 Items.flint, Blocks.emerald_ore	});	
	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 1), new Object[]{ new ItemStack(Evercraft_Items.sanddust, 1, 0)});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedredstonepowder,4), new Object[]{	Evercraft_Items.hardenedredstonedust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedredstonedust,1), new Object[]{	Evercraft_Items.hardenedredstonepowder,Evercraft_Items.hardenedredstonepowder,Evercraft_Items.hardenedredstonepowder,Evercraft_Items.hardenedredstonepowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedlapispowder,4), new Object[]{	Evercraft_Items.hardenedlapisdust,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedlapisdust,1), new Object[]{	Evercraft_Items.hardenedlapispowder,Evercraft_Items.hardenedlapispowder,Evercraft_Items.hardenedlapispowder,Evercraft_Items.hardenedlapispowder,	});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetCopper), new Object[] {Evercraft_Items.copperingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetTin), new Object[] {Evercraft_Items.tiningot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetSilver), new Object[] {Evercraft_Items.silveringot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetTitanium), new Object[] {Evercraft_Items.titaniumingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetLead), new Object[] {Evercraft_Items.leadingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetSteel), new Object[] {Evercraft_Items.steelingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetZinc), new Object[] {Evercraft_Items.zincingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetObsidian), new Object[] {Evercraft_Items.obsidianingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.metaNugget, 9, MetaInterface.nuggetIron), new Object[] {Items.iron_ingot});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.superalloyPowder, 4), new Object[] {Evercraft_Items.superalloyDust});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.superalloyDust, 1), new Object[] {Evercraft_Items.superalloyPowder, Evercraft_Items.superalloyPowder, Evercraft_Items.superalloyPowder, Evercraft_Items.superalloyPowder});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.chromiumPowder, 4), new Object[] {Evercraft_Items.chromiumDust});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.chromiumDust, 1), new Object[] {Evercraft_Items.chromiumPowder, Evercraft_Items.chromiumPowder, Evercraft_Items.chromiumPowder, Evercraft_Items.chromiumPowder});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.cobaltPowder, 4), new Object[] {Evercraft_Items.cobaltDust});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.cobaltDust, 1), new Object[] {Evercraft_Items.cobaltPowder, Evercraft_Items.cobaltPowder, Evercraft_Items.cobaltPowder, Evercraft_Items.cobaltPowder});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.nickelPowder, 4), new Object[] {Evercraft_Items.nickelDust});
	GameRegistry.addShapelessRecipe(new ItemStack(Evercraft_Items.nickelDust, 1), new Object[] {Evercraft_Items.nickelPowder, Evercraft_Items.nickelPowder, Evercraft_Items.nickelPowder, Evercraft_Items.nickelPowder});
	
	Evercraft.log.info("Recipes registered: phase 4");
	
	// SMELTING
	FurnaceRecipes.smelting().func_151393_a(Evercraft_Blocks.blockcopperore, new ItemStack(Evercraft_Items.copperingot,1), 2); 
	FurnaceRecipes.smelting().func_151393_a(Evercraft_Blocks.blocktinore, new ItemStack(Evercraft_Items.tiningot,1), 3); 
	FurnaceRecipes.smelting().func_151393_a(Evercraft_Blocks.blocksilverore, new ItemStack(Evercraft_Items.silveringot,1), 5); 
	FurnaceRecipes.smelting().func_151393_a(Evercraft_Blocks.blockzincore, new ItemStack(Evercraft_Items.zincingot,1), 1); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.copperdust, new ItemStack(Evercraft_Items.copperingot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.tindust, new ItemStack(Evercraft_Items.tiningot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.silverdust, new ItemStack(Evercraft_Items.silveringot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.golddust, new ItemStack(Items.gold_ingot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.irondust, new ItemStack(Items.iron_ingot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.bronzedust, new ItemStack(Evercraft_Items.bronzeingot,1), 0.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.zincdust, new ItemStack(Evercraft_Items.zincingot,1), 0.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.redstonitedust, new ItemStack(Evercraft_Items.redstoniteingot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.brassdust, new ItemStack(Evercraft_Items.brassingot,1), 0.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.electrumdust, new ItemStack(Evercraft_Items.electrumingot,1), 0.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.leaddust, new ItemStack(Evercraft_Items.leadingot,1), 0.0F);
	FurnaceRecipes.smelting().func_151393_a(Evercraft_Blocks.blockleadore, new ItemStack(Evercraft_Items.leadingot,1), 2.0F);
	FurnaceRecipes.smelting().func_151393_a(Blocks.glass_pane, new ItemStack(Evercraft_Items.moltenglass,1), 0.1F);
	FurnaceRecipes.smelting().func_151394_a(new ItemStack(Evercraft_Items.sanddust, 1, 1), new ItemStack(Evercraft_Blocks.blockclearglass, 1), 0.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.hardenedirondust, new ItemStack(Evercraft_Items.hardenedironingot,1), 2.0F);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.hardenedredstonedust, new ItemStack(Evercraft_Items.hardenedredstoneingot,1), 0); 
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.hardenedlapisdust, new ItemStack(Evercraft_Items.hardenedlapisingot,1), 0); 
	FurnaceRecipes.smelting().func_151394_a(new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 1), new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 0), 0);
	FurnaceRecipes.smelting().func_151396_a(Evercraft_Items.nickelDust, new ItemStack(Evercraft_Items.nickelIngot, 1), 0.0F);

	Evercraft.log.info("Recipes registered: phase 5");
	
	//EASYMODE ONLY
	if (Evercraft_Config_Base.hardmode == false) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.derpyarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', new ItemStack(Evercraft_Items.derpyingot,1,0)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.derpypickaxe,1), new Object[]{"iii"," s ","nsn",'s',"stickWood",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyshovel,1), new Object[]{" i "," s ","nsn",'s',"stickWood",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyaxe,1), new Object[]{"ii ","is ","nsn",'s',"stickWood",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpysword,1), new Object[]{" i "," i ","nsn",'s',"stickWood",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyhoe,1), new Object[]{"ii "," s ","nsn",'s',"stickWood",'i',new ItemStack(Evercraft_Items.derpyingot,1,0),'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpybow, 1), new Object[]{" is", "ins", " is", 's', Items.string, 'i', new ItemStack(Evercraft_Items.derpyingot,1,0), 'n',Items.nether_star,});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyboots,1), new Object[]{"i i","i i",'i',new ItemStack(Evercraft_Items.derpyingot,1,0)});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyleggings,1), new Object[]{"iii","i i","i i",'i',new ItemStack(Evercraft_Items.derpyingot,1,0)});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpychestplate,1), new Object[]{"i i","iii","iii",'i',new ItemStack(Evercraft_Items.derpyingot,1,0)});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyhelmet,1), new Object[]{"iii","i i",'i',new ItemStack(Evercraft_Items.derpyingot,1,0)});
		
	}else{
	//HARDMODE ONLY
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.derpyarrow, 9), new Object[]{"i", "s", "f", 'f', Items.feather, 's', "stickWood", 'i', Evercraft_Blocks.blockderpyblock}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.derpypickaxe,1), new Object[]{"iii"," s ","nsn",'s',"stickWood",'i',Evercraft_Blocks.blockderpyblock,'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyshovel,1), new Object[]{" i "," s ","nsn",'s',"stickWood",'i',Evercraft_Blocks.blockderpyblock,'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyaxe,1), new Object[]{"ii ","is ","nsn",'s',"stickWood",'i',Evercraft_Blocks.blockderpyblock,'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpysword,1), new Object[]{" i "," i ","nsn",'s',"stickWood",'i',Evercraft_Blocks.blockderpyblock,'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack( Evercraft_Items.derpyhoe,1), new Object[]{"ii "," s ","nsn",'s',"stickWood",'i',Evercraft_Blocks.blockderpyblock,'n',Items.nether_star,	}));
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpybow, 1), new Object[]{" is", "ins", " is", 's', Items.string, 'i', Evercraft_Blocks.blockderpyblock, 'n',Items.nether_star,});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyboots,1), new Object[]{"i i","i i",'i',Evercraft_Blocks.blockderpyblock});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyleggings,1), new Object[]{"iii","i i","i i",'i',Evercraft_Blocks.blockderpyblock});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpychestplate,1), new Object[]{"i i","iii","iii",'i',Evercraft_Blocks.blockderpyblock});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.derpyhelmet,1), new Object[]{"iii","i i",'i',Evercraft_Blocks.blockderpyblock});

	}
	
	//NAME TAG
	if (Evercraft_Config_Base.nametag == true) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.name_tag,1), new Object[]{	Items.paper,"dustSlime",Items.string,	}));
		
	}
	
	//SADDLE
	if (Evercraft_Config_Base.saddle == true) {	
		GameRegistry.addRecipe(new ItemStack(Items.saddle,1), new Object[]{"lll","lil","t t",'l',Items.leather,'i',Items.iron_ingot,'t',Blocks.tripwire_hook,	});
		
	}


	//GregTech ONLY
	if (Evercraft_Config_Base.gregTechMODE == true) {	
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockhammeringmachineOff, 1), new Object[] {"iii", "cpc", "CpH", 'i', "plateIron", 'c', "craftingRawMachineTier02", 'p', Blocks.piston, 'C', new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), 'H', Evercraft_Items.energyabsorber}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcentrifugeOff,1), new Object[]{"ttt","TgT","cCe",'t',"plateTitanium",'C',"craftingRawMachineTier03",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,2),'e',Evercraft_Items.energyabsorber,'g',"gearTungstensteel",'T',new ItemStack(Evercraft_Items.largeplate, 1, 12)}));	
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ethericdrill,1), new Object[]{"ii ","igi"," ih",'i',"plateTitanium",'g',"gearSteel",'h',Evercraft_Items.drillhandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.drillhandle,1), new Object[]{"bgb","eme","bcb",'b',"ingotAluminium",'g',"gearSteel",'c',new ItemStack(Evercraft_Items.portablecapacitor,1,2),'e',Evercraft_Items.electromagnet,'m',Evercraft_Items.magnet}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockredstonitecable,4), new Object[]{"igi","rrr","igi",'i',"plateIron",'g',"glass",'r',Evercraft_Items.redstoniteingot}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockredstonitecable,4), new Object[]{"igi","rrr","igi",'i',"plateIron",'g',"blockGlass",'r',Evercraft_Items.redstoniteingot}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,0), new Object[]{" i ","rlr"," i ",'i',"plateIron",'l',"ingotLead",'r',Items.redstone }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,1), new Object[]{" s ","cgc"," s ",'s',"plateSilver",'g',"plateDenseGold",'c',new ItemStack(Evercraft_Items.portablecapacitor,1,0) }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,2), new Object[]{" e ","rdr",'e',"plateElectrum",'r',Evercraft_Items.redstonitewire,'d',"gemDiamond" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,3), new Object[]{" S ","ece","t t",'e',"plateElectrum",'t',"plateTitanium",'c',new ItemStack(Evercraft_Items.portablecapacitor,1,2),'S',new ItemStack(Evercraft_Items.mediumplate,1,7), }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockelectrolyzerOff,1), new Object[]{"iii","ccc","EIE",'i',"plateSteel",'c',"ingotElectrum",'I',"craftingRawMachineTier03",'E', "craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockadvancedelectrolyzerOff,1), new Object[]{"sss","ccc","E3E",'s',new ItemStack(Evercraft_Items.largeplate,1,7),'c',"craftingSuperconductor",'3',"craftingRawMachineTier04",'E', "craftingCircuitTier07"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","EIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"stickGold",'E', "craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","EIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"rodGold",'E',"craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","EIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"goldRod",'E',"craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"stickIron",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondgrinder,3), new Object[]{"iIi","III","iIi",'I',"plateTitanium",'i',"plateDiamond",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"rodIron",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"ironRod",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockadvancedcrusherOff,1), new Object[]{"iii","ggg","EIE",'i',"plateTitanium",'g',"craftingGrinder",'I',"craftingRawMachineTier03",'E', "craftingCircuitTier04"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockrepulsivecrusherOff,1), new Object[]{"sss","bbb","C3E",'s',new ItemStack(Evercraft_Items.largeplate,1,7),'b',"craftingGrinder",'3',"craftingRawMachineTier04",'E',"craftingCircuitTier07", 'C', "craftingCircuitTier08"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockparticlemergerOff,1), new Object[]{"sss","rDl","C3E",'s',new ItemStack(Evercraft_Blocks.blockplatedblock,1,1),'D',new ItemStack(Evercraft_Items.largeplate,1,4),'r',"plateRedstone",'l',"plateLapis",'3',"craftingRawMachineTier04",'E',"craftingCircuitTier07", 'C', "craftingCircuitTier08"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockparticlemergerOff,1), new Object[]{"sss","lDr","C3E",'s',new ItemStack(Evercraft_Blocks.blockplatedblock,1,1),'D',new ItemStack(Evercraft_Items.largeplate,1,4),'r',"plateRedstone",'l',"plateLapis",'3',"craftingRawMachineTier04",'E',"craftingCircuitTier07", 'C', "craftingCircuitTier08"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockhightemperaturefurnaceOff,1), new Object[]{"ttt","TqT","ICI",'t', "plateTitanium",'T', "craftingHeatingCoilTier02",'q',new ItemStack(Evercraft_Items.largeplate,1,10),'I',"craftingRawMachineTier03", 'C',"craftingCircuitTier07"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockreinforcedchest,1), new Object[]{"iii","i i","iIi",'i',"plateIron",'I',"craftingRawMachineTier01",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockplatemillOff,1), new Object[]{"iii","pIp","EcE",'i',"plateSteel",'p',Blocks.piston,'c',"craftingRawMachineTier02",'I',Blocks.iron_block,'E',"craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcrusherOff,1), new Object[]{"iii","ggg","EIE",'i',"plateSteel",'g',Evercraft_Items.irongrinder,'I',"craftingRawMachineTier02",'E',"craftingCircuitTier04"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.wrench,1), new Object[]{" i "," ci","i  ",'c',"craftingRawMachineTier00",'i',"plateIron", }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.wrench,1), new Object[]{" i "," ci","i  ",'c',"craftingRawMachineTier01",'i',"plateIron", }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockdicoschest, 1), new Object[]{"rrr","rcr","rrr",'c',Blocks.chest,'r',"plateRedstone",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateDiamond", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateCopper", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzebow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateBronze", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateSteel", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonebow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateRedstone", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateLapis", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ironbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateIron", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.goldbow, 1), new Object[]{"His", "i s", "Fis", 's', Items.string, 'i', "plateGold", 'H', "craftingToolHardHammer", 'F', "craftingToolFile"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing1,1), new Object[]{"iii","iIi","iii",'i',"plateTin",'I',Blocks.iron_block,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing2,1), new Object[]{"iai","aIa","iai",'i',"plateZinc",'I',Evercraft_Blocks.blockcasing1,'a',"plateAluminium"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing3,1), new Object[]{"sis","iIi","sis",'i',"plateTitanium",'I',Evercraft_Blocks.blockcasing2,'s',"plateDiamond",		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockmixingtable, 1), new Object[]{"PPP","CcC","tpt", 't', "plateTin",'p', new ItemStack(Evercraft_Blocks.blockplatedblock, 1, 0),'C', "craftingRawMachineTier02",'c', Blocks.cauldron,'P', new ItemStack(Evercraft_Items.largeplate,1,0)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockheatgeneratorOff_Idle,1), new Object[]{"iii","CcC","fff",'i',"plateSteel",'C',"craftingRawMachineTier02",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,1),'f',"craftingHeatingCoilTier02"}));

		
		//HORSE ARMOR
		if (Evercraft_Config_Base.horsearmor == true) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.iron_horse_armor,1), new Object[]{"Fsi","iIi","iHi",'i',"plateIron",'I',Blocks.iron_block,'H',"craftingToolHardHammer",'F',"craftingToolFile",'s',Items.saddle,}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.golden_horse_armor,1), new Object[]{"Fsi","iIi","iHi",'i',"plateGold",'I',Blocks.gold_block,'H',"craftingToolHardHammer",'F',"craftingToolFile",'s',Items.saddle,}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_horse_armor,1), new Object[]{"Fsi","iIi","iHi",'i',"plateDiamond",'I',Blocks.diamond_block,'H',"craftingToolHardHammer",'F',"craftingToolFile",'s',Items.saddle,}));

		}
	}else{
	//NO GregTech		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockhammeringmachineOff, 1), new Object[] {"iii", "cpc", "CpH", 'i', "plateIron", 'c', "craftingRawMachineTier01", 'p', Blocks.piston, 'C', new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), 'H', Evercraft_Items.energyabsorber}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcentrifugeOff,1), new Object[]{"ttt","TgT","cCe",'t',"plateTitanium",'C',"craftingRawMachineTier03",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,2),'e',Evercraft_Items.energyabsorber,'g',Evercraft_Items.drillgear,'T',new ItemStack(Evercraft_Items.largeplate, 1, 12)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockheatgeneratorOff_Idle,1), new Object[]{"iii","CcC","hch",'i',"plateIron",'C',"craftingRawMachineTier02",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,1),'h',Evercraft_Items.heater,'f',Blocks.furnace}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ethericdrill,1), new Object[]{"ii ","igi"," ih",'i',"plateHardenedIron",'g',Evercraft_Items.drillgear,'h',Evercraft_Items.drillhandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.drillhandle,1), new Object[]{"bgb","eme","bcb",'b',"plateBrass",'g',Evercraft_Items.drillgear,'c',new ItemStack(Evercraft_Items.portablecapacitor,1,2),'e',Evercraft_Items.electromagnet,'m',Evercraft_Items.magnet}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.drillgear,1), new Object[]{"sbs","bbb","sbs",'s',"stickObsidian",'b',Blocks.obsidian}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.drillgear,1), new Object[]{"sbs","bbb","sbs",'s',"rodObsidian",'b',Blocks.obsidian}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.drillgear,1), new Object[]{"sbs","bbb","sbs",'s',"obsidianRod",'b',Blocks.obsidian}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blocksolargenerator,1), new Object[]{"PPP","sCs","scs",'s',"plateSteel",'C',"craftingRawMachineTier03",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,1),'P',Evercraft_Items.photovoltaicpanel}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockredstonitecable,8), new Object[]{"igi","rrr","igi",'i',"plateIron",'g',Blocks.glass_pane,'r',Evercraft_Items.redstoniteingot}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockstandardgeneratorOff,1), new Object[]{"iii","CcC","eee",'i',"plateIron",'C',"craftingRawMachineTier02",'c',new ItemStack(Evercraft_Items.machinecapacitor,1,1),'e',Evercraft_Items.energyabsorber}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,0), new Object[]{" i ","rlr"," i ",'i',"plateIron",'l',"ingotLead",'r',"dustSmallRedstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,1), new Object[]{" s ","cgc"," s ",'s',"plateSilver",'g',"plateGold",'c',new ItemStack(Evercraft_Items.portablecapacitor,1,0) }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,2), new Object[]{" e ","rdr",'e',"plateElectrum",'r',Evercraft_Items.redstonitewire,'d',"gemDiamond" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.portablecapacitor,1,3), new Object[]{" S ","ece","t t",'e',"plateElectrum",'t',"plateTitanium",'c',new ItemStack(Evercraft_Items.portablecapacitor,1,2),'S',new ItemStack(Evercraft_Items.smallplate,1,7), }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.coil,2), new Object[]{"ccc","ttt","ccc",'c',"ingotCopper",'t',"plateTin", }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.heater,1), new Object[]{"c c","crc","iti",'c',Evercraft_Items.coil,'t',"plateTin",'r', Items.redstone, 'i', "plateIron" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.energyabsorber,1), new Object[]{"qqq","chc","rqr",'c',"ingotCopper",'q',"plateBrass",'r', Items.redstone, 'h', Evercraft_Items.heater }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machinecapacitor, 1, 0), new Object[]{"tct", "tct", "tqt", 't', "plateBronze", 'c', "ingotLead", 'q', Items.quartz}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machinecapacitor, 1, 1), new Object[]{"sss", "CgC", "sss", 's', "plateSilver", 'g', "plateGold", 'C', new ItemStack(Evercraft_Items.machinecapacitor,1,0),}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machinecapacitor, 1, 2), new Object[]{"wdw", "w w", "wew", 'd', "gemDiamond", 'w', Evercraft_Items.redstonitewire, 'e', "plateElectrum",}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.machinecapacitor, 1, 3), new Object[]{"aCa", "aca", "ttt", 't', "plateTitanium", 'a', "plateAluminium", 'c', Evercraft_Items.coil, 'C', new ItemStack(Evercraft_Items.machinecapacitor,1,2)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing3,1), new Object[]{"sis","iIi","sis",'i',"plateTitanium",'I',"craftingRawMachineTier02",'s',"plateDiamond",		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockelectrolyzerOff,1), new Object[]{"iii","ctc","CIE",'i',"plateIron",'t',"ingotElectrum",'c',"plateCopper",'I',"craftingRawMachineTier01",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,0)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockelectrolyzerOff,1), new Object[]{"iii","ctc","CIE",'i',"plateIron",'t',"ingotElectrum",'c',"plateCopper",'I',"craftingRawMachineTier00",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,0)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing1,1), new Object[]{"iii","iIi","iii",'i',"plateTin",'I',Blocks.iron_block,	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing2,1), new Object[]{"iai","aIa","iai",'i',"plateZinc",'I',"craftingRawMachineTier01",'a',"plateAluminium"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcasing2,1), new Object[]{"iai","aIa","iai",'i',"plateZinc",'I',"craftingRawMachineTier00",'a',"plateAluminium"	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockadvancedelectrolyzerOff,1), new Object[]{"sss","bbb","C3E",'s',new ItemStack(Evercraft_Items.mediumplate,1,7),'b',"ingotElectrum",'3',"craftingRawMachineTier03",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,2)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","CIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"stickGold",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,1)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","CIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"rodGold",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,1)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockindustrialfurnaceOff,1), new Object[]{"iii","sss","CIE",'i',"plateIron",'I',"craftingRawMachineTier02",'s',"goldRod",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,1)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"stickIron",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondgrinder,3), new Object[]{"iIi","III","iIi",'I',"plateTitanium",'i',"stickDiamond",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"rodIron",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondgrinder,3), new Object[]{"iIi","III","iIi",'I',"plateTitanium",'i',"rodDiamond",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.irongrinder,3), new Object[]{"iIi","III","iIi",'I',"plateIron",'i',"ironRod",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondgrinder,3), new Object[]{"iIi","III","iIi",'I',"plateTitanium",'i',"diamondRod",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockadvancedcrusherOff,1), new Object[]{"iii","ggg","CIE",'i',"plateTitanium",'g',"craftingGrinder",'I',"craftingRawMachineTier03",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,1)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockrepulsivecrusherOff,1), new Object[]{"sss","bbb","C3E",'s',new ItemStack(Evercraft_Items.mediumplate,1,7),'b',"craftingGrinder",'3',"craftingRawMachineTier03",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,3)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockparticlemergerOff,1), new Object[]{"sss","rDl","C3E",'s',new ItemStack(Evercraft_Blocks.blockplatedblock,1,4),'D',new ItemStack(Evercraft_Items.largeplate,1,4),'r',"plateHardenedRedstone",'l',"plateHardenedLapis",'3',"craftingRawMachineTier03",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,3)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockparticlemergerOff,1), new Object[]{"sss","lDr","C3E",'s',new ItemStack(Evercraft_Blocks.blockplatedblock,1,4),'D',new ItemStack(Evercraft_Items.largeplate,1,4),'r',"plateHardenedRedstone",'l',"plateHardenedLapis",'3',"craftingRawMachineTier03",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,3)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockhightemperaturefurnaceOff,1), new Object[]{"ttt","TqT","ICI",'t',new ItemStack(Evercraft_Items.largeplate,1,0),'T', Items.blaze_rod,'q',new ItemStack(Evercraft_Items.largeplate,1,10),'I',"craftingRawMachineTier02", 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,2)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockreinforcedchest,1), new Object[]{"iii","i i","iIi",'i',"plateIron",'I',"craftingRawMachineTier02",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockplatemillOff,1), new Object[]{"iii","pIp","CcE",'i',"plateIron",'p',Blocks.piston,'c',"craftingRawMachineTier02",'I',Blocks.iron_block,'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,1)	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockcrusherOff,1), new Object[]{"iii","ggg","CIE",'i',"plateIron",'g',Evercraft_Items.irongrinder,'I',"craftingRawMachineTier02",'E',Evercraft_Items.energyabsorber, 'C',new ItemStack(Evercraft_Items.machinecapacitor,1,0)	}));		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.wrench,1), new Object[]{" i "," ci","i  ",'c',"craftingRawMachineTier00",'i',"plateIron", }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.wrench,1), new Object[]{" i "," ci","i  ",'c',"craftingRawMachineTier01",'i',"plateIron", }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.diamondbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.copperbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.bronzebow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.steelbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonebow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "ingotHardenedRedstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.lapisbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', "ingotHardenedLapis"}));
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.ironbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(Evercraft_Items.goldbow, 1), new Object[]{" is", "i s", " is", 's', Items.string, 'i', Items.gold_ingot});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockdicoschest,2), new Object[]{"rrr","rcr","rrr",'c',Blocks.chest,'r',"ingotHardenedRedstone",	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.redstonitewire, 8), new Object[]{"iii", 'i', "plateRedstonite",}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockmixingtable, 1), new Object[]{"PPP","CcC","tpt", 't', "plateTin",'p', Blocks.iron_block,'C', "craftingRawMachineTier01",'c', Items.cauldron,'P', Blocks.heavy_weighted_pressure_plate	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Blocks.blockminingmachine, 1), new Object[]{"iii","iMi","cgC", 'i', "plateIron",'M', "craftingRawMachineTier02",'c', new ItemStack(Evercraft_Items.machinecapacitor, 1, 1),'C', Evercraft_Items.energyabsorber,'g', Evercraft_Items.irongrinder	}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Evercraft_Items.ethericwrench, 1), new Object[]{"i i","ibi"," c ", 'i', "plateHardenedIron",'b', "plateBrass",'c', new ItemStack(Evercraft_Items.portablecapacitor, 1, 2) }));
		
	
		//HORSE ARMOR
		if (Evercraft_Config_Base.horsearmor == true) {
			GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor,1), new Object[]{" si","iIi","i i",'i',Items.iron_ingot,'I',Blocks.iron_block,'s',Items.saddle,		});
			GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor,1), new Object[]{" si","iIi","i i",'i',Items.gold_ingot,'I',Blocks.gold_block,'s',Items.saddle,		});
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_horse_armor,1), new Object[]{" si","iIi","i i",'i',"gemDiamond",'I',Blocks.diamond_block,'s',Items.saddle,		}));

		}
	}
	Evercraft.log.info("Recipes registered: phase 6");
	}

}
