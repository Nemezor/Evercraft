package evercraft.NEMESIS13cz.Tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;



public final class ECTooltab extends CreativeTabs
{
public ECTooltab(int par1, String par2Str)
{
super(par1, par2Str);
}


@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
	return Evercraft_Items.steelmultitool;
}
}