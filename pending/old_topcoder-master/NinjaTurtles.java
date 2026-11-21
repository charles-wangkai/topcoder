public class NinjaTurtles {
	public int countOpponents(int P, int K) {
		for (int N = 0;; N++) {
			int pizza = N / 3 + N / K * 3;
			if (pizza == P) {
				return N;
			} else if (pizza > P) {
				return -1;
			}
		}
	}
}
