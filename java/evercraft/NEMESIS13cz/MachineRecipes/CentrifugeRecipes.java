package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.ArrayList;
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

public class CentrifugeRecipes
{
    private static final CentrifugeRecipes smeltingBase = new CentrifugeRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map inputAmountList = new HashMap();
    private Map processSpeedList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CentrifugeRecipes centrifuging()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private CentrifugeRecipes() {
    	this.func_151394_a(new ItemStack(Evercraft_Items.hardenedirondust), new ItemStack[] {new ItemStack(Evercraft_Items.aluminiumdust,2), new ItemStack(Evercraft_Items.irondust,5), new ItemStack(Items.glowstone_dust), null, null, null}, 0.0F, 8, 600);
    	this.func_151394_a(new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack[] {new ItemStack(Items.glowstone_dust), new ItemStack(Items.redstone), null, null, null, null}, 0.0F, 2, 300);
    	for (int i = 0; i < dict.brassDust.size(); i++) {
        	this.func_151394_a(new ItemStack(dict.brassDust.get(i).getItem(), 1, dict.brassDust.get(i).getItemDamage()), new ItemStack[] {new ItemStack(Evercraft_Items.zincdust,1), new ItemStack(Evercraft_Items.copperdust,3), null, null, null, null}, 0.0F, 4, 550);
    	}
    	for (int i = 0; i < dict.bronzeDust.size(); i++) {
        	this.func_151394_a(new ItemStack(dict.bronzeDust.get(i).getItem(), 1, dict.bronzeDust.get(i).getItemDamage()), new ItemStack[] {new ItemStack(Evercraft_Items.tindust,1), new ItemStack(Evercraft_Items.copperdust,3), null, null, null, null}, 0.0F, 4, 550);
    	}
    	for (int i = 0; i < dict.electrumDust.size(); i++) {
        	this.func_151394_a(new ItemStack(dict.electrumDust.get(i).getItem(), 1, dict.electrumDust.get(i).getItemDamage()), new ItemStack[] {new ItemStack(Evercraft_Items.silverdust), new ItemStack(Evercraft_Items.golddust), null, null, null, null}, 0.0F, 2, 500);
    	}
    	this.func_151394_a(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 0), new ItemStack[] {new ItemStack(Evercraft_Items.lapislazulidust,4), new ItemStack(Evercraft_Items.diamonddust,4), null, null, null, null}, 0.0F, 1, 2400);
    	this.func_151394_a(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 1), new ItemStack[] {new ItemStack(Evercraft_Items.emeralddust, 1), new ItemStack(Evercraft_Items.diamonddust,4), null, null, null, null}, 0.0F, 1, 2400);
    	this.func_151394_a(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 2), new ItemStack[] {new ItemStack(Evercraft_Items.irondust,24), new ItemStack(Items.redstone,16), new ItemStack(Evercraft_Items.diamonddust,20), null, null, null}, 0.0F, 5, 12000);
    	this.func_151394_a(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 3), new ItemStack[] {new ItemStack(Items.glowstone_dust,4), new ItemStack(Items.redstone,4), new ItemStack(Evercraft_Items.diamonddust,4), null, null, null}, 0.0F, 1, 2400);
    	for (int i = 0; i < dict.steelDust.size(); i++) {
    		this.func_151394_a(new ItemStack(dict.steelDust.get(i).getItem(), 1, dict.steelDust.get(i).getItemDamage()), new ItemStack[] {new ItemStack(Evercraft_Items.irondust), new ItemStack(Evercraft_Items.coaldust), null, null, null, null}, 0.0F, 1, 700);
    	}
    	this.func_151394_a(new ItemStack(Evercraft_Items.redstonitedust), new ItemStack[] {new ItemStack(Evercraft_Items.lapislazulidust), new ItemStack(Items.redstone), null, null, null, null}, 0.0F, 2, 400);
    	this.func_151394_a(new ItemStack(Evercraft_Items.hardenedlapisdust), new ItemStack[] {new ItemStack(Evercraft_Items.lapislazulidust, 2), new ItemStack(Evercraft_Items.irondust, 3), null, null, null, null}, 0.0F, 5, 600);
    	this.func_151394_a(new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack[] {new ItemStack(Items.redstone, 2), new ItemStack(Evercraft_Items.irondust, 3), null, null, null, null}, 0.0F, 5, 600);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 5), new ItemStack[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 1), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 6), new ItemStack[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 2), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 7), new ItemStack[] {new ItemStack(Items.dye, 2, 15), new ItemStack(Items.dye, 1, 0), null, null, null, null}, 0.0F, 3, 70);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 8), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 0), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 9), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 1), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 10), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 2), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 12), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 4), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 13), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 2, 1), null, null, null}, 0.0F, 4, 80);
    	this.func_151394_a(new ItemStack(Items.dye, 1, 14), new ItemStack[] {new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 1), null, null, null, null}, 0.0F, 2, 60);
    	this.func_151394_a(new ItemStack(Items.ender_eye), new ItemStack[] {new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.blaze_powder, 1), null, null, null, null}, 0.0F, 1, 140);
    	this.func_151394_a(new ItemStack(Items.golden_apple, 1, 0), new ItemStack[] {new ItemStack(Items.apple, 1), new ItemStack(Items.gold_ingot, 8), null, null, null, null}, 0.0F, 1, 200);
    	this.func_151394_a(new ItemStack(Items.golden_apple, 1, 1), new ItemStack[] {new ItemStack(Items.apple, 1), new ItemStack(Items.gold_ingot, 8), new ItemStack(Items.gold_ingot, 64), null, null, null}, 0.0F, 1, 800);
    	this.func_151394_a(new ItemStack(Items.magma_cream), new ItemStack[] {new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.slime_ball, 1), null, null, null, null}, 0.0F, 1, 180);
    	this.func_151394_a(new ItemStack(Items.golden_carrot), new ItemStack[] {new ItemStack(Items.carrot, 1), new ItemStack(Items.gold_nugget, 8), null, null, null, null}, 0.0F, 1, 180);
    	this.func_151394_a(new ItemStack(Items.speckled_melon), new ItemStack[] {new ItemStack(Items.melon, 1), new ItemStack(Items.gold_nugget, 8), null, null, null, null}, 0.0F, 1, 180);
    	this.func_151394_a(new ItemStack(Items.fermented_spider_eye), new ItemStack[] {new ItemStack(Items.sugar, 1), new ItemStack(Items.spider_eye, 1), new ItemStack(Blocks.brown_mushroom, 1), null, null, null}, 0.0F, 1, 200);
    	this.func_151394_a(new ItemStack(Blocks.yellow_flower, 1, 0), new ItemStack[] {new ItemStack(Items.dye, 2, 11), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 0), new ItemStack[] {new ItemStack(Items.dye, 2, 1), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 1), new ItemStack[] {new ItemStack(Items.dye, 2, 12), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 2), new ItemStack[] {new ItemStack(Items.dye, 2, 13), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 3), new ItemStack[] {new ItemStack(Items.dye, 2, 7), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 4), new ItemStack[] {new ItemStack(Items.dye, 2, 1), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 5), new ItemStack[] {new ItemStack(Items.dye, 2, 14), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 6), new ItemStack[] {new ItemStack(Items.dye, 2, 7), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 7), new ItemStack[] {new ItemStack(Items.dye, 2, 9), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.red_flower, 1, 8), new ItemStack[] {new ItemStack(Items.dye, 2, 7), null, null, null, null, null}, 0.0F, 1, 80);
    	this.func_151394_a(new ItemStack(Blocks.double_plant, 1, 0), new ItemStack[] {new ItemStack(Items.dye, 4, 11), null, null, null, null, null}, 0.0F, 1, 120);
    	this.func_151394_a(new ItemStack(Blocks.double_plant, 1, 1), new ItemStack[] {new ItemStack(Items.dye, 4, 13), null, null, null, null, null}, 0.0F, 1, 120);
    	this.func_151394_a(new ItemStack(Blocks.double_plant, 1, 4), new ItemStack[] {new ItemStack(Items.dye, 4, 1), null, null, null, null, null}, 0.0F, 1, 120);
    	this.func_151394_a(new ItemStack(Blocks.double_plant, 1, 5), new ItemStack[] {new ItemStack(Items.dye, 4, 9), null, null, null, null, null}, 0.0F, 1, 120);
    	for(int i = 0; i < 16; i++) {
        	this.func_151394_a(new ItemStack(Evercraft_Items.coloredslimeball, 1, i), new ItemStack[] {new ItemStack(Items.dye, 1, i), new ItemStack(Evercraft_Items.stickydust, 2), null, null, null, null}, 0.0F, 1, 300);
    	}
    	for (int i = 0; i < dict.whitestoneDust.size(); i++) {
    		this.func_151394_a(new ItemStack(dict.whitestoneDust.get(i).getItem(), 1, dict.whitestoneDust.get(i).getItemDamage()), new ItemStack[] {new ItemStack(Items.dye, 1, 15), new ItemStack(Evercraft_Items.stonedust, 1), null, null, null, null}, 0.0F, 2, 800);
    	}
    }
        
    public int CentrifugeRecipesInputAmount(ItemStack p_151395_1_)
    {
        Iterator iterator = this.inputAmountList.entrySet().iterator();
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

    public int CentrifugeRecipesProcessSpeed(ItemStack p_151395_1_)
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
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
    }
    
    public void func_151393_a(Block p_151393_1_, ItemStack[] p_151393_2_, float p_151393_3_, int inputAmount, int processSpeed)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_, inputAmount, processSpeed);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack[] p_151396_2_, float p_151396_3_, int inputAmount, int processSpeed)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_, inputAmount, processSpeed);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack[] p_151394_2_, float p_151394_3_, int inputAmount, int processSpeed)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.inputAmountList.put(p_151394_1_, inputAmount);
        this.processSpeedList.put(p_151394_1_, processSpeed);
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack[] getSmeltingResult(ItemStack p_151395_1_)
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

        return (ItemStack[])entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    private boolean func_151397_a2(ItemStack p_151397_1_, ItemStack[] p_151397_2_)
    {
        return p_151397_2_[0].getItem() == p_151397_1_.getItem() && (p_151397_2_[0].getItemDamage() == 32767 || p_151397_2_[0].getItemDamage() == p_151397_1_.getItemDamage());
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
        while (!this.func_151397_a2(p_151398_1_, (ItemStack[])entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}