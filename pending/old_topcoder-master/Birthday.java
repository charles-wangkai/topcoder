import java.util.Arrays;
import java.util.Comparator;

public class Birthday {
	public String getNext(String date, String[] birthdays) {
		for (int i = 0; i < birthdays.length; i++) {
			birthdays[i] = birthdays[i].split(" ")[0];
		}
		Arrays.sort(birthdays, new DateComparator(date));
		return birthdays[0];
	}
}

class DateComparator implements Comparator<String> {
	String base;

	DateComparator(String base) {
		this.base = base;
	}

	public int compare(String d1, String d2) {
		return distance(d1) - distance(d2);
	}

	int distance(String date) {
		return (distanceFromOrigin(date) - distanceFromOrigin(base) + 12 * 31)
				% (12 * 31);
	}

	int distanceFromOrigin(String date) {
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3));
		return (month - 1) * 31 + (day - 1);
	}
}