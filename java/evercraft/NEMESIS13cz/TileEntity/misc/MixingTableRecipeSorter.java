package evercraft.NEMESIS13cz.TileEntity.misc;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import evercraft.NEMESIS13cz.MachineRecipes.MixingTableRecipes;

public class MixingTableRecipeSorter implements Comparator
{
final MixingTableRecipes mixingCraftingManager;

public MixingTableRecipeSorter(MixingTableRecipes par1FurnitureCraftingManager)
{
         this.mixingCraftingManager = par1FurnitureCraftingManager;
}

public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
{
         return par1IRecipe instanceof MixingTableShapelessRecipes && par2IRecipe instanceof MixingTableShapedRecipes ? 1 : (par2IRecipe instanceof MixingTableShapelessRecipes && par1IRecipe instanceof MixingTableShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
}

public int compare(Object par1Obj, Object par2Obj)
{
         return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
}
}