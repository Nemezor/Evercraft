package evercraft.NEMESIS13cz.Utils;

import net.minecraft.tileentity.TileEntity;

/**
 * Just to unify my machines so I don't have to check for dozens of different tileEntities when I want to connect cables to them...
 * 
 * @author NEMESIS13cz
 */
public abstract class TileEntityAcceptable extends TileEntityPowerNetwork {

	public int power;
	public int maxPower;
	public boolean isCable = false;
	
	public int getPower() {
		return power;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
	public void addPower(int input) {
		this.power += input;
	}
	
	public void setPower(int input) {
		this.power = input;
	}
	
	public boolean isSideValidForEnergy(int side) {
		return true;
	}
}