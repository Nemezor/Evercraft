package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import evercraft.NEMESIS13cz.Blocks.Misc.BlockInstantRepeater;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;

public class TileEntityInstantRepeater extends TileEntity {
	
	public boolean doTick = true;
	
	public void updateEntity() {
		if (this.doTick && Block.isEqualTo(this.worldObj.getBlock(xCoord, yCoord, zCoord), Evercraft_Blocks.blockHyperenergeticRepeater)) {
			BlockInstantRepeater block = (BlockInstantRepeater)this.worldObj.getBlock(xCoord, yCoord, zCoord);
			block.updateState(worldObj, xCoord, yCoord, zCoord);
		}else{
			this.doTick = true;
		}
	}
}
