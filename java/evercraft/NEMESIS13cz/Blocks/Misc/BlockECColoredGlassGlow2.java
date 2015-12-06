package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Entity.EntityFX.EntityGlassShineFX;

public class BlockECColoredGlassGlow2 extends BlockStainedGlass
{
    /////////////////////////////////
private static int BlockMetaCount = 16; //
    /////////////////////////////////
	
public BlockECColoredGlassGlow2(Material par2Material, boolean par3) {
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
       public static IIcon particleshine;
      
       @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
             icons = new IIcon[BlockMetaCount];
            
             for(int i = 0; i < icons.length; i++)
             {
                    icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + "blockcoloredglassclear" + i);
             }
             
             particleshine = par1IconRegister.registerIcon(ModInformation.PARTICLETEXTUREPATH + "/" + ModInformation.GLOW_SHINE_PARTICLE);
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
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + -0.2F;
            float f2 = (float)par4 + 0.5F;
            float f3 = par5Random.nextFloat() * 1.2F - 0.6F;
            float f4 = par5Random.nextFloat() * -1.2F - -0.6F;
            float f5 = par5Random.nextFloat() * 1.2F;

            Minecraft.getMinecraft().effectRenderer.addEffect(new EntityGlassShineFX(par1World, (double)(f - f3), (double)(f1 + f5), (double)(f2 + f4), 0.0D, 0.0D, 0.0D, 0.4F));        
    }
}