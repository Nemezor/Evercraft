package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;

public class BlockECColoredGlass2 extends BlockStainedGlass
{
    /////////////////////////////////
private static int BlockMetaCount = 16; //
    /////////////////////////////////
	
public BlockECColoredGlass2(Material par2Material, boolean par3) {
	   super(par2Material);
}
@SideOnly(Side.CLIENT)
public int getRenderBlockPass()
{
    return 1;
}


public boolean renderAsNormalBlock()
{
        return false;
}

       @SideOnly(Side.CLIENT)
       private IIcon[] icons;
      
       @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
             icons = new IIcon[BlockMetaCount];
            
             for(int i = 0; i < icons.length; i++)
             {
                    icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + "blockcoloredglassclear" + i);
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
	public boolean canSilkHarvest()
	{
		return true;
	}
	public int quantityDropped(Random random)
	{
	return 0;
	}
}