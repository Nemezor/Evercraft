package evercraft.NEMESIS13cz.TileEntity.Gui;

import java.util.ArrayList;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedElectrolyzerRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.ElectrolyzerRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerOreFactory;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityOreFactory;
import evercraft.NEMESIS13cz.Utils.GuiHelper;
import evercraft.NEMESIS13cz.Utils.PowerHandler;

@SideOnly(Side.CLIENT)
public class GuiOreFactory extends GuiContainer
{	
	private int recipeCount;
	private ArrayList<ItemStack> recipe_inputs = new ArrayList<ItemStack>();
	
	protected static RenderItem itemRenderer = new RenderItem();

    private TileEntityOreFactory furnaceInventory;
    private static final ResourceLocation background_texture = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.OREFACTORY_GUI + ".png");
    private static final ResourceLocation peripherals = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.INV_PER + ".png");
    public GuiOreFactory(InventoryPlayer par1InventoryPlayer, TileEntityOreFactory par2TileEntityFurnace)
    {
        super(new ContainerOreFactory(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        this.addRecipes();
        this.recipeCount = -1;
    }

    /**
     * Defines the actual recipes.
     */
    
	private void addRecipes() {
		for (int i = 0; i < Evercraft.getEvercraft().advCrusherRecipes.length; i++) {
			this.registerRecipe((ItemStack) Evercraft.getEvercraft().advCrusherRecipes[i]);
		}
	}
	
	/**
	 * Adds all the recipe things into their ArrayLists.
	 * 
	 * @param input
	 */
	
	private void registerRecipe(ItemStack input) {
		recipe_inputs.add(input);
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
	    		ItemStack crusherRes = AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.recipe_inputs.get(this.recipeCount));
	    		ItemStack electrolyzerRes = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(crusherRes);
	    		ItemStack furnaceRes = FurnaceRecipes.smelting().getSmeltingResult(crusherRes);
	    		
	    		this.drawRecipeForeground(this.recipe_inputs.get(this.recipeCount).getDisplayName(), (furnaceRes == null && electrolyzerRes == null) ? "" : (furnaceRes != null ? "" : (crusherRes.getDisplayName())), (furnaceRes == null && electrolyzerRes == null) ? "" : (electrolyzerRes != null ? "" : (crusherRes.getDisplayName())), crusherRes.getDisplayName(), electrolyzerRes != null ? electrolyzerRes.getDisplayName() : "", furnaceRes != null ? furnaceRes.getDisplayName() : "", mouseX, mouseY, posX1, posY1, PowerHandler.AdvCrusherSpeed, PowerHandler.AdvElectrolyzerSpeed * 2, PowerHandler.AdvFurnaceSpeed, AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.recipe_inputs.get(this.recipeCount)).stackSize);
	    	}else{
	    		ItemStack crusherRes = AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.recipe_inputs.get(this.recipeCount));
	    		ItemStack electrolyzerRes = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(crusherRes);
	    		ItemStack furnaceRes = FurnaceRecipes.smelting().getSmeltingResult(crusherRes);
	    		
	    		this.drawRecipeBackground(this.recipe_inputs.get(this.recipeCount), (furnaceRes == null && electrolyzerRes == null) ? null : (furnaceRes != null ? null : crusherRes), (furnaceRes == null && electrolyzerRes == null) ? null : (electrolyzerRes != null ? null : crusherRes), crusherRes, electrolyzerRes, furnaceRes, crusherRes != null ? crusherRes.stackSize : 1, electrolyzerRes != null ? electrolyzerRes.stackSize : 1, furnaceRes != null ? furnaceRes.stackSize : 1, posX2, posY2);
	    	}
    	}
    }
    
    /**
     * Draws the recipe item names in the inventory.
     * 
     * @param inputNameCrusher
     * @param inputNameElectrolyzer
     * @param inputNameFurnace
     * @param outputNameCrusher
     * @param outputNameElectrolyzer
     * @param outputNameFurnace
     * @param mouseX
     * @param mouseY
     * @param x
     * @param y
     * @param processSpeedCrusher
     * @param processSpeedElectrolyzer
     * @param processSpeedFurnace
     */
    
    private void drawRecipeForeground(String inputNameCrusher, String inputNameElectrolyzer, String inputNameFurnace, String outputNameCrusher, String outputNameElectrolyzer, String outputNameFurnace, int mouseX, int mouseY, int x, int y, int processSpeedCrusher, int processSpeedElectrolyzer, int processSpeedFurnace, int crusherOutputAmount) {
    	if (this.recipeCount > -1) {
    		
    		int totalTime = 0;
    		int totalPower = 0;
    		
    		String processC = "Crushing";
    		this.fontRendererObj.drawString(processC, 214 - this.fontRendererObj.getStringWidth(processC) / 2, this.ySize - 155, 4210752);
            this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(processSpeedCrusher), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(processSpeedCrusher)) / 2, this.ySize - 145, 4210752);
    		String costC = processSpeedCrusher * PowerHandler.AdvCrusherConsump + " EE";
            this.fontRendererObj.drawString(costC, 214 - this.fontRendererObj.getStringWidth(costC) / 2, this.ySize - 133, 4210752);
    		String consumptionC = PowerHandler.AdvCrusherConsump + " EE/tick";
            this.fontRendererObj.drawString(consumptionC, 214 - this.fontRendererObj.getStringWidth(consumptionC) / 2, this.ySize - 121, 4210752);
            totalTime += processSpeedCrusher;
            
            if (!outputNameElectrolyzer.equals("")) {
        		String processE = "Electrolyzing";
        		this.fontRendererObj.drawString(processE, 214 - this.fontRendererObj.getStringWidth(processE) / 2, this.ySize - 155 + 56, 4210752);
                this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(processSpeedElectrolyzer), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(processSpeedElectrolyzer)) / 2, this.ySize - 145 + 56, 4210752);
        		String costE = processSpeedElectrolyzer * PowerHandler.AdvElectrolyzerConsump / 2 + " EE";
                this.fontRendererObj.drawString(costE, 214 - this.fontRendererObj.getStringWidth(costE) / 2, this.ySize - 133 + 56, 4210752);
        		String consumptionE = PowerHandler.AdvElectrolyzerConsump / 2 + " EE/tick";
                this.fontRendererObj.drawString(consumptionE, 214 - this.fontRendererObj.getStringWidth(consumptionE) / 2, this.ySize - 121 + 56, 4210752);
                totalTime += processSpeedElectrolyzer * crusherOutputAmount;
                totalPower += PowerHandler.AdvElectrolyzerConsump / 2;
            }else if (!outputNameFurnace.equals("")) {
        		String processF = "Smelting";
        		this.fontRendererObj.drawString(processF, 214 - this.fontRendererObj.getStringWidth(processF) / 2, this.ySize - 155 + 56, 4210752);
                this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(processSpeedFurnace), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(processSpeedFurnace)) / 2, this.ySize - 145 + 56, 4210752);
        		String costF = processSpeedFurnace * PowerHandler.AdvFurnaceConsump + " EE";
                this.fontRendererObj.drawString(costF, 214 - this.fontRendererObj.getStringWidth(costF) / 2, this.ySize - 133 + 56, 4210752);
        		String consumptionF = PowerHandler.AdvFurnaceConsump + " EE/tick";
                this.fontRendererObj.drawString(consumptionF, 214 - this.fontRendererObj.getStringWidth(consumptionF) / 2, this.ySize - 121 + 56, 4210752);
                totalTime += processSpeedFurnace * crusherOutputAmount;
                totalPower += PowerHandler.AdvFurnaceConsump;
            }else{
        		String processO = "No other";
        		this.fontRendererObj.drawString(processO, 214 - this.fontRendererObj.getStringWidth(processO) / 2, this.ySize - 144 + 56, 4210752);
        		String processO1 = "operations";
        		this.fontRendererObj.drawString(processO1, 214 - this.fontRendererObj.getStringWidth(processO1) / 2, this.ySize - 136 + 56, 4210752);
            }

    		String processL = "Total";
    		this.fontRendererObj.drawString(processL, 214 - this.fontRendererObj.getStringWidth(processL) / 2, this.ySize - 150 + 112, 4210752);
            this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(totalTime), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(totalTime)) / 2, this.ySize - 138 + 112, 4210752);
    		String costL = (processSpeedCrusher * PowerHandler.AdvCrusherConsump + (totalTime - processSpeedCrusher) * totalPower) + " EE";
            this.fontRendererObj.drawString(costL, 214 - this.fontRendererObj.getStringWidth(costL) / 2, this.ySize - 126 + 112, 4210752);
            
            
			if (mouseX > x + 31 && mouseX < x + 32 + 18 && mouseY > y + 9 && mouseY < y + 10 + 18) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(inputNameCrusher);
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 84 && mouseX < x + 85 + 18 && mouseY > y + 54 && mouseY < y + 55 + 18 && !inputNameElectrolyzer.equals("")) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(inputNameElectrolyzer);
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 84 && mouseX < x + 85 + 18 && mouseY > y + 34 && mouseY < y + 35 + 18 && !inputNameFurnace.equals("")) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(inputNameFurnace);
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 79 && mouseX < x + 80 + 18 && mouseY > y + 9 && mouseY < y + 10 + 18) {
				ArrayList<String> Output = new ArrayList<String>();
				Output.add(outputNameCrusher);
		    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 54 && mouseY < y + 55 + 18 && !outputNameElectrolyzer.equals("")) {
				ArrayList<String> Output = new ArrayList<String>();
				Output.add(outputNameElectrolyzer);
		    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 34 && mouseY < y + 35 + 18 && !outputNameFurnace.equals("")) {
				ArrayList<String> Output = new ArrayList<String>();
				Output.add(outputNameFurnace);
		    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
    	}
    }
    
    /**
     * Draws the recipe images in the inventory.
     * 
     * @param inputCrusher
     * @param inputElectrolyzer
     * @param inputFurnace
     * @param outputCrusher
     * @param outputElectrolyzer
     * @param outputFurnace
     * @param amountOutCrusher
     * @param amountOutElectrolyzer
     * @param amountOutFurnace
     * @param x
     * @param y
     */
    
    private void drawRecipeBackground(ItemStack inputCrusher, ItemStack inputElectrolyzer, ItemStack inputFurnace, ItemStack outputCrusher, ItemStack outputElectrolyzer, ItemStack outputFurnace, int amountOutCrusher, int amountOutElectrolyzer, int amountOutFurnace, int x, int y) {
	    if (this.recipeCount > -1) {
	
	        this.mc.renderEngine.bindTexture(this.peripherals);
	        this.drawTexturedModalRect(x + 176, y + 5, 14, 16, 80, 56);
	        this.drawTexturedModalRect(x + 176, y + 5 + 56, 14, 16, 80, 56);
	        this.drawTexturedModalRect(x + 176, y + 5 + 112, 14, 16, 80, 56);
	        
	    	itemRenderer.zLevel = 100.0F;
	    	if (this.furnaceInventory.furnaceItemStacks[0] == null) {
	        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), inputCrusher, x + 32, y + 10);
	    	}
	    	if (this.furnaceInventory.furnaceItemStacks[1] == null && inputElectrolyzer != null) {
	        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), inputElectrolyzer, x + 85, y + 55);
	    	}
	    	if (this.furnaceInventory.furnaceItemStacks[2] == null && inputFurnace != null) {
	        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), inputFurnace, x + 85, y + 35);
	    	}
	    	if (this.furnaceInventory.furnaceItemStacks[4] == null) {
	    		this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputCrusher, x + 80, y + 10);
	    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputCrusher.getItem(), amountOutCrusher, outputCrusher.getItemDamage()), x + 80, y + 10);
	    	}
	    	if (this.furnaceInventory.furnaceItemStacks[5] == null && outputElectrolyzer != null) {
	    		this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputElectrolyzer, x + 141, y + 55);
	    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputElectrolyzer.getItem(), amountOutElectrolyzer, outputElectrolyzer.getItemDamage()), x + 141, y + 55);
	    	}
	    	if (this.furnaceInventory.furnaceItemStacks[6] == null && outputFurnace != null) {
	    		this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputFurnace, x + 141, y + 35);
	    		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputFurnace.getItem(), amountOutFurnace, outputFurnace.getItemDamage()), x + 141, y + 35);
	    	}
	    	itemRenderer.zLevel = 0.0F;
    	}
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
            this.drawTexturedModalRect(k + 47, l + 35, 0, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 47, l + 35, 0, 0, 7, 7);
        }
        if (this.recipeCount > -1) {
            this.drawTexturedModalRect(k + 47, l + 44, 7, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 47, l + 44, 7, 0, 7, 7);
        }
        this.drawTexturedModalRect(k + 36, l + 35, 14, 0, 9, 16);
    }
    
    /**
     * Handles mouse clicking.
     */
    
	public void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;

        if (this.recipeCount < this.recipe_inputs.size()-1) {
        	if (x > k + 46 && x < k + 54 && y > l + 34 && y < l + 42) {
				this.recipeCount += 1;
			}
        }
        if (this.recipeCount > -1) {
        	if (x > k + 46 && x < k + 54 && y > l + 43 && y < l + 51) {
				this.recipeCount -= 1;
			}
        }
        if (x > k + 35 && x < k + 45 && y > l + 34 && y < l + 51) {
			this.recipeCount = -1;
        }
	}
    
    /**
     * Draws the foreground layer of the inventory.
     */
	
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	this.fontRendererObj.drawString("Ore", this.xSize - 72, this.ySize - 162, 4210752);
    	this.fontRendererObj.drawString("Processing", this.xSize - 72, this.ySize - 152, 4210752);
    	this.fontRendererObj.drawString("Plant", this.xSize - 72, this.ySize - 142, 4210752);
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
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.mc.renderEngine.bindTexture(this.peripherals);
        if (this.recipeCount > -1) {
	        this.drawTexturedModalRect(k + 172, l + 5 + 112, 14 + 80, 16, 4, 56);
        }
        this.mc.renderEngine.bindTexture(background_texture);
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        int i2;
        int i3;

        if (par2 > k + 5 && par2 < k + 24 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 6, l + 5, 208, 16, 18, 68);
            this.drawTexturedModalRect(k + 7, l + 71 - 64, 176 + 16, 81 - 64, 16, 64 + 2);
        }
        
        if (this.furnaceInventory.hasPower())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 7, l + 71 - i1, 176, 81 - i1, 16, i1 + 2);
        }

        i1 = this.furnaceInventory.getCookProgressScaledCrushing(25);
        this.drawTexturedModalRect(k + 49, l + 10, 176, 0, i1 + 1, 16);

        i2 = this.furnaceInventory.getCookProgressScaledElectrolyzing(25);
        this.drawTexturedModalRect(k + 104, l + 55, 176 + 25, 0, i2 + 1, 16);

        i3 = this.furnaceInventory.getCookProgressScaledSmelting(25);
        this.drawTexturedModalRect(k + 104, l + 35, 176 + 50, 0, i3 + 1, 16);

        this.drawButtons(k, l);
        this.getRecipe(false, 0, 0, 0, 0, k, l);
    }
}
