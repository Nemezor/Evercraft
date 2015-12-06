package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockHighTemperatureFurnace;
import evercraft.NEMESIS13cz.MachineRecipes.HammeringMachineRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.HighPressureFurnaceRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityMachine;

public class TileEntityHighTemperatureFurnace extends TileEntityMachine implements ISidedInventory
{
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2};
    private static final int[] slots_sides = new int[] {1};

    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] furnaceItemStacks = new ItemStack[4];

    public int maxPower = PowerHandler.highCapacity;
    public int upgradeType;
    private static MachineUpgrades UPGR;

    private ItemStack processedItem;

    public int S2CsyncProcessSpeed;
    
    public boolean isFormed;
    public int isFormed2int;
    private int formTimer = 0;
    public boolean isAdvanced;
    
    /** The number of ticks that the current item has been cooking for */
    public int furnaceCookTime = 0;
    private String field_94130_e;

	public void addPower(int input) {
		this.power += input;
	}
	
	public void setPower(int input) {
		this.power = input;
	}
	

	public boolean isCable = false;
	
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
        return this.hasCustomInventoryName() ? this.field_94130_e : "High Pressure Furnace";
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
        NBTTagList nbttaglist2 = par1NBTTagCompound.getTagList("Processed_Item", 10);
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
        NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist2.getCompoundTagAt(0);
        this.processedItem = ItemStack.loadItemStackFromNBT(nbttagcompound2);

        this.power = par1NBTTagCompound.getInteger("Power");
        this.furnaceCookTime = par1NBTTagCompound.getInteger("CookTime");
        this.upgradeType = par1NBTTagCompound.getInteger("upgrade_type");
        this.flagRS = par1NBTTagCompound.getBoolean("RS");
        this.isFormed = par1NBTTagCompound.getBoolean("isFormed");
        this.isAdvanced = par1NBTTagCompound.getBoolean("advanced");

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
        par1NBTTagCompound.setInteger("Power", this.power);
        par1NBTTagCompound.setInteger("CookTime", this.furnaceCookTime);
        par1NBTTagCompound.setInteger("upgrade_type", this.upgradeType);
        par1NBTTagCompound.setBoolean("RS", this.flagRS);
        par1NBTTagCompound.setBoolean("isFormed", this.isFormed);
        par1NBTTagCompound.setBoolean("advanced", this.isAdvanced);
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

        NBTTagList nbttaglist2 = new NBTTagList();
        
        if (this.processedItem != null) {
	        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
	        nbttagcompound2.setByte("Input_Stack", (byte)0);
	        this.processedItem.writeToNBT(nbttagcompound2);
	        nbttaglist2.appendTag(nbttagcompound2);
        }
        par1NBTTagCompound.setTag("Processed_Item", nbttaglist2);

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
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
    	if (this.S2CsyncProcessSpeed > 0) {
            return this.furnaceCookTime * par1 / S2CsyncProcessSpeed;
    	}else{
    		return 0;
    	}
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
        return this.power > PowerHandler.HTFurnaceConsump - 1;
    }

    private boolean flagRS;
    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity() {
    	super.updateEntity();
    	
        boolean flag = this.hasPower();
        boolean flag1 = false;
        
        if (this.hasPower() && (this.isSmelting() || (!this.isFormed && this.furnaceItemStacks[0] != null && this.furnaceCookTime > 0))) {
        	this.power -= PowerHandler.HTFurnaceConsump;
        }
        
        if (!this.worldObj.isRemote)
        {
            formTimer += 1;
            
            if (formTimer > 99) {
                isFormed = this.Formed(worldObj, xCoord, yCoord, zCoord);
                formTimer = 0;
            }
            if (this.isFormed) {
            	this.isFormed2int = 1;
            }else{
            	this.isFormed2int = 0;
            }
            
            this.upgradeType = this.setUpgradeType(this.furnaceItemStacks[3]);

        	power = PowerHandler.dischargeItem(this.furnaceItemStacks[1], this.maxPower, this.power);
        	
            
            if (this.isItemFuel(this.furnaceItemStacks[1]) && this.power <= (this.maxPower-this.getPower(this.furnaceItemStacks[1])))
            {
                this.power += getPower(this.furnaceItemStacks[1]);

                
                if (this.furnaceItemStacks[1] != null) {
                	flag1 = true;
                	this.furnaceItemStacks[1].stackSize--;
                	if (this.furnaceItemStacks[1].stackSize == 0) {
                		this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
                	}
                	
                }
            }         
            if (this.furnaceCookTime > 0 && !this.isFormed) {
            	this.processedItem = null;
            	this.furnaceCookTime = 0;
            	this.worldObj.createExplosion(this.worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 1), xCoord, yCoord, zCoord, 0, true);
            }
            
            if (this.furnaceCookTime > 0) {
            	S2CsyncProcessSpeed = HighPressureFurnaceRecipes.smelting().getHighTemperatureFurnaceRecipeSpeed(processedItem);
            }else{
            	S2CsyncProcessSpeed = 0;
            }

            if (this.furnaceCookTime == 0) {
            	if (this.setUpgradeType(this.furnaceItemStacks[3]) == UPGR.redstoneUpgradeID) {
                    flagRS = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
            	}else{
            		flagRS = true;
            	}
            }
            if (this.hasPower() && this.canStartSmelting() && flagRS && this.processedItem == null)
            {
            	++this.furnaceCookTime;
            	this.power -= PowerHandler.HTFurnaceConsump;
            	this.consumeInput();
            }
            if (this.hasPower() && this.canContinueSmelting() && flagRS && this.processedItem != null)
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == HighPressureFurnaceRecipes.smelting().getHighTemperatureFurnaceRecipeSpeed(this.processedItem))
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    this.processedItem = null;
                    flag1 = true;
                	this.power -= PowerHandler.HTFurnaceConsump;
                }
            }

            if (!this.isSmelting() || this.isSmelting() || flag != this.hasPower())
            {
                flag1 = true;
                BlockHighTemperatureFurnace.updateFurnaceBlockState(this.isMainTextureOn(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        
        if (flag1)
        {
            this.markDirty();
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
    public boolean Formed(World w,int x, int y, int z) {    	
    			// y = 0
			if (w.getBlock(x + 1, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x + 1, y + 1, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 2, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 2, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 1, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  &&
				// y = 2
				w.getBlock(x + 1, y + 2, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 2, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 2, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 2, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 3, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  &&
				// y = 3
				w.getBlock(x + 1, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x - 1, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x - 1, y + 1, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 2, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 2, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 1, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  &&
				// y = 2
				w.getBlock(x - 1, y + 2, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 2, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 2, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 2, z) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 3, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  &&
				// y = 3
				w.getBlock(x - 1, y + 3,z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z - 1) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z + 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z + 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x, y + 1, z + 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z + 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z + 3) == Evercraft_Blocks.blockcasing1  &&
				// y = 2
				w.getBlock(x, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z + 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z + 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x, y + 2, z + 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z + 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z + 3) == Evercraft_Blocks.blockcasing1  &&
				// y = 3
				w.getBlock(x, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 3) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z - 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z - 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x, y + 1, z - 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 1, z - 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 1, z - 3) == Evercraft_Blocks.blockcasing1  &&
				// y = 2
				w.getBlock(x, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z - 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z - 2) == Evercraft_Blocks.blockcasing1  && w.getBlock(x, y + 2, z - 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x + 1, y + 2, z - 3) == Evercraft_Blocks.blockcasing1  && w.getBlock(x - 1, y + 2, z - 3) == Evercraft_Blocks.blockcasing1  &&
				// y = 3
				w.getBlock(x, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 3) == Evercraft_Blocks.blockcasing2)
			{
				this.isAdvanced = false;
            	return true;
            }
            else 	
            	// y = 0
			if (w.getBlock(x + 1, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x + 1, y + 1, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x + 2, y + 1, z) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 2, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 1, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 2
				w.getBlock(x + 1, y + 2, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x + 2, y + 2, z) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 2, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 2, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 3
				w.getBlock(x + 1, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 3, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 2, y + 3, z) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x - 1, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x - 1, y + 1, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x - 2, y + 1, z) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x - 2, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 1, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 2
				w.getBlock(x - 1, y + 2, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x - 2, y + 1, z) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x - 2, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 2, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  &&
				// y = 3
				w.getBlock(x - 1, y + 3,z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 2, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 3, y + 3, z - 1) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z + 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z + 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x, y + 1, z + 2) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 1, y + 1, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 1, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z + 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 2
				w.getBlock(x, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z + 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x, y + 2, z + 2) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 1, y + 2, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 2, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z + 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 3
				w.getBlock(x, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z + 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z + 3) == Evercraft_Blocks.blockcasing2

				// y = 0
			|| w.getBlock(x, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y, z - 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 1
				w.getBlock(x, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x, y + 1, z - 2) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 1, y + 1, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 1, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 1, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 1, z - 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 2
				w.getBlock(x, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z - 1) == Evercraft_Blocks.blockcasing2 && w.getBlock(x, y + 2, z - 2) == Evercraft_Blocks.blockConductanceCoil  && w.getBlock(x + 1, y + 2, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 2, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 2, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 2, z - 3) == Evercraft_Blocks.blockcasing2  &&
				// y = 3
				w.getBlock(x, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 1) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 2) == Evercraft_Blocks.blockcasing2  && w.getBlock(x, y + 3, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x + 1, y + 3, z - 3) == Evercraft_Blocks.blockcasing2  && w.getBlock(x - 1, y + 3, z - 3) == Evercraft_Blocks.blockcasing2)
			{
				this.isAdvanced = true;
            	return true;
            }else{
            	this.isAdvanced = false;
            	return false;
            }
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canStartSmelting()
    {
        if (this.power <= 0 || this.furnaceItemStacks[0] == null)
        {
            return false;
        }
        if (!isFormed)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = HighPressureFurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
                boolean adv = HighPressureFurnaceRecipes.smelting().isAdvanced(this.furnaceItemStacks[0]);
                if (adv) {
                	if (!this.isAdvanced) {
                		return false;
                	}
                }
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[2] == null) return true;
                if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
            }
    }

    private boolean canContinueSmelting()
    {
        if (this.power <= 0 || this.processedItem == null)
        {
            return false;
        }
        if (!isFormed)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = HighPressureFurnaceRecipes.smelting().getSmeltingResult(this.processedItem);
                boolean adv = HighPressureFurnaceRecipes.smelting().isAdvanced(this.processedItem);
                if (adv) {
                	if (!this.isAdvanced) {
                		return false;
                	}
                }
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[2] == null) return true;
                if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
            }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canContinueSmelting())
        {
            ItemStack itemstack = HighPressureFurnaceRecipes.smelting().getSmeltingResult(this.processedItem);

            if (this.furnaceItemStacks[2] == null)
            {
                this.furnaceItemStacks[2] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[2].isItemEqual(itemstack))
            {
                this.furnaceItemStacks[2].stackSize += itemstack.stackSize;
            }
        }
    }

    public void consumeInput() {

    	this.processedItem = new ItemStack(this.furnaceItemStacks[0].getItem(), 1, this.furnaceItemStacks[0].getItemDamage());
    	
        --this.furnaceItemStacks[0].stackSize;

        if (this.furnaceItemStacks[0].stackSize <= 0)
        {
            this.furnaceItemStacks[0] = null;
        }
    }

    public boolean isMainTextureOn() {
    	ItemStack item = this.furnaceItemStacks[0];
    	if (this.isSmelting() || (this.furnaceItemStacks[0] != null && this.hasPower() && HighPressureFurnaceRecipes.smelting().getSmeltingResult(item) != null && this.furnaceCookTime > 0) && flagRS) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public static int getPower(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            Item item = par0ItemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.glowstone) return PowerHandler.FuelValue * 4;
                if (block == Blocks.redstone_block) return (PowerHandler.FuelValue / 6) * 9;
                
            }

            if (item == Items.glowstone_dust) return PowerHandler.FuelValue;
            if (item == Items.redstone) return PowerHandler.FuelValue / 6;
            if (item == Evercraft_Items.redstonepowder) return PowerHandler.FuelValue / 24;
            if (item == Evercraft_Items.enrichedredstone) return PowerHandler.FuelValue * 2;
            return 0;
        }
    }

    public boolean isSmelting() {
    	if (this.furnaceCookTime > 0) {
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getPower(par0ItemStack) > 0;
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
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
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