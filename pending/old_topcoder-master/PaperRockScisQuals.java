public class PaperRockScisQuals {
	public int whoPassed(String[] players) {
		int maxScoreDouble = -1;
		int passIndex = -1;
		for (int i = 0; i < players.length; i++) {
			int scoreDouble = 0;
			for (int j = 0; j < players.length; j++) {
				if (j == i) {
					continue;
				}
				int winScore = 0;
				for (int k = 0; k < 5; k++) {
					winScore += getWinScore(players[i].charAt(k),
							players[j].charAt(k));
				}
				if (winScore > 5) {
					scoreDouble += 2;
				} else if (winScore == 5) {
					scoreDouble++;
				}
			}
			if (scoreDouble > maxScoreDouble) {
				maxScoreDouble = scoreDouble;
				passIndex = i;
			}
		}
		return passIndex;
	}

	int getWinScore(char throw1, char throw2) {
		if (throw1 == throw2) {
			return 1;
		} else if ((throw1 == 'P' && throw2 == 'R')
				|| (throw1 == 'R' && throw2 == 'S')
				|| (throw1 == 'S' && throw2 == 'P')) {
			return 2;
		} else {
			return 0;
		}
	}
}
