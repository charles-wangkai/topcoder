public class Salary {
	public int howMuch(String[] arrival, String[] departure, int wage) {
		final String EVENING_BEGIN = "18:00:00";
		final String MORNING_END = "06:00:00";
		int normalTime = 0;
		int extraTime = 0;
		for (int i = 0; i < arrival.length; i++) {
			int arrivalTime = convertToSecond(arrival[i]);
			int departureTime = convertToSecond(departure[i]);
			normalTime += Math.max(
					Math.min(departureTime, convertToSecond(EVENING_BEGIN)),
					convertToSecond(MORNING_END))
					- Math.max(Math.min(arrivalTime,
							convertToSecond(EVENING_BEGIN)),
							convertToSecond(MORNING_END));
			int eveningTime = Math.max(departureTime,
					convertToSecond(EVENING_BEGIN))
					- Math.max(arrivalTime, convertToSecond(EVENING_BEGIN));
			int morningTime = Math.min(departureTime,
					convertToSecond(MORNING_END))
					- Math.min(arrivalTime, convertToSecond(MORNING_END));
			extraTime += eveningTime + morningTime;
		}
		return (int) (wage * (2L * normalTime + 3 * extraTime) / 7200);
	}

	int convertToSecond(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3, 5));
		int second = Integer.parseInt(time.substring(6));
		return hour * 3600 + minute * 60 + second;
	}
}
