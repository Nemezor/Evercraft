package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedCrusherRecipes;
import evercraft.NEMESIS13cz.MachineRecipes.AdvancedElectrolyzerRecipes;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotAdvancedCrusher;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotElectrolyzer;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityOreFactory;
import evercraft.NEMESIS13cz.Utils.NumberHelper;

public class ContainerOreFactory extends Container
{
    private TileEntityOreFactory furnace;
    private int lastCookTimeCrushing = 0;
    private int lastCookTimeElectrolyzing = 0;
    private int lastCookTimeSmelting = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastUpgradeType = 0;
    private short powerHolder_0 = 0;
    private short powerHolder_1 = 0;
    private short powerHolder_2 = 0;

    public ContainerOreFactory(InventoryPlayer par1InventoryPlayer, TileEntityOreFactory par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 32, 10));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 85, 55));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 2, 85, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 28, 53));
        this.addSlotToContainer(new SlotAdvancedCrusher(par1InventoryPlayer.player, par2TileEntityFurnace, 4, 80, 10));
        this.addSlotToContainer(new SlotElectrolyzer(par1InventoryPlayer.player, par2TileEntityFurnace, 5, 141, 55));
        this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 6, 141, 35));
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 7, 154, 6));
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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTimeCrushing);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceCookTimeElectrolyzing);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.furnaceCookTimeSmelting);
        short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
        par1ICrafting.sendProgressBarUpdate(this, 3, powerShorts[0]);
        par1ICrafting.sendProgressBarUpdate(this, 4, powerShorts[1]);
        par1ICrafting.sendProgressBarUpdate(this, 5, powerShorts[2]);
        par1ICrafting.sendProgressBarUpdate(this, 6, this.furnace.upgradeType);
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

            if (this.lastCookTimeCrushing != this.furnace.furnaceCookTimeCrushing)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTimeCrushing);
            }
            if (this.lastCookTimeElectrolyzing != this.furnace.furnaceCookTimeElectrolyzing)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceCookTimeElectrolyzing);
            }
            if (this.lastCookTimeSmelting != this.furnace.furnaceCookTimeSmelting)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.furnaceCookTimeSmelting);
            }
            if (this.lastBurnTime != this.furnace.power)
            {
                short[] powerShorts = NumberHelper.Int2Short(this.furnace.power);
                icrafting.sendProgressBarUpdate(this, 3, powerShorts[0]);
                icrafting.sendProgressBarUpdate(this, 4, powerShorts[1]);
                icrafting.sendProgressBarUpdate(this, 5, powerShorts[2]);
            }
            if (this.lastUpgradeType != this.furnace.upgradeType)
            {
                icrafting.sendProgressBarUpdate(this, 6, this.furnace.upgradeType);
            }
        }

        this.lastCookTimeCrushing = this.furnace.furnaceCookTimeCrushing;
        this.lastCookTimeElectrolyzing = this.furnace.furnaceCookTimeElectrolyzing;
        this.lastCookTimeSmelting = this.furnace.furnaceCookTimeSmelting;
        this.lastBurnTime = this.furnace.power;
        this.lastUpgradeType = this.furnace.upgradeType;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.furnaceCookTimeCrushing = par2;
        }
        if (par1 == 1)
        {
            this.furnace.furnaceCookTimeElectrolyzing = par2;
        }
        if (par1 == 2)
        {
            this.furnace.furnaceCookTimeSmelting = par2;
        }
        if (par1 == 3)
        {
        	this.powerHolder_0 = (short)par2;
        }
        if (par1 == 4)
        {
        	this.powerHolder_1 = (short)par2;
        }
        if (par1 == 5) {
        	this.powerHolder_2 = (short)par2;
        }
        this.furnace.power = NumberHelper.Short2Int(this.powerHolder_0, this.powerHolder_1, this.powerHolder_2);
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

            if (par2 == 4 || par2 == 5 || par2 == 6)
            {
                if (!this.mergeItemStack(itemstack1, 8, 44, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 7 && par2 != 3 && par2 != 2 && par2 != 1 && par2 != 0)
            {
                if (AdvancedCrusherRecipes.advancedCrushing().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                    	if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) == null) {
                    		return null;
                    	}else{
                            if (!this.mergeItemStack(itemstack1, 2, 3, false))
                            {
                                return null;
                            }
                    	}
                    }
                }else if (AdvancedElectrolyzerRecipes.advancedElectrolyzing().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityOreFactory.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 3, 4, false))
                    {
                        return null;
                    }
                }else if (TileEntityOreFactory.isUpgrade(itemstack1)) {
                	if (!this.mergeItemStack(itemstack1, 7, 8, false)) {
                		return null;
                	}
                }
                else if (par2 >= 8 && par2 < 35)
                {
                    if (!this.mergeItemStack(itemstack1, 35, 44, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 35 && par2 < 44 && !this.mergeItemStack(itemstack1, 8, 35, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 8, 44, false))
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
