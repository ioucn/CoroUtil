package CoroUtil.util;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;

import com.google.common.collect.Multimap;

public class CoroUtilItem {

	public static Item setUnlocalizedNameAndTexture(Item item, String nameTex) {
		item.setUnlocalizedName(nameTex);
		item.setTextureName(nameTex);
    	return item;
    }
	
	public static Item getItemByName(String name) {
		try {
			Object obj = Item.itemRegistry.getObject(name);
			if (obj != null) {
				return (Item) obj;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String getNameByItem(Item item) {
		return Item.itemRegistry.getNameForObject(item);
	}
	
	public static float getLeftClickDamage(ItemStack is) {
		if (is.getItem() == null) return 0;
		ServersideAttributeMap attributes = new ServersideAttributeMap();
		attributes.registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		Multimap map = is.getItem().getAttributeModifiers(is);
		attributes.applyAttributeModifiers(map);
		try {
			return (float)attributes.getAttributeInstance(SharedMonsterAttributes.attackDamage).getAttributeValue();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
	}
	
	public static EntityItem tossItemFromEntity(Entity parEnt, ItemStack p_146097_1_, boolean p_146097_2_, boolean p_146097_3_)
    {
		
		Random rand = new Random();
		
        if (p_146097_1_ == null)
        {
            return null;
        }
        else if (p_146097_1_.stackSize == 0)
        {
            return null;
        }
        else
        {
            EntityItem entityitem = new EntityItem(parEnt.worldObj, parEnt.posX, parEnt.posY - 0.30000001192092896D + (double)parEnt.getEyeHeight(), parEnt.posZ, p_146097_1_);
            entityitem.delayBeforeCanPickup = 40;

            if (p_146097_3_)
            {
                entityitem.func_145799_b(parEnt.getCommandSenderName());
            }

            float f = 0.1F;
            float f1;

            if (p_146097_2_)
            {
                f1 = rand.nextFloat() * 0.5F;
                float f2 = rand.nextFloat() * (float)Math.PI * 2.0F;
                entityitem.motionX = (double)(-MathHelper.sin(f2) * f1);
                entityitem.motionZ = (double)(MathHelper.cos(f2) * f1);
                entityitem.motionY = 0.20000000298023224D;
            }
            else
            {
                f = 0.3F;
                entityitem.motionX = (double)(-MathHelper.sin(parEnt.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(parEnt.rotationPitch / 180.0F * (float)Math.PI) * f);
                entityitem.motionZ = (double)(MathHelper.cos(parEnt.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(parEnt.rotationPitch / 180.0F * (float)Math.PI) * f);
                entityitem.motionY = (double)(-MathHelper.sin(parEnt.rotationPitch / 180.0F * (float)Math.PI) * f + 0.1F);
                f = 0.02F;
                f1 = rand.nextFloat() * (float)Math.PI * 2.0F;
                f *= rand.nextFloat();
                entityitem.motionX += Math.cos((double)f1) * (double)f;
                entityitem.motionY += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F);
                entityitem.motionZ += Math.sin((double)f1) * (double)f;
            }

            parEnt.worldObj.spawnEntityInWorld(entityitem);
            //this.addStat(StatList.dropStat, 1);
            return entityitem;
        }
    }
	
	
	
}
