package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MetaInterface;

public class HammeringMachineRecipes
{
    private static final HammeringMachineRecipes smeltingBase = new HammeringMachineRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map processTime = new HashMap();
    
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static HammeringMachineRecipes hammering()
    {
        return smeltingBase;
    }
    
    private MetaInterface plates;
    private DictionaryExtractor dict;

    private HammeringMachineRecipes()
    {
		if (dict.copperIngot != null) {
			for (int i = 0; i < dict.copperIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateCopper), 0.0F, 120);
    		}
		}

		if (dict.tinIngot != null) {
			for (int i = 0; i < dict.tinIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.tinIngot.get(i).getItem(), 1, dict.tinIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateTin), 0.0F, 200);
    		}
		}

		if (dict.titaniumIngot != null) {
			for (int i = 0; i < dict.titaniumIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.titaniumIngot.get(i).getItem(), 1, dict.titaniumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateTitanium), 0.0F, 600);
    		}
		}

		if (dict.steelIngot != null) {
			for (int i = 0; i < dict.steelIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.steelIngot.get(i).getItem(), 1, dict.steelIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateSteel), 0.0F, 960);
    		}
		}

		if (dict.zincIngot != null) {
			for (int i = 0; i < dict.zincIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.zincIngot.get(i).getItem(), 1, dict.zincIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateZinc), 0.0F, 180);
    		}
		}

		if (dict.silverIngot != null) {
			for (int i = 0; i < dict.silverIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.silverIngot.get(i).getItem(), 1, dict.silverIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateSilver), 0.0F, 140);
    		}
		}

		if (dict.hardenedIronIngot != null) {
			for (int i = 0; i < dict.hardenedIronIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.hardenedIronIngot.get(i).getItem(), 1, dict.hardenedIronIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateHardenedIron), 0.0F, 720);
    		}
		}

		if (dict.hardenedLapisIngot != null) {
			for (int i = 0; i < dict.hardenedLapisIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.hardenedLapisIngot.get(i).getItem(), 1, dict.hardenedLapisIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateHardenedLapis), 0.0F, 640);
    		}
		}

		if (dict.hardenedRedstoneIngot != null) {
			for (int i = 0; i < dict.hardenedRedstoneIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.hardenedRedstoneIngot.get(i).getItem(), 1, dict.hardenedRedstoneIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateHardenedRedstone), 0.0F, 600);
    		}
		}

		if (dict.electrumIngot != null) {
			for (int i = 0; i < dict.electrumIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.electrumIngot.get(i).getItem(), 1, dict.electrumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateElectrum), 0.0F, 500);
    		}
		}

		if (dict.brassIngot != null) {
			for (int i = 0; i < dict.brassIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.brassIngot.get(i).getItem(), 1, dict.brassIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateBrass), 0.0F, 260);
    		}
		}

		if (dict.bronzeIngot != null) {
			for (int i = 0; i < dict.bronzeIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.bronzeIngot.get(i).getItem(), 1, dict.bronzeIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateBronze), 0.0F, 300);
    		}
		}

		if (dict.aluminiumIngot != null) {
			for (int i = 0; i < dict.aluminiumIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.aluminiumIngot.get(i).getItem(), 1, dict.aluminiumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateAluminium), 0.0F, 260);
    		}
		}

		if (dict.redstoniteIngot != null) {
			for (int i = 0; i < dict.redstoniteIngot.size(); i++) {
            	this.func_151394_a(new ItemStack(dict.redstoniteIngot.get(i).getItem(), 1, dict.redstoniteIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateRedstonite), 0.0F, 440);
    		}
		}
		for (int i = 0; i < dict.nickelIngot.size(); i++) {
        	this.func_151394_a(new ItemStack(dict.nickelIngot.get(i).getItem(), 1, dict.nickelIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.plate, 1, plates.plateNickel), 0.0F, 400);
		}
		
		this.func_151394_a(new ItemStack(Items.iron_ingot), new ItemStack(Evercraft_Items.plate, 1, plates.plateIron), 0.0F, 320);
		this.func_151394_a(new ItemStack(Items.gold_ingot), new ItemStack(Evercraft_Items.plate, 1, plates.plateGold), 0.0F, 200);
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

    public int HammeringRecipesProcessSpeed(ItemStack p_151395_1_)
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