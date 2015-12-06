package evercraft.NEMESIS13cz.Blocks.MetalBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.ECTabs;

public class BlockDerpyBlock extends Block {



public BlockDerpyBlock(String texture) {
super(Material.iron);
setCreativeTab(ECTabs.tabECDeco);
}

public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
	entity.motionY = 20;
}


@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.DERPY_BLOCK);
}
}