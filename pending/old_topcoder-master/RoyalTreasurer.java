import java.util.Arrays;

public class RoyalTreasurer {
	public int minimalArrangement(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result += A[i] * B[B.length - 1 - i];
		}
		return result;
	}
}
