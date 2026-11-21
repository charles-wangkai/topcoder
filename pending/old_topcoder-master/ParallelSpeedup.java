public class ParallelSpeedup {
	public int numProcessors(int k, int overhead) {
		long minTime = Long.MAX_VALUE;
		int result = -1;
		for (int i = 1; i <= k; i++) {
			long time = (long) i * (i - 1) / 2 * overhead + divisionCeil(k, i);
			if (time < minTime) {
				minTime = time;
				result = i;
			}
		}
		return result;
	}

	int divisionCeil(int a, int b) {
		return a / b + ((a % b == 0) ? 0 : 1);
	}
}
