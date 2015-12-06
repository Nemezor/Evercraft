package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import evercraft.NEMESIS13cz.Entity.EntityTravellingItem;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;
import evercraft.NEMESIS13cz.Utils.ItemStackHelper;

public class TileEntityItemPipe extends TileEntity implements IInventory {
    
	public int type;

	public boolean[] allowedSides = new boolean[6];
	
	/**
	 * UP, DOWN, NORTH, SOUTH, WEST, EAST
	 */
	public ForgeDirection[] directions = new ForgeDirection[6];
	
	public Random rand = new Random();
	
	public void setAllowedSide(boolean newSide, int index) {
		this.allowedSides[index] = newSide;
	}
	
	public boolean getAllowedSide(int index) {
		return this.allowedSides[index];
	}
	
	public boolean[] getAllAllowedSides() {
		return this.allowedSides;
	}
	
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        
        this.type = nbt.getShort("type");
        
        this.allowedSides = new boolean[] {nbt.getBoolean("AS0"), nbt.getBoolean("AS1"), nbt.getBoolean("AS2"), nbt.getBoolean("AS3"), nbt.getBoolean("AS4"), nbt.getBoolean("AS5")};
        
    }
    
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        
        nbt.setShort("type", (short)this.type);
        
        nbt.setBoolean("AS0", this.allowedSides[0]);
        nbt.setBoolean("AS1", this.allowedSides[1]);
        nbt.setBoolean("AS2", this.allowedSides[2]);
        nbt.setBoolean("AS3", this.allowedSides[3]);
        nbt.setBoolean("AS4", this.allowedSides[4]);
        nbt.setBoolean("AS5", this.allowedSides[5]);

        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        
        nbt.setTag("Items", nbttaglist);
    }

    private int extractTimer;
            
    public void updateEntity()
    {        
        if (this.worldObj.isRemote)
        {
			if((this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord))) || this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof IInventory) {
				directions[0] = ForgeDirection.UP;
			}else{
				directions[0] = null;
			}
			if((this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord))) || this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof IInventory) {
				directions[1] = ForgeDirection.DOWN;
			}else{
				directions[1] = null;
			}
			if((this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1))) || this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof IInventory) {
				directions[2] = ForgeDirection.NORTH;
			}else{
				directions[2] = null;
			}
			if((this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1))) || this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof IInventory) {
				directions[3] = ForgeDirection.SOUTH;
			}else{
				directions[3] = null;
			}
			if((this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord))) || this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof IInventory) {
				directions[4] = ForgeDirection.WEST;
			}else{
				directions[4] = null;
			}
			if((this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityItemPipe && ItemPipeHandler.canConnectToPipe(type, (TileEntityItemPipe)this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord))) || this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof IInventory) {
				directions[5] = ForgeDirection.EAST;
			}else{
				directions[5] = null;
			}
		}else{
    		if (this.type == ItemPipeHandler.EXTRACTION_1) {
            	extractTimer += 1;
            	
            	if (extractTimer >= 100) {
            		extractTimer = 0;
            		
            		if (this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
                		ItemPipeHandler.extractContents(worldObj, xCoord, yCoord, zCoord, rand, type, allowedSides);
            		}
            		
            	}
    		}else if (this.type == ItemPipeHandler.EXTRACTION_2) {
            	extractTimer += 1;
            	
            	if (extractTimer >= 20) {
            		extractTimer = 0;

            		if (this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
            			ItemPipeHandler.extractContents(worldObj, xCoord, yCoord, zCoord, rand, type, allowedSides);
            		}
            		
            	}
    		}
        }
        
        if (this.type == ItemPipeHandler.ROUTING) {
        	this.allowedSides[0] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[0], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
        	this.allowedSides[1] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[1], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
        	this.allowedSides[2] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[4], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
        	this.allowedSides[3] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[5], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
        	this.allowedSides[4] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[3], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
        	this.allowedSides[5] = !ItemStackHelper.areItemStacksEqual(this.furnaceItemStacks[2], new ItemStack(Evercraft_Items.upgradePipeRouting, 1, 0));
            this.markDirty();
        }
    }
    
    public ItemStack[] furnaceItemStacks = new ItemStack[6];

    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.furnaceItemStacks[par1];
    }
	
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.furnaceItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.furnaceItemStacks[par1];
                this.furnaceItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.furnaceItemStacks[par1].splitStack(par2);

                if (this.furnaceItemStacks[par1].stackSize == 0)
                {
                    this.furnaceItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

	@Override
	public String getInventoryName() {
		return "Routing Pipe";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}
}