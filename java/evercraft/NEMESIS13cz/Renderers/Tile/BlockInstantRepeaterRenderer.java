package evercraft.NEMESIS13cz.Renderers.Tile;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockInstantRepeater;

public class BlockInstantRepeaterRenderer implements ISimpleBlockRenderingHandler {

	public static final BlockInstantRepeaterRenderer INSTANCE = new BlockInstantRepeaterRenderer();
	
	@Override
	public void renderInventoryBlock(Block block1, int metadata, int modelId, RenderBlocks renderer) {
		BlockInstantRepeater block = (BlockInstantRepeater)block1;
		
		Tessellator tess = Tessellator.instance;

		block.setBlockBoundsForItemRender();

        GL11.glRotatef(180.0F, 0, 1, 0);
        GL11.glTranslatef(-0.5F, -0.15F, -0.5F);
        
		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(0));
		
		tess.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(1));

		tess.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(2));
		
		tess.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(3));

		tess.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(4));
		
		tess.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(5));
		tess.draw();

        GL11.glTranslatef(0.5F, 0.15F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int direction = renderer.blockAccess.getBlockMetadata(x, y, z) & 3;
		
		if (direction == 2) {
			renderer.uvRotateTop = 3;
		}else if (direction == 3) {
			renderer.uvRotateTop = 2;
		}else{
			renderer.uvRotateTop = direction;
		}
    	
    	boolean flag = renderer.renderStandardBlock(block, x, y, z);
    	renderer.uvRotateTop = 0;
    	
    	return flag;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return 3368;
	}

}
