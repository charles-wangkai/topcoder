public class Zoo {
	public long theCount(int[] answers) {
		int[] counts = new int[41];
		for (int answer : answers) {
			counts[answer]++;
		}
		int total = 0;
		long result = 1;
		boolean countTwo = true;
		for (int count : counts) {
			if (count == 0) {
				if (total < answers.length) {
					return 0;
				}
				break;
			}
			if (count > 2 || (count == 2 && !countTwo)) {
				return 0;
			}
			if (count == 2) {
				result *= 2;
			}
			if (count == 1 && countTwo) {
				countTwo = false;
				result *= 2;
			}
			total += count;
		}
		return result;
	}
}
