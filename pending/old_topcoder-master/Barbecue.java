public class Barbecue {
	public int eliminate(int n, int[] voter, int[] excluded) {
		int voting[] = new int[n];
		int voted[] = new int[n];
		for (int i = 0; i < voter.length; i++) {
			voting[voter[i]]++;
			voted[excluded[i]]++;
		}
		int excludeIndex = 0;
		for (int i = 1; i < n; i++) {
			if (voted[i] > voted[excludeIndex]
					|| (voted[i] == voted[excludeIndex] && voting[i] > voting[excludeIndex])) {
				excludeIndex = i;
			}
		}
		return excludeIndex;
	}
}
