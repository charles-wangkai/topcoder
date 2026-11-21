import java.util.Arrays;

public class ChangingString {
	public int distance(String A, String B, int K) {
		int diffs[] = new int[A.length()];
		for (int i = 0; i < diffs.length; i++) {
			diffs[i] = Math.abs(A.charAt(i) - B.charAt(i));
		}
		Arrays.sort(diffs);
		for (int i = diffs.length - 1; i >= diffs.length - K; i--) {
			diffs[i] = (diffs[i] == 0) ? 1 : 0;
		}
		int sum = 0;
		for (int diff : diffs) {
			sum += diff;
		}
		return sum;
	}
}
