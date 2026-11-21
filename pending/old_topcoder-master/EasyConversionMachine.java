public class EasyConversionMachine {
	public String isItPossible(String originalWord, String finalWord, int k) {
		int diff = 0;
		for (int i = 0; i < originalWord.length(); i++) {
			if (originalWord.charAt(i) != finalWord.charAt(i)) {
				diff++;
			}
		}
		if (k >= diff && (k - diff) % 2 == 0) {
			return "POSSIBLE";
		} else {
			return "IMPOSSIBLE";
		}
	}
}
