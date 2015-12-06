package evercraft.NEMESIS13cz.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCapacitorStorage;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityConductanceCoil;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCuttingMachine;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityDicosChest;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityEnricher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHammeringMachine;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHeatGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHighTemperatureFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityIndustrialFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityInstantRepeater;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiner;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiningPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityNuggetOre;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityOreFactory;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityParticleMerger;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityPlateMill;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityPotionSpreader;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRedstoniteCable;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityReinforcedChest;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRepulsiveCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntitySolarGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityStandardGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityWirelessRedstoneReceiver;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityWirelessRedstoneTransmitter;


public class Evercraft_TileEntity {


	
	public static void init() {
		GameRegistry.registerTileEntity(TileEntityElectrolyzer.class, "ECTileEntityElectrolyzer");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "ECTileEntityCrusher");
		GameRegistry.registerTileEntity(TileEntityIndustrialFurnace.class, "ECTileEntityIndustrialFurnace");
		GameRegistry.registerTileEntity(TileEntityAdvancedCrusher.class, "ECTileEntityAdvancedCrusher");
		GameRegistry.registerTileEntity(TileEntityReinforcedChest.class, "ECTileEntityReinforcedChest");
		GameRegistry.registerTileEntity(TileEntityPlateMill.class, "ECTileEntityPlateMill");
		GameRegistry.registerTileEntity(TileEntityHighTemperatureFurnace.class, "ECTileEntityHighTemperatureFurnace");
		GameRegistry.registerTileEntity(TileEntityDicosChest.class, "ECTileEntityDicosChest");
		GameRegistry.registerTileEntity(TileEntityRepulsiveCrusher.class, "ECTileEntityRepulsiveCrusher");
		GameRegistry.registerTileEntity(TileEntityAdvancedElectrolyzer.class, "ECTileEntityAdvancedElectrolyzer");
		GameRegistry.registerTileEntity(TileEntityParticleMerger.class, "ECTileEntityParticleMerger");
		GameRegistry.registerTileEntity(TileEntityMiner.class, "ECTileEntityMiner");
		GameRegistry.registerTileEntity(TileEntityMiningPipe.class, "ECTileEntityMiningPipe");
		GameRegistry.registerTileEntity(TileEntityStandardGenerator.class, "ECTileEntityEthericGenerator");
		GameRegistry.registerTileEntity(TileEntityRedstoniteCable.class, "ECTileEntityRedstoniteCable");
		GameRegistry.registerTileEntity(TileEntitySolarGenerator.class, "ECTileEntitySolarGenerator");
		GameRegistry.registerTileEntity(TileEntityHeatGenerator.class, "ECTileEntityHeatGenerator");
		GameRegistry.registerTileEntity(TileEntityCentrifuge.class, "ECTileEntityCentrifuge");
		GameRegistry.registerTileEntity(TileEntityHammeringMachine.class, "ECTileEntityHammeringMachine");
		GameRegistry.registerTileEntity(TileEntityWirelessRedstoneReceiver.class, "ECTileEntityWirelessRedstoneReceiver");
		GameRegistry.registerTileEntity(TileEntityWirelessRedstoneTransmitter.class, "ECTileEntityWirelessRedstoneTransmitter");
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "ECTileEntityAlloyFurnace");
		GameRegistry.registerTileEntity(TileEntityPotionSpreader.class, "ECTileEntityPotionSpreader");
		GameRegistry.registerTileEntity(TileEntityCuttingMachine.class, "ECTileEntityCuttingMachine");
		GameRegistry.registerTileEntity(TileEntityNuggetOre.class, "ECTileEntityNuggetOre");
		GameRegistry.registerTileEntity(TileEntityCapacitorStorage.class, "ECTileEntityCapacitorStorage");
		GameRegistry.registerTileEntity(TileEntityItemPipe.class, "ECTileEntityItemPipe");
		GameRegistry.registerTileEntity(TileEntityOreFactory.class, "ECTileEntityOreFactory");
		GameRegistry.registerTileEntity(TileEntityInstantRepeater.class, "ECTileEntityInstantRepeater");
		GameRegistry.registerTileEntity(TileEntityEnricher.class, "ECTileEntityEnricher");
		GameRegistry.registerTileEntity(TileEntityConductanceCoil.class, "ECTileEntityConductanceCoil");
		
		Evercraft.log.info("TileEntities Registered");
	}
}
