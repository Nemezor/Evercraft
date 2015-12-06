package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Entity.EntityFX.EntitySmileFX;
import evercraft.NEMESIS13cz.Main.ECTabs;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class BlockSmileBlock extends Block {



public BlockSmileBlock(String texture) {
super(Material.rock);
this.setCreativeTab(ECTabs.tabECMisc);
}
@SideOnly(Side.CLIENT)
public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = (float)par2 + 2.5F;
        float f1 = (float)par3 + 3.0F;
        float f2 = (float)par4 + -2.5F;
        float f3 = par5Random.nextFloat() * 5.0F;
        float f4 = par5Random.nextFloat() * 5.0F;

        	 Minecraft.getMinecraft().effectRenderer.addEffect(new EntitySmileFX(par1World, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.15D, 0.0D, 3.2F));

    }

public Item getItemDropped(int par1, Random par2Random, int par3)
{
return Evercraft_Items.smilespawner;
}
public int quantityDropped(Random random)
{
return 1;
}

public static IIcon PARTICLE_SMILE;

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.SMILE_BLOCK);
    PARTICLE_SMILE = par1IconRegister.registerIcon(ModInformation.PARTICLETEXTUREPATH + "/" + ModInformation.SMILE_PARTICLE);
}
@SideOnly(Side.CLIENT)
public Item itemPicked(World par1World, int par2, int par3, int par4)
{
    return Evercraft_Items.smilespawner;
}
}