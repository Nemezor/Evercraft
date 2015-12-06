package evercraft.NEMESIS13cz.TileEntity.misc;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import evercraft.NEMESIS13cz.MachineRecipes.FurnitureCrafterRecipes;

public class FurnitureCrafterRecipeSorter implements Comparator
{
final FurnitureCrafterRecipes furnitureCraftingManager;

public FurnitureCrafterRecipeSorter(FurnitureCrafterRecipes par1FurnitureCraftingManager)
{
         this.furnitureCraftingManager = par1FurnitureCraftingManager;
}

public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
{
         return par1IRecipe instanceof FurnitureCrafterShapelessRecipes && par2IRecipe instanceof FurnitureCrafterShapedRecipes ? 1 : (par2IRecipe instanceof FurnitureCrafterShapelessRecipes && par1IRecipe instanceof FurnitureCrafterShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
}

public int compare(Object par1Obj, Object par2Obj)
{
         return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
}
}