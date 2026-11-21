import java.util.Arrays;

public class Fractile {
	public int fractile(int[] x, int p) {
		Arrays.sort(x);
		return x[Math.max((int) Math.ceil(x.length / 100.0 * p) - 1, 0)];
	}
}
