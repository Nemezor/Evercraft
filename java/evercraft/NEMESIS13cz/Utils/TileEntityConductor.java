package evercraft.NEMESIS13cz.Utils;

import net.minecraft.util.MathHelper;


/**
 * Just to unify my machines so I don't have to check for dozens of different tileEntities when I want to connect cables to them...
 * 
 * @author NEMESIS13cz
 */
public abstract class TileEntityConductor extends TileEntityAcceptable {

	public double power;
	public boolean isCable = true;
	
	public int getPower() {
		return MathHelper.floor_double(this.power);
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
}