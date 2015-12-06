package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MetaInterface;

public class CuttingMachineRecipes
{
    private static final CuttingMachineRecipes smeltingBase = new CuttingMachineRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map processTime = new HashMap();
    
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CuttingMachineRecipes cutting()
    {
        return smeltingBase;
    }
    
    private MetaInterface plates;
    private DictionaryExtractor dict;

    private CuttingMachineRecipes()
    {
		if (dict.obsidianIngot != null) {
			for (int i = 0; i < dict.obsidianIngot.size(); i++) {
            	this.addRecipe_Itemstack(new ItemStack(dict.obsidianIngot.get(i).getItem(), 1, dict.obsidianIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 2, plates.plateObsidian), 0.0F, 900);
    		}
		}
		
        this.addRecipe_Itemstack(new ItemStack(Evercraft_Blocks.blockredstoniteblock), new ItemStack(Evercraft_Items.plate, 9, plates.plateRedstonite), 0.0F, 1200);
        this.addRecipe_Itemstack(new ItemStack(Blocks.diamond_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateDiamond), 0.0F, 6000);
		this.addRecipe_Itemstack(new ItemStack(Blocks.glowstone), new ItemStack(Evercraft_Items.plate, 4, plates.plateGlowstone), 0.0F, 60);
		this.addRecipe_Itemstack(new ItemStack(Blocks.iron_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateIron), 0.0F, 800);
		this.addRecipe_Itemstack(new ItemStack(Blocks.gold_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateGold), 0.0F, 400);
		this.addRecipe_Itemstack(new ItemStack(Blocks.emerald_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateEmerald), 0.0F, 4000);
		this.addRecipe_Itemstack(new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Evercraft_Items.plate, 4, plates.plateQuartz), 0.0F, 1800);
		this.addRecipe_Itemstack(new ItemStack(Blocks.lapis_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateLapis), 0.0F, 300);
		this.addRecipe_Itemstack(new ItemStack(Blocks.redstone_block), new ItemStack(Evercraft_Items.plate, 9, plates.plateRedstone), 0.0F, 400);
		for (int i = 0; i < 16; i++) {
			this.addRecipe_Itemstack(new ItemStack(Blocks.wool, 1, i), new ItemStack(Blocks.carpet, 8, i), 0.0F, 80);
		}
		for (int i = 0; i < 13; i++) {
			this.addRecipe_Itemstack(new ItemStack(Evercraft_Blocks.blockplatedblock, 1, i), new ItemStack(Evercraft_Blocks.blockPlatedCarpet, 8, i), 0.0F, 600);
		}
		
		String[] ores = OreDictionary.getOreNames();
		
		for (int i = 0; i < ores.length; i++) {
			if (ores[i].contains("log") && ores[i].replaceFirst("log", "").length() > 0) {
				String woodType = ores[i].replaceFirst("log", "");
				
				if (!woodType.equals("Wood")) {
					if (OreDictionary.getOres("plank" + woodType).size() > 0) {
						for (int j = 0; j < OreDictionary.getOres("log" + woodType).size(); j++) {
							for (int k = 0; k < OreDictionary.getOres("plank" + woodType).size(); k++) {
								this.addRecipe_Itemstack(new ItemStack(OreDictionary.getOres("log" + woodType).get(j).getItem(), 1, OreDictionary.getOres("log" + woodType).get(j).getItemDamage()), new ItemStack(OreDictionary.getOres("plank" + woodType).get(k).getItem(), 6, OreDictionary.getOres("plank" + woodType).get(k).getItemDamage()), 0.0F, 120);
							}
						}
					}
				}
			}
		}
    }
    
    public void addRecipe_Block(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_, int processSpeed)
    {
        this.addRecipe_Item(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_, processSpeed);
    }

    public void addRecipe_Item(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_, int processSpeed)
    {
        this.addRecipe_Itemstack(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_, processSpeed);
    }

    public void addRecipe_Itemstack(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_, int processSpeed)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
        this.processTime.put(p_151394_1_, processSpeed);
    }

    public int CuttingRecipesProcessSpeed(ItemStack p_151395_1_)
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