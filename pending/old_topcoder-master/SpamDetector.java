import java.util.ArrayList;

public class SpamDetector {
	public int countKeywords(String subjectLine, String[] keywords) {
		String words[] = subjectLine.split(" ");
		int result = 0;
		for (String word : words) {
			if (word.equals("")) {
				continue;
			}
			for (String keyword : keywords) {
				if (isMatch(word, keyword)) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	boolean isMatch(String word, String keyword) {
		ArrayList<Letter_Count> wordLCs = buildLetterCounts(word);
		ArrayList<Letter_Count> keywordLCs = buildLetterCounts(keyword);
		if (wordLCs.size() != keywordLCs.size()) {
			return false;
		}
		for (int i = 0; i < wordLCs.size(); i++) {
			Letter_Count wordLC = wordLCs.get(i);
			Letter_Count keywordLC = keywordLCs.get(i);
			if (wordLC.letter != keywordLC.letter
					|| wordLC.count < keywordLC.count) {
				return false;
			}
		}
		return true;
	}

	ArrayList<Letter_Count> buildLetterCounts(String str) {
		str = str.toLowerCase();
		ArrayList<Letter_Count> letterCounts = new ArrayList<Letter_Count>();
		char letter = str.charAt(0);
		int count = 1;
		for (int i = 0; i <= str.length(); i++) {
			char current = 0;
			if (i < str.length() && (current = str.charAt(i)) == letter) {
				count++;
			} else {
				letterCounts.add(new Letter_Count(letter, count));
				letter = current;
				count = 1;
			}
		}
		return letterCounts;
	}
}

class Letter_Count {
	char letter;
	int count;

	Letter_Count(char letter, int count) {
		this.letter = letter;
		this.count = count;
	}
}