package evercraft.NEMESIS13cz.Renderers.Tile.Special;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;

public class BlockPipeRenderer extends TileEntitySpecialRenderer {

	private final ResourceLocation texture_transport_1 = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.TRANSPORTPIPE_1 + ".png");
	private final ResourceLocation texture_transport_2 = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.TRANSPORTPIPE_2 + ".png");
	private final ResourceLocation texture_extraction_1 = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.EXTRACTIONPIPE_1 + ".png");
	private final ResourceLocation texture_extraction_2 = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.EXTRACTIONPIPE_2 + ".png");
	private final ResourceLocation texture_routing = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.ROUTINGPIPE + ".png");
	private final ResourceLocation texture_transport_fast = new ResourceLocation(ModInformation.MODELTEXTUREPATH + "/" + ModInformation.TRANSPORTPIPE_FAST + ".png");
	
	private int textWidth = 16;
	private int textHeight = 16;
	
	private float pixel = 1F/16;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double playerX, double playerY, double playerZ, float var8) {
		TileEntityItemPipe pipe = (TileEntityItemPipe) tileentity;

			GL11.glTranslated(playerX, playerY, playerZ);
			GL11.glDisable(GL11.GL_LIGHTING);

			if (pipe.type == ItemPipeHandler.EXTRACTION_1) {
				this.bindTexture(texture_extraction_1);
			}else if(pipe.type == ItemPipeHandler.EXTRACTION_2) {
				this.bindTexture(texture_extraction_2);
			}else if(pipe.type == ItemPipeHandler.TRANSPORT_2) {
				this.bindTexture(texture_transport_2);
			}else if(pipe.type == ItemPipeHandler.ROUTING) {
				this.bindTexture(texture_routing);
			}else if(pipe.type == ItemPipeHandler.TRANSPORT_FAST) {
				this.bindTexture(texture_transport_fast);
			}else{
				this.bindTexture(texture_transport_1);
			}
			if (!((pipe.directions[0] != null && pipe.directions[1] != null && pipe.directions[2] == null && pipe.directions[3] == null && pipe.directions[4] == null && pipe.directions[5] == null) || (pipe.directions[0] == null && pipe.directions[1] == null && pipe.directions[2] != null && pipe.directions[3] != null && pipe.directions[4] == null && pipe.directions[5] == null) || (pipe.directions[0] == null && pipe.directions[1] == null && pipe.directions[2] == null && pipe.directions[3] == null && pipe.directions[4] != null && pipe.directions[5] != null))) {
				this.drawCore();
				for (int i = 0; i < pipe.directions.length; i++) {
					if (pipe.directions[i] != null) {
						this.drawConnections(pipe.directions[i], new boolean[] {!pipe.getAllowedSide(0), !pipe.getAllowedSide(1), !pipe.getAllowedSide(2), !pipe.getAllowedSide(3), !pipe.getAllowedSide(4), !pipe.getAllowedSide(5)}, pipe.type);
					}
				}
			}else{
				for (int i = 0; i < pipe.directions.length; i++) {
					if (pipe.directions[i] != null) {
						this.drawFullCable(pipe.directions[i], new boolean[] {!pipe.getAllowedSide(0), !pipe.getAllowedSide(1), !pipe.getAllowedSide(2), !pipe.getAllowedSide(3), !pipe.getAllowedSide(4), !pipe.getAllowedSide(5)}, pipe.type);
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
		
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);

		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 6);

		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 6);

		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);

		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);

		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, 0);
		tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 6);
		tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
		
		tess.draw();
	}
	
	public void drawConnections(ForgeDirection dir, boolean[] allowedSides, int type) {
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		
		boolean shouldRenderLine = false;
		
			if (dir.equals(ForgeDirection.UP)) {
				shouldRenderLine = allowedSides[0];
			}else if (dir.equals(ForgeDirection.DOWN)) {
				shouldRenderLine = allowedSides[1];
				GL11.glRotatef(180, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.NORTH)) {
				shouldRenderLine = allowedSides[5];
				GL11.glRotatef(270, 1, 0, 0);
			}else if (dir.equals(ForgeDirection.EAST)) {
				shouldRenderLine = allowedSides[2];
				GL11.glRotatef(270, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.WEST)) {
				shouldRenderLine = allowedSides[3];
				GL11.glRotatef(90, 0, 0, 1);
			}else if (dir.equals(ForgeDirection.SOUTH)) {
				shouldRenderLine = allowedSides[4];
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

				tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, 0);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 11, 0);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0 + (this.pixel * 5), this.pixel * 11, this.pixel * 6);
	
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, 0);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, 0);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
	
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - (this.pixel * 5), this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5, this.pixel * 6, 0);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 5, this.pixel * 11, 0);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, this.pixel * 6);
	
				tess.addVertexWithUV(this.pixel * 5, 1, this.pixel * 5, this.pixel * 6, this.pixel * 6);
				tess.addVertexWithUV(this.pixel * 5, 1, 1 - (this.pixel * 5), this.pixel * 6, 0);
				tess.addVertexWithUV(this.pixel * 5, 1 - (this.pixel * 5), 1 - (this.pixel * 5), this.pixel * 11, 0);
				tess.addVertexWithUV(this.pixel * 5, 1 - (this.pixel * 5), this.pixel * 5, this.pixel * 11, this.pixel * 6);
				
				if (shouldRenderLine && type == ItemPipeHandler.ROUTING) {
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
				}
				
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
	
	public void drawFullCable(ForgeDirection dir, boolean[] allowedSides, int type) {
		
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
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);

				tess.draw();
				
				if (allowedSides[1] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}

				if (allowedSides[0] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}
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
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);

				tess.draw();
				
				if (allowedSides[5] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}

				if (allowedSides[4] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}
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
				
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, 0, this.pixel * 12);

				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 5), 0, 0, this.pixel * 12);

				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 6);
				tess.addVertexWithUV(1 - (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 6);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 0, 0, this.pixel * 12);
				tess.addVertexWithUV(0 + (this.pixel * 5), 0 + (this.pixel * 5), 1, this.pixel * 16, this.pixel * 12);

				tess.draw();
				
				if (allowedSides[2] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}

				if (allowedSides[3] && type == ItemPipeHandler.ROUTING) {
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(-90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

					tess.startDrawingQuads();
					
					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, this.pixel * 5 - 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, this.pixel * 5 - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 0 + (this.pixel * 5) - 0.0001, 0, 1);

					tess.addVertexWithUV(1 - (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, 0, 1);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1 - (this.pixel * 1), 1 - (this.pixel * 5) + 0.0001, this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(0 + (this.pixel * 5), 1, 1 - this.pixel * 5 + 0.0001, this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(1 - (this.pixel * 5) + 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);

					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, this.pixel * 5, 0, 1);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1, 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), 1 - (this.pixel * 5), this.pixel * 6, 1 - this.pixel);
					tess.addVertexWithUV(this.pixel * 5 - 0.0001, 1 - (this.pixel * 1), this.pixel * 5, 0, 1);

					tess.draw();
					
					GL11.glTranslatef(0.5F, 0.5F, 0.5F);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				}
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			GL11.glRotatef(-90, 0, 1, 0);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			}
	}

}
