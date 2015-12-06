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
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerMiner;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiner;

@SideOnly(Side.CLIENT)
public class GuiMiner extends GuiContainer
{
    private TileEntityMiner furnaceInventory;
    private static final ResourceLocation field_110409_t = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.MINER_GUI + ".png");
    public GuiMiner(InventoryPlayer par1InventoryPlayer, TileEntityMiner par2TileEntityMachine)
    {
        super(new ContainerMiner(par1InventoryPlayer, par2TileEntityMachine));
        this.furnaceInventory = par2TileEntityMachine;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.furnaceInventory.hasCustomInventoryName() ? this.furnaceInventory.getInventoryName() : StatCollector.translateToLocal(this.furnaceInventory.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 92, 4210752);
        
		if (par1 > ((this.width - this.xSize) / 2) + 5 && par1 < ((this.width - this.xSize) / 2) + 24 && par2 > ((this.height - this.ySize) / 2) + 5 && par2 < ((this.height - this.ySize) / 2) + 72) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("EE: " + this.furnaceInventory.power + "/" + this.furnaceInventory.maxPower);
		this.drawHoveringText(lines, par1 - ((this.width - this.xSize) / 2), par2 - ((this.height - this.ySize) / 2), fontRendererObj);
		}
		if (par1 > ((this.width - this.xSize) / 2) + 26 && par1 < ((this.width - this.xSize) / 2) + 35 && par2 > ((this.height - this.ySize) / 2) + 5 && par2 < ((this.height - this.ySize) / 2) + 72) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Breaking: " + this.furnaceInventory.miningProgress + "/" + Evercraft_Config_Machines.minerSpeed);
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

        if (par2 > k + 5 && par2 < k + 24 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 6, l + 5, 208, 16, 18, 68);
            this.drawTexturedModalRect(k + 7, l + 71 - 64, 192, 17, 16, 64 + 1);
        }
        if (par2 > k + 26 && par2 < k + 35 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 27, l + 5, 188, 81, 8, 68);
            this.drawTexturedModalRect(k + 28, l + 71 - 64, 182, 82, 6, 64 + 1);
        }
        
        if (this.furnaceInventory.hasPower())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 7, l + 71 - i1, 176, 81 - i1, 16, i1 + 1);
        }
        if (this.furnaceInventory.miningProgress > 0) {
            i2 = this.furnaceInventory.getDigTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 28, l + 71 - i2, 176, 146 - i2, 6, i2 + 1);
        }
    }
}
