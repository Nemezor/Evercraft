package evercraft.NEMESIS13cz.Tools.Pickaxes;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Tools.Base.ItemPickaxePowered;

public class ItemEthericDrill extends ItemPickaxePowered
{

    public ItemEthericDrill(Item.ToolMaterial par2ECEnumToolMaterial)
    {
        super(par2ECEnumToolMaterial);
        this.setNoRepair();
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
        par3.add("Mining Speed: 8.0");
        par3.add("Mining Level: Obsidian");
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
    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ETHERIC_DRILL);
}
}
