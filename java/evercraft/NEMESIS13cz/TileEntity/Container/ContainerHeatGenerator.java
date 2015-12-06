package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityHeatGenerator;
import evercraft.NEMESIS13cz.Utils.NumberHelper;

public class ContainerHeatGenerator extends Container
{
    private TileEntityHeatGenerator furnace;
    private int power = 0;
    private int heat = 0;
    private int heatMax = 0;
    private short powerHolder_0 = 0;
    private short powerHolder_1 = 0;
    private short powerHolder_2 = 0;
    private short heatHolder_0 = 0;
    private short heatHolder_1 = 0;
    private short heatHolder_2 = 0;
    private short heatMaxHolder_0 = 0;
    private short heatMaxHolder_1 = 0;
    private short heatMaxHolder_2 = 0;

    public ContainerHeatGenerator(InventoryPlayer par1InventoryPlayer, TileEntityHeatGenerator par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 117, 12));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 117, 57));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 2, 145, 12));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 145, 57));
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
        short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 1, powerShorts[0]);
        par1ICrafting.sendProgressBarUpdate(this, 2, powerShorts[1]);
        par1ICrafting.sendProgressBarUpdate(this, 3, powerShorts[2]);
        short[] heatShorts = NumberHelper.Int2Short(this.furnace.burning);
        par1ICrafting.sendProgressBarUpdate(this, 4, heatShorts[0]);
        par1ICrafting.sendProgressBarUpdate(this, 5, heatShorts[1]);
        par1ICrafting.sendProgressBarUpdate(this, 6, heatShorts[2]);
        short[] heatMaxShorts = NumberHelper.Int2Short(this.furnace.burningMax);
        par1ICrafting.sendProgressBarUpdate(this, 7, heatMaxShorts[0]);
        par1ICrafting.sendProgressBarUpdate(this, 8, heatMaxShorts[1]);
        par1ICrafting.sendProgressBarUpdate(this, 9, heatMaxShorts[2]);
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

            if (this.power != this.furnace.power)
            {
                short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
                icrafting.sendProgressBarUpdate(this, 1, powerShorts[0]);
                icrafting.sendProgressBarUpdate(this, 2, powerShorts[1]);
                icrafting.sendProgressBarUpdate(this, 3, powerShorts[2]);
            }
            if (this.heat != this.furnace.burning)
            {
                short[] heatShorts = NumberHelper.Int2Short(this.furnace.burning);
                icrafting.sendProgressBarUpdate(this, 4, heatShorts[0]);
                icrafting.sendProgressBarUpdate(this, 5, heatShorts[1]);
                icrafting.sendProgressBarUpdate(this, 6, heatShorts[2]);
            }
            if (this.heatMax != this.furnace.burningMax)
            {
                short[] heatMaxShorts = NumberHelper.Int2Short(this.furnace.burningMax);
                icrafting.sendProgressBarUpdate(this, 7, heatMaxShorts[0]);
                icrafting.sendProgressBarUpdate(this, 8, heatMaxShorts[1]);
                icrafting.sendProgressBarUpdate(this, 9, heatMaxShorts[2]);
            }
        }

        this.power = this.furnace.power;
        this.heat = this.furnace.burning;
        this.heatMax = this.furnace.burningMax;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 1)
        {
        	this.powerHolder_0 = (short)par2;
        }
        if (par1 == 2)
        {
        	this.powerHolder_1 = (short)par2;
        }
        if (par1 == 3)
        {
        	this.powerHolder_2 = (short)par2;
        }
        if (par1 == 4)
        {
        	this.heatHolder_0 = (short)par2;
        }
        if (par1 == 5)
        {
        	this.heatHolder_1 = (short)par2;
        }
        if (par1 == 6)
        {
        	this.heatHolder_2 = (short)par2;
        }
        if (par1 == 7)
        {
        	this.heatMaxHolder_0 = (short)par2;
        }
        if (par1 == 8)
        {
        	this.heatMaxHolder_1 = (short)par2;
        }
        if (par1 == 9)
        {
        	this.heatMaxHolder_2 = (short)par2;
        }
        this.furnace.power = NumberHelper.Short2Int(powerHolder_0, powerHolder_1, powerHolder_2);
        this.furnace.burning = NumberHelper.Short2Int(heatHolder_0, heatHolder_1, heatHolder_2);
        this.furnace.burningMax = NumberHelper.Short2Int(heatMaxHolder_0, heatMaxHolder_1, heatMaxHolder_2);
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

            if (par2 == 1 || par2 == 3)
            {
                if (!this.mergeItemStack(itemstack1, 4, 40, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 0 && par2 != 2)
            {
                if (itemstack1 == new ItemStack(Evercraft_Items.portablecapacitor))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (itemstack1.getItem() == Evercraft_Items.ashFilter)
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
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
