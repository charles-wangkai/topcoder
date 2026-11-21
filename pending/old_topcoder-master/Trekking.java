public class Trekking {
	public int findCamps(String trail, String[] plans) {
		int minCamp = -1;
		for (String plan : plans) {
			int camp = 0;
			for (int i = 0; i < trail.length(); i++) {
				if (plan.charAt(i) == 'C') {
					if (trail.charAt(i) == '^') {
						camp = -1;
						break;
					}
					camp++;
				}
			}
			if (camp >= 0 && (minCamp == -1 || camp < minCamp)) {
				minCamp = camp;
			}
		}
		return minCamp;
	}
}
