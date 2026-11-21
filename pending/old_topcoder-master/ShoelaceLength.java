public class ShoelaceLength {
	public double calculate(int startWidth, int endWidth, int spread,
			int numPairs) {
		double total = startWidth;
		double widthStep = (endWidth - startWidth) / (numPairs - 1.0);
		double width = startWidth;
		for (int i = 0; i < numPairs - 1; i++) {
			double horizontal = width + widthStep / 2;
			double diagonal = Math.sqrt(horizontal * horizontal + spread
					* spread);
			total += diagonal * 2;
			width += widthStep;
		}
		return total;
	}
}
