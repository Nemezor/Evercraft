package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockAdvancedCrusher;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;

public class TileEntityWirelessRedstoneTransmitter extends TileEntity {

	public int RecX;
	public int RecY;
	public int RecZ;
	public boolean isSet;
	public boolean isActive;
	public int RecXOLD;
	public int RecYOLD;
	public int RecZOLD;
	
	private int shouldCheck = 0;
	
    public void readFromNBT(NBTTagCompound nbttag) {
        super.readFromNBT(nbttag);
        this.RecX = nbttag.getInteger("RecX");
        this.RecY = nbttag.getInteger("RecY");
        this.RecZ = nbttag.getInteger("RecZ");
        this.isSet = nbttag.getBoolean("isSet");
        this.isActive = nbttag.getBoolean("isActive");
    }

    public void writeToNBT(NBTTagCompound nbttag) {
        super.writeToNBT(nbttag);
        nbttag.setInteger("RecX", this.RecX);
        nbttag.setInteger("RecY", this.RecY);
        nbttag.setInteger("RecZ", this.RecZ);
        nbttag.setBoolean("isSet", this.isSet);
        nbttag.setBoolean("isActive", this.isActive);
    }
        
    public void updateEntity() {
    	
        if (!this.worldObj.isRemote) {
        	if (this.isSet) {
        		
        		if (this.RecX != this.RecXOLD || this.RecY != this.RecYOLD || this.RecZ != this.RecZOLD) {
    	            if ((this.worldObj.getBlock(this.RecXOLD, this.RecYOLD, this.RecZOLD) == Evercraft_Blocks.blockWRSreceiverOn || this.worldObj.getBlock(this.RecXOLD, this.RecYOLD, this.RecZOLD) == Evercraft_Blocks.blockWRSreceiverOff) && this.worldObj.getTileEntity(this.RecXOLD, this.RecYOLD, this.RecZOLD) instanceof TileEntityWirelessRedstoneReceiver) {
    	            	TileEntityWirelessRedstoneReceiver receiver = (TileEntityWirelessRedstoneReceiver) this.worldObj.getTileEntity(this.RecXOLD, this.RecYOLD, this.RecZOLD);
    	            	
    	            	receiver.eraseCoordsAndReset();
    	            }
    	        	this.RecXOLD = this.RecX;
    	        	this.RecYOLD = this.RecY;
    	        	this.RecZOLD = this.RecZ;
        		}
        		
	            if ((this.worldObj.getBlock(this.RecX, this.RecY, this.RecZ) == Evercraft_Blocks.blockWRSreceiverOn || this.worldObj.getBlock(this.RecX, this.RecY, this.RecZ) == Evercraft_Blocks.blockWRSreceiverOff) && this.worldObj.getTileEntity(this.RecX, this.RecY, this.RecZ) instanceof TileEntityWirelessRedstoneReceiver) {
	            	TileEntityWirelessRedstoneReceiver receiver = (TileEntityWirelessRedstoneReceiver) this.worldObj.getTileEntity(this.RecX, this.RecY, this.RecZ);
	            		
	            	receiver.getCoordinates(xCoord, yCoord, zCoord);
	            	if (this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
	                	receiver.setActive();
	                	this.setActive();
	            	}else{
	            		receiver.setInactive();
	            		this.setInactive();
	            	}
	            }
	        	this.RecXOLD = this.RecX;
	        	this.RecYOLD = this.RecY;
	        	this.RecZOLD = this.RecZ;
        	}
        }
    }
    
    public void setActive() {
    	this.isActive = true;
    }
    
    public void setInactive() {
    	this.isActive = false;
    }
    
    public void eraseCoordsAndReset() {
    	this.RecX = 0;
    	this.RecY = 0;
    	this.RecZ = 0;
    	this.isSet = false;
    	this.isActive = false;
    }
    
    public void setBroken() {
    	if (this.worldObj.getTileEntity(this.RecX, this.RecY, this.RecZ) != null && this.worldObj.getTileEntity(this.RecX, this.RecY, this.RecZ) instanceof TileEntityWirelessRedstoneReceiver) {
    		TileEntityWirelessRedstoneReceiver tileentity = (TileEntityWirelessRedstoneReceiver) this.worldObj.getTileEntity(this.RecX, this.RecY, this.RecZ);
    		
    		tileentity.setInactive();
    		tileentity.eraseCoordsAndReset();
    	}
    	this.isActive = false;
    	this.RecX = 0;
    	this.RecY = 0;
    	this.RecZ = 0;
    	this.isSet = false;
    }
}