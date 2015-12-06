package evercraft.NEMESIS13cz.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerAdvancedElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerCapacitorStorage;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerCrusher;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerCuttingMachine;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerEnricher;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerFurnitureCrafter;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerHammeringMachine;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerHeatGenerator;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerHighTemperatureFurnace;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerIndustrialFurnace;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerItemPipe;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerMiner;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerMixingTable;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerOreFactory;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerParticleMerger;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerPlateMill;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerRepulsiveCrusher;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerSolarGenerator;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerStandardGenerator;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiAdvancedElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiCapacitorStorage;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiCrusher;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiCuttingMachine;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiEnricher;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiFurnitureCrafter;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiHammeringMachine;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiHeatGenerator;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiHighTemperatureFurnace;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiIndustrialFurnace;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiItemPipe_Crossing;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiMiner;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiMixingTable;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiOreFactory;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiParticleMerger;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiPlateMill;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiRepulsiveCrusher;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiSolarGenerator;
import evercraft.NEMESIS13cz.TileEntity.Gui.GuiStandardGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCapacitorStorage;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCuttingMachine;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityEnricher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHammeringMachine;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHeatGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHighTemperatureFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityIndustrialFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiner;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityOreFactory;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityParticleMerger;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityPlateMill;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRepulsiveCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntitySolarGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityStandardGenerator;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;

public class ECGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
			TileEntity tile_entity = world.getTileEntity(x, y, z);
			switch(ID)
			{
			case 11: return ID == 11 && world.getBlock(x, y, z) == Evercraft_Blocks.blockfurniturecrafter ? new ContainerFurnitureCrafter(player.inventory, world, x, y, z) : null;
			case 13: return ID == 13 && world.getBlock(x, y, z) == Evercraft_Blocks.blockmixingtable ? new ContainerMixingTable(player.inventory, world, x, y, z) : null;
			}
				if(tile_entity instanceof TileEntityElectrolyzer) {
					return new ContainerElectrolyzer(player.inventory, (TileEntityElectrolyzer) tile_entity);
					}
					if(tile_entity instanceof TileEntityCrusher) {
						return new ContainerCrusher(player.inventory, (TileEntityCrusher) tile_entity);
					}
					if(tile_entity instanceof TileEntityIndustrialFurnace) {
						return new ContainerIndustrialFurnace(player.inventory, (TileEntityIndustrialFurnace) tile_entity);
					}
					if(tile_entity instanceof TileEntityAdvancedCrusher) {
						return new ContainerAdvancedCrusher(player.inventory, (TileEntityAdvancedCrusher) tile_entity);
					}
					if(tile_entity instanceof TileEntityPlateMill) {
						return new ContainerPlateMill(player.inventory, (TileEntityPlateMill) tile_entity);
					}
					if(tile_entity instanceof TileEntityHighTemperatureFurnace) {
						return new ContainerHighTemperatureFurnace(player.inventory, (TileEntityHighTemperatureFurnace) tile_entity);
					}
					if(tile_entity instanceof TileEntityAdvancedElectrolyzer) {
						return new ContainerAdvancedElectrolyzer(player.inventory, (TileEntityAdvancedElectrolyzer) tile_entity);
					}
					if(tile_entity instanceof TileEntityRepulsiveCrusher) {
						return new ContainerRepulsiveCrusher(player.inventory, (TileEntityRepulsiveCrusher) tile_entity);
					}
					if(tile_entity instanceof TileEntityParticleMerger) {
						return new ContainerParticleMerger(player.inventory, (TileEntityParticleMerger) tile_entity);
					}
					if(tile_entity instanceof TileEntityMiner) {
						return new ContainerMiner(player.inventory, (TileEntityMiner) tile_entity);
					}
					if(tile_entity instanceof TileEntityStandardGenerator) {
						return new ContainerStandardGenerator(player.inventory, (TileEntityStandardGenerator) tile_entity);
					}
					if(tile_entity instanceof TileEntitySolarGenerator) {
						return new ContainerSolarGenerator(player.inventory, (TileEntitySolarGenerator) tile_entity);
					}
					if(tile_entity instanceof TileEntityHeatGenerator) {
						return new ContainerHeatGenerator(player.inventory, (TileEntityHeatGenerator) tile_entity);
					}
					if(tile_entity instanceof TileEntityCentrifuge) {
						return new ContainerCentrifuge(player.inventory, (TileEntityCentrifuge) tile_entity);
					}
					if(tile_entity instanceof TileEntityHammeringMachine) {
						return new ContainerHammeringMachine(player.inventory, (TileEntityHammeringMachine) tile_entity);
					}
					if(tile_entity instanceof TileEntityAlloyFurnace) {
						return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) tile_entity);
					}
					if(tile_entity instanceof TileEntityCuttingMachine) {
						return new ContainerCuttingMachine(player.inventory, (TileEntityCuttingMachine) tile_entity);
					}
					if(tile_entity instanceof TileEntityCapacitorStorage) {
						return new ContainerCapacitorStorage(player.inventory, (TileEntityCapacitorStorage) tile_entity);
					}
					if(tile_entity instanceof TileEntityOreFactory) {
						return new ContainerOreFactory(player.inventory, (TileEntityOreFactory) tile_entity);
					}
					if (tile_entity instanceof TileEntityItemPipe && ((TileEntityItemPipe) tile_entity).type == ItemPipeHandler.ROUTING) {
						return new ContainerItemPipe(player.inventory, (TileEntityItemPipe) tile_entity);
					}
					if(tile_entity instanceof TileEntityEnricher) {
						return new ContainerEnricher(player.inventory, (TileEntityEnricher) tile_entity);
					}
			return null;
		}	
	
			
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID)
		{
		case 11: return ID == 11 && world.getBlock(x, y, z) == Evercraft_Blocks.blockfurniturecrafter ? new GuiFurnitureCrafter(player.inventory, world, x, y, z) : null;
		case 13: return ID == 13 && world.getBlock(x, y, z) == Evercraft_Blocks.blockmixingtable ? new GuiMixingTable(player.inventory, world, x, y, z) : null;
		}
		if(tile_entity instanceof TileEntityElectrolyzer) {
			return new GuiElectrolyzer(player.inventory, (TileEntityElectrolyzer) tile_entity);
		}
		if(tile_entity instanceof TileEntityCrusher) {
			return new GuiCrusher(player.inventory, (TileEntityCrusher) tile_entity);
		}
		if(tile_entity instanceof TileEntityIndustrialFurnace) {
			return new GuiIndustrialFurnace(player.inventory, (TileEntityIndustrialFurnace) tile_entity);
		}
		if(tile_entity instanceof TileEntityAdvancedCrusher) {
			return new GuiAdvancedCrusher(player.inventory, (TileEntityAdvancedCrusher) tile_entity);
		}
		if(tile_entity instanceof TileEntityPlateMill) {
			return new GuiPlateMill(player.inventory, (TileEntityPlateMill) tile_entity);
		}
		if(tile_entity instanceof TileEntityHighTemperatureFurnace) {
			return new GuiHighTemperatureFurnace(player.inventory, (TileEntityHighTemperatureFurnace) tile_entity);
		}
		if(tile_entity instanceof TileEntityAdvancedElectrolyzer) {
			return new GuiAdvancedElectrolyzer(player.inventory, (TileEntityAdvancedElectrolyzer) tile_entity);
		}
		if(tile_entity instanceof TileEntityRepulsiveCrusher) {
			return new GuiRepulsiveCrusher(player.inventory, (TileEntityRepulsiveCrusher) tile_entity);
		}
		if(tile_entity instanceof TileEntityParticleMerger) {
			return new GuiParticleMerger(player.inventory, (TileEntityParticleMerger) tile_entity);
		}
		if(tile_entity instanceof TileEntityMiner) {
			return new GuiMiner(player.inventory, (TileEntityMiner) tile_entity);
		}
		if(tile_entity instanceof TileEntityStandardGenerator) {
			return new GuiStandardGenerator(player.inventory, (TileEntityStandardGenerator) tile_entity);
		}
		if(tile_entity instanceof TileEntitySolarGenerator) {
			return new GuiSolarGenerator(player.inventory, (TileEntitySolarGenerator) tile_entity);
		}
		if(tile_entity instanceof TileEntityHeatGenerator) {
			return new GuiHeatGenerator(player.inventory, (TileEntityHeatGenerator) tile_entity);
		}
		if(tile_entity instanceof TileEntityCentrifuge) {
			return new GuiCentrifuge(player.inventory, (TileEntityCentrifuge) tile_entity);
		}
		if(tile_entity instanceof TileEntityHammeringMachine) {
			return new GuiHammeringMachine(player.inventory, (TileEntityHammeringMachine) tile_entity);
		}
		if(tile_entity instanceof TileEntityAlloyFurnace) {
			return new GuiAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) tile_entity);
		}
		if(tile_entity instanceof TileEntityCuttingMachine) {
			return new GuiCuttingMachine(player.inventory, (TileEntityCuttingMachine) tile_entity);
		}
		if(tile_entity instanceof TileEntityCapacitorStorage) {
			return new GuiCapacitorStorage(player.inventory, (TileEntityCapacitorStorage) tile_entity);
		}
		if(tile_entity instanceof TileEntityOreFactory) {
			return new GuiOreFactory(player.inventory, (TileEntityOreFactory) tile_entity);
		}
		if (tile_entity instanceof TileEntityItemPipe && ((TileEntityItemPipe) tile_entity).type == ItemPipeHandler.ROUTING) {
			return new GuiItemPipe_Crossing(player.inventory, (TileEntityItemPipe) tile_entity);
		}
		if(tile_entity instanceof TileEntityEnricher) {
			return new GuiEnricher(player.inventory, (TileEntityEnricher) tile_entity);
		}
		
		
	return null;
}
	
	
	
	
}
