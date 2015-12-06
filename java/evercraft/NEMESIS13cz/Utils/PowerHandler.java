package evercraft.NEMESIS13cz.Utils;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;



public class PowerHandler {
	
	public static int FuelValue = 1200; //base for glowstone dust (redstone /6, rs powder /24, enriched redstone *2, GS block *4, RS block *1,5)
	
	public static int CrusherSpeed = 200;
	public static int AdvCrusherSpeed = 80;
	public static int AdvFurnaceSpeed = 20;
	public static int RepCrusherSpeed = 400;
	public static int ElectrolyzerSpeed = 600;
	public static int AdvElectrolyzerSpeed = 100;
	
	public static int CrusherConsump = 4;
	public static int AdvCrusherConsump = 4;
	public static int AdvFurnaceConsump = 2;
	public static int RepCrusherConsump = 30;
	public static int PlateMillConsump = 4;
	public static int ParticleMergConsump = 16;
	public static int ElectrolyzerConsump = 4;
	public static int AdvElectrolyzerConsump = 8;
	public static int HTFurnaceConsump = 8;
	public static int HammeringMachineConsump = 2;
	public static int CentrifugeConsump = 4;
	public static int CuttingMachineConsump = 6;
	public static int OreEnricherConsump = 4;
	
	public static int lowCapacity = 10000;
	public static int mediumCapacity = 30000;
	public static int highCapacity = 120000;
	public static int extremeCapacity = 200000;
	public static int cableCapacity = 200;
	
	public static int redstoniteCableThroughput = 40;
	
	public static int ironAshFilterDurability = 20000;
	public static int ethericGeneratorFuelMultiplier = 4;
	public static int heatGeneratorFuelMultiplier = 3;
	
	/**
	 * Base charging code (called by machines).
	 * Here you insert chargables
	 * 
	 * @param slot
	 * @param maxPower
	 * @param power
	 * @param hasPower --Unused
	 * @return new power level
	 */
	
	public static int chargeItem(ItemStack slot, int maxPower, int power, boolean hasPower) {
        if (slot != null) {
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 0) 	power = subitemCharge(slot, power, 1, 1000, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 1) 	power = subitemCharge(slot, power, 10, 4000, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 2) 	power = subitemCharge(slot, power, 50, 16000, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 3)	power = subitemCharge(slot, power, 200, 64000, "charge");
        	if (slot.getItem() == Evercraft_Items.ethericdrill) 									power = subitemCharge(slot, power, 50, 16000, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 0)	power = subitemCharge(slot, power, 600, 192000, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 1) 	power = subitemCharge(slot, power, 800, 256000, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 2) 	power = subitemCharge(slot, power, 1000, 320000, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 3) 	power = subitemCharge(slot, power, 1600, 384000, "charge");
        	if (slot.getItem() == Evercraft_Items.ethericwrench)									power = subitemCharge(slot, power, 50, 16000, "charge");
        	if (slot.getItem() == Evercraft_Items.WRScoordinator)									power = subitemCharge(slot, power, 10, 4000, "charge");
        }
        return power;
	}
	
	/**
	 * Base discharging code (called by machines).
	 * Here you insert dischargables
	 * 
	 * @param slot
	 * @param maxPower
	 * @param power
	 * @return new power level
	 */
	
	public static int dischargeItem(ItemStack slot, int maxPower, int power) {
        if (slot != null) {
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 0) 	power = subitemDischarge(slot, power, maxPower, 10, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 1) 	power = subitemDischarge(slot, power, maxPower, 20, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 2) 	power = subitemDischarge(slot, power, maxPower, 100, "charge");
        	if (slot.getItem() == Evercraft_Items.portablecapacitor && slot.getItemDamage() == 3)	power = subitemDischarge(slot, power, maxPower, 600, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 0)	power = subitemDischarge(slot, power, maxPower, 2400, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 1) 	power = subitemDischarge(slot, power, maxPower, 3200, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 2) 	power = subitemDischarge(slot, power, maxPower, 4000, "charge");
        	if (slot.getItem() == Evercraft_Items.energizeddiamond && slot.getItemDamage() == 3) 	power = subitemDischarge(slot, power, maxPower, 5600, "charge");
        }
        return power;
	}
	
	/**
	 * Universal Code for item charging.
	 * 
	 * @param item
	 * @param power
	 * @param chargeSpeed
	 * @param capacity
	 * @param NBTTagName
	 * @return new power level
	 */
	public static int subitemCharge(ItemStack item, int power, int chargeSpeed, int capacity, String NBTTagName) {
		if (item.stackTagCompound != null) {
			if (power >= chargeSpeed) {
				if (item.stackTagCompound.getInteger(NBTTagName) + chargeSpeed <= capacity) {
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	capCharge += chargeSpeed;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
		        	power -= chargeSpeed;
				}else{
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	power -= capacity - capCharge;
		        	capCharge = capacity;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
				}
			}else if(power > 0) {
				if (item.stackTagCompound.getInteger(NBTTagName) + power <= capacity) {
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	capCharge += power;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
		        	power = 0;
				}else{
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	power -= capacity - capCharge;
		        	capCharge = capacity;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
				}
			}
		}else{ //If the item (capacitor, ...) has no charge tagName --It should crash you when you get item like that but people are magical...
    		item.stackTagCompound = new NBTTagCompound();
    		item.stackTagCompound.setInteger(NBTTagName, 0);
		}
		return power;
	}
	
	/**
	 * Universal Code for item discharging.
	 * 
	 * @param item
	 * @param power
	 * @param maxPower
	 * @param dischargeSpeed
	 * @param NBTTagName
	 * @return new power level
	 */
	public static int subitemDischarge(ItemStack item, int power, int maxPower, int dischargeSpeed, String NBTTagName) {
		if (item.stackTagCompound != null) {
			if (power <= maxPower - dischargeSpeed) {
				if (item.stackTagCompound.getInteger(NBTTagName) >= dischargeSpeed) {
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	capCharge -= dischargeSpeed;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
		        	power += dischargeSpeed;
				}else{
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	power += capCharge;
		        	capCharge = 0;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
				}
			}else{
				if (item.stackTagCompound.getInteger(NBTTagName) >= maxPower - power) {
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	capCharge -= maxPower - power;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
		        	power = maxPower;
				}else{
		        	int capCharge;
		        	capCharge = item.stackTagCompound.getInteger(NBTTagName);
		        	power += capCharge;
		        	capCharge = 0;
		        	item.stackTagCompound.setInteger(NBTTagName, capCharge);
				}
			}
		}else{ //If the item (capacitor, ...) has no charge tagName --It should crash you when you get item like that but people are magical...
    		item.stackTagCompound = new NBTTagCompound();
    		item.stackTagCompound.setInteger(NBTTagName, 0);
		}
		return power;
	}
	
	/**
	 * Calculates and sends EE power to adjacent machines.
	 * Called by generators.
	 * Will work for cables (throughput = maxPower), but you usually want to limit the throughput of cables...
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param power
	 * @return new power level
	 */
	
	public static int sendPower(World world, int x, int y, int z, int power) {
		
        ArrayList<TileEntityAcceptable> tiles = getAdjacentTileEntities(world, x, y, z);
        
        
        if (tiles.size() > 0 && power > 0) {
        	int amount = tiles.size();
        	int amountToSendTo = 0;
        	int powerBegin = power;

        	for (int i = 0; i < amount; i++) {
        		if (tiles.get(i).getMaxPower() > tiles.get(i).getPower()) {
        			amountToSendTo += 1;
        		}else{
        			tiles.remove(i);
        			i -= 1;
        			amount -= 1;
        		}
        	}

        	for (int i = 0; i < amountToSendTo; i++) {
        		if ((powerBegin / amountToSendTo) > (tiles.get(i).getMaxPower() - tiles.get(i).getPower())) {
        			power -= (tiles.get(i).getMaxPower() - tiles.get(i).getPower());
        			powerBegin -= (tiles.get(i).getMaxPower() - tiles.get(i).getPower());
        			tiles.get(i).setPower(tiles.get(i).getMaxPower());
        			amountToSendTo -= 1;
        		}else{
        			tiles.get(i).addPower(powerBegin / amountToSendTo);
        			power -= powerBegin / amountToSendTo;
        		}
        	}
        }
        
        return power;
	}
	
	/**
	 * Sends power to a specified block (x, y, z)
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param power
	 * @return new power level
	 */
	
	public static int sendPowerToSpecifiedBlock(World world, int x, int y, int z, int power) {        
        
		if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityAcceptable) {
			
			TileEntityAcceptable tile = (TileEntityAcceptable)world.getTileEntity(x, y, z);
			
	        if (power > 0) {
	        	if (tile.getMaxPower() > tile.getPower()) {
	        		if (power > (tile.getMaxPower() - tile.getPower())) {
	        			power -= (tile.getMaxPower() - tile.getPower());
	        			tile.setPower(tile.getMaxPower());
	        		}else{
	        			tile.addPower(power);
	        			power = 0;
	        		}
	        	}
	        }
		}
        return power;
	}
	
	/**
	 * Calculates and sends EE power to adjacent cables or machines.
	 * ONLY call this with CABLES!
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param power
	 * @return new power level
	 */
	
	public static double sendPowerViaCable(World world, int x, int y, int z, double power, int throughPut) {
	
        ArrayList<TileEntityConductor> cables = getAdjacentCables(world, x, y, z);
        
        power = (double)sendPower(world, x, y, z, MathHelper.floor_double(power));
        
        if (cables.size() > 0) {
        	if (MathHelper.floor_double(power) >= throughPut && cables.size() > 0) {
        		int powerBeginToCable = MathHelper.floor_double(power);
        		
        		for (int i = 0; i < cables.size(); i++) {
        			if (cables.get(i).getPower() < MathHelper.floor_double(power)) {
            			if ((cables.get(i).getMaxPower() - cables.get(i).getPower()) >= powerBeginToCable / cables.size()) {
            				cables.get(i).addPower(powerBeginToCable / cables.size());
            				powerBeginToCable -= powerBeginToCable / cables.size();
            				cables.remove(i);
            				i -= 1;
            			}else{
            				cables.get(i).addPower(cables.get(i).getMaxPower() - cables.get(i).getPower());
            				powerBeginToCable -= cables.get(i).getMaxPower() - cables.get(i).getPower();
            				cables.remove(i);
            				i -= 1;
            			}
        			}
        		}
        	}
        }
        
        return power;
	}
	
	/**
	 * Scans adjacent blocks and returns an ArrayList of TileEntities that can accept power.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return ArrayList of TileEntityAcceptable
	 */
	
    public static ArrayList<TileEntityAcceptable> getAdjacentTileEntities(World world, int x, int y, int z) {
    	
    	ArrayList<TileEntityAcceptable> list = new ArrayList<TileEntityAcceptable>();
    	
    	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x, y + 1, z)).isSideValidForEnergy(0) && !((TileEntityAcceptable)world.getTileEntity(x, y + 1, z)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x, y + 1, z));
    	}
    	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x, y - 1, z)).isSideValidForEnergy(1) && !((TileEntityAcceptable)world.getTileEntity(x, y - 1, z)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x, y - 1, z));
    	}
    	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x + 1, y, z)).isSideValidForEnergy(4) && !((TileEntityAcceptable)world.getTileEntity(x + 1, y, z)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x + 1, y, z));
    	}
    	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x - 1, y, z)).isSideValidForEnergy(5) && !((TileEntityAcceptable)world.getTileEntity(x - 1, y, z)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x - 1, y, z));
    	}
    	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x, y, z + 1)).isSideValidForEnergy(2) && !((TileEntityAcceptable)world.getTileEntity(x, y, z + 1)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x, y, z + 1));
    	}
    	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityAcceptable && ((TileEntityAcceptable)world.getTileEntity(x, y, z - 1)).isSideValidForEnergy(3) && !((TileEntityAcceptable)world.getTileEntity(x, y, z - 1)).isCable) {
    		list.add((TileEntityAcceptable)world.getTileEntity(x, y, z - 1));
    	}
    	return list;
    }
	
	/**
	 * Scans adjacent blocks and returns an ArrayList of TileEntities that can accept power.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return ArrayList of TileEntityAcceptable
	 */
	
    public static ArrayList<TileEntityConductor> getAdjacentCables(World world, int x, int y, int z) {
    	
    	ArrayList<TileEntityConductor> list = new ArrayList<TileEntityConductor>();
    	
    	if (world.getTileEntity(x, y + 1, z) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x, y + 1, z)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x, y + 1, z));
    	}
    	if (world.getTileEntity(x, y - 1, z) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x, y - 1, z)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x, y - 1, z));
    	}
    	if (world.getTileEntity(x + 1, y, z) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x + 1, y, z)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x + 1, y, z));
    	}
    	if (world.getTileEntity(x - 1, y, z) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x - 1, y, z)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x - 1, y, z));
    	}
    	if (world.getTileEntity(x, y, z + 1) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x, y, z + 1)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x, y, z + 1));
    	}
    	if (world.getTileEntity(x, y, z - 1) instanceof TileEntityConductor && ((TileEntityConductor)world.getTileEntity(x, y, z - 1)).isCable) {
    		list.add((TileEntityConductor)world.getTileEntity(x, y, z - 1));
    	}
    	return list;
    }

}
