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
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.Container.ContainerFurnitureCrafter;

@SideOnly(Side.CLIENT)
public class GuiFurnitureCrafter extends GuiContainer
{
	private int recipeCount;
	private ArrayList<ItemStack[]> recipe_inputs = new ArrayList<ItemStack[]>();
	private ArrayList<ItemStack> recipe_output = new ArrayList<ItemStack>();
	private ArrayList<String[]> recipe_inputs_names = new ArrayList<String[]>();
	private ArrayList<String> recipe_output_name = new ArrayList<String>();
	private ArrayList<Integer> recipe_output_amount = new ArrayList<Integer>();
	
    protected static RenderItem itemRenderer = new RenderItem();
	
    private static final ResourceLocation background_texture = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.FURNITURECRAFTER_GUI + ".png");
    private static final ResourceLocation peripherals = new ResourceLocation(ModInformation.GUITEXTUREPATH + "/" + ModInformation.INV_PER + ".png");
    
    public GuiFurnitureCrafter(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
{
         super(new ContainerFurnitureCrafter(inventoryplayer, world, i, j, k));
         this.addRecipes();
         this.recipeCount = -1;
}

    /**
     * Defines the actual recipes.
     */
    
	private void addRecipes() {
		this.registerRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot)}, new ItemStack(Evercraft_Items.smallplatecluster, 1, 9), 1, new String[] {"Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem"}, "Small Cluster");
		this.registerRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot)}, new ItemStack(Evercraft_Items.mediumplatecluster, 1, 9), 1, new String[] {"Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem"}, "Medium Cluster");
		this.registerRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot), new ItemStack(Evercraft_Items.copperingot)}, new ItemStack(Evercraft_Items.largeplatecluster, 1, 9), 1, new String[] {"Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem", "Ingot/Gem"}, "Large Cluster");
		this.registerRecipe(new ItemStack[] {new ItemStack(Items.iron_ingot), new ItemStack(Items.string), new ItemStack(Items.iron_ingot), null, null, new ItemStack(Items.string), new ItemStack(Items.iron_sword), new ItemStack(Items.string), new ItemStack(Items.iron_hoe), null, new ItemStack(Items.iron_ingot), new ItemStack(Items.string), new ItemStack(Items.iron_pickaxe), new ItemStack(Items.string), new ItemStack(Items.iron_ingot), null, new ItemStack(Items.iron_axe), new ItemStack(Items.string), new ItemStack(Items.iron_shovel), new ItemStack(Items.iron_ingot), null, null, new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot)}, new ItemStack(Evercraft_Items.ironmultitool), 1, new String[] {"Ingot/Gem", "String/Obsidian Stick/Diamond Stick", "Ingot/Gem", null, null, "String/Obsidian Stick/Diamond Stick", "Sword", "String/Obsidian Stick/Diamond Stick", "Hoe", null, "Ingot/Gem", "String/Obsidian Stick/Diamond Stick", "Pickaxe", "String/Obsidian Stick/Diamond Stick", "Ingot/Gem", null, "Axe", "String/Obsidian Stick/Diamond Stick", "Shovel", "Ingot/Gem", null, null, "Ingot/Gem", "Ingot/Gem"}, "Bundled Tool");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.stone)), new ItemStack(Item.getItemFromBlock(Blocks.stone)), new ItemStack(Item.getItemFromBlock(Blocks.stone)), null, null,  new ItemStack(Item.getItemFromBlock(Blocks.stone)), null,  new ItemStack(Item.getItemFromBlock(Blocks.stone)), null, null,  new ItemStack(Item.getItemFromBlock(Blocks.stone)),  new ItemStack(Item.getItemFromBlock(Blocks.stone)),  new ItemStack(Item.getItemFromBlock(Blocks.stone))}, new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 3), 8, new String[] {"Stone", "Stone", "Stone", null, null, "Stone", null, "Stone", null, null, "Stone", "Stone", "Stone"}, "Circle Stone Bricks");
		this.registerRecipe(new ItemStack[] {new ItemStack(Items.emerald), new ItemStack(Items.emerald), new ItemStack(Items.emerald), null, null,  new ItemStack(Items.emerald), null,  new ItemStack(Items.emerald), null, null,  new ItemStack(Items.emerald),  new ItemStack(Items.emerald),  new ItemStack(Items.emerald)}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks), 1, 13), 8, new String[] {"Material", "Material", "Material", null, null, "Material", null, "Material", null, null, "Material", "Material", "Material"}, "Circle Metal Bricks");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks), 1, 5),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks), 1, 5),  null,  null,  null, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks), 1, 5), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks), 1, 5)}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockbricks2), 1, 5), 4, new String[] {"Bricks (Metal, Circle Metal)", "Bricks (Metal, Circle Metal)", null, null, null, "Bricks (Metal, Circle Metal)", "Bricks (Metal, Circle Metal)"}, "Smooth Bricks (Metal, Circle Metal)");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), null, null,  new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), new ItemStack(Items.dye, 1, 4),  new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), null, null,  new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0),  new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0),  new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0)}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 4), 8, new String[] {"Stone Bricks", "Stone Bricks", "Stone Bricks", null, null, "Stone Bricks", "Dye", "Stone Bricks", null, null, "Stone Bricks", "Stone Bricks", "Stone Bricks"}, "Colored Bricks");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0), new ItemStack(Items.dye, 1, 0),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbricks), 1, 0)}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbrickssmooth), 1, 0), 8, new String[] {"Colored Bricks", "Colored Bricks", "Colored Bricks", null, null, "Colored Bricks", "Dye", "Colored Bricks", null, null, "Colored Bricks", "Colored Bricks", "Colored Bricks"}, "Smooth Colored Bricks");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)), new ItemStack(Items.dye, 1, 8),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass)),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockclearglass))}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 8), 8, new String[] {"Glass (Normal, Clear)", "Glass (Normal, Clear)", "Glass (Normal, Clear)", null, null, "Glass (Normal, Clear)", "Dye", "Glass (Normal, Clear)", null, null, "Glass (Normal, Clear)", "Glass (Normal, Clear)", "Glass (Normal, Clear)"}, "Colored Glass (Normal, Clear)");
		this.registerRecipe(new ItemStack[] {new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6), new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6), new ItemStack(Items.glowstone_dust),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6), null, null,  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6),  new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 6)}, new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredglassclear), 1, 8), 8, new String[] {"Glass (Normal, Clear, Colored)", "Glass (Normal, Clear, Colored)", "Glass (Normal, Clear, Colored)", null, null, "Glass (Normal, Clear, Colored)", "Glowstone Dust", "Glass (Normal, Clear, Colored)", null, null, "Glass (Normal, Clear, Colored)", "Glass (Normal, Clear, Colored)", "Glass (Normal, Clear, Colored)"}, "Glowing Glass (Normal, Clear, Colored)");
		this.registerRecipe(new ItemStack[] {new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11)}, new ItemStack(Evercraft_Items.smilespawner), 1, new String[] {"Dandelion Yellow" ,"Ink Sac" ,"Ink Sac" ,"Ink Sac" ,"Dandelion Yellow" ,"Ink Sac" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Ink Sac" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Ink Sac" ,"Dandelion Yellow" ,"Ink Sac" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow" ,"Dandelion Yellow"}, "Smile");
	
	}
	
	/**
	 * Adds all the recipe things into their ArrayLists.
	 * 
	 * @param inputs
	 * @param output
	 * @param outputAmount
	 * @param inputNames
	 * @param outputName
	 */
	
	private void registerRecipe(ItemStack[] inputs, ItemStack output, int outputAmount, String[] inputNames, String outputName) {
		this.recipe_inputs.add(inputs);
		this.recipe_inputs_names.add(inputNames);
		this.recipe_output.add(output);
		this.recipe_output_amount.add(outputAmount);
		this.recipe_output_name.add(outputName);
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
	    		this.drawRecipeForeground(this.recipe_inputs_names.get(this.recipeCount), this.recipe_output_name.get(this.recipeCount), mouseX, mouseY, posX1, posY1);
	    	}else{
	    		this.drawRecipeBackground(this.recipe_inputs.get(this.recipeCount), this.recipe_output.get(this.recipeCount), this.recipe_output_amount.get(this.recipeCount), posX2, posY2);
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
    
    private void drawRecipeForeground(String[] inputName, String outputName, int mouseX, int mouseY, int x, int y) {
    	if (this.recipeCount > -1) {
			if (mouseX > x + 23 && mouseX < x + 24 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				ArrayList<String> Output = new ArrayList<String>();
				Output.add(outputName);
			    this.drawHoveringText(Output, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
			}
			if (mouseX > x + 86 && mouseX < x + 87 + 18 && mouseY > y + 99 && mouseY < y + 100 + 18) {
				if (inputName.length > 0) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[0] != null) {
						Input.add(inputName[0]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 104 && mouseX < x + 105 + 18 && mouseY > y + 99 && mouseY < y + 100 + 18) {
				if (inputName.length > 1) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[1] != null) {
						Input.add(inputName[1]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 122 && mouseX < x + 123 + 18 && mouseY > y + 99 && mouseY < y + 100 + 18) {
				if (inputName.length > 2) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[2] != null) {
						Input.add(inputName[2]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 99 && mouseY < y + 100 + 18) {
				if (inputName.length > 3) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[3] != null) {
						Input.add(inputName[3]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 158 && mouseX < x + 159 + 18 && mouseY > y + 99 && mouseY < y + 100 + 18) {
				if (inputName.length > 4) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[4] != null) {
						Input.add(inputName[4]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}////////////////
			if (mouseX > x + 86 && mouseX < x + 87 + 18 && mouseY > y + 81 && mouseY < y + 82 + 18) {
				if (inputName.length > 5) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[5] != null) {
						Input.add(inputName[5]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 104 && mouseX < x + 105 + 18 && mouseY > y + 81 && mouseY < y + 82 + 18) {
				if (inputName.length > 6) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[6] != null) {
						Input.add(inputName[6]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 122 && mouseX < x + 123 + 18 && mouseY > y + 81 && mouseY < y + 82 + 18) {
				if (inputName.length > 7) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[7] != null) {
						Input.add(inputName[7]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 81 && mouseY < y + 82 + 18) {
				if (inputName.length > 8) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[8] != null) {
						Input.add(inputName[8]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 158 && mouseX < x + 159 + 18 && mouseY > y + 81 && mouseY < y + 82 + 18) {
				if (inputName.length > 9) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[9] != null) {
						Input.add(inputName[9]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}////////////////
			if (mouseX > x + 86 && mouseX < x + 87 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				if (inputName.length > 10) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[10] != null) {
						Input.add(inputName[10]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 104 && mouseX < x + 105 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				if (inputName.length > 11) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[11] != null) {
						Input.add(inputName[11]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 122 && mouseX < x + 123 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				if (inputName.length > 12) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[12] != null) {
						Input.add(inputName[12]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				if (inputName.length > 13) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[13] != null) {
						Input.add(inputName[13]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 158 && mouseX < x + 159 + 18 && mouseY > y + 63 && mouseY < y + 64 + 18) {
				if (inputName.length > 14) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[14] != null) {
						Input.add(inputName[14]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}////////////////
			if (mouseX > x + 86 && mouseX < x + 87 + 18 && mouseY > y + 45 && mouseY < y + 46 + 18) {
				if (inputName.length > 15) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[15] != null) {
						Input.add(inputName[15]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 104 && mouseX < x + 105 + 18 && mouseY > y + 45 && mouseY < y + 46 + 18) {
				if (inputName.length > 16) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[16] != null) {
						Input.add(inputName[16]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 122 && mouseX < x + 123 + 18 && mouseY > y + 45 && mouseY < y + 46 + 18) {
				if (inputName.length > 17) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[17] != null) {
						Input.add(inputName[17]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 45 && mouseY < y + 46 + 18) {
				if (inputName.length > 18) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[18] != null) {
						Input.add(inputName[18]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 158 && mouseX < x + 159 + 18 && mouseY > y + 45 && mouseY < y + 46 + 18) {
				if (inputName.length > 19) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[19] != null) {
						Input.add(inputName[19]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}////////////////
			if (mouseX > x + 86 && mouseX < x + 87 + 18 && mouseY > y + 27 && mouseY < y + 28 + 18) {
				if (inputName.length > 20) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[20] != null) {
						Input.add(inputName[20]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 104 && mouseX < x + 105 + 18 && mouseY > y + 27 && mouseY < y + 28 + 18) {
				if (inputName.length > 21) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[21] != null) {
						Input.add(inputName[21]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 122 && mouseX < x + 123 + 18 && mouseY > y + 27 && mouseY < y + 28 + 18) {
				if (inputName.length > 22) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[22] != null) {
						Input.add(inputName[22]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 140 && mouseX < x + 141 + 18 && mouseY > y + 27 && mouseY < y + 28 + 18) {
				if (inputName.length > 23) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[23] != null) {
						Input.add(inputName[23]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
			if (mouseX > x + 158 && mouseX < x + 159 + 18 && mouseY > y + 27 && mouseY < y + 28 + 18) {
				if (inputName.length > 24) {
					ArrayList<String> Input = new ArrayList<String>();
					if (inputName[24] != null) {
						Input.add(inputName[24]);
				    	this.drawHoveringText(Input, mouseX - ((this.width - this.xSize) / 2) - 8, mouseY - ((this.height - this.ySize) / 2) - 16, fontRendererObj);
					}
				}
			}
    	}
    }
    
    /**
     * Draws the recipe images in the inventory.
     * 
     * @param input
     * @param inputAmount
     * @param output
     * @param amountOut
     * @param x
     * @param y
     */
    
    private void drawRecipeBackground(ItemStack[] input, ItemStack output, int amountOut, int x, int y) {
    	itemRenderer.zLevel = 100.0F;
    	if (input.length > 0) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[0], x + 87, y + 100);
    	}
    	if (input.length > 1) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[1], x + 105, y + 100);
    	}
    	if (input.length > 2) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[2], x + 123, y + 100);
    	}
    	if (input.length > 3) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[3], x + 141, y + 100);
    	}
    	if (input.length > 4) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[4], x + 159, y + 100);
    	}/////
    	if (input.length > 5) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[5], x + 87, y + 82);
    	}
    	if (input.length > 6) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[6], x + 105, y + 82);
    	}
    	if (input.length > 7) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[7], x + 123, y + 82);
    	}
    	if (input.length > 8) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[8], x + 141, y + 82);
    	}
    	if (input.length > 9) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[9], x + 159, y + 82);
    	}/////
    	if (input.length > 10) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[10], x + 87, y + 64);
    	}
    	if (input.length > 11) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[11], x + 105, y + 64);
    	}
    	if (input.length > 12) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[12], x + 123, y + 64);
    	}
    	if (input.length > 13) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[13], x + 141, y + 64);
    	}
    	if (input.length > 14) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[14], x + 159, y + 64);
    	}/////
    	if (input.length > 15) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[15], x + 87, y + 46);
    	}
    	if (input.length > 16) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[16], x + 105, y + 46);
    	}
    	if (input.length > 17) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[17], x + 123, y + 46);
    	}
    	if (input.length > 18) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[18], x + 141, y + 46);
    	}
    	if (input.length > 19) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[19], x + 159, y + 46);
    	}/////
    	if (input.length > 20) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[20], x + 87, y + 28);
    	}
    	if (input.length > 21) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[21], x + 105, y + 28);
    	}
    	if (input.length > 22) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[22], x + 123, y + 28);
    	}
    	if (input.length > 23) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[23], x + 141, y + 28);
    	}
    	if (input.length > 24) {
        	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), input[24], x + 159, y + 28);
    	}
    	
    	this.itemRenderer.renderItemAndEffectIntoGUI(fontRendererObj, mc.getTextureManager(), output, x + 24, y + 64);
    	this.itemRenderer.renderItemOverlayIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(output.getItem(), amountOut, output.getItemDamage()), x + 24, y + 64);
    		
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
            this.drawTexturedModalRect(k + 76, l + 100, 0, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 76, l + 100, 0, 0, 7, 7);
        }
        if (this.recipeCount > -1) {
            this.drawTexturedModalRect(k + 76, l + 109, 7, 7, 7, 7);
        }else{
            this.drawTexturedModalRect(k + 76, l + 109, 7, 0, 7, 7);
        }
        this.drawTexturedModalRect(k + 65, l + 100, 14, 0, 9, 16);
    }
    
    /**
     * Handles mouse clicking.
     */
    
	public void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;

        if (this.recipeCount < this.recipe_inputs.size()-1) {
        	if (x > k + 75 && x < k + 83 && y > l + 99 && y < l + 107) {
				this.recipeCount += 1;
			}
        }
        if (this.recipeCount > -1) {
        	if (x > k + 75 && x < k + 83 && y > l + 108 && y < l + 116) {
				this.recipeCount -= 1;
			}
        }
        if (x > k + 64 && x < k + 74 && y > l + 99 && y < l + 116) {
			this.recipeCount = -1;
        }
	}
    
    /**
     * Draws the foreground layer of the inventory.
     */
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	    this.fontRendererObj.drawString(StatCollector.translateToLocal("Advanced"), 8, this.ySize - 192, 4210752);
	    this.fontRendererObj.drawString(StatCollector.translateToLocal("Crafter"), 8, this.ySize - 182, 4210752);
	    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 112, 4210752);
		this.getRecipe(true, par1, par2, (this.width - this.xSize) / 2, (this.height - this.ySize) / 2, 0, 0);
	}

    /**
     * Draws the background layer of the inventory.
     */
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.background_texture);
        xSize = 190;
        ySize = 202;
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1 + 19, 0, 0, xSize, ySize);
	         
	         this.drawButtons(l, i1);
	         this.getRecipe(false, 0, 0, 0, 0, l, i1);
	}
}