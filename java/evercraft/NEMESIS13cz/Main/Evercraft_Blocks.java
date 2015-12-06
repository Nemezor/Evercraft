package evercraft.NEMESIS13cz.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Blocks.Bricks.BlockEC2Bricks;
import evercraft.NEMESIS13cz.Blocks.Bricks.BlockECBricks;
import evercraft.NEMESIS13cz.Blocks.Bricks.BlockECColoredBricks;
import evercraft.NEMESIS13cz.Blocks.Bricks.BlockECColoredBricks2;
import evercraft.NEMESIS13cz.Blocks.Bricks.BlockECRSBricks;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockBasicSpawner;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockDiamondSpawner;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockGoldSpawner;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockHardenedBarsColored;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockIronSpawner;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockObsidianSpawner;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockEC2Bricks;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECBricks;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECColoredBricks;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECColoredBricks2;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECColoredGlass2;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECColoredGlassGlow;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECColoredGlassGlow2;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockECRSBricks;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockFireBlock;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockHardenedBarsColored;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockNuggetOre;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockPlatedBlock;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockPlatedCarpet;
import evercraft.NEMESIS13cz.Blocks.ItemBlock.ItemBlockWhiteStone;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockAdvancedCrusher;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockAdvancedElectrolyzer;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockAlloyFurnace;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCapacitorStorage;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCasing1;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCasing2;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCasing3;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCentrifuge;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCrusher;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockCuttingMachine;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockDicosChest;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockElectrolyzer;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockEnricher;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockFurnitureCrafter;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockHammeringMachine;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockHeatGenerator;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockHighTemperatureFurnace;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockIndustrialFurnace;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockItemPipe;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockMiner;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockMiningPipe;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockMixingTable;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockOreFactory;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockParticleMerger;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockPlateMill;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockRedstoniteCable;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockReinforcedChest;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockRepulsiveCrusher;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockSolarGenerator;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockStandardGenerator;
import evercraft.NEMESIS13cz.Blocks.MetalBlocks.BlockObsidiumBlock;
import evercraft.NEMESIS13cz.Blocks.MetalBlocks.BlockDerpyBlock;
import evercraft.NEMESIS13cz.Blocks.MetalBlocks.BlockPlatedBlock;
import evercraft.NEMESIS13cz.Blocks.MetalBlocks.BlockPlatedCarpet;
import evercraft.NEMESIS13cz.Blocks.MetalBlocks.BlockRedstoniteBlock;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockClearGlass;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockClearGlassGlow;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockConductanceCoil;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockECColoredGlass2;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockECColoredGlassGlow;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockECColoredGlassGlow2;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockInstantRepeater;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockPotionSpreader;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockSmileBlock;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockVanillaGlassGlow;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockWirelessRedstone;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockBauxiteOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockClayDirt;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockCopperOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockEndOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockFireBlock;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockLeadOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockMagneticStone;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockMossyStone;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockNuggetOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockOverworldQuartzOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockPowerSand;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockSilverOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockSpheneOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockTinOre;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockWhiteStone;
import evercraft.NEMESIS13cz.Blocks.WorldGen.BlockZincOre;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;


public class Evercraft_Blocks {


	//Blocks ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	public static Block blockbasicspawner;
	public static Block blockironspawner;
	public static Block blockgoldspawner;
	public static Block blockdiamondspawner;
	public static Block blockobsidianspawner;
	public static Block blockbricks;
	public static Block blockpowersand;
	public static Block blockcopperore;
	public static Block blocktinore;
	public static Block blocksilverore;
	public static Block blockbauxiteore;
	public static Block blockmagneticstone;
	public static Block blockelectrolyzerOff;
	public static Block blockelectrolyzerOn;
	public static Block blockcrusherOff;
	public static Block blockcrusherOn;
	public static Block blockindustrialfurnaceOff;
	public static Block blockindustrialfurnaceOn;
	public static Block blockadvancedcrusherOff;
	public static Block blockadvancedcrusherOn;
	public static Block blockcasing1;
	public static Block blockcasing2;
	public static Block blockcasing3;
	public static Block blockreinforcedchest;
	public static Block blockplatemillOff;
	public static Block blockplatemillOn;
	public static Block blockfurniturecrafter;
	public static Block blockhightemperaturefurnaceOff;
	public static Block blockhightemperaturefurnaceOn;
	public static Block blockhardenedbarscolored;
	public static Block blockobsidiumblock;
	public static Block blockderpyblock;
	public static Block blockbricks2;
	public static Block blockmossystone;
	public static Block blockrsbricks;
	public static Block blockplatedblock;
	public static Block blockcoloredbricks;
	public static Block blockcoloredbrickssmooth;
	public static Block blockcoloredglassclear;
	public static Block blockclearglass;
	public static Block blockdicoschest;
	public static Block blockadvancedelectrolyzerOff;
	public static Block blockrepulsivecrusherOff;
	public static Block blockparticlemergerOff;
	public static Block blockadvancedelectrolyzerOn;
	public static Block blockrepulsivecrusherOn;
	public static Block blockparticlemergerOn;
	public static Block blockzincore;
	public static Block blockfireblock;
	public static Block blocksmileblock;
	public static Block blockcoloredglassglowing;
	public static Block blockcoloredglassclearglowing;
	public static Block blockclaydirt;
	public static Block blockoverworldquartzore;
	public static Block blockvanillaglassglowing;
	public static Block blockclearglassglowing;
	public static Block blockspheneore;
	public static Block blockendore;
	public static Block blockleadore;
	public static Block blockredstoniteblock;
	public static Block blockmixingtable;
	public static Block blockminingmachine;
	public static Block blockminingpipe;
	public static Block blockstandardgeneratorOff;
	public static Block blockstandardgeneratorOn;
	public static Block blockredstonitecable;
	public static Block blocksolargenerator;
	public static Block blockheatgeneratorOn_Idle;
	public static Block blockheatgeneratorOn_Active;
	public static Block blockheatgeneratorOff_Idle;
	public static Block blockcentrifugeOff;
	public static Block blockcentrifugeOn;
	public static Block blockhammeringmachineOff;
	public static Block blockhammeringmachineOn;
	public static Block blockWRStransmitter;
	public static Block blockWRSreceiverOff;
	public static Block blockWRSreceiverOn;
	public static Block blockwhitestone;
	public static Block blockalloyfurnaceOff;
	public static Block blockalloyfurnaceOn;
	public static Block blockpotionspreader;
	public static Block blockcuttingmachineOff;
	public static Block blockcuttingmachineOn;
	public static Block blocknuggetOre;
	public static Block blockCapStorage;
	public static Block blockItemPipeNormal_1;
	public static Block blockItemPipeNormal_2;
	public static Block blockItemPipeExtraction1;
	public static Block blockItemPipeExtraction2;
	public static Block blockItemPipeCrossing;
	public static Block blockItemPipeFast;
	public static Block blockorefactoryOff;
	public static Block blockorefactoryOn;
	public static Block blockHyperenergeticRepeater;
	public static Block blockPlatedCarpet;
	public static Block blockEnricherOff;
	public static Block blockEnricherOn;
	public static Block blockConductanceCoil;
	
	
	public static void init() {
		
		//blocks ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


		blockbasicspawner= new BlockBasicSpawner(Material.rock, false).setBlockName("hardenedBars").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(20.0F);
		blockironspawner= new BlockIronSpawner(Material.iron, false).setBlockName("hardenedBars_iron").setHardness(5.5F).setStepSound(Block.soundTypeMetal).setResistance(25.0F);
		blockgoldspawner= new BlockGoldSpawner(Material.iron, false).setBlockName("hardenedBars_gold").setHardness(3.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockdiamondspawner= new BlockDiamondSpawner(Material.iron, false).setBlockName("hardenedBars_diamond").setHardness(6.0F).setStepSound(Block.soundTypeMetal).setResistance(35.0F);
		blockobsidianspawner= new BlockObsidianSpawner(Material.rock, false).setBlockName("hardenedBars_obsidian").setHardness(7.0F).setStepSound(Block.soundTypeMetal).setResistance(6000.0F);
		blockbricks = new BlockECBricks(Material.rock).setBlockName("metalBricks_normal").setHardness(4.0F).setStepSound(Block.soundTypeStone).setResistance(12.0F).setCreativeTab(ECTabs.tabECDeco); 
		blockbricks2 = new BlockEC2Bricks(Material.rock).setBlockName("metalBricks_smooth").setHardness(4.0F).setStepSound(Block.soundTypeStone).setResistance(12.0F).setCreativeTab(ECTabs.tabECDeco);
		blockpowersand= new BlockPowerSand().setBlockName("redstoneSand").setHardness(1.0F).setStepSound(Block.soundTypeSand).setResistance(4.0F);
		blockcopperore= new BlockCopperOre().setBlockName("copperOre").setHardness(2.5F).setStepSound(Block.soundTypeStone).setResistance(10.0F);
		blocktinore= new BlockTinOre().setBlockName("tinOre").setHardness(3.5F).setStepSound(Block.soundTypeStone).setResistance(11.75F);
		blocksilverore= new BlockSilverOre().setBlockName("silverOre").setHardness(3.0F).setStepSound(Block.soundTypeStone).setResistance(9.25F);
		blockbauxiteore= new BlockBauxiteOre().setBlockName("bauxiteOre").setHardness(3.0F).setStepSound(Block.soundTypeStone).setResistance(8.0F);
		blockmagneticstone= new BlockMagneticStone().setBlockName("magnetiteOre").setHardness(13.0F).setStepSound(Block.soundTypeStone).setResistance(50.0F);
		blockcrusherOff= new BlockCrusher(false).setBlockName("crusherOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockcrusherOn= new BlockCrusher(true).setBlockName("crusherOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockindustrialfurnaceOff= new BlockIndustrialFurnace(false).setBlockName("advancedFurnaceOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockindustrialfurnaceOn= new BlockIndustrialFurnace(true).setBlockName("advancedFurnaceOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setLightLevel(0.875F);
		blockadvancedcrusherOff= new BlockAdvancedCrusher(false).setBlockName("advancedCrusherOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockadvancedcrusherOn= new BlockAdvancedCrusher(true).setBlockName("advancedCrusherOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockcasing1= new BlockCasing1("blockcasing1").setBlockName("casing_1").setHardness(3.0F).setStepSound(Block.soundTypeMetal).setResistance(13.0F);
		blockcasing2= new BlockCasing2("blockcasing2").setBlockName("casing_2").setHardness(4.0F).setStepSound(Block.soundTypeMetal).setResistance(14.0F);
		blockcasing3= new BlockCasing3("blockcasing3").setBlockName("casing_3").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockreinforcedchest= new BlockReinforcedChest(0).setBlockName("reinforcedChest").setCreativeTab(ECTabs.tabECMisc).setStepSound(Block.soundTypeMetal).setHardness(10.0F).setResistance(3500.0F);
		blockplatemillOff= new BlockPlateMill(false).setBlockName("plateMillOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockplatemillOn= new BlockPlateMill(true).setBlockName("plateMillOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockfurniturecrafter= new BlockFurnitureCrafter().setBlockName("advancedCrafter").setHardness(2.0F).setStepSound(Block.soundTypeWood).setResistance(5.0F);
		blockhightemperaturefurnaceOff= new BlockHighTemperatureFurnace(false).setBlockName("highPressureFurnaceOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockhightemperaturefurnaceOn= new BlockHighTemperatureFurnace(true).setBlockName("highPressureFurnaceOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setLightLevel(1.0F);
		blockplatedblock = new BlockPlatedBlock(Material.iron).setBlockName("platedBlock").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(10000.0F).setCreativeTab(ECTabs.tabECDeco);
		blockhardenedbarscolored = new BlockHardenedBarsColored(Material.rock, false).setBlockName("hardenedBars_colored").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setCreativeTab(ECTabs.tabECDeco);
		blockobsidiumblock = new BlockObsidiumBlock("blockobsidiumblock").setBlockName("blockStorage_obsidium").setHardness(6.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockelectrolyzerOff= new BlockElectrolyzer(false).setBlockName("electrolyzerOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockelectrolyzerOn= new BlockElectrolyzer(true).setBlockName("electrolyzerOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setLightLevel(0.875F);
		blockderpyblock = new BlockDerpyBlock("blockderpyblock").setBlockName("blockStorage_derpy").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(12.5F);
		blockmossystone = new BlockMossyStone("blockmossystone").setBlockName("mossySmoothStone").setHardness(1.5F).setStepSound(Block.soundTypeStone).setResistance(4.5F);
		blockrsbricks = new BlockECRSBricks(Material.rock).setBlockName("metalBricks_Redstone").setHardness(4.0F).setStepSound(Block.soundTypeStone).setResistance(12.0F).setCreativeTab(ECTabs.tabECDeco);
		blockcoloredbricks = new BlockECColoredBricks(Material.rock).setBlockName("coloredBricks_normal").setHardness(1.5F).setStepSound(Block.soundTypeStone).setResistance(4.5F).setCreativeTab(ECTabs.tabECDeco);
		blockcoloredbrickssmooth = new BlockECColoredBricks2(Material.rock).setBlockName("coloredBricks_smooth").setHardness(1.5F).setStepSound(Block.soundTypeStone).setResistance(4.5F).setCreativeTab(ECTabs.tabECDeco);
		blockcoloredglassclear = new BlockECColoredGlass2(Material.glass, false).setBlockName("coloredGlass_clear").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F).setCreativeTab(ECTabs.tabECDeco);
		blockclearglass = new BlockClearGlass(Material.glass, false).setBlockName("glass_clear").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F);
		blockdicoschest = new BlockDicosChest(0).setBlockName("diconianChest").setCreativeTab(ECTabs.tabECMisc).setStepSound(Block.soundTypeMetal).setHardness(4.0F).setResistance(7.0F);
		blockadvancedelectrolyzerOff = new BlockAdvancedElectrolyzer(false).setBlockName("advancedElectrolyzerOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockadvancedelectrolyzerOn = new BlockAdvancedElectrolyzer(true).setBlockName("advancedElectrolyzerOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setLightLevel(0.3F);
		blockrepulsivecrusherOff = new BlockRepulsiveCrusher(false).setBlockName("repulsiveCrusherOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockrepulsivecrusherOn = new BlockRepulsiveCrusher(true).setBlockName("repulsiveCrusherOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F);
		blockparticlemergerOff = new BlockParticleMerger(false).setBlockName("compacterOff").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setCreativeTab(ECTabs.tabECMachines);
		blockparticlemergerOn = new BlockParticleMerger(true).setBlockName("compacterOn").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(15.0F).setLightLevel(1.0F);
		blockzincore = new BlockZincOre("blockzincore").setBlockName("zincOre").setHardness(2.0F).setStepSound(Block.soundTypeStone).setResistance(6.0F);
		blockfireblock = new BlockFireBlock(Material.rock).setBlockName("infernalNetherrack").setHardness(0.4F).setStepSound(Block.soundTypeStone).setResistance(0.3F).setCreativeTab(ECTabs.tabECWGMaterials);
		blocksmileblock = new BlockSmileBlock("blocksmileblock").setBlockName("smileBlock").setStepSound(Block.soundTypeStone).setResistance(100.0F).setHardness(10.0F);
		blockcoloredglassglowing = new BlockECColoredGlassGlow(Material.glass, false).setBlockName("coloredGlass_normalGlowing").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F).setCreativeTab(ECTabs.tabECDeco).setLightLevel(1.0F);
		blockcoloredglassclearglowing = new BlockECColoredGlassGlow2(Material.glass, false).setBlockName("coloredGlass_clearGlowing").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F).setCreativeTab(ECTabs.tabECDeco).setLightLevel(1.0F);
		blockclaydirt = new BlockClayDirt("blockclaydirt").setBlockName("clayDirt").setHardness(0.5F).setStepSound(Block.soundTypeGravel).setResistance(1.0F);
		blockoverworldquartzore = new BlockOverworldQuartzOre("blockoverworldquartzore").setBlockName("quartzOre_stone").setHardness(4.0F).setStepSound(Block.soundTypeStone).setResistance(20.0F);
		blockvanillaglassglowing = new BlockVanillaGlassGlow(Material.glass, false).setBlockName("glass_normalGlowing").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F).setLightLevel(1.0F);
		blockclearglassglowing = new BlockClearGlassGlow(Material.glass, false).setBlockName("glass_clearGlowing").setHardness(0.5F).setStepSound(Block.soundTypeGlass).setResistance(0.5F).setLightLevel(1.0F);
		blockspheneore = new BlockSpheneOre("blockspheneore").setBlockName("spheneOre").setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(20.0F);
		blockendore = new BlockEndOre("blockendore").setBlockName("endOre").setHardness(8.0F).setStepSound(Block.soundTypeStone).setResistance(6000.0F);
		blockleadore = new BlockLeadOre("blockleadore").setBlockName("leadOre").setHardness(4.0F).setStepSound(Block.soundTypeStone).setResistance(12.5F);
		blockredstoniteblock = new BlockRedstoniteBlock("redstoniteblock").setBlockName("blockStorage_redstonite").setHardness(8.0F).setStepSound(Block.soundTypeMetal).setResistance(25.0F);
		blockmixingtable = new BlockMixingTable().setBlockName("mixingTable").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(30.0F);
		blockminingmachine = new BlockMiner().setBlockName("miner").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setCreativeTab(ECTabs.tabECMachines);
		blockminingpipe = new BlockMiningPipe().setBlockName("pipeMining").setHardness(3.5F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
		blockstandardgeneratorOff = new BlockStandardGenerator(false).setBlockName("generatorEthericOff").setHardness(16.0F).setStepSound(Block.soundTypeMetal).setResistance(35.0F).setCreativeTab(ECTabs.tabECMachines);
		blockstandardgeneratorOn = new BlockStandardGenerator(true).setBlockName("generatorEthericOn").setHardness(16.0F).setStepSound(Block.soundTypeMetal).setResistance(35.0F);
		blockredstonitecable = new BlockRedstoniteCable().setBlockName("cableRedstonite").setHardness(5.0F).setStepSound(Block.soundTypePiston).setResistance(10.0F).setCreativeTab(ECTabs.tabECMachines);
		blocksolargenerator = new BlockSolarGenerator().setBlockName("generatorSolar").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F).setCreativeTab(ECTabs.tabECMachines);
		blockheatgeneratorOff_Idle = new BlockHeatGenerator(false, false).setBlockName("blockheatgeneratorOff_Idle").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(18.0F).setCreativeTab(ECTabs.tabECMachines);
		blockheatgeneratorOn_Idle = new BlockHeatGenerator(true, false).setBlockName("blockheatgeneratorOn_Idle").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(18.0F);
		blockheatgeneratorOn_Active = new BlockHeatGenerator(true, true).setBlockName("blockheatgeneratorOn_Active").setHardness(5.0F).setStepSound(Block.soundTypeMetal).setResistance(18.0F).setLightLevel(1.0F);
		blockcentrifugeOff = new BlockCentrifuge(false).setBlockName("centrifugeOff").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F).setCreativeTab(ECTabs.tabECMachines);
		blockcentrifugeOn = new BlockCentrifuge(true).setBlockName("centrifugeOn").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F);
		blockhammeringmachineOff = new BlockHammeringMachine(false).setBlockName("hammeringMachineOff").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(31.0F).setCreativeTab(ECTabs.tabECMachines);
		blockhammeringmachineOn = new BlockHammeringMachine(true).setBlockName("hammeringMachineOn").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(31.0F);
		blockWRSreceiverOff = new BlockWirelessRedstone(false, false).setBlockName("wirelessRedstone_ReceiverOff").setHardness(3.0F).setStepSound(Block.soundTypeMetal).setResistance(8.0F).setCreativeTab(ECTabs.tabECMisc);
		blockWRSreceiverOn = new BlockWirelessRedstone(false, true).setBlockName("wirelessRedstone_ReceiverOn").setHardness(3.0F).setStepSound(Block.soundTypeMetal).setResistance(8.0F);
		blockWRStransmitter = new BlockWirelessRedstone(true, false).setBlockName("wirelessRedstone_Transmitter").setHardness(3.0F).setStepSound(Block.soundTypeMetal).setResistance(8.0F).setCreativeTab(ECTabs.tabECMisc);
		blockwhitestone = new BlockWhiteStone(Material.rock).setBlockName("whiteStone").setHardness(1.5F).setStepSound(Block.soundTypeStone).setResistance(7.5F).setCreativeTab(ECTabs.tabECDeco);
		blockalloyfurnaceOff = new BlockAlloyFurnace(false).setBlockName("alloyFurnaceOff").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(30.0F).setCreativeTab(ECTabs.tabECMachines);
		blockalloyfurnaceOn = new BlockAlloyFurnace(true).setBlockName("alloyFurnaceOn").setHardness(14.0F).setStepSound(Block.soundTypeMetal).setResistance(30.0F);
		blockpotionspreader = new BlockPotionSpreader().setBlockName("potionSpreader").setHardness(2.0F).setStepSound(Block.soundTypeStone).setResistance(6.000F);
		blockcuttingmachineOff = new BlockCuttingMachine(false).setBlockName("cuttingMachineOff").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F).setCreativeTab(ECTabs.tabECMachines);
		blockcuttingmachineOn = new BlockCuttingMachine(true).setBlockName("cuttingMachineOn").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F);
		blocknuggetOre = new BlockNuggetOre().setBlockName("oreNugget").setHardness(1.0F).setStepSound(Block.soundTypeGravel).setResistance(3.0F);
		blockCapStorage = new BlockCapacitorStorage().setBlockName("storageEE_Battery").setHardness(20.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeNormal_1 = new BlockItemPipe(ItemPipeHandler.TRANSPORT_1).setBlockName("blockPipeItem_Transport1").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeNormal_2 = new BlockItemPipe(ItemPipeHandler.TRANSPORT_2).setBlockName("blockPipeItem_Transport2").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeExtraction1 = new BlockItemPipe(ItemPipeHandler.EXTRACTION_1).setBlockName("blockPipeItem_Extraction1").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeExtraction2 = new BlockItemPipe(ItemPipeHandler.EXTRACTION_2).setBlockName("blockPipeItem_Extraction2").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeCrossing = new BlockItemPipe(ItemPipeHandler.ROUTING).setBlockName("blockPipeItem_Routing").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockItemPipeFast = new BlockItemPipe(ItemPipeHandler.TRANSPORT_FAST).setBlockName("blockPipeItem_TransportBoost").setHardness(1.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setCreativeTab(ECTabs.tabECMachines);
		blockorefactoryOff = new BlockOreFactory(false).setBlockName("oreFactoryOff").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F).setCreativeTab(ECTabs.tabECMachines);
		blockorefactoryOn = new BlockOreFactory(true).setBlockName("oreFactoryOn").setHardness(18.0F).setStepSound(Block.soundTypeMetal).setResistance(40.0F);
		blockHyperenergeticRepeater = new BlockInstantRepeater().setBlockName("hyperenergeticRepeater").setHardness(0.0F).setStepSound(Block.soundTypeWood).setResistance(1.0F).setCreativeTab(ECTabs.tabECMisc);
		blockPlatedCarpet = new BlockPlatedCarpet(Material.iron).setBlockName("platedCarpet").setHardness(1.5F).setStepSound(Block.soundTypeMetal).setResistance(10000.0F).setCreativeTab(ECTabs.tabECDeco);
		blockEnricherOff = new BlockEnricher(false).setBlockName("enricherOff").setHardness(15.0F).setStepSound(Block.soundTypeMetal).setResistance(30.0F).setCreativeTab(ECTabs.tabECMachines);
		blockEnricherOn = new BlockEnricher(true).setBlockName("enricherOn").setHardness(15.0F).setStepSound(Block.soundTypeMetal).setResistance(30.0F);
		blockConductanceCoil = new BlockConductanceCoil().setBlockName("advConductanceCoil").setHardness(2.0F).setStepSound(Block.soundTypeMetal).setResistance(10.0F);
		
		 Evercraft.log.info("Blocks created");
		//Block Registry ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 
		//Misc
		GameRegistry.registerBlock(blocksmileblock, "smileBlock");
		GameRegistry.registerBlock(blockfurniturecrafter, "advancedCrafter");
		GameRegistry.registerBlock(blockreinforcedchest, "reinforcedChest");
		GameRegistry.registerBlock(blockdicoschest, "diconianChest");
		GameRegistry.registerBlock(blockWRSreceiverOff, "wirelessRedstone_Receiver_Off");
		GameRegistry.registerBlock(blockWRSreceiverOn, "wirelessRedstone_Receiver_On");
		GameRegistry.registerBlock(blockWRStransmitter, "wirelessRedstone_Transmitter");
		GameRegistry.registerBlock(blockpotionspreader, "potionSpreader");
		GameRegistry.registerBlock(blockHyperenergeticRepeater, "hyperenergeticRepeater");
		GameRegistry.registerBlock(blockConductanceCoil, "advConductanceCoil");
		
		//Storage Blocks
		GameRegistry.registerBlock(blockderpyblock, "blockStorage_derpy");
		GameRegistry.registerBlock(blockobsidiumblock, "blockStorage_obsidium");
		GameRegistry.registerBlock(blockredstoniteblock, "blockStorage_redstonite");
		
		//Bars
		GameRegistry.registerBlock(blockbasicspawner, "hardenedBars");
		GameRegistry.registerBlock(blockironspawner, "hardenedBars_iron");
		GameRegistry.registerBlock(blockgoldspawner, "hardenedBars_gold");
		GameRegistry.registerBlock(blockdiamondspawner, "hardenedBars_diamond");
		GameRegistry.registerBlock(blockobsidianspawner, "hardenedBars_obsidian");
		GameRegistry.registerBlock(blockhardenedbarscolored, ItemBlockHardenedBarsColored.class, blockhardenedbarscolored.getUnlocalizedName().substring(5));
		
		//Bricks
		GameRegistry.registerBlock(blockwhitestone, ItemBlockWhiteStone.class, blockwhitestone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockcoloredbricks, ItemBlockECColoredBricks.class, blockcoloredbricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockcoloredbrickssmooth, ItemBlockECColoredBricks2.class, blockcoloredbrickssmooth.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockbricks, ItemBlockECBricks.class, blockbricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockbricks2, ItemBlockEC2Bricks.class, blockbricks2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockrsbricks, ItemBlockECRSBricks.class, blockrsbricks.getUnlocalizedName().substring(5));
		
		//Glass
		GameRegistry.registerBlock(blockclearglass, "glass_clear");
		GameRegistry.registerBlock(blockclearglassglowing, "glass_clearGlowing");
		GameRegistry.registerBlock(blockvanillaglassglowing, "glass_normalGlowing");
		GameRegistry.registerBlock(blockcoloredglassclear, ItemBlockECColoredGlass2.class, blockcoloredglassclear.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockcoloredglassglowing, ItemBlockECColoredGlassGlow.class, blockcoloredglassglowing.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockcoloredglassclearglowing, ItemBlockECColoredGlassGlow2.class, blockcoloredglassclearglowing.getUnlocalizedName().substring(5));
		
		//Plated Blocks
		GameRegistry.registerBlock(blockplatedblock, ItemBlockPlatedBlock.class, blockplatedblock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPlatedCarpet, ItemBlockPlatedCarpet.class, blockPlatedCarpet.getUnlocalizedName().substring(5));
		
		//Machines
		GameRegistry.registerBlock(blockelectrolyzerOff, "electrolyzerOff");
		GameRegistry.registerBlock(blockelectrolyzerOn, "electrolyzerOn");
		GameRegistry.registerBlock(blockadvancedelectrolyzerOff, "advancedElectrolyzerOff");
		GameRegistry.registerBlock(blockadvancedelectrolyzerOn, "advancedElectrolyzerOn");
		GameRegistry.registerBlock(blockadvancedcrusherOff, "advancedCrusherOff");
		GameRegistry.registerBlock(blockadvancedcrusherOn, "advancedCrusherOn");
		GameRegistry.registerBlock(blockcrusherOff, "crusherOff");
		GameRegistry.registerBlock(blockcrusherOn, "crusherOn");
		GameRegistry.registerBlock(blockhammeringmachineOff, "hammeringMachineOff");
		GameRegistry.registerBlock(blockhammeringmachineOn, "hammeringMachineOn");
		GameRegistry.registerBlock(blockcuttingmachineOff, "cuttingMachineOff");
		GameRegistry.registerBlock(blockcuttingmachineOn, "cuttingMachineOn");
		GameRegistry.registerBlock(blockEnricherOff, "enricherOff");
		GameRegistry.registerBlock(blockEnricherOn, "enricherOn");
		GameRegistry.registerBlock(blockrepulsivecrusherOff, "repulsiveCrusherOff");
		GameRegistry.registerBlock(blockrepulsivecrusherOn, "repulsiveCrusherOn");
		GameRegistry.registerBlock(blockindustrialfurnaceOff, "advancedFurnaceOff");
		GameRegistry.registerBlock(blockindustrialfurnaceOn, "advancedFurnaceOn");
		GameRegistry.registerBlock(blockalloyfurnaceOff, "alloyFurnaceOff");
		GameRegistry.registerBlock(blockalloyfurnaceOn, "alloyFurnaceOn");
		GameRegistry.registerBlock(blockhightemperaturefurnaceOff, "highPressureFurnaceOff");
		GameRegistry.registerBlock(blockhightemperaturefurnaceOn, "highPressureFurnaceOn");
		GameRegistry.registerBlock(blockplatemillOff, "plateMillOff");
		GameRegistry.registerBlock(blockplatemillOn, "plateMillOn");
		GameRegistry.registerBlock(blockparticlemergerOff, "compacterOff");
		GameRegistry.registerBlock(blockparticlemergerOn, "compacterOn");
		GameRegistry.registerBlock(blockcentrifugeOff, "centrifugeOff");
		GameRegistry.registerBlock(blockcentrifugeOn, "centrifugeOn");
		GameRegistry.registerBlock(blockorefactoryOff, "oreFactoryOff");
		GameRegistry.registerBlock(blockorefactoryOn, "oreFactoryOn");
		
		
		GameRegistry.registerBlock(blockminingmachine, "miner");
		GameRegistry.registerBlock(blockmixingtable, "tableMixing");

		GameRegistry.registerBlock(blockcasing1, "casing_1");
		GameRegistry.registerBlock(blockcasing2, "casing_2");
		GameRegistry.registerBlock(blockcasing3, "casing_3");
		GameRegistry.registerBlock(blockminingpipe, "pipeMining");
		
		//Generators
		GameRegistry.registerBlock(blockstandardgeneratorOff, "generatorEthericOff");
		GameRegistry.registerBlock(blockstandardgeneratorOn, "generatorEthericOn");
		GameRegistry.registerBlock(blockheatgeneratorOn_Active, "generatorHeatOn_Active");
		GameRegistry.registerBlock(blockheatgeneratorOn_Idle, "generatorHeatOn_Idle");
		GameRegistry.registerBlock(blockheatgeneratorOff_Idle, "generatorHeatOff_Idle");
		GameRegistry.registerBlock(blocksolargenerator, "generatorSolar");
		
		//Energy Storage
		GameRegistry.registerBlock(blockCapStorage, "storageEE_Battery");
		
		//Misc-Machines
		GameRegistry.registerBlock(blockredstonitecable, "cableRedstonite");
		GameRegistry.registerBlock(blockItemPipeNormal_1, "blockItemPipeTransport1");
		GameRegistry.registerBlock(blockItemPipeNormal_2, "blockItemPipeTransport2");
		GameRegistry.registerBlock(blockItemPipeExtraction1, "blockItemPipeExtraction1");
		GameRegistry.registerBlock(blockItemPipeExtraction2, "blockItemPipeExtraction2");
		GameRegistry.registerBlock(blockItemPipeFast, "blockItemPipeTransportBoost");
		GameRegistry.registerBlock(blockItemPipeCrossing, "blockItemPipeRouting");
		
		//Ores
		GameRegistry.registerBlock(blockcopperore, "copperOre");
		GameRegistry.registerBlock(blocktinore, "tinOre");
		GameRegistry.registerBlock(blocksilverore, "silverOre");
		GameRegistry.registerBlock(blockbauxiteore, "bauxiteOre");
		GameRegistry.registerBlock(blockzincore, "zincOre");
		GameRegistry.registerBlock(blockleadore, "leadOre");
		GameRegistry.registerBlock(blockendore, "endOre");
		GameRegistry.registerBlock(blockmagneticstone, "magnetiteOre");
		GameRegistry.registerBlock(blockspheneore, "spheneOre");
		GameRegistry.registerBlock(blockoverworldquartzore, "quartzOre_stone");
		GameRegistry.registerBlock(blockmossystone, "mossySmoothStone");
		GameRegistry.registerBlock(blockfireblock, ItemBlockFireBlock.class, blockfireblock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockclaydirt, "clayDirt");
		GameRegistry.registerBlock(blockpowersand, "redstoneSand");
		GameRegistry.registerBlock(blocknuggetOre, ItemBlockNuggetOre.class, blocknuggetOre.getUnlocalizedName().substring(5));
		
		//HARVEST LEVELS

		blockcopperore.setHarvestLevel("pickaxe", 0);
		blocktinore.setHarvestLevel("pickaxe", 1);
		blockspheneore.setHarvestLevel("pickaxe", 2);
		blockbauxiteore.setHarvestLevel("pickaxe", 2);
		blocksilverore.setHarvestLevel("pickaxe", 2);
		blockoverworldquartzore.setHarvestLevel("pickaxe", 1);
		blockendore.setHarvestLevel("pickaxe", 3);
		blockpowersand.setHarvestLevel("shovel", 2);
		blockmagneticstone.setHarvestLevel("pickaxe", 2);
		blockmossystone.setHarvestLevel("pickaxe", 0);
		blockzincore.setHarvestLevel("pickaxe", 1);
		blockclaydirt.setHarvestLevel("shovel", 1);
		blockfireblock.setHarvestLevel("pickaxe", 1);
		blockleadore.setHarvestLevel("pickaxe", 2);
		blockwhitestone.setHarvestLevel("pickaxe", 0);
		blockpotionspreader.setHarvestLevel("pickaxe", 3);
		blockItemPipeNormal_1.setHarvestLevel("pickaxe", 2);
		blockItemPipeNormal_2.setHarvestLevel("pickaxe", 2);
		blockItemPipeExtraction1.setHarvestLevel("pickaxe", 2);
		blockItemPipeExtraction2.setHarvestLevel("pickaxe", 2);
		blockItemPipeCrossing.setHarvestLevel("pickaxe", 2);
		blockItemPipeFast.setHarvestLevel("pickaxe", 2);
		
		 Evercraft.log.info("Blocks registered");
	}
}
