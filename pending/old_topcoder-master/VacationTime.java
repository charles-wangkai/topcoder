public class VacationTime {
	public int bestSchedule(int N, int K, int[] workingDays) {
		boolean meetings[] = new boolean[N];
		for (int workingDay : workingDays) {
			meetings[workingDay - 1] = true;
		}
		int conflict = 0;
		for (int i = 0; i < K; i++) {
			if (meetings[i]) {
				conflict++;
			}
		}
		int minConflict = conflict;
		for (int i = 1; i + K <= N; i++) {
			if (meetings[i - 1]) {
				conflict--;
			}
			if (meetings[i + K - 1]) {
				conflict++;
			}
			minConflict = Math.min(minConflict, conflict);
		}
		return minConflict;
	}
}
