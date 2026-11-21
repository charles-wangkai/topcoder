import java.util.Arrays;

public class BoundingBox {
	public int smallestArea(int[] X, int[] Y) {
		return span(X) * span(Y);
	}

	int span(int[] a) {
		return Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt();
	}
}
