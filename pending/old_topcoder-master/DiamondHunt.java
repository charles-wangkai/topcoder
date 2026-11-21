public class DiamondHunt {
	public int countDiamonds(String mine) {
		int matched = 0;
		int toMatchNum = 0;
		for (int i = 0; i < mine.length(); i++) {
			if (mine.charAt(i) == '<') {
				toMatchNum++;
			} else if (toMatchNum > 0) {
				toMatchNum--;
				matched++;
			}
		}
		return matched;
	}
}
