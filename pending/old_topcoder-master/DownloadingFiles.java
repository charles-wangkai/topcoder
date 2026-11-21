public class DownloadingFiles {
	public double actualTime(String[] tasks) {
		int bandwidth = 0;
		int total = 0;
		for (String task : tasks) {
			String fields[] = task.split(" ");
			int speed = Integer.parseInt(fields[0]);
			int time = Integer.parseInt(fields[1]);
			bandwidth += speed;
			total += speed * time;
		}
		return (double) total / bandwidth;
	}
}
