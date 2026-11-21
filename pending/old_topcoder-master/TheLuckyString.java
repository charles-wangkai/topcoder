public class TheLuckyString {
	int luckyStringNum = 0;

	public int count(String s) {
		search(s.toCharArray(), 0);
		return luckyStringNum;
	}

	void search(char current[], int index) {
		if (index == current.length) {
			luckyStringNum++;
			return;
		}
		char previous = 0;
		if (index > 0) {
			previous = current[index - 1];
		}
		boolean used[] = new boolean[26];
		for (int i = index; i < current.length; i++) {
			char temp = current[i];
			if (!used[temp - 'a'] && temp != previous) {
				used[temp - 'a'] = true;
				swapChars(current, index, i);
				search(current, index + 1);
				swapChars(current, index, i);
			}
		}
	}

	void swapChars(char current[], int index1, int index2) {
		char temp = current[index1];
		current[index1] = current[index2];
		current[index2] = temp;
	}
}
