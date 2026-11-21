public class IndicatorMotion {
	public String getMotion(String program, char startState) {
		char states[] = { '|', '/', '-', '\\' };
		int pos;
		for (int i = 0;; i++) {
			if (states[i] == startState) {
				pos = i;
				break;
			}
		}
		String motion = startState + "";
		for (int i = 0; i < program.length(); i += 3) {
			char instr = program.charAt(i);
			int offset = 0;
			if (instr == 'L') {
				offset = 3;
			} else if (instr == 'R') {
				offset = 1;
			} else if (instr == 'F') {
				offset = 2;
			}
			int secs = Integer.parseInt(program.substring(i + 1, i + 3));
			for (int j = 0; j < secs; j++) {
				pos = (pos + offset) % 4;
				motion += states[pos];
			}
		}
		return motion;
	}
}
