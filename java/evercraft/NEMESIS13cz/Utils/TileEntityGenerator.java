package evercraft.NEMESIS13cz.Utils;

import net.minecraft.tileentity.TileEntity;

/**
 * Just to unify my machines so I don't have to check for dozens of different tileEntities when I want to connect cables to them...
 * 
 * @author NEMESIS13cz
 */
public abstract class TileEntityGenerator extends TileEntityPowerNetwork {

	public int power;
	public int maxPower;
	
}