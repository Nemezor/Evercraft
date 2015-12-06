package evercraft.NEMESIS13cz.Blocks.Machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;

public class BlockItemPipe extends BlockContainer
{
	private float pixel = 1F/16F;
    
	public boolean[] allowedSides = new boolean[] {true, true, true, true, true, true};
	
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private final Random furnaceRand = new Random();

    public int type;
    
    public BlockItemPipe(int pipeType) {
        super(Material.iron);
    	this.type = pipeType;
    }

    public int getRenderType() {
    	return -1;
    }

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    if (this.type == ItemPipeHandler.EXTRACTION_1) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.EXTRACTIONPIPE_1_ITEM);
	    if (this.type == ItemPipeHandler.EXTRACTION_2) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.EXTRACTIONPIPE_2_ITEM);
	    if (this.type == ItemPipeHandler.TRANSPORT_1) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.TRANSPORTPIPE_1_ITEM);
	    if (this.type == ItemPipeHandler.TRANSPORT_2) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.TRANSPORTPIPE_2_ITEM);
	    if (this.type == ItemPipeHandler.ROUTING) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.ROUTINGPIPE_ITEM);
	    if (this.type == ItemPipeHandler.TRANSPORT_FAST) this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.TRANSPORTPIPE_FAST_ITEM);
	}

    public boolean isOpaqueCube() {
    	return false;
    }

    public boolean renderAsNormalBlock() {
    	return false;
    }

public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
	
	float maxX = pixel*5;
	float maxY = pixel*5;
	float maxZ = pixel*5;
	float minX = 1 - pixel*5;
	float minY = 1 - pixel*5;
	float minZ = 1 - pixel*5;
	
	if((world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y + 1, z))) || world.getTileEntity(x, y + 1, z) instanceof IInventory) {
		minY = 1;
	}
	if((world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y - 1, z))) || world.getTileEntity(x, y - 1, z) instanceof IInventory) {
		maxY = 0;
	}
	if((world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x + 1, y, z))) || world.getTileEntity(x + 1, y, z) instanceof IInventory) {
		minX = 1;
	}
	if((world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x - 1, y, z))) || world.getTileEntity(x - 1, y, z) instanceof IInventory) {
		maxX = 0;
	}
	if((world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y, z + 1))) || world.getTileEntity(x, y, z + 1) instanceof IInventory) {
		minZ = 1;
	}
	if((world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y, z - 1))) || world.getTileEntity(x, y, z - 1) instanceof IInventory) {
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

	if((world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y + 1, z))) || world.getTileEntity(x, y + 1, z) instanceof IInventory) {
		minY1 = 1;
	}
	if((world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y - 1, z))) || world.getTileEntity(x, y - 1, z) instanceof IInventory) {
		maxY1 = 0;
	}
	if((world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x + 1, y, z))) || world.getTileEntity(x + 1, y, z) instanceof IInventory) {
		minX1 = 1;
	}
	if((world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x - 1, y, z))) || world.getTileEntity(x - 1, y, z) instanceof IInventory) {
		maxX1 = 0;
	}
	if((world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y, z + 1))) || world.getTileEntity(x, y, z + 1) instanceof IInventory) {
		minZ1 = 1;
	}
	if((world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)world.getTileEntity(x, y, z - 1))) || world.getTileEntity(x, y, z - 1) instanceof IInventory) {
		maxZ1 = 0;
	}
	
	setBlockBounds(maxX1, maxY1, maxZ1, minX1, minY1, minZ1);
	
	return AxisAlignedBB.getBoundingBox(x+minX, y+minY, z+minZ, x+maxX, y+maxY, z+maxZ);
}

public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
{
    	TileEntityItemPipe tileentityfurnace = (TileEntityItemPipe)par1World.getTileEntity(par2, par3, par4);

        if (tileentityfurnace != null)
        {
            for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0)
                    {
                        int k1 = this.furnaceRand.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
                        par1World.spawnEntityInWorld(entityitem);
                    }
                }

            par1World.func_147453_f(par2, par3, par4, par5);
        }
    }

    super.breakBlock(par1World, par2, par3, par4, par5, par6);
}

    public Item getItemDropped(int par1, Random par2Random, int par3) {
    	if (this.type == ItemPipeHandler.EXTRACTION_1) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeExtraction1);
    	}else if (this.type == ItemPipeHandler.EXTRACTION_2) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeExtraction2);
    	}else if (this.type == ItemPipeHandler.TRANSPORT_1){
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeNormal_1);
    	}else if (this.type == ItemPipeHandler.ROUTING) {
    		return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeCrossing);
    	}else if (this.type == ItemPipeHandler.TRANSPORT_FAST) {
    		return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeFast);
    	}else{
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeNormal_2);
    	}
    }
    
    public int quantityDropped(Random random) {
    	return 1;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntityItemPipe tileentityfurnace = (TileEntityItemPipe)world.getTileEntity(x, y, z);
    	if (tileentityfurnace.type == ItemPipeHandler.ROUTING && player.getCurrentEquippedItem() == null) {
	        if (world.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	            if (tileentityfurnace != null)
	            {
	            	player.openGui(Evercraft.getEvercraft(), 3, world, x, y, z);
	            }
	
	            return true;
	        }
    	}else{
    		return false;
    	}
	}

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World, int par2) {
    	TileEntityItemPipe pipe = new TileEntityItemPipe();
    	pipe.type = this.type;
    	return pipe;
    }
    
    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */

    public boolean hasComparatorInputOverride()
    {
        return false;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public Item getItem(World par1World, int par2, int par3, int par4) {
    	if (this.type == ItemPipeHandler.EXTRACTION_1) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeExtraction1);
    	}else if (this.type == ItemPipeHandler.EXTRACTION_2) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeExtraction2);
    	}else if (this.type == ItemPipeHandler.TRANSPORT_1){
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeNormal_1);
    	}else if (this.type == ItemPipeHandler.ROUTING) {
    		return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeCrossing);
    	}else if (this.type == ItemPipeHandler.TRANSPORT_FAST) {
    		return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeFast);
    	}else{
        	return Item.getItemFromBlock(Evercraft_Blocks.blockItemPipeNormal_2);
    	}
    }
}
