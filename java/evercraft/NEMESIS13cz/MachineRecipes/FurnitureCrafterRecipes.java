package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.misc.FurnitureCrafterShapedRecipes;
import evercraft.NEMESIS13cz.TileEntity.misc.FurnitureCrafterShapelessRecipes;

public class FurnitureCrafterRecipes
{
    /**
     * The static instance of this class
     */
    private static final FurnitureCrafterRecipes instance = new FurnitureCrafterRecipes();
    /**
     * A list of all the recipes added
     */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final FurnitureCrafterRecipes getInstance()
    {
        /**
         * The static instance of this class
         */
        return instance;
    }
    
    private DictionaryExtractor dict;

    private FurnitureCrafterRecipes() {
    	
    	//Misc
    	this.addRecipe(new ItemStack(Blocks.stonebrick, 4, 0), new Object[] {"ii","ii",'i', Blocks.stone});
    	this.addRecipe(new ItemStack(Blocks.stonebrick, 8, 3), new Object[] {"iii","i i", "iii",'i', Blocks.stone});
    	this.addRecipe(new ItemStack(Evercraft_Items.netherbrickstick, 4), new Object[] {"i","i",'i', Items.netherbrick});
    	this.addRecipe(new ItemStack(Evercraft_Items.stonestick, 4), new Object[] {"i","i",'i', Blocks.cobblestone});
    	this.addRecipe(new ItemStack(Evercraft_Items.obsidianstick, 4), new Object[] {"i","i",'i', Blocks.obsidian});
    	this.addRecipe(new ItemStack(Evercraft_Items.goldstick, 4), new Object[] {"i","i",'i', Items.gold_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Items.ironstick, 4), new Object[] {"i","i",'i', Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Items.diamondstick, 4), new Object[] {"i","i",'i', Items.diamond});	
    		//Metal Bricks -- normal
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockrsbricks,4,0), new Object[] {"ii","ii",'i',Items.redstone});
    		for (int ID = 0; ID < dict.hardenedRedstoneIngot.size(); ID++) {
    			this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,0), new Object[] {"ii","ii",'i',new ItemStack(dict.hardenedRedstoneIngot.get(ID).getItem(), 1, dict.hardenedRedstoneIngot.get(ID).getItemDamage())});
    		}
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,2), new Object[] {"ii","ii",'i',Blocks.obsidian});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,4), new Object[] {"ii","ii",'i',Items.netherbrick});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,6), new Object[] {"ii","ii",'i',Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,8), new Object[] {"ii","ii",'i',Items.gold_ingot});
    		for (int ID = 0; ID < dict.diamond.size(); ID++) {
    			this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,10), new Object[] {"ii","ii",'i',new ItemStack(dict.diamond.get(ID).getItem(), 1, dict.diamond.get(ID).getItemDamage())});
    		}
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,12), new Object[] {"ii","ii",'i',Items.emerald});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,4,14), new Object[] {"ii","ii",'i',new ItemStack(Items.dye,1,4)});
    		//Metal Bricks -- smooth normal
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockrsbricks,4,2), new Object[] {"ii","ii",'i',new ItemStack(Evercraft_Blocks.blockrsbricks,1,0)});
    	for(int i=0;i<16;i++) {
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks2,4,i), new Object[] {"ii","ii",'i',new ItemStack(Evercraft_Blocks.blockbricks,1,i)});
    	}
    		//Metal Bricks -- circle
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockrsbricks,8,1), new Object[] {"iii","i i","iii",'i',Items.redstone});
    		for (int ID = 0; ID < dict.hardenedRedstoneIngot.size(); ID++) {
    			this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,1), new Object[] {"iii","i i","iii",'i',new ItemStack(dict.hardenedRedstoneIngot.get(ID).getItem(), 1, dict.hardenedRedstoneIngot.get(ID).getItemDamage())});
    		}
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,3), new Object[] {"iii","i i","iii",'i',Blocks.obsidian});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,5), new Object[] {"iii","i i","iii",'i',Items.netherbrick});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,7), new Object[] {"iii","i i","iii",'i',Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,9), new Object[] {"iii","i i","iii",'i',Items.gold_ingot});
    		for (int ID = 0; ID < dict.diamond.size(); ID++) {
    			this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,11), new Object[] {"iii","i i","iii",'i',new ItemStack(dict.diamond.get(ID).getItem(), 1, dict.diamond.get(ID).getItemDamage())});
    		}
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,13), new Object[] {"iii","i i","iii",'i',Items.emerald});
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockbricks,8,15), new Object[] {"iii","i i","iii",'i',new ItemStack(Items.dye,1,4)});
    		//Metal Bricks -- smooth circle
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockrsbricks,4,3), new Object[] {"ii","ii",'i',new ItemStack(Evercraft_Blocks.blockrsbricks,1,1)});
    		//Colored Bricks
    	for (int ID = 0; ID < dict.blackDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,0), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blackDye.get(ID).getItem(), 1, dict.blackDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.redDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,1), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.redDye.get(ID).getItem(), 1, dict.redDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.greenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,2), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.greenDye.get(ID).getItem(), 1, dict.greenDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.brownDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,3), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.brownDye.get(ID).getItem(), 1, dict.brownDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.blueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,4), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blueDye.get(ID).getItem(), 1, dict.blueDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.purpleDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,5), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.purpleDye.get(ID).getItem(), 1, dict.purpleDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.cyanDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,6), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.cyanDye.get(ID).getItem(), 1, dict.cyanDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.lightGrayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,7), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGrayDye.get(ID).getItem(), 1, dict.lightGrayDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.grayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,8), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.grayDye.get(ID).getItem(), 1, dict.grayDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.pinkDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,9), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.pinkDye.get(ID).getItem(), 1, dict.pinkDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.lightGreenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,10), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGreenDye.get(ID).getItem(), 1, dict.lightGreenDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.yellowDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,11), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.yellowDye.get(ID).getItem(), 1, dict.yellowDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.lightBlueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,12), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightBlueDye.get(ID).getItem(), 1, dict.lightBlueDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.magentaDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,13), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.magentaDye.get(ID).getItem(), 1, dict.magentaDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.orangeDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,14), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.orangeDye.get(ID).getItem(), 1, dict.orangeDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}
    	for (int ID = 0; ID < dict.whiteDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbricks,8,15), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.whiteDye.get(ID).getItem(), 1, dict.whiteDye.get(ID).getItemDamage()), 'b', new ItemStack(Blocks.stonebrick,1,0)});
    	}

    		//Colored Bricks -- smooth
    	for (int ID = 0; ID < dict.blackDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,0), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blackDye.get(ID).getItem(), 1, dict.blackDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,0)});
    	}
    	for (int ID = 0; ID < dict.redDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,1), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.redDye.get(ID).getItem(), 1, dict.redDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,1)});
    	}
    	for (int ID = 0; ID < dict.greenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,2), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.greenDye.get(ID).getItem(), 1, dict.greenDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,2)});
    	}
    	for (int ID = 0; ID < dict.brownDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,3), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.brownDye.get(ID).getItem(), 1, dict.brownDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,3)});
    	}
    	for (int ID = 0; ID < dict.blueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,4), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blueDye.get(ID).getItem(), 1, dict.blueDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,4)});
    	}
    	for (int ID = 0; ID < dict.purpleDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,5), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.purpleDye.get(ID).getItem(), 1, dict.purpleDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,5)});
    	}
    	for (int ID = 0; ID < dict.cyanDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,6), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.cyanDye.get(ID).getItem(), 1, dict.cyanDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,6)});
    	}
    	for (int ID = 0; ID < dict.lightGrayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,7), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGrayDye.get(ID).getItem(), 1, dict.lightGrayDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,7)});
    	}
    	for (int ID = 0; ID < dict.grayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,8), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.grayDye.get(ID).getItem(), 1, dict.grayDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,8)});
    	}
    	for (int ID = 0; ID < dict.pinkDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,9), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.pinkDye.get(ID).getItem(), 1, dict.pinkDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,9)});
    	}
    	for (int ID = 0; ID < dict.lightGreenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,10), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGreenDye.get(ID).getItem(), 1, dict.lightGreenDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,10)});
    	}
    	for (int ID = 0; ID < dict.yellowDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,11), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.yellowDye.get(ID).getItem(), 1, dict.yellowDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,11)});
    	}
    	for (int ID = 0; ID < dict.lightBlueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,12), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightBlueDye.get(ID).getItem(), 1, dict.lightBlueDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,12)});
    	}
    	for (int ID = 0; ID < dict.magentaDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,13), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.magentaDye.get(ID).getItem(), 1, dict.magentaDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,13)});
    	}
    	for (int ID = 0; ID < dict.orangeDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,14), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.orangeDye.get(ID).getItem(), 1, dict.orangeDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,14)});
    	}
    	for (int ID = 0; ID < dict.whiteDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredbrickssmooth,8,15), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.whiteDye.get(ID).getItem(), 1, dict.whiteDye.get(ID).getItemDamage()), 'b', new ItemStack(Evercraft_Blocks.blockcoloredbricks,1,15)});
    	}
    		//Colored Glass
    	for (int ID = 0; ID < dict.blackDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,15), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blackDye.get(ID).getItem(), 1, dict.blackDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.redDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,14), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.redDye.get(ID).getItem(), 1, dict.redDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.greenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,13), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.greenDye.get(ID).getItem(), 1, dict.greenDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.brownDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,12), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.brownDye.get(ID).getItem(), 1, dict.brownDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.blueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,11), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blueDye.get(ID).getItem(), 1, dict.blueDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.purpleDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,10), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.purpleDye.get(ID).getItem(), 1, dict.purpleDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.cyanDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,9), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.cyanDye.get(ID).getItem(), 1, dict.cyanDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.lightGrayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,8), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGrayDye.get(ID).getItem(), 1, dict.lightGrayDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.grayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,7), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.grayDye.get(ID).getItem(), 1, dict.grayDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.pinkDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,6), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.pinkDye.get(ID).getItem(), 1, dict.pinkDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.lightGreenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,5), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGreenDye.get(ID).getItem(), 1, dict.lightGreenDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.yellowDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,4), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.yellowDye.get(ID).getItem(), 1, dict.yellowDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.lightBlueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,3), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightBlueDye.get(ID).getItem(), 1, dict.lightBlueDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.magentaDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,2), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.magentaDye.get(ID).getItem(), 1, dict.magentaDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.orangeDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,1), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.orangeDye.get(ID).getItem(), 1, dict.orangeDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    	for (int ID = 0; ID < dict.whiteDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Blocks.stained_glass,8,0), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.whiteDye.get(ID).getItem(), 1, dict.whiteDye.get(ID).getItemDamage()), 'b', Blocks.glass});
    	}
    		//Colored Glass -- clear
    	for (int ID = 0; ID < dict.blackDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,0), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blackDye.get(ID).getItem(), 1, dict.blackDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.redDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,1), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.redDye.get(ID).getItem(), 1, dict.redDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.greenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,2), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.greenDye.get(ID).getItem(), 1, dict.greenDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.brownDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,3), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.brownDye.get(ID).getItem(), 1, dict.brownDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.blueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,4), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.blueDye.get(ID).getItem(), 1, dict.blueDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.purpleDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,5), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.purpleDye.get(ID).getItem(), 1, dict.purpleDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.cyanDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,6), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.cyanDye.get(ID).getItem(), 1, dict.cyanDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.lightGrayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,7), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGrayDye.get(ID).getItem(), 1, dict.lightGrayDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.grayDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,8), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.grayDye.get(ID).getItem(), 1, dict.grayDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.pinkDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,9), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.pinkDye.get(ID).getItem(), 1, dict.pinkDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.lightGreenDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,10), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightGreenDye.get(ID).getItem(), 1, dict.lightGreenDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.yellowDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,11), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.yellowDye.get(ID).getItem(), 1, dict.yellowDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.lightBlueDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,12), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.lightBlueDye.get(ID).getItem(), 1, dict.lightBlueDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.magentaDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,13), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.magentaDye.get(ID).getItem(), 1, dict.magentaDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.orangeDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,14), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.orangeDye.get(ID).getItem(), 1, dict.orangeDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int ID = 0; ID < dict.whiteDye.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclear,8,15), new Object[] {"bbb","bcb","bbb",'c',new ItemStack(dict.whiteDye.get(ID).getItem(), 1, dict.whiteDye.get(ID).getItemDamage()), 'b', Evercraft_Blocks.blockclearglass});
    	}
    	for (int i = 0; i < 16; i++) {
    		//Colored Glass Glowing
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassglowing,8,i), new Object[] {"bbb","bcb","bbb",'b',new ItemStack(Blocks.stained_glass,1,i), 'c', Items.glowstone_dust});
    		//Colored Glass Glowing -- clear
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockcoloredglassclearglowing,8,i), new Object[] {"bbb","bcb","bbb",'b',new ItemStack(Evercraft_Blocks.blockcoloredglassclear,1,i), 'c', Items.glowstone_dust});
    	}	//Glass Glowing
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockvanillaglassglowing,8), new Object[] {"bbb","bcb","bbb",'b',Blocks.glass, 'c', Items.glowstone_dust});
    		//Glass Glowing -- clear
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blockclearglassglowing,8), new Object[] {"bbb","bcb","bbb",'b',Evercraft_Blocks.blockclearglass, 'c', Items.glowstone_dust});
    		//Smile
    	for (int ID1 = 0; ID1 < dict.yellowDye.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.blackDye.size(); ID2++) {
    			this.addRecipe(new ItemStack(Evercraft_Items.smilespawner,1), new Object[] {"yyyyy", "ybyby", "yyyyy", "byyyb", "ybbby", 'b', new ItemStack(dict.blackDye.get(ID2).getItem(), 1, dict.blackDye.get(ID2).getItemDamage()), 'y', new ItemStack(dict.yellowDye.get(ID1).getItem(), 1, dict.yellowDye.get(ID1).getItemDamage())});
    		}
    	}
    		//Plate Clusters - Small
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,0), new Object[] {"mmmmm", 'm', Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,1), new Object[] {"mmmmm", 'm', Items.gold_ingot});
    	for (int ID = 0; ID < dict.zincIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,2), new Object[] {"mmmmm", 'm', new ItemStack(dict.zincIngot.get(ID).getItem(), 1, dict.zincIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,3), new Object[] {"mmmmm", 'm', Items.emerald});
    	for (int ID = 0; ID < dict.diamond.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,4), new Object[] {"mmmmm", 'm', new ItemStack(dict.diamond.get(ID).getItem(), 1, dict.diamond.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.aluminiumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,5), new Object[] {"mmmmm", 'm', new ItemStack(dict.aluminiumIngot.get(ID).getItem(), 1, dict.aluminiumIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.bronzeIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,6), new Object[] {"mmmmm", 'm', new ItemStack(dict.bronzeIngot.get(ID).getItem(), 1, dict.bronzeIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.steelIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,7), new Object[] {"mmmmm", 'm', new ItemStack(dict.steelIngot.get(ID).getItem(), 1, dict.steelIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.tinIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,8), new Object[] {"mmmmm", 'm', new ItemStack(dict.tinIngot.get(ID).getItem(), 1, dict.tinIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.copperIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,9), new Object[] {"mmmmm", 'm', new ItemStack(dict.copperIngot.get(ID).getItem(), 1, dict.copperIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,10), new Object[] {"mmmmm", 'm', Items.quartz});
    	for (int ID = 0; ID < dict.silverIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,11), new Object[] {"mmmmm", 'm', new ItemStack(dict.silverIngot.get(ID).getItem(), 1, dict.silverIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.titaniumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster,1,12), new Object[] {"mmmmm", 'm', new ItemStack(dict.titaniumIngot.get(ID).getItem(), 1, dict.titaniumIngot.get(ID).getItemDamage())});
    	}
    		//Plate Clusters - Medium
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,0), new Object[] {"mmmmm","mmmmm", 'm', Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,1), new Object[] {"mmmmm","mmmmm", 'm', Items.gold_ingot});
    	for (int ID = 0; ID < dict.zincIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,2), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.zincIngot.get(ID).getItem(), 1, dict.zincIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,3), new Object[] {"mmmmm","mmmmm", 'm', Items.emerald});
    	for (int ID = 0; ID < dict.diamond.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,4), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.diamond.get(ID).getItem(), 1, dict.diamond.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.aluminiumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,5), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.aluminiumIngot.get(ID).getItem(), 1, dict.aluminiumIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.bronzeIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,6), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.bronzeIngot.get(ID).getItem(), 1, dict.bronzeIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.steelIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,7), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.steelIngot.get(ID).getItem(), 1, dict.steelIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.tinIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,8), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.tinIngot.get(ID).getItem(), 1, dict.tinIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.copperIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,9), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.copperIngot.get(ID).getItem(), 1, dict.copperIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,10), new Object[] {"mmmmm","mmmmm", 'm', Items.quartz});
    	for (int ID = 0; ID < dict.silverIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,11), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.silverIngot.get(ID).getItem(), 1, dict.silverIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.titaniumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster,1,12), new Object[] {"mmmmm","mmmmm", 'm', new ItemStack(dict.titaniumIngot.get(ID).getItem(), 1, dict.titaniumIngot.get(ID).getItemDamage())});
    	}
    		//Plate Clusters - Large
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,0), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', Items.iron_ingot});
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,1), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', Items.gold_ingot});
    	for (int ID = 0; ID < dict.zincIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,2), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.zincIngot.get(ID).getItem(), 1, dict.zincIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,3), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', Items.emerald});
    	for (int ID = 0; ID < dict.diamond.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,4), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.diamond.get(ID).getItem(), 1, dict.diamond.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.aluminiumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,5), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.aluminiumIngot.get(ID).getItem(), 1, dict.aluminiumIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.bronzeIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,6), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.bronzeIngot.get(ID).getItem(), 1, dict.bronzeIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.steelIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,7), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.steelIngot.get(ID).getItem(), 1, dict.steelIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.tinIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,8), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.tinIngot.get(ID).getItem(), 1, dict.tinIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.copperIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,9), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.copperIngot.get(ID).getItem(), 1, dict.copperIngot.get(ID).getItemDamage())});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,10), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', Items.quartz});
    	for (int ID = 0; ID < dict.silverIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,11), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.silverIngot.get(ID).getItem(), 1, dict.silverIngot.get(ID).getItemDamage())});
    	}
    	for (int ID = 0; ID < dict.titaniumIngot.size(); ID++) {
    	this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster,1,12), new Object[] {"mmmmm","mmmmm","mmmmm", 'm', new ItemStack(dict.titaniumIngot.get(ID).getItem(), 1, dict.titaniumIngot.get(ID).getItemDamage())});
    	}
    	//Multi tools
    	for (int ID = 0; ID < dict.woodPlank.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.woodmultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.woodPlank.get(ID).getItem(), 1, dict.woodPlank.get(ID).getItemDamage()), 'S', Items.string, 's', Items.wooden_sword, 'h', Items.wooden_hoe, 'p', Items.wooden_pickaxe, 'a', Items.wooden_axe, 'l', Items.wooden_shovel});
    	}
    	this.addRecipe(new ItemStack(Evercraft_Items.stonemultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', Blocks.cobblestone, 'S', Items.string, 's', Items.stone_sword, 'h', Items.stone_hoe, 'p', Items.stone_pickaxe, 'a', Items.stone_axe, 'l', Items.stone_shovel});
    	this.addRecipe(new ItemStack(Evercraft_Items.ironmultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', Items.iron_ingot, 'S', Items.string, 's', Items.iron_sword, 'h', Items.iron_hoe, 'p', Items.iron_pickaxe, 'a', Items.iron_axe, 'l', Items.iron_shovel});
    	this.addRecipe(new ItemStack(Evercraft_Items.goldmultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', Items.gold_ingot, 'S', Items.string, 's', Items.golden_sword, 'h', Items.golden_hoe, 'p', Items.golden_pickaxe, 'a', Items.golden_axe, 'l', Items.golden_shovel});
    	for (int ID1 = 0; ID1 < dict.obsidianStick.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.diamond.size(); ID2++) {
    			this.addRecipe(new ItemStack(Evercraft_Items.diamondmultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.diamond.get(ID2).getItem(), 1, dict.diamond.get(ID2).getItemDamage()), 'S', new ItemStack(dict.obsidianStick.get(ID1).getItem(), 1, dict.obsidianStick.get(ID1).getItemDamage()), 's', Items.diamond_sword, 'h', Items.diamond_hoe, 'p', Items.diamond_pickaxe, 'a', Items.diamond_axe, 'l', Items.diamond_shovel});
    		}
    	}
    	for (int ID = 0; ID < dict.copperIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.coppermultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.copperIngot.get(ID).getItem(), 1, dict.copperIngot.get(ID).getItemDamage()), 'S', Items.string, 's', Evercraft_Items.coppersword, 'h', Evercraft_Items.copperhoe, 'p', Evercraft_Items.copperpickaxe, 'a', Evercraft_Items.copperaxe, 'l', Evercraft_Items.coppershovel});
    	}
    	for (int ID = 0; ID < dict.bronzeIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.bronzemultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.bronzeIngot.get(ID).getItem(), 1, dict.bronzeIngot.get(ID).getItemDamage()), 'S', Items.string, 's', Evercraft_Items.bronzesword, 'h', Evercraft_Items.bronzehoe, 'p', Evercraft_Items.bronzepickaxe, 'a', Evercraft_Items.bronzeaxe, 'l', Evercraft_Items.bronzeshovel});
    	}
    	for (int ID1 = 0; ID1 < dict.steelIngot.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.obsidianStick.size(); ID2++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.steelmultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.steelIngot.get(ID1).getItem(), 1, dict.steelIngot.get(ID1).getItemDamage()), 'S', new ItemStack(dict.obsidianStick.get(ID2).getItem(), 1, dict.obsidianStick.get(ID2).getItemDamage()), 's', Evercraft_Items.steelsword, 'h', Evercraft_Items.steelhoe, 'p', Evercraft_Items.steelpickaxe, 'a', Evercraft_Items.steelaxe, 'l', Evercraft_Items.steelshovel});
    		}
    	}
    	for (int ID = 0; ID < dict.hardenedRedstoneIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.redstonemultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.hardenedRedstoneIngot.get(ID).getItem(), 1, dict.hardenedRedstoneIngot.get(ID).getItemDamage()), 'S', Items.string, 's', Evercraft_Items.redstonesword, 'h', Evercraft_Items.redstonehoe, 'p', Evercraft_Items.redstonepickaxe, 'a', Evercraft_Items.redstoneaxe, 'l', Evercraft_Items.redstoneshovel});
    	}
    	for (int ID = 0; ID < dict.hardenedLapisIngot.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.lapismultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(dict.hardenedLapisIngot.get(ID).getItem(), 1, dict.hardenedLapisIngot.get(ID).getItemDamage()), 'S', Items.string, 's', Evercraft_Items.lapissword, 'h', Evercraft_Items.lapishoe, 'p', Evercraft_Items.lapispickaxe, 'a', Evercraft_Items.lapisaxe, 'l', Evercraft_Items.lapisshovel});
    	}
    	for (int ID = 0; ID < dict.obsidianStick.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.obsidiummultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', Evercraft_Items.obsidiumgem, 'S',new ItemStack(dict.obsidianStick.get(ID).getItem(), 1, dict.obsidianStick.get(ID).getItemDamage()), 's', Evercraft_Items.obsidiumsword, 'h', Evercraft_Items.obsidiumhoe, 'p', Evercraft_Items.obsidiumpickaxe, 'a', Evercraft_Items.obsidiumaxe, 'l', Evercraft_Items.obsidiumshovel});
    	}
    	if (Evercraft_Config_Base.hardmode == false) {
    	for (int ID = 0; ID < dict.diamondStick.size(); ID++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.derpymultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', new ItemStack(Evercraft_Items.derpyingot, 1, 0), 'S', new ItemStack(dict.diamondStick.get(ID).getItem(), 1, dict.diamondStick.get(ID).getItemDamage()), 's', Evercraft_Items.derpysword, 'h', Evercraft_Items.derpyhoe, 'p', Evercraft_Items.derpypickaxe, 'a', Evercraft_Items.derpyaxe, 'l', Evercraft_Items.derpyshovel});
    	}
    	}else{
    		for (int ID = 0; ID < dict.diamondStick.size(); ID++) {
    			this.addRecipe(new ItemStack(Evercraft_Items.derpymultitool,1), new Object[] {"  MM "," aSlM", "MSpSM", "SsSh ", "MSM  ", 'M', Evercraft_Blocks.blockderpyblock, 'S', new ItemStack(dict.diamondStick.get(ID).getItem(), 1, dict.diamondStick.get(ID).getItemDamage()), 's', Evercraft_Items.derpysword, 'h', Evercraft_Items.derpyhoe, 'p', Evercraft_Items.derpypickaxe, 'a', Evercraft_Items.derpyaxe, 'l', Evercraft_Items.derpyshovel});
    		}
    	}
    	this.addRecipe(new ItemStack(Evercraft_Blocks.blocksmileblock, 1), new Object[] {"ii","ii",'i', Evercraft_Items.smilespawner});

        Collections.sort(this.recipes, new Comparator()
        {
            private static final String __OBFID = "CL_00000091";
            public int compare(IRecipe par1IRecipe, IRecipe par2IRecipe)
            {
                return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
            }
            public int compare(Object par1Obj, Object par2Obj)
            {
                return this.compare((IRecipe)par1Obj, (IRecipe)par2Obj);
            }
        });
    }

    public FurnitureCrafterShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        FurnitureCrafterShapedRecipes shapedrecipes = new FurnitureCrafterShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new FurnitureCrafterShapelessRecipes(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}