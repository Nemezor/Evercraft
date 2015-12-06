package evercraft.NEMESIS13cz.Items.Upgrades;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemUpgradeRedstone extends Item {
public ItemUpgradeRedstone() {
setCreativeTab(ECTabs.tabECMisc);
this.setMaxStackSize(1);
}

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{	
    par3.add(EnumChatFormatting.DARK_GRAY + ">> " + EnumChatFormatting.DARK_RED + "Redstone Control" + EnumChatFormatting.DARK_GRAY + " <<");
    par3.add("");
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
    	par3.add("Applicable for: ");
    	par3.add(EnumChatFormatting.WHITE + "-Processing Machines");
    	par3.add(EnumChatFormatting.WHITE + "-Mining Machines");
    }else{
        par3.add(EnumChatFormatting.GOLD + "Hold Shift...");
    }
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.REDSTONE_UPGRADE);
}
}