package evercraft.NEMESIS13cz.TileEntity.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPotionSpreader extends TileEntity {
	
	private int potionType = 0;
	
	private int coolDown;
	
	public void updateEntity() {
		
		if (!this.worldObj.isRemote) {
			
			if (this.coolDown > 0) {
				this.coolDown -= 1;
			}
			
			EntityPlayer player = this.worldObj.getClosestPlayer(xCoord + 0.5, yCoord + 1, zCoord + 0.5, 0.5);
			
			if (this.coolDown == 0 && player != null && this.potionType > 0) {
				if (this.potionType == Potion.harm.id || this.potionType == Potion.heal.id) {
					player.addPotionEffect(new PotionEffect(this.potionType, 1, 0));
					this.coolDown += 100;
				}else{
					player.addPotionEffect(new PotionEffect(this.potionType, 3600, 0));
					this.coolDown += 20;
				}
			}
		}
	}
	
	public void setPotionType(int newID) {
		this.potionType = newID;
	}
	
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.potionType = nbt.getByte("potionID");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    	nbt.setByte("potionID", (byte)this.potionType);
    }
}
