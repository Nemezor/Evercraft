package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityMiner;

public class ContainerMiner extends Container
{
    private TileEntityMiner furnace;
    private int lastBurnTime = 0;
    private int lastProgressTime = 0;
    private int lastUpgradeType = 0;

    public ContainerMiner(InventoryPlayer par1InventoryPlayer, TileEntityMiner par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 85, 34));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 154, 6));
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
        par1ICrafting.sendProgressBarUpdate(this, 0, (int)this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.miningProgress);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.upgradeType);
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
            if (this.lastBurnTime != this.furnace.power)
            {
                icrafting.sendProgressBarUpdate(this, 0, (int)this.furnace.power);
            }
            if (this.lastProgressTime != this.furnace.miningProgress)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.miningProgress);
            }
            if (this.lastUpgradeType != this.furnace.upgradeType)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.upgradeType);
            }
        }

        this.lastBurnTime = (int)this.furnace.power;
        this.lastProgressTime = this.furnace.miningProgress;
        this.lastUpgradeType = this.furnace.upgradeType;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.power = par2;
        }
        if (par1 == 1)
        {
            this.furnace.miningProgress = par2;
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
             Slot slot = (Slot)inventorySlots.get(par2);
             if(slot != null && slot.getHasStack())
             {
                     ItemStack itemstack1 = slot.getStack();
                     itemstack = itemstack1.copy();
                     if(par2 == 0)
                     {
                             if(!mergeItemStack(itemstack1, 2, 37, true))
                             {
                                     return null;
                             }
                             slot.onSlotChange(itemstack1, itemstack);
                     }
                     else if (par2 != 1)
                     {
                    	 if (TileEntityMiner.isUpgrade(itemstack1)) {
                         	if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                         		return null;
                         	}
                         }else if(par2 >= 2 && par2 < 28)
	                     {
	                             if(!mergeItemStack(itemstack1, 28, 37, false))
	                             {
	                                     return null;
	                             }
	                     } else
	                     if(par2 >= 28 && par2 < 37)
	                     {
	                             if(!mergeItemStack(itemstack1, 2, 28, false))
	                             {
	                                     return null;
	                             }
	                     } 
                     }
                     else if(!mergeItemStack(itemstack1, 2, 37, false))
                     {
                             return null;
                     }
                     if(itemstack1.stackSize == 0)
                     {
                             slot.putStack(null);
                     } else
                     {
                             slot.onSlotChanged();
                     }
                     if(itemstack1.stackSize != itemstack.stackSize)
                     {
                             slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
                     } else
                     {
                             return null;
                     }
             }
             return itemstack;
    	}
}
