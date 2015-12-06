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

public class CrusherRecipes
{
    private static final CrusherRecipes smeltingBase = new CrusherRecipes();
    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CrusherRecipes crushing()
    {
        return smeltingBase;
    }
    
    private DictionaryExtractor dict;

    private CrusherRecipes() {    	
    	
    if (dict.tinOre != null) {
    	for (int i = 0; i < dict.tinOre.size(); i++) {
    		this.addRecipe(new ItemStack(dict.tinOre.get(i).getItem(), 1, dict.tinOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.tindust,2), 0.6F);
    	}
	}
	if (dict.copperOre != null) {
    	for (int i = 0; i < dict.copperOre.size(); i++) {
        this.addRecipe(new ItemStack(dict.copperOre.get(i).getItem(), 1, dict.copperOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.copperdust,2), 0.4F);
    	}
	}
	if (dict.silverOre != null) {
    	for (int i = 0; i < dict.silverOre.size(); i++) {
        this.addRecipe(new ItemStack(dict.silverOre.get(i).getItem(), 1, dict.silverOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.silverdust,2), 1.2F);
    	}
	}
	if (dict.copperIngot != null) {
    	for (int i = 0; i < dict.copperIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.copperIngot.get(i).getItem(), 1, dict.copperIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.copperdust), 0.0F);
    	}
	}
	if (dict.silverIngot != null) {
    	for (int i = 0; i < dict.silverIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.silverIngot.get(i).getItem(), 1, dict.silverIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.silverdust), 0.0F);
    	}
	}
	if (dict.tinIngot != null) {
    	for (int i = 0; i < dict.tinIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.tinIngot.get(i).getItem(), 1, dict.tinIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.tindust), 0.0F);
    	}
	}
	if (dict.aluminiumIngot != null) {
    	for (int i = 0; i < dict.aluminiumIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.aluminiumIngot.get(i).getItem(), 1, dict.aluminiumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.aluminiumdust), 0.0F);
    	}
	}
	if (dict.zincOre != null) {
    	for (int i = 0; i < dict.zincOre.size(); i++) {
        this.addRecipe(new ItemStack(dict.zincOre.get(i).getItem(), 1, dict.zincOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.zincdust, 2), 0.0F);
    	}
	}
	if (dict.zincIngot != null) {
    	for (int i = 0; i < dict.zincIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.zincIngot.get(i).getItem(), 1, dict.zincIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.zincdust), 0.0F);
    	}
	}
	if (dict.bauxiteOre != null) {
    	for (int i = 0; i < dict.bauxiteOre.size(); i++) {
        this.addRecipe(new ItemStack(dict.bauxiteOre.get(i).getItem(), 1, dict.bauxiteOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.bauxitedust,2), 0.0F);
    	}
	}
	if (dict.titaniumIngot != null) {
    	for (int i = 0; i < dict.titaniumIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.titaniumIngot.get(i).getItem(), 1, dict.titaniumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.titaniumdust), 0.0F);
    	}
	}
	if (dict.bronzeIngot != null) {
    	for (int i = 0; i < dict.bronzeIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.bronzeIngot.get(i).getItem(), 1, dict.bronzeIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.bronzedust), 0.0F);
    	}
	}
	if (dict.electrumIngot != null) {
    	for (int i = 0; i < dict.electrumIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.electrumIngot.get(i).getItem(), 1, dict.electrumIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.electrumdust,1), 0.0F);
    	}
	}
	if (dict.brassIngot != null) {
    	for (int i = 0; i < dict.brassIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.brassIngot.get(i).getItem(), 1, dict.brassIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.brassdust,1), 0.0F);
    	}
	}
	if (dict.leadOre != null) {
    	for (int i = 0; i < dict.leadOre.size(); i++) {
        this.addRecipe(new ItemStack(dict.leadOre.get(i).getItem(), 1, dict.leadOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.leaddust,2), 0.0F);
    	}
	}
	if (dict.leadIngot != null) {
    	for (int i = 0; i < dict.leadIngot.size(); i++) {
        this.addRecipe(new ItemStack(dict.leadIngot.get(i).getItem(), 1, dict.leadIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.leaddust,1), 0.0F);
    	}
	}
	if (dict.aluminiumOre != null) {
    	for (int i = 0; i < dict.aluminiumOre.size(); i++) {
            this.addRecipe(new ItemStack(dict.aluminiumOre.get(i).getItem(), 1, dict.aluminiumOre.get(i).getItemDamage()), new ItemStack(Evercraft_Items.aluminiumdust,2), 0.3F);
    	}
	}
	if (dict.hardenedIronIngot != null) {
    	for (int i = 0; i < dict.hardenedIronIngot.size(); i++) {
            this.addRecipe(new ItemStack(dict.hardenedIronIngot.get(i).getItem(), 1, dict.hardenedIronIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.hardenedirondust,1), 0.0F);
    	}
	}
	if (dict.hardenedLapisIngot != null) {
    	for (int i = 0; i < dict.hardenedLapisIngot.size(); i++) {
            this.addRecipe(new ItemStack(dict.hardenedLapisIngot.get(i).getItem(), 1, dict.hardenedLapisIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.hardenedlapisdust,1), 0.0F);
    	}
	}
	if (dict.hardenedRedstoneIngot != null) {
    	for (int i = 0; i < dict.hardenedRedstoneIngot.size(); i++) {
            this.addRecipe(new ItemStack(dict.hardenedRedstoneIngot.get(i).getItem(), 1, dict.hardenedRedstoneIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.hardenedredstonedust,1), 0.0F);
    	}
	}
	if (dict.steelIngot != null) {
    	for (int i = 0; i < dict.steelIngot.size(); i++) {
            this.addRecipe(new ItemStack(dict.steelIngot.get(i).getItem(), 1, dict.steelIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.steeldust,1), 0.0F);
    	}
	}
	for (int i = 0; i < dict.nickelIngot.size(); i++) {
		this.addRecipe(new ItemStack(dict.nickelIngot.get(i).getItem(), 1, dict.nickelIngot.get(i).getItemDamage()), new ItemStack(Evercraft_Items.nickelDust, 1), 0.0F);
	}
    	
        this.addRecipe(Evercraft_Items.redstoniteingot, new ItemStack(Evercraft_Items.redstonitedust,1, 0), 0.0F);
        this.addRecipe(Blocks.coal_ore, new ItemStack(Items.coal,2, 0), 0.3F);
        this.addRecipe(Blocks.gold_ore, new ItemStack(Evercraft_Items.golddust,2, 0), 0.8F);
        this.addRecipe(Blocks.iron_ore, new ItemStack(Evercraft_Items.irondust,2, 0), 0.5F);
        this.addRecipe(Blocks.lapis_ore, new ItemStack(Items.dye,10,4), 0.8F);
        this.addRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone,8, 0), 0.4F);
        this.addRecipe(new ItemStack(Items.coal, 1, 0), new ItemStack(Evercraft_Items.coaldust, 1, 0), 0.0F);
        this.addRecipe(new ItemStack(Items.dye, 1, 4), new ItemStack(Evercraft_Items.lapislazulidust, 1, 0), 0.0F);
        this.addRecipe(Items.iron_ingot, new ItemStack(Evercraft_Items.irondust, 1, 0), 0.0F);
        this.addRecipe(Items.gold_ingot, new ItemStack(Evercraft_Items.golddust, 1, 0), 0.0F);
        this.addRecipe(Items.bone, new ItemStack(Items.dye,5,15), 0.025F);
        this.addRecipe(Items.blaze_rod, new ItemStack(Items.blaze_powder,3, 0), 0.1F);
        this.addRecipe(Blocks.stone, new ItemStack(Blocks.cobblestone,1, 0), 0.0F);
        this.addRecipe(Blocks.cobblestone, new ItemStack(Evercraft_Items.stonedust, 2), 0.0F);
        this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Blocks.sand,1, 0), 0.0F);
        this.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), new ItemStack(Blocks.cobblestone, 1, 0), 0.0F);
        this.addRecipe(Blocks.clay, new ItemStack(Items.clay_ball, 4, 0), 0.0F);
        this.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.cobblestone_wall), 1, 0), new ItemStack(Blocks.cobblestone,1, 0), 0.0F);
        this.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.cobblestone_wall), 1, 1), new ItemStack(Blocks.mossy_cobblestone,1, 0), 0.0F);
        this.addRecipe(Evercraft_Blocks.blockpowersand, new ItemStack(Evercraft_Items.redstonepowder,2, 0), 0.0F);
        this.addRecipe(Items.slime_ball, new ItemStack(Evercraft_Items.stickydust,2, 0), 0.0F);
        this.addRecipe(Evercraft_Blocks.blockclaydirt, new ItemStack(Items.clay_ball,3, 0), 0.0F);
        this.addRecipe(Blocks.sandstone, new ItemStack(Blocks.sand, 1), 0.0F);
        this.addRecipe(Blocks.sand, new ItemStack(Evercraft_Items.sanddust, 1, 0), 0.0F);
        this.addRecipe(new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 0), new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 1), 0.0F);
        this.addRecipe(new ItemStack(Evercraft_Blocks.blockwhitestone, 1, 1), new ItemStack(Evercraft_Items.whitestonedust, 2), 0.0F);

    	
    	//MOD COMPAT RECIPES
    	
    	
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