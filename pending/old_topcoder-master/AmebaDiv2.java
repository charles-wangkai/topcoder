public class AmebaDiv2 {
	public int simulate(int[] X, int A) {
		int size = A;
		for (int oneX : X) {
			if (oneX == size) {
				size *= 2;
			}
		}
		return size;
	}
}
