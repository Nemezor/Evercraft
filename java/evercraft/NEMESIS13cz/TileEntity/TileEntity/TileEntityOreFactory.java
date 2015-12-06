package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockOreFactory;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedElectrolyzerRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityMachine;

public class TileEntityOreFactory extends TileEntityMachine implements ISidedInventory
{
    private static final int[] slots_top = new int[] {0, 1, 2};
    private static final int[] slots_bottom = new int[] {5, 6};
    private static final int[] slots_sides = new int[] {3};

    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] furnaceItemStacks = new ItemStack[8];

    public int maxPower = PowerHandler.extremeCapacity;
    public int upgradeType;
    private static MachineUpgrades UPGR;

    private ItemStack processedItemElectrolyzing;
    private ItemStack processedItemSmelting;
    private ItemStack processedItemCrushing;
    
    public int furnaceCookTimeElectrolyzing = 0;
    public int furnaceCookTimeCrushing = 0;
    public int furnaceCookTimeSmelting = 0;
    
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
        return this.hasCustomInventoryName() ? this.field_94130_e : "Ore Processing Plant";
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
        NBTTagList nbttaglist2 = par1NBTTagCompound.getTagList("Processed_Item_Electrolyzing", 10);
        NBTTagList nbttaglist3 = par1NBTTagCompound.getTagList("Processed_Item_Crushing", 10);
        NBTTagList nbttaglist4 = par1NBTTagCompound.getTagList("Processed_Item_Smelting", 10);
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
        this.processedItemElectrolyzing = ItemStack.loadItemStackFromNBT(nbttagcompound2);
        NBTTagCompound nbttagcompound3 = (NBTTagCompound)nbttaglist3.getCompoundTagAt(0);
        this.processedItemCrushing = ItemStack.loadItemStackFromNBT(nbttagcompound3);
        NBTTagCompound nbttagcompound4 = (NBTTagCompound)nbttaglist4.getCompoundTagAt(0);
        this.processedItemSmelting = ItemStack.loadItemStackFromNBT(nbttagcompound4);

        this.power = par1NBTTagCompound.getInteger("Power");
        this.furnaceCookTimeElectrolyzing = par1NBTTagCompound.getInteger("CookTime_Electrolyzing");
        this.furnaceCookTimeCrushing = par1NBTTagCompound.getInteger("CookTime_Crushing");
        this.furnaceCookTimeSmelting = par1NBTTagCompound.getInteger("CookTime_Smelting");
        this.upgradeType = par1NBTTagCompound.getInteger("upgrade_type");
        this.flagRSFurnace = par1NBTTagCompound.getBoolean("RSA");
        this.flagRSElectrolyzer = par1NBTTagCompound.getBoolean("RSB");
        this.flagRSCrusher = par1NBTTagCompound.getBoolean("RSC");

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
        par1NBTTagCompound.setInteger("CookTime_Electrolyzing", this.furnaceCookTimeElectrolyzing);
        par1NBTTagCompound.setInteger("CookTime_Crushing", this.furnaceCookTimeCrushing);
        par1NBTTagCompound.setInteger("CookTime_Smelting", this.furnaceCookTimeSmelting);
        par1NBTTagCompound.setInteger("upgrade_type", this.upgradeType);
        par1NBTTagCompound.setBoolean("RSA", this.flagRSFurnace);
        par1NBTTagCompound.setBoolean("RSB", this.flagRSElectrolyzer);
        par1NBTTagCompound.setBoolean("RSC", this.flagRSCrusher);
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
        
        if (this.processedItemElectrolyzing != null) {
	        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
	        nbttagcompound2.setByte("Input_Stack", (byte)0);
	        this.processedItemElectrolyzing.writeToNBT(nbttagcompound2);
	        nbttaglist2.appendTag(nbttagcompound2);
        }
        par1NBTTagCompound.setTag("Processed_Item_Electrolyzing", nbttaglist2);

        NBTTagList nbttaglist3 = new NBTTagList();
        
        if (this.processedItemCrushing != null) {
	        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
	        nbttagcompound2.setByte("Input_Stack", (byte)0);
	        this.processedItemCrushing.writeToNBT(nbttagcompound2);
	        nbttaglist2.appendTag(nbttagcompound2);
        }
        par1NBTTagCompound.setTag("Processed_Item_Crushing", nbttaglist3);

        NBTTagList nbttaglist4 = new NBTTagList();
        
        if (this.processedItemSmelting != null) {
	        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
	        nbttagcompound2.setByte("Input_Stack", (byte)0);
	        this.processedItemSmelting.writeToNBT(nbttagcompound2);
	        nbttaglist2.appendTag(nbttagcompound2);
        }
        par1NBTTagCompound.setTag("Processed_Item_Smelting", nbttaglist4);
        
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
    public int getCookProgressScaledElectrolyzing(int par1)
    {
        return this.furnaceCookTimeElectrolyzing * par1 / (PowerHandler.AdvElectrolyzerSpeed * 2);
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaledCrushing(int par1)
    {
        return this.furnaceCookTimeCrushing * par1 / PowerHandler.AdvCrusherSpeed;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaledSmelting(int par1)
    {
        return this.furnaceCookTimeSmelting * par1 / PowerHandler.AdvFurnaceSpeed;
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
        return (this.power > PowerHandler.AdvElectrolyzerConsump / 2 - 1 && this.power > PowerHandler.AdvCrusherConsump - 1 && this.power > PowerHandler.AdvFurnaceConsump);
    }

    private boolean flagRSFurnace;
    private boolean flagRSElectrolyzer;
    private boolean flagRSCrusher;
    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity() {
    	super.updateEntity();
    	
        boolean flag = this.hasPower();
        boolean flag1 = false;
        
        if (this.hasPower() && this.isElectrolyzing()) {
        	this.power -= PowerHandler.AdvElectrolyzerConsump / 2;
        }
        if (this.hasPower() && this.isCrushing()) {
        	this.power -= PowerHandler.CrusherConsump;
        }
        if (this.hasPower() && this.isSmelting()) {
        	this.power -= PowerHandler.AdvFurnaceConsump;
        }
        
        if (!this.worldObj.isRemote)
        {        	
            this.upgradeType = this.setUpgradeType(this.furnaceItemStacks[7]);

        	power = PowerHandler.dischargeItem(this.furnaceItemStacks[3], this.maxPower, this.power);
        	
            if (this.isItemFuel(this.furnaceItemStacks[3]) && this.power <= (this.maxPower-this.getPower(this.furnaceItemStacks[3])))
            {
                this.power += getPower(this.furnaceItemStacks[3]);

                
                if (this.furnaceItemStacks[3] != null) {
                	flag1 = true;
                	this.furnaceItemStacks[3].stackSize--;
                	if (this.furnaceItemStacks[3].stackSize == 0) {
                		this.furnaceItemStacks[3] = this.furnaceItemStacks[3].getItem().getContainerItem(this.furnaceItemStacks[3]);
                	}
                	
                }
            }
            if (this.furnaceCookTimeCrushing == 0) {
            	if (this.setUpgradeType(this.furnaceItemStacks[7]) == UPGR.redstoneUpgradeID) {
            		flagRSCrusher = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
            	}else{
            		flagRSCrusher = true;
            	}
            }
            if (this.furnaceCookTimeElectrolyzing == 0) {
            	if (this.setUpgradeType(this.furnaceItemStacks[7]) == UPGR.redstoneUpgradeID) {
            		flagRSElectrolyzer = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
            	}else{
            		flagRSElectrolyzer = true;
            	}
            }
            if (this.furnaceCookTimeSmelting == 0) {
            	if (this.setUpgradeType(this.furnaceItemStacks[7]) == UPGR.redstoneUpgradeID) {
            		flagRSFurnace = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
            	}else{
            		flagRSFurnace = true;
            	}
            }
            if (this.hasPower() && this.canStartCrushing() && flagRSCrusher && this.processedItemCrushing == null)
            {
            	++this.furnaceCookTimeCrushing;
            	this.power -= PowerHandler.AdvCrusherConsump;
            	this.consumeInput0();
            }
            if (this.hasPower() && this.canStartElectrolyzing() && flagRSElectrolyzer && this.processedItemElectrolyzing == null)
            {
            	++this.furnaceCookTimeElectrolyzing;
            	this.power -= PowerHandler.AdvElectrolyzerConsump / 2;
            	this.consumeInput1();
            }
            if (this.hasPower() && this.canStartSmelting() && flagRSFurnace && this.processedItemSmelting == null)
            {
            	++this.furnaceCookTimeSmelting;
            	this.power -= PowerHandler.AdvFurnaceConsump;
            	this.consumeInput2();
            }
            if (this.hasPower() && this.canContinueCrushing() && flagRSCrusher && this.processedItemCrushing != null)
            {
                ++this.furnaceCookTimeCrushing;

                if (this.furnaceCookTimeCrushing == PowerHandler.AdvCrusherSpeed)
                {
                    this.furnaceCookTimeCrushing = 0;
                    this.crushItem();
                    this.processedItemCrushing = null;
                    flag1 = true;
                    this.power -= PowerHandler.AdvCrusherConsump;
                }
            }
            if (this.hasPower() && this.canContinueElectrolyzing() && flagRSElectrolyzer && this.processedItemElectrolyzing != null)
            {
                ++this.furnaceCookTimeElectrolyzing;

                if (this.furnaceCookTimeElectrolyzing == PowerHandler.AdvElectrolyzerSpeed * 2)
                {
                    this.furnaceCookTimeElectrolyzing = 0;
                    this.electrolyzeItem();
                    this.processedItemElectrolyzing = null;
                    flag1 = true;
                    this.power -= PowerHandler.AdvElectrolyzerConsump / 2;
                }
            }
            if (this.hasPower() && this.canContinueSmelting() && flagRSFurnace && this.processedItemSmelting != null)
            {
                ++this.furnaceCookTimeSmelting;

                if (this.furnaceCookTimeSmelting == PowerHandler.AdvFurnaceSpeed)
                {
                    this.furnaceCookTimeSmelting = 0;
                    this.smeltItem();
                    this.processedItemSmelting = null;
                    flag1 = true;
                    this.power -= PowerHandler.AdvFurnaceConsump;
                }
            }

            if (this.furnaceItemStacks[4] != null) {
            	if (AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(this.furnaceItemStacks[4]) != null && (this.furnaceItemStacks[1] == null || this.furnaceItemStacks[4].isItemEqual(this.furnaceItemStacks[1]))) {
            		if (this.furnaceItemStacks[1] == null) {
            			this.furnaceItemStacks[1] = new ItemStack(this.furnaceItemStacks[4].getItem(), 1, this.furnaceItemStacks[4].getItemDamage());
            			if (this.furnaceItemStacks[4].stackSize > 1) {
            				this.furnaceItemStacks[4].stackSize -= 1;
            			}else{
            				this.furnaceItemStacks[4] = null;
            			}
            		}else{
            			this.furnaceItemStacks[1].stackSize += 1;
            			if (this.furnaceItemStacks[4].stackSize > 1) {
            				this.furnaceItemStacks[4].stackSize -= 1;
            			}else{
            				this.furnaceItemStacks[4] = null;
            			}
            		}
            	}else if (FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[4]) != null && (this.furnaceItemStacks[2] == null || this.furnaceItemStacks[4].isItemEqual(this.furnaceItemStacks[2]))) {
                		if (this.furnaceItemStacks[2] == null) {
                			this.furnaceItemStacks[2] = new ItemStack(this.furnaceItemStacks[4].getItem(), 1, this.furnaceItemStacks[4].getItemDamage());
                			if (this.furnaceItemStacks[4].stackSize > 1) {
                				this.furnaceItemStacks[4].stackSize -= 1;
                			}else{
                				this.furnaceItemStacks[4] = null;
                			}
                		}else{
                			this.furnaceItemStacks[2].stackSize += 1;
                			if (this.furnaceItemStacks[4].stackSize > 1) {
                				this.furnaceItemStacks[4].stackSize -= 1;
                			}else{
                				this.furnaceItemStacks[4] = null;
                			}
                		}
                	}
            }
            
            if (!this.isSmelting() || this.isSmelting() || flag != this.hasPower())
            {
                flag1 = true;
                BlockOreFactory.updateFurnaceBlockState(this.isMainTextureOn(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
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
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canStartSmelting()
    {
        if (this.power <= 0 || this.furnaceItemStacks[2] == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[2]);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[6] == null) return true;
                if (!this.furnaceItemStacks[6].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[6].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[6].getMaxStackSize();
            }
    }

    private boolean canContinueSmelting()
    {
        if (this.power <= 0 || this.processedItemSmelting == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.processedItemSmelting);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[6] == null) return true;
                if (!this.furnaceItemStacks[6].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[6].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[6].getMaxStackSize();
            }
    }

    private boolean canStartCrushing()
    {
        if (this.power <= 0 || this.furnaceItemStacks[0] == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.furnaceItemStacks[0]);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[4] == null) return true;
                if (!this.furnaceItemStacks[4].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[4].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[4].getMaxStackSize();
            }
    }

    private boolean canContinueCrushing()
    {
        if (this.power <= 0 || this.processedItemCrushing == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.processedItemCrushing);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[4] == null) return true;
                if (!this.furnaceItemStacks[4].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[4].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[4].getMaxStackSize();
            }
    }

    private boolean canStartElectrolyzing()
    {
        if (this.power <= 0 || this.furnaceItemStacks[1] == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(this.furnaceItemStacks[1]);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[5] == null) return true;
                if (!this.furnaceItemStacks[5].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[5].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[5].getMaxStackSize();
            }
    }

    private boolean canContinueElectrolyzing()
    {
        if (this.power <= 0 || this.processedItemElectrolyzing == null)
        {
            return false;
        }
            else
            {
                ItemStack itemstack = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(this.processedItemElectrolyzing);
                if (itemstack == null) return false;
                if (this.furnaceItemStacks[5] == null) return true;
                if (!this.furnaceItemStacks[5].isItemEqual(itemstack)) return false;
                int result = furnaceItemStacks[5].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[5].getMaxStackSize();
            }
    }
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canContinueSmelting())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.processedItemSmelting);

            if (this.furnaceItemStacks[6] == null)
            {
                this.furnaceItemStacks[6] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[6].isItemEqual(itemstack))
            {
                this.furnaceItemStacks[6].stackSize += itemstack.stackSize;
            }
        }
    }

    public void electrolyzeItem()
    {
        if (this.canContinueElectrolyzing())
        {
            ItemStack itemstack = AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(this.processedItemElectrolyzing);

            if (this.furnaceItemStacks[5] == null)
            {
                this.furnaceItemStacks[5] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[5].isItemEqual(itemstack))
            {
                this.furnaceItemStacks[5].stackSize += itemstack.stackSize;
            }
        }
    }

    public void crushItem()
    {
        if (this.canContinueCrushing())
        {
            ItemStack itemstack = AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(this.processedItemCrushing);

            if (this.furnaceItemStacks[4] == null)
            {
                this.furnaceItemStacks[4] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[4].isItemEqual(itemstack))
            {
                this.furnaceItemStacks[4].stackSize += itemstack.stackSize;
            }
        }
    }
    
    public void consumeInput0() {

    	this.processedItemCrushing = new ItemStack(this.furnaceItemStacks[0].getItem(), 1, this.furnaceItemStacks[0].getItemDamage());
    	
        --this.furnaceItemStacks[0].stackSize;

        if (this.furnaceItemStacks[0].stackSize <= 0)
        {
        	this.furnaceItemStacks[0] = null;
        }
    }
    
    public void consumeInput1() {

    	this.processedItemElectrolyzing = new ItemStack(this.furnaceItemStacks[1].getItem(), 1, this.furnaceItemStacks[1].getItemDamage());
    	
        --this.furnaceItemStacks[1].stackSize;

        if (this.furnaceItemStacks[1].stackSize <= 0)
        {
        	this.furnaceItemStacks[1] = null;
        }
    }
    
    public void consumeInput2() {

    	this.processedItemSmelting = new ItemStack(this.furnaceItemStacks[2].getItem(), 1, this.furnaceItemStacks[2].getItemDamage());
    	
        --this.furnaceItemStacks[2].stackSize;

        if (this.furnaceItemStacks[2].stackSize <= 0)
        {
        	this.furnaceItemStacks[2] = null;
        }
    }
    
    public boolean isMainTextureOn() {
    	ItemStack item = this.furnaceItemStacks[0];
    	if (((this.isSmelting() && this.flagRSFurnace) || (this.isCrushing() && this.flagRSCrusher) || (this.isElectrolyzing() && this.flagRSElectrolyzer))) {
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
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
    	if (this.furnaceCookTimeSmelting > 0) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean isCrushing() {
    	if (this.furnaceCookTimeCrushing > 0) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean isElectrolyzing() {
    	if (this.furnaceCookTimeElectrolyzing > 0) {
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
        return (par1 == 4 || par1 == 5 ||  par1 == 6) ? false : (par1 == 3 ? isItemFuel(par2ItemStack) : true);
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