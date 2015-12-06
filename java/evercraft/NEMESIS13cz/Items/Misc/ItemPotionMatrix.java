 package evercraft.NEMESIS13cz.Items.Misc;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemPotionMatrix extends Item
{
       public ItemPotionMatrix()
       {
              this.setHasSubtypes(true);
              this.setMaxDamage(0);
              this.setMaxStackSize(1);
              this.setCreativeTab(ECTabs.tabECMetaM);
       }
       
       public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean b) {
    	   
    	   if (itemstack.getItemDamage() > 0) {
	    	   PotionEffect effect = new PotionEffect(itemstack.getItemDamage(), 0, 0);
	    	   String name = StatCollector.translateToLocal(effect.getEffectName()).trim();
	    	   if (Potion.potionTypes[itemstack.getItemDamage()].isBadEffect()) {
	        	   list.add(EnumChatFormatting.RED + name);
	    	   }else{
	        	   list.add(EnumChatFormatting.BLUE + name);
	    	   }
	    	   if (itemstack.stackTagCompound != null) {
	    		   list.add("Uses Left: " + itemstack.stackTagCompound.getInteger("uses"));
	    	   }else{
	    		   list.add("Uses Left: 4");
	    	   }
    	   }else{
    		   list.add("Empty");
    	   }
       }

       @SideOnly(Side.CLIENT)
       private IIcon[] icons;
      
       @SideOnly(Side.CLIENT)
       public void registerIcons(IIconRegister par1IconRegister)
       {
              icons = new IIcon[24];
             
              for(int i = 0; i < icons.length; i++)
              {
                     icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.POTION_MATRIX);
              }
       }

       public static void damageItem(int amount, int maxUses, ItemStack itemstack) {
    	   if (itemstack.stackTagCompound != null) {
        	   int uses = itemstack.stackTagCompound.getInteger("uses");
        	   uses -= amount;
        	   if (uses == 0) {
        			itemstack.stackSize--; 
        	   }else{
        		   itemstack.stackTagCompound.setInteger("uses", uses);
        	   }
    	   }else{
    		   itemstack.stackTagCompound = new NBTTagCompound();
    		   itemstack.stackTagCompound.setInteger("uses", maxUses - amount);
    	   }
       }
       
public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
	itemstack.stackTagCompound = new NBTTagCompound();
	itemstack.stackTagCompound.setInteger("uses", 4);
	
	if (itemstack.stackTagCompound.getInteger("uses") == 0) {
		itemstack.stackSize--; 
	}
}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean b) {
	if (itemstack.stackTagCompound == null) {
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setInteger("uses", 4);
	}
	if (itemstack.stackTagCompound.getInteger("uses") == 0) {
		itemstack.stackSize--; 
	}
}
      
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return super.getUnlocalizedName();
    }
       
       @SideOnly(Side.CLIENT)
       public IIcon getIconFromDamage(int par1)
    {
       return icons[par1];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
       for (int x = 0; x < 24; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }
}