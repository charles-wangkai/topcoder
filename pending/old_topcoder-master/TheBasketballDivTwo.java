public class TheBasketballDivTwo {
	int minWinnerWin = Integer.MAX_VALUE;

	public int find(String[] table) {
		search(table, 0, 0);
		return minWinnerWin;
	}

	void search(String[] table, int x, int y) {
		int teamNum = table.length;
		if (y == teamNum) {
			search(table, x + 1, 0);
			return;
		}
		if (x == teamNum) {
			int winnerWin = 0;
			for (int team = 0; team < teamNum; team++) {
				int win = 0;
				for (int j = 0; j < teamNum; j++) {
					if (table[team].charAt(j) == 'W') {
						win++;
					}
				}
				for (int i = 0; i < teamNum; i++) {
					if (table[i].charAt(team) == 'L') {
						win++;
					}
				}
				winnerWin = Math.max(winnerWin, win);
			}
			minWinnerWin = Math.min(minWinnerWin, winnerWin);
			return;
		}
		if (table[x].charAt(y) == '?') {
			char results[] = { 'W', 'L' };
			for (char result : results) {
				setCharAt(table, x, y, result);
				search(table, x, y + 1);
				setCharAt(table, x, y, '?');
			}
		} else {
			search(table, x, y + 1);
		}
	}

	void setCharAt(String str[], int x, int y, char ch) {
		str[x] = str[x].substring(0, y) + ch + str[x].substring(y + 1);
	}
}
