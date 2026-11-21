public class FixedPointTheorem {
	public double cycleRange(double R) {
		double min = Double.MAX_VALUE;
		double max = -Double.MAX_VALUE;
		double x = 0.25;
		for (int i = 0; i < 201000; i++) {
			x = R * x * (1 - x);
			if (i >= 200000) {
				min = Math.min(min, x);
				max = Math.max(max, x);
			}
		}
		return max - min;
	}
}
