package evercraft.NEMESIS13cz.TileEntity.Gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.MachineRecipes.AlloyFurnaceRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAlloyFurnace;
import evercraft.NEMESIS13cz.Utils.GuiHelper;
import evercraft.NEMESIS13cz.Utils.PowerHandler;

@SideOnly(Side.CLIENT)
public class GuiAlloyFurnace extends GuiContainer
{
    
	private int recipeCount;
	private ArrayList<ItemStack[]> recipe_inputs = new ArrayList<ItemStack[]>();

    protected static RenderItem itemRenderer = new RenderItem();
    
    private TileEntityAlloyFurnace furnaceInventory;
    
    private static final ResourceLocation background_texture = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.ALLOYFURNACE_GUI + ".png");
    private static final ResourceLocation peripherals = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.INV_PER + ".png");
    
    public GuiAlloyFurnace(InventoryPlayer par1InventoryPlayer, TileEntityAlloyFurnace par2TileEntityMachine) {
        super(new ContainerAlloyFurnace(par1InventoryPlayer, par2TileEntityMachine));
        this.furnaceInventory = par2TileEntityMachine;
        this.addRecipes();
        this.recipeCount = -1;
    }   
    
    /**
     * Defines the actual recipes.
     */
    
	private void addRecipes() {
		for (int i = 0; i < Evercraft.getEvercraft().alloyFurnaceRecipes.length; i++) {
			this.registerRecipe((ItemStack[]) Evercraft.getEvercraft().alloyFurnaceRecipes[i]);
		}
	}
	
	/**
	 * Adds all the recipe things into their ArrayLists.
	 * 
	 * @param input
	 * @param output
	 * @param outputAmount
	 * @param inputName
	 * @param outputName
	 */
	
	private void registerRecipe(ItemStack[] input) {
		this.recipe_inputs.add(input);
	}
	
	/**
	 * Switches between foreground and background rendering.
	 * 
	 * @param mode
	 * @param mouseX
	 * @param mouseY
	 * @param posX1
	 * @param posY1
	 * @param posX2
	 * @param posY2
	 */
	
    private void getRecipe(boolean mode, int mouseX, int mouseY, int posX1, int posY1, int posX2, int posY2) {
    	if (this.recipeCount > -1) {
	    	if (mode) {
	    		this.drawRecipeForeground(this.recipe_inputs.get(this.recipeCount)[0].getDisplayName(), this.recipe_inputs.get(this.recipeCount)[1].getDisplayName(), AlloyFurnaceRecipes.smelting().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)).getDisplayName(), mouseX, mouseY, posX1, posY1, AlloyFurnaceRecipes.smelting().AlloyFurnaceRecipesProcessSpeed(this.recipe_inputs.get(this.recipeCount)), AlloyFurnaceRecipes.smelting().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)).getItem() == Evercraft_Items.potionmatrix, AlloyFurnaceRecipes.smelting().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)));
	    	}else{
	    		this.drawRecipeBackground(this.recipe_inputs.get(this.recipeCount), AlloyFurnaceRecipes.smelting().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)), AlloyFurnaceRecipes.smelting().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)).stackSize, posX2, posY2, AlloyFurnaceRecipes.smelting().AlloyFurnaceRecipesInputAmount(this.recipe_inputs.get(this.recipeCount)));
	    	}
    	}
    }
    
    /**
     * Draws the recipe item names in the inventory.
     * 
     * @param inputName
     * @param outputName
     * @param mouseX
     * @param mouseY
     * @param x
     * @param y
     */
    
    private void drawRecipeForeground(String inputName1, String inputName2, String outputName, int mouseX, int mouseY, int x, int y, int processSpeed, boolean isPotionMatrix, ItemStack additionalOutput) {
    	if (this.recipeCount > -1) {
            this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(processSpeed), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(processSpeed)) / 2, this.ySize - 150, 4210752);
    		String cost = processSpeed * AlloyFurnaceRecipes.smelting().AlloyFurnaceRecipesPowerConsumption(this.recipe_inputs.get(this.recipeCount)) + " EE";
            this.fontRendererObj.drawString(cost, 214 - this.fontRendererObj.getStringWidth(cost) / 2, this.ySize - 138, 4210752);
    		String consumption = AlloyFurnaceRecipes.smelting().AlloyFurnaceRecipesPowerConsumption(this.recipe_inputs.get(this.recipeCount)) + " EE/tick";
            this.fontRendererObj.drawString(consumption, 214 - this.fontRendererObj.getStringWidth(consumption) / 2, this.ySize - 126, 4210752);
            
            if (isPotionMatrix) {
                String s = additionalOutput.getTooltip(Minecraft.getMinecraft().thePlayer, false).get(1).toString();
                this.fontRendererObj.drawString(s, 120 - this.fontRendererObj.getStringWidth(s) / 2, this.ySize - 126 + 28, 4210752);
            }
            
			if (mouseX > x + 54 - 18 && mouseX < x + 55 && mouseY > y + 33 - 18 && mouseY < y + 34) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(inputName1);
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 54 + 14 && mouseX < x + 55 + 32 && mouseY > y + 33 - 18 && mouseY < y + 34) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(inputName2);
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 114 && mouseX < x + 115 + 18 && mouseY > y + 33 && mouseY < y + 34 + 18) {
				ArrayList<String> Output = new ArrayList<String>();
				Output.add(outputName);
		    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
    	}
    }
    
    /**
     * Draws the recipe images in the inventory.
     * 
     * @param input
     * @param output
     * @param amountOut
     * @param x
     * @param y
     */

    private void drawRecipeBackground(ItemStack[] input, ItemStack output, int amountOut, int x, int y, int[] inputAmounts) {

        this.mc.renderEngine.bindTexture(this.peripherals);
        this.drawTexturedModalRect(x + 176, y + 5, 14, 16, 80, 56);
        //this.drawTexturedModalRect(x + 176, y + 5 + 56, 14, 16, 80, 56);
        
    	itemRenderer.zLevel = 100.0F;
    	if (this.furnaceInventory.furnaceItemStacks[0] == null) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[0], x + 56 - 18, y + 35 - 18);
    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(input[0].getItem(), inputAmounts[0], input[0].getItemDamage()), x + 56 - 18, y + 35 - 18);
    	}
    	if (this.furnaceInventory.furnaceItemStacks[1] == null) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[1], x + 56 + 14, y + 35 - 18);
    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(input[1].getItem(), inputAmounts[1], input[1].getItemDamage()), x + 56 + 14, y + 35 - 18);
    	}
    	if (this.furnaceInventory.furnaceItemStacks[3] == null) {
    		this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), output, x + 116, y + 35);
    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(output.getItem(), amountOut, output.getItemDamage()), x + 116, y + 35);
    	}
    	itemRenderer.zLevel = 0.0F;
    }
    
    /**
     * Draws buttons.
     * 
     * @param k
     * @param l
     */
    
    private void drawButtons(int k, int l) {
        this.mc.renderEngine.bindTexture(this.peripherals);
        
        if (this.recipeCount < this.recipe_inputs.size()-1) {
            this.drawTexturedModalRect(k + 27, l + 35 - 18, 0, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 27, l + 35 - 18, 0, 0, 7, 7);
        }
        if (this.recipeCount > -1) {
            this.drawTexturedModalRect(k + 27, l + 44 - 18, 7, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 27, l + 44 - 18, 7, 0, 7, 7);
        }
        this.drawTexturedModalRect(k + 26, l + 35, 14, 0, 9, 16);
    }
    
    /**
     * Handles mouse clicking.
     */
    
	public void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;

        if (this.recipeCount < this.recipe_inputs.size()-1) {
        	if (x > k + 26 && x < k + 34 && y > l + 34 - 18 && y < l + 42 - 18) {
				this.recipeCount += 1;
			}
        }
        if (this.recipeCount > -1) {
        	if (x > k + 26 && x < k + 34 && y > l + 43 - 18 && y < l + 51 - 18) {
				this.recipeCount -= 1;
			}
        }
        if (x > k + 25 && x < k + 35 && y > l + 34 && y < l + 51) {
			this.recipeCount = -1;
        }
	}
    
    /**
     * Draws the foreground layer of the inventory.
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
		
		this.getRecipe(true, par1, par2, (this.width - this.xSize) / 2, (this.height - this.ySize) / 2, 0, 0);
    }
    
    /**
     * Draws the background layer of the inventory.
     */
    
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.background_texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (par2 > k + 5 && par2 < k + 24 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 6, l + 6, 208, 25, 18, 68);
            this.drawTexturedModalRect(k + 7, l + 71 - 64, 176 + 16, 89 - 64, 16, 64 + 2);
        }
        
        if (this.furnaceInventory.hasPower())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 7, l + 71 - i1, 176, 89 - i1, 16, i1 + 2);
        }
        
        i1 = this.furnaceInventory.getCookProgressScaled(93);
        int i2 = i1 - 5;
        int i3 = i1 - 25;
        int i4 = i1 - 31;
        int i5 = i1 - 61;
        int i6 = i1 - 78;
        
        if (i1 < 12) {
        	this.drawTexturedModalRect(k + 41, l + 35, 176, 0, 10, i1);
        	this.drawTexturedModalRect(k + 41 + 32, l + 35, 176 + 32, 0, 10, i1);
        }else{
        	this.drawTexturedModalRect(k + 41, l + 35, 176, 0, 10, 11);
        	this.drawTexturedModalRect(k + 41 + 32, l + 35, 176 + 32, 0, 10, 11);
        }
        if (i2 < 22) {
        	this.drawTexturedModalRect(k + 41, l + 35, 176, 0, i2, 14);
        	this.drawTexturedModalRect(k + 41 + 21 + 21 - i2, l + 35, 176 + 42 - i2, 0, i2, 14);
        }else{
        	this.drawTexturedModalRect(k + 41, l + 35, 176, 0, 21, 14);
        	this.drawTexturedModalRect(k + 41 + 21 + 21 - 21, l + 35, 176 + 42 - 21, 0, 21, 14);
        }
        if (i3 < 11) {
        	this.drawTexturedModalRect(k + 41 + 16, l + 35 + 12, 176 + 16, 12, 10, i3);
        }else{
        	this.drawTexturedModalRect(k + 41 + 16, l + 35 + 12, 176 + 16, 12, 10, 10);
        }
        if (i4 < 32) {
        	this.drawTexturedModalRect(k + 41 + 16, l + 35 + 19, 176 + 16, 19, i4, 6);
        }else{
        	this.drawTexturedModalRect(k + 41 + 16, l + 35 + 19, 176 + 16, 19, 31, 6);
        }
        if (i5 < 21) {
        	this.drawTexturedModalRect(k + 41 + 44, l + 35 + 5 + 20 - i5, 176 + 44, 5 + 20 - i5, 10, i5);
        }else{
        	this.drawTexturedModalRect(k + 41 + 44, l + 35 + 5, 176 + 44, 5, 10, 20);
        }
        if (i6 < 14) {
        	this.drawTexturedModalRect(k + 41 + 53, l + 35, 176 + 53, 0, i6, 16);
        }else{
        	this.drawTexturedModalRect(k + 41 + 53, l + 35, 176 + 53, 0, 13, 16);
        }

        this.drawButtons(k, l);
        this.getRecipe(false, 0, 0, 0, 0, k, l);
    }
}
