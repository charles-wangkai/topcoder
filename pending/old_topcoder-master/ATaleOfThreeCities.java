import java.util.Arrays;

public class ATaleOfThreeCities {
	public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx,
			int[] cy) {
		double distances[] = { findClosest(ax, ay, bx, by),
				findClosest(bx, by, cx, cy), findClosest(cx, cy, ax, ay) };
		Arrays.sort(distances);
		return distances[0] + distances[1];
	}

	double findClosest(int x1[], int y1[], int x2[], int y2[]) {
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x2.length; j++) {
				minDistance = Math.min(
						minDistance,
						Math.sqrt((x1[i] - x2[j]) * (x1[i] - x2[j])
								+ (y1[i] - y2[j]) * (y1[i] - y2[j])));
			}
		}
		return minDistance;
	}
}
