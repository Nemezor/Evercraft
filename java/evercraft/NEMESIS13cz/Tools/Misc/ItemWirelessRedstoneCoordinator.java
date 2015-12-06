package evercraft.NEMESIS13cz.Tools.Misc;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemWirelessRedstoneCoordinator extends Item {
public ItemWirelessRedstoneCoordinator() {
setCreativeTab(ECTabs.tabECTools);
this.setMaxStackSize(1);
}

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
	if (par1.stackTagCompound != null) {
    	int charge = par1.stackTagCompound.getInteger("charge");
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
	        par3.add("Uses: " + (par1.stackTagCompound.getInteger("charge") / 10));
	        par3.add("Charge Speed: 10EE/t");
		if(par1.stackTagCompound.getBoolean("isSet")) {
	    par3.add("X: " + par1.stackTagCompound.getInteger("x"));
	    par3.add("Y: " + par1.stackTagCompound.getInteger("y"));
	    par3.add("Z: " + par1.stackTagCompound.getInteger("z"));
		}
	}else{
		par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/4000");
        par3.add("Uses: 0");
        par3.add("Charge Speed: 10EE/t");
	}
    par3.add("");
    if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
    	par3.add(EnumChatFormatting.WHITE + "RightClick" + EnumChatFormatting.GRAY + " on a RS receiver to save it's coords.");
    	par3.add(EnumChatFormatting.WHITE + "Shift+RightClick" + EnumChatFormatting.GRAY + " to erase coords.");
    	par3.add(EnumChatFormatting.WHITE + "Shift+RightClick with an empty hand");
    	par3.add(EnumChatFormatting.GRAY + " on a RS transmitter to reset it.");
    }else{
        par3.add(EnumChatFormatting.GOLD + "Hold Shift...");
    }
}

@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
	if (player.isSneaking()) {
		if (itemstack.stackTagCompound != null) {
			itemstack.stackTagCompound.setBoolean("isSet", false);
			itemstack.stackTagCompound.setInteger("x", 0);
			itemstack.stackTagCompound.setInteger("y", 0);
			itemstack.stackTagCompound.setInteger("z", 0);
		}else{
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setBoolean("isSet", false);
			itemstack.stackTagCompound.setInteger("x", 0);
			itemstack.stackTagCompound.setInteger("y", 0);
			itemstack.stackTagCompound.setInteger("z", 0);
		}
    }
	if (player.capabilities.isCreativeMode && player.isSneaking()) {
		itemstack.stackTagCompound.setInteger("charge", 4000);
    }
return itemstack;
}

public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	itemStack.stackTagCompound = new NBTTagCompound();
	itemStack.stackTagCompound.setBoolean("isSet", false);
	itemStack.stackTagCompound.setInteger("x", 0);
	itemStack.stackTagCompound.setInteger("y", 0);
	itemStack.stackTagCompound.setInteger("z", 0);
	itemStack.stackTagCompound.setInteger("charge", 0);
}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean b) {
	if (itemstack.stackTagCompound == null) {
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setBoolean("isSet", false);
		itemstack.stackTagCompound.setInteger("x", 0);
		itemstack.stackTagCompound.setInteger("y", 0);
		itemstack.stackTagCompound.setInteger("z", 0);
		itemstack.stackTagCompound.setInteger("charge", 0);
	}
}

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.WRS_COORDINATOR);
}
}