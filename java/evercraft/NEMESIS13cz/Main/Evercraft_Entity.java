package evercraft.NEMESIS13cz.Main;

import cpw.mods.fml.common.registry.EntityRegistry;
import evercraft.NEMESIS13cz.Evercraft;
import evercraft.NEMESIS13cz.Entity.EntityObsidiumArrow;
import evercraft.NEMESIS13cz.Entity.EntityBronzeArrow;
import evercraft.NEMESIS13cz.Entity.EntityCopperArrow;
import evercraft.NEMESIS13cz.Entity.EntityDiamondArrow;
import evercraft.NEMESIS13cz.Entity.EntityDerpyArrow;
import evercraft.NEMESIS13cz.Entity.EntityGoldArrow;
import evercraft.NEMESIS13cz.Entity.EntityIronArrow;
import evercraft.NEMESIS13cz.Entity.EntityLapisArrow;
import evercraft.NEMESIS13cz.Entity.EntityRedstoneArrow;
import evercraft.NEMESIS13cz.Entity.EntitySteelArrow;
import evercraft.NEMESIS13cz.Entity.EntityTravellingItem;

public class Evercraft_Entity {

	public static void registerEntity() {
		EntityRegistry.registerModEntity(EntityCopperArrow.class,"copperarrow", 0, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityBronzeArrow.class,"bronzearrow", 1, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntitySteelArrow.class,"steelarrow", 2, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityLapisArrow.class,"lapisarrow", 3, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityRedstoneArrow.class,"redstonearrow", 4, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityObsidiumArrow.class,"obsidiumarrow", 5, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityDerpyArrow.class,"derpyarrow", 6, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityIronArrow.class,"ironarrow", 7, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityGoldArrow.class,"goldarrow", 8, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityDiamondArrow.class,"diamondarrow", 9, Evercraft.getEvercraft(), 160, 3, true);
		EntityRegistry.registerModEntity(EntityTravellingItem.class, "travellingitem", 10, Evercraft.getEvercraft(), 64, 1, true);

		Evercraft.log.info("Entities registered");
	}
}
