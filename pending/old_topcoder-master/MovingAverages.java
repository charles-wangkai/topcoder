public class MovingAverages {
	public int[] calculate(String[] times, int n) {
		int seconds[] = new int[times.length];
		for (int i = 0; i < seconds.length; i++) {
			seconds[i] = convertToSecond(times[i]);
		}
		int averages[] = new int[times.length - n + 1];
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += seconds[i];
		}
		for (int i = 0; i < averages.length; i++) {
			averages[i] = total / n;
			if (i < averages.length - 1) {
				total += seconds[i + n] - seconds[i];
			}
		}
		return averages;
	}

	int convertToSecond(String time) {
		String fields[] = time.split(":");
		int hour = Integer.parseInt(fields[0]);
		int minute = Integer.parseInt(fields[1]);
		int second = Integer.parseInt(fields[2]);
		return hour * 3600 + minute * 60 + second;
	}
}
