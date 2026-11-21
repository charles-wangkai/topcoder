public class ChainOfRectangles {
	public int getMaximalArea(int[] width, int[] height, String color) {
		int redArea = 0;
		int greenArea = 0;
		int blueArea = 0;
		for (int i = 0; i < width.length; i++) {
			int area;
			if (i < width.length - 1) {
				area = width[i] * height[i] - width[i + 1] * height[i + 1];
			} else {
				area = width[i] * height[i];
			}
			char c = color.charAt(i);
			if (c == 'R') {
				redArea += area;
			} else if (c == 'G') {
				greenArea += area;
			} else if (c == 'B') {
				blueArea += area;
			}
		}
		return Math.max(Math.max(redArea, greenArea), blueArea);
	}
}
