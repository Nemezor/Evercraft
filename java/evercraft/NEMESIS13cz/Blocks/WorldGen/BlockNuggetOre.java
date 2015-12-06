package evercraft.NEMESIS13cz.Blocks.WorldGen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityNuggetOre;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;
import evercraft.NEMESIS13cz.Utils.MetaInterface;

public class BlockNuggetOre extends BlockContainer {



public BlockNuggetOre() {
super(Material.sand);
this.useNeighborBrightness = true;
}

private static int BlockMetaCount = 7;

public Item getItemDropped(int par1, Random par2Random, int par3) {
	if (par1 == 0) {
		return Items.gold_nugget;
	}else{
		return Evercraft_Items.metaNugget;
	}
}
public boolean isOpaqueCube()
{
    return false;
}

public boolean renderAsNormalBlock() {
	return false;
}

@SideOnly(Side.CLIENT)
public int getRenderBlockPass()
{
    return 1;
}

public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
{
    return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
}

public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
{
    if (!world.isRemote)
    {
    	if (!this.canPlaceBlockAt(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }

        super.onNeighborBlockChange(world, x, y, z, block);
    }
}

public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
	float maxX = 0;
	float maxY = 0;
	float maxZ = 0;
	float minX = 1;
	float minY = 1;
	float minZ = 1;
	
	if (Block.isEqualTo(world.getBlock(x, y - 1, z), Blocks.grass)) {
		minY = 0.01F;
	}
	
	setBlockBounds(maxX, maxY, maxZ, minX, minY, minZ);
}

public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
	float maxX1 = 0;
	float maxY1 = 0;
	float maxZ1 = 0;
	float minX1 = 1;
	float minY1 = 1;
	float minZ1 = 1;
	
	if (Block.isEqualTo(world.getBlock(x, y - 1, z), Blocks.grass)) {
		minY1 = 0.01F;
	}
	
	setBlockBounds(maxX1, maxY1, maxZ1, minX1, minY1, minZ1);
	
	return AxisAlignedBB.getBoundingBox(x+minX, y+minY, z+minZ, x+maxX, y+maxY, z+maxZ);
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
	this.blockIcon = par1IconRegister.registerIcon("minecraft:gravel");
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2)
{
      return this.blockIcon;
}

@SideOnly(Side.CLIENT)
public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
{
 for (int var4 = 0; var4 < BlockMetaCount; var4++)
 {
     par3List.add(new ItemStack(par1, 1, var4));
 }
}
public int damageDropped(int meta) {
	if (meta == 0) {
		return 0;
	}else if (meta == 1) {
		return MetaInterface.nuggetCopper;
	}else if (meta == 2) {
		return MetaInterface.nuggetIron;
	}else if (meta == 3) {
		return MetaInterface.nuggetLead;
	}else if (meta == 4) {
		return MetaInterface.nuggetZinc;
	}else if (meta == 5){
		return MetaInterface.nuggetTin;
	}else{
		return MetaInterface.nuggetSilver;
	}
}

public static int limitToValidMetadata(int j1) 
{
	return BlockMetaCount - 1;
}

public TileEntity createNewTileEntity(World world, int p_149915_2_) {
	return new TileEntityNuggetOre();
}

public boolean canSilkHarvest()
{
	return false;
}

public int quantityDropped(Random random)
{
return 1;
}

public int getRenderType() {
	return -1;
}
public int getDamageValue(World world, int x, int y, int z)
{
    return world.getBlockMetadata(x, y, z);
}
}