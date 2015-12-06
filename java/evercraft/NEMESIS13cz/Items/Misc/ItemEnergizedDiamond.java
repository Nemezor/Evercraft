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


public class ItemEnergizedDiamond extends Item {
public ItemEnergizedDiamond() {
setCreativeTab(ECTabs.tabECMisc);
this.setMaxStackSize(1);
this.setHasSubtypes(true);
this.setMaxDamage(0);
}
@SideOnly(Side.CLIENT)
private IIcon[] icon_charge_1;
@SideOnly(Side.CLIENT)
private IIcon[] icon_charge_2;
@SideOnly(Side.CLIENT)
private IIcon[] icon_charge_3;
@SideOnly(Side.CLIENT)
private IIcon[] icon_charge_4;
@SideOnly(Side.CLIENT)
private IIcon[] icon_discharged;

public static final String[] names = new String[] {"blue", "green", "red", "etheric"};

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4) {
			if (par1.getItemDamage() == 0) {
				if (par1.stackTagCompound != null) {
					int charge = par1.stackTagCompound.getInteger("charge");
					if (charge <= this.getNumber(192000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/192000");
					}if (charge <= this.getNumber(192000, 4) && charge > this.getNumber(192000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/192000");
					}if (charge <= this.getNumber(192000, 3) && charge > this.getNumber(192000, 4)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/192000");
					}if (charge <= this.getNumber(192000, 2) && charge > this.getNumber(192000, 3)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/192000");
					}if (charge <= 192000 && charge > this.getNumber(192000, 2)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/192000");
					}
				}else{
					par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/192000");
				}
			    par3.add(EnumChatFormatting.DARK_PURPLE + "Crystal");
			    par3.add("Charge Speed: 600EE/t");
			    par3.add("Discharge Speed: 2400EE/t");
			}
			if (par1.getItemDamage() == 1) {
				if (par1.stackTagCompound != null) {
					int charge = par1.stackTagCompound.getInteger("charge");
					if (charge <= this.getNumber(256000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/256000");
					}if (charge <= this.getNumber(256000, 4) && charge > this.getNumber(256000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/256000");
					}if (charge <= this.getNumber(256000, 3) && charge > this.getNumber(256000, 4)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/256000");
					}if (charge <= this.getNumber(256000, 2) && charge > this.getNumber(256000, 3)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/256000");
					}if (charge <= 256000 && charge > this.getNumber(256000, 2)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/256000");
					}
				}else{
					par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/256000");
				}
			    par3.add(EnumChatFormatting.DARK_PURPLE + "Crystal");
			    par3.add("Charge Speed: 800EE/t");
			    par3.add("Discharge Speed: 3200EE/t");
			}
			if (par1.getItemDamage() == 2) {
				if (par1.stackTagCompound != null) {
					int charge = par1.stackTagCompound.getInteger("charge");
					if (charge <= this.getNumber(320000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/320000");
					}if (charge <= this.getNumber(320000, 4) && charge > this.getNumber(320000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/320000");
					}if (charge <= this.getNumber(320000, 3) && charge > this.getNumber(320000, 4)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/320000");
					}if (charge <= this.getNumber(320000, 2) && charge > this.getNumber(320000, 3)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/320000");
					}if (charge <= 320000 && charge > this.getNumber(320000, 2)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/320000");
					}
				}else{
					par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/320000");
				}
			    par3.add(EnumChatFormatting.DARK_PURPLE + "Crystal");
			    par3.add("Charge Speed: 1000EE/t");
			    par3.add("Discharge Speed: 4000EE/t");
			}
			if (par1.getItemDamage() == 3) {
				if (par1.stackTagCompound != null) {
					int charge = par1.stackTagCompound.getInteger("charge");
					if (charge <= this.getNumber(384000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + charge + EnumChatFormatting.WHITE + "/384000");
					}if (charge <= this.getNumber(384000, 4) && charge > this.getNumber(384000, 5)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.RED + charge + EnumChatFormatting.WHITE + "/384000");
					}if (charge <= this.getNumber(384000, 3) && charge > this.getNumber(384000, 4)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GOLD + charge + EnumChatFormatting.WHITE + "/384000");
					}if (charge <= this.getNumber(384000, 2) && charge > this.getNumber(384000, 3)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.YELLOW + charge + EnumChatFormatting.WHITE + "/384000");
					}if (charge <= 384000 && charge > this.getNumber(384000, 2)) {
						par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.GREEN + charge + EnumChatFormatting.WHITE + "/384000");
					}
				}else{
					par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/384000");
				}
			    par3.add(EnumChatFormatting.DARK_PURPLE + "Crystal");
			    par3.add("Charge Speed: 1600EE/t");
			    par3.add("Discharge Speed: 5600EE/t");
			}
}

public int getNumber(int num, int divisor) {
	if (divisor == 5) {
		return num/5;
	}else if(divisor == 4) {
		return (num/5)*2;
	}else if(divisor == 3) {
		return (num/5)*3;
	}else if(divisor == 2) {
		return (num/5)*4;
	}else{
		return num;
	}
}

@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
	int meta = itemstack.getItemDamage();
	if (player.capabilities.isCreativeMode && player.isSneaking()) {
		if (meta == 0) {
			itemstack.stackTagCompound.setInteger("charge", 192000);
		}else if (meta == 1) {
			itemstack.stackTagCompound.setInteger("charge", 256000);
		}else if (meta == 2) {
			itemstack.stackTagCompound.setInteger("charge", 320000);
		}else if (meta == 3) {
			itemstack.stackTagCompound.setInteger("charge", 384000);
		}
    }
return itemstack;
}

@SideOnly(Side.CLIENT)
public IIcon getIconIndex(ItemStack stack) {
	int meta = stack.getItemDamage();
	if (meta == 0) {
		if (stack.stackTagCompound != null) {
			int charge = stack.stackTagCompound.getInteger("charge");
			if (charge <= this.getNumber(192000, 4) && charge > this.getNumber(192000, 5)) {
				this.itemIcon =  this.icon_charge_1[meta];
			}else if (charge <= this.getNumber(192000, 3) && charge > this.getNumber(192000, 4)) {
				this.itemIcon =  this.icon_charge_2[meta];
			}else if (charge <= this.getNumber(192000, 2) && charge > this.getNumber(192000, 3)) {
				this.itemIcon =  this.icon_charge_3[meta];
			}else if (charge <= 192000 && charge > this.getNumber(192000, 2)) {
				this.itemIcon =  this.icon_charge_4[meta];
			}else{
				this.itemIcon = this.icon_discharged[meta];
			}
		}else{
			this.itemIcon = this.icon_discharged[meta];
		}
	}
	if (meta == 1) {
		if (stack.stackTagCompound != null) {
			int charge = stack.stackTagCompound.getInteger("charge");
			if (charge <= this.getNumber(256000, 4) && charge > this.getNumber(256000, 5)) {
				this.itemIcon =  this.icon_charge_1[meta];
			}else if (charge <= this.getNumber(256000, 3) && charge > this.getNumber(256000, 4)) {
				this.itemIcon =  this.icon_charge_2[meta];
			}else if (charge <= this.getNumber(256000, 2) && charge > this.getNumber(256000, 3)) {
				this.itemIcon =  this.icon_charge_3[meta];
			}else if (charge <= 256000 && charge > this.getNumber(256000, 2)) {
				this.itemIcon =  this.icon_charge_4[meta];
			}else{
				this.itemIcon = this.icon_discharged[meta];
			}
		}else{
			this.itemIcon = this.icon_discharged[meta];
		}
	}
	if (meta == 2) {
		if (stack.stackTagCompound != null) {
			int charge = stack.stackTagCompound.getInteger("charge");
			if (charge <= this.getNumber(320000, 4) && charge > this.getNumber(320000, 5)) {
				this.itemIcon =  this.icon_charge_1[meta];
			}else if (charge <= this.getNumber(320000, 3) && charge > this.getNumber(320000, 4)) {
				this.itemIcon =  this.icon_charge_2[meta];
			}else if (charge <= this.getNumber(320000, 2) && charge > this.getNumber(320000, 3)) {
				this.itemIcon =  this.icon_charge_3[meta];
			}else if (charge <= 320000 && charge > this.getNumber(320000, 2)) {
				this.itemIcon =  this.icon_charge_4[meta];
			}else{
				this.itemIcon = this.icon_discharged[meta];
			}
		}else{
			this.itemIcon = this.icon_discharged[meta];
		}
	}
	if (meta == 3) {
		if (stack.stackTagCompound != null) {
			int charge = stack.stackTagCompound.getInteger("charge");
			if (charge <= this.getNumber(384000, 4) && charge > this.getNumber(384000, 5)) {
				this.itemIcon =  this.icon_charge_1[meta];
			}else if (charge <= this.getNumber(384000, 3) && charge > this.getNumber(384000, 4)) {
				this.itemIcon =  this.icon_charge_2[meta];
			}else if (charge <= this.getNumber(384000, 2) && charge > this.getNumber(384000, 3)) {
				this.itemIcon =  this.icon_charge_3[meta];
			}else if (charge <= 384000 && charge > this.getNumber(384000, 2)) {
				this.itemIcon =  this.icon_charge_4[meta];
			}else{
				this.itemIcon = this.icon_discharged[meta];
			}
		}else{
			this.itemIcon = this.icon_discharged[meta];
		}
	}
	
	return this.itemIcon;
}

public String getUnlocalizedName(ItemStack par1ItemStack)
{
 int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, this.names.length - 1);
 return super.getUnlocalizedName() + "." + names[i];
}

@SideOnly(Side.CLIENT)
public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
{
   for (int x = 0; x < this.names.length; x++)
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

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister) {
	
	this.icon_charge_1 = new IIcon[this.names.length];
	this.icon_charge_2 = new IIcon[this.names.length];
	this.icon_charge_3 = new IIcon[this.names.length];
	this.icon_charge_4 = new IIcon[this.names.length];
	this.icon_discharged = new IIcon[this.names.length];
	
	for (int meta = 0; meta < this.names.length; meta++) {
    this.icon_charge_1[meta] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_1 + "_" + this.names[meta]);
    this.icon_charge_2[meta] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_2 + "_" + this.names[meta]);
    this.icon_charge_3[meta] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_3 + "_" + this.names[meta]);
    this.icon_charge_4[meta] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_4 + "_" + this.names[meta]);
    this.icon_discharged[meta] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ENERGIZED_DIAMOND_DIS + "_" + this.names[meta]);
	}
    
}
}