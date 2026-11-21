public class ScrabbleBet {
	public double estimate(int trials, int games, int winsNeeded, int winChance) {
		double winProb = winChance / 100.0;
		double loseProbForGame = 0;
		for (int i = 0; i < winsNeeded; i++) {
			loseProbForGame += C(games, i) * Math.pow(winProb, i)
					* Math.pow(1 - winProb, games - i);
		}
		return 1 - Math.pow(loseProbForGame, trials);
	}

	int C(int n, int m) {
		long result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		for (int i = 1; i <= m; i++) {
			result /= i;
		}
		return (int) result;
	}
}
