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
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class EnricherRecipes
{
    private static final EnricherRecipes smeltingBase = new EnricherRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map inputAmount = new HashMap();
    private Map	processSpeed = new HashMap();
    private Map outputPercentage = new HashMap();
    private Map secondOutput = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static EnricherRecipes enriching()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private EnricherRecipes() {
    	this.addRecipe(Blocks.iron_ore, new ItemStack(Evercraft_Items.irondust, 1), new ItemStack(Evercraft_Items.nickelPowder), 0.4F, 1, 400, 25);
    	for (int i = 0; i < dict.copperOre.size(); i++) {
        	this.addRecipe(new ItemStack(dict.copperOre.get(i).getItem(), 1, dict.copperOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.copperdust, 1), new ItemStack(Evercraft_Items.cobaltPowder, 1), 0.2F, 1, 300, 15);
    	}
    }

    public void addRecipe(Block p_151393_1_, ItemStack p_151393_2_, ItemStack secOut, float p_151393_3_, int inputAmount, int processSpeed, int percentageOfSecondOutput)
    {
        this.addRecipe(Item.getItemFromBlock(p_151393_1_), p_151393_2_, secOut, p_151393_3_, inputAmount, processSpeed, percentageOfSecondOutput);
    }

    public void addRecipe(Item p_151396_1_, ItemStack p_151396_2_, ItemStack secOut, float p_151396_3_, int inputAmount, int processSpeed, int percentageOfSecondOutput)
    {
        this.addRecipe(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, secOut, p_151396_3_, inputAmount, processSpeed, percentageOfSecondOutput);
    }

    public void addRecipe(ItemStack p_151394_1_, ItemStack p_151394_2_, ItemStack secOut, float p_151394_3_, int inputAmount, int processSpeed, int percentageOfSecondOutput)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.inputAmount.put(p_151394_1_, inputAmount);
        this.processSpeed.put(p_151394_1_, processSpeed);
        this.outputPercentage.put(p_151394_1_, percentageOfSecondOutput);
        this.secondOutput.put(p_151394_1_, secOut);
    }

    /**
     * Returns the smelting result of an item.
     */
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

    public ItemStack getSecondOutput(ItemStack p_151395_1_)
    {
        Iterator iterator = this.secondOutput.entrySet().iterator();
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

    public int getInputAmount(ItemStack p_151395_1_)
    {
        Iterator iterator = this.inputAmount.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 1;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
    }

    public int getProcessSpeed(ItemStack p_151395_1_)
    {
        Iterator iterator = this.processSpeed.entrySet().iterator();
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

    public int getPercentage(ItemStack p_151395_1_)
    {
        Iterator iterator = this.outputPercentage.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
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