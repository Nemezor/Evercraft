package evercraft.NEMESIS13cz.misc;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class ECCraftingHandler {

	@SubscribeEvent
	public void crafted(PlayerEvent.ItemCraftedEvent event) {
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {               
			if(event.craftMatrix.getStackInSlot(i) != null) {
				ItemStack stack = event.craftMatrix.getStackInSlot(i);
				if(stack.getItem() != null && stack.getItem() == Evercraft_Items.hammer) {
		         	ItemStack stack_new = new ItemStack(Evercraft_Items.hammer, 2, (stack.getItemDamage() + 1));
		         	if(stack_new.getItemDamage() >= stack_new.getMaxDamage()) { 
		         		stack_new.stackSize--;
		         	}
		         	event.craftMatrix.setInventorySlotContents(i, stack_new);
				}
			}
		}
	}
}