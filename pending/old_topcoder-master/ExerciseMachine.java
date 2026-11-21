public class ExerciseMachine {
	public int getPercentages(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3, 5));
		int second = Integer.parseInt(time.substring(6, 8));
		int total = hour * 3600 + minute * 60 + second;
		int count = 0;
		for (int i = 1; i <= 99; i++) {
			if (total * i % 100 == 0) {
				count++;
			}
		}
		return count;
	}
}
