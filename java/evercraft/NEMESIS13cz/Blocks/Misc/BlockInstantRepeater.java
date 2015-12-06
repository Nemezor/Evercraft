package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityInstantRepeater;
import evercraft.NEMESIS13cz.Utils.BlockContainerDirectional;
import evercraft.NEMESIS13cz.Utils.TileEntityAcceptable;

public class BlockInstantRepeater extends BlockContainerDirectional {
	
	public BlockInstantRepeater() {
		super(Material.circuits);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canPlaceBlockAt(world, x, y, z);
    }
    
    public boolean canBlockStay(World world, int x, int y, int z) {
        return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canBlockStay(world, x, y, z);
    }
    
    public void updateTick(World world, int x, int y, int z, Random rand) {
    	if (!this.canBlockStay(world, x, y, z)) {
        	this.breakAndDropBlock(world, x, y, z);
        	this.notifyAll(world, x, y, z);
    	}
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
        int l = ((MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
    	this.notifyAll(world, x, y, z);
    	
        super.onBlockDestroyedByPlayer(world, x, y, z, metadata);
    }
    
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
    	int dir = world.getBlockMetadata(x, y, z) & 3;
    	
    	return side == dir || side == reverseDir(dir);
    }

    public boolean canProvidePower() {
        return false;
    }

    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
        return this.isProvidingWeakPower(world, x, y, z, side);
    }

    protected int func_149904_f(IBlockAccess p_149904_1_, int p_149904_2_, int p_149904_3_, int p_149904_4_, int p_149904_5_)
    {
        return 15;
    }
    
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
    {
        int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);

        if (!((i1 & 12) > 3))
        {
            return 0;
        }
        else
        {
            int j1 = getDirection(i1);
            return j1 == 0 && p_149709_5_ == 3 ? this.func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i1) : (j1 == 1 && p_149709_5_ == 4 ? this.func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i1) : (j1 == 2 && p_149709_5_ == 2 ? this.func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i1) : (j1 == 3 && p_149709_5_ == 5 ? this.func_149904_f(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_, i1) : 0)));
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!this.canBlockStay(world, x, y, z)) {
        	this.breakAndDropBlock(world, x, y, z);
        	this.notifyAll(world, x, y, z);
        }
    }
    
    protected int reverseDir(int dir1) {
    	int dir2 = 0;
    	
    	if (dir1 == 0) {
    		dir2 = 2;
    	}
    	if (dir1 == 1) {
    		dir2 = 3;
    	}
    	if (dir1 == 2) {
    		dir2 = 0;
    	}
    	if (dir1 == 3) {
    		dir2 = 1;
    	}
    	
    	return dir2;
    }
    
    protected int isGettingInput(World world, int x, int y, int z, int side) {
        int i1 = getDirection(side);
        int j1 = x + Direction.offsetX[i1];
        int k1 = z + Direction.offsetZ[i1];
        int l1 = world.getIndirectPowerLevelTo(j1, y, k1, Direction.directionToFacing[i1]);
        return l1 >= 15 ? l1 : Math.max(l1, world.getBlock(j1, y, k1) == Blocks.redstone_wire ? world.getBlockMetadata(j1, y, k1) : 0);
    }
    
    public void updateState(World world, int x, int y, int z) {	    
	    this.notifyDirectional(world, x, y, z);
	    	
	    if (this.isGettingInput(world, x, y, z, world.getBlockMetadata(x, y, z)) > 0) {
	    	world.setBlockMetadataWithNotify(x, y, z, (world.getBlockMetadata(x, y, z) & 3) + 4, 2);
	    }else{
	    	world.setBlockMetadataWithNotify(x, y, z, (world.getBlockMetadata(x, y, z) & 3), 2);
	    }

	    this.notifyDirectional(world, x, y, z);
    }
    
    protected void breakAndDropBlock(World world, int x, int y, int z) {
    	this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
    	world.setBlockToAir(x, y, z);
    }
    
    protected void notifyAll(World world, int x, int y, int z) {

    	world.notifyBlocksOfNeighborChange(x + 1, y, z, world.getBlock(x, y, z));
    	world.notifyBlocksOfNeighborChange(x - 1, y, z, world.getBlock(x, y, z));
    	world.notifyBlocksOfNeighborChange(x, y, z + 1, world.getBlock(x, y, z));
    	world.notifyBlocksOfNeighborChange(x, y, z - 1, world.getBlock(x, y, z));
    	world.notifyBlocksOfNeighborChange(x, y - 1, z, world.getBlock(x, y, z));
    	world.notifyBlocksOfNeighborChange(x, y + 1, z, world.getBlock(x, y, z));
    }
    
    protected void notifyDirectional(World world, int x, int y, int z)
    {
        int l = getDirection(world.getBlockMetadata(x, y, z));

        if (l == 1)
        {
        	world.notifyBlockOfNeighborChange(x + 1, y, z, world.getBlock(x, y, z));
        }

        if (l == 3)
        {
        	world.notifyBlockOfNeighborChange(x - 1, y, z, world.getBlock(x, y, z));
        }

        if (l == 2)
        {
        	world.notifyBlockOfNeighborChange(x, y, z + 1, world.getBlock(x, y, z));
        }

        if (l == 0)
        {
        	world.notifyBlockOfNeighborChange(x, y, z - 1, world.getBlock(x, y, z));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon blockIcon_active;
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 0 ? (Blocks.double_stone_slab.getBlockTextureFromSide(0)) : (side == 1 ? ((meta & 12) > 3 ? this.blockIcon_active : this.blockIcon) : Blocks.double_stone_slab.getBlockTextureFromSide(1));
    }

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.HYPERENERGETIC_REPEATER_OFF);
	    this.blockIcon_active = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.HYPERENERGETIC_REPEATER_ON);
	}
	
	public int getRenderType() {
		return 3368;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityInstantRepeater();
	}
}
