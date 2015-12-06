 package evercraft.NEMESIS13cz.Items.Nuggets;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class ItemMetaNuggets extends Item
{
       public ItemMetaNuggets()
       {
              this.setHasSubtypes(true);
              this.setMaxDamage(0);
              this.setCreativeTab(ECTabs.tabECWGMaterials);
       }

       public static final String[] names = new String[] {"iron", "zinc", "tin", "titanium", "steel", "obsidian", "lead", "copper", "silver"};
       
       @SideOnly(Side.CLIENT)
       private IIcon[] icons;
      
       @SideOnly(Side.CLIENT)
       public void registerIcons(IIconRegister par1IconRegister)
       {
              icons = new IIcon[names.length];
             
              for(int i = 0; i < icons.length; i++)
              {
                     icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + names[i] + "nugget");
              }
       }
      
      
       public String getUnlocalizedName(ItemStack par1ItemStack)
       {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, names.length);
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
       for (int x = 0; x < names.length; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }
}