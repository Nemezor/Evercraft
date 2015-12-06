package evercraft.NEMESIS13cz.Renderers.Tile.Special;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import evercraft.NEMESIS13cz.ModInformation;

public class BlockConductanceCoilRenderer extends TileEntitySpecialRenderer {

	private final ResourceLocation texture = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.ADV_CONDUCTANCE_COIL + ".png");
	
	private float pixel = 1F/16;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float f) {

		GL11.glTranslated(playerX, playerY, playerZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.bindTexture(texture);

		Tessellator tess = Tessellator.instance;
		
		this.drawCoil(tess, 0.4F, 1F, 0.5F);
		this.drawCoil(tess, 0.1F, 1F, 0.2F);
		this.drawCoil(tess, 0.7F, 1F, 0.4F);
		this.drawCoil(tess, 0.1F, 1F, 0.6F);
		this.drawCoil(tess, 0.5F, 1F, 0.1F);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-playerX, -playerY, -playerZ);
	}
	
	public void drawCoil(Tessellator tess, float x, float y, float z) {
		tess.startDrawingQuads();
		
		tess.addVertexWithUV(x + pixel * 3, y, z, 0, 0);
		tess.addVertexWithUV(x + pixel * 3, y, z + pixel * 3, pixel * 3, 0);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z + pixel * 3, pixel * 3, 1);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z, 0, 1);

		tess.addVertexWithUV(x, y, z, 0, 0);
		tess.addVertexWithUV(x, y - 1, z, 0, 1);
		tess.addVertexWithUV(x, y - 1, z + pixel * 3, pixel * 3, 1);
		tess.addVertexWithUV(x, y, z + pixel * 3, pixel * 3, 0);

		tess.addVertexWithUV(x, y, z + pixel * 3, 0, 0);
		tess.addVertexWithUV(x, y - 1, z + pixel * 3, 0, 1);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z + pixel * 3, pixel * 3, 1);
		tess.addVertexWithUV(x + pixel * 3, y, z + pixel * 3, pixel * 3, 0);

		tess.addVertexWithUV(x + pixel * 3, y, z, pixel * 3, 0);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z, pixel * 3, 1);
		tess.addVertexWithUV(x, y - 1, z, 0, 1);
		tess.addVertexWithUV(x, y, z, 0, 0);

		tess.addVertexWithUV(x, y, z, 0, 0);
		tess.addVertexWithUV(x, y, z + pixel * 3, 0, pixel * 3);
		tess.addVertexWithUV(x + pixel * 3, y, z + pixel * 3, pixel * 3, pixel * 3);
		tess.addVertexWithUV(x + pixel * 3, y, z, pixel * 3, 0);

		tess.addVertexWithUV(x, y - 1, z, 0, 0);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z, pixel * 3, 0);
		tess.addVertexWithUV(x + pixel * 3, y - 1, z + pixel * 3, pixel * 3, pixel * 3);
		tess.addVertexWithUV(x, y - 1, z + pixel * 3, 0, pixel * 3);
		
		tess.draw();
	}

}
