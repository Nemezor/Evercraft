package evercraft.NEMESIS13cz.Utils;

import net.minecraft.item.ItemStack;

public class ItemStackHelper {
	
	/**
	 * Compares ItemStacks, returns false if one of them is null.
	 * 
	 * @param stack1
	 * @param stack2
	 * @return boolean are equal
	 */
	
	public static boolean areItemStacksEqual(ItemStack stack1, ItemStack stack2) {
		if (stack1 != null && stack2 != null) {
			return stack1.getItemDamage() == stack2.getItemDamage() && stack1.getItem() == stack2.getItem();
		}
		return false;
	}

	/**
	 * Compares ItemStacks, if both are null, returns true.
	 * 
	 * @param stack1
	 * @param stack2
	 * @return boolean are equal
	 */
	
	public static boolean areItemStacksEqualInclNull(ItemStack stack1, ItemStack stack2) {
		if (stack1 == null && stack2 == null) {
			return true;
		}
		if (stack1 != null && stack2 != null) {
			return stack1.getItemDamage() == stack2.getItemDamage() && stack1.getItem() == stack2.getItem();
		}
		return false;
	}
	
	/**
	 * Compares ItemStacks AND their stacksizes.
	 * 
	 * @param stack1
	 * @param stack2
	 * @return boolean are equal
	 */
	
	public static boolean areItemStacksEqualInclStacksize(ItemStack stack1, ItemStack stack2) {
		if (stack1 != null && stack2 != null) {
			return stack1.getItemDamage() == stack2.getItemDamage() && stack1.getItem() == stack2.getItem() && stack1.stackSize == stack2.stackSize;
		}
		return false;
	}

	/**
	 * Compares ItemStacks AND their stacksizes, if both are null, returns true.
	 * 
	 * @param stack1
	 * @param stack2
	 * @return boolean are equal
	 */
	
	public static boolean areItemStacksEqualInclStacksizeAndNull(ItemStack stack1, ItemStack stack2) {
		if (stack1 == null && stack2 == null) {
			return true;
		}
		if (stack1 != null && stack2 != null) {
			return stack1.getItemDamage() == stack2.getItemDamage() && stack1.getItem() == stack2.getItem() && stack1.stackSize == stack2.stackSize;
		}
		return false;
	}
}
