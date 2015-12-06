package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.MachineRecipes.HammeringMachineRecipes;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotHammeringMachine;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHammeringMachine;

public class ContainerHammeringMachine extends Container
{
    private TileEntityHammeringMachine furnace;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastUpgradeType = 0;
    private int lastProcessSpeed = 0;

    public ContainerHammeringMachine(InventoryPlayer par1InventoryPlayer, TileEntityHammeringMachine par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 56, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 28, 53));
        this.addSlotToContainer(new SlotHammeringMachine(par1InventoryPlayer.player, par2TileEntityFurnace, 2, 116, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 154, 6));
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
        par1ICrafting.sendProgressBarUpdate(this, 1, (int)this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.upgradeType);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.furnace.S2CsyncProcessSpeed);
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
                icrafting.sendProgressBarUpdate(this, 1, (int)this.furnace.power);
            }
            if (this.lastUpgradeType != this.furnace.upgradeType)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.upgradeType);
            }
            if (this.lastProcessSpeed != this.furnace.S2CsyncProcessSpeed)
            {
                icrafting.sendProgressBarUpdate(this, 3, this.furnace.S2CsyncProcessSpeed);
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
            this.furnace.power = par2;
        }
        if (par1 == 3) {
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

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 4, 40, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 3 && par2 != 1 && par2 != 0)
            {
                if (HammeringMachineRecipes.hammering().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityHammeringMachine.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (TileEntityHammeringMachine.isUpgrade(itemstack1)) {
                	if (!this.mergeItemStack(itemstack1, 3, 4, false)) {
                		return null;
                	}
                }
                else if (par2 >= 4 && par2 < 31)
                {
                    if (!this.mergeItemStack(itemstack1, 31, 40, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 31 && par2 < 40 && !this.mergeItemStack(itemstack1, 4, 31, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 4, 40, false))
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
