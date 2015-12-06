package evercraft.NEMESIS13cz.Items.Misc;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;



public class ItemIronGrinder extends Item {
public ItemIronGrinder() {
setCreativeTab(ECTabs.tabECMisc); //Tells the game what creative mode tab it goes in
}



@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.IRON_GRINDER);
}
}