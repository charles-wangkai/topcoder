public class MeasuringTemperature {
	public double averageTemperature(int[] measuredValues) {
		int validNum = 0;
		int validTotal = 0;
		for (int i = 0; i < measuredValues.length; i++) {
			if (measuredValues[i] < -273) {
				continue;
			}
			boolean valid = false;
			for (int j = -2; j <= 2; j++) {
				if (j == 0) {
					continue;
				}
				int adj = i + j;
				if (adj >= 0
						&& adj < measuredValues.length
						&& Math.abs(measuredValues[adj] - measuredValues[i]) <= 2) {
					valid = true;
					break;
				}
			}
			if (valid) {
				validNum++;
				validTotal += measuredValues[i];
			}
		}
		if (validNum > 0) {
			return (double) validTotal / validNum;
		} else {
			return -300;
		}
	}
}
