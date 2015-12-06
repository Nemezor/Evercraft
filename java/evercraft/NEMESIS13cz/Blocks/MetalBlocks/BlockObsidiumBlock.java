package evercraft.NEMESIS13cz.Blocks.MetalBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockObsidiumBlock extends Block {



public BlockObsidiumBlock(String texture) {
super(Material.iron);
setCreativeTab(ECTabs.tabECDeco); //place in creative tabs
}



@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.OBSIDIUM_BLOCK);
}
}