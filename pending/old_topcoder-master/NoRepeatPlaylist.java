public class NoRepeatPlaylist {
	static final int MODULO = 1000000007;

	public int numPlaylists(int N, int M, int P) {
		int[][] ways = new int[P + 1][N + 1];
		ways[0][0] = 1;
		for (int i = 1; i <= P; i++) {
			for (int j = 1; j <= N; j++) {
				if (j > M) {
					ways[i][j] = addMod(ways[i][j],
							multiplyMod(ways[i - 1][j], j - M));
				}
				ways[i][j] = addMod(ways[i][j],
						multiplyMod(ways[i - 1][j - 1], N - j + 1));
			}
		}
		return ways[P][N];
	}

	int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}
}
