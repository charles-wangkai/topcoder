public class LeftOrRight {
	public int maxDistance(String program) {
		return Math.max(calcReach(program.replaceAll("\\?", "L")),
				calcReach(program.replaceAll("\\?", "R")));
	}

	int calcReach(String commands) {
		int reach = 0;
		int distance = 0;
		for (int i = 0; i < commands.length(); i++) {
			if (commands.charAt(i) == 'L') {
				distance--;
			} else {
				distance++;
			}
			reach = Math.max(reach, Math.abs(distance));
		}
		return reach;
	}
}
