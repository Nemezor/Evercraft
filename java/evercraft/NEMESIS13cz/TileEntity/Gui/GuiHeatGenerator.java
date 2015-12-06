package evercraft.NEMESIS13cz.TileEntity.Gui;

import java.util.ArrayList;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerHeatGenerator;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHeatGenerator;

@SideOnly(Side.CLIENT)
public class GuiHeatGenerator extends GuiContainer
{
    private TileEntityHeatGenerator furnaceInventory;
    private static final ResourceLocation field_110409_t = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.HEATGENERATOR_GUI + ".png");
    public GuiHeatGenerator(InventoryPlayer par1InventoryPlayer, TileEntityHeatGenerator par2TileEntityMachine)
    {
        super(new ContainerHeatGenerator(par1InventoryPlayer, par2TileEntityMachine));
        this.furnaceInventory = par2TileEntityMachine;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.furnaceInventory.hasCustomInventoryName() ? this.furnaceInventory.getInventoryName() : StatCollector.translateToLocal(this.furnaceInventory.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 + 42, 3, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 92, 4210752);
        
		if (par1 > ((this.width - this.xSize) / 2) + 5 && par1 < ((this.width - this.xSize) / 2) + 72 && par2 > ((this.height - this.ySize) / 2) + 5 && par2 < ((this.height - this.ySize) / 2) + 72) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("EE: " + this.furnaceInventory.power + "/" + this.furnaceInventory.maxPower);
		this.drawHoveringText(lines, par1 - ((this.width - this.xSize) / 2), par2 - ((this.height - this.ySize) / 2), fontRendererObj);
		}
		if (par1 > ((this.width - this.xSize) / 2) + 73 && par1 < ((this.width - this.xSize) / 2) + 84 && par2 > ((this.height - this.ySize) / 2) + 5 && par2 < ((this.height - this.ySize) / 2) + 72) {
		ArrayList<String> lines = new ArrayList<String>();
		if (this.furnaceInventory.hasFuel()) {
			lines.add("Heat: " + this.furnaceInventory.burning + "/" + this.furnaceInventory.burningMax);
		}else{
			lines.add("Insert Fuel");
		}
		this.drawHoveringText(lines, par1 - ((this.width - this.xSize) / 2), par2 - ((this.height - this.ySize) / 2), fontRendererObj);
		}
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(field_110409_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        int i2;

        if (par2 > k + 5 && par2 < k + 72 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 6, l + 6, 176, 128, 66, 66);
            this.drawTexturedModalRect(k + 7, l + 71 - 64, 176, 64, 64, 64);
        }
        
        if (par2 > k + 73 && par2 < k + 84 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 74, l + 6, 242, 128, 10, 66);
            this.drawTexturedModalRect(k + 75, l + 71 - 64, 242, 64, 8, 64);
        }
        
        if (this.furnaceInventory.hasPower())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(64);
        	this.drawTexturedModalRect(k + 7, l + 71 - i1, 176, 64 - i1, 64, i1);
        }
        
        if (this.furnaceInventory.hasFuel())
        {
            i2 = this.furnaceInventory.getFuelTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 75, l + 71 - i2, 242, 64 - i2, 8, i2);
            //Flame
            this.drawTexturedModalRect(k + 118, l + 35, 0, 166, 14, 14);
        }
    }
}
