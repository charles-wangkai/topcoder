public class AkariDaisukiDiv2 {
	public int countTuples(String S) {
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j < S.length(); j++) {
				for (int k = 0; (j - 1 - k) - (i + 1 + k) >= 2; k++) {
					if (S.substring(i + 1, i + k + 2).equals(
							S.substring(j - 1 - k, j))) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
