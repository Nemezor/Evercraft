package evercraft.NEMESIS13cz.Tabs; 

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;



public final class ECDecotab extends CreativeTabs
{
public ECDecotab(int par1, String par2Str)
{
super(par1, par2Str);
}

@SideOnly(Side.CLIENT)
public ItemStack getIconItemStack() {
	return new ItemStack(Item.getItemFromBlock(Evercraft_Blocks.blockcoloredbrickssmooth), 1, 12);
}


@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
	return null;
}
}