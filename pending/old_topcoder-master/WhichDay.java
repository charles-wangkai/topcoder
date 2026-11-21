import java.util.Arrays;
import java.util.HashSet;

public class WhichDay {
	public String getDay(String[] notOnThisDay) {
		HashSet<String> weekdays = new HashSet<String>(
				Arrays.asList(new String[] { "Sunday", "Monday", "Tuesday",
						"Wednesday", "Thursday", "Friday", "Saturday" }));
		for (String day : notOnThisDay) {
			weekdays.remove(day);
		}
		return weekdays.iterator().next();
	}
}
