public class Alliteration {
	public int count(String[] words) {
		int alliterationNum = 0;
		boolean alliteration = false;
		for (int i = 1; i < words.length; i++) {
			if (Character.toLowerCase(words[i].charAt(0)) == Character
					.toLowerCase(words[i - 1].charAt(0))) {
				if (!alliteration) {
					alliteration = true;
					alliterationNum++;
				}
			} else {
				alliteration = false;
			}
		}
		return alliterationNum;
	}
}
