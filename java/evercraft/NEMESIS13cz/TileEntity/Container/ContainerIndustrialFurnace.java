package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotIndustrialFurnace;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityIndustrialFurnace;

public class ContainerIndustrialFurnace extends Container
{
    private TileEntityIndustrialFurnace furnace;
    private int lastCookTime1 = 0;
    private int lastCookTime2 = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastUpgradeType = 0;

    public ContainerIndustrialFurnace(InventoryPlayer par1InventoryPlayer, TileEntityIndustrialFurnace par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 56, 47));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 56, 21));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 2, 28, 53));
        this.addSlotToContainer(new SlotIndustrialFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 3, 116, 47));
        this.addSlotToContainer(new SlotIndustrialFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 4, 116, 21));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 5, 154, 6));
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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime1);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceCookTime2);
        par1ICrafting.sendProgressBarUpdate(this, 2, (int)this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.furnace.upgradeType);
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

            if (this.lastCookTime1 != this.furnace.furnaceCookTime1)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime1);
            }
            
            if (this.lastCookTime2 != this.furnace.furnaceCookTime2)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceCookTime2);
            }

            if (this.lastBurnTime != this.furnace.power)
            {
                icrafting.sendProgressBarUpdate(this, 2, (int)this.furnace.power);
            }
            if (this.lastUpgradeType != this.furnace.upgradeType)
            {
                icrafting.sendProgressBarUpdate(this, 3, this.furnace.upgradeType);
            }
        }

        this.lastCookTime1 = this.furnace.furnaceCookTime1;
        this.lastCookTime2 = this.furnace.furnaceCookTime2;
        this.lastBurnTime = (int)this.furnace.power;
        this.lastUpgradeType = this.furnace.upgradeType;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.furnaceCookTime1 = par2;
        }

        if (par1 == 1)
        {
            this.furnace.furnaceCookTime2 = par2;
        }

        if (par1 == 2)
        {
            this.furnace.power = par2;
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

            if (par2 == 3 || par2 == 4)
            {
                if (!this.mergeItemStack(itemstack1, 6, 42, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 5 && par2 != 2 && par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 2, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityIndustrialFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
                        return null;
                    }
                }else if (TileEntityIndustrialFurnace.isUpgrade(itemstack1)) {
                	if (!this.mergeItemStack(itemstack1, 5, 6, false)) {
                		return null;
                	}
                }
                else if (par2 >= 6 && par2 < 33)
                {
                    if (!this.mergeItemStack(itemstack1, 33, 42, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 33 && par2 < 42 && !this.mergeItemStack(itemstack1, 6, 33, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 6, 42, false))
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
