public class WidgetRepairs {
	public int days(int[] arrivals, int numPerDay) {
		int repairDay = 0;
		int widgetNum = 0;
		for (int i = 0;; i++) {
			if (i >= arrivals.length && widgetNum == 0) {
				return repairDay;
			}
			if (i < arrivals.length) {
				widgetNum += arrivals[i];
			}
			int repaired = Math.min(widgetNum, numPerDay);
			if (repaired > 0) {
				widgetNum -= repaired;
				repairDay++;
			}
		}
	}
}
