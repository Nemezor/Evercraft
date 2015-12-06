package evercraft.NEMESIS13cz.Blocks.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityRedstoniteCable;
import evercraft.NEMESIS13cz.Utils.BlockPowerNetwork;
import evercraft.NEMESIS13cz.Utils.TileEntityAcceptable;
import evercraft.NEMESIS13cz.Utils.TileEntityGenerator;

public class BlockRedstoniteCable extends BlockPowerNetwork {

private float pixel = 1F/16F;

public BlockRedstoniteCable() {
super(Material.iron);
}

public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
	
	float maxX = pixel*5;
	float maxY = pixel*5;
	float maxZ = pixel*5;
	float minX = 1 - pixel*5;
	float minY = 1 - pixel*5;
	float minZ = 1 - pixel*5;
	
	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityAcceptable || world.getTileEntity(x, y + 1, z) instanceof TileEntityGenerator) {
		minY = 1;
	}
	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityAcceptable || world.getTileEntity(x, y - 1, z) instanceof TileEntityGenerator) {
		maxY = 0;
	}
	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityAcceptable || world.getTileEntity(x + 1, y, z) instanceof TileEntityGenerator) {
		minX = 1;
	}
	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityAcceptable || world.getTileEntity(x - 1, y, z) instanceof TileEntityGenerator) {
		maxX = 0;
	}
	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityAcceptable || world.getTileEntity(x, y, z + 1) instanceof TileEntityGenerator) {
		minZ = 1;
	}
	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityAcceptable || world.getTileEntity(x, y, z - 1) instanceof TileEntityGenerator) {
		maxZ = 0;
	}
	
	setBlockBounds(maxX, maxY, maxZ, minX, minY, minZ);
}

public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
{
	
	float maxX1 = pixel*5;
	float maxY1 = pixel*5;
	float maxZ1 = pixel*5;
	float minX1 = 1 - pixel*5;
	float minY1 = 1 - pixel*5;
	float minZ1 = 1 - pixel*5;

	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityAcceptable || world.getTileEntity(x, y + 1, z) instanceof TileEntityGenerator) {
		minY1 = 1;
	}
	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityAcceptable || world.getTileEntity(x, y - 1, z) instanceof TileEntityGenerator) {
		maxY1 = 0;
	}
	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityAcceptable || world.getTileEntity(x + 1, y, z) instanceof TileEntityGenerator) {
		minX1 = 1;
	}
	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityAcceptable || world.getTileEntity(x - 1, y, z) instanceof TileEntityGenerator) {
		maxX1 = 0;
	}
	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityAcceptable || world.getTileEntity(x, y, z + 1) instanceof TileEntityGenerator) {
		minZ1 = 1;
	}
	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityAcceptable || world.getTileEntity(x, y, z - 1) instanceof TileEntityGenerator) {
		maxZ1 = 0;
	}
	
	setBlockBounds(maxX1, maxY1, maxZ1, minX1, minY1, minZ1);
	
	return AxisAlignedBB.getBoundingBox(x+minX, y+minY, z+minZ, x+maxX, y+maxY, z+maxZ);
}

@Override
public int getRenderType() {
	return -1;
}

public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
	killNetwork = true;
	super.breakBlock(world, x, y, z, block, par6);
}

public boolean isOpaqueCube() {
	return false;
}

public boolean renderAsNormalBlock() {
	return false;
}

public TileEntity createNewTileEntity(World par1World, int par2) {
    return new TileEntityRedstoniteCable();
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.REDSTONITE_CABLE_ITEM);
}
}