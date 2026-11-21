public class ContiguousSubsequences {
	public int[] findMaxAverage(int[] a, int K) {
		double maxAvg = -1;
		int maxBegin = -1;
		int maxEnd = -1;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				if (j - i + 1 >= K) {
					double average = (double) sum / (j - i + 1);
					if (average > maxAvg
							|| (average == maxAvg && j - i > maxEnd - maxBegin)) {
						maxAvg = average;
						maxBegin = i;
						maxEnd = j;
					}
				}
			}
		}
		return new int[] { maxBegin, maxEnd };
	}
}
