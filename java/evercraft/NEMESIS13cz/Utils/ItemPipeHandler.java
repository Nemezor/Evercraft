package evercraft.NEMESIS13cz.Utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Entity.EntityTravellingItem;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;

public class ItemPipeHandler {
    
	public static final int TRANSPORT_1 = 0;
	public static final int TRANSPORT_2 = 1;
	public static final int EXTRACTION_1 = 2;
	public static final int EXTRACTION_2 = 3;
	public static final int ROUTING = 4;
	public static final int TRANSPORT_FAST = 5;
	
	public static final float STANDARD_SPEED = 0.1F;
	public static final float FAST_SPEED = 0.5F;
	
	/**
	 * Extracts Items from adjacent inventories.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param rand
	 * @param type
	 * @param allowedSides
	 */
	
	public static void extractContents(World world, int x, int y, int z, Random rand, int type, boolean[] allowedSides) {

    	ArrayList<Integer> tileDir = new ArrayList<Integer>();
    	ArrayList<Integer> tileDir2 = new ArrayList<Integer>();
    	ArrayList<IInventory> tiles = getAdjacentInventories(world, x, y, z, tileDir, type);
    	getAdjacentPipe(world, x, y, z, tileDir2, type, allowedSides);
    	
    	for (int i = 0; i < tiles.size(); i++) {
    		if (tiles.get(i) instanceof ISidedInventory) {
    	    	for (int j = 0; j < ((ISidedInventory)tiles.get(i)).getAccessibleSlotsFromSide(tileDir.get(i)).length; j++) {
    	    		int[] slots = ((ISidedInventory)tiles.get(i)).getAccessibleSlotsFromSide(tileDir.get(i));
    				ISidedInventory localTile = (ISidedInventory)tiles.get(i);
        			if (localTile.getStackInSlot(slots[j]) != null && localTile.canExtractItem(slots[j], localTile.getStackInSlot(slots[j]), tileDir.get(i))) {
        				ItemStack item = localTile.getStackInSlot(slots[j]).copy();
        				localTile.setInventorySlotContents(slots[j], null);

        				ArrayList<Integer> localTileDir = new ArrayList<Integer>();
        				localTileDir.addAll(tileDir);
        				localTileDir.remove(i);
        				ArrayList<Integer> localTileDir2 = new ArrayList<Integer>();
        				localTileDir2.addAll(tileDir2);

        				int sideTGT = 10;
        				if (tileDir.size() -1 > 0) {
        					sideTGT = localTileDir.get(rand.nextInt(tileDir.size() - 1));
        				}
        				if (tileDir2.size() > 0) {
        					sideTGT = localTileDir2.get(rand.nextInt(tileDir2.size()));
        				}
        				ItemPipeHandler.reverseDir(sideTGT);
        				EntityTravellingItem entity = new EntityTravellingItem(world, x + 0.5D, y + 0.5D, z + 0.5D, item, sideTGT);
        				if (item.hasTagCompound()) {
        					entity.getItemstack().setTagCompound((NBTTagCompound)item.getTagCompound());
        				}
        				entity.setMomentum(entity.side, ItemPipeHandler.getPipeSpeed(type));
        				world.spawnEntityInWorld(entity);
        				
        				j = tiles.get(i).getSizeInventory();
        			}
    	    	}
    		}else{
    	    	for (int j = 0; j < tiles.get(i).getSizeInventory(); j++) {
        			if (tiles.get(i).getStackInSlot(j) != null) {
        				IInventory localTile = tiles.get(i);
        				ItemStack item = localTile.getStackInSlot(j).copy();
        				localTile.setInventorySlotContents(j, null);

        				ArrayList<Integer> localTileDir = new ArrayList<Integer>();
        				localTileDir.addAll(tileDir);
        				localTileDir.remove(i);
        				ArrayList<Integer> localTileDir2 = new ArrayList<Integer>();
        				localTileDir2.addAll(tileDir2);

        				int sideTGT = 10;
        				if (tileDir.size() -1 > 0) {
        					sideTGT = localTileDir.get(rand.nextInt(tileDir.size() - 1));
        				}
        				if (tileDir2.size() > 0) {
        					sideTGT = localTileDir2.get(rand.nextInt(tileDir2.size()));
        				}
        				ItemPipeHandler.reverseDir(sideTGT);
        				EntityTravellingItem entity = new EntityTravellingItem(world, x + 0.5D, y + 0.5D, z + 0.5D, item, sideTGT);
        				if (item.hasTagCompound()) {
        					entity.getItemstack().setTagCompound((NBTTagCompound)item.getTagCompound());
        				}
        				entity.setMomentum(entity.side, ItemPipeHandler.getPipeSpeed(type));
        				world.spawnEntityInWorld(entity);
        				
        				j = tiles.get(i).getSizeInventory();
        			}
    			}
    		}
    	}
	}
	
	/**
	 * Sends contents to an inventory. Respects stacksizes and ISidedInventory.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param side
	 * @param itemstack
	 * @param isDead
	 * @param simulate
	 * @return boolean did send the item
	 */
	
	public static boolean sendContentsToInv(World world, int x, int y, int z, int side, ItemStack itemstack, boolean isDead, boolean simulate) {
		boolean flag = false;
		int globalSimulateStacksize = 0;
		if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof IInventory) {
			IInventory inventory = (IInventory)world.getTileEntity(x, y, z);
			ItemStack stack = itemstack.copy();
			
			if (simulate) side = ItemPipeHandler.reverseDir(side);
			
			if (inventory instanceof ISidedInventory) {
				
				int[] slots = ((ISidedInventory)inventory).getAccessibleSlotsFromSide(side);
				
				for (int i = 0; i < slots.length; i++) {
					if (((ISidedInventory)inventory).getStackInSlot(slots[i]) == null) {
						if (((ISidedInventory)inventory).canInsertItem(slots[i], stack, side)) {
							if (!simulate) {
								((ISidedInventory)inventory).setInventorySlotContents(slots[i], stack.copy());
							}
							flag = true;
							i = slots.length;
							if (!simulate) {
								stack.stackSize -= stack.stackSize;
							}
							globalSimulateStacksize = 0;
						}
					}else{
						if (((ISidedInventory)inventory).canInsertItem(slots[i], stack, side) && ((ISidedInventory)inventory).getStackInSlot(slots[i]).isItemEqual(stack)) {
							
							int maxStackSize = Math.min(((ISidedInventory)inventory).getInventoryStackLimit(), stack.getMaxStackSize());
							
							if (((ISidedInventory)inventory).getStackInSlot(slots[i]).stackSize + stack.stackSize > maxStackSize) {
								int simStackSize = stack.stackSize - maxStackSize - ((ISidedInventory)inventory).getStackInSlot(slots[i]).stackSize;
								if (!simulate) {
									stack.stackSize -= maxStackSize - ((ISidedInventory)inventory).getStackInSlot(slots[i]).stackSize;
									((ISidedInventory)inventory).getStackInSlot(slots[i]).stackSize = maxStackSize;
								}
								flag = true;
								if (stack.stackSize <= 0) {
									i = slots.length;
								}
								if (simulate && simStackSize <= 0) {
									i = slots.length;
								}
								globalSimulateStacksize = simStackSize;
							}else{
								if (!simulate) {
									((ISidedInventory)inventory).getStackInSlot(slots[i]).stackSize += stack.stackSize;
								}
								flag = true;
								i = slots.length;
								if (!simulate) {
									stack.stackSize -= stack.stackSize;
								}
								globalSimulateStacksize = 0;
							}
						}
					}
				}
			}else{
				for (int i = 0; i < inventory.getSizeInventory(); i++) {
					if ((inventory).getStackInSlot(i) == null) {
						if (!simulate) {
							(inventory).setInventorySlotContents(i, stack.copy());
						}
						i = inventory.getSizeInventory();
						flag = true;
						if (!simulate) {
							stack.stackSize -= stack.stackSize;
						}
						globalSimulateStacksize = 0;
					}else{
						if ((inventory).getStackInSlot(i).isItemEqual(stack)) {
							
							int maxStackSize = Math.min((inventory).getInventoryStackLimit(), stack.getMaxStackSize());
							
							if (((inventory).getStackInSlot(i).stackSize + stack.stackSize) > maxStackSize) {
								int simStackSize = stack.stackSize - maxStackSize - (inventory).getStackInSlot(i).stackSize;
								if (!simulate) {
									stack.stackSize -= maxStackSize - (inventory).getStackInSlot(i).stackSize;
									(inventory).getStackInSlot(i).stackSize = maxStackSize;
								}
								flag = true;
								if (stack.stackSize <= 0) {
									i = inventory.getSizeInventory();
								}
								if (simulate && simStackSize <= 0) {
									i = inventory.getSizeInventory();
								}
								globalSimulateStacksize = simStackSize;
							}else{
								if (!simulate) {
									(inventory).getStackInSlot(i).stackSize += stack.stackSize;
								}
								flag = true;
								i = inventory.getSizeInventory();
								if (!simulate) {
									stack.stackSize -= stack.stackSize;
								}
								globalSimulateStacksize = 0;
							}
						}
					}
				}
			}
			if (!simulate && stack.stackSize > 0) {
				flag = false;
			}
			if (!simulate) {
				itemstack.stackSize = stack.stackSize;
			}
			if (simulate && globalSimulateStacksize > 0) {
				flag = false;
			}
		}
		if (flag && !simulate) {
			isDead = true;
		}
		return flag;
	}
	
	/**
	 * Outputs an item from Miner.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param rand
	 * @param type
	 * @param allowedSides
	 * @param item2output
	 */
	
	public static void sendContentsFromMiner(World world, int x, int y, int z, Random rand, int type, boolean[] allowedSides, ItemStack item2output) {

    	ArrayList<Integer> tileDir = new ArrayList<Integer>();
    	ArrayList<Integer> tileDir2 = new ArrayList<Integer>();
    	getAdjacentInventories(world, x, y, z, tileDir, type);
    	getAdjacentPipe(world, x, y, z, tileDir2, type, allowedSides);

        int sideTGT = 10;
        if (tileDir.size() > 0) {
        	sideTGT = tileDir.get(rand.nextInt(tileDir.size()));
        }
        if (tileDir2.size() > 0) {
        	sideTGT = tileDir2.get(rand.nextInt(tileDir2.size()));
        }
        ItemPipeHandler.reverseDir(sideTGT);
        EntityTravellingItem entity = new EntityTravellingItem(world, x + 0.5D, y + 0.5D, z + 0.5D, item2output, sideTGT);
        if (item2output.hasTagCompound()) {
        	entity.getItemstack().setTagCompound((NBTTagCompound)item2output.getTagCompound());
        }
        world.spawnEntityInWorld(entity);
	}
	
	/**
	 * Gets the item speed from pipe type.
	 * 
	 * @param pipeType
	 * @return speed
	 */

	public static float getPipeSpeed(int pipeType) {
		if (pipeType == ItemPipeHandler.TRANSPORT_FAST) {
			return ItemPipeHandler.FAST_SPEED;
		}else{
			return ItemPipeHandler.STANDARD_SPEED;
		}
	}
	
	/**
	 * Determins where the item should go in the pipe system.
	 * 
	 * @param tileentity
	 * @param side
	 * @param stack
	 * @param entity
	 * @return the new side
	 */
	
	public static int whereToGo(TileEntityItemPipe tileentity, int side, ItemStack stack, EntityTravellingItem entity) {
	    	ArrayList<Integer> tileDir = new ArrayList<Integer>();
	    	ArrayList<Integer> tileDir2 = new ArrayList<Integer>();
	    	ItemPipeHandler.getAdjacentInventories(tileentity.getWorldObj(), tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileDir2, tileentity.type);
			ArrayList<TileEntityItemPipe> tiles = ItemPipeHandler.getAdjacentPipe(tileentity.getWorldObj(), tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileDir, tileentity.type, tileentity.allowedSides);
	
			int side1 = ItemPipeHandler.reverseDir(side);
			
			if (tileentity.type != ItemPipeHandler.EXTRACTION_1 && tileentity.type != ItemPipeHandler.EXTRACTION_2) {
				for (int i = 0; i < tileDir.size(); i++) {
					if (tileDir.get(i) == side1) {
						tileDir.remove(i);
						i--;
					}
				}
				for (int i = 0; i < tileDir2.size(); i++) {
					if (!ItemPipeHandler.sendContentsToInv(tileentity.getWorldObj(), tileentity.xCoord + ItemPipeHandler.dir2Coords(tileDir2.get(i))[0], tileentity.yCoord + ItemPipeHandler.dir2Coords(tileDir2.get(i))[1], tileentity.zCoord + ItemPipeHandler.dir2Coords(tileDir2.get(i))[2], ItemPipeHandler.reverseDir(tileDir2.get(i)), stack, false, true)) {
						tileDir2.remove(i);
						i -= 1;
					}
				}
			}
			
			int sideTGT = 10;
			if (tileentity.type != ItemPipeHandler.EXTRACTION_1 && tileentity.type != ItemPipeHandler.EXTRACTION_2) {
				if (tileDir.size() > 0) {
					sideTGT = tileDir.get(tileentity.rand.nextInt(tileDir.size()));
				}
				if (tileDir2.size() > 0) {
					sideTGT = tileDir2.get(tileentity.rand.nextInt(tileDir2.size()));
				}
			}else{
				if (tileDir.size() > 0) {
					sideTGT = tileDir.get(tileentity.rand.nextInt(tileDir.size()));
				}
			}
			if (sideTGT == 10) {
				entity.bounceCounter += 1;
				return ItemPipeHandler.reverseDir(side);
			}
		return sideTGT;
	}
	
	/**
	 * Returns the relative position of an inventory/pipe from the given side.
	 * e.g. side 0 is 1 block above...
	 * 
	 * @param dir direction
	 * @return positions[x, y, z]
	 */
	
	public static int[] dir2Coords(int dir) {
		if (dir == 0) return new int[] {0, 1, 0};
		if (dir == 1) return new int[] {0, -1, 0};
		if (dir == 2) return new int[] {0, 0, 1};
		if (dir == 3) return new int[] {-1, 0, 0};
		if (dir == 4) return new int[] {1, 0, 0};
		if (dir == 5) return new int[] {0, 0, -1};
		return new int[] {0, 0, 0};
	}
	
	/**
	 * Scans adjacent blocks and returns an ArrayList of TileEntities.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return ArrayList of IInventory
	 */
	
    public static ArrayList<IInventory> getAdjacentInventories(World world, int x, int y, int z, ArrayList<Integer> sides, int type) {
    	
    	ArrayList<IInventory> list = new ArrayList<IInventory>();
    	ArrayList<Integer> listDir = new ArrayList<Integer>();
    	
    	if (world.getTileEntity(x, y + 1, z) instanceof IInventory && !(world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x, y + 1, z));
    		listDir.add(0);
    	}
    	if (world.getTileEntity(x, y - 1, z) instanceof IInventory && !(world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x, y - 1, z));
    		listDir.add(1);
    	}
    	if (world.getTileEntity(x + 1, y, z) instanceof IInventory && !(world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x + 1, y, z));
    		listDir.add(4);
    	}
    	if (world.getTileEntity(x - 1, y, z) instanceof IInventory && !(world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x - 1, y, z));
    		listDir.add(3);
    	}
    	if (world.getTileEntity(x, y, z + 1) instanceof IInventory && !(world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x, y, z + 1));
    		listDir.add(2);
    	}
    	if (world.getTileEntity(x, y, z - 1) instanceof IInventory && !(world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe)) {
    		list.add((IInventory)world.getTileEntity(x, y, z - 1));
    		listDir.add(5);
    	}
    	
    	sides.addAll(listDir);
    	return list;
    }
    
	/**
	 * Scans adjacent blocks and returns an ArrayList of Pipes.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return ArrayList of TileEntityItemPipe
	 */
	
    public static ArrayList<TileEntityItemPipe> getAdjacentPipe(World world, int x, int y, int z, ArrayList<Integer> sides, int type, boolean[] allowedSides) {
    	
    	ArrayList<TileEntityItemPipe> list = new ArrayList<TileEntityItemPipe>();
    	ArrayList<Integer> listDir = new ArrayList<Integer>();
    	
    	if (type == ItemPipeHandler.TRANSPORT_1) {
        	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y + 1, z)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y + 1, z));
        		listDir.add(0);
        	}
        	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y - 1, z)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y - 1, z));
        		listDir.add(1);
        	}
        	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x + 1, y, z)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x + 1, y, z));
        		listDir.add(4);
        	}
        	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x - 1, y, z)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x - 1, y, z));
        		listDir.add(3);
        	}
        	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y, z + 1)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y, z + 1));
        		listDir.add(2);
        	}
        	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y, z - 1)).type != ItemPipeHandler.TRANSPORT_2) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y, z - 1));
        		listDir.add(5);
        	}
    	}else if (type == ItemPipeHandler.TRANSPORT_2){
        	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y + 1, z)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y + 1, z));
        		listDir.add(0);
        	}
        	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y - 1, z)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y - 1, z));
        		listDir.add(1);
        	}
        	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x + 1, y, z)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x + 1, y, z));
        		listDir.add(4);
        	}
        	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x - 1, y, z)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x - 1, y, z));
        		listDir.add(3);
        	}
        	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y, z + 1)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y, z + 1));
        		listDir.add(2);
        	}
        	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe && ((TileEntityItemPipe)world.getTileEntity(x, y, z - 1)).type != ItemPipeHandler.TRANSPORT_1) {
        		list.add((TileEntityItemPipe)world.getTileEntity(x, y, z - 1));
        		listDir.add(5);
        	}
    	}else{
        	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityItemPipe) {
        		if (allowedSides[0] == true) {
            		list.add((TileEntityItemPipe)world.getTileEntity(x, y + 1, z));
            		listDir.add(0);
        		}
        	}
        	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityItemPipe) {
        		if (allowedSides[1] == true) {
	        		list.add((TileEntityItemPipe)world.getTileEntity(x, y - 1, z));
	        		listDir.add(1);
        		}
        	}
        	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityItemPipe) {
        		if (allowedSides[2] == true) {
        			list.add((TileEntityItemPipe)world.getTileEntity(x + 1, y, z));
        			listDir.add(4);
        		}
        	}
        	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityItemPipe) {
        		if (allowedSides[3] == true) {
        			list.add((TileEntityItemPipe)world.getTileEntity(x - 1, y, z));
        			listDir.add(3);
        		}
        	}
        	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityItemPipe) {
        		if (allowedSides[4] == true) {
        			list.add((TileEntityItemPipe)world.getTileEntity(x, y, z + 1));
        			listDir.add(2);
        		}
        	}
        	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityItemPipe) {
        		if (allowedSides[5] == true) {
        			list.add((TileEntityItemPipe)world.getTileEntity(x, y, z - 1));
        			listDir.add(5);
        		}
        	}
    	}
    	
    	sides.addAll(listDir);
    	return list;
    }
    
    /**
     * Returns an oppsite of the input block side.
     * 
     * @param dir
     * @return Reversed Side IDs
     */

    public static int reverseDir(int dir) {
    	if (dir == 0) {
    		return 1;
    	}else if (dir == 1) {
    		return 0;
    	}else if (dir == 2) {
    		return 5;
    	}else if (dir == 3) {
    		return 4;
    	}else if (dir == 4) {
    		return 3;
    	}else if (dir == 5){
    		return 2;
    	}else{
    		return 10;
    	}
    }
    
    /**
     * Checks if the pipe can connect to another pipe. (Client side use only)
     * 
     * @param type
     * @param pipe
     * @return
     */
    
    @SideOnly(Side.CLIENT)
    public static boolean canConnectToPipe(int type, TileEntityItemPipe pipe) {
    	if (type == ItemPipeHandler.TRANSPORT_1 && pipe.type == ItemPipeHandler.TRANSPORT_2) {
    		return false;
    	}else if(type == ItemPipeHandler.TRANSPORT_2 && pipe.type == ItemPipeHandler.TRANSPORT_1) {
    		return false;
    	}else{
    		return true;
    	}
    }
}
