package evercraft.NEMESIS13cz.Main;

import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import evercraft.NEMESIS13cz.Entity.EntityObsidiumArrow;
import evercraft.NEMESIS13cz.Entity.EntityBronzeArrow;
import evercraft.NEMESIS13cz.Entity.EntityCopperArrow;
import evercraft.NEMESIS13cz.Entity.EntityDiamondArrow;
import evercraft.NEMESIS13cz.Entity.EntityDerpyArrow;
import evercraft.NEMESIS13cz.Entity.EntityGoldArrow;
import evercraft.NEMESIS13cz.Entity.EntityIronArrow;
import evercraft.NEMESIS13cz.Entity.EntityLapisArrow;
import evercraft.NEMESIS13cz.Entity.EntityRedstoneArrow;
import evercraft.NEMESIS13cz.Entity.EntitySteelArrow;
import evercraft.NEMESIS13cz.Entity.EntityTravellingItem;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityObsidiumArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityBronzeArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityCopperArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityDiamondArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityDerpyArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityGoldArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityIronArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityLapisArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityRedstoneArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntitySteelArrowRenderer;
import evercraft.NEMESIS13cz.Renderers.Entity.EntityTravellingItemRenderer;
import evercraft.NEMESIS13cz.Renderers.Helpers.ItemEvercraftChestRenderHelper;
import evercraft.NEMESIS13cz.Renderers.Item.ItemGlassTubeRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.BlockInstantRepeaterRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityAdvancedCrusherRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityAdvancedElectrolyzerRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityAlloyFurnaceRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityCapacitorStorage;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityCentrifugeRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityCrusherRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityCuttingMachineRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityElectrolyzerRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityEnricherRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityHammeringMachineRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityHeatGeneratorRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityHighTemperatureFurnaceRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityIndustrialFurnaceRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityMiningPipeRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityOreFactoryRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityParticleMergerRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityPlateMillRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityRepulsiveCrusherRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.TileEntityStandardGeneratorRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.BlockAdvancedCrusherRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.BlockConductanceCoilRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.BlockNuggetOreRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.BlockPipeRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.BlockRedstoniteCableRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.TileEntityDicosChestRenderer;
import evercraft.NEMESIS13cz.Renderers.Tile.Special.TileEntityReinforcedChestRenderer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityConductanceCoil;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityDicosChest;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiningPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityNuggetOre;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRedstoniteCable;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityReinforcedChest;

public class ClientProxy extends CommonProxy{

	@Override
	public void initSounds() {
		
	}

	@Override
	public void initRenderers() {
		TileEntityRendererChestHelper.instance = new ItemEvercraftChestRenderHelper();
		MinecraftForgeClient.registerItemRenderer(Evercraft_Items.glassTube, new ItemGlassTubeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReinforcedChest.class, new TileEntityReinforcedChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDicosChest.class, new TileEntityDicosChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningPipe.class, new TileEntityMiningPipeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRedstoniteCable.class, new BlockRedstoniteCableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdvancedCrusher.class, new BlockAdvancedCrusherRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNuggetOre.class, new BlockNuggetOreRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPipe.class, new BlockPipeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConductanceCoil.class, new BlockConductanceCoilRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityCopperArrow.class, new EntityCopperArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityBronzeArrow.class, new EntityBronzeArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntitySteelArrow.class, new EntitySteelArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneArrow.class, new EntityRedstoneArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisArrow.class, new EntityLapisArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityObsidiumArrow.class, new EntityObsidiumArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityDerpyArrow.class, new EntityDerpyArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityIronArrow.class, new EntityIronArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldArrow.class, new EntityGoldArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondArrow.class, new EntityDiamondArrowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityTravellingItem.class, new EntityTravellingItemRenderer());
		RenderingRegistry.registerBlockHandler(3350, TileEntityAdvancedCrusherRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3351, TileEntityAdvancedElectrolyzerRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3353, TileEntityCrusherRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3354, TileEntityElectrolyzerRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3355, TileEntityHighTemperatureFurnaceRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3356, TileEntityIndustrialFurnaceRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3357, TileEntityParticleMergerRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3358, TileEntityPlateMillRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3359, TileEntityRepulsiveCrusherRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3360, TileEntityStandardGeneratorRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3361, TileEntityHeatGeneratorRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3362, TileEntityHammeringMachineRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3363, TileEntityCentrifugeRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3364, TileEntityAlloyFurnaceRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3365, TileEntityCuttingMachineRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3366, TileEntityCapacitorStorage.INSTANCE);
		RenderingRegistry.registerBlockHandler(3367, TileEntityOreFactoryRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3368, BlockInstantRepeaterRenderer.INSTANCE);
		RenderingRegistry.registerBlockHandler(3369, TileEntityEnricherRenderer.INSTANCE);
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
