public class TheFansAndMeetingsDivTwo {
	public double find(int[] minJ, int[] maxJ, int[] minB, int[] maxB) {
		double[] jProbs = calcProbs(minJ, maxJ);
		double[] bProbs = calcProbs(minB, maxB);
		double result = 0;
		for (int i = 0; i < jProbs.length; i++) {
			result += jProbs[i] * bProbs[i];
		}
		return result;
	}

	double[] calcProbs(int[] min, int[] max) {
		double[] probs = new double[51];
		for (int i = 0; i < min.length; i++) {
			double addition = 1.0 / min.length / (max[i] - min[i] + 1);
			for (int j = min[i]; j <= max[i]; j++) {
				probs[j] += addition;
			}
		}
		return probs;
	}
}
