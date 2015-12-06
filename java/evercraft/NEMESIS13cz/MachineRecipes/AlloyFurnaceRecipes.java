package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class AlloyFurnaceRecipes
{
    private static final AlloyFurnaceRecipes smeltingBase = new AlloyFurnaceRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map inputAmountList = new HashMap();
    private Map powerConsumpList = new HashMap();
    private Map processSpeedList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static AlloyFurnaceRecipes smelting()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private AlloyFurnaceRecipes() {
    	
    	for (int i = 0; i < dict.goldDust.size(); i++) {
    		for (int j = 0; j < dict.silverDust.size(); j++) {    	
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.silverDust.get(j).getItem(), 1, dict.silverDust.get(j).getItemDamage()), new ItemStack(dict.goldDust.get(i).getItem(), 1, dict.goldDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.electrumingot, 2), new int[] {1, 1}, 300, 4);
    		}
    	}
    	for (int i = 0; i < dict.goldDust.size(); i++) {
    		for (int j = 0; j < dict.silverIngot.size(); j++) {    	
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.silverIngot.get(j).getItem(), 1, dict.silverIngot.get(j).getItemDamage()), new ItemStack(dict.goldDust.get(i).getItem(), 1, dict.goldDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.electrumingot, 2), new int[] {1, 1}, 300, 4);
    		}
    	}
    	for (int j = 0; j < dict.silverDust.size(); j++) {    	
    		this.addRecipe(new ItemStack[] {new ItemStack(dict.silverDust.get(j).getItem(), 1, dict.silverDust.get(j).getItemDamage()), new ItemStack(Items.gold_ingot)}, new ItemStack(Evercraft_Items.electrumingot, 2), new int[] {1, 1}, 300, 4);
    	}
    	for (int j = 0; j < dict.silverIngot.size(); j++) {    	
    		this.addRecipe(new ItemStack[] {new ItemStack(dict.silverIngot.get(j).getItem(), 1, dict.silverIngot.get(j).getItemDamage()), new ItemStack(Items.gold_ingot)}, new ItemStack(Evercraft_Items.electrumingot, 2), new int[] {1, 1}, 300, 4);
    	}
    	//
    	for (int i = 0; i < dict.copperDust.size(); i ++) {
    		for (int j = 0; j < dict.zincDust.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.zincDust.get(j).getItem(), 1, dict.zincDust.get(j).getItemDamage()), new ItemStack(dict.copperDust.get(i).getItem(), 1, dict.copperDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.brassingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperDust.size(); i ++) {
    		for (int j = 0; j < dict.zincIngot.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.zincIngot.get(j).getItem(), 1, dict.zincIngot.get(j).getItemDamage()), new ItemStack(dict.copperDust.get(i).getItem(), 1, dict.copperDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.brassingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperIngot.size(); i ++) {
    		for (int j = 0; j < dict.zincDust.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.zincDust.get(j).getItem(), 1, dict.zincDust.get(j).getItemDamage()), new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.brassingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperIngot.size(); i ++) {
    		for (int j = 0; j < dict.zincIngot.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.zincIngot.get(j).getItem(), 1, dict.zincIngot.get(j).getItemDamage()), new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.brassingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	//
    	for (int i = 0; i < dict.copperDust.size(); i ++) {
    		for (int j = 0; j < dict.tinDust.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.tinDust.get(j).getItem(), 1, dict.tinDust.get(j).getItemDamage()), new ItemStack(dict.copperDust.get(i).getItem(), 1, dict.copperDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.bronzeingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperDust.size(); i ++) {
    		for (int j = 0; j < dict.tinIngot.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.tinIngot.get(j).getItem(), 1, dict.tinIngot.get(j).getItemDamage()), new ItemStack(dict.copperDust.get(i).getItem(), 1, dict.copperDust.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.bronzeingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperIngot.size(); i ++) {
    		for (int j = 0; j < dict.tinDust.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.tinDust.get(j).getItem(), 1, dict.tinDust.get(j).getItemDamage()), new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.bronzeingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	for (int i = 0; i < dict.copperIngot.size(); i ++) {
    		for (int j = 0; j < dict.tinIngot.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.tinIngot.get(j).getItem(), 1, dict.tinIngot.get(j).getItemDamage()), new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage())}, new ItemStack(Evercraft_Items.bronzeingot, 4), new int[] {1, 3}, 200, 2);
    		}
    	}
    	//
    	for (int i = 0; i < dict.ironDust.size(); i++) {
    		for (int j = 0; j < dict.lapisDust.size(); j++) {
    			this.addRecipe(new ItemStack[] {new ItemStack(dict.ironDust.get(i).getItem(), 1, dict.ironDust.get(i).getItemDamage()), new ItemStack(dict.lapisDust.get(j).getItem(), 1, dict.lapisDust.get(j).getItemDamage())}, new ItemStack(Evercraft_Items.hardenedlapisingot, 5), new int[] {3, 2}, 600, 4);
    		}
    	}
    	for (int j = 0; j < dict.lapisDust.size(); j++) {
    		this.addRecipe(new ItemStack[] {new ItemStack(Items.iron_ingot), new ItemStack(dict.lapisDust.get(j).getItem(), 1, dict.lapisDust.get(j).getItemDamage())}, new ItemStack(Evercraft_Items.hardenedlapisingot, 5), new int[] {3, 2}, 600, 4);
    	}
    	for (int i = 0; i < dict.ironDust.size(); i++) {
    		this.addRecipe(new ItemStack[] {new ItemStack(dict.ironDust.get(i).getItem(), 1, dict.ironDust.get(i).getItemDamage()), new ItemStack(Items.dye, 1, 4)}, new ItemStack(Evercraft_Items.hardenedlapisingot, 5), new int[] {3, 2}, 600, 4);
    	}
    	this.addRecipe(new ItemStack[] {new ItemStack(Items.iron_ingot), new ItemStack(Items.dye, 1, 4)}, new ItemStack(Evercraft_Items.hardenedlapisingot, 5), new int[] {3, 2}, 600, 4);
    	//
    	for (int i = 0; i < dict.ironDust.size(); i++) {
    		this.addRecipe(new ItemStack[] {new ItemStack(dict.ironDust.get(i).getItem(), 1, dict.ironDust.get(i).getItemDamage()), new ItemStack(Items.redstone)}, new ItemStack(Evercraft_Items.hardenedredstoneingot, 5), new int[] {3, 2}, 600, 4);
    	}
    	this.addRecipe(new ItemStack[] {new ItemStack(Items.iron_ingot), new ItemStack(Items.redstone)}, new ItemStack(Evercraft_Items.hardenedredstoneingot, 5), new int[] {3, 2}, 600, 4);
    	//
    	for (int i = 0; i < dict.lapisDust.size(); i++) {
    		this.addRecipe(new ItemStack[] {new ItemStack(dict.lapisDust.get(i).getItem(), 1, dict.lapisDust.get(i).getItemDamage()), new ItemStack(Items.redstone)}, new ItemStack(Evercraft_Items.redstoniteingot, 2), new int[] {1, 1}, 1200, 2);
    	}
    	this.addRecipe(new ItemStack[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.redstone)}, new ItemStack(Evercraft_Items.redstoniteingot, 2), new int[] {1, 1}, 1200, 2);
    	//
    	this.addRecipe(new ItemStack[] {new ItemStack(Blocks.lapis_block), new ItemStack(Blocks.redstone_block)}, new ItemStack(Evercraft_Blocks.blockredstoniteblock, 2), new int[] {1, 1}, 5400, 4);
    	//
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.sugar)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 1), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Blocks.soul_sand)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 2), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.gold_ingot)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 3), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.iron_ingot)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 4), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.blaze_powder)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 5), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.speckled_melon)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 6), new int[] {1, 64},  72000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Blocks.tnt)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 7), new int[] {1, 64},  72000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.ender_eye)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 8), new int[] {1, 48},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.gunpowder)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 9), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.ghast_tear)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 10), new int[] {1, 32},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Blocks.obsidian)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 11), new int[] {1, 48},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.magma_cream)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 12), new int[] {1, 48},  24000, 8);
    	for (int i = 0; i < 4; i++) {
    		this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.fish, 1, i)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 13), new int[] {1, 64},  24000, 8);
    	}
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.diamond)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 14), new int[] {1, 48},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.fermented_spider_eye)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 15), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.golden_carrot)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 16), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.rotten_flesh)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 17), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.bone)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 18), new int[] {1, 64}, 24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.spider_eye)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 19), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.skull, 1, 1)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 20), new int[] {1, 3},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.golden_apple, 1, 1)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 21), new int[] {1, 6},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.golden_apple, 1, 0)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 22), new int[] {1, 48},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.cooked_beef)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 23), new int[] {1, 64},  24000, 8);
    	this.addRecipe(new ItemStack[] {new ItemStack(Evercraft_Items.potionmatrix, 1, 0), new ItemStack(Items.cooked_porkchop)}, new ItemStack(Evercraft_Items.potionmatrix, 1, 23), new int[] {1, 64},  24000, 8);
    	
    }

    public void addRecipe(ItemStack[] inputArray, ItemStack output, int[] inputAmounts, int processSpeed, int powerConsumption)
    {
        this.smeltingList.put(inputArray, output);
        this.smeltingList.put(new ItemStack[] {inputArray[1], inputArray[0]}, output);
        this.inputAmountList.put(inputArray, inputAmounts);
        this.inputAmountList.put(new ItemStack[] {inputArray[1], inputArray[0]}, new int[] {inputAmounts[1], inputAmounts[0]});
        this.powerConsumpList.put(inputArray, powerConsumption);
        this.powerConsumpList.put(new ItemStack[] {inputArray[1], inputArray[0]}, powerConsumption);
        this.processSpeedList.put(inputArray, processSpeed);
        this.processSpeedList.put(new ItemStack[] {inputArray[1], inputArray[0]}, processSpeed);
    }

    public int[] AlloyFurnaceRecipesInputAmount(ItemStack[] p_151395_1_)
    {
        Iterator iterator = this.inputAmountList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return new int[] {1, 1};
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack[])entry.getKey()));

        return (int[])entry.getValue();
    }

    public int AlloyFurnaceRecipesProcessSpeed(ItemStack[] p_151395_1_)
    {
        Iterator iterator = this.processSpeedList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 200;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack[])entry.getKey()));

        return (Integer)entry.getValue();
    }

    public int AlloyFurnaceRecipesPowerConsumption(ItemStack[] p_151395_1_)
    {
        Iterator iterator = this.powerConsumpList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 4;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack[])entry.getKey()));

        return (Integer)entry.getValue();
    }
    
    public ItemStack getSmeltingResult(ItemStack[] p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack[])entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack[] p_151397_1_, ItemStack[] p_151397_2_)
    {
        return (p_151397_2_[0].getItem() == p_151397_1_[0].getItem() && (p_151397_2_[0].getItemDamage() == 32767 || p_151397_2_[0].getItemDamage() == p_151397_1_[0].getItemDamage()) && p_151397_2_[1].getItem() == p_151397_1_[1].getItem() && (p_151397_2_[1].getItemDamage() == 32767 || p_151397_2_[1].getItemDamage() == p_151397_1_[1].getItemDamage()));
    }


    public ItemStack hasSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_b(p_151395_1_, (ItemStack[])entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    private boolean func_151397_b(ItemStack p_151397_1_, ItemStack[] p_151397_2_)
    {
        return (p_151397_2_[0].getItem() == p_151397_1_.getItem() && (p_151397_2_[0].getItemDamage() == 32767 || p_151397_2_[0].getItemDamage() == p_151397_1_.getItemDamage()) || p_151397_2_[1].getItem() == p_151397_1_.getItem() && (p_151397_2_[1].getItemDamage() == 32767 || p_151397_2_[1].getItemDamage() == p_151397_1_.getItemDamage()));
    }
    
    public Map getSmeltingList()
    {
        return this.smeltingList;
    }
}