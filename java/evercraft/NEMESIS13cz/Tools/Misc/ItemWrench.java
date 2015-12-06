package evercraft.NEMESIS13cz.Tools.Misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Utils.WrenchBehavior;


public class ItemWrench extends Item {
	
	public ItemWrench() {
		super();
		setCreativeTab(ECTabs.tabECTools);
		this.maxStackSize = 1;
		this.setMaxDamage(Evercraft_Config_Base.wrenchUSES);
	}


public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
    par3.add("Uses: " + (this.getMaxDamage() - this.getDamage(par1)));
}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int side, float par8, float par9, float par10) {
	    if (!par2EntityPlayer.canPlayerEdit(x, y, z, side, par1ItemStack)) {
	        return false;
	    }else{
	        Block i1 = par3World.getBlock(x, y, z);
	        
	            if (par3World.isRemote) {
	                return true;
	            }else{	            	
	            	if (!par2EntityPlayer.isSneaking() && WrenchBehavior.isWrenchable(i1)) {
		            	WrenchBehavior.wrenchMachine(par3World, x, y, z, i1);
		            	par1ItemStack.damageItem(1, par2EntityPlayer);
	            	}else if (par2EntityPlayer.isSneaking() && WrenchBehavior.rotateables(i1)) {
	            		WrenchBehavior.rotateMachine(par3World, x, y, z, side);
	            		par1ItemStack.damageItem(1, par2EntityPlayer);
	            	}
	            }
	            return true;
	    } 
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.WRENCH);
	}
}