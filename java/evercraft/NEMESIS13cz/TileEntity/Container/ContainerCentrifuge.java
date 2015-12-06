package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.MachineRecipes.CentrifugeRecipes;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotCentrifuge;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityCentrifuge;
import evercraft.NEMESIS13cz.Utils.NumberHelper;

public class ContainerCentrifuge extends Container
{
    private TileEntityCentrifuge furnace;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastUpgradeType = 0;
    private short powerHolder_0 = 0;
    private short powerHolder_1 = 0;
    private short powerHolder_2 = 0;
    private int lastProcessSpeed = 0;

    public ContainerCentrifuge(InventoryPlayer par1InventoryPlayer, TileEntityCentrifuge par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 56, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 28, 53));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 2, 116, 35));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 3, 116, 17));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 4, 116, 53));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 5, 134, 35));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 6, 134, 17));
        this.addSlotToContainer(new SlotCentrifuge(par1InventoryPlayer.player, par2TileEntityFurnace, 7, 134, 53));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 8, 154, 6));
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
        }

        this.lastCookTime = this.furnace.furnaceCookTime;
        this.lastBurnTime = (int)this.furnace.power;
        this.lastUpgradeType = this.furnace.upgradeType;
        this.lastProcessSpeed = this.furnace.S2CsyncProcessSpeed;
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

            if (par2 == 2 || par2 == 3 || par2 == 4 || par2 == 5 || par2 == 6 || par2 == 7)
            {
                if (!this.mergeItemStack(itemstack1, 9, 45, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 8 && par2 != 1 && par2 != 0)
            {
                if (CentrifugeRecipes.centrifuging().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityCentrifuge.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (TileEntityCentrifuge.isUpgrade(itemstack1)) {
                	if (!this.mergeItemStack(itemstack1, 8, 9, false)) {
                		return null;
                	}
                }
                else if (par2 >= 9 && par2 < 36)
                {
                    if (!this.mergeItemStack(itemstack1, 36, 45, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 36 && par2 < 45 && !this.mergeItemStack(itemstack1, 9, 36, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 9, 45, false))
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
