import java.util.Arrays;

public class UnsortedSequence {
	public int[] getUnsorted(int[] s) {
		Arrays.sort(s);
		for (int i = s.length - 1; i > 0; i--) {
			if (s[i] > s[i - 1]) {
				int temp = s[i];
				s[i] = s[i - 1];
				s[i - 1] = temp;
				return s;
			}
		}
		return new int[0];
	}
}
