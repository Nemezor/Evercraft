package evercraft.NEMESIS13cz.Tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;



public final class ECMachinetab extends CreativeTabs
{
public ECMachinetab(int par1, String par2Str)
{
super(par1, par2Str);
}


@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
	return Item.getItemFromBlock(Evercraft_Blocks.blockadvancedcrusherOff);
}
}