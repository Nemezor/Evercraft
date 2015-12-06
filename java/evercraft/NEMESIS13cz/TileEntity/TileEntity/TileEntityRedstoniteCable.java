package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityAcceptable;
import evercraft.NEMESIS13cz.Utils.TileEntityConductor;
import evercraft.NEMESIS13cz.Utils.TileEntityGenerator;

public class TileEntityRedstoniteCable extends TileEntityConductor {

	public int maxPower = PowerHandler.cableCapacity;

	public int getPower() {
		return MathHelper.floor_double(power);
	}
	
	public int getMaxPower() {
		return maxPower;
	}

	public void addPower(int input) {
		this.power += input;
	}
	
	public void setPower(int input) {
		this.power = input;
	}

	public boolean isCable = true;
	
	/**
	 * UP, DOWN, NORTH, SOUTH, WEST, EAST
	 */
	public ForgeDirection[] directions = new ForgeDirection[6];
	
	public void updateEntity() {
    	super.updateEntity();
    	
		
		//this is here to help draw the cable connections.
		if (worldObj.isRemote) {
			if(this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityGenerator) {
				directions[0] = ForgeDirection.UP;
			}else{
				directions[0] = null;
			}
			if(this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityGenerator) {
				directions[1] = ForgeDirection.DOWN;
			}else{
				directions[1] = null;
			}
			if(this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityGenerator) {
				directions[2] = ForgeDirection.NORTH;
			}else{
				directions[2] = null;
			}
			if(this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityGenerator) {
				directions[3] = ForgeDirection.SOUTH;
			}else{
				directions[3] = null;
			}
			if(this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityGenerator) {
				directions[4] = ForgeDirection.WEST;
			}else{
				directions[4] = null;
			}
			if(this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityAcceptable || this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityGenerator) {
				directions[5] = ForgeDirection.EAST;
			}else{
				directions[5] = null;
			}	
		}else{//This part does the power transmission.
			this.power = PowerHandler.sendPowerViaCable(worldObj, xCoord, yCoord, zCoord, power, PowerHandler.redstoniteCableThroughput);
		}
	}
	
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.power = par1NBTTagCompound.getDouble("Power");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setDouble("Power", this.power);
    }
}
