public class SoccerLeagues {
	public int[] points(String[] matches) {
		int totalPoints[] = new int[matches.length];
		for (int i = 0; i < matches.length; i++) {
			for (int j = 0; j < matches[0].length(); j++) {
				char ch = matches[i].charAt(j);
				if (ch == 'W') {
					totalPoints[i] += 3;
				} else if (ch == 'D') {
					totalPoints[i]++;
					totalPoints[j]++;
				} else if (ch == 'L') {
					totalPoints[j] += 3;
				}
			}
		}
		return totalPoints;
	}
}
