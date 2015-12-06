package evercraft.NEMESIS13cz.Tools.Misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Utils.WrenchBehavior;


public class ItemEthericWrench extends Item {
	
	public ItemEthericWrench() {
		super();
		setCreativeTab(ECTabs.tabECTools);
		this.maxStackSize = 1;
		this.setMaxDamage(0);
		this.setNoRepair();
	}

	private IIcon wrench_off;
	private IIcon wrench_on;
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int side, float par8, float par9, float par10) {
	    if (!par2EntityPlayer.canPlayerEdit(x, y, z, side, itemstack)) {
	        return false;
	    }else {
	        Block i1 = par3World.getBlock(x, y, z);
	        
	        if(itemstack.stackTagCompound.getInteger("charge") < 10) {
	        	return false;
	        }else{
	            if (par3World.isRemote) {
	                return true;
	            }else{
	            	if (!par2EntityPlayer.isSneaking() && WrenchBehavior.isWrenchable(i1)) {
		            	WrenchBehavior.wrenchMachine(par3World, x, y, z, i1);
		            	int charge = itemstack.stackTagCompound.getInteger("charge");
		            	charge -= 10;
		            	itemstack.stackTagCompound.setInteger("charge", charge);
	            	}else if (par2EntityPlayer.isSneaking() && WrenchBehavior.rotateables(i1)) {
	            		WrenchBehavior.rotateMachine(par3World, x, y, z, side);
		            	int charge = itemstack.stackTagCompound.getInteger("charge");
		            	charge -= 10;
		            	itemstack.stackTagCompound.setInteger("charge", charge);
	            	}
	            }
	            return true;
	        }
	    } 
	}
	
    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {
    	if (par1.stackTagCompound != null) {
    	int charge = (int)par1.stackTagCompound.getInteger("charge");
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
	        par3.add("Uses: " + (par1.stackTagCompound.getInteger("charge") / 10));
    	}else{
    		par3.add(EnumChatFormatting.WHITE + "EE: " + EnumChatFormatting.DARK_RED + "0" + EnumChatFormatting.WHITE + "/16000");
            par3.add("Uses: 0");
    	}
	    par3.add("Charge Speed: 50EE/t");
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
	public IIcon getIconIndex(ItemStack stack)
	{
		if (stack.stackTagCompound != null) {
			int charge = stack.stackTagCompound.getInteger("charge");
			if (charge > 0) {
				this.itemIcon = this.wrench_on;
			}else{
				this.itemIcon = this.wrench_off;
			}
		}else{
			this.itemIcon = this.wrench_off;
		}

		return this.itemIcon;
	}
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
    	if (player.capabilities.isCreativeMode && player.isSneaking()) {
    		itemstack.stackTagCompound.setInteger("charge", 16000);
        }
    return itemstack;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.wrench_on = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ETHERIC_WRENCH_ON);
	    this.wrench_off = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ETHERIC_WRENCH_OFF);
	}
}