package evercraft.NEMESIS13cz.Utils;

public class NumberHelper {

	/**
	 * Cuts a positive Integer into 3 shorts.
	 * 
	 * @param Number
	 * @return String Array
	 */
	
	public static short[] Int2Short(int num) {
		short sh1 = (short)(num & 0x00007FFF);
		short sh2 = (short)((num >> 15) & 0x00007FFF);
		short sh3 = (short)((num >> 30) & 0x0001);
		
		return new short[] {sh3, sh2, sh1};
	}
	
	/**
	 * Creates a positive Integer from 3 shorts.
	 * 
	 * @param Short 1
	 * @param Short 2
	 * @param Short 3
	 * @return Integer
	 */
	
	public static int Short2Int(short sh1, short sh2, short sh3) {
		int in1 = (sh1 << 30) & 0xC0000000;
		int in2 = (sh2 << 15) & 0x3FFF8000;
		
		return in1 + in2 + sh3;
	}
	
	/**
	 * Converts a boolean into a short.
	 * 
	 * @param b
	 * @return short
	 */
	
	public static short boolean2Short(boolean b) {
		return (short) (b ? 1 : 0);
	}
	
	/**
	 * Creates a boolean from a short.
	 * 
	 * @param s
	 * @return boolean
	 */
	
	public static boolean short2boolean(short s) {
		return s == 1;
	}
	
	/**
	 * Converts a boolean into an integer.
	 * 
	 * @param b
	 * @return integer
	 */
	
	public static int boolean2Int(boolean b) {
		return (b ? 1 : 0);
	}
	
	/**
	 * Creates a boolean from an integer.
	 * 
	 * @param i
	 * @return boolean
	 */
	
	public static boolean int2boolean(int i) {
		return i == 1;
	}
	
	/**
	 * Returns the positive value of an integer.
	 * 
	 * @param i
	 * @return integer
	 */
	
	public static int absoluteValue(int i) {
		return i >= 0 ? i : -i;
	}
	
	/**
	 * Returns the positive value of an double.
	 * 
	 * @param i
	 * @return double
	 */
	
	public static double absoluteValue(double i) {
		return i >= 0 ? i : -i;
	}
}
