package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Entity.EntityFX.EntityGlassShineFX;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockVanillaGlassGlow extends BlockBreakable {



public BlockVanillaGlassGlow(Material par2Material, boolean par3) {
super("glass", par2Material, par3);
setCreativeTab(ECTabs.tabECDeco); //place in creative tabs

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


@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon("glass");
}
}