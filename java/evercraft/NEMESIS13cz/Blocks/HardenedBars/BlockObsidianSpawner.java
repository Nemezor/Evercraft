package evercraft.NEMESIS13cz.Blocks.HardenedBars;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockObsidianSpawner extends BlockBreakable {



public BlockObsidianSpawner(Material par2Material, boolean par3) {
super("glass", par2Material, par3);
setCreativeTab(ECTabs.tabECDeco); //place in creative tabs

}

@SideOnly(Side.CLIENT)
public int getRenderBlockPass()
{
         return 1;
}

public boolean isOpaqueCube()
{
         return false;
}

public boolean renderAsNormalBlock()
{
         return false;
}



@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.OBSIDIAN_HARDENED_BARS);
}
}