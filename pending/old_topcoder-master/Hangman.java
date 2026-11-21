public class Hangman {
	public String guessWord(String feedback, String[] words) {
		String result = "";
		for (String word : words) {
			if (isMatched(feedback, word)) {
				if (!result.equals("")) {
					return "";
				}
				result = word;
			}
		}
		return result;
	}

	boolean isMatched(String feedback, String word) {
		if (feedback.length() != word.length()) {
			return false;
		}
		boolean used[] = new boolean[26];
		for (int i = 0; i < feedback.length(); i++) {
			char ch = feedback.charAt(i);
			if (ch != '-') {
				used[ch - 'A'] = true;
			}
		}
		for (int i = 0; i < feedback.length(); i++) {
			char feedbackCh = feedback.charAt(i);
			char wordCh = word.charAt(i);
			if ((feedbackCh == '-' && used[wordCh - 'A'])
					|| (feedbackCh != '-' && feedbackCh != wordCh)) {
				return false;
			}
		}
		return true;
	}
}
