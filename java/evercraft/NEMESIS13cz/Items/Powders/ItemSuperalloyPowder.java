package evercraft.NEMESIS13cz.Items.Powders;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;


public class ItemSuperalloyPowder extends Item {
public ItemSuperalloyPowder() {
setCreativeTab(ECTabs.tabECWGMaterials);
}
public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
    par3.add(EnumChatFormatting.WHITE + "5/11" + EnumChatFormatting.WHITE + " Nickel");
    par3.add(EnumChatFormatting.WHITE + "2/11" + EnumChatFormatting.RED + " Chromium");
    par3.add(EnumChatFormatting.WHITE + "2/11" + EnumChatFormatting.BLUE + " Cobalt");
    par3.add(EnumChatFormatting.WHITE + "1/11" + EnumChatFormatting.AQUA + " Aluminium");
    par3.add(EnumChatFormatting.WHITE + "1/11" + EnumChatFormatting.GRAY + " Titanium");
}



@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.SUPERALLOY_POWDER);
}
}