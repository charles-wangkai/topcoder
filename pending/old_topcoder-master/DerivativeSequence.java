public class DerivativeSequence {
	public int[] derSeq(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int derivative[] = new int[a.length - 1];
			for (int j = 0; j < derivative.length; j++) {
				derivative[j] = a[j + 1] - a[j];
			}
			a = derivative;
		}
		return a;
	}
}
