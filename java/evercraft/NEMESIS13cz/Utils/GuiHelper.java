package evercraft.NEMESIS13cz.Utils;

import java.util.ArrayList;

public class GuiHelper {

	public static String TicksIntoTime(int inputTicks) {
		float secsUnprocessed = (float)inputTicks / 20;
		
		ArrayList<String> time = new ArrayList<String>();
		
		int hours = 0;
		int minutes = 0;
		float seconds = 0.0F;
		
		while (secsUnprocessed >= 3600.0F) {
			secsUnprocessed -= 3600.0F;
			hours += 1;
		}
		while (secsUnprocessed >= 60.0F) {
			secsUnprocessed -= 60.0F;
			minutes += 1;
		}
		seconds = secsUnprocessed;
		
		if (hours > 0) {
			time.add(Integer.toString(hours) + "h");
		}
		if (minutes > 0) {
			time.add(Integer.toString(minutes) + "min");
		}
		if (seconds > 0.0F) {
			time.add(Float.toString(seconds) + "s");
		}
		
		return time.toString().replace("[", "").replace("]", "").replace(",", "");
	}

}
