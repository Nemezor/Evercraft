package evercraft.NEMESIS13cz.Renderers.Helpers;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;

import com.google.common.collect.Maps;

import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityDicosChest;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityReinforcedChest;

public class ItemEvercraftChestRenderHelper extends TileEntityRendererChestHelper{
	
	private Map<Integer, TileEntity> itemRenders = Maps.newHashMap();
	  
	public ItemEvercraftChestRenderHelper()
	{
	    	this.itemRenders.put(0, (TileEntityReinforcedChest)Evercraft_Blocks.blockreinforcedchest.createTileEntity(null, 0));
	    	this.itemRenders.put(1, (TileEntityDicosChest)Evercraft_Blocks.blockdicoschest.createTileEntity(null, 0));
	}
	
	public void renderChest(Block block, int i, float f) {
		if (block == Evercraft_Blocks.blockreinforcedchest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt((TileEntity)this.itemRenders.get(0), 0.0D, 0.0D, 0.0D, 0.0F);
		}else if (block == Evercraft_Blocks.blockdicoschest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt((TileEntity)this.itemRenders.get(1), 0.0D, 0.0D, 0.0D, 0.0F);
		}else{
			super.renderChest(block, i, f);
		}
	}
}
