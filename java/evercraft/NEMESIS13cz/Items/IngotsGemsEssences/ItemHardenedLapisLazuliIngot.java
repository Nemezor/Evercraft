package evercraft.NEMESIS13cz.Items.IngotsGemsEssences;

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



public class ItemHardenedLapisLazuliIngot extends Item {
public ItemHardenedLapisLazuliIngot() {
setCreativeTab(ECTabs.tabECWGMaterials); //Tells the game what creative mode tab it goes in
}
public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
    par3.add(EnumChatFormatting.WHITE + "3/5" + EnumChatFormatting.GRAY + " Iron");
    par3.add(EnumChatFormatting.WHITE + "2/5" + EnumChatFormatting.BLUE + " Lapis Lazuli");
}



@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.HARDENED_LAPIS_INGOT);
}
}