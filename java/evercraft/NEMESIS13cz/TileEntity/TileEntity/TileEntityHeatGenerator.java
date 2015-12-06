package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockHeatGenerator;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityGenerator;
import evercraft.NEMESIS13cz.Utils.TileEntityMachine;

public class TileEntityHeatGenerator extends TileEntityGenerator implements ISidedInventory
{
    private static final int[] slots_top = new int[] {1, 2};
    private static final int[] slots_bottom = new int[] {1, 3};
    private static final int[] slots_sides = new int[] {0};

    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] furnaceItemStacks = new ItemStack[4];
	
	public ArrayList<TileEntityMachine> machines = new ArrayList<TileEntityMachine>();

    public int maxPower = PowerHandler.mediumCapacity * 2;

    public int burning;
    public int burningMax;
    
    public  int timeToDamage;
    
    private String field_94130_e;


    
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
        return this.hasCustomInventoryName() ? this.field_94130_e : "Heat Generator";
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
        this.burning = par1NBTTagCompound.getInteger("FuelValue");
        this.burningMax = par1NBTTagCompound.getInteger("FuelMax");
        this.timeToDamage = par1NBTTagCompound.getInteger("timeToDamage");

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
        par1NBTTagCompound.setInteger("FuelValue", this.burning);
        par1NBTTagCompound.setInteger("FuelMax", this.burningMax);
        par1NBTTagCompound.setInteger("timeToDamage", this.timeToDamage);
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
    public int getBurnTimeRemainingScaled(int par1) {
    	return (int)this.power * par1 / this.maxPower;
    }

    @SideOnly(Side.CLIENT)
    public int getFuelTimeRemainingScaled(int par1) {
    	if (this.burningMax > 0) {
            return this.burning * par1 / this.burningMax;
    	}else{
    		return 0;
    	}
    }
    
    public boolean hasPower()
    {
        return this.power > 0;
    }
    
    public boolean hasFuel()
    {
        return this.burning > 4;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity() {
    	super.updateEntity();
    	
        boolean flag = this.hasPower();
        float flag2 = this.burning;
        boolean flag1 = false;
        boolean flagSent = false;
        
        if (this.hasFuel()) {
        	if (this.furnaceItemStacks[2] != null && (this.furnaceItemStacks[2].getItem() == Evercraft_Items.ashFilter && this.furnaceItemStacks[2].getItemDamage() < 1000)) {
            	this.power += 5;
            	this.burning -= 5;
        	}else{
        		this.burning = 0;
        		this.burningMax = 0;
        	}
        }else{
        	this.burningMax = 0;
        }
        
        if (!this.worldObj.isRemote)
        {        	
        	if (this.hasFuel()) {
        		this.timeToDamage += 1;
        	}
        	
        	if (this.timeToDamage > PowerHandler.ironAshFilterDurability) {
            	if (this.furnaceItemStacks[2] != null && this.furnaceItemStacks[2].getItem() == Evercraft_Items.ashFilter) {
            		if (this.furnaceItemStacks[2].getItemDamage() < 1000) {
            			this.furnaceItemStacks[2] = new ItemStack(Evercraft_Items.ashFilter, 1, this.furnaceItemStacks[2].getItemDamage() + 1);
            		}else{
            			this.furnaceItemStacks[2] = null;
            		}
            		if (this.furnaceItemStacks[3] == null) {
            			this.furnaceItemStacks[3] = new ItemStack(Evercraft_Items.ash, 1, 0);
            		}else if(this.furnaceItemStacks[3].isItemEqual(new ItemStack(Evercraft_Items.ash, 1, 0)) && this.furnaceItemStacks[3].stackSize < 64) {
            			this.furnaceItemStacks[3].stackSize += 1;
            		}
            	}
        		this.timeToDamage = 0;
        	}
        	
            if (this.isItemFuel(this.furnaceItemStacks[0]) && this.power <= (this.maxPower - this.getItemBurnTime(this.furnaceItemStacks[0])) && !this.hasFuel() && this.furnaceItemStacks[2] != null && (this.furnaceItemStacks[2].getItem() == Evercraft_Items.ashFilter && this.furnaceItemStacks[2].getItemDamage() < 1000) && (this.furnaceItemStacks[3] == null || (this.furnaceItemStacks[3].isItemEqual(new ItemStack(Evercraft_Items.ash, 1, 0)) && this.furnaceItemStacks[3].stackSize < 64)))
            {
                this.burning = this.getItemBurnTime(this.furnaceItemStacks[0]);
                this.burningMax = this.burning;
                this.timeToDamage += 1;
                
                if (this.furnaceItemStacks[0] != null) {
                	flag1 = true;
                	this.furnaceItemStacks[0].stackSize--;
                	if (this.furnaceItemStacks[0].stackSize == 0) {
                		this.furnaceItemStacks[0] = this.furnaceItemStacks[0].getItem().getContainerItem(this.furnaceItemStacks[0]);
                	}
                }
            }
            
        	power = PowerHandler.dischargeItem(this.furnaceItemStacks[0], this.maxPower, this.power);
            power = PowerHandler.chargeItem(this.furnaceItemStacks[1], this.maxPower, this.power, this.hasPower());

            int currPower = this.power;
            
            power = PowerHandler.sendPower(worldObj, xCoord, yCoord, zCoord, power);
            
            if (currPower != this.power) {
            	flagSent = true;
            }
            
            if (flag != this.hasPower() || flag2 != this.burning) {
                flag1 = true;
                if (this.hasPower()) {
                	if (this.hasFuel()) {
                        BlockHeatGenerator.updateFurnaceBlockState(2, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                	}else{
                        BlockHeatGenerator.updateFurnaceBlockState(1, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                	}
                }else{
                    BlockHeatGenerator.updateFurnaceBlockState(0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                }
            }
        }
        
        if (flag1)
        {
            this.markDirty();
        }
    }

    public static int getItemBurnTime(ItemStack stack) {
        if (stack == null)
        {
            return 0;
        }
        else
        {
        	return TileEntityFurnace.getItemBurnTime(stack) * PowerHandler.heatGeneratorFuelMultiplier;
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_) {
        return getItemBurnTime(p_145954_0_) > 0;
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
        return par1 == 3 ? false : (par1 == 0 ? isItemFuel(par2ItemStack) : true);
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