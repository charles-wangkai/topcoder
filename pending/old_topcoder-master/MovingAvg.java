public class MovingAvg {
	public double difference(int k, double[] data) {
		double minAvg = Double.MAX_VALUE;
		double maxAvg = -Double.MAX_VALUE;
		for (int i = 0; i + k <= data.length; i++) {
			double sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += data[j];
			}
			double avg = sum / k;
			minAvg = Math.min(minAvg, avg);
			maxAvg = Math.max(maxAvg, avg);
		}
		return maxAvg - minAvg;
	}
}
