public class GuessingNextElement {
	public int guess(int[] A) {
		if (A[0] + A[2] == 2 * A[1]) {
			return A[1] - A[0] + A[A.length - 1];
		} else {
			return A[1] / A[0] * A[A.length - 1];
		}
	}
}
