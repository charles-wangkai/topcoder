public class DrawingMarbles {
	public double sameColor(int[] colors, int n) {
		int total = 0;
		for (int color : colors) {
			total += color;
		}
		double result = 0;
		for (int color : colors) {
			if (color >= n) {
				double current = 1;
				for (int i = color; i > color - n; i--) {
					current *= (double) i / (total - (color - i));
				}
				result += current;
			}
		}
		return result;
	}
}
