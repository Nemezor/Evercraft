package evercraft.NEMESIS13cz.Renderers.Item;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityReinforcedChest;

public class ItemReinforcedChestRenderer implements IItemRenderer {

	private ModelChest chestModel;
	
	public ItemReinforcedChestRenderer(){
		chestModel = new ModelChest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

	    return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) || (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.ENTITY));
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityReinforcedChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
