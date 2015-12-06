package evercraft.NEMESIS13cz.Utils;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class MachineUpgrades {
	
	public static int noUpgradeID = 0;
	public static int redstoneUpgradeID = 1;
	public static int miningUpgradeID = 2;
	
	public static ItemStack noUpgradeItemStack = null;
	
	public static boolean redstoneUpgradeFunction(TileEntity tileEntity, int x, int y, int z, int upgradeType) {
		if (upgradeType == redstoneUpgradeID) {
			if (tileEntity.getWorldObj().isBlockIndirectlyGettingPowered(x, y, z)) {
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
	}
}
