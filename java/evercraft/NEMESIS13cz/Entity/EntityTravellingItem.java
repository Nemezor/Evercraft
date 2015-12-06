package evercraft.NEMESIS13cz.Entity;

import java.util.Iterator;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Machines;
import evercraft.NEMESIS13cz.TileEntity.TileEntity.TileEntityItemPipe;
import evercraft.NEMESIS13cz.Utils.ItemPipeHandler;
import evercraft.NEMESIS13cz.Utils.NumberHelper;

public class EntityTravellingItem extends Entity {
    private int health;
    private String field_145801_f;
    private String field_145802_g;
    protected boolean isImmuneToFire = true;
    public int side;
    public int bounceCounter = 0;
    public TileEntity lastTile;
    public TileEntity lastSpeedTile;
    public int XposCounter = 0;
    public int YposCounter = 0;
    public int ZposCounter = 0;
    
    public EntityTravellingItem(World p_i1709_1_, double p_i1709_2_, double p_i1709_4_, double p_i1709_6_, int side)
    {
        super(p_i1709_1_);
        this.health = 5;
        this.setSize(0.1F, 0.1F);
        this.yOffset = 0.0F;
        this.setPosition(p_i1709_2_, p_i1709_4_, p_i1709_6_);
        this.rotationYaw = 0;
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.XposCounter = 0;
        this.YposCounter = 0;
        this.ZposCounter = 0;
        this.side = side;
        this.lastTile = p_i1709_1_.getTileEntity(MathHelper.floor_double(p_i1709_2_), MathHelper.floor_double(p_i1709_4_), MathHelper.floor_double(p_i1709_6_));
    }

    public EntityTravellingItem(World p_i1710_1_, double p_i1710_2_, double p_i1710_4_, double p_i1710_6_, ItemStack p_i1710_8_, int side)
    {
        this(p_i1710_1_, p_i1710_2_, p_i1710_4_, p_i1710_6_, side);        
        this.setItemStack(p_i1710_8_);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    public EntityTravellingItem(World p_i1711_1_)
    {
        super(p_i1711_1_);
        this.health = 5;
        this.setSize(0.1F, 0.1F);
        this.yOffset = 0.0F;
    }

    protected void entityInit()
    {
        this.getDataWatcher().addObjectByDataType(10, 5);
    }
    
    public AxisAlignedBB getBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(0.5, 0.5, 0.5, 0.5, 0.5, 0.5);
    }

    public boolean isInsideOfMaterial(Material p_70055_1_)
    {
    	return false;
    }

    public void applyEntityCollision(Entity p_70108_1_) {}

    public boolean canBeCollidedWith()
    {
        return false;
    }

    public boolean isEntityInsideOpaqueBlock()
    {
    	return false;
    }
    
    public AxisAlignedBB getCollisionBox(Entity p_70114_1_)
    {
        return null;
    }
    
    public boolean isEntityInvulnerable()
    {
        return true;
    }
    
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }
   
    @SideOnly(Side.CLIENT)
    public boolean canRenderOnFire()
    {
        return false;
    }
    
    public boolean isPushedByWater()
    {
        return false;
    }
    
    public boolean canBePushed()
    {
        return false;
    }
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        ItemStack item = getDataWatcher().getWatchableObjectItemStack(10);
        
        if (this.getItemstack() == null || (item != null && item.stackSize <= 0))
        {
            this.isDead = true;
        }
        else
        {
            int lastXCount = this.XposCounter;
            int lastYCount = this.YposCounter;
            int lastZCount = this.ZposCounter;
            this.noClip = true;
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            boolean flag2 = (this.XposCounter == 0 && lastXCount != 0) || (this.YposCounter == 0 && lastYCount != 0) || (this.ZposCounter == 0 && lastZCount != 0);

    		if (this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == null || !(this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) instanceof IInventory)) {
            	this.setDead();
    		}
    		
            if (flag2)
            {	
                if (this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) != null && this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) instanceof TileEntityItemPipe)
                {
                	if (!this.worldObj.isRemote) {
                		if(flag2) {
                        	TileEntityItemPipe pipeTile = (TileEntityItemPipe)this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
                        	
                        	this.side = ItemPipeHandler.whereToGo(pipeTile, this.side, this.getItemstack(), this);
                        	this.setMomentum(this.side, ItemPipeHandler.getPipeSpeed(pipeTile.type));
                        }
                	}
                }else if(this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) != null && this.worldObj.getTileEntity(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) instanceof IInventory) {
                	if (!this.worldObj.isRemote) {
                    	if (ItemPipeHandler.sendContentsToInv(this.worldObj, MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), this.side, this.getItemstack(), this.isDead, false)) {
                            this.isDead = true;
                    	}else{
                    		this.setDead();
                    	}
                	}
            	}
                if (this.bounceCounter >= Evercraft_Config_Machines.travellingItemBounceCounter) {
                	this.setDead();
                }
                if (!this.worldObj.isRemote)
                {
                    this.searchForOtherItemsNearby();
                }
            }
        }
    }
    
    public void setMomentum(int side, float speed) {
            	if (this.side == 0) {
            		this.motionX = 0;
            		this.motionY = speed;
            		this.motionZ = 0;
            	}else if (this.side == 1) {
            		this.motionX = 0;
            		this.motionY = -speed;
            		this.motionZ = 0;
            	}else if (this.side == 2) {
            		this.motionX = 0;
            		this.motionY = 0;
            		this.motionZ = speed;
            	}else if (this.side == 3) {
            		this.motionX = -speed;
            		this.motionY = 0;
            		this.motionZ = 0;
            	}else if (this.side == 4) {
            		this.motionX = speed;
            		this.motionY = 0;
            		this.motionZ = 0;
            	}else if (this.side == 5) {
            		this.motionX = 0;
            		this.motionY = 0;
            		this.motionZ = -speed;
            	}else{
            		this.setDead();
            	}
    }
    
    public void moveEntity(double posX, double posY, double posZ) {
        this.boundingBox.offset(posX, posY, posZ);
        this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0D;
        this.posY = (this.boundingBox.minY + (double)this.yOffset - (double)this.ySize);
        this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0D;
        
    	this.XposCounter = this.XposCounter + MathHelper.floor_double(NumberHelper.absoluteValue(this.motionX) * 10);
    	this.YposCounter = this.YposCounter + MathHelper.floor_double(NumberHelper.absoluteValue(this.motionY) * 10);
    	this.ZposCounter = this.ZposCounter + MathHelper.floor_double(NumberHelper.absoluteValue(this.motionZ) * 10);
    	if (NumberHelper.absoluteValue(this.XposCounter) >= 10) this.XposCounter = 0;
    	if (NumberHelper.absoluteValue(this.YposCounter) >= 10) this.YposCounter = 0;
    	if (NumberHelper.absoluteValue(this.ZposCounter) >= 10) this.ZposCounter = 0;
    }

    public void setPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_)
    {
        this.posX = p_70107_1_;
        this.posY = p_70107_3_;
        this.posZ = p_70107_5_;
        float f = this.width / 2.0F;
        float f1 = this.height;
        this.boundingBox.setBounds(p_70107_1_ - (double)f, p_70107_3_ - (double)this.yOffset + (double)this.ySize, p_70107_5_ - (double)f, p_70107_1_ + (double)f, p_70107_3_ - (double)this.yOffset + (double)this.ySize + (double)f1, p_70107_5_ + (double)f);
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {}
    
    public void setDead()
    {
    	if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getDataWatcher().getWatchableObjectItemStack(10)));
    	}
        this.isDead = true;
    }
    
    /**
     * Looks for other itemstacks nearby and tries to stack them together
     */
    private void searchForOtherItemsNearby()
    {
        Iterator iterator = this.worldObj.getEntitiesWithinAABB(EntityTravellingItem.class, this.boundingBox.expand(0.5D, 0.0D, 0.5D)).iterator();

        while (iterator.hasNext())
        {
            EntityTravellingItem entityitem = (EntityTravellingItem)iterator.next();
            this.combineItems(entityitem);
        }
    }

    /**
     * Tries to merge this item with the item passed as the parameter. Returns true if successful. Either this item or
     * the other item will  be removed from the world.
     */
    public boolean combineItems(EntityTravellingItem p_70289_1_)
    {
        if (p_70289_1_ == this)
        {
            return false;
        }
        else if (p_70289_1_.isEntityAlive() && this.isEntityAlive())
        {
            ItemStack itemstack = this.getItemstack();
            ItemStack itemstack1 = p_70289_1_.getItemstack();

            if (itemstack1.getItem() != itemstack.getItem())
            {
                return false;
            }
            else if (itemstack1.hasTagCompound() ^ itemstack.hasTagCompound())
            {
                return false;
            }
            else if (itemstack1.hasTagCompound() && !itemstack1.getTagCompound().equals(itemstack.getTagCompound()))
            {
                return false;
            }
            else if (itemstack1.getItem() == null)
            {
                return false;
            }
            else if (itemstack1.getItem().getHasSubtypes() && itemstack1.getItemDamage() != itemstack.getItemDamage())
            {
                return false;
            }
            else if (itemstack1.stackSize < itemstack.stackSize)
            {
                return p_70289_1_.combineItems(this);
            }
            else if (itemstack1.stackSize + itemstack.stackSize > itemstack1.getMaxStackSize())
            {
                return false;
            }
            else
            {
                itemstack1.stackSize += itemstack.stackSize;
                p_70289_1_.setItemStack(itemstack1);
                this.isDead = true;
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns if this entity is in water and will end up adding the waters velocity to the entity
     */
    public boolean handleWaterMovement()
    {
        return false;
    }

    /**
     * Will deal the specified amount of damage to the entity if the entity isn't immune to fire damage. Args:
     * amountDamage
     */
    protected void dealFireDamage(int p_70081_1_) {}

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
    	return false;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.setShort("Health", (short)((byte)this.health));
        p_70014_1_.setShort("Sides", (short)this.side);
        
        if (this.getItemstack() != null)
        {
            p_70014_1_.setTag("Item", this.getItemstack().writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        this.health = p_70037_1_.getShort("Health") & 255;
        this.side = p_70037_1_.getShort("Sides");
        
        NBTTagCompound nbttagcompound1 = p_70037_1_.getCompoundTag("Item");
        this.setItemStack(ItemStack.loadItemStackFromNBT(nbttagcompound1));

        ItemStack item = getDataWatcher().getWatchableObjectItemStack(10);

        if (item == null || item.stackSize <= 0)
        {
            this.isDead = true;
        }
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer p_70100_1_) {}

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return "";
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
    }

    /**
     * Teleports the entity to another dimension. Params: Dimension number to teleport to
     */
    public void travelToDimension(int p_71027_1_) {}

    /**
     * Returns the ItemStack corresponding to the Entity (Note: if no item exists, will log an error but still return an
     * ItemStack containing Block.stone)
     */
    public ItemStack getItemstack()
    {
        ItemStack itemstack = this.getDataWatcher().getWatchableObjectItemStack(10);
        return itemstack == null ? new ItemStack(Blocks.stone) : itemstack;
    }

    /**
     * Sets the ItemStack for this entity
     */
    public void setItemStack(ItemStack p_92058_1_)
    {
        this.getDataWatcher().updateObject(10, p_92058_1_);
        this.getDataWatcher().setObjectWatched(10);
    }

    public String func_145798_i()
    {
        return this.field_145802_g;
    }

    public void func_145797_a(String p_145797_1_)
    {
        this.field_145802_g = p_145797_1_;
    }

    public String func_145800_j()
    {
        return this.field_145801_f;
    }

    public void func_145799_b(String p_145799_1_)
    {
        this.field_145801_f = p_145799_1_;
    }
}