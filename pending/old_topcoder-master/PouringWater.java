public class PouringWater {
	public int getMinBottles(int N, int K) {
		for (int i = 0; i < K - 1; i++) {
			int power2 = 1;
			while ((power2 << 1) <= N) {
				power2 <<= 1;
			}
			N -= power2;
			if (N == 0) {
				return 0;
			}
		}
		int power2 = 1;
		while (power2 < N) {
			power2 <<= 1;
		}
		return power2 - N;
	}
}
