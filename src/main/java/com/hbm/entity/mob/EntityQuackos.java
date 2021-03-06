package com.hbm.entity.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 *  BOW
 */
public class EntityQuackos extends EntityDuck implements IBossDisplayData {

    /**
     *  BOW
     */
	public EntityQuackos(World world) {
		super(world);
        this.setSize(0.3F * 25, 0.7F * 25);
	}
    
    /**
     *  BOW
     */
    protected String getLivingSound() {
        return "hbm:entity.megaquacc";
    }
    
    /**
     *  BOW
     */
    protected String getHurtSound() {
        return "hbm:entity.megaquacc";
    }
    
    /**
     *  BOW
     */
    protected String getDeathSound() {
        return "hbm:entity.megaquacc";
    }
    
    /**
     *  BOW
     */
    public EntityQuackos createChild(EntityAgeable entity)
    {
        return new EntityQuackos(this.worldObj);
    }
    
    /**
     *  BOW
     */
    public boolean isEntityInvulnerable() {
        return true;
    }
    
    /**
     *  BOW
     */
	public boolean interact(EntityPlayer player) {
		
		if(super.interact(player)) {
			return true;
			
		} else if(!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player)) {
			player.mountEntity(this);
			return true;
			
		} else {
			return false;
		}
    }
    
    /**
     *  BOW
     */
    public void updateRiderPosition() {
    	
        super.updateRiderPosition();
        float f = MathHelper.sin(this.renderYawOffset * (float)Math.PI / 180.0F);
        float f1 = MathHelper.cos(this.renderYawOffset * (float)Math.PI / 180.0F);
        float f2 = 0.1F;
        float f3 = 0.0F;
        this.riddenByEntity.setPosition(this.posX + (double)(f2 * f), this.posY + (double)(this.height - 0.125F) + this.riddenByEntity.getYOffset() + (double)f3, this.posZ - (double)(f2 * f1));

        if (this.riddenByEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
        }
    }
}
