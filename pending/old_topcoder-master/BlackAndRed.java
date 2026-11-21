public class BlackAndRed {
	public int cut(String deck) {
		for (int i = 0;; i++) {
			String cutted = deck.substring(i) + deck.substring(0, i);
			if (isWin(cutted)) {
				return i;
			}
		}
	}

	boolean isWin(String deck) {
		int red = 0;
		int black = 0;
		for (int i = 0; i < deck.length(); i++) {
			if (deck.charAt(i) == 'R') {
				red++;
			} else {
				black++;
			}
			if (red > black) {
				return false;
			}
		}
		return true;
	}
}
