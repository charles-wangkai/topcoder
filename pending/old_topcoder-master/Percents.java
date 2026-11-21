public class Percents {
	public int minSamples(String percent) {
		int percentMultiply10000 = Integer.parseInt(percent.replaceAll("\\D",
				""));
		for (int i = 1;; i++) {
			int floorYes = i * percentMultiply10000 / 10000;
			if (isSamePercentage(floorYes, i, percentMultiply10000)
					|| isSamePercentage(floorYes + 1, i, percentMultiply10000)) {
				return i;
			}
		}
	}

	boolean isSamePercentage(int yes, int total, int percentMultiply10000) {
		return (yes * 100000L / total + 5) / 10 == percentMultiply10000;
	}
}
