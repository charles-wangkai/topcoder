public class BoredPhilosophers {
	public int[] simulate(String[] text, int N) {
		String whole = "";
		for (String oneText : text) {
			whole += oneText;
		}
		String[] words = whole.split(" ");
		int[] result = new int[N];
		for (int consecutive = 1; consecutive <= N; consecutive++) {
			for (int i = 0; i + consecutive <= words.length; i++) {
				boolean duplicate = false;
				for (int j = 0; j < i; j++) {
					if (isSameSequence(words, i, j, consecutive)) {
						duplicate = true;
						break;
					}
				}
				if (!duplicate) {
					result[consecutive - 1]++;
				}
			}
		}
		return result;
	}

	boolean isSameSequence(String[] words, int start1, int start2,
			int consecutive) {
		for (int i = 0; i < consecutive; i++) {
			if (!words[start1 + i].equals(words[start2 + i])) {
				return false;
			}
		}
		return true;
	}
}
