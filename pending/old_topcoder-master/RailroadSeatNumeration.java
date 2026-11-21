import java.util.HashMap;
import java.util.HashSet;

public class RailroadSeatNumeration {
	public String getInternational(int[] tickets) {
		HashMap<Integer, Integer> domestic2international = new HashMap<Integer, Integer>();
		HashSet<Integer> internationals = new HashSet<Integer>();
		int domestic = 1;
		int seats[] = { 1, 3, 4, 6 };
		for (int i = 1; i <= 9; i++) {
			for (int seat : seats) {
				int international = i * 10 + seat;
				domestic2international.put(domestic, international);
				internationals.add(international);
				domestic++;
			}
		}
		String fromDomestic = "";
		String fromInternational = "";
		for (int ticket : tickets) {
			if (domestic2international.containsKey(ticket)) {
				if (fromDomestic != null) {
					fromDomestic = spaceAppend(fromDomestic,
							domestic2international.get(ticket));
				}
			} else {
				fromDomestic = null;
			}
			if (internationals.contains(ticket)) {
				if (fromInternational != null) {
					fromInternational = spaceAppend(fromInternational, ticket);
				}
			} else {
				fromInternational = null;
			}
		}
		if (fromDomestic != null && fromInternational != null) {
			return "AMBIGUOUS";
		} else if (fromDomestic == null && fromInternational == null) {
			return "BAD DATA";
		} else {
			return (fromDomestic != null) ? fromDomestic : fromInternational;
		}
	}

	String spaceAppend(String a, int b) {
		return a + (a.equals("") ? "" : " ") + b;
	}
}
