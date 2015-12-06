package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.Entity.EntityTravellingItem;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;
import evercraft.NEMESIS13cz.Utils.MachineUpgrades;
import evercraft.NEMESIS13cz.Utils.PowerHandler;
import evercraft.NEMESIS13cz.Utils.TileEntityMachine;

public class TileEntityMiner extends TileEntityMachine implements ISidedInventory
{
    private static final int[] slots_top = new int[] {0};

    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] furnaceItemStacks = new ItemStack[2];

    public int maxPower = PowerHandler.mediumCapacity;
    public int upgradeType;
    private static MachineUpgrades UPGR;
    
    public int miningProgress;
    
    public int blocksMined;
    
    private Random rand = new Random();
    
    public boolean isDoneMining = false;

    /** The number of ticks that the current item has been cooking for */
    private String field_94130_e;

	public void addPower(int input) {
		this.power += input;
	}
	
	public void setPower(int input) {
		this.power = input;
	}
	

	public boolean isCable = false;
	
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

	public int getPower() {
		return power;
	}
	
	public int getMaxPower() {
		return maxPower;
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
        return this.hasCustomInventoryName() ? this.field_94130_e : "Miner";
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
        this.isDoneMining = par1NBTTagCompound.getBoolean("isDoneMining");
        this.blocksMined = (int)par1NBTTagCompound.getShort("blocksMined");
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
        par1NBTTagCompound.setBoolean("isDoneMining", this.isDoneMining);
        par1NBTTagCompound.setShort("blocksMined", (short)this.blocksMined);
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
    
    public int getDigTimeRemainingScaled(int par1) {
    	return this.miningProgress * par1 / Evercraft_Config_Machines.minerSpeed;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean hasPower()
    {
    	if (this.upgradeType == UPGR.miningUpgradeID) {
            return this.power > (Evercraft_Config_Machines.minerCostPerBlock*9);
    	}else{
            return this.power > Evercraft_Config_Machines.minerCostPerBlock;
    	}
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
        boolean flagTravel = false;

        if (!this.isDoneMining) {


            if (!this.worldObj.isRemote)
            {
                this.upgradeType = this.setUpgradeType(this.furnaceItemStacks[1]);

            	power = PowerHandler.dischargeItem(this.furnaceItemStacks[0], this.maxPower, this.power);
            	
                
                if (this.isItemFuel(this.furnaceItemStacks[0]) && this.power <= (this.maxPower-this.getPower(this.furnaceItemStacks[0])))
                {
                    this.power += getPower(this.furnaceItemStacks[0]);

                    
                    if (this.furnaceItemStacks[0] != null) {
                    	flag1 = true;
                    	this.furnaceItemStacks[0].stackSize--;
                    	if (this.furnaceItemStacks[0].stackSize == 0) {
                    		this.furnaceItemStacks[0] = this.furnaceItemStacks[0].getItem().getContainerItem(this.furnaceItemStacks[0]);
                    	}
                    	
                    }
                }

                if (this.miningProgress == 0) {
                	if (this.setUpgradeType(this.furnaceItemStacks[1]) == UPGR.redstoneUpgradeID) {
                        flagRS = UPGR.redstoneUpgradeFunction(this, xCoord, yCoord, zCoord, upgradeType);
                	}else{
                		flagRS = true;
                	}
                }

                if (this.hasPower() && this.canMine() && this.miningProgress < Evercraft_Config_Machines.minerSpeed && flagRS) {
                	this.miningProgress += 1;
                }
                if (this.miningProgress >= Evercraft_Config_Machines.minerSpeed) {
                	
                	ArrayList<Integer> sides = new ArrayList<Integer>();
                	if (ItemPipeHandler.getAdjacentInventories(this.worldObj, this.xCoord, this.yCoord, this.zCoord, sides, ItemPipeHandler.EXTRACTION_1).size() > 0 || ItemPipeHandler.getAdjacentPipe(this.worldObj, this.xCoord, this.yCoord, this.zCoord, sides, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}).size() > 0) {
                		flagTravel = true;
                		sides = null;
                	}
                	
                	Block currentlyMined1 = this.worldObj.getBlock(xCoord, yCoord - 1 - this.blocksMined, zCoord);
                	int currentlyMinedMeta1 = currentlyMined1.getDamageValue(worldObj, xCoord, yCoord - 1 - this.blocksMined, zCoord);
                    Block currentlyMined2 = this.worldObj.getBlock(xCoord+1, yCoord - 1 - this.blocksMined, zCoord);
                    int currentlyMinedMeta2 = currentlyMined2.getDamageValue(worldObj, xCoord+1, yCoord - 1 - this.blocksMined, zCoord);
                    Block currentlyMined3 = this.worldObj.getBlock(xCoord+1, yCoord - 1 - this.blocksMined, zCoord+1);
                    int currentlyMinedMeta3 = currentlyMined3.getDamageValue(worldObj, xCoord+1, yCoord - 1 - this.blocksMined, zCoord+1);
                    Block currentlyMined4 = this.worldObj.getBlock(xCoord+1, yCoord - 1 - this.blocksMined, zCoord-1);
                    int currentlyMinedMeta4 = currentlyMined4.getDamageValue(worldObj, xCoord+1, yCoord - 1 - this.blocksMined, zCoord-1);
                    Block currentlyMined5 = this.worldObj.getBlock(xCoord, yCoord - 1 - this.blocksMined, zCoord+1);
                    int currentlyMinedMeta5 = currentlyMined5.getDamageValue(worldObj, xCoord, yCoord - 1 - this.blocksMined, zCoord+1);
                    Block currentlyMined6 = this.worldObj.getBlock(xCoord, yCoord - 1 - this.blocksMined, zCoord-1);
                    int currentlyMinedMeta6 = currentlyMined6.getDamageValue(worldObj, xCoord, yCoord - 1 - this.blocksMined, zCoord-1);
                    Block currentlyMined7 = this.worldObj.getBlock(xCoord-1, yCoord - 1 - this.blocksMined, zCoord);
                    int currentlyMinedMeta7 = currentlyMined7.getDamageValue(worldObj, xCoord-1, yCoord - 1 - this.blocksMined, zCoord);
                    Block currentlyMined8 = this.worldObj.getBlock(xCoord-1, yCoord - 1 - this.blocksMined, zCoord+1);
                    int currentlyMinedMeta8 = currentlyMined8.getDamageValue(worldObj, xCoord-1, yCoord - 1 - this.blocksMined, zCoord+1);
                    Block currentlyMined9 = this.worldObj.getBlock(xCoord-1, yCoord - 1 - this.blocksMined, zCoord-1);
                    int currentlyMinedMeta9 = currentlyMined9.getDamageValue(worldObj, xCoord-1, yCoord - 1 - this.blocksMined, zCoord-1);
                	
                    for (int i = this.yCoord-1; i > this.yCoord-1-this.blocksMined; i--) {
                    	if (this.worldObj.getBlock(xCoord, i, zCoord) != Evercraft_Blocks.blockminingpipe) {
                    		this.worldObj.setBlock(xCoord, i, zCoord, Evercraft_Blocks.blockminingpipe);
                    	}
                    }
                	if (currentlyMined1 != Blocks.bedrock && currentlyMined1 != Evercraft_Blocks.blockminingpipe) {
                		
                		if (this.upgradeType == UPGR.miningUpgradeID) {
    	            		if (currentlyMined2 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord+1, yCoord - 1 - this.blocksMined, zCoord);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined2.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta2, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined2.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta2, 0);
    	                        }
    	            		}
    	            		if (currentlyMined3 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord+1, yCoord - 1 - this.blocksMined, zCoord+1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined3.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta3, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined3.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta3, 0);
    	                        }
    	            		}
    	            		if (currentlyMined4 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord+1, yCoord - 1 - this.blocksMined, zCoord-1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined4.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta4, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined4.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta4, 0);
    	                        }
    	            		}
    	            		if (currentlyMined5 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord, yCoord - 1 - this.blocksMined, zCoord+1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined5.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta5, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined5.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta5, 0);
    	                        }
    	            		}
    	            		if (currentlyMined6 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord, yCoord - 1 - this.blocksMined, zCoord-1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined6.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta6, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined6.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta6, 0);
    	                        }
    	            		}
    	            		if (currentlyMined7 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord-1, yCoord - 1 - this.blocksMined, zCoord);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined7.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta7, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined7.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta7, 0);
    	                        }
    	            		}
    	            		if (currentlyMined8 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord-1, yCoord - 1 - this.blocksMined, zCoord+1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined8.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta8, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined8.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta8, 0);
    	                        }
    	            		}
    	            		if (currentlyMined9 != Blocks.bedrock) {
    	                        this.worldObj.setBlockToAir(xCoord-1, yCoord - 1 - this.blocksMined, zCoord-1);
    	                        if (flagTravel) {
    	                        	ArrayList<ItemStack> droppedItems1 = currentlyMined9.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta9, 0);
    	                        	for (int i = 0; i < droppedItems1.size(); i++) {
    	                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
    	                        	}
    	                        }else{
    	                        	currentlyMined9.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta9, 0);
    	                        }
    	            		}
                		}
                		
                        this.worldObj.setBlockToAir(xCoord, yCoord - 1 - this.blocksMined, zCoord);
                        if (flagTravel) {
                        	ArrayList<ItemStack> droppedItems1 = currentlyMined1.getDrops(worldObj, xCoord, yCoord, zCoord, currentlyMinedMeta1, 0);
                        	for (int i = 0; i < droppedItems1.size(); i++) {
                            	ItemPipeHandler.sendContentsFromMiner(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.rand, ItemPipeHandler.EXTRACTION_1, new boolean[] {true, true, true, true, true, true}, droppedItems1.get(i));
                        	}
                        }else{
                            currentlyMined1.dropBlockAsItem(worldObj, xCoord, yCoord + 2, zCoord, currentlyMinedMeta1, 0);
                        }

                    	List entities = this.worldObj.getEntitiesWithinAABB(EntityTravellingItem.class, AxisAlignedBB.getBoundingBox(this.xCoord + 0.4, this.yCoord + 0.4, this.zCoord + 0.4, this.xCoord + 0.6, this.yCoord + 0.6, this.zCoord + 0.6));
                    	if (entities.size() > 0) {
                    		for (int i = 0; i < entities.size(); i++) {
                    			Entity entity = ((EntityTravellingItem)entities.get(i));
                    			if (entity.getBoundingBox().minX == 0.5 && entity.getBoundingBox().minY == 0.5 && entity.getBoundingBox().minZ == 0.5 && entity.getBoundingBox().maxX == 0.5 && entity.getBoundingBox().maxY == 0.5 && entity.getBoundingBox().maxZ == 0.5) {
                            		((EntityTravellingItem)entity).setMomentum(((EntityTravellingItem)entity).side, ItemPipeHandler.getPipeSpeed(ItemPipeHandler.EXTRACTION_1));
                    			}
                    		}
                    	}
                    	
                        this.worldObj.setBlock(xCoord, yCoord - 1 - this.blocksMined, zCoord, Evercraft_Blocks.blockminingpipe);
                        this.blocksMined += 1;
                        currentlyMined1 = null;
                	}else if (currentlyMined1 == Evercraft_Blocks.blockminingpipe) {
                		this.blocksMined += 1;
                	}else{
                		this.isDoneMining = true;
                	}
                	this.miningProgress = 0;
                	if (this.upgradeType == UPGR.miningUpgradeID) {
                    	this.power -= Evercraft_Config_Machines.minerCostPerBlock * 9;
                	}else{
                    	this.power -= Evercraft_Config_Machines.minerCostPerBlock;
                	}
                }
                if ((this.yCoord - 1 - this.blocksMined) < 1) {
                	this.isDoneMining = true;
                }
                
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
    	if (stack.isItemEqual(new ItemStack(Evercraft_Items.upgradeMining, 1, 0))) return UPGR.miningUpgradeID;
    	
    	return UPGR.noUpgradeID;
    }
    
    public static boolean isUpgrade(ItemStack stack) {
    	if (stack.isItemEqual(new ItemStack(Evercraft_Items.upgradeRedstone, 1, 0))) return true;
    	if (stack.isItemEqual(new ItemStack(Evercraft_Items.upgradeMining, 1, 0))) return true;
    	
    	return false;
    }
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canMine()
    {
    	if (this.isDoneMining != false) {
    		return false;
    	}
    	else if (this.power <= 0) {
            return false;
        }else {
        	return true;
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
        return slots_top;
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