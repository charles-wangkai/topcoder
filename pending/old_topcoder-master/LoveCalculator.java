public class LoveCalculator {
	public String findBoy(String girl, String[] boys) {
		int maxProb = -1;
		String result = null;
		char letters[] = { 'L', 'O', 'V', 'E' };
		for (String boy : boys) {
			int counts[] = new int[letters.length];
			for (int i = 0; i < counts.length; i++) {
				counts[i] = countLetter(girl, letters[i])
						+ countLetter(boy, letters[i]);
			}
			int prob = 1;
			for (int i = 0; i < counts.length; i++) {
				for (int j = i + 1; j < counts.length; j++) {
					prob = prob * (counts[i] + counts[j]) % 100;
				}
			}
			if (prob > maxProb
					|| (prob == maxProb && boy.compareTo(result) < 0)) {
				maxProb = prob;
				result = boy;
			}
		}
		return result;
	}

	int countLetter(String name, char letter) {
		int count = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}
}
