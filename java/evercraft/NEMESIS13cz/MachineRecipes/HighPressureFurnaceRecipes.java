package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class HighPressureFurnaceRecipes
{
    private static final HighPressureFurnaceRecipes smeltingBase = new HighPressureFurnaceRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map processTime = new HashMap();
    private Map isAdvRecipe = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static HighPressureFurnaceRecipes smelting()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private HighPressureFurnaceRecipes()
    {
		if (dict.steelDust != null) {
			for (int i = 0; i < dict.steelDust.size(); i++) {
				this.addRecipe(new ItemStack(dict.steelDust.get(i).getItem(), 1, dict.steelDust.get(i).getItemDamage()), new ItemStack(Evercraft_Items.steelingot,1), 0.0F, 600, false);
			}
		}
		if (dict.obsidianDust != null) {
        	for (int i = 0; i < dict.obsidianDust.size(); i++) {
        		this.addRecipe(new ItemStack(dict.obsidianDust.get(i).getItem(), 1, dict.obsidianDust.get(i).getItemDamage()), new ItemStack(Evercraft_Items.obsidianingot,1), 0.0F, 1200, false);
        	}
		}
    	if (dict.titaniumDust != null) {
        	for (int i = 0; i < dict.titaniumDust.size(); i++) {
        		this.addRecipe(new ItemStack(dict.titaniumDust.get(i).getItem(), 1, dict.titaniumDust.get(i).getItemDamage()), new ItemStack(Evercraft_Items.titaniumingot,1), 0.0F, 1600, false);
        	}
    	}
    	if (dict.spheneDust != null) {
        	for (int i = 0; i < dict.spheneDust.size(); i++) {
        		this.addRecipe(new ItemStack(dict.spheneDust.get(i).getItem(), 1, dict.spheneDust.get(i).getItemDamage()), new ItemStack(Evercraft_Items.titaniumingot,1), 2.0F, 2000, false);
        	}
    	}
    	if (dict.aluminiumDust != null) {
        	for (int i = 0; i < dict.aluminiumDust.size(); i++) {
        		this.addRecipe(new ItemStack(dict.aluminiumDust.get(i).getItem(), 1, dict.aluminiumDust.get(i).getItemDamage()), new ItemStack(Evercraft_Items.aluminiumingot,1), 0.0F, 800, false);
        	}
    	}
    	
    	this.addRecipe(Blocks.iron_ore, new ItemStack(Evercraft_Items.chromiumPowder, 1, 0), 2.0F, 1200, false);
        this.addRecipe(Evercraft_Items.sphenelump, new ItemStack(Evercraft_Items.titaniumingot,1), 2.0F, 2000, false);
        this.addRecipe(Blocks.obsidian, new ItemStack(Evercraft_Items.obsidianingot,1), 0.0F, 1200, false);
        for (int i = 0; i < 2; i++) {
            this.addRecipe(new ItemStack(Blocks.sand, 1, i), new ItemStack(Evercraft_Items.siliconwafer, 4), 3.5F, 400, false);
        }
        this.addRecipe(Evercraft_Items.superalloyDust, new ItemStack(Evercraft_Items.superalloyIngot, 1), 0.0F, 1200, true);
    }

    public void addRecipe(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_, int processSpeed, boolean advanced)
    {
        this.addRecipe(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_, processSpeed, advanced);
    }

    public void addRecipe(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_, int processSpeed, boolean advanced)
    {
        this.addRecipe(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_, processSpeed, advanced);
    }

    public void addRecipe(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_, int processSpeed, boolean advanced)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.processTime.put(p_151394_1_, processSpeed);
        this.isAdvRecipe.put(p_151394_1_, advanced);
    }

    public int getHighTemperatureFurnaceRecipeSpeed(ItemStack p_151395_1_)
    {
        Iterator iterator = this.processTime.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 200;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
    }
    
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
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
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    public boolean isAdvanced(ItemStack p_151395_1_)
    {
        Iterator iterator = this.isAdvRecipe.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (Boolean)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}