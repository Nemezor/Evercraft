package evercraft.NEMESIS13cz.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Armor.Boots.ItemBronzeBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemCopperBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemDerpyBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemLapisBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemObsidiumBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemRedstoneBoots;
import evercraft.NEMESIS13cz.Armor.Boots.ItemSteelBoots;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemBronzeChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemCopperChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemDerpyChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemLapisChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemObsidiumChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemRedstoneChestplate;
import evercraft.NEMESIS13cz.Armor.Chestplate.ItemSteelChestplate;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemBronzeHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemCopperHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemDerpyHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemLapisHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemObsidiumHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemRedstoneHelmet;
import evercraft.NEMESIS13cz.Armor.Helmet.ItemSteelHelmet;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemBronzeLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemCopperLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemDerpyLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemLapisLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemObsidiumLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemRedstoneLeggings;
import evercraft.NEMESIS13cz.Armor.Leggings.ItemSteelLeggings;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Items.Dusts.ItemAluminiumDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemAshDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemBauxiteDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemBrassDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemBronzeDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemChromeDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemCoalDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemCobaltDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemCopperDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemDiamondDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemElectrumDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemEmeraldDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemEnergizedDiamondDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemGoldDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemHardenedIronDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemHardenedLapisDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemHardenedRedstoneDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemIronDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemLapisLazuliDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemLeadDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemNickelDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemObsidianDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemQuartzDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemRedstoniteDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemSandDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemSilverDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemSpheneDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemSteelDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemStickyDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemStoneDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemSuperalloyDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemTinDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemTitaniumDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemWhitestoneDust;
import evercraft.NEMESIS13cz.Items.Dusts.ItemZincDust;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemObsidiumGem;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemObsidiumIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemAluminiumIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemBrassIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemBronzeIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemCopperIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemElectrumIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemDerpyIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemHardenedIronIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemHardenedLapisLazuliIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemHardenedRedstoneIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemLeadIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemMagneticLump;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemNickelIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemObsidianIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemRedstoniteIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemSilverIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemSpheneLump;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemSteelIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemSuperalloyIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemTinIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemTitaniumIngot;
import evercraft.NEMESIS13cz.Items.IngotsGemsEssences.ItemZincIngot;
import evercraft.NEMESIS13cz.Items.Misc.ItemAshFilter;
import evercraft.NEMESIS13cz.Items.Misc.ItemColoredSlimeBall;
import evercraft.NEMESIS13cz.Items.Misc.ItemConductanceCoil;
import evercraft.NEMESIS13cz.Items.Misc.ItemDiamondGrinder;
import evercraft.NEMESIS13cz.Items.Misc.ItemDrillGear;
import evercraft.NEMESIS13cz.Items.Misc.ItemDrillHandle;
import evercraft.NEMESIS13cz.Items.Misc.ItemElectromagnet;
import evercraft.NEMESIS13cz.Items.Misc.ItemEnergizedDiamond;
import evercraft.NEMESIS13cz.Items.Misc.ItemEnrichedRedstone;
import evercraft.NEMESIS13cz.Items.Misc.ItemGlassTube;
import evercraft.NEMESIS13cz.Items.Misc.ItemInfernalCoal;
import evercraft.NEMESIS13cz.Items.Misc.ItemIronGrinder;
import evercraft.NEMESIS13cz.Items.Misc.ItemMachineCapacitor;
import evercraft.NEMESIS13cz.Items.Misc.ItemMagnet;
import evercraft.NEMESIS13cz.Items.Misc.ItemMoltenGlass;
import evercraft.NEMESIS13cz.Items.Misc.ItemPhotovoltaicCell;
import evercraft.NEMESIS13cz.Items.Misc.ItemPhotovoltaicPanel;
import evercraft.NEMESIS13cz.Items.Misc.ItemPortableCapacitor;
import evercraft.NEMESIS13cz.Items.Misc.ItemPotionMatrix;
import evercraft.NEMESIS13cz.Items.Misc.ItemRedstoneEnergyAbsorber;
import evercraft.NEMESIS13cz.Items.Misc.ItemRedstoneHeater;
import evercraft.NEMESIS13cz.Items.Misc.ItemRedstoniteWire;
import evercraft.NEMESIS13cz.Items.Misc.ItemSieve;
import evercraft.NEMESIS13cz.Items.Misc.ItemSiliconWafer;
import evercraft.NEMESIS13cz.Items.Misc.ItemSpawnSmile;
import evercraft.NEMESIS13cz.Items.Misc.ItemStopSign;
import evercraft.NEMESIS13cz.Items.Nuggets.ItemMetaNuggets;
import evercraft.NEMESIS13cz.Items.Plates.ItemLargePlate;
import evercraft.NEMESIS13cz.Items.Plates.ItemLargePlateCluster;
import evercraft.NEMESIS13cz.Items.Plates.ItemMediumPlate;
import evercraft.NEMESIS13cz.Items.Plates.ItemMediumPlateCluster;
import evercraft.NEMESIS13cz.Items.Plates.ItemSmallPlate;
import evercraft.NEMESIS13cz.Items.Plates.ItemSmallPlateCluster;
import evercraft.NEMESIS13cz.Items.Plates.ItemStandardPlate;
import evercraft.NEMESIS13cz.Items.Powders.ItemAluminiumPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemBauxitePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemBrassPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemBronzePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemChromePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemCoalPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemCobaltPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemCopperPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemDiamondPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemElectrumPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemEmeraldPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemGoldPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemHardenedIronPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemHardenedLapisPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemHardenedRedstonePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemIronPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemLapisLazuliPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemLeadPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemNickelPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemObsidianPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemQuartzPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemRedstonePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemRedstonitePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemSilverPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemSphenePowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemSteelPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemSuperalloyPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemTinPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemTitaniumPowder;
import evercraft.NEMESIS13cz.Items.Powders.ItemZincPowder;
import evercraft.NEMESIS13cz.Items.Sticks.ItemDiamondStick;
import evercraft.NEMESIS13cz.Items.Sticks.ItemGoldStick;
import evercraft.NEMESIS13cz.Items.Sticks.ItemIronStick;
import evercraft.NEMESIS13cz.Items.Sticks.ItemNetherBrickStick;
import evercraft.NEMESIS13cz.Items.Sticks.ItemObsidianStick;
import evercraft.NEMESIS13cz.Items.Sticks.ItemStoneStick;
import evercraft.NEMESIS13cz.Items.Upgrades.ItemUpgradeMiner;
import evercraft.NEMESIS13cz.Items.Upgrades.ItemUpgradeRedstone;
import evercraft.NEMESIS13cz.Items.Upgrades.ItemUpgradeRoutingPipe;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemBronzeArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemCopperArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemDiamondArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemDerpyArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemGoldArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemIronArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemLapisArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemObsidiumArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemRedstoneArrow;
import evercraft.NEMESIS13cz.Tools.Arrows.ItemSteelArrow;
import evercraft.NEMESIS13cz.Tools.Axes.ItemBronzeAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemCopperAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemDerpyAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemLapisAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemObsidiumAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemRedstoneAxe;
import evercraft.NEMESIS13cz.Tools.Axes.ItemSteelAxe;
import evercraft.NEMESIS13cz.Tools.Bows.ItemBronzeBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemCopperBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemDiamondBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemDerpyBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemGoldBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemIronBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemLapisBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemObsidiumBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemRedstoneBow;
import evercraft.NEMESIS13cz.Tools.Bows.ItemSteelBow;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemBronzeHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemCopperHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemDerpyHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemLapisHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemObsidiumHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemRedstoneHoe;
import evercraft.NEMESIS13cz.Tools.Hoes.ItemSteelHoe;
import evercraft.NEMESIS13cz.Tools.Misc.ItemEthericWrench;
import evercraft.NEMESIS13cz.Tools.Misc.ItemGlowstoneHarvester;
import evercraft.NEMESIS13cz.Tools.Misc.ItemHammer;
import evercraft.NEMESIS13cz.Tools.Misc.ItemObsidianHarvester;
import evercraft.NEMESIS13cz.Tools.Misc.ItemWirelessRedstoneCoordinator;
import evercraft.NEMESIS13cz.Tools.Misc.ItemWoolCard;
import evercraft.NEMESIS13cz.Tools.Misc.ItemWrench;
import evercraft.NEMESIS13cz.Tools.Multi.ItemBronzeMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemCopperMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemDiamondMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemDerpyMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemGoldMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemIronMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemLapisLazuliMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemObsidiumMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemRedstoneMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemSteelMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemStoneMultiTool;
import evercraft.NEMESIS13cz.Tools.Multi.ItemWoodenMultiTool;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemBronzePickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemCopperPickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemEthericDrill;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemDerpyPickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemLapisLazuliPickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemObsidiumPickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemRedstonePickaxe;
import evercraft.NEMESIS13cz.Tools.Pickaxes.ItemSteelPickaxe;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemBronzeShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemCopperShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemDerpyShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemLapisShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemObsidiumShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemRedstoneShovel;
import evercraft.NEMESIS13cz.Tools.Shovels.ItemSteelShovel;
import evercraft.NEMESIS13cz.Tools.Swords.ItemBronzeSword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemCopperSword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemDerpySword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemLapisSword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemObsidiumSword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemRedstoneSword;
import evercraft.NEMESIS13cz.Tools.Swords.ItemSteelSword;

public class Evercraft_Items {

	//Items ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	public static Item ironstick;
	public static Item stonestick;
	public static Item goldstick;
	public static Item diamondstick;
	public static Item obsidianstick;
	public static Item copperingot;
	public static Item tiningot;
	public static Item silveringot;
	public static Item aluminiumingot;
	public static Item titaniumingot;
	public static Item magneticlump;
	public static Item magnet;
	public static Item electromagnet;
	public static Item stopsign;
	public static Item irongrinder;
	public static Item irondust;
	public static Item golddust;
	public static Item emeralddust;
	public static Item diamonddust;
	public static Item coaldust;
	public static Item lapislazulidust;
	public static Item copperdust;
	public static Item tindust;
	public static Item silverdust;
	public static Item bauxitedust;
	public static Item titaniumdust;
	public static Item aluminiumdust;
	public static Item diamondgrinder;
	public static Item netherbrickstick;
	public static Item lapispowder;
	public static Item ironpowder;
	public static Item goldpowder;
	public static Item diamondpowder;
	public static Item emeraldpowder;
	public static Item redstonepowder;
	public static Item tinpowder;
	public static Item copperpowder;
	public static Item silverpowder;
	public static Item bauxitepowder;
	public static Item titaniumpowder;
	public static Item aluminiumpowder;
	public static Item coalpowder;
	public static Item quartzdust;
	public static Item steelingot;
	public static Item quartzpowder;
	public static Item steeldust;
	public static Item steelpowder;
	public static Item hardenedlapisingot;
	public static Item hardenedredstoneingot;
	public static Item bronzedust;
	public static Item bronzepowder;
	public static Item bronzeingot;
	public static Item stickydust;
	public static Item coloredslimeball;
	public static Item obsidiumingot;
	public static Item obsidiumgem;
	public static Item derpyingot;
	public static Item obsidiandust;
	public static Item obsidianpowder;
	public static Item obsidianingot;
	public static Item zincingot;
	public static Item zincdust;
	public static Item zincpowder;
	public static Item infernalcoal;
	public static Item largeplate;
	public static Item mediumplate;
	public static Item smallplate;
	public static Item smilespawner;
	public static Item electrumingot;
	public static Item brassingot;
	public static Item redstoniteingot;
	public static Item electrumdust;
	public static Item electrumpowder;
	public static Item brassdust;
	public static Item brasspowder;
	public static Item redstonitepowder;
	public static Item redstonitedust;
	public static Item sphenelump;
	public static Item sphenedust;
	public static Item sphenepowder;
	public static Item enrichedredstone;
	public static Item largeplatecluster;
	public static Item mediumplatecluster;
	public static Item smallplatecluster;
	public static Item moltenglass;
	public static Item heater;
	public static Item coil;
	public static Item energyabsorber;
	public static Item leaddust;
	public static Item leadpowder;
	public static Item leadingot;
	public static Item machinecapacitor;
	public static Item redstonitewire;
	public static Item portablecapacitor;
	public static Item photovoltaiccell;
	public static Item sanddust;
	public static Item siliconwafer;
	public static Item photovoltaicpanel;
	public static Item hardenedironingot;
	public static Item hardenedirondust;
	public static Item hardenedironpowder;
	public static Item drillhandle;
	public static Item drillgear;
	public static Item energizeddiamond;
	public static Item energizeddiamonddust;
	public static Item hardenedredstonedust;
	public static Item hardenedredstonepowder;
	public static Item hardenedlapispowder;
	public static Item hardenedlapisdust;
	public static Item upgradeRedstone;
	public static Item plate;
	public static Item WRScoordinator;
	public static Item whitestonedust;
	public static Item stonedust;
	public static Item potionmatrix;
	public static Item metaNugget;
	public static Item ash;
	public static Item ashFilter;
	public static Item glassTube;
	public static Item upgradeMining;
	public static Item upgradePipeRouting;
	public static Item superalloyIngot;
	public static Item superalloyDust;
	public static Item superalloyPowder;
	public static Item chromiumDust;
	public static Item cobaltDust;
	public static Item machineSieve;
	public static Item chromiumPowder;
	public static Item cobaltPowder;
	public static Item nickelIngot;
	public static Item nickelDust;
	public static Item nickelPowder;
	
	
	//tools ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	public static Item copperpickaxe;
	public static Item coppershovel;
	public static Item copperaxe;
	public static Item coppersword;
	public static Item copperhoe;
	public static Item bronzepickaxe;
	public static Item bronzeshovel;
	public static Item bronzeaxe;
	public static Item bronzesword;
	public static Item bronzehoe;
	public static Item steelpickaxe;
	public static Item steelshovel;
	public static Item steelaxe;
	public static Item steelsword;
	public static Item steelhoe;
	public static Item redstonepickaxe;
	public static Item redstoneshovel;
	public static Item redstoneaxe;
	public static Item redstonesword;
	public static Item redstonehoe;
	public static Item lapispickaxe;
	public static Item lapisshovel;
	public static Item lapisaxe;
	public static Item lapissword;
	public static Item lapishoe;
	public static Item obsidiumpickaxe;
	public static Item obsidiumshovel;
	public static Item obsidiumaxe;
	public static Item obsidiumsword;
	public static Item obsidiumhoe;
	public static Item derpypickaxe;
	public static Item derpyshovel;
	public static Item derpyaxe;
	public static Item derpysword;
	public static Item derpyhoe;
	public static Item ethericdrill;
	
	public static Item ironarrow;
	public static Item goldarrow;
	public static Item diamondarrow;
	public static Item copperarrow;
	public static Item bronzearrow;
	public static Item steelarrow;
	public static Item lapisarrow;
	public static Item redstonearrow;
	public static Item obsidiumarrow;
	public static Item derpyarrow;
	
	public static Item copperbow;
	public static Item bronzebow;
	public static Item steelbow;
	public static Item redstonebow;
	public static Item lapisbow;
	public static Item obsidiumbow;
	public static Item derpybow;
	public static Item ironbow;
	public static Item goldbow;
	public static Item diamondbow;
	
	public static Item copperhelmet;
	public static Item copperchestplate;
	public static Item copperleggings;
	public static Item copperboots;
	public static Item bronzehelmet;
	public static Item bronzechestplate;
	public static Item bronzeleggings;
	public static Item bronzeboots;
	public static Item steelhelmet;
	public static Item steelchestplate;
	public static Item steelleggings;
	public static Item steelboots;
	public static Item lapishelmet;
	public static Item lapischestplate;
	public static Item lapisleggings;
	public static Item lapisboots;
	public static Item redstonehelmet;
	public static Item redstonechestplate;
	public static Item redstoneleggings;
	public static Item redstoneboots;
	public static Item obsidiumhelmet;
	public static Item obsidiumchestplate;
	public static Item obsidiumleggings;
	public static Item obsidiumboots;
	public static Item derpyhelmet;
	public static Item derpychestplate;
	public static Item derpyleggings;
	public static Item derpyboots;
	
	public static Item wrench;
	public static Item glowstoneharvester;
	public static Item obsidianharvester;
	public static Item ethericwrench;
	public static Item woolcard;
	public static Item hammer;
	
	public static Item woodmultitool;
	public static Item stonemultitool;
	public static Item ironmultitool;
	public static Item goldmultitool;
	public static Item diamondmultitool;
	public static Item coppermultitool;
	public static Item bronzemultitool;
	public static Item steelmultitool;
	public static Item redstonemultitool;
	public static Item lapismultitool;
	public static Item obsidiummultitool;
	public static Item derpymultitool;

	//tool Materials ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static Item.ToolMaterial ToolCopper = EnumHelper.addToolMaterial("EC:NEMESIS:COPPER", 1, Evercraft_Config_Base.coppertoolsUSES, 2.5F, 0, 5);
	public static Item.ToolMaterial ToolBronze = EnumHelper.addToolMaterial("EC:NEMESIS:BRONZE", 2, Evercraft_Config_Base.bronzetoolsUSES, 3.0F, 0, 6);
	public static Item.ToolMaterial ToolSteel = EnumHelper.addToolMaterial("EC:NEMESIS:STEEL", 3, Evercraft_Config_Base.steeltoolsUSES, 6.5F, 2, 10);
	public static Item.ToolMaterial ToolRedstone = EnumHelper.addToolMaterial("EC:NEMESIS:REDSTONE", 2, Evercraft_Config_Base.redstonetoolsUSES, 5.0F, 3, 28);
	public static Item.ToolMaterial ToolLapis = EnumHelper.addToolMaterial("EC:NEMESIS:LAPISLAZULI", 2, Evercraft_Config_Base.lapistoolsUSES, 6.0F, 3, 9);
	public static Item.ToolMaterial ToolObsidium = EnumHelper.addToolMaterial("EC:NEMESIS:OBSIDIUM", 3, Evercraft_Config_Base.obsidiumtoolsUSES, 8.5F, 4, 18);
	public static Item.ToolMaterial ToolDerpy = EnumHelper.addToolMaterial("EC:NEMESIS:DERPY", 3, Evercraft_Config_Base.derpytoolsUSES, 12.0F, 10, 22);
	public static Item.ToolMaterial ToolEtheric = EnumHelper.addToolMaterial("EC:NEMESIS:ETHERIC", 3, 0, 8.0F, 3.0F, 0);

	//Armor Materials ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static ItemArmor.ArmorMaterial ArmorCopper = EnumHelper.addArmorMaterial("EC:NEMESIS:COPPER", Evercraft_Config_Base.copperarmorUSES, new int[]{2, 4, 3, 2}, 2);
	public static ItemArmor.ArmorMaterial ArmorBronze = EnumHelper.addArmorMaterial("EC:NEMESIS:BRONZE", Evercraft_Config_Base.bronzearmorUSES, new int[]{2, 7, 6, 2}, 3);
	public static ItemArmor.ArmorMaterial ArmorSteel = EnumHelper.addArmorMaterial("EC:NEMESIS:STEEL", Evercraft_Config_Base.steelarmorUSES, new int[]{3, 8, 6, 3}, 7);
	public static ItemArmor.ArmorMaterial ArmorRedstone = EnumHelper.addArmorMaterial("EC:NEMESIS:REDSTONE", Evercraft_Config_Base.redstonearmorUSES, new int[]{2, 7, 6, 2}, 20);
	public static ItemArmor.ArmorMaterial ArmorLapis = EnumHelper.addArmorMaterial("EC:NEMESIS:LAPISLAZULI", Evercraft_Config_Base.lapisarmorUSES, new int[]{2, 7, 6, 2}, 7);
	public static ItemArmor.ArmorMaterial ArmorObsidium = EnumHelper.addArmorMaterial("EC:NEMESIS:OBSIDIUM", Evercraft_Config_Base.obsidiumarmorUSES, new int[]{4, 10, 8, 4}, 15);
	public static ItemArmor.ArmorMaterial ArmorDerpy = EnumHelper.addArmorMaterial("EC:NEMESIS:DERPY", Evercraft_Config_Base.derpyarmorUSES, new int[]{8, 20, 16, 8}, 18);



	public static void init() {

		
		//Items ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


		ironstick = new ItemIronStick().setUnlocalizedName("ironstick");
		stonestick = new ItemStoneStick().setUnlocalizedName("stonestick");
		goldstick = new ItemGoldStick().setUnlocalizedName("goldstick");
		diamondstick = new ItemDiamondStick().setUnlocalizedName("diamondstick");
		obsidianstick = new ItemObsidianStick().setUnlocalizedName("obsidianstick");
		copperingot = new ItemCopperIngot().setUnlocalizedName("copperingot");
		tiningot = new ItemTinIngot().setUnlocalizedName("tiningot");
		silveringot = new ItemSilverIngot().setUnlocalizedName("silveringot");
		aluminiumingot = new ItemAluminiumIngot().setUnlocalizedName("aluminiumingot");
		titaniumingot = new ItemTitaniumIngot().setUnlocalizedName("titaniumingot");
		magneticlump = new ItemMagneticLump().setUnlocalizedName("magneticlump");
		magnet = new ItemMagnet().setUnlocalizedName("magnet");
		electromagnet = new ItemElectromagnet().setUnlocalizedName("electromagnet");
		stopsign = new ItemStopSign().setUnlocalizedName("stopsign");
		irongrinder = new ItemIronGrinder().setUnlocalizedName("irongrinder");
		irondust = new ItemIronDust().setUnlocalizedName("irondust");
		golddust = new ItemGoldDust().setUnlocalizedName("golddust");
		emeralddust = new ItemEmeraldDust().setUnlocalizedName("emeralddust");
		diamonddust = new ItemDiamondDust().setUnlocalizedName("diamonddust");
		coaldust = new ItemCoalDust().setUnlocalizedName("coaldust");
		lapislazulidust = new ItemLapisLazuliDust().setUnlocalizedName("lapislazulidust");
		copperdust = new ItemCopperDust().setUnlocalizedName("copperdust");
		tindust = new ItemTinDust().setUnlocalizedName("tindust");
		silverdust = new ItemSilverDust().setUnlocalizedName("silverdust");
		bauxitedust = new ItemBauxiteDust().setUnlocalizedName("bauxitedust");
		titaniumdust = new ItemTitaniumDust().setUnlocalizedName("titaniumdust");
		aluminiumdust = new ItemAluminiumDust().setUnlocalizedName("aluminiumdust");
		diamondgrinder = new ItemDiamondGrinder().setUnlocalizedName("diamondgrinder");
		netherbrickstick = new ItemNetherBrickStick().setUnlocalizedName("netherbrickstick");
		lapispowder = new ItemLapisLazuliPowder().setUnlocalizedName("lapispowder");
		ironpowder = new ItemIronPowder().setUnlocalizedName("ironpowder");
		goldpowder = new ItemGoldPowder().setUnlocalizedName("goldpowder");
		diamondpowder = new ItemDiamondPowder().setUnlocalizedName("diamondpowder");
		emeraldpowder = new ItemEmeraldPowder().setUnlocalizedName("emeraldpowder");
		redstonepowder = new ItemRedstonePowder().setUnlocalizedName("redstonepowder");
		tinpowder = new ItemTinPowder().setUnlocalizedName("tinpowder");
		copperpowder = new ItemCopperPowder().setUnlocalizedName("copperpowder");
		silverpowder = new ItemSilverPowder().setUnlocalizedName("silverpowder");
		bauxitepowder = new ItemBauxitePowder().setUnlocalizedName("bauxitepowder");
		titaniumpowder = new ItemTitaniumPowder().setUnlocalizedName("titaniumpowder");
		aluminiumpowder = new ItemAluminiumPowder().setUnlocalizedName("aluminiumpowder");
		coalpowder = new ItemCoalPowder().setUnlocalizedName("coalpowder");
		quartzdust = new ItemQuartzDust().setUnlocalizedName("quartzdust");
		steelingot = new ItemSteelIngot().setUnlocalizedName("steelingot");
		quartzpowder = new ItemQuartzPowder().setUnlocalizedName("quartzpowder");
		steeldust = new ItemSteelDust().setUnlocalizedName("steeldust");
		steelpowder = new ItemSteelPowder().setUnlocalizedName("steelpowder");
		hardenedlapisingot = new ItemHardenedLapisLazuliIngot().setUnlocalizedName("hardenedlapislazuliingot");
		hardenedredstoneingot = new ItemHardenedRedstoneIngot().setUnlocalizedName("hardenedredstoneingot");
		bronzedust = new ItemBronzeDust().setUnlocalizedName("bronzedust");
		bronzepowder = new ItemBronzePowder().setUnlocalizedName("bronzepowder");
		bronzeingot = new ItemBronzeIngot().setUnlocalizedName("bronzeingot");
		stickydust = new ItemStickyDust().setUnlocalizedName("stickydust");
		coloredslimeball = new ItemColoredSlimeBall().setUnlocalizedName("coloredslimeball");
		obsidiumingot = new ItemObsidiumIngot().setUnlocalizedName("obsidiumingot");
		obsidiumgem = new ItemObsidiumGem().setUnlocalizedName("obsidiumgem");
		derpyingot = new ItemDerpyIngot().setUnlocalizedName("derpyingot");
		obsidiandust = new ItemObsidianDust().setUnlocalizedName("obsidiandust");
		obsidianpowder = new ItemObsidianPowder().setUnlocalizedName("obsidianpowder");
		obsidianingot = new ItemObsidianIngot().setUnlocalizedName("obsidianingot");
		zincingot = new ItemZincIngot().setUnlocalizedName("zincingot");
		zincdust = new ItemZincDust().setUnlocalizedName("zincdust");
		zincpowder = new ItemZincPowder().setUnlocalizedName("zincpowder");
		infernalcoal = new ItemInfernalCoal().setUnlocalizedName("infernalcoal");
		largeplate = new ItemLargePlate().setUnlocalizedName("largeplate");
		mediumplate = new ItemMediumPlate().setUnlocalizedName("mediumplate");
		smallplate = new ItemSmallPlate().setUnlocalizedName("smallplate");
		smilespawner = new ItemSpawnSmile().setUnlocalizedName("smilespawner");
		electrumingot = new ItemElectrumIngot().setUnlocalizedName("electrumingot");
		brassingot = new ItemBrassIngot().setUnlocalizedName("brassingot");
		redstoniteingot = new ItemRedstoniteIngot().setUnlocalizedName("redstoniteingot");
		electrumdust = new ItemElectrumDust().setUnlocalizedName("electrumdust");
		electrumpowder = new ItemElectrumPowder().setUnlocalizedName("electrumpowder");
		redstonitedust = new ItemRedstoniteDust().setUnlocalizedName("redstonitedust");
		redstonitepowder = new ItemRedstonitePowder().setUnlocalizedName("redstonitepowder");
		brassdust = new ItemBrassDust().setUnlocalizedName("brassdust");
		brasspowder = new ItemBrassPowder().setUnlocalizedName("brasspowder");
		sphenelump = new ItemSpheneLump().setUnlocalizedName("sphenelump");
		sphenedust = new ItemSpheneDust().setUnlocalizedName("sphenedust");
		sphenepowder = new ItemSphenePowder().setUnlocalizedName("sphenepowder");
		enrichedredstone = new ItemEnrichedRedstone().setUnlocalizedName("enrichedredstone");
		largeplatecluster = new ItemLargePlateCluster().setUnlocalizedName("largeplatecluster");
		mediumplatecluster = new ItemMediumPlateCluster().setUnlocalizedName("mediumplatecluster");
		smallplatecluster = new ItemSmallPlateCluster().setUnlocalizedName("smallplatecluster");
		moltenglass = new ItemMoltenGlass().setUnlocalizedName("moltenglass");
		energyabsorber = new ItemRedstoneEnergyAbsorber().setUnlocalizedName("redstoneenergyabsorber");
		coil = new ItemConductanceCoil().setUnlocalizedName("conductancecoil");
		heater = new ItemRedstoneHeater().setUnlocalizedName("redstoneheater");
		leaddust = new ItemLeadDust().setUnlocalizedName("leaddust");
		leadpowder = new ItemLeadPowder().setUnlocalizedName("leadpowder");
		leadingot = new ItemLeadIngot().setUnlocalizedName("leadingot");
		ironarrow = new ItemIronArrow().setUnlocalizedName("ironarrow");
		goldarrow = new ItemGoldArrow().setUnlocalizedName("goldarrow");
		diamondarrow = new ItemDiamondArrow().setUnlocalizedName("diamondarrow");
		copperarrow = new ItemCopperArrow().setUnlocalizedName("copperarrow");
		bronzearrow = new ItemBronzeArrow().setUnlocalizedName("bronzearrow");
		steelarrow = new ItemSteelArrow().setUnlocalizedName("steelarrow");
		lapisarrow = new ItemLapisArrow().setUnlocalizedName("lapisarrow");
		redstonearrow = new ItemRedstoneArrow().setUnlocalizedName("redstonearrow");
		obsidiumarrow = new ItemObsidiumArrow().setUnlocalizedName("obsidiumarrow");
		derpyarrow = new ItemDerpyArrow().setUnlocalizedName("derpyarrow");
		machinecapacitor = new ItemMachineCapacitor().setUnlocalizedName("machinecapacitor");
		redstonitewire = new ItemRedstoniteWire().setUnlocalizedName("redstonitewire");
		portablecapacitor = new ItemPortableCapacitor().setUnlocalizedName("portablecapacitor");
		photovoltaiccell = new ItemPhotovoltaicCell().setUnlocalizedName("photovoltaiccell");
		sanddust = new ItemSandDust().setUnlocalizedName("sanddust");
		siliconwafer = new ItemSiliconWafer().setUnlocalizedName("siliconwafer");
		photovoltaicpanel = new ItemPhotovoltaicPanel().setUnlocalizedName("photovoltaicpanel");
		hardenedironingot = new ItemHardenedIronIngot().setUnlocalizedName("hardenedironingot");
		hardenedironpowder = new ItemHardenedIronPowder().setUnlocalizedName("hardenedironpowder");
		hardenedirondust = new ItemHardenedIronDust().setUnlocalizedName("hardenedirondust");
		drillhandle = new ItemDrillHandle().setUnlocalizedName("drillhandle");
		drillgear = new ItemDrillGear().setUnlocalizedName("drillgear");
		energizeddiamond = new ItemEnergizedDiamond().setUnlocalizedName("ethericcrystal");
		energizeddiamonddust = new ItemEnergizedDiamondDust().setUnlocalizedName("ethericcrystaldust");
		hardenedredstonedust = new ItemHardenedRedstoneDust().setUnlocalizedName("hardenedredstonedust");
		hardenedredstonepowder = new ItemHardenedRedstonePowder().setUnlocalizedName("hardenedredstonepowder");
		hardenedlapisdust = new ItemHardenedLapisDust().setUnlocalizedName("hardenedlapislazulidust");
		hardenedlapispowder = new ItemHardenedLapisPowder().setUnlocalizedName("hardenedlapislazulipowder");
		upgradeRedstone = new ItemUpgradeRedstone().setUnlocalizedName("upgrade_redstone");
		plate = new ItemStandardPlate().setUnlocalizedName("plate_standard");
		WRScoordinator = new ItemWirelessRedstoneCoordinator().setUnlocalizedName("wirelessRedstone_coordinator");
		stonedust = new ItemStoneDust().setUnlocalizedName("dust_stone");
		whitestonedust = new ItemWhitestoneDust().setUnlocalizedName("dust_whitestone");
		potionmatrix = new ItemPotionMatrix().setUnlocalizedName("potionMatrix");
		metaNugget = new ItemMetaNuggets().setUnlocalizedName("nugget");
		ash = new ItemAshDust().setUnlocalizedName("ash");
		ashFilter = new ItemAshFilter().setUnlocalizedName("ashFilter");
		glassTube = new ItemGlassTube(1000).setUnlocalizedName("glassTube");
		upgradeMining = new ItemUpgradeMiner().setUnlocalizedName("upgrade_mining");
		upgradePipeRouting = new ItemUpgradeRoutingPipe().setUnlocalizedName("upgrade_pipeRouter");
		superalloyIngot = new ItemSuperalloyIngot().setUnlocalizedName("superalloyIngot");
		superalloyPowder = new ItemSuperalloyPowder().setUnlocalizedName("superalloyPowder");
		superalloyDust = new ItemSuperalloyDust().setUnlocalizedName("superalloyDust");
		machineSieve = new ItemSieve().setUnlocalizedName("machineSieve");
		chromiumDust = new ItemChromeDust().setUnlocalizedName("chromiumDust");
		cobaltDust = new ItemCobaltDust().setUnlocalizedName("cobaltDust");
		chromiumPowder = new ItemChromePowder().setUnlocalizedName("chromiumPowder");
		cobaltPowder = new ItemCobaltPowder().setUnlocalizedName("cobaltPowder");
		nickelPowder = new ItemNickelPowder().setUnlocalizedName("nickelPowder");
		nickelDust = new ItemNickelDust().setUnlocalizedName("nickelDust");
		nickelIngot = new ItemNickelIngot().setUnlocalizedName("nickelIngot");
		
		//tools ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		woodmultitool = new ItemWoodenMultiTool(Item.ToolMaterial.WOOD).setUnlocalizedName("woodmultitool").setCreativeTab(ECTabs.tabECTools);
		stonemultitool = new ItemStoneMultiTool(Item.ToolMaterial.STONE).setUnlocalizedName("stonemultitool").setCreativeTab(ECTabs.tabECTools);
		ironmultitool = new ItemIronMultiTool(Item.ToolMaterial.IRON).setUnlocalizedName("ironmultitool").setCreativeTab(ECTabs.tabECTools);
		goldmultitool = new ItemGoldMultiTool(Item.ToolMaterial.GOLD).setUnlocalizedName("goldmultitool").setCreativeTab(ECTabs.tabECTools);
		diamondmultitool = new ItemDiamondMultiTool(Item.ToolMaterial.EMERALD).setUnlocalizedName("diamondmultitool").setCreativeTab(ECTabs.tabECTools);
		coppermultitool = new ItemCopperMultiTool(ToolCopper).setUnlocalizedName("coppermultitool").setCreativeTab(ECTabs.tabECTools);
		bronzemultitool = new ItemBronzeMultiTool(ToolBronze).setUnlocalizedName("bronzemultitool").setCreativeTab(ECTabs.tabECTools);
		steelmultitool = new ItemSteelMultiTool(ToolSteel).setUnlocalizedName("steelmultitool").setCreativeTab(ECTabs.tabECTools);
		redstonemultitool = new ItemRedstoneMultiTool(ToolRedstone).setUnlocalizedName("redstonemultitool").setCreativeTab(ECTabs.tabECTools);
		lapismultitool = new ItemLapisLazuliMultiTool(ToolLapis).setUnlocalizedName("lapismultitool").setCreativeTab(ECTabs.tabECTools);
		obsidiummultitool = new ItemObsidiumMultiTool(ToolObsidium).setUnlocalizedName("obsidiummultitool").setCreativeTab(ECTabs.tabECTools);
		derpymultitool = new ItemDerpyMultiTool(ToolDerpy).setUnlocalizedName("derpymultitool").setCreativeTab(ECTabs.tabECTools);
		
		copperpickaxe = new ItemCopperPickaxe(ToolCopper).setUnlocalizedName("copperpickaxe").setCreativeTab(ECTabs.tabECTools);
		coppershovel = new ItemCopperShovel(ToolCopper).setUnlocalizedName("coppershovel").setCreativeTab(ECTabs.tabECTools);
		copperaxe = new ItemCopperAxe(ToolCopper).setUnlocalizedName("copperaxe").setCreativeTab(ECTabs.tabECTools);
		coppersword = new ItemCopperSword(ToolCopper).setUnlocalizedName("coppersword").setCreativeTab(ECTabs.tabECTools);
		copperhoe = new ItemCopperHoe(ToolCopper).setUnlocalizedName("copperhoe").setCreativeTab(ECTabs.tabECTools);
		bronzepickaxe = new ItemBronzePickaxe(ToolBronze).setUnlocalizedName("bronzepickaxe").setCreativeTab(ECTabs.tabECTools);
		bronzeshovel = new ItemBronzeShovel(ToolBronze).setUnlocalizedName("bronzeshovel").setCreativeTab(ECTabs.tabECTools);
		bronzeaxe = new ItemBronzeAxe(ToolBronze).setUnlocalizedName("bronzeaxe").setCreativeTab(ECTabs.tabECTools);
		bronzesword = new ItemBronzeSword(ToolBronze).setUnlocalizedName("bronzesword").setCreativeTab(ECTabs.tabECTools);
		bronzehoe = new ItemBronzeHoe(ToolBronze).setUnlocalizedName("bronzehoe").setCreativeTab(ECTabs.tabECTools);
		steelpickaxe = new ItemSteelPickaxe(ToolSteel).setUnlocalizedName("steelpickaxe").setCreativeTab(ECTabs.tabECTools);
		steelshovel = new ItemSteelShovel(ToolSteel).setUnlocalizedName("steelshovel").setCreativeTab(ECTabs.tabECTools);
		steelaxe = new ItemSteelAxe(ToolSteel).setUnlocalizedName("steelaxe").setCreativeTab(ECTabs.tabECTools);
		steelsword = new ItemSteelSword(ToolSteel).setUnlocalizedName("steelsword").setCreativeTab(ECTabs.tabECTools);
		steelhoe = new ItemSteelHoe(ToolSteel).setUnlocalizedName("steelhoe").setCreativeTab(ECTabs.tabECTools);
		redstonepickaxe = new ItemRedstonePickaxe(ToolRedstone).setUnlocalizedName("redstonepickaxe").setCreativeTab(ECTabs.tabECTools);
		redstoneshovel = new ItemRedstoneShovel(ToolRedstone).setUnlocalizedName("redstoneshovel").setCreativeTab(ECTabs.tabECTools);
		redstoneaxe = new ItemRedstoneAxe(ToolRedstone).setUnlocalizedName("redstoneaxe").setCreativeTab(ECTabs.tabECTools);
		redstonesword = new ItemRedstoneSword(ToolRedstone).setUnlocalizedName("redstonesword").setCreativeTab(ECTabs.tabECTools);
		redstonehoe = new ItemRedstoneHoe(ToolRedstone).setUnlocalizedName("redstonehoe").setCreativeTab(ECTabs.tabECTools);
		lapispickaxe = new ItemLapisLazuliPickaxe(ToolLapis).setUnlocalizedName("lapislazulipickaxe").setCreativeTab(ECTabs.tabECTools);
		lapisshovel = new ItemLapisShovel(ToolLapis).setUnlocalizedName("lapislazulishovel").setCreativeTab(ECTabs.tabECTools);
		lapisaxe = new ItemLapisAxe(ToolLapis).setUnlocalizedName("lapislazuliaxe").setCreativeTab(ECTabs.tabECTools);
		lapissword = new ItemLapisSword(ToolLapis).setUnlocalizedName("lapislazulisword").setCreativeTab(ECTabs.tabECTools);
		lapishoe = new ItemLapisHoe(ToolLapis).setUnlocalizedName("lapislazulihoe").setCreativeTab(ECTabs.tabECTools);
		obsidiumpickaxe = new ItemObsidiumPickaxe(ToolObsidium).setUnlocalizedName("obsidiumpickaxe").setCreativeTab(ECTabs.tabECTools);
		obsidiumshovel = new ItemObsidiumShovel(ToolObsidium).setUnlocalizedName("obsidiumshovel").setCreativeTab(ECTabs.tabECTools);
		obsidiumaxe = new ItemObsidiumAxe(ToolObsidium).setUnlocalizedName("obsidiumaxe").setCreativeTab(ECTabs.tabECTools);
		obsidiumsword = new ItemObsidiumSword(ToolObsidium).setUnlocalizedName("obsidiumsword").setCreativeTab(ECTabs.tabECTools);
		obsidiumhoe = new ItemObsidiumHoe(ToolObsidium).setUnlocalizedName("obsidiumhoe").setCreativeTab(ECTabs.tabECTools);
		derpypickaxe = new ItemDerpyPickaxe(ToolDerpy).setUnlocalizedName("derpypickaxe").setCreativeTab(ECTabs.tabECTools);
		derpyshovel = new ItemDerpyShovel(ToolDerpy).setUnlocalizedName("derpyshovel").setCreativeTab(ECTabs.tabECTools);
		derpyaxe = new ItemDerpyAxe(ToolDerpy).setUnlocalizedName("derpyaxe").setCreativeTab(ECTabs.tabECTools);
		derpysword = new ItemDerpySword(ToolDerpy).setUnlocalizedName("derpysword").setCreativeTab(ECTabs.tabECTools);
		derpyhoe = new ItemDerpyHoe(ToolDerpy).setUnlocalizedName("derpyhoe").setCreativeTab(ECTabs.tabECTools);
		copperbow = new ItemCopperBow().setUnlocalizedName("copperbow").setCreativeTab(ECTabs.tabECTools);
		bronzebow = new ItemBronzeBow().setUnlocalizedName("bronzebow").setCreativeTab(ECTabs.tabECTools);
		steelbow = new ItemSteelBow().setUnlocalizedName("steelbow").setCreativeTab(ECTabs.tabECTools);
		lapisbow = new ItemLapisBow().setUnlocalizedName("lapisbow").setCreativeTab(ECTabs.tabECTools);
		redstonebow = new ItemRedstoneBow().setUnlocalizedName("redstonebow").setCreativeTab(ECTabs.tabECTools);
		obsidiumbow = new ItemObsidiumBow().setUnlocalizedName("obsidiumbow").setCreativeTab(ECTabs.tabECTools);
		derpybow = new ItemDerpyBow().setUnlocalizedName("derpybow").setCreativeTab(ECTabs.tabECTools);
		ironbow = new ItemIronBow().setUnlocalizedName("ironbow").setCreativeTab(ECTabs.tabECTools);
		goldbow = new ItemGoldBow().setUnlocalizedName("goldbow").setCreativeTab(ECTabs.tabECTools);
		diamondbow = new ItemDiamondBow().setUnlocalizedName("diamondbow").setCreativeTab(ECTabs.tabECTools);
		ethericdrill = new ItemEthericDrill(ToolEtheric).setUnlocalizedName("drill").setCreativeTab(ECTabs.tabECTools);
		
		int renderCopperArmor = Evercraft.proxy.addArmor("copperarmor");
		int renderBronzeArmor = Evercraft.proxy.addArmor("bronzearmor");
		int renderSteelArmor = Evercraft.proxy.addArmor("steelarmor");
		int renderLapisArmor = Evercraft.proxy.addArmor("lapisarmor");
		int renderRedstoneArmor = Evercraft.proxy.addArmor("redstonearmor");
		int renderObsidiumArmor = Evercraft.proxy.addArmor("obsidiumarmor");
		int renderDerpyArmor = Evercraft.proxy.addArmor("derpyarmor");
		
		copperhelmet = new ItemCopperHelmet(ArmorCopper, renderCopperArmor, 0).setUnlocalizedName("copperhelmet").setCreativeTab(ECTabs.tabECTools);
		copperchestplate = new ItemCopperChestplate(ArmorCopper, renderCopperArmor, 1).setUnlocalizedName("copperchestplate").setCreativeTab(ECTabs.tabECTools);
		copperleggings = new ItemCopperLeggings(ArmorCopper, renderCopperArmor, 2).setUnlocalizedName("copperleggings").setCreativeTab(ECTabs.tabECTools);
		copperboots = new ItemCopperBoots(ArmorCopper, renderCopperArmor, 3).setUnlocalizedName("copperboots").setCreativeTab(ECTabs.tabECTools);
		bronzehelmet = new ItemBronzeHelmet(ArmorBronze, renderBronzeArmor, 0).setUnlocalizedName("bronzehelmet").setCreativeTab(ECTabs.tabECTools);
		bronzechestplate = new ItemBronzeChestplate(ArmorBronze, renderBronzeArmor, 1).setUnlocalizedName("bronzechestplate").setCreativeTab(ECTabs.tabECTools);
		bronzeleggings = new ItemBronzeLeggings(ArmorBronze, renderBronzeArmor, 2).setUnlocalizedName("bronzeleggings").setCreativeTab(ECTabs.tabECTools);
		bronzeboots = new ItemBronzeBoots(ArmorBronze, renderBronzeArmor, 3).setUnlocalizedName("bronzeboots").setCreativeTab(ECTabs.tabECTools);
		steelhelmet = new ItemSteelHelmet(ArmorSteel, renderSteelArmor, 0).setUnlocalizedName("steelhelmet").setCreativeTab(ECTabs.tabECTools);
		steelchestplate = new ItemSteelChestplate(ArmorSteel, renderSteelArmor, 1).setUnlocalizedName("steelchestplate").setCreativeTab(ECTabs.tabECTools);
		steelleggings = new ItemSteelLeggings(ArmorSteel, renderSteelArmor, 2).setUnlocalizedName("steelleggings").setCreativeTab(ECTabs.tabECTools);
		steelboots = new ItemSteelBoots(ArmorSteel, renderSteelArmor, 3).setUnlocalizedName("steelboots").setCreativeTab(ECTabs.tabECTools);
		lapishelmet = new ItemLapisHelmet(ArmorLapis, renderLapisArmor, 0).setUnlocalizedName("lapishelmet").setCreativeTab(ECTabs.tabECTools);
		lapischestplate = new ItemLapisChestplate(ArmorLapis, renderLapisArmor, 1).setUnlocalizedName("lapischestplate").setCreativeTab(ECTabs.tabECTools);
		lapisleggings = new ItemLapisLeggings(ArmorLapis, renderLapisArmor, 2).setUnlocalizedName("lapisleggings").setCreativeTab(ECTabs.tabECTools);
		lapisboots = new ItemLapisBoots(ArmorLapis, renderLapisArmor, 3).setUnlocalizedName("lapisboots").setCreativeTab(ECTabs.tabECTools);
		redstonehelmet = new ItemRedstoneHelmet(ArmorRedstone, renderRedstoneArmor, 0).setUnlocalizedName("redstonehelmet").setCreativeTab(ECTabs.tabECTools);
		redstonechestplate = new ItemRedstoneChestplate(ArmorRedstone, renderRedstoneArmor, 1).setUnlocalizedName("redstonechestplate").setCreativeTab(ECTabs.tabECTools);
		redstoneleggings = new ItemRedstoneLeggings(ArmorRedstone, renderRedstoneArmor, 2).setUnlocalizedName("redstoneleggings").setCreativeTab(ECTabs.tabECTools);
		redstoneboots = new ItemRedstoneBoots(ArmorRedstone, renderRedstoneArmor, 3).setUnlocalizedName("redstoneboots").setCreativeTab(ECTabs.tabECTools);
		obsidiumhelmet = new ItemObsidiumHelmet(ArmorObsidium, renderObsidiumArmor, 0).setUnlocalizedName("obsidiumhelmet").setCreativeTab(ECTabs.tabECTools);
		obsidiumchestplate = new ItemObsidiumChestplate(ArmorObsidium, renderObsidiumArmor, 1).setUnlocalizedName("obsidiumchestplate").setCreativeTab(ECTabs.tabECTools);
		obsidiumleggings = new ItemObsidiumLeggings(ArmorObsidium, renderObsidiumArmor, 2).setUnlocalizedName("obsidiumleggings").setCreativeTab(ECTabs.tabECTools);
		obsidiumboots = new ItemObsidiumBoots(ArmorObsidium, renderObsidiumArmor, 3).setUnlocalizedName("obsidiumboots").setCreativeTab(ECTabs.tabECTools);
		derpyhelmet = new ItemDerpyHelmet(ArmorDerpy, renderDerpyArmor, 0).setUnlocalizedName("derpyhelmet").setCreativeTab(ECTabs.tabECTools);
		derpychestplate = new ItemDerpyChestplate(ArmorDerpy, renderDerpyArmor, 1).setUnlocalizedName("derpychestplate").setCreativeTab(ECTabs.tabECTools);
		derpyleggings = new ItemDerpyLeggings(ArmorDerpy, renderDerpyArmor, 2).setUnlocalizedName("derpyleggings").setCreativeTab(ECTabs.tabECTools);
		derpyboots = new ItemDerpyBoots(ArmorDerpy, renderDerpyArmor, 3).setUnlocalizedName("derpyboots").setCreativeTab(ECTabs.tabECTools);
		
		wrench = new ItemWrench().setUnlocalizedName("wrench");
		glowstoneharvester = new ItemGlowstoneHarvester().setUnlocalizedName("glowstoneharvester");
		obsidianharvester = new ItemObsidianHarvester().setUnlocalizedName("obsidianharvester");
		woolcard = new ItemWoolCard().setUnlocalizedName("woolcard");
		ethericwrench = new ItemEthericWrench().setUnlocalizedName("ethericwrench");
		hammer = new ItemHammer().setUnlocalizedName("hammer");
		
		
		 Evercraft.log.info("Items created");
		//Item Registry -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		//MiscCraft Tab
		GameRegistry.registerItem(potionmatrix, "potionMatrix", ModInformation.ID);
		GameRegistry.registerItem(glassTube, "glassTube");
		 
		//Sticks
		GameRegistry.registerItem(ironstick, "ironstick", ModInformation.ID);
		GameRegistry.registerItem(stonestick, "stonestick", ModInformation.ID);
		GameRegistry.registerItem(goldstick, "goldstick", ModInformation.ID);
		GameRegistry.registerItem(diamondstick, "diamondstick", ModInformation.ID);
		GameRegistry.registerItem(obsidianstick, "obsidianstick", ModInformation.ID);
		GameRegistry.registerItem(netherbrickstick, "netherbrickstick", ModInformation.ID);

		//Misc
		GameRegistry.registerItem(stopsign, "stopsign", ModInformation.ID);
		GameRegistry.registerItem(stickydust, "stickydust", ModInformation.ID);
		GameRegistry.registerItem(smilespawner, "smilespawner", ModInformation.ID);
		GameRegistry.registerItem(moltenglass, "moltenglass", ModInformation.ID);
		
		//Capacitors
		GameRegistry.registerItem(machinecapacitor, "machinecapacitor", ModInformation.ID);
		GameRegistry.registerItem(portablecapacitor, "portablecapacitor", ModInformation.ID);
		GameRegistry.registerItem(energizeddiamond, "ethericcrystal", ModInformation.ID);
		
		//Upgrades
		GameRegistry.registerItem(upgradeRedstone, "upgrade_redstone", ModInformation.ID);
		GameRegistry.registerItem(upgradeMining, "upgrade_mining", ModInformation.ID);
		GameRegistry.registerItem(upgradePipeRouting, "upgrade_pipeRouter", ModInformation.ID);
		
		//Technical
		GameRegistry.registerItem(magnet, "magnet", ModInformation.ID);
		GameRegistry.registerItem(electromagnet, "electromagnet", ModInformation.ID);
		GameRegistry.registerItem(irongrinder, "irongrinder", ModInformation.ID);
		GameRegistry.registerItem(diamondgrinder, "diamondgrinder", ModInformation.ID);
		GameRegistry.registerItem(heater, "heater", ModInformation.ID);
		GameRegistry.registerItem(coil, "coil", ModInformation.ID);
		GameRegistry.registerItem(energyabsorber, "energyabsorber", ModInformation.ID);
		GameRegistry.registerItem(redstonitewire, "redstonitewire", ModInformation.ID);
		GameRegistry.registerItem(siliconwafer, "siliconwafer", ModInformation.ID);
		GameRegistry.registerItem(photovoltaiccell, "photovoltaiccell", ModInformation.ID);
		GameRegistry.registerItem(photovoltaicpanel, "photovoltaicpanel", ModInformation.ID);
		GameRegistry.registerItem(drillhandle, "drillhandle", ModInformation.ID);
		GameRegistry.registerItem(drillgear, "drillgear", ModInformation.ID);
		GameRegistry.registerItem(ashFilter, "ashFilter", ModInformation.ID);
		GameRegistry.registerItem(machineSieve, "machineSieve", ModInformation.ID);
		
		//Slimeballs
		GameRegistry.registerItem(coloredslimeball, "coloredslimeball", ModInformation.ID);
		
		//Ingots
		GameRegistry.registerItem(copperingot, "copperingot", ModInformation.ID);
		GameRegistry.registerItem(tiningot, "tiningot", ModInformation.ID);
		GameRegistry.registerItem(silveringot, "silveringot", ModInformation.ID);
		GameRegistry.registerItem(aluminiumingot, "aluminiumingot", ModInformation.ID);
		GameRegistry.registerItem(titaniumingot, "titaniumingot", ModInformation.ID);
		GameRegistry.registerItem(steelingot, "steelingot", ModInformation.ID);
		GameRegistry.registerItem(hardenedlapisingot, "lapisingot", ModInformation.ID);
		GameRegistry.registerItem(hardenedredstoneingot, "redstoneingot", ModInformation.ID);
		GameRegistry.registerItem(bronzeingot, "bronzeingot", ModInformation.ID);
		GameRegistry.registerItem(obsidiumingot, "obsidiumingot", ModInformation.ID);
		GameRegistry.registerItem(derpyingot, "derpyingot", ModInformation.ID);
		GameRegistry.registerItem(obsidianingot, "obsidianingot", ModInformation.ID);
		GameRegistry.registerItem(zincingot, "zincingot", ModInformation.ID);
		GameRegistry.registerItem(brassingot, "brassingot", ModInformation.ID);
		GameRegistry.registerItem(electrumingot, "electrumingot", ModInformation.ID);
		GameRegistry.registerItem(redstoniteingot, "redstoniteingot", ModInformation.ID);
		GameRegistry.registerItem(leadingot, "leadingot", ModInformation.ID);
		GameRegistry.registerItem(hardenedironingot, "hardenedironingot", ModInformation.ID);
		GameRegistry.registerItem(superalloyIngot, "superalloyIngot", ModInformation.ID);
		GameRegistry.registerItem(nickelIngot, "nickelIngot", ModInformation.ID);
		
		//Lumps
		GameRegistry.registerItem(magneticlump, "magneticlump", ModInformation.ID);
		GameRegistry.registerItem(sphenelump, "sphenelump", ModInformation.ID);
		
		//Gems
		GameRegistry.registerItem(obsidiumgem, "obsidiumgem", ModInformation.ID);
		GameRegistry.registerItem(infernalcoal, "infernalcoal", ModInformation.ID);
		
		//Dusts
		GameRegistry.registerItem(irondust, "irondust", ModInformation.ID);
		GameRegistry.registerItem(golddust, "golddust", ModInformation.ID);
		GameRegistry.registerItem(emeralddust, "emeralddust", ModInformation.ID);
		GameRegistry.registerItem(diamonddust, "diamonddust", ModInformation.ID);
		GameRegistry.registerItem(coaldust, "coaldust", ModInformation.ID);
		GameRegistry.registerItem(lapislazulidust, "lapisdust", ModInformation.ID);
		GameRegistry.registerItem(copperdust, "copperdust", ModInformation.ID);
		GameRegistry.registerItem(tindust, "tindust", ModInformation.ID);
		GameRegistry.registerItem(silverdust, "silverdust", ModInformation.ID);
		GameRegistry.registerItem(bauxitedust, "bauxitedust", ModInformation.ID);
		GameRegistry.registerItem(titaniumdust, "titaniumdust", ModInformation.ID);
		GameRegistry.registerItem(aluminiumdust, "aluminiumdust", ModInformation.ID);
		GameRegistry.registerItem(quartzdust, "quartzdust", ModInformation.ID);
		GameRegistry.registerItem(steeldust, "steeldust", ModInformation.ID);
		GameRegistry.registerItem(bronzedust, "bronzedust", ModInformation.ID);
		GameRegistry.registerItem(obsidiandust, "obsidiandust", ModInformation.ID);
		GameRegistry.registerItem(zincdust, "zincdust", ModInformation.ID);
		GameRegistry.registerItem(brassdust, "brassdust", ModInformation.ID);
		GameRegistry.registerItem(electrumdust, "electrumdust", ModInformation.ID);
		GameRegistry.registerItem(redstonitedust, "redstonitedust", ModInformation.ID);
		GameRegistry.registerItem(sphenedust, "sphenedust", ModInformation.ID);
		GameRegistry.registerItem(enrichedredstone, "enrichedredstone", ModInformation.ID);
		GameRegistry.registerItem(leaddust, "leaddust", ModInformation.ID);
		GameRegistry.registerItem(sanddust, "sanddust", ModInformation.ID);
		GameRegistry.registerItem(hardenedirondust, "hardenedirondust", ModInformation.ID);
		GameRegistry.registerItem(energizeddiamonddust, "crystalizedethericdust", ModInformation.ID);
		GameRegistry.registerItem(hardenedredstonedust, "hardenedredstonedust", ModInformation.ID);
		GameRegistry.registerItem(hardenedlapisdust, "hardenedlapislazulidust", ModInformation.ID);
		GameRegistry.registerItem(stonedust, "stonedust", ModInformation.ID);
		GameRegistry.registerItem(whitestonedust, "whitestonedust", ModInformation.ID);
		GameRegistry.registerItem(ash, "ash", ModInformation.ID);
		GameRegistry.registerItem(superalloyDust, "superalloyDust", ModInformation.ID);
		GameRegistry.registerItem(cobaltDust, "cobaltDust", ModInformation.ID);
		GameRegistry.registerItem(chromiumDust, "chromiumDust", ModInformation.ID);
		GameRegistry.registerItem(nickelDust, "nickelDust", ModInformation.ID);
		
		//Powders
		GameRegistry.registerItem(lapispowder, "lapispowder", ModInformation.ID);
		GameRegistry.registerItem(ironpowder, "ironpowder", ModInformation.ID);
		GameRegistry.registerItem(goldpowder, "goldpowder", ModInformation.ID);
		GameRegistry.registerItem(diamondpowder, "diamondpowder", ModInformation.ID);
		GameRegistry.registerItem(emeraldpowder, "emeraldpowder", ModInformation.ID);
		GameRegistry.registerItem(redstonepowder, "redstonepowder", ModInformation.ID);
		GameRegistry.registerItem(tinpowder, "tinpowder", ModInformation.ID);
		GameRegistry.registerItem(copperpowder, "copperpowder", ModInformation.ID);
		GameRegistry.registerItem(silverpowder, "silverpowder", ModInformation.ID);
		GameRegistry.registerItem(bauxitepowder, "bauxitepowder", ModInformation.ID);
		GameRegistry.registerItem(titaniumpowder, "titaniumpowder", ModInformation.ID);
		GameRegistry.registerItem(aluminiumpowder, "aluminiumpowder", ModInformation.ID);
		GameRegistry.registerItem(coalpowder, "coalpowder", ModInformation.ID);
		GameRegistry.registerItem(quartzpowder, "quartzpowder", ModInformation.ID);
		GameRegistry.registerItem(steelpowder, "steelpowder", ModInformation.ID);
		GameRegistry.registerItem(bronzepowder, "bronzepowder", ModInformation.ID);
		GameRegistry.registerItem(obsidianpowder, "obsidianpowder", ModInformation.ID);
		GameRegistry.registerItem(zincpowder, "zincpowder", ModInformation.ID);
		GameRegistry.registerItem(brasspowder, "brasspowder", ModInformation.ID);
		GameRegistry.registerItem(electrumpowder, "electrumpowder", ModInformation.ID);
		GameRegistry.registerItem(redstonitepowder, "redstonitepowder", ModInformation.ID);
		GameRegistry.registerItem(sphenepowder, "sphenepowder", ModInformation.ID);
		GameRegistry.registerItem(leadpowder, "leadpowder", ModInformation.ID);
		GameRegistry.registerItem(hardenedironpowder, "hardenedironpowder", ModInformation.ID);
		GameRegistry.registerItem(hardenedredstonepowder, "hardenedredstonepowder", ModInformation.ID);
		GameRegistry.registerItem(hardenedlapispowder, "hardenedlapislazulipowder", ModInformation.ID);
		GameRegistry.registerItem(superalloyPowder, "superalloyPowder", ModInformation.ID);
		GameRegistry.registerItem(cobaltPowder, "cobaltPowder", ModInformation.ID);
		GameRegistry.registerItem(chromiumPowder, "chromiumPowder", ModInformation.ID);
		GameRegistry.registerItem(nickelPowder, "nickelPowder", ModInformation.ID);
		
		//Nuggets
		GameRegistry.registerItem(metaNugget, "nugget", ModInformation.ID);
		
		//Stadard Plates
		GameRegistry.registerItem(plate, "plate_standard", ModInformation.ID);
		
		//Small Plates
		GameRegistry.registerItem(smallplate, "smallplate", ModInformation.ID);
		
		//Small Plate Clusters
		GameRegistry.registerItem(smallplatecluster, "smallplatecluster", ModInformation.ID);
		
		//Medium Plates
		GameRegistry.registerItem(mediumplate, "mediumplate", ModInformation.ID);
		
		//Medium Plate Clusters
		GameRegistry.registerItem(mediumplatecluster, "mediumplatecluster", ModInformation.ID);
		
		//Large Plates
		GameRegistry.registerItem(largeplate, "largeplate", ModInformation.ID);
		
		//Large Plate Clusters
		GameRegistry.registerItem(largeplatecluster, "largeplatecluster", ModInformation.ID);
		
		//Misc Tools/Armor
		GameRegistry.registerItem(wrench, "wrench", ModInformation.ID);
		GameRegistry.registerItem(hammer, "hammer", ModInformation.ID);
		GameRegistry.registerItem(ethericwrench, "ethericwrench", ModInformation.ID);
		GameRegistry.registerItem(ethericdrill, "drill", ModInformation.ID);
		GameRegistry.registerItem(glowstoneharvester, "glowstoneharvester", ModInformation.ID);
		GameRegistry.registerItem(obsidianharvester, "obsidianharvester", ModInformation.ID);
		GameRegistry.registerItem(woolcard, "woolcard", ModInformation.ID);
		GameRegistry.registerItem(WRScoordinator, "wirelessRedstone_coordinator", ModInformation.ID);
		
		//Wooden Tools/Armor
		GameRegistry.registerItem(woodmultitool, "woodmultitool", ModInformation.ID);
		
		//Stone Tools/Armor
		GameRegistry.registerItem(stonemultitool, "stonemultitool", ModInformation.ID);
		
		//Iron Tools/Armor
		GameRegistry.registerItem(ironmultitool, "ironmultitool", ModInformation.ID);
		GameRegistry.registerItem(ironbow, "ironbow", ModInformation.ID);
		GameRegistry.registerItem(ironarrow, "ironarrow", ModInformation.ID);
		
		//Golden Tools/Armor
		GameRegistry.registerItem(goldmultitool, "goldmultitool", ModInformation.ID);
		GameRegistry.registerItem(goldbow, "goldbow", ModInformation.ID);
		GameRegistry.registerItem(goldarrow, "goldarrow", ModInformation.ID);
		
		//Diamond Tools/Armor
		GameRegistry.registerItem(diamondmultitool, "diamondmultitool", ModInformation.ID);
		GameRegistry.registerItem(diamondbow, "diamondbow", ModInformation.ID);
		GameRegistry.registerItem(diamondarrow, "diamondarrow", ModInformation.ID);
		
		//Copper Tools/Armor
		GameRegistry.registerItem(copperpickaxe, "copperpickaxe", ModInformation.ID);
		GameRegistry.registerItem(coppershovel, "coppershovel", ModInformation.ID);
		GameRegistry.registerItem(copperaxe, "copperaxe", ModInformation.ID);
		GameRegistry.registerItem(coppersword, "coppersword", ModInformation.ID);
		GameRegistry.registerItem(copperhoe, "copperhoe", ModInformation.ID);
		GameRegistry.registerItem(coppermultitool, "coppermultitool", ModInformation.ID);
		GameRegistry.registerItem(copperbow, "copperbow", ModInformation.ID);
		GameRegistry.registerItem(copperarrow, "copperarrow", ModInformation.ID);
		GameRegistry.registerItem(copperhelmet, "copperhelmet", ModInformation.ID);
		GameRegistry.registerItem(copperchestplate, "copperchestplate", ModInformation.ID);
		GameRegistry.registerItem(copperleggings, "copperleggings", ModInformation.ID);
		GameRegistry.registerItem(copperboots, "copperboots", ModInformation.ID);
		
		//Bronze Tools/Armor
		GameRegistry.registerItem(bronzepickaxe, "bronzepickaxe", ModInformation.ID);
		GameRegistry.registerItem(bronzeshovel, "bronzeshovel", ModInformation.ID);
		GameRegistry.registerItem(bronzeaxe, "bronzeaxe", ModInformation.ID);
		GameRegistry.registerItem(bronzesword, "bronzesword", ModInformation.ID);
		GameRegistry.registerItem(bronzehoe, "bronzehoe", ModInformation.ID);
		GameRegistry.registerItem(bronzemultitool, "bronzemultitool", ModInformation.ID);
		GameRegistry.registerItem(bronzebow, "bronzebow", ModInformation.ID);
		GameRegistry.registerItem(bronzearrow, "bronzearrow", ModInformation.ID);
		GameRegistry.registerItem(bronzehelmet, "bronzehelmet", ModInformation.ID);
		GameRegistry.registerItem(bronzechestplate, "bronzechestplate", ModInformation.ID);
		GameRegistry.registerItem(bronzeleggings, "bronzeleggings", ModInformation.ID);
		GameRegistry.registerItem(bronzeboots, "bronzeboots", ModInformation.ID);
		
		//Steel Tools/Armor
		GameRegistry.registerItem(steelpickaxe, "steelpickaxe", ModInformation.ID);
		GameRegistry.registerItem(steelshovel, "steelshovel", ModInformation.ID);
		GameRegistry.registerItem(steelaxe, "steelaxe", ModInformation.ID);
		GameRegistry.registerItem(steelsword, "steelsword", ModInformation.ID);
		GameRegistry.registerItem(steelhoe, "steelhoe", ModInformation.ID);
		GameRegistry.registerItem(steelmultitool, "steelmultitool", ModInformation.ID);
		GameRegistry.registerItem(steelbow, "steelbow", ModInformation.ID);
		GameRegistry.registerItem(steelarrow, "steelarrow", ModInformation.ID);
		GameRegistry.registerItem(steelhelmet, "steelhelmet", ModInformation.ID);
		GameRegistry.registerItem(steelchestplate, "steelchestplate", ModInformation.ID);
		GameRegistry.registerItem(steelleggings, "steelleggings", ModInformation.ID);
		GameRegistry.registerItem(steelboots, "steelboots", ModInformation.ID);
		
		//Redstone Tools/Armor
		GameRegistry.registerItem(redstonepickaxe, "redstonepickaxe", ModInformation.ID);
		GameRegistry.registerItem(redstoneshovel, "redstoneshovel", ModInformation.ID);
		GameRegistry.registerItem(redstoneaxe, "redstoneaxe", ModInformation.ID);
		GameRegistry.registerItem(redstonesword, "redstonesword", ModInformation.ID);
		GameRegistry.registerItem(redstonehoe, "redstonehoe", ModInformation.ID);
		GameRegistry.registerItem(redstonemultitool, "redstonemultitool", ModInformation.ID);
		GameRegistry.registerItem(redstonebow, "redstonebow", ModInformation.ID);
		GameRegistry.registerItem(redstonearrow, "redstonearrow", ModInformation.ID);
		GameRegistry.registerItem(redstonehelmet, "redstonehelmet", ModInformation.ID);
		GameRegistry.registerItem(redstonechestplate, "redstonechestplate", ModInformation.ID);
		GameRegistry.registerItem(redstoneleggings, "redstoneleggings", ModInformation.ID);
		GameRegistry.registerItem(redstoneboots, "redstoneboots", ModInformation.ID);
		
		//Lapis Tools/Armor
		GameRegistry.registerItem(lapispickaxe, "lapispickaxe", ModInformation.ID);
		GameRegistry.registerItem(lapisshovel, "lapisshovel", ModInformation.ID);
		GameRegistry.registerItem(lapisaxe, "lapisaxe", ModInformation.ID);
		GameRegistry.registerItem(lapissword, "lapissword", ModInformation.ID);
		GameRegistry.registerItem(lapishoe, "lapishoe", ModInformation.ID);
		GameRegistry.registerItem(lapismultitool, "lapismultitool", ModInformation.ID);
		GameRegistry.registerItem(lapisbow, "lapisbow", ModInformation.ID);
		GameRegistry.registerItem(lapisarrow, "lapisarrow", ModInformation.ID);
		GameRegistry.registerItem(lapishelmet, "lapishelmet", ModInformation.ID);
		GameRegistry.registerItem(lapischestplate, "lapischestplate", ModInformation.ID);
		GameRegistry.registerItem(lapisleggings, "lapisleggings", ModInformation.ID);
		GameRegistry.registerItem(lapisboots, "lapisboots", ModInformation.ID);
		
		//Obsidium Tools/Armor
		GameRegistry.registerItem(obsidiumpickaxe, "obsidiumpickaxe", ModInformation.ID);
		GameRegistry.registerItem(obsidiumshovel, "obsidiumshovel", ModInformation.ID);
		GameRegistry.registerItem(obsidiumaxe, "obsidiumaxe", ModInformation.ID);
		GameRegistry.registerItem(obsidiumsword, "obsidiumsword", ModInformation.ID);
		GameRegistry.registerItem(obsidiumhoe, "obsidiumhoe", ModInformation.ID);
		GameRegistry.registerItem(obsidiummultitool, "obsidiummultitool", ModInformation.ID);
		GameRegistry.registerItem(obsidiumbow, "obsidiumbow", ModInformation.ID);
		GameRegistry.registerItem(obsidiumarrow, "obsidiumarrow", ModInformation.ID);
		GameRegistry.registerItem(obsidiumhelmet, "obsidiumhelmet", ModInformation.ID);
		GameRegistry.registerItem(obsidiumchestplate, "obsidiumchestplate", ModInformation.ID);
		GameRegistry.registerItem(obsidiumleggings, "obsidiumleggings", ModInformation.ID);
		GameRegistry.registerItem(obsidiumboots, "obsidiumboots", ModInformation.ID);
		
		//Derpy Tools/Armor
		GameRegistry.registerItem(derpypickaxe, "derpypickaxe", ModInformation.ID);
		GameRegistry.registerItem(derpyshovel, "derpyshovel", ModInformation.ID);
		GameRegistry.registerItem(derpyaxe, "derpyaxe", ModInformation.ID);
		GameRegistry.registerItem(derpysword, "derpysword", ModInformation.ID);
		GameRegistry.registerItem(derpyhoe, "derpyhoe", ModInformation.ID);
		GameRegistry.registerItem(derpymultitool, "derpymultitool", ModInformation.ID);
		GameRegistry.registerItem(derpybow, "derpybow", ModInformation.ID);
		GameRegistry.registerItem(derpyarrow, "derpyarrow", ModInformation.ID);
		GameRegistry.registerItem(derpyhelmet, "derpyhelmet", ModInformation.ID);
		GameRegistry.registerItem(derpychestplate, "derpychestplate", ModInformation.ID);
		GameRegistry.registerItem(derpyleggings, "derpyleggings", ModInformation.ID);
		GameRegistry.registerItem(derpyboots, "derpyboots", ModInformation.ID);

		 Evercraft.log.info("Items registered");
	}
}