package evercraft.NEMESIS13cz.Blocks.WorldGen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;

public class BlockWhiteStone extends Block
{

    /////////////////////////////////
	private static int BlockMetaCount = 3;
    /////////////////////////////////
	
       public BlockWhiteStone(Material m)
       {
             super(m);
       }
       
       
       @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < BlockMetaCount; var4++)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
       
	public static int limitToValidMetadata(int j1) 
	{
		return BlockMetaCount - 1;
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    private String[] names = new String[] {"smooth", "cobblestone", "bricks"};
   
    @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister par1IconRegister)
	 {
          icons = new IIcon[BlockMetaCount];
         
          for(int i = 0; i < icons.length; i++)
          {
                 icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + "whitestone_" + names[i]);
          }
 }
   
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
          return icons[par2];
    }
    
    public boolean canSilkHarvest()
    {
    	return true;
    }
    public int quantityDropped(Random random)
    {
    return 1;
    }
    public int damageDropped(int meta) {
    	if (meta != 0) {
    		return meta;
    	}else{
    		return 1;
    	}
    }
    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
}




