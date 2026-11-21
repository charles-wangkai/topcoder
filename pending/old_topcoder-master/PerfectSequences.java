public class PerfectSequences {
	public String fixIt(int[] seq) {
		for (int i = 0; i < seq.length; i++) {
			boolean negative = false;
			long sum = 0;
			for (int j = 0; j < seq.length; j++) {
				if (j == i) {
					continue;
				}
				if (seq[j] < 0) {
					negative = true;
					break;
				}
				sum += seq[j];
			}
			if (!negative) {
				long product = 1;
				for (int j = 0; j < seq.length; j++) {
					if (j == i) {
						continue;
					}
					if ((double) product * seq[j] - 1 > sum) {
						product = sum + 2;
						break;
					}
					product *= seq[j];
				}
				if ((sum == 0 && (product == 1 || seq[i] != 0))
						|| (sum > 1 && product > 1 && sum % (product - 1) == 0 && seq[i] != sum
								/ (product - 1))) {
					return "Yes";
				}
			}
		}
		return "No";
	}
}
