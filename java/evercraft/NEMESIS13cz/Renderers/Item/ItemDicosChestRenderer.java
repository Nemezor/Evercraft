package evercraft.NEMESIS13cz.Renderers.Item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityDicosChest;

public class ItemDicosChestRenderer implements IItemRenderer {

	private ModelChest chestModel;
	
	public ItemDicosChestRenderer(){
		chestModel = new ModelChest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityDicosChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
