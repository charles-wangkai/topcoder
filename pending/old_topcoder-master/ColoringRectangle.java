import java.util.Arrays;

public class ColoringRectangle {
	public int chooseDisks(int width, int height, int[] red, int[] blue) {
		Arrays.sort(red);
		Arrays.sort(blue);
		int minDisk = Math.min(placeDisks(width, height, red, blue),
				placeDisks(width, height, blue, red));
		return (minDisk == Integer.MAX_VALUE) ? -1 : minDisk;
	}

	int placeDisks(int width, int height, int color1[], int color2[]) {
		int diameters[][] = new int[][] { color1, color2 };
		int indices[] = new int[] { color1.length - 1, color2.length - 1 };
		int color = 0;
		double rest = width;
		for (int i = 1; indices[color] >= 0
				&& diameters[color][indices[color]] >= height; i++) {
			rest -= Math.sqrt(diameters[color][indices[color]]
					* diameters[color][indices[color]] - height * height);
			if (rest <= 0) {
				return i;
			}
			indices[color]--;
			color = 1 - color;
		}
		return Integer.MAX_VALUE;
	}
}
