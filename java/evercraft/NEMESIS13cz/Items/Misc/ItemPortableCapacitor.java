package evercraft.NEMESIS13cz.Items.Misc;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemPortableCapacitor extends Item {
public ItemPortableCapacitor() {
setCreativeTab(ECTabs.tabECMisc); //Tells the game what creative mode tab it goes in
this.setHasSubtypes(true);
this.setMaxDamage(0);
this.setMaxStackSize(1);
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
	int k = par1.getItemDamage();
	if (par1.stackTagCompound != null) {
		int charge = (int)par1.stackTagCompound.getInteger("charge");
		if (k == 0) {
			if (charge <= 200) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/1000");
			}if (charge <= 400 && charge > 200) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/1000");
			}if (charge <= 600 && charge > 400) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/1000");
			}if (charge <= 800 && charge > 600) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/1000");
			}if (charge <= 1000 && charge > 800) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/1000");
			}
		    par3.add(EnumChatFormatting.RED + "Low" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 1EE/t");
		    par3.add("Discharge Speed: 10EE/t");
		}else if (k == 1) {
			if (charge <= 800) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/4000");
			}if (charge <= 1600 && charge > 800) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/4000");
			}if (charge <= 2400 && charge > 1600) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/4000");
			}if (charge <= 3200 && charge > 2400) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/4000");
			}if (charge <= 4000 && charge > 3200) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/4000");
			}
		    par3.add(EnumChatFormatting.GOLD + "Medium" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 10EE/t");
		    par3.add("Discharge Speed: 20EE/t");
		}else if (k == 2) {
			if (charge <= 3200) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/16000");
			}if (charge <= 6400 && charge > 3200) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/16000");
			}if (charge <= 9600 && charge > 6400) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/16000");
			}if (charge <= 12800 && charge > 9600) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/16000");
			}if (charge <= 16000 && charge > 12800) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/16000");
			}
		    par3.add(EnumChatFormatting.GREEN + "High" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 50EE/t");
		    par3.add("Discharge Speed: 100EE/t");
		}else if (k == 3) {
			if (charge <= 12800) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/64000");
			}if (charge <= 25600 && charge > 12800) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/64000");
			}if (charge <= 38400 && charge > 25600) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/64000");
			}if (charge <= 51200 && charge > 38400) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/64000");
			}if (charge <= 64000 && charge > 51200) {
				par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/64000");
			}
		    par3.add(EnumChatFormatting.BLUE + "Extreme" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 200EE/t");
		    par3.add("Discharge Speed: 600EE/t");
		}
	}else{
		if (k == 0) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/1000");
		    par3.add(EnumChatFormatting.RED + "Low" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 1EE/t");
		    par3.add("Discharge Speed: 10EE/t");
		}else if (k == 1) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/4000");
		    par3.add(EnumChatFormatting.GOLD + "Medium" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 10EE/t");
		    par3.add("Discharge Speed: 20EE/t");
		}else if (k == 2) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/16000");
		    par3.add(EnumChatFormatting.GREEN + "High" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 50EE/t");
		    par3.add("Discharge Speed: 100EE/t");
		}else if (k == 3) {
			par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/64000");
		    par3.add(EnumChatFormatting.BLUE + "Extreme" + EnumChatFormatting.GRAY + " capacity");
		    par3.add("Charge Speed: 200EE/t");
		    par3.add("Discharge Speed: 600EE/t");
		}
	}
}

@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
	if (player.capabilities.isCreativeMode && player.isSneaking()) {
		if (itemstack.getItemDamage() == 0) {
			itemstack.stackTagCompound.setInteger("charge", 1000);
		}else if (itemstack.getItemDamage() == 1) {
			itemstack.stackTagCompound.setInteger("charge", 4000);
		}else if (itemstack.getItemDamage() == 2) {
			itemstack.stackTagCompound.setInteger("charge", 16000);
		}else if (itemstack.getItemDamage() == 3) {
			itemstack.stackTagCompound.setInteger("charge", 64000);
		}
    }
return itemstack;
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


public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	itemStack.stackTagCompound = new NBTTagCompound();
	itemStack.stackTagCompound.setInteger("charge", 0);
}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean b) {
	if (itemstack.stackTagCompound == null) {
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setInteger("charge", 0);
	}
}
}