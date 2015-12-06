package evercraft.NEMESIS13cz.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import evercraft.NEMESIS13cz.Blocks.Machines.BlockItemPipe;
import evercraft.NEMESIS13cz.Main.Achievements;
import evercraft.NEMESIS13cz.Main.Evercraft_Blocks;
import evercraft.NEMESIS13cz.Main.Evercraft_Items;

public class ECAchievementTrigger
{
	@SubscribeEvent
	public void crafted(PlayerEvent.ItemCraftedEvent event) {
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockfurniturecrafter))) {
			event.player.addStat(Achievements.advCrafter, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockadvancedcrusherOff))) {
			event.player.addStat(Achievements.advCrusher, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockadvancedelectrolyzerOff))) {
			event.player.addStat(Achievements.advElectrolyzer, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockindustrialfurnaceOff))) {
			event.player.addStat(Achievements.advFurnace, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockalloyfurnaceOff))) {
			event.player.addStat(Achievements.alloyFurnace, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockredstonitecable))) {
			event.player.addStat(Achievements.cables, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockCapStorage))) {
			event.player.addStat(Achievements.CapArray, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockcentrifugeOff))) {
			event.player.addStat(Achievements.centrifuge, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockcrusherOff))) {
			event.player.addStat(Achievements.crusher, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockcuttingmachineOff))) {
			event.player.addStat(Achievements.cuttingMachine, 1);
		}
		if (event.crafting.getItem().equals(Evercraft_Items.derpyingot)) {
			event.player.addStat(Achievements.derpyIngot, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockelectrolyzerOff))) {
			event.player.addStat(Achievements.electrolyzer, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockstandardgeneratorOff))) {
			event.player.addStat(Achievements.ethericGenerator, 1);
		}
		if (event.crafting.getItem().equals(Evercraft_Items.hammer)) {
			event.player.addStat(Achievements.hammer, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockhammeringmachineOff))) {
			event.player.addStat(Achievements.hammeringMachine, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockheatgeneratorOff_Idle))) {
			event.player.addStat(Achievements.heatGenerator, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockhightemperaturefurnaceOff))) {
			event.player.addStat(Achievements.HTFurnace, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockminingmachine))) {
			event.player.addStat(Achievements.miner, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockmixingtable))) {
			event.player.addStat(Achievements.mixingTable, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockorefactoryOff))) {
			event.player.addStat(Achievements.oreProcessPlant, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockplatemillOff))) {
			event.player.addStat(Achievements.plateMill, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockparticlemergerOff))) {
			event.player.addStat(Achievements.pressurizer, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockrepulsivecrusherOff))) {
			event.player.addStat(Achievements.repCrusher, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blocksolargenerator))) {
			event.player.addStat(Achievements.solarGenerator, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockWRSreceiverOff))) {
			event.player.addStat(Achievements.wirelessRedstone, 1);
		}
		if (event.crafting.getItem().equals(Item.getItemFromBlock(Evercraft_Blocks.blockWRStransmitter))) {
			event.player.addStat(Achievements.wirelessRedstone, 1);
		}
		if (event.crafting.getItem().equals(Evercraft_Items.WRScoordinator)) {
			event.player.addStat(Achievements.wirelessRedstone, 1);
		}
	}
}