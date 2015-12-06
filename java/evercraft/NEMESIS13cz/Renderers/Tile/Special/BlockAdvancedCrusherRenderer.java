package evercraft.NEMESIS13cz.Renderers.Tile.Special;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAdvancedCrusher;

public class BlockAdvancedCrusherRenderer extends TileEntitySpecialRenderer {

	private final ResourceLocation texture = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.ADVANCEDCRUSHER_MODEL + ".png");
	private final ResourceLocation texture_blade = new ResourceLocation(ModInformation.TEXTUREPATH + ":textures/items" + "/" + ModInformation.DIAMOND_GRINDER + ".png");
	
	private int textWidth = 32;
	private int textHeight = 32;
	
	private float pixel = 1F/16;
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float var8) {
		TileEntityAdvancedCrusher AdvCrusher = (TileEntityAdvancedCrusher) tileentity;
		

		if (Evercraft_Config_Machines.fancyRender) {
		
		int metadata = AdvCrusher.getWorldObj().getBlockMetadata(AdvCrusher.xCoord, AdvCrusher.yCoord, AdvCrusher.zCoord);
		Block block = AdvCrusher.getWorldObj().getBlock(AdvCrusher.xCoord, AdvCrusher.yCoord, AdvCrusher.zCoord);			
		
			GL11.glTranslated(playerX, playerY, playerZ);
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			if (metadata == 3) {
				GL11.glRotatef(180, 0, 1, 0);
			}
			if (metadata == 4) {
				GL11.glRotatef(90, 0, 1, 0);
			}
			if (metadata == 5) {
				GL11.glRotatef(270, 0, 1, 0);
			}
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			
			//RENDERING
			this.bindTexture(texture);

			Tessellator tess = Tessellator.instance;

			tess.startDrawingQuads();
			
			tess.addVertexWithUV(0, 0 + pixel * 14, 0, 0.5, pixel);
			tess.addVertexWithUV(0, 1, 0, 0.5, 0);
			tess.addVertexWithUV(1, 1, 0, 0, 0);
			tess.addVertexWithUV(1, 0 + pixel * 14, 0, 0, pixel);
			
			if (block == Evercraft_Blocks.blockadvancedcrusherOn) {
				tess.addVertexWithUV(0 + pixel * 3, pixel * 3, 0, 0.5, pixel * 3);
				tess.addVertexWithUV(0 + pixel * 3, pixel * 9, 0, 0.5, 0);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, 0, 0.5 + pixel * 5, 0);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, 0, 0.5 + pixel * 5, pixel * 3);
				
				tess.addVertexWithUV(0, 1 - pixel*3, 0, 1, pixel * 7 / 2);
				tess.addVertexWithUV(0, 1 - pixel*2, 0, 1, pixel * 3);
				tess.addVertexWithUV(1, 1 - pixel*2, 0, 0.5, pixel * 3);
				tess.addVertexWithUV(1, 1 - pixel*3, 0, 0.5, pixel * 7 / 2);
			}else{

				tess.addVertexWithUV(0, 1 - pixel*3, 0, 0.5, pixel * 3 / 2);
				tess.addVertexWithUV(0, 1 - pixel*2, 0, 0.5, pixel);
				tess.addVertexWithUV(1, 1 - pixel*2, 0, 0, pixel);
				tess.addVertexWithUV(1, 1 - pixel*3, 0, 0, pixel * 3 / 2);
			}
			
			tess.addVertexWithUV(0, 0, 0, 0.5, 0.5);
			tess.addVertexWithUV(0, 1 - pixel * 3, 0, 0.5, pixel * 3 / 2);
			tess.addVertexWithUV(1, 1 - pixel * 3, 0, 0, pixel * 3 / 2);
			tess.addVertexWithUV(1, 0, 0, 0, 0.5);
					
			tess.addVertexWithUV(0, 0, 1, 0.5, 1);
			tess.addVertexWithUV(0, 1, 1, 0.5, 0.5);
			tess.addVertexWithUV(0, 1, 0, 0, 0.5);
			tess.addVertexWithUV(0, 0, 0, 0, 1);
			
			tess.addVertexWithUV(1, 0, 1, 0.5, 1);
			tess.addVertexWithUV(1, 0, 0, 0, 1);
			tess.addVertexWithUV(1, 1, 0, 0, 0.5);
			tess.addVertexWithUV(1, 1, 1, 0.5, 0.5);

			tess.addVertexWithUV(0, 0, 1, 0, 1);
			tess.addVertexWithUV(1, 0, 1, 0.5, 1);
			tess.addVertexWithUV(1, 1, 1, 0.5, 0.5);
			tess.addVertexWithUV(0, 1, 1, 0, 0.5);

			tess.addVertexWithUV(0, 1, 0, 0.5, 0.5);
			tess.addVertexWithUV(0, 1, 1, 0.5, 1);
			tess.addVertexWithUV(1, 1, 1, 1, 1);
			tess.addVertexWithUV(1, 1, 0, 1, 0.5);
			
			tess.addVertexWithUV(0, 0, 0, 0.5, 0.5);
			tess.addVertexWithUV(1, 0, 0, 1, 0.5);
			tess.addVertexWithUV(1, 0, 1, 1, 1);
			tess.addVertexWithUV(0, 0, 1, 0.5, 1);
			
			if (block == Evercraft_Blocks.blockadvancedcrusherOff) {
				tess.addVertexWithUV(pixel * 3, pixel * 3, 0, pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(pixel * 3, pixel * 3, pixel * 12, pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, 0, 0.5 - pixel * 1.5, 1 - pixel * 1.5);
				
				tess.addVertexWithUV(pixel * 3, pixel * 9, 0, pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, 0, 0.5 - pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(pixel * 3, pixel * 9, pixel * 12, pixel * 1.5, 1 - pixel * 6);
	
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, 0, 0.5 - pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, 0, 0.5 - pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
	
				tess.addVertexWithUV(pixel * 3, pixel * 9, 0, pixel * 1.5, 1 - pixel * 1.5);
				tess.addVertexWithUV(pixel * 3, pixel * 9, pixel * 12, pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(pixel * 3, pixel * 3, pixel * 12, pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(pixel * 3, pixel * 3, 0, pixel * 1.5, 1 - pixel * 1.5);
	
				tess.addVertexWithUV(pixel * 3, pixel * 9, pixel * 12, pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 9, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(1 - pixel * 3, pixel * 3, pixel * 12, 0.5 - pixel * 1.5, 1 - pixel * 6);
				tess.addVertexWithUV(pixel * 3, pixel * 3, pixel * 12, pixel * 1.5, 1 - pixel * 6);
			}
			tess.draw();

			this.bindTexture(texture_blade);
			tess.startDrawingQuads();

			if (block == Evercraft_Blocks.blockadvancedcrusherOff) {
				tess.addVertexWithUV(pixel * 4, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 4, pixel * 4, pixel * 12, 0, 1);
				tess.addVertexWithUV(pixel * 4, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 4, pixel * 14, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 4, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 4, pixel * 14, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 4, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 4, pixel * 4, pixel * 12, 0, 1);
	
				tess.addVertexWithUV(pixel * 6, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 6, pixel * 4, pixel * 12, 0, 1);
				tess.addVertexWithUV(pixel * 6, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 6, pixel * 14, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 6, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 6, pixel * 14, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 6, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 6, pixel * 4, pixel * 12, 0, 1);
	
				tess.addVertexWithUV(pixel * 8, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 8, pixel * 4, pixel * 12, 0, 1);
				tess.addVertexWithUV(pixel * 8, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 8, pixel * 14, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 8, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 8, pixel * 14, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 8, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 8, pixel * 4, pixel * 12, 0, 1);
	
				tess.addVertexWithUV(pixel * 10, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 10, pixel * 4, pixel * 12, 0, 1);
				tess.addVertexWithUV(pixel * 10, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 10, pixel * 14, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 10, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 10, pixel * 14, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 10, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 10, pixel * 4, pixel * 12, 0, 1);
				
				tess.addVertexWithUV(pixel * 12, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 12, pixel * 4, pixel * 12, 0, 1);
				tess.addVertexWithUV(pixel * 12, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 12, pixel * 14, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 12, pixel * 4, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 12, pixel * 14, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 12, pixel * 14, pixel * 12, 1, 1);
				tess.addVertexWithUV(pixel * 12, pixel * 4, pixel * 12, 0, 1);
				
	
				
				tess.addVertexWithUV(pixel * 5, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 5, 0, pixel * 12, 0, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 5, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 5, pixel * 7, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 5, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 5, pixel * 7, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 5, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 5, 0, pixel * 12, 0, 1 - pixel * 3);
	
				tess.addVertexWithUV(pixel * 7, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 7, 0, pixel * 12, 0, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 7, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 7, pixel * 7, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 7, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 7, pixel * 7, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 7, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 7, 0, pixel * 12, 0, 1 - pixel * 3);
				
				tess.addVertexWithUV(pixel * 9, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 9, 0, pixel * 12, 0, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 9, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 9, pixel * 7, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 9, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 9, pixel * 7, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 9, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 9, 0, pixel * 12, 0, 1 - pixel * 3);
				
				tess.addVertexWithUV(pixel * 11, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 11, 0, pixel * 12, 0, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 11, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 11, pixel * 7, pixel * 2, 1, 0);
				
				tess.addVertexWithUV(pixel * 11, 0, pixel * 2, 0, 0);
				tess.addVertexWithUV(pixel * 11, pixel * 7, pixel * 2, 1, 0);
				tess.addVertexWithUV(pixel * 11, pixel * 7, pixel * 12, 1, 1 - pixel * 3);
				tess.addVertexWithUV(pixel * 11, 0, pixel * 12, 0, 1 - pixel * 3);
			}
			
			tess.draw();
			
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			if (metadata == 3) {
				GL11.glRotatef(-180, 0, 1, 0);
			}
			if (metadata == 4) {
				GL11.glRotatef(-90, 0, 1, 0);
			}
			if (metadata == 5) {
				GL11.glRotatef(-270, 0, 1, 0);
			}
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glTranslated(-playerX, -playerY, -playerZ);
		}
	}
}