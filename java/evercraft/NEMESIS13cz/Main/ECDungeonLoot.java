package evercraft.NEMESIS13cz.Main;

import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Config.Evercraft_Config_Base;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class ECDungeonLoot {
	
	public static void addMobs() {
		if (Evercraft_Config_Base.creeperDungeons == true) {
			DungeonHooks.addDungeonMob("Creeper", 100);
			
			Evercraft.log.info("Special dungeons registered");
			
		}
	}
	
	public static void addLoot() {
		/**
		 * BONUS CHEST
		 */
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.woolcard, 1, 0), 1, 1, 3));
		
		if (Evercraft_Config_Base.dungeonLoot == true) {
			/**
			 * DUNGEON
			 */
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 4, 18, 20));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 2, 14, 18));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.ironarrow), 4, 19, 14));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.aluminiumingot), 1, 7, 10));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelingot), 2, 7, 5));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.titaniumingot), 2, 4, 4));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.goldbow), 1, 1, 9));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.derpyingot, 1, 0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.silveringot), 1, 4, 10));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.zincingot), 4, 7, 14));
			/**
			 * PYRAMID
			 */
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.ironmultitool), 1, 1, 15));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.obsidianingot), 1, 4, 10));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.diamondstick), 2, 3, 7));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 7, 21, 18));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 4, 17, 16));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.obsidiumleggings), 1, 1, 7));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.silveringot), 3, 8, 8));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.zincingot), 2, 6, 10));
			/**
			 * TEMPLE
			 */
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.diamondbow), 1, 1, 4));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.obsidiumgem), 1, 4, 6));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.aluminiumingot), 1, 8, 8));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.titaniumingot), 1, 5, 4));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 6, 20, 12));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 7, 20, 14));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.silveringot), 3, 4, 11));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.zincingot), 2, 7, 13));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 6, 20, 20));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 7, 20, 15));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.lapisboots), 1, 1, 9));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.redstonechestplate), 1, 1, 11));
			/**
			 * STRONGHOLD
			 */
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.derpybow), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.redstonesword), 1, 1, 12));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.lapismultitool), 1, 1, 9));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 3, 12, 15));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 2, 9, 14));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.silveringot), 2, 4, 11));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.zincingot), 1, 4, 13));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.aluminiumingot), 1, 5, 7));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelingot), 1, 7, 8));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.derpybow), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.redstonesword), 1, 1, 9));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.lapismultitool), 1, 1, 6));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 3, 12, 20));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 2, 9, 18));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.aluminiumingot), 1, 5, 14));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelingot), 1, 7, 9));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelpickaxe), 1, 1, 8));
			/**
			 * MINESHAFT
			 */
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelpickaxe), 1, 1, 7));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperingot), 7, 22, 25));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.tiningot), 6, 15, 23));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.aluminiumingot), 3, 8, 12));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelingot), 2, 5, 8));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.titaniumingot), 1, 4, 6));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.hardenedredstoneingot), 2, 5, 10));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.hardenedlapisingot), 1, 7, 10));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.redstoniteingot), 2, 4, 9));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.electrumingot), 1, 3, 10));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.brassingot), 4, 6, 13));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.bronzeingot), 2, 5, 14));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.infernalcoal), 3, 9, 16));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.silveringot), 3, 8, 18));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.zincingot), 2, 6, 21));
			/**
			 * BLACKSMITH
			 */
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.redstonehelmet), 1, 1, 14));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.derpychestplate), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.obsidiumboots), 1, 1, 12));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.copperchestplate), 1, 1, 15));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.bronzeleggings), 1, 1, 14));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.steelhoe), 1, 1, 8));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Items.lapispickaxe), 1, 1, 10));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Blocks.blockcasing1), 3, 7, 12));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Blocks.blockcasing2), 2, 5, 10));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Evercraft_Blocks.blockcasing3), 1, 2, 3));
			

			Evercraft.log.info("Special loot registered");
			
		}
	}
	
}
