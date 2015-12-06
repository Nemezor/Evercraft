package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;

public class ParticleMergerRecipes
{
    private static final ParticleMergerRecipes smeltingBase = new ParticleMergerRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map processTime = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static ParticleMergerRecipes compacting()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private ParticleMergerRecipes()
    {

    	for (int i = 0; i < dict.lapisDust.size(); i++) {
            this.func_151394_a(new ItemStack(dict.lapisDust.get(i).getItem(), 1, dict.lapisDust.get(i).getItemDamage()), new ItemStack(Items.dye,1,4), 0.0F, 600);
    	}
        	for (int i = 0; i < dict.emeraldDust.size(); i++) {
            this.func_151394_a(new ItemStack(dict.emeraldDust.get(i).getItem(), 1, dict.emeraldDust.get(i).getItemDamage()), new ItemStack(Items.emerald,1), 0.0F, 9000);
        }
        	for (int i = 0; i < dict.diamondDust.size(); i++) {
            this.func_151394_a(new ItemStack(dict.diamondDust.get(i).getItem(), 1, dict.diamondDust.get(i).getItemDamage()), new ItemStack(Items.diamond,1), 0.0F, 12000);
        }
        	for (int i = 0; i < dict.quartzDust.size(); i++) {
            this.func_151394_a(new ItemStack(dict.quartzDust.get(i).getItem(), 1, dict.quartzDust.get(i).getItemDamage()), new ItemStack(Items.quartz,1), 0.0F, 1800);
    	}

    }
    
    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_, int processSpeed)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_, processSpeed);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_, int processSpeed)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_, processSpeed);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_, int processSpeed)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.processTime.put(p_151394_1_, processSpeed);
    }
    
    public int getParticleMergerRecipeProcessSpeed(ItemStack p_151395_1_)
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