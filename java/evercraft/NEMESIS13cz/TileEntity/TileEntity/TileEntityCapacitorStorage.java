package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityMachine;

public class TileEntityCapacitorStorage extends TileEntityMachine implements ISidedInventory
{
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {0, 1};
    private static final int[] slots_sides = new int[] {1};
    
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] furnaceItemStacks = new ItemStack[3];

    private String field_94130_e;
    public int maxPower = PowerHandler.highCapacity * 3;
    public int upgradeType;
    private static MachineUpgrades UPGR;

	public boolean isCable = false;

	public boolean isSideValidForEnergy(int side) {
		if (side == this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)) {
			return false;
		}else{
			return true;
		}
	}
	
	public void addPower(int input) {
		this.power += input;
	}
	
	public void setPower(int input) {
		this.power = input;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
    
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.furnaceItemStacks[par1];
    }
    public void setGuiDisplayName(String par1Str)
    {
        this.field_94130_e = par1Str;
    }
    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
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

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
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

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_94130_e : "Capacitor Array";
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean hasCustomInventoryName()
    {
        return this.field_94130_e != null && this.field_94130_e.length() > 0;
    }

    public void func_94129_a(String par1Str)
    {
        this.field_94130_e = par1Str;
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
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
        this.power = par1NBTTagCompound.getInteger("power");
        this.upgradeType = par1NBTTagCompound.getInteger("upgrade_type");
        this.flagRS = par1NBTTagCompound.getBoolean("RS");

        if (par1NBTTagCompound.hasKey("CustomName", 8))
        {
            this.field_94130_e = par1NBTTagCompound.getString("CustomName");
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("power", this.power);
        par1NBTTagCompound.setInteger("upgrade_type", this.upgradeType);
        par1NBTTagCompound.setBoolean("RS", this.flagRS);
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
        
        par1NBTTagCompound.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
        	par1NBTTagCompound.setString("CustomName", this.field_94130_e);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1) {
    	return (int)this.power * par1 / this.maxPower;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean hasPower()
    {
        return this.power > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    
    private boolean flagRS;
        
    public void updateEntity() {
    	super.updateEntity();
    	
        if (!this.worldObj.isRemote)
        {	        	
            this.upgradeType = this.setUpgradeType(this.furnaceItemStacks[2]);
            
        	power = PowerHandler.dischargeItem(this.furnaceItemStacks[0], this.maxPower, this.power);
        	power = PowerHandler.chargeItem(this.furnaceItemStacks[1], this.maxPower, this.power, this.hasPower());
        	            
            if (this.setUpgradeType(this.furnaceItemStacks[2]) == UPGR.redstoneUpgradeID) {
            	flagRS = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
            }else{
            	flagRS = true;
            }
            
            if (flagRS && this.hasPower()) {
            	int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
            	
            	if (metadata == 0) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord, yCoord - 1, zCoord, this.power);
            	}else if (metadata == 1) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord, yCoord + 1, zCoord, this.power);
            	}else if (metadata == 2) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord, yCoord, zCoord - 1, this.power);
            	}else if (metadata == 3) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord, yCoord, zCoord + 1, this.power);
            	}else if (metadata == 4) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord - 1, yCoord, zCoord, this.power);
            	}else if (metadata == 5) {
                	this.power = PowerHandler.sendPowerToSpecifiedBlock(worldObj, xCoord + 1, yCoord, zCoord, this.power);
            	}
            }
        }
    }

    private int setUpgradeType(ItemStack stack) {
    	if (stack == null) return UPGR.noUpgradeID;
    	if (stack.isItemEqual(new ItemStack(Evercraft_Items.upgradeRedstone, 1, 0))) return UPGR.redstoneUpgradeID;
    	
    	return UPGR.noUpgradeID;
    }
    
    public static boolean isUpgrade(ItemStack stack) {
    	if (stack.isItemEqual(new ItemStack(Evercraft_Items.upgradeRedstone, 1, 0))) return true;
    	
    	return false;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }
}