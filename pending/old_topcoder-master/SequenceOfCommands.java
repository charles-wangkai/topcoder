public class SequenceOfCommands {
	public String whatHappens(String[] commands) {
		int x = 0;
		int y = 0;
		int direction = 0;
		int[] OFFSET_X = { -1, 0, 1, 0 };
		int[] OFFSET_Y = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			for (String commandElement : commands) {
				for (int j = 0; j < commandElement.length(); j++) {
					char command = commandElement.charAt(j);
					if (command == 'S') {
						x += OFFSET_X[direction];
						y += OFFSET_Y[direction];
					} else if (command == 'L') {
						direction = (direction + 3) % 4;
					} else if (command == 'R') {
						direction = (direction + 1) % 4;
					}
				}
			}
			if (x == 0 && y == 0) {
				return "bounded";
			}
		}
		return "unbounded";
	}
}
