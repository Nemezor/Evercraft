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

public class RepulsiveCrusherRecipes
{
    private static final RepulsiveCrusherRecipes smeltingBase = new RepulsiveCrusherRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static RepulsiveCrusherRecipes crushing()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private RepulsiveCrusherRecipes()
    {
			if (dict.tinOre != null) {
	        	for (int i = 0; i < dict.tinOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.tinOre.get(i).getItem(), 1, dict.tinOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.tinpowder,12), 0.0F);
	        	}
			}
	    	if (dict.copperOre != null) {
	           	for (int i = 0; i < dict.copperOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.copperOre.get(i).getItem(), 1, dict.copperOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.copperpowder,12), 0.0F);
	        	}
	    	}
	        if (dict.silverOre != null) {
	            for (int i = 0; i < dict.silverOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.silverOre.get(i).getItem(), 1, dict.silverOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.silverpowder,12), 0.0F);
	        	}
	        }
	        if (dict.bauxiteOre != null) {
	            for (int i = 0; i < dict.bauxiteOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.bauxiteOre.get(i).getItem(), 1, dict.bauxiteOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.bauxitepowder,12), 0.0F);
	        	}
	        }
	        if (dict.zincOre != null) {
	            for (int i = 0; i < dict.zincOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.zincOre.get(i).getItem(), 1, dict.zincOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.zincpowder, 12), 0.0F);
	        	}
	        }
	        if (dict.spheneOre != null) {
	            for (int i = 0; i < dict.spheneOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.spheneOre.get(i).getItem(), 1, dict.spheneOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.sphenelump, 8), 0.0F);
	        	}
	        }
	        if (dict.leadOre != null) {
	            for (int i = 0; i < dict.leadOre.size(); i++) {
	                this.addRecipe(new ItemStack(dict.leadOre.get(i).getItem(), 1, dict.leadOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.leadpowder, 12), 0.0F);
	        	}
	        }
            
            this.addRecipe(Blocks.coal_ore, new ItemStack(Evercraft_Items.coaldust,10), 0.0F);
            this.addRecipe(Blocks.gold_ore, new ItemStack(Evercraft_Items.goldpowder,12), 0.0F);
            this.addRecipe(Blocks.iron_ore, new ItemStack(Evercraft_Items.ironpowder,12), 0.0F);
            this.addRecipe(Blocks.lapis_ore, new ItemStack(Evercraft_Items.lapislazulidust,18), 0.0F);
            this.addRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone,22), 0.0F);
            this.addRecipe(Evercraft_Blocks.blockpowersand, new ItemStack(Evercraft_Items.redstonepowder,8), 0.0F);
            this.addRecipe(Items.slime_ball, new ItemStack(Evercraft_Items.stickydust,8), 0.0F);
            this.addRecipe(Blocks.obsidian, new ItemStack(Evercraft_Items.obsidiandust,6), 0.0F);
            this.addRecipe(Blocks.diamond_ore, new ItemStack(Evercraft_Items.diamonddust,4), 0.0F);
            this.addRecipe(Blocks.quartz_ore, new ItemStack(Evercraft_Items.quartzdust,14), 0.0F);
            this.addRecipe(Evercraft_Blocks.blockoverworldquartzore, new ItemStack(Evercraft_Items.quartzdust,14), 0.0F);
            this.addRecipe(Evercraft_Blocks.blockmagneticstone, new ItemStack(Evercraft_Items.magneticlump,8), 0.0F);
            this.addRecipe(Blocks.emerald_ore, new ItemStack(Evercraft_Items.emeralddust,4), 0.0F);
            this.addRecipe(Evercraft_Items.superalloyIngot, new ItemStack(Evercraft_Items.superalloyDust), 0.0F);
            
            
    }

    public void addRecipe(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.addRecipe(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void addRecipe(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.addRecipe(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void addRecipe(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
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