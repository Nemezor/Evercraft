package evercraft.NEMESIS13cz.MachineRecipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import evercraft.NEMESIS13cz.Main.DictionaryExtractor;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.misc.MixingTableShapedRecipes;
import evercraft.NEMESIS13cz.TileEntity.misc.MixingTableShapelessRecipes;

public class MixingTableRecipes
{
    /**
     * The static instance of this class
     */
    private static final MixingTableRecipes instance = new MixingTableRecipes();
    /**
     * A list of all the recipes added
     */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final MixingTableRecipes getInstance()
    {
        /**
         * The static instance of this class
         */
        return instance;
    }
    
    private static DictionaryExtractor dict;

    private MixingTableRecipes()
    {
    	for (int ID1 = 0; ID1 < dict.silverDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.goldDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.electrumdust, 1), new Object[] {new ItemStack(dict.silverDust.get(ID1).getItem(), 1, dict.silverDust.get(ID1).getItemDamage()), new ItemStack(dict.goldDust.get(ID2).getItem(), 1, dict.goldDust.get(ID2).getItemDamage())});
    		}
    	}
    	for (int ID1 = 0; ID1 < dict.coalDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.ironDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.steeldust, 1), new Object[] {new ItemStack(dict.coalDust.get(ID1).getItem(), 1, dict.coalDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage())});
    		}
    	}
    	for (int ID1 = 0; ID1 < dict.diamondDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.obsidianIngot.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.obsidiumingot, 1), new Object[] {new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.obsidianIngot.get(ID2).getItem(), 1, dict.obsidianIngot.get(ID2).getItemDamage())});
    		}
    	}
    	this.addShapelessRecipe(new ItemStack(Evercraft_Items.enrichedredstone, 2), new Object[] {Items.glowstone_dust, Items.redstone});

    	for (int ID1 = 0; ID1 < dict.zincDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.copperDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.brassdust, 2), new Object[] {new ItemStack(dict.zincDust.get(ID1).getItem(), 1, dict.zincDust.get(ID1).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage())});
    		}
    	}

    	for (int ID1 = 0; ID1 < dict.tinDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.copperDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.bronzedust, 2), new Object[] {new ItemStack(dict.tinDust.get(ID1).getItem(), 1, dict.tinDust.get(ID1).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage()), new ItemStack(dict.copperDust.get(ID2).getItem(), 1, dict.copperDust.get(ID2).getItemDamage())});
    		}
    	}
    	
    	for (int ID1 = 0; ID1 < dict.ironDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.aluminiumDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedirondust, 8), new Object[] {new ItemStack(dict.ironDust.get(ID1).getItem(), 1, dict.ironDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID1).getItem(), 1, dict.ironDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID1).getItem(), 1, dict.ironDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID1).getItem(), 1, dict.ironDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID1).getItem(), 1, dict.ironDust.get(ID1).getItemDamage()), new ItemStack(dict.aluminiumDust.get(ID2).getItem(), 1, dict.aluminiumDust.get(ID2).getItemDamage()), new ItemStack(dict.aluminiumDust.get(ID2).getItem(), 1, dict.aluminiumDust.get(ID2).getItemDamage()), Items.glowstone_dust});
    		}
    	}
    	
		for (int ID1 = 0; ID1 < dict.diamondDust.size(); ID1++) {
			this.addShapelessRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 3), new Object[] {new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(Evercraft_Items.enrichedredstone), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage())});
		}

		for (int ID2 = 0; ID2 < dict.ironDust.size(); ID2++) {
			this.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedredstonedust, 2), new Object[] {Items.redstone, Items.redstone, new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage())});
		}
    	
    	for (int ID1 = 0; ID1 < dict.lapisDust.size(); ID1++) {
    		for (int ID2 = 0; ID2 < dict.ironDust.size(); ID2++) {
    			this.addShapelessRecipe(new ItemStack(Evercraft_Items.hardenedlapisdust, 2), new Object[] {new ItemStack(dict.lapisDust.get(ID1).getItem(), 1, dict.lapisDust.get(ID1).getItemDamage()), new ItemStack(dict.lapisDust.get(ID1).getItem(), 1, dict.lapisDust.get(ID1).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage()), new ItemStack(dict.ironDust.get(ID2).getItem(), 1, dict.ironDust.get(ID2).getItemDamage())});
    		}
    	}
    	
		for (int ID1 = 0; ID1 < dict.diamondDust.size(); ID1++) {
			this.addShapelessRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 0), new Object[] {new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(Evercraft_Items.lapislazulidust), new ItemStack(Evercraft_Items.lapislazulidust), new ItemStack(Evercraft_Items.lapislazulidust), new ItemStack(Evercraft_Items.lapislazulidust), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage())});
		}
    	
		for (int ID1 = 0; ID1 < dict.diamondDust.size(); ID1++) {
			this.addShapelessRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 1), new Object[] {new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(Evercraft_Items.emeralddust), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage())});
		}
    	
		for (int ID1 = 0; ID1 < dict.diamondDust.size(); ID1++) {
			this.addShapelessRecipe(new ItemStack(Evercraft_Items.energizeddiamonddust, 1, 2), new Object[] {new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(Evercraft_Items.hardenedredstonedust), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage()), new ItemStack(dict.diamondDust.get(ID1).getItem(), 1, dict.diamondDust.get(ID1).getItemDamage())});
		}
		
		for (int ID1 = 0; ID1 < dict.nickelDust.size(); ID1++) {
			for (int ID2 = 0; ID2 < dict.titaniumDust.size(); ID2++) {
				for (int ID3 = 0; ID3 < dict.aluminiumDust.size(); ID3++) {
					for (int ID4 = 0; ID4 < dict.chromeDust.size(); ID4++) {
						for (int ID5 = 0; ID5 < dict.cobaltDust.size(); ID5++) {
							this.addShapelessRecipe(new ItemStack(Evercraft_Items.superalloyDust, 11), new Object[] {new ItemStack(dict.nickelDust.get(ID1).getItem(), 1, dict.nickelDust.get(ID1).getItemDamage()), new ItemStack(dict.nickelDust.get(ID1).getItem(), 1, dict.nickelDust.get(ID1).getItemDamage()), new ItemStack(dict.nickelDust.get(ID1).getItem(), 1, dict.nickelDust.get(ID1).getItemDamage()), new ItemStack(dict.nickelDust.get(ID1).getItem(), 1, dict.nickelDust.get(ID1).getItemDamage()), new ItemStack(dict.nickelDust.get(ID1).getItem(), 1, dict.nickelDust.get(ID1).getItemDamage()), new ItemStack(dict.titaniumDust.get(ID2).getItem(), 1, dict.titaniumDust.get(ID2).getItemDamage()), new ItemStack(dict.aluminiumDust.get(ID3).getItem(), 1, dict.aluminiumDust.get(ID3).getItemDamage()), new ItemStack(dict.chromeDust.get(ID4).getItem(), 1, dict.chromeDust.get(ID4).getItemDamage()), new ItemStack(dict.chromeDust.get(ID4).getItem(), 1, dict.chromeDust.get(ID4).getItemDamage()), new ItemStack(dict.cobaltDust.get(ID5).getItem(), 1, dict.cobaltDust.get(ID5).getItemDamage()), new ItemStack(dict.cobaltDust.get(ID5).getItem(), 1, dict.cobaltDust.get(ID5).getItemDamage())});
						}
					}
				}
			}
		}
    	
        Collections.sort(this.recipes, new Comparator()
        {
            public int compare(IRecipe par1IRecipe, IRecipe par2IRecipe)
            {
                return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
            }
            public int compare(Object par1Obj, Object par2Obj)
            {
                return this.compare((IRecipe)par1Obj, (IRecipe)par2Obj);
            }
        });
    }

    public MixingTableShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        MixingTableShapedRecipes shapedrecipes = new MixingTableShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new MixingTableShapelessRecipes(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}