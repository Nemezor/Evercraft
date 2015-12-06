package evercraft.NEMESIS13cz.Items.Dusts;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.TileEntityAcceptable;

public class ItemSandDust extends Item {
public ItemSandDust() {
this.setHasSubtypes(true);
this.setMaxDamage(0);
this.setCreativeTab(ECTabs.tabECWGMaterials);
}

public static final String[] names = new String[] {"normal", "clear"};

public static int ItemMetaCount = names.length; 

@SideOnly(Side.CLIENT)
private IIcon[] icons;

@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister par1IconRegister)
{
       icons = new IIcon[ItemMetaCount];
      
       for(int i = 0; i < icons.length; i++)
       {
              icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5));
       }
}

public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
{
	int k = this.getDamage(par1);
	if (k == 1) {
	    par3.add("Hydrated");
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