package evercraft.NEMESIS13cz.Items.Misc;

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

public class ItemMachineCapacitor extends Item {
public ItemMachineCapacitor() {
setCreativeTab(ECTabs.tabECMisc); //Tells the game what creative mode tab it goes in
this.setHasSubtypes(true);
this.setMaxDamage(0);
}


/////////////////////////////////
public static int ItemMetaCount = 4; //
/////////////////////////////////

@SideOnly(Side.CLIENT)
private IIcon[] icons;

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
       icons = new IIcon[ItemMetaCount];
      
       for(int i = 0; i < icons.length; i++)
       {
              icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5) + names[i]);
       }
}
public static final String[] names = new String[] {"low", "medium", "high", "extreme"};


public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
	int k = this.getDamage(par1);
	if (k == 0) {
	    par3.add(EnumChatFormatting.YELLOW + "10 000" + EnumChatFormatting.WHITE + " Etheric Energy");
	    par3.add(EnumChatFormatting.RED + "Low" + EnumChatFormatting.GRAY + " capacity");
	}else if (k == 1) {
	    par3.add(EnumChatFormatting.YELLOW + "30 000" + EnumChatFormatting.WHITE + " Etheric Energy");
	    par3.add(EnumChatFormatting.GOLD + "Medium" + EnumChatFormatting.GRAY + " capacity");
	}else if (k == 2) {
	    par3.add(EnumChatFormatting.YELLOW + "120 000" + EnumChatFormatting.WHITE + " Etheric Energy");
	    par3.add(EnumChatFormatting.GREEN + "High" + EnumChatFormatting.GRAY + " capacity");
	}else if (k == 3) {
	    par3.add(EnumChatFormatting.YELLOW + "200 000" + EnumChatFormatting.WHITE + " Etheric Energy");
	    par3.add(EnumChatFormatting.BLUE + "Extreme" + EnumChatFormatting.GRAY + " capacity");
	}
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
 int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, ItemMetaCount - 1);
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
   for (int x = 0; x < ItemMetaCount; x++)
    {
        par3List.add(new ItemStack(this, 1, x));
    }
}
}