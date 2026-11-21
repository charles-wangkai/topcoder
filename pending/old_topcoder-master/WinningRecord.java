public class WinningRecord {
	public int[] getBestAndWorst(String games) {
		int bestGame = 1;
		int bestWin = 0;
		int worstGame = games.length();
		int worstWin = games.length();
		int win = 0;
		for (int i = 0; i < games.length(); i++) {
			if (games.charAt(i) == 'W') {
				win++;
			}
			if (i < 2) {
				continue;
			}
			if (win * bestGame >= bestWin * (i + 1)) {
				bestGame = i + 1;
				bestWin = win;
			}
			if (win * worstGame <= worstWin * (i + 1)) {
				worstGame = i + 1;
				worstWin = win;
			}
		}
		return new int[] { bestGame, worstGame };
	}
}
