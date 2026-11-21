public class SentenceSplitting {
	public int split(String sentence, int K) {
		String words[] = sentence.split(" ");
		for (int length = 1;; length++) {
			int lineBreak = 0;
			int rest = length;
			for (String word : words) {
				int wordLength = word.length();
				int leadingSpace = (rest == length ? 0 : 1);
				if (leadingSpace + wordLength <= rest) {
					rest -= leadingSpace + wordLength;
				} else if (wordLength <= length) {
					lineBreak++;
					rest = length - wordLength;
				} else {
					lineBreak = Integer.MAX_VALUE;
					break;
				}
			}
			if (lineBreak <= K) {
				return length;
			}
		}
	}
}
