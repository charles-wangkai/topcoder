public class TemplateMatching {
	public String bestMatch(String text, String prefix, String suffix) {
		Match resultMatch = new Match(-1, -1, "");
		for (int i = 0; i < text.length(); i++) {
			for (int j = i + 1; j <= text.length(); j++) {
				String substring = text.substring(i, j);
				int prefixMatchScore = calcMatchScore(substring, 0, 0, prefix,
						Math.max(0, prefix.length() - substring.length()), 1);
				int suffixMatchScore = calcMatchScore(substring,
						Math.max(0, substring.length() - suffix.length()), 1,
						suffix, 0, 0);
				Match match = new Match(prefixMatchScore, suffixMatchScore,
						substring);
				if (match.betterThan(resultMatch)) {
					resultMatch = match;
				}
			}
		}
		return resultMatch.substring;
	}

	int calcMatchScore(String str1, int beginIndex1, int offset1, String str2,
			int beginIndex2, int offset2) {
		int maxScore = 0;
		while (true) {
			String substr1 = str1.substring(beginIndex1);
			String substr2 = str2.substring(beginIndex2);
			if (substr1.equals("") || substr2.equals("")) {
				break;
			}
			int score = 0;
			for (int i = 0;; i++) {
				if (i == substr1.length() || i == substr2.length()) {
					break;
				}
				if (substr1.charAt(i) != substr2.charAt(i)) {
					score = 0;
					break;
				}
				score++;
			}
			maxScore = Math.max(maxScore, score);
			beginIndex1 += offset1;
			beginIndex2 += offset2;
		}
		return maxScore;
	}
}

class Match {
	int prefixMatchScore;
	int suffixMatchScore;
	int totalMatchScore;
	String substring;

	public Match(int prefixMatchScore, int suffixMatchScore, String substring) {
		this.prefixMatchScore = prefixMatchScore;
		this.suffixMatchScore = suffixMatchScore;
		totalMatchScore = prefixMatchScore + suffixMatchScore;
		this.substring = substring;
	}

	boolean betterThan(Match another) {
		if (totalMatchScore != another.totalMatchScore) {
			return totalMatchScore > another.totalMatchScore;
		}
		if (prefixMatchScore != another.prefixMatchScore) {
			return prefixMatchScore > another.prefixMatchScore;
		}
		return substring.compareTo(another.substring) < 0;
	}
}