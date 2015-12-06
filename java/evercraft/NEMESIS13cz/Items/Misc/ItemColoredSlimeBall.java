 package evercraft.NEMESIS13cz.Items.Misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Blocks.HardenedBars.BlockHardenedBarsColored;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;


public class ItemColoredSlimeBall extends Item
{
       public ItemColoredSlimeBall()
       {
              this.setHasSubtypes(true);
              this.setMaxDamage(0);
              this.setCreativeTab(ECTabs.tabECDeco);
       }
       
       
       /////////////////////////////////
       public int ItemMetaCount = 16; //
       /////////////////////////////////
       
       
       @SideOnly(Side.CLIENT)
       private IIcon[] icons;
      
       @SideOnly(Side.CLIENT)
       public void registerIcons(IIconRegister par1IconRegister)
       {
              icons = new IIcon[ItemMetaCount];
             
              for(int i = 0; i < icons.length; i++)
              {
                     icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5) + i);
              }
       }
      
       public static final String[] names = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lightgreen", "yellow", "lightblue", "magenta", "orange", "white"};
      
       public String getUnlocalizedName(ItemStack par1ItemStack)
       {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
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
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                return true;
            }
            for(int i = 0; i < ItemMetaCount;i++)
            if (par1ItemStack.getItemDamage() == i){
            Block i1 = par3World.getBlock(par4, par5, par6);
            int j1 = par3World.getBlockMetadata(par4, par5, par6);

            if (par7 == 0 || (i1 != Evercraft_Blocks.blockhardenedbarscolored && BlockHardenedBarsColored.limitToValidMetadata(j1) < 16 && i1 != Evercraft_Blocks.blockbasicspawner))
            {
                return false;
            }
            else
            {
                Block block = Evercraft_Blocks.blockhardenedbarscolored;
            

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block, i, 2);
                    if (!par2EntityPlayer.capabilities.isCreativeMode)
                    {
                        --par1ItemStack.stackSize;
                    }
                }
                    return true;
                }
            }
        }
		return true;
    }

    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {
        par3.add("Used to Dye Metals");
    }
}