package evercraft.NEMESIS13cz.Blocks.MetalBlocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;

public class BlockPlatedBlock extends Block {
	
	private static int BlockMetaCount = 13;
	
       public BlockPlatedBlock(Material m)
       {
             super(m);
       }
       
       @SideOnly(Side.CLIENT)
       private IIcon[] iconsGeneric;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons0;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons1;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons2;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons3;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons4;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons5;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons6;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons7;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons8;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons9;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons10;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons11;
       @SideOnly(Side.CLIENT)
       private IIcon[] icons12;
       
       public static int[] textureRefByID = {0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4, 5, 5, 17, 17, 22, 26, 17, 17, 22, 26, 16, 16, 20, 20, 16, 16, 28, 28, 21, 21, 46, 42, 21, 21, 43, 38, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9, 30, 12, 9, 9, 30, 12, 16, 16, 20, 20, 16, 16, 28, 28, 25, 25, 45, 37, 25, 25, 40, 32, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4, 5, 5, 17, 17, 22, 26, 17, 17, 22, 26, 7, 7, 24, 24, 7, 7, 10, 10, 29, 29, 44, 41, 29, 29, 39, 33, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9, 30, 12, 9, 9, 30, 12, 7, 7, 24, 24, 7, 7, 10, 10, 8, 8, 36, 35, 8, 8, 34, 11 };
      
       @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
             iconsGeneric = new IIcon[BlockMetaCount];
             icons0 = new IIcon[47];
             icons1 = new IIcon[47];
             icons2 = new IIcon[47];
             icons3 = new IIcon[47];
             icons4 = new IIcon[47];
             icons5 = new IIcon[47];
             icons6 = new IIcon[47];
             icons7 = new IIcon[47];
             icons8 = new IIcon[47];
             icons9 = new IIcon[47];
             icons10 = new IIcon[47];
             icons11 = new IIcon[47];
             icons12 = new IIcon[47];
             
             for(int i = 0; i < BlockMetaCount; i++) {
            	 iconsGeneric[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + i) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + i + " (1)"));
             }
             for(int i = 0; i < 47; i++) {
                    icons0[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 0) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 0 + " (" + (i + 1) + ")"));
                    icons1[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 1) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 1 + " (" + (i + 1) + ")"));
                    icons2[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 2) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 2 + " (" + (i + 1) + ")"));
                    icons3[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 3) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 3 + " (" + (i + 1) + ")"));
                    icons4[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 4) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 4 + " (" + (i + 1) + ")"));
                    icons5[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 5) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 5 + " (" + (i + 1) + ")"));
                    icons6[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 6) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 6 + " (" + (i + 1) + ")"));
                    icons7[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 7) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 7 + " (" + (i + 1) + ")"));
                    icons8[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 8) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 8 + " (" + (i + 1) + ")"));
                    icons9[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 9) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 9 + " (" + (i + 1) + ")"));
                    icons10[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 10) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 10 + " (" + (i + 1) + ")"));
                    icons11[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 11) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 11 + " (" + (i + 1) + ")"));
                    icons12[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CTM_TEXTUREPATH + "/" + (this.getUnlocalizedName().substring(5).toLowerCase() + 12) +  "/" + ("block" + this.getUnlocalizedName().substring(5).toLowerCase() + 12 + " (" + (i + 1) + ")"));
             }
    }
      
       @SideOnly(Side.CLIENT)
       public IIcon getIcon(int par1, int par2)
       {
    	   if (par2 < BlockMetaCount) {
             return iconsGeneric[par2];
    	   }else{
    		   return iconsGeneric[0];
    	   }
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
       
       @SideOnly(Side.CLIENT)
       public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
       {
                boolean[] bitMatrix = new boolean[8];
                
                   if (side == 0 || side == 1)
                   {
                           bitMatrix[0] = world.getBlock(x-1, y, z-1) == this;
                           bitMatrix[1] = world.getBlock(x, y, z-1) == this;
                           bitMatrix[2] = world.getBlock(x+1, y, z-1) == this;
                           bitMatrix[3] = world.getBlock(x-1, y, z) == this;
                           bitMatrix[4] = world.getBlock(x+1, y, z) == this;
                           bitMatrix[5] = world.getBlock(x-1, y, z+1) == this;
                           bitMatrix[6] = world.getBlock(x, y, z+1) == this;
                           bitMatrix[7] = world.getBlock(x+1, y, z+1) == this;
                   }
                   if (side == 2 || side == 3)
                   {
                           bitMatrix[0] = world.getBlock(x+(side==2?1:-1), y+1, z) == this;
                           bitMatrix[1] = world.getBlock(x, y+1, z)                      == this;
                           bitMatrix[2] = world.getBlock(x+(side==3?1:-1), y+1, z) == this;
                           bitMatrix[3] = world.getBlock(x+(side==2?1:-1), y, z) == this;
                           bitMatrix[4] = world.getBlock(x+(side==3?1:-1), y, z) == this;
                           bitMatrix[5] = world.getBlock(x+(side==2?1:-1), y-1, z) == this;
                           bitMatrix[6] = world.getBlock(x, y-1, z)                      == this;
                           bitMatrix[7] = world.getBlock(x+(side==3?1:-1), y-1, z) == this;
                   }
                   if (side == 4 || side == 5)
                   {
                           bitMatrix[0] = world.getBlock(x, y+1, z+(side==5?1:-1)) == this;
                           bitMatrix[1] = world.getBlock(x, y+1, z)                      == this;
                           bitMatrix[2] = world.getBlock(x, y+1, z+(side==4?1:-1)) == this;
                           bitMatrix[3] = world.getBlock(x, y, z+(side==5?1:-1)) == this;
                           bitMatrix[4] = world.getBlock(x, y, z+(side==4?1:-1)) == this;
                           bitMatrix[5] = world.getBlock(x, y-1, z+(side==5?1:-1)) == this;
                           bitMatrix[6] = world.getBlock(x, y-1, z)                      == this;
                           bitMatrix[7] = world.getBlock(x, y-1, z+(side==4?1:-1)) == this;
                   }
                  
                   int idBuilder = 0;

                   for (int i = 0; i <= 7; i++) idBuilder = idBuilder + (bitMatrix[i]?(i==0?1:(i==1?2:(i==2?4:(i==3?8:(i==4?16:(i==5?32:(i==6?64:128))))))):0);
                  if (world.getBlockMetadata(x, y, z) == 0) {
                      return idBuilder>255||idBuilder<0?icons0[0]:icons0[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 1) {
                      return idBuilder>255||idBuilder<0?icons1[0]:icons1[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 2) {
                      return idBuilder>255||idBuilder<0?icons2[0]:icons2[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 3) {
                      return idBuilder>255||idBuilder<0?icons3[0]:icons3[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 4) {
                      return idBuilder>255||idBuilder<0?icons4[0]:icons4[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 5) {
                      return idBuilder>255||idBuilder<0?icons5[0]:icons5[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 6) {
                      return idBuilder>255||idBuilder<0?icons6[0]:icons6[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 7) {
                      return idBuilder>255||idBuilder<0?icons7[0]:icons7[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 8) {
                      return idBuilder>255||idBuilder<0?icons8[0]:icons8[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 9) {
                      return idBuilder>255||idBuilder<0?icons9[0]:icons9[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 10) {
                      return idBuilder>255||idBuilder<0?icons10[0]:icons10[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 11) {
                      return idBuilder>255||idBuilder<0?icons11[0]:icons11[textureRefByID[idBuilder]];
                  }else if (world.getBlockMetadata(x, y, z) == 12) {
                      return idBuilder>255||idBuilder<0?icons12[0]:icons12[textureRefByID[idBuilder]];
                  }else{
                      return iconsGeneric[0];
                  }

       }
       
	public static int limitToValidMetadata(int j1) 
	{
		return BlockMetaCount - 1;
	}
	
	
}