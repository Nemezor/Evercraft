package evercraft.NEMESIS13cz.Renderers.Tile;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;

public class TileEntityMiningPipeRenderer extends TileEntitySpecialRenderer {

	private final ResourceLocation texture = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.MINING_PIPE + ".png");
	
	private int textWidth = 16;
	private int textHeight = 16;
	
	private float pixel = 1F/16;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float var8) {
		
		int x = tileentity.xCoord;
		int y = tileentity.yCoord;
		int z = tileentity.zCoord;
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)playerX, (float)playerY, (float)playerZ);
			GL11.glDisable(GL11.GL_LIGHTING);
			
			Tessellator tess = Tessellator.instance;
			this.bindTexture(texture);
			tess.startDrawingQuads();
			
			if (tileentity.getWorldObj().getBlock(x, y - 1, z) == Evercraft_Blocks.blockminingpipe) {
				{
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 1 - (this.pixel * 5), 1 - (this.pixel * 5), 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0);
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 1);
				}
				{
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0);
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 0 + (this.pixel * 5), 0 + (this.pixel * 5), 1);
				}
				{
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 1 - (this.pixel * 5), 1 - (this.pixel * 5), 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0);
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 0 + (this.pixel * 5), 0 + (this.pixel * 5), 1);
				}
				{
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0);
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 1);
				}
				{
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5));
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5));
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5));
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5));
				}
				{
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5));
					tess.addVertexWithUV(0 + (this.pixel * 5), 0, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5));
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5));
					tess.addVertexWithUV(1 - (this.pixel * 5), 0, 1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5));
				}
			}else{
				{
					tess.addVertexWithUV(1 - (this.pixel * 8), 0, 1 - (this.pixel * 8), 1 - (this.pixel * 8), 1);
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 1 - (this.pixel * 1), 1 - (this.pixel * 1), 0);
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 1 - (this.pixel * 1), 0 + (this.pixel * 1), 0);
					tess.addVertexWithUV(0 + (this.pixel * 8), 0, 1 - (this.pixel * 8), 0 + (this.pixel * 8), 1);
				}
				{
					tess.addVertexWithUV(0 + (this.pixel * 8), 0, 0 + (this.pixel * 8), 1 - (this.pixel * 8), 1);
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 0 + (this.pixel * 1), 1 - (this.pixel * 1), 0);
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 0 + (this.pixel * 1), 0 + (this.pixel * 1), 0);
					tess.addVertexWithUV(1 - (this.pixel * 8), 0, 0 + (this.pixel * 8), 0 + (this.pixel * 8), 1);
				}
				{
					tess.addVertexWithUV(0 + (this.pixel * 8), 0, 1 - (this.pixel * 8), 1 - (this.pixel * 8), 1);
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 1 - (this.pixel * 1), 1 - (this.pixel * 1), 0);
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 0 + (this.pixel * 1), 0 + (this.pixel * 1), 0);
					tess.addVertexWithUV(0 + (this.pixel * 8), 0, 0 + (this.pixel * 8), 0 + (this.pixel * 8), 1);
				}
				{
					tess.addVertexWithUV(1 - (this.pixel * 8), 0, 0 + (this.pixel * 8), 1 - (this.pixel * 8), 1);
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 0 + (this.pixel * 1), 1 - (this.pixel * 1), 0);
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 1 - (this.pixel * 1), 0 + (this.pixel * 1), 0);
					tess.addVertexWithUV(1 - (this.pixel * 8), 0, 1 - (this.pixel * 8), 0 + (this.pixel * 8), 1);
				}
				{
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 1 - (this.pixel * 1), 0 + (this.pixel * 1), 0 + (this.pixel * 1));
					tess.addVertexWithUV(1 - (this.pixel * 1), 1, 0 + (this.pixel * 1), 1 - (this.pixel * 1), 0 + (this.pixel * 1));
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 0 + (this.pixel * 1), 1 - (this.pixel * 1), 1 - (this.pixel * 1));
					tess.addVertexWithUV(0 + (this.pixel * 1), 1, 1 - (this.pixel * 1), 0 + (this.pixel * 1), 1 - (this.pixel * 1));
				}
			}

			tess.draw();
			GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

}
