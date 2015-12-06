package evercraft.NEMESIS13cz.TileEntity.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import evercraft.NEMESIS13cz.MachineRecipes.MixingTableRecipes;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.TileEntity.Slot.SlotMixingTable;

public class ContainerMixingTable extends Container
{
    private ItemStack[] stackList;
public InventoryCrafting craftMatrix;
public IInventory craftResult;
private World worldObj;
private int posX;
private int posY;
private int posZ;

public ContainerMixingTable(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
{
         craftMatrix = new InventoryCrafting(this, 5, 5);
         craftResult = new InventoryCraftResult();
         worldObj = world;
         posX = i;
         posY = j;
         posZ = k;
         this.addSlotToContainer(new SlotMixingTable(inventoryplayer.player, craftMatrix, craftResult, 0, 17, 46));
         for(int l = 0; l < 5; l++)
         {
                 for(int k1 = 0; k1 < 5; k1++)
                 {
                 this.addSlotToContainer(new Slot(craftMatrix, k1 + l * 5, 80 + k1 * 18, 10 + l * 18));
                 }

         }

         for(int i1 = 0; i1 < 3; i1++)
         {
                 for(int l1 = 0; l1 < 9; l1++)
                 {
                 this.addSlotToContainer(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 102 + i1 * 18));
                 }

         }

         for(int j1 = 0; j1 < 9; j1++)
         {
         this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18, 160));
         }

         onCraftMatrixChanged(craftMatrix);
}
public void onContainerClosed(EntityPlayer par1EntityPlayer)
{
    super.onContainerClosed(par1EntityPlayer);

    if (!this.worldObj.isRemote)
    {
        for (int i = 0; i < 25; ++i)
        {
            ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

            if (itemstack != null)
            {
                par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
}

public void onCraftMatrixChanged(IInventory par1IInventory)
{
    this.craftResult.setInventorySlotContents(0, MixingTableRecipes.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
}

public ItemStack getStackInSlotOnClosing(int par1)
{
    if (this.stackList[par1] != null)
    {
        ItemStack itemstack = this.stackList[par1];
        this.stackList[par1] = null;
        return itemstack;
    }
    else
    {
        return null;
    }
}

public boolean canInteractWith(EntityPlayer entityplayer)
{
         if(worldObj.getBlock(posX, posY, posZ) != Evercraft_Blocks.blockmixingtable)
         {
                 return false;
         } else
         {
                 return entityplayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
         }
}

public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
    ItemStack itemstack = null;
    Slot slot = (Slot)this.inventorySlots.get(par2);

    if (slot != null && slot.getHasStack())
    {
        ItemStack itemstack1 = slot.getStack();
        itemstack = itemstack1.copy();

        if (par2 == 0)
        {
            if (!this.mergeItemStack(itemstack1, 26, 62, true))
            {
                return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
        }
        else if (par2 >= 26 && par2 < 53)
        {
            if (!this.mergeItemStack(itemstack1, 53, 62, false))
            {
                return null;
            }
        }
        else if (par2 >= 53 && par2 < 62)
        {
            if (!this.mergeItemStack(itemstack1, 26, 53, false))
            {
                return null;
            }
        }
        else if (!this.mergeItemStack(itemstack1, 26, 53, false))
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


public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
{
    return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
}
}