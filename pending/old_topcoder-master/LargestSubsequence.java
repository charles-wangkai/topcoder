public class LargestSubsequence {
	public String getLargest(String s) {
		String largest = "";
		int index = 0;
		while (index < s.length()) {
			index = findMaxIndex(s, index);
			largest += s.charAt(index);
			index++;
		}
		return largest;
	}

	int findMaxIndex(String s, int start) {
		int maxIndex = start;
		for (int i = start + 1; i < s.length(); i++) {
			if (s.charAt(i) > s.charAt(maxIndex)) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
