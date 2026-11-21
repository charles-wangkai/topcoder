public class Mailbox {
	public int impossible(String collection, String[] address) {
		int impossibleNum = 0;
		int letterCountsForCollection[] = calcLetterCounts(collection);
		for (String addr : address) {
			int letterCountsForAddr[] = calcLetterCounts(addr);
			for (int i = 0; i < letterCountsForCollection.length; i++) {
				if (letterCountsForCollection[i] < letterCountsForAddr[i]) {
					impossibleNum++;
					break;
				}
			}
		}
		return impossibleNum;
	}

	int[] calcLetterCounts(String str) {
		int letterCounts[] = new int[36];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				letterCounts[ch - 'A']++;
			} else if (Character.isDigit(ch)) {
				letterCounts[ch - '0' + 26]++;
			}
		}
		return letterCounts;
	}
}
