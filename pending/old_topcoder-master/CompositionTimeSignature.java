public class CompositionTimeSignature {
	public String getTimeSignature(String duration) {
		int total = 0;
		String signatures[] = { "3/8", "2/4", "3/4", "4/4" };
		int times[] = { 6, 8, 12, 16 };
		int crosses[] = new int[4];
		for (int i = 0; i < duration.length(); i++) {
			char ch = duration.charAt(i);
			int previous[] = new int[4];
			for (int j = 0; j < 4; j++) {
				previous[j] = total / times[j];
			}
			if (ch == 'W') {
				total += 16;
			} else if (ch == 'H') {
				total += 8;
			} else if (ch == 'Q') {
				total += 4;
			} else if (ch == 'E') {
				total += 2;
			} else if (ch == 'S') {
				total++;
			}
			for (int j = 0; j < 4; j++) {
				if ((total - 1) / times[j] != previous[j]) {
					crosses[j]++;
				}
			}
		}
		int min = -1;
		for (int i = 0; i < 4; i++) {
			if (total % times[i] != 0) {
				crosses[i] = -1;
			} else {
				if (min == -1 || crosses[i] < min) {
					min = crosses[i];
				}
			}
		}
		if (min == -1) {
			return "?/?";
		}
		for (int i = 0; i < 4; i++) {
			if (crosses[i] == min) {
				return signatures[i];
			}
		}
		return null;
	}
}
