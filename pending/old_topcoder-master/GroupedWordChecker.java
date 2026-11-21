public class GroupedWordChecker {
	public int howMany(String[] words) {
		int groupedNum = 0;
		for (String word : words) {
			boolean grouped = true;
			boolean used[] = new boolean[26];
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (used[ch - 'a'] && i > 0 && ch != word.charAt(i - 1)) {
					grouped = false;
					break;
				} else {
					used[ch - 'a'] = true;
				}
			}
			if (grouped) {
				groupedNum++;
			}
		}
		return groupedNum;
	}
}
