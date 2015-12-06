package evercraft.NEMESIS13cz.Main;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;



// 1600 = coal
public class ECFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.isItemEqual(new ItemStack(Evercraft_Items.coaldust, 1, 0))) return 1600;
		if(fuel.isItemEqual(new ItemStack(Evercraft_Items.coalpowder, 1, 0))) return 400;
		if(fuel.isItemEqual(new ItemStack(Evercraft_Items.infernalcoal, 1, 0))) return 4000;
		return 0;
	}
}