public class DoorsGame {
	public int determineOutcome(String doors, int trophy) {
		boolean[] johnColors = new boolean[16];
		boolean[] gogoColors = new boolean[16];
		fillColors(johnColors, doors, 0, trophy - 1);
		fillColors(gogoColors, doors, trophy, doors.length() - 1);
		int johnColorNum = 0;
		int gogoColorNum = 0;
		int bothColorNum = 0;
		for (int i = 0; i < johnColors.length; i++) {
			if (johnColors[i] && gogoColors[i]) {
				bothColorNum++;
			} else if (johnColors[i] && !gogoColors[i]) {
				johnColorNum++;
			} else if (!johnColors[i] && gogoColors[i]) {
				gogoColorNum++;
			}
		}
		int chosen = 0;
		int[] selfColorNums = { johnColorNum, gogoColorNum };
		int turn = 0;
		while (true) {
			if (selfColorNums[turn] > 0) {
				selfColorNums[turn]--;
			} else {
				bothColorNum--;
			}
			chosen++;
			if (bothColorNum == 0) {
				if (selfColorNums[0] == 0 && selfColorNums[1] == 0) {
					return 0;
				}
				if (selfColorNums[0] == 0) {
					return chosen;
				} else if (selfColorNums[1] == 0) {
					return -chosen;
				}
			}
			turn = 1 - turn;
		}
	}

	void fillColors(boolean[] colors, String doors, int begin, int end) {
		for (int i = begin; i <= end; i++) {
			colors[doors.charAt(i) - 'A'] = true;
		}
	}
}
