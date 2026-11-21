public class SortEstimate {
	public double howMany(int c, int time) {
		double lower = 1;
		double upper = Math.max((double) time / c, 2);
		double previous = -1;
		while (true) {
			double current = (lower + upper) / 2;
			if (f(c, current) < time) {
				lower = current;
			} else {
				upper = current;
			}
			if (Math.abs(current - previous) < 1E-12) {
				return current;
			}
			previous = current;
		}
	}

	double f(int c, double n) {
		return c * n * Math.log(n) / Math.log(2);
	}
}
