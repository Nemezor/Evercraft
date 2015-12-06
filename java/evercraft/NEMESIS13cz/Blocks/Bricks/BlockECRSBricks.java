package evercraft.NEMESIS13cz.Blocks.Bricks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;

public class BlockECRSBricks extends Block
{
    /////////////////////////////////
private static int BlockMetaCount = 4; //
    /////////////////////////////////
	
       public BlockECRSBricks(Material m)
       {
             super(m);
       }

       public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
       {
           par3.add("Powered");
       }
       public boolean canProvidePower()
       {
           return true;
       }

       public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
       {
           return 15;

       }
       @SideOnly(Side.CLIENT)
       private IIcon[] icons;
      
       @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
             icons = new IIcon[BlockMetaCount];
            
             for(int i = 0; i < icons.length; i++)
             {
                    icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + "blockECRSbricks" + i);
             }
    }
      
       @SideOnly(Side.CLIENT)
       public IIcon getIcon(int par1, int par2)
       {
             return icons[par2];
       }
      
       @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < BlockMetaCount; var4++)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
       public int damageDropped(int par1)
       {
           return par1;
       }
       
	public static int limitToValidMetadata(int j1) 
	{
		return BlockMetaCount - 1;
	}
}