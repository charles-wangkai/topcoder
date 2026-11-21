public class RecursiveFigures {
	public double getArea(int sideLength, int K) {
		double area = 0;
		double r = sideLength / 2.0;
		for (int i = K; i >= 1; i--) {
			if (i == 1) {
				area += Math.PI * r * r;
			} else {
				area += (Math.PI - 2) * r * r;
			}
			r /= Math.sqrt(2);
		}
		return area;
	}
}
