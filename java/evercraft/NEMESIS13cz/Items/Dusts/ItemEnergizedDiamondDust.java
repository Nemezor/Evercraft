package evercraft.NEMESIS13cz.Items.Dusts;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;



public class ItemEnergizedDiamondDust extends Item {
public ItemEnergizedDiamondDust() {
setCreativeTab(ECTabs.tabECWGMaterials);
this.setHasSubtypes(true);
this.setMaxDamage(0);
}

private static final String[] names = new String[] {"blue", "green", "red", "etheric"};

@SideOnly(Side.CLIENT)
private IIcon[] icons;

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
	int meta = par1.getItemDamage();
	
	if (meta == 0) {
	    par3.add(EnumChatFormatting.WHITE + "1/2" + EnumChatFormatting.DARK_GRAY + " Carbon (Diamond form)");
	    par3.add(EnumChatFormatting.WHITE + "1/2" + EnumChatFormatting.BLUE + " Lapis Lazuli");
	}else if (meta == 1) {
	    par3.add(EnumChatFormatting.WHITE + "4/5" + EnumChatFormatting.DARK_GRAY + " Carbon (Diamond form)");
	    par3.add(EnumChatFormatting.WHITE + "1/5" + EnumChatFormatting.GREEN + " Emerald");
	}else if (meta == 2) {
	    par3.add(EnumChatFormatting.WHITE + "5/15" + EnumChatFormatting.DARK_GRAY + " Carbon (Diamond form)");
	    par3.add(EnumChatFormatting.DARK_RED + "|" + EnumChatFormatting.WHITE + "6/15" + EnumChatFormatting.GRAY + " Iron");
	    par3.add(EnumChatFormatting.DARK_RED + "|" + EnumChatFormatting.WHITE + "4/15" + EnumChatFormatting.RED + " Redstone");
	}else if (meta == 3) {
	    par3.add(EnumChatFormatting.WHITE + "1/3" + EnumChatFormatting.DARK_GRAY + " Carbon (Diamond form)");
	    par3.add(EnumChatFormatting.DARK_RED + "|" + EnumChatFormatting.WHITE + "1/3" + EnumChatFormatting.YELLOW + " Glowstone");
	    par3.add(EnumChatFormatting.DARK_RED + "|" + EnumChatFormatting.WHITE + "1/3" + EnumChatFormatting.RED + " Redstone");
	}
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
 int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, this.names.length);
 return super.getUnlocalizedName() + "." + names[i];
}

@SideOnly(Side.CLIENT)
public IIcon getIconFromDamage(int par1)
{
return icons[par1];
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
{
   for (int x = 0; x < this.names.length; x++)
    {
        par3List.add(new ItemStack(this, 1, x));
    }
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
	this.icons = new IIcon[this.names.length];
	
	for (int i = 0; i < this.names.length; i++) {
	    this.icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_DUST + "_" + names[i]);
	}
}
}