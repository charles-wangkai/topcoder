public class FourBlocksEasy {
	public int maxScore(String[] grid) {
		int score = 0;
		boolean prevUpgradable = false;
		for (int i = 0; i < grid[0].length(); i++) {
			score += 2;
			if (grid[0].charAt(i) == '.' && grid[1].charAt(i) == '.') {
				if (prevUpgradable) {
					score += 12;
					prevUpgradable = false;
				} else {
					prevUpgradable = true;
				}
			} else {
				prevUpgradable = false;
			}
		}
		return score;
	}
}
