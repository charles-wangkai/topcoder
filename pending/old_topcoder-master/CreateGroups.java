public class CreateGroups {
	public int minChanges(int[] groups, int minSize, int maxSize) {
		int sum = 0;
		int exceeding = 0;
		int lacking = 0;
		for (int group : groups) {
			sum += group;
			if (group > maxSize) {
				exceeding += group - maxSize;
			} else if (group < minSize) {
				lacking += minSize - group;
			}
		}
		if (sum < minSize * groups.length || sum > maxSize * groups.length) {
			return -1;
		} else {
			return Math.max(exceeding, lacking);
		}
	}
}
