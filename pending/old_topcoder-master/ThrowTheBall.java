public class ThrowTheBall {
	public int timesThrown(int N, int M, int L) {
		int players[] = new int[N];
		int ball = 0;
		for (int i = 0;; i++) {
			players[ball]++;
			if (players[ball] == M) {
				return i;
			}
			if (players[ball] % 2 == 0) {
				ball = (ball + L) % N;
			} else {
				ball = (ball - L + N) % N;
			}
		}
	}
}
