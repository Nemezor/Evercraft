package evercraft.NEMESIS13cz.Blocks.WorldGen;

import net.minecraft.block.BlockFalling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockPowerSand extends BlockFalling
{
    public BlockPowerSand()
    {
        super();
        this.setCreativeTab(ECTabs.tabECWGMaterials);
       
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
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.POWER_SAND);
}
}
