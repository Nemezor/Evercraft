package evercraft.NEMESIS13cz.TileEntity.Gui;

import java.util.ArrayList;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.MachineRecipes.CentrifugeRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCentrifuge;
import evercraft.NEMESIS13cz.Utils.GuiHelper;
import evercraft.NEMESIS13cz.Utils.PowerHandler;

@SideOnly(Side.CLIENT)
public class GuiCentrifuge extends GuiContainer
{
	private int recipeCount;
	private ArrayList<ItemStack> recipe_inputs = new ArrayList<ItemStack>();

    protected static RenderItem itemRenderer = new RenderItem();
    
    private TileEntityCentrifuge furnaceInventory;
    private static final ResourceLocation background_texture = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.CENTRIFUGE_GUI + ".png");
    private static final ResourceLocation peripherals = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.INV_PER + ".png");
    public GuiCentrifuge(InventoryPlayer par1InventoryPlayer, TileEntityCentrifuge par2TileEntityFurnace)
    {
        super(new ContainerCentrifuge(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        this.addRecipes();
        this.recipeCount = -1;
    }

    /**
     * Defines the actual recipes.
     */
    
	private void addRecipes() {
		for (int i = 0; i < Evercraft.getEvercraft().centrifugeRecipes.length; i++) {
			this.registerRecipe((ItemStack) Evercraft.getEvercraft().centrifugeRecipes[i]);
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
	    		this.drawRecipeForeground(mouseX, mouseY, posX1, posY1, recipe_inputs.get(this.recipeCount), CentrifugeRecipes.centrifuging().CentrifugeRecipesProcessSpeed(this.recipe_inputs.get(this.recipeCount)));
	    	}else{
	    		this.drawRecipeBackground(recipe_inputs.get(this.recipeCount), posX2, posY2);
	    	}
    	}
    }
    
    /**
     * Draws the recipe item names in the inventory.
     * 
     * @param mouseX
     * @param mouseY
     * @param x
     * @param y
     * @param input
     * @param processSpeed
     */
    
    private void drawRecipeForeground(int mouseX, int mouseY, int x, int y, ItemStack input, int processSpeed) {
    	ItemStack[] outputs = CentrifugeRecipes.centrifuging().getSmeltingResult(input);

        this.fontRendererObj.drawString(GuiHelper.TicksIntoTime(processSpeed), 214 - this.fontRendererObj.getStringWidth(GuiHelper.TicksIntoTime(processSpeed)) / 2, this.ySize - 150, 4210752);
		String cost = CentrifugeRecipes.centrifuging().CentrifugeRecipesProcessSpeed(input) * PowerHandler.CentrifugeConsump + " EE";
        this.fontRendererObj.drawString(cost, 214 - this.fontRendererObj.getStringWidth(cost) / 2, this.ySize - 138, 4210752);
		String consumption = PowerHandler.CentrifugeConsump + " EE/tick";
        this.fontRendererObj.drawString(consumption, 214 - this.fontRendererObj.getStringWidth(consumption) / 2, this.ySize - 126, 4210752);
    	
    	if (this.recipeCount > -1) {
			if (mouseX > x + 54 && mouseX < x + 55 + 18 && mouseY > y + 33 && mouseY < y + 34 + 18) {
				ArrayList<String> Input = new ArrayList<String>();
				Input.add(input.getDisplayName());
		    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
			}
			if (mouseX > x + 114 && mouseX < x + 115 + 18 && mouseY > y + 14 && mouseY < y + 15 + 18) {
				if (outputs[0] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[0].getItem(), 1, outputs[0].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
			if (mouseX > x + 114 && mouseX < x + 115 + 18 && mouseY > y + 33 && mouseY < y + 34 + 18) {
				if (outputs[1] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[1].getItem(), 1, outputs[1].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
			if (mouseX > x + 114 && mouseX < x + 115 + 18 && mouseY > y + 51 && mouseY < y + 52 + 18) {
				if (outputs[2] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[2].getItem(), 1, outputs[2].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
			if (mouseX > x + 132 && mouseX < x + 133 + 18 && mouseY > y + 33 && mouseY < y + 34 + 18) {
				if (outputs[3] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[3].getItem(), 1, outputs[3].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
			if (mouseX > x + 132 && mouseX < x + 133 + 18 && mouseY > y + 14 && mouseY < y + 15 + 18) {
				if (outputs[4] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[4].getItem(), 1, outputs[4].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
			if (mouseX > x + 132 && mouseX < x + 133 + 18 && mouseY > y + 51 && mouseY < y + 52 + 18) {
				if (outputs[5] != null) {
					ArrayList<String> Output = new ArrayList<String>();
					Output.add(new ItemStack(outputs[5].getItem(), 1, outputs[5].getItemDamage()).getDisplayName());
			    	this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), fontRendererObj);
				}
			}
    	}
    }
    
    /**
     * Draws the recipe images in the inventory.
     * 
     * @param input
     * @param x
     * @param y
     */
    
    private void drawRecipeBackground(ItemStack input, int x, int y) {

    	ItemStack[] outputs = CentrifugeRecipes.centrifuging().getSmeltingResult(input);

        this.mc.renderEngine.bindTexture(this.peripherals);
        this.drawTexturedModalRect(x + 176, y + 5, 14, 16, 80, 56);
        
    	itemRenderer.zLevel = 100.0F;
    	if (this.furnaceInventory.furnaceItemStacks[0] == null) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input, x + 56, y + 35);
        	this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(input.getItem(), CentrifugeRecipes.centrifuging().CentrifugeRecipesInputAmount(input), input.getItemDamage()), x + 56, y + 35);
    	}
    	if (this.furnaceInventory.furnaceItemStacks[2] == null && this.furnaceInventory.furnaceItemStacks[3] == null && this.furnaceInventory.furnaceItemStacks[4] == null && this.furnaceInventory.furnaceItemStacks[5] == null && this.furnaceInventory.furnaceItemStacks[6] == null && this.furnaceInventory.furnaceItemStacks[7] == null) {
    		if (outputs[0] != null) {
    			this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[0], x + 116, y + 16);
    			this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[0].getItem(), outputs[0].stackSize, outputs[0].getItemDamage()), x + 116, y + 16);
    		}
    		if (outputs[1] != null) {
        		this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[1], x + 116, y + 35);
        		this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[1].getItem(), outputs[1].stackSize, outputs[1].getItemDamage()), x + 116, y + 35);
    		}
    		if (outputs[2] != null) {
    			this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[2], x + 116, y + 53);
    			this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[2].getItem(), outputs[2].stackSize, outputs[2].getItemDamage()), x + 116, y + 53);
    		}
    		if (outputs[3] != null) {
    			this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[3], x + 134, y + 35);
    			this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[3].getItem(), outputs[3].stackSize, outputs[3].getItemDamage()), x + 134, y + 35);
    		}
    		if (outputs[4] != null) {
    			this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[4], x + 134, y + 16);
    			this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[4].getItem(), outputs[4].stackSize, outputs[4].getItemDamage()), x + 134, y + 16);
    		}
    		if (outputs[5] != null) {
    			this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), outputs[5], x + 134, y + 53);
    			this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(outputs[5].getItem(), outputs[5].stackSize, outputs[5].getItemDamage()), x + 134, y + 53);
    		}
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
        
        if (this.recipeCount < recipe_inputs.size()-1) {
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

        if (this.recipeCount < recipe_inputs.size()-1) {
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
        this.mc.renderEngine.bindTexture(background_texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        int i2;
        int i3;

        if (par2 > k + 5 && par2 < k + 24 && par3 > l + 5 && par3 < l + 72) {
            this.drawTexturedModalRect(k + 6, l + 6, 208, 45, 18, 66);
            this.drawTexturedModalRect(k + 7, l + 71 - 64, 176 + 16, 109 - 64, 16, 64 + 2);
        }
        
        if (this.furnaceInventory.hasPower())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(64);
            this.drawTexturedModalRect(k + 7, l + 71 - i1, 176, 109 - i1, 16, i1 + 2);
        }
        
        i2 = this.furnaceInventory.getCookProgressScaled(58);
        i3 = this.furnaceInventory.getCookProgressScaled(100);
        
        if (i2 > 0 && i2 <= 11) {
            this.drawTexturedModalRect(k + 60, l + 33 - i2, 176, 12 - i2, 8, i2);
            this.drawTexturedModalRect(k + 60, l + 53, 176, 32, 8, i2);
        }else if (i2 > 11) {
            this.drawTexturedModalRect(k + 60, l + 33 - 11, 176, 12 - 11, 8, 11);
            this.drawTexturedModalRect(k + 60, l + 53, 176, 32, 8, 11);
        }
        if (i2 > 2) {
            this.drawTexturedModalRect(k + 60, l + 21, 176, 0, i2-2, 9);
            this.drawTexturedModalRect(k + 60, l + 57, 176, 36, i2-2, 9);
        }
        if (i2 > 34) {
        	if (i3 < 79) {
                this.drawTexturedModalRect(k + 85, l + 27, 176 + 25, 6, 10, i3 - 60);
        	}else{
                this.drawTexturedModalRect(k + 85, l + 27, 176 + 25, 6, 10, 19);
                this.drawTexturedModalRect(k + 85, l + 38, 176 + 25, 17, i3 - 65, 10);
        	}
        }        
        this.drawButtons(k, l);
        this.getRecipe(false, 0, 0, 0, 0, k, l);

    }
}
