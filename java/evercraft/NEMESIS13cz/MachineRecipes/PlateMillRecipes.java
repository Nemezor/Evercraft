package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MetaInterface;

public class PlateMillRecipes
{
    private static final PlateMillRecipes smeltingBase = new PlateMillRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map processTime = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static PlateMillRecipes plating()
    {
        return smeltingBase;
    }
    
    private MetaInterface meta;
    private DictionaryExtractor dict;

    private PlateMillRecipes()
    {
    	for (int i = 0; i < 12; i++) {
    		this.addRecipe(new ItemStack(Evercraft_Items.largeplatecluster, 1, i), new ItemStack(Evercraft_Items.largeplate, 1, i), 0.0F, 1800);
    		this.addRecipe(new ItemStack(Evercraft_Items.mediumplatecluster, 1, i), new ItemStack(Evercraft_Items.mediumplate, 1, i), 0.0F, 1200);
    		this.addRecipe(new ItemStack(Evercraft_Items.smallplatecluster, 1, i), new ItemStack(Evercraft_Items.smallplate, 1, i), 0.0F, 600);
    	}
        this.addRecipe(Evercraft_Items.obsidiumingot, new ItemStack(Evercraft_Items.obsidiumgem,1), 0.0F, 400);
        this.addRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 0), new ItemStack(Evercraft_Items.energizeddiamond, 1, 0), 0.0F, 7200);
        this.addRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 1), new ItemStack(Evercraft_Items.energizeddiamond, 1, 1), 0.0F, 8400);
        this.addRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 2), new ItemStack(Evercraft_Items.energizeddiamond, 1, 2), 0.0F, 9600);
        this.addRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 3), new ItemStack(Evercraft_Items.energizeddiamond, 1, 3), 0.0F, 10800);
        this.addRecipe(Evercraft_Items.superalloyIngot, new ItemStack(Evercraft_Items.plate, 1, meta.plateSuperalloy), 0.0F, 600);
    }

    public void addRecipe(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_, int processSpeed)
    {
        this.addRecipe(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_, processSpeed);
    }

    public void addRecipe(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_, int processSpeed)
    {
        this.addRecipe(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_, processSpeed);
    }

    public void addRecipe(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_, int processSpeed)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.processTime.put(p_151394_1_, processSpeed);
    }

    public int getPlateMillRecipeProcessSpeed(ItemStack p_151395_1_)
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