package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockClearGlass extends BlockBreakable {



public BlockClearGlass(Material par2Material, boolean par3) {
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
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.CLEAR_GLASS);
}
}