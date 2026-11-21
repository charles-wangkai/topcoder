public class ProgressBar {
	public String showProgress(int[] taskTimes, int tasksCompleted) {
		int sum = 0;
		int completed = 0;
		for (int i = 0; i < taskTimes.length; i++) {
			sum += taskTimes[i];
			if (i < tasksCompleted) {
				completed += taskTimes[i];
			}
		}
		String bar = "";
		int barFilled = completed * 20 / sum;
		for (int i = 0; i < barFilled; i++) {
			bar += "#";
		}
		for (int i = 0; i < 20 - barFilled; i++) {
			bar += ".";
		}
		return bar;
	}
}
