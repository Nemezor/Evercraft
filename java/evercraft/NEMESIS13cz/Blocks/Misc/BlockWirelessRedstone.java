package evercraft.NEMESIS13cz.Blocks.Misc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.ModInformation;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityWirelessRedstoneReceiver;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityWirelessRedstoneTransmitter;

public class BlockWirelessRedstone extends BlockContainer
{	
    private final boolean isTransmitter;
    private final boolean isPowered;

    private static boolean shouldNotBeUpdated;

    @SideOnly(Side.CLIENT)
    private IIcon blockSide;
    
    public BlockWirelessRedstone(boolean par1, boolean par2)
    {
        super(Material.iron);
        this.isTransmitter = par1;
        this.isPowered = par2;
    }
    
    public Item getItemDropped(int par1, Random par2Random, int par3) {
    	if (this.isTransmitter) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockWRStransmitter);
    	}else{
        	return Item.getItemFromBlock(Evercraft_Blocks.blockWRSreceiverOff);
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.blockIcon : (par1 == 0 ? this.blockIcon : this.blockSide);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(ModInformation.TEXTUREPATH + ":" + ModInformation.MACHINE_TOP);
        this.blockSide = par1IconRegister.registerIcon(this.isTransmitter ? (ModInformation.TEXTUREPATH + ":" + ModInformation.WIRELESS_TRANSMITTER_SIDE) : (this.isPowered ? (ModInformation.TEXTUREPATH + ":" + ModInformation.WIRELESS_RECEIVER_ON_SIDE) : (ModInformation.TEXTUREPATH + ":" + ModInformation.WIRELESS_RECEIVER_OFF_SIDE)));
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {    	
        if (world.isRemote) {
            return true;
        }else{
        	ItemStack currentStack = player.getCurrentEquippedItem();
        	
        	//Reset Transmitter
        	if (currentStack == null && player.isSneaking() && world.getTileEntity(x, y, z) instanceof TileEntityWirelessRedstoneTransmitter) {
        		TileEntityWirelessRedstoneTransmitter tileentity = (TileEntityWirelessRedstoneTransmitter) world.getTileEntity(x, y, z);
    			tileentity.setBroken();
        	}
        	
        	if (currentStack != null) {
        		
        		//getReceiverCoords
	        	if (world.getTileEntity(x, y, z) instanceof TileEntityWirelessRedstoneReceiver && currentStack.isItemEqual(new ItemStack(Evercraft_Items.WRScoordinator)) && currentStack.stackTagCompound.getInteger("charge") > 9) {
	        		TileEntityWirelessRedstoneReceiver tileentity = (TileEntityWirelessRedstoneReceiver) world.getTileEntity(x, y, z);
	        		if (currentStack.stackTagCompound == null) {
	        			currentStack.stackTagCompound = new NBTTagCompound();
	        		}
	        		currentStack.stackTagCompound.setInteger("x", x);
	        		currentStack.stackTagCompound.setInteger("y", y);
	        		currentStack.stackTagCompound.setInteger("z", z);
	        		currentStack.stackTagCompound.setBoolean("isSet", true);
        			int charge = currentStack.stackTagCompound.getInteger("charge");
        			currentStack.stackTagCompound.setInteger("charge", charge - 10);
	        		
	        	//Give Coords to the Transmitter
	        	}else if (world.getTileEntity(x, y, z) instanceof TileEntityWirelessRedstoneTransmitter && currentStack.isItemEqual(new ItemStack(Evercraft_Items.WRScoordinator)) && currentStack.stackTagCompound.getInteger("charge") > 9) {
	        		TileEntityWirelessRedstoneTransmitter tileentity = (TileEntityWirelessRedstoneTransmitter) world.getTileEntity(x, y, z);
	        		if (currentStack.stackTagCompound == null) {
	        			currentStack.stackTagCompound = new NBTTagCompound();
	        		}
	        		if (currentStack.stackTagCompound.getBoolean("isSet")) {
	        			tileentity.isSet = true;
	        			tileentity.RecX = currentStack.stackTagCompound.getInteger("x");
	        			tileentity.RecY = currentStack.stackTagCompound.getInteger("y");
	        			tileentity.RecZ = currentStack.stackTagCompound.getInteger("z");
	        			int charge = currentStack.stackTagCompound.getInteger("charge");
	        			currentStack.stackTagCompound.setInteger("charge", charge - 10);
	        		}
	        	}
        	}
            return true;
        }
    }
    
    public boolean canProvidePower() {
    	if (!this.isTransmitter) {
            return true;
    	}else{
    		return false;
    	}
    }

    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int p_149709_5_) {
    	if (this.isPowered) {
    		return 15;
    	}else{
    		return 0;
    	}
    }
    
    public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
    	TileEntityWirelessRedstoneReceiver tileentity = (TileEntityWirelessRedstoneReceiver)par1World.getTileEntity(par2, par3, par4);
    	int x = tileentity.TransX;
    	int y = tileentity.TransY;
    	int z = tileentity.TransZ;
    	shouldNotBeUpdated = true;
    	
        if (par0)
        {
            par1World.setBlock(par2, par3, par4, Evercraft_Blocks.blockWRSreceiverOn);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, Evercraft_Blocks.blockWRSreceiverOff);
        }

    	shouldNotBeUpdated = false;
        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
            tileentity.TransX = x;
            tileentity.TransY = y;
            tileentity.TransZ = z;
        }
    }
    
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
    	if (world.getTileEntity(x, y, z) instanceof TileEntityWirelessRedstoneReceiver && !this.shouldNotBeUpdated) {
    		TileEntityWirelessRedstoneReceiver tileentity1 = (TileEntityWirelessRedstoneReceiver) world.getTileEntity(x, y, z);
    		
    		tileentity1.setBroken();
    	}
    	if (world.getTileEntity(x, y, z) instanceof TileEntityWirelessRedstoneTransmitter) {
    		TileEntityWirelessRedstoneTransmitter tileentity1 = (TileEntityWirelessRedstoneTransmitter) world.getTileEntity(x, y, z);
    		
    		tileentity1.setBroken();
    	}
    	
        super.breakBlock(world, x, y, z, par5, par6);
    }

    public TileEntity createNewTileEntity(World par1World, int par2) {
    	if (this.isTransmitter) {
    		return new TileEntityWirelessRedstoneTransmitter();
    	}else{
            return new TileEntityWirelessRedstoneReceiver();
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
    	if (this.isTransmitter) {
        	return Item.getItemFromBlock(Evercraft_Blocks.blockWRStransmitter);
    	}else{
        	return Item.getItemFromBlock(Evercraft_Blocks.blockWRSreceiverOff);
    	}
    }
}
