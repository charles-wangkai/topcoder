public class SurroundingGameEasy {
	public int score(String[] cost, String[] benefit, String[] stone) {
		int row = cost.length;
		int column = cost[0].length();
		int scoreTotal = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (stone[i].charAt(j) == 'o') {
					scoreTotal -= cost[i].charAt(j) - '0';
				}
				if (isDominated(stone, i, j)) {
					scoreTotal += benefit[i].charAt(j) - '0';
				}
			}
		}
		return scoreTotal;
	}

	boolean isDominated(String[] stone, int r, int c) {
		if (stone[r].charAt(c) == 'o') {
			return true;
		}
		int[] offsetR = { -1, 0, 1, 0 };
		int[] offsetC = { 0, 1, 0, -1 };
		for (int i = 0; i < offsetR.length; i++) {
			int adjR = r + offsetR[i];
			int adjC = c + offsetC[i];

			if (!(adjR >= 0 && adjR < stone.length && adjC >= 0 && adjC < stone[0]
					.length())) {
				continue;
			}
			if (stone[adjR].charAt(adjC) == '.') {
				return false;
			}
		}
		return true;
	}
}
