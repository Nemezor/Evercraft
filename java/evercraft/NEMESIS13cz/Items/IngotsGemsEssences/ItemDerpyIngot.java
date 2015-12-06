package evercraft.NEMESIS13cz.Items.IngotsGemsEssences;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemDerpyIngot extends Item
{
      public ItemDerpyIngot()
      {
             this.setHasSubtypes(true);
             this.setMaxDamage(0);
             this.setCreativeTab(ECTabs.tabECWGMaterials);
      }
      
      @SideOnly(Side.CLIENT)
      public boolean hasEffect(ItemStack par1ItemStack)
      {
    	  if (this.getDamage(par1ItemStack) == 0) {
    		  return true;
    	  }else{
    		  return false;
    	  }
      }
      public EnumRarity getRarity(ItemStack par1ItemStack)
      {
    	  if (this.getDamage(par1ItemStack) == 0) {
    		  return EnumRarity.rare;
    	  }else{
    		  return EnumRarity.common;
    	  }
      }
      
      /////////////////////////////////
      public int ItemMetaCount = 1; //
      /////////////////////////////////
      
      
      @SideOnly(Side.CLIENT)
      private IIcon[] icons;
     
      @SideOnly(Side.CLIENT)
      public void registerIcons(IIconRegister par1IconRegister)
      {
             icons = new IIcon[ItemMetaCount];
            
             for(int i = 0; i < icons.length; i++)
             {
                    icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.DERPY_INGOT);
             }
      }
     
      public static final String[] names = new String[] {"regular", "achievement"};
     
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
}