public class PillarsDivTwo {
	public double maximalLength(int[] height, int w) {
		double[] lengths = new double[height[0] + 1];
		for (int i = 1; i < height.length; i++) {
			double[] nextLengths = new double[height[i] + 1];
			for (int j = 1; j < nextLengths.length; j++) {
				for (int k = 1; k < lengths.length; k++) {
					nextLengths[j] = Math.max(nextLengths[j], lengths[k]
							+ computeHypotenuse(j - k, w));
				}
			}
			lengths = nextLengths;
		}
		double maxLength = -1;
		for (double length : lengths) {
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}

	double computeHypotenuse(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}
}
