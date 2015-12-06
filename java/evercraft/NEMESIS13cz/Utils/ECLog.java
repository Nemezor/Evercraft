package evercraft.NEMESIS13cz.Utils;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import evercraft.NEMESIS13cz.ModInformation;

public class ECLog {
	
	/**
	 * Logs information using Evercrafts mod name.
	 * 
	 * @param level
	 * @param obj
	 */
	
	public static void log(Level level, Object obj) {
		FMLLog.log(ModInformation.NAME, level, String.valueOf(obj));
	}
	
	/**
	 * logs information (level all)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void all(Object obj) {
		log(Level.ALL, obj);
	}
	
	/**
	 * logs information (level debug)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void debug(Object obj) {
		log(Level.DEBUG, obj);
	}

	/**
	 * logs information (level error)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void error(Object obj) {
		log(Level.ERROR, obj);
	}

	/**
	 * logs information (level fatal)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void fatal(Object obj) {
		log(Level.FATAL, obj);
	}

	/**
	 * logs information (level information)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void info(Object obj) {
		log(Level.INFO, obj);
	}

	/**
	 * logs information (level off)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void off(Object obj) {
		log(Level.OFF, obj);
	}

	/**
	 * logs information (level trace)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void trace(Object obj) {
		log(Level.TRACE, obj);
	}

	/**
	 * logs information (level warning)
	 * calls log
	 * 
	 * @param obj
	 */
	
	public static void warn(Object obj) {
		log(Level.WARN, obj);
	}
}
