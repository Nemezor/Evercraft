package evercraft.NEMESIS13cz.Blocks.WorldGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Entity.EntityFX.EntityBigFlameFX;
import evercraft.NEMESIS13cz.Entity.EntityFX.EntityBigSmokeFX;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class BlockFireBlock extends Block
{

    /////////////////////////////////
	private static int BlockMetaCount = 2;
    /////////////////////////////////
	
       public BlockFireBlock(Material m)
       {
             super(m);
             
       }

       public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
       {
           float f = 0.125F;
           return AxisAlignedBB.getBoundingBox((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
       }
       
       
       @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < BlockMetaCount; var4++)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

       public boolean isOpaqueCube()
       {
                return true;
       }

       public boolean renderAsNormalBlock()
       {
                return true;
       }
       
	public static int limitToValidMetadata(int j1) 
	{
		return BlockMetaCount - 1;
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    @SideOnly(Side.CLIENT)
	public static IIcon particlebigsmoke;
    @SideOnly(Side.CLIENT)
	public static IIcon particlebigflame;
    
   
    @SideOnly(Side.CLIENT)
 public void registerBlockIcons(IIconRegister par1IconRegister)
 {
          icons = new IIcon[BlockMetaCount];
         
          for(int i = 0; i < icons.length; i++)
          {
                 icons[i] = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + "blockfireblock" + i);
          }
          particlebigsmoke = par1IconRegister.registerIcon(ModInformation.PARTICLETEXTUREPATH + "/" + ModInformation.BIGSMOKE_PARTICLE);
          particlebigflame = par1IconRegister.registerIcon(ModInformation.PARTICLETEXTUREPATH + "/" + ModInformation.BIGFLAME_PARTICLE);
 }
   
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
          return icons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 1.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.0F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (l == 0)
            {
            	 Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBigSmokeFX(par1World, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.15D, 0.0D, 3.2F));
            }
            else if (l == 1)
            {
           	 Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBigSmokeFX(par1World, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.15D, 0.0D, 3.2F));
           	 Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBigFlameFX(par1World, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.16D, 0.0D, 1.5F));
            }
            
        }
    
    public boolean canSilkHarvest()
    {
    	return true;
    }
    public int quantityDropped(Random random)
    {
    return 0;
    }
    
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }
    

    protected Item getCoalItem()
    {
        return Evercraft_Items.infernalcoal;
    }


    protected Item getBlockItem()
    {
        return Item.getItemFromBlock(Blocks.netherrack);
    }
    
    
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    	if (world.getBlockMetadata(x, y, z) == 1) {
        	entity.setFire(10);
        	entity.attackEntityFrom(DamageSource.generic, 4.0F);
        	return;
    	}else{
        	entity.attackEntityFrom(DamageSource.generic, 4.0F);
        	return;
    	}
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override 
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

        if (metadata >= 0)
        {
            ret.add(new ItemStack(this.getCoalItem(), 1, 0));
            ret.add(new ItemStack(this.getBlockItem(), 1, 0));
        }

        return ret;
    }
}




