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
import evercraft.NEMESIS13cz.Blocks.Misc.BlockWirelessRedstone;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;

public class TileEntityWirelessRedstoneReceiver extends TileEntity {

	public int TransX;
	public int TransY;
	public int TransZ;
	public boolean isActive;
	
	private int shouldCheck = 0;

    public void readFromNBT(NBTTagCompound nbttag) {
        super.readFromNBT(nbttag);
        this.TransX = nbttag.getInteger("TransX");
        this.TransY = nbttag.getInteger("TransY");
        this.TransZ = nbttag.getInteger("TransZ");
        this.isActive = nbttag.getBoolean("isActive");
    }

    public void writeToNBT(NBTTagCompound nbttag) {
        super.writeToNBT(nbttag);
        nbttag.setInteger("TransX", this.TransX);
        nbttag.setInteger("TransY", this.TransY);
        nbttag.setInteger("TransZ", this.TransZ);
        nbttag.setBoolean("isActive", this.isActive);
    }
        
    public void updateEntity() {
    	
        if (!this.worldObj.isRemote) { 
        	BlockWirelessRedstone.updateBlockState(isActive, worldObj, xCoord, yCoord, zCoord);
        }
    }
    
    public void setActive() {
    	this.isActive = true;
    }
    
    public void setInactive() {
    	this.isActive = false;
    }

    public void eraseCoordsAndReset() {
		this.TransX = 0;
		this.TransY = 0;
		this.TransZ = 0;
    	this.isActive = false;
    }
    
    public void setBroken() {
    	if (this.worldObj.getTileEntity(this.TransX, this.TransY, this.TransZ) != null && this.worldObj.getTileEntity(this.TransX, this.TransY, this.TransZ) instanceof TileEntityWirelessRedstoneTransmitter) {
    		TileEntityWirelessRedstoneTransmitter tileentity = (TileEntityWirelessRedstoneTransmitter) this.worldObj.getTileEntity(this.TransX, this.TransY, this.TransZ);
    		
    		tileentity.setInactive();
    		tileentity.eraseCoordsAndReset();
    	}
    	this.isActive = false;
    	this.TransX = 0;
    	this.TransY = 0;
    	this.TransZ = 0;
    }
    
    public void getCoordinates(int x, int y, int z) {
    	this.TransX = x;
    	this.TransY = y;
    	this.TransZ = z;
    }
}