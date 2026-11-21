public class Filtering {
	public int[] designFilter(int[] sizes, String outcome) {
		boolean rejects[] = new boolean[101];
		int minAccept = Integer.MAX_VALUE;
		int maxAccept = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			if (outcome.charAt(i) == 'A') {
				minAccept = Math.min(minAccept, sizes[i]);
				maxAccept = Math.max(maxAccept, sizes[i]);
			} else {
				rejects[sizes[i]] = true;
			}
		}
		for (int i = minAccept; i <= maxAccept; i++) {
			if (rejects[i]) {
				return new int[0];
			}
		}
		return new int[] { minAccept, maxAccept };
	}
}
