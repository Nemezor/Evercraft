package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.MachineRecipes.AlloyFurnaceRecipes;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotAlloyFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityAlloyFurnace;
import evercraft.NEMESIS13cz.Utils.NumberHelper;

public class ContainerAlloyFurnace extends Container
{
    private TileEntityAlloyFurnace furnace;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastUpgradeType = 0;
    private short powerHolder_0 = 0;
    private short powerHolder_1 = 0;
    private short powerHolder_2 = 0;
    private int lastProcessSpeed = 0;
    private int lastPowerConsump = 0;

    public ContainerAlloyFurnace(InventoryPlayer par1InventoryPlayer, TileEntityAlloyFurnace par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 38, 17));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 70, 17));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 2, 28, 53));
        this.addSlotToContainer(new SlotAlloyFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 3, 116, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 4, 154, 6));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
        short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 1, powerShorts[0]);
        par1ICrafting.sendProgressBarUpdate(this, 2, powerShorts[1]);
        par1ICrafting.sendProgressBarUpdate(this, 3, powerShorts[2]);
        par1ICrafting.sendProgressBarUpdate(this, 4, this.furnace.upgradeType);
        par1ICrafting.sendProgressBarUpdate(this, 5, this.furnace.S2CsyncProcessSpeed);
        par1ICrafting.sendProgressBarUpdate(this, 6, this.furnace.S2CsyncPowerConsump);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.furnace.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
            }
            if (this.lastBurnTime != this.furnace.power)
            {
                short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
                icrafting.sendProgressBarUpdate(this, 1, powerShorts[0]);
                icrafting.sendProgressBarUpdate(this, 2, powerShorts[1]);
                icrafting.sendProgressBarUpdate(this, 3, powerShorts[2]);
            }
            if (this.lastUpgradeType != this.furnace.upgradeType)
            {
                icrafting.sendProgressBarUpdate(this, 4, this.furnace.upgradeType);
            }
            if (this.lastProcessSpeed != this.furnace.S2CsyncProcessSpeed)
            {
                icrafting.sendProgressBarUpdate(this, 5, this.furnace.S2CsyncProcessSpeed);
            }
            if (this.lastPowerConsump != this.furnace.S2CsyncPowerConsump)
            {
                icrafting.sendProgressBarUpdate(this, 6, this.furnace.S2CsyncPowerConsump);
            }
        }

        this.lastCookTime = this.furnace.furnaceCookTime;
        this.lastBurnTime = (int)this.furnace.power;
        this.lastUpgradeType = this.furnace.upgradeType;
        this.lastProcessSpeed = this.furnace.S2CsyncProcessSpeed;
        this.lastPowerConsump = this.furnace.S2CsyncPowerConsump;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.furnaceCookTime = par2;
        }
        if (par1 == 1)
        {
        	this.powerHolder_0 = (short)par2;
        }
        if (par1 == 2)
        {
        	this.powerHolder_1 = (short)par2;
        }
        if (par1 == 3) {
        	this.powerHolder_2 = (short)par2;
        }
        this.furnace.power = NumberHelper.Short2Int(this.powerHolder_0, this.powerHolder_1, this.powerHolder_2);
        if (par1 == 5) {
        	this.furnace.S2CsyncProcessSpeed = par2;
        }
        if (par1 == 6) {
        	this.furnace.S2CsyncPowerConsump = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.furnace.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 5, 41, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 3 && par2 != 1 && par2 != 0)
            {
                if (AlloyFurnaceRecipes.smelting().hasSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false) && !this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityAlloyFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
                        return null;
                    }
                }else if (TileEntityAlloyFurnace.isUpgrade(itemstack1)) {
                	if (!this.mergeItemStack(itemstack1, 5, 6, false)) {
                		return null;
                	}
                }
                else if (par2 >= 5 && par2 < 32)
                {
                    if (!this.mergeItemStack(itemstack1, 32, 41, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 32 && par2 < 41 && !this.mergeItemStack(itemstack1, 5, 32, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 5, 41, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}
