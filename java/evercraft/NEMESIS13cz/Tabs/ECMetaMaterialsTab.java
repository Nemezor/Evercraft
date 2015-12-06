package evercraft.NEMESIS13cz.Tabs; 

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;



public final class ECMetaMaterialsTab extends CreativeTabs
{
public ECMetaMaterialsTab(int par1, String par2Str)
{
super(par1, par2Str);
}

@SideOnly(Side.CLIENT)
public ItemStack getIconItemStack() {
	return new ItemStack(Evercraft_Items.potionmatrix, 1, 0);
}


@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
	return Evercraft_Items.stopsign;
}
}