package evercraft.NEMESIS13cz.Renderers.Tile.Special;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityNuggetOre;

public class BlockNuggetOreRenderer extends TileEntitySpecialRenderer {
	
	private ResourceLocation gravel_texture = new ResourceLocation("minecraft:textures/blocks/gravel.png");
	private ResourceLocation[] nugget_texture = new ResourceLocation[] {new ResourceLocation("minecraft:textures/items/gold_nugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/coppernugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/ironnugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/leadnugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/zincnugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/tinnugget.png"), new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items/silvernugget.png")}; 
	
	private int textWidth = 16;
	private int textHeight = 16;
	
	private float pixel = 1F/16;
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float var8) {
		TileEntityNuggetOre nuggetTileEntity = (TileEntityNuggetOre) tileentity;
		int metadata = nuggetTileEntity.getWorldObj().getBlockMetadata(nuggetTileEntity.xCoord, nuggetTileEntity.yCoord, nuggetTileEntity.zCoord);
		boolean grass = Block.isEqualTo(nuggetTileEntity.getWorldObj().getBlock(nuggetTileEntity.xCoord, nuggetTileEntity.yCoord - 1, nuggetTileEntity.zCoord), Blocks.grass);
				
		GL11.glTranslated(playerX, playerY, playerZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		Tessellator tess = new Tessellator();
		
		if (grass) {
			this.bindTexture(nugget_texture[metadata]);

			tess.startDrawingQuads();
	
			tess.addVertexWithUV(1, 0.01, 0, 1, 0);
			tess.addVertexWithUV(0, 0.01, 0, 0, 0);
			tess.addVertexWithUV(0, 0.01, 1, 0, 1);
			tess.addVertexWithUV(1, 0.01, 1, 1, 1);
			
			tess.draw();
		}else{
			this.bindTexture(nugget_texture[metadata]);
			
			tess.startDrawingQuads();
	
			tess.addVertexWithUV(1, 1.01, 0, 1, 0);
			tess.addVertexWithUV(0, 1.01, 0, 0, 0);
			tess.addVertexWithUV(0, 1.01, 1, 0, 1);
			tess.addVertexWithUV(1, 1.01, 1, 1, 1);
			
			tess.draw();
	
			this.bindTexture(gravel_texture);
					
			tess.startDrawingQuads();
	
			tess.addVertexWithUV(1, 1, 0, 1, 0);
			tess.addVertexWithUV(0, 1, 0, 0, 0);
			tess.addVertexWithUV(0, 1, 1, 0, 1);
			tess.addVertexWithUV(1, 1, 1, 1, 1);
	
			tess.addVertexWithUV(1, 0, 0, 1, 0);
			tess.addVertexWithUV(1, 0, 1, 1, 1);
			tess.addVertexWithUV(0, 0, 1, 0, 1);
			tess.addVertexWithUV(0, 0, 0, 0, 0);
			
			tess.addVertexWithUV(1, 0, 0, 1, 0);
			tess.addVertexWithUV(0, 0, 0, 0, 0);
			tess.addVertexWithUV(0, 1, 0, 0, 1);
			tess.addVertexWithUV(1, 1, 0, 1, 1);
			
			tess.addVertexWithUV(1, 0, 1, 1, 0);
			tess.addVertexWithUV(1, 1, 1, 1, 1);
			tess.addVertexWithUV(0, 1, 1, 0, 1);
			tess.addVertexWithUV(0, 0, 1, 0, 0);
	
			tess.addVertexWithUV(1, 0, 1, 1, 0);
			tess.addVertexWithUV(1, 0, 0, 0, 0);
			tess.addVertexWithUV(1, 1, 0, 0, 1);
			tess.addVertexWithUV(1, 1, 1, 1, 1);
	
			tess.addVertexWithUV(0, 0, 1, 1, 0);
			tess.addVertexWithUV(0, 1, 1, 1, 1);
			tess.addVertexWithUV(0, 1, 0, 0, 1);
			tess.addVertexWithUV(0, 0, 0, 0, 0);
			
			tess.draw();
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-playerX, -playerY, -playerZ);
	}
}