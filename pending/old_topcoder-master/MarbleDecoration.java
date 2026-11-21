import java.util.Arrays;

public class MarbleDecoration {
	public int maxLength(int R, int G, int B) {
		int colors[] = { R, G, B };
		Arrays.sort(colors);
		if (colors[1] == colors[2]) {
			return colors[1] * 2;
		} else {
			return colors[1] * 2 + 1;
		}
	}
}
