package evercraft.NEMESIS13cz.Blocks.Machines;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiningPipe;

public class BlockMiningPipe extends BlockContainer {



public BlockMiningPipe() {
super(Material.iron);
super.setBlockBounds(0.3125F, 0, 0.3125F, 0.6875F, 1, 0.6875F);
}

@Override
public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
	return false;
}

@Override
public int getRenderType() {
	return -1;
}

public boolean isOpaqueCube() {
	return false;
}

public boolean renderAsNormalBlock() {
	return false;
}

public TileEntity createNewTileEntity(World par1World, int par2) {
    return new TileEntityMiningPipe();
}

public int quantityDropped(Random par1Random)
{
    return 0;
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.MINING_PIPE);
}
}