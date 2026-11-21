public class Measures {
	public int beatsPerM(int[] loudness) {
		for (int bpm = 2; bpm <= 10; bpm++) {
			for (int begin = 0; begin < bpm; begin++) {
				int full = 0;
				int stressed = 0;
				for (int left = begin, right = begin + bpm - 1; right < loudness.length; left += bpm, right += bpm) {
					full++;
					if (isStressed(loudness, left, right)) {
						stressed++;
					}
				}
				if (full > 0 && stressed * 5 >= full * 4) {
					return bpm;
				}
			}
		}
		return -1;
	}

	boolean isStressed(int loudness[], int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			if (loudness[i] > loudness[left]) {
				return false;
			}
		}
		return true;
	}
}
