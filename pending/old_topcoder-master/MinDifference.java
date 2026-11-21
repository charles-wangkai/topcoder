import java.util.Arrays;

public class MinDifference {
	public int closestElements(int A0, int X, int Y, int M, int n) {
		int A[] = new int[n];
		A[0] = A0;
		for (int i = 1; i < A.length; i++) {
			A[i] = (A[i - 1] * X + Y) % M;
		}
		Arrays.sort(A);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			minDiff = Math.min(minDiff, Math.abs(A[i] - A[i - 1]));
		}
		return minDiff;
	}
}
