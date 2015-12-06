package evercraft.NEMESIS13cz.Renderers.Tile.Special;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRedstoniteCable;

public class BlockRedstoniteCableRenderer extends TileEntitySpecialRenderer {

	private final ResourceLocation texture = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.REDSTONITE_CABLE + ".png");
	
	private int textWidth = 16;
	private int textHeight = 16;
	
	private float pixel = 1F/16;
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float var8) {
		TileEntityRedstoniteCable cable = (TileEntityRedstoniteCable) tileentity;
		
			GL11.glTranslated(playerX, playerY, playerZ);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.bindTexture(texture);
			
			if (!((cable.directions[0] != null && cable.directions[1] != null && cable.directions[2] == null && cable.directions[3] == null && cable.directions[4] == null && cable.directions[5] == null) || (cable.directions[0] == null && cable.directions[1] == null && cable.directions[2] != null && cable.directions[3] != null && cable.directions[4] == null && cable.directions[5] == null) || (cable.directions[0] == null && cable.directions[1] == null && cable.directions[2] == null && cable.directions[3] == null && cable.directions[4] != null && cable.directions[5] != null))) {
				this.drawCore();
				for (int i = 0; i < cable.directions.length; i++) {
					if (cable.directions[i] != null) {
						this.drawConnections(cable.directions[i]);
					}
				}
			}else{
				for (int i = 0; i < cable.directions.length; i++) {
					if (cable.directions[i] != null) {
						this.drawFullCable(cable.directions[i]);
					}
				}
			}
					
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glTranslated(-playerX, -playerY, -playerZ);
	}
	
	public void drawCore() {
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, 0);

		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);

		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, 0);

		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);

		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);

		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		
		tess.draw();
	}
	
	public void drawConnections(ForgeDirection dir) {
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		
			if (dir.equals(ForgeDirection.UP)) {
				//Nothing
			}else if (dir.equals(ForgeDirection.DOWN)) {
				GL11.glRotatef(180, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.NORTH)) {
				GL11.glRotatef(270, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.EAST)) {
				GL11.glRotatef(270, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.WEST)) {
				GL11.glRotatef(90, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.SOUTH)) {
				GL11.glRotatef(90, 1, 0, 0);
			}
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

			Tessellator tess = Tessellator.instance;
				tess.startDrawingQuads();
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 11, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 11, 0);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, 0);
	
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, 0);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, 0);
	
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 5, this.pixel * 11, 0);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, 0);
	
				tess.addVertexWithUV(this.pixel * 5, 1, this.pixel * 5, this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(this.pixel * 5, 1 - (this.pixel * 5), this.pixel * 5, this.pixel * 11, this.pixel * 6);
				tess.addVertexWithUV(this.pixel * 5, 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, 0);
				tess.addVertexWithUV(this.pixel * 5, 1, 1 - (this.pixel * 5), this.pixel * 6, 0);
			
			tess.draw();

			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			if (dir.equals(ForgeDirection.UP)) {
				//Nothing
			}else if (dir.equals(ForgeDirection.DOWN)) {
				GL11.glRotatef(-180, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.NORTH)) {
				GL11.glRotatef(-270, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.EAST)) {
				GL11.glRotatef(-270, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.WEST)) {
				GL11.glRotatef(-90, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.SOUTH)) {
				GL11.glRotatef(-90, 1, 0, 0);
			}
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	}
	
	public void drawFullCable(ForgeDirection dir) {

			if (dir.equals(ForgeDirection.DOWN)) {
				GL11.glTranslatef(0.5F, 0.5F, 0.5F);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				Tessellator tess = Tessellator.instance;
				tess.startDrawingQuads();
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				
			tess.draw();
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			GL11.glRotatef(-90, 1, 0, 0);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			}else if (dir.equals(ForgeDirection.NORTH)) {
				Tessellator tess = Tessellator.instance;
				tess.startDrawingQuads();
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				
			tess.draw();
			}else if (dir.equals(ForgeDirection.EAST)) {
				GL11.glTranslatef(0.5F, 0.5F, 0.5F);
				GL11.glRotatef(90, 0, 1, 0);
				GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				Tessellator tess = Tessellator.instance;
				tess.startDrawingQuads();
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				
			tess.draw();
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			GL11.glRotatef(-90, 0, 1, 0);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			}
	}

}
