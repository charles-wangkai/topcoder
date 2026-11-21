public class GymTraining {
	public int trainingTime(int needToTrain, int minPulse, int maxPulse,
			int trainChange, int restChange) {
		if (minPulse + trainChange > maxPulse) {
			return -1;
		}
		int pulse = minPulse;
		for (int i = 1;; i++) {
			if (pulse + trainChange <= maxPulse) {
				pulse += trainChange;
				needToTrain--;
				if (needToTrain == 0) {
					return i;
				}
			} else {
				pulse = Math.max(pulse - restChange, minPulse);
			}
		}
	}
}
