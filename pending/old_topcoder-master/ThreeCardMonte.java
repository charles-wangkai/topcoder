public class ThreeCardMonte {
	public String position(String swaps) {
		int pos = 0;
		for (int i = 0; i < swaps.length(); i++) {
			char swap = swaps.charAt(i);
			if (swap == 'L') {
				if (pos <= 0) {
					pos = -1 - pos;
				}
			} else if (swap == 'R') {
				if (pos >= 0) {
					pos = 1 - pos;
				}
			} else if (swap == 'E') {
				if (pos != 0) {
					pos = -pos;
				}
			}
		}
		if (pos < 0) {
			return "L";
		} else if (pos > 0) {
			return "R";
		} else {
			return "M";
		}
	}
}
