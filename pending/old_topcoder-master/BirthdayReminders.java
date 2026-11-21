import java.util.PriorityQueue;

public class BirthdayReminders {
	public String[] remind(String[] friendNames, int[] birthDates,
			int currentDate, String[] occasions, int[] days, int k) {
		PriorityQueue<Celebration> celebrations = new PriorityQueue<Celebration>();
		for (int friendIndex = 0; friendIndex < friendNames.length; friendIndex++) {
			for (int occasionIndex = 0; occasionIndex < occasions.length; occasionIndex++) {
				int date = calcMinCycle(birthDates[friendIndex], currentDate,
						days[occasionIndex]);
				int number = (date - birthDates[friendIndex])
						/ days[occasionIndex];
				celebrations.offer(new Celebration(date, friendIndex,
						occasionIndex, number));
			}
		}
		String result[] = new String[k];
		for (int i = 0; i < result.length; i++) {
			Celebration celebration = celebrations.poll();
			result[i] = String.format("%d. %s %s (%d)", celebration.date,
					friendNames[celebration.friendIndex],
					occasions[celebration.occasionIndex], celebration.number);
			celebration.date += days[celebration.occasionIndex];
			celebration.number++;
			celebrations.offer(celebration);
		}
		return result;
	}

	int calcMinCycle(int birthDate, int currentDate, int day) {
		return currentDate + (day - (currentDate - birthDate) % day) % day;
	}
}

class Celebration implements Comparable<Celebration> {
	int date;
	int friendIndex;
	int occasionIndex;
	int number;

	public Celebration(int date, int friendIndex, int occasionIndex, int number) {
		this.date = date;
		this.friendIndex = friendIndex;
		this.occasionIndex = occasionIndex;
		this.number = number;
	}

	public int compareTo(Celebration another) {
		if (date != another.date) {
			return date - another.date;
		}
		if (occasionIndex != another.occasionIndex) {
			return occasionIndex - another.occasionIndex;
		}
		return friendIndex - another.friendIndex;
	}
}