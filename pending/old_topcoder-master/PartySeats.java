import java.util.ArrayList;
import java.util.Collections;

public class PartySeats {
	public String[] seating(String[] attendees) {
		ArrayList<String> boys = new ArrayList<String>();
		ArrayList<String> girls = new ArrayList<String>();
		for (String attendee : attendees) {
			String fields[] = attendee.split(" ");
			if (fields[1].equals("boy")) {
				boys.add(fields[0]);
			} else {
				girls.add(fields[0]);
			}
		}
		if (boys.size() != girls.size() || boys.size() % 2 != 0) {
			return new String[0];
		}
		String result[] = new String[attendees.length + 2];
		Collections.sort(boys);
		Collections.sort(girls);
		boolean boyTurn = true;
		int boyIndex = 0;
		int girlIndex = 0;
		for (int i = 0; i < result.length; i++) {
			if (boyTurn) {
				if (i == 0) {
					result[i] = "HOST";
				} else {
					result[i] = boys.get(boyIndex);
					boyIndex++;
				}
			} else {
				if (i == result.length / 2) {
					result[i] = "HOSTESS";
				} else {
					result[i] = girls.get(girlIndex);
					girlIndex++;
				}
			}
			boyTurn = !boyTurn;
		}
		return result;
	}
}
