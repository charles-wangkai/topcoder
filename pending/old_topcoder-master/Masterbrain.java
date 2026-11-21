public class Masterbrain {
	public int possibleSecrets(String[] guesses, String[] results) {
		int count = 0;
		for (char a = '1'; a <= '7'; a++) {
			for (char b = '1'; b <= '7'; b++) {
				for (char c = '1'; c <= '7'; c++) {
					for (char d = '1'; d <= '7'; d++) {
						String answer = "" + a + b + c + d;
						int fault = 0;
						for (int i = 0; i < guesses.length; i++) {
							if (!compare(guesses[i], answer).equals(results[i])) {
								fault++;
								if (fault > 1) {
									break;
								}
							}
						}
						if (fault == 1) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	String compare(String guess, String answer) {
		int black = 0;
		int white = 0;
		int counts[] = new int[7];
		for (int i = 0; i < 4; i++) {
			char ch = answer.charAt(i);
			if (ch == guess.charAt(i)) {
				black++;
			} else {
				counts[ch - '1']++;
			}
		}
		for (int i = 0; i < 4; i++) {
			char ch = guess.charAt(i);
			if (ch != answer.charAt(i) && counts[ch - '1'] > 0) {
				white++;
				counts[ch - '1']--;
			}
		}
		return black + "b " + white + "w";
	}
}
