public class GameOfLifeDivTwo {
	public String theSimulation(String init, int T) {
		int N = init.length();
		int states[] = new int[init.length()];
		for (int i = 0; i < N; i++) {
			states[i] = init.charAt(i) - '0';
		}
		for (int t = 0; t < T; t++) {
			int nextStates[] = new int[N];
			for (int i = 0; i < N; i++) {
				nextStates[i] = (states[(i - 1 + N) % N] + states[i]
						+ states[(i + 1) % N] >= 2) ? 1 : 0;
			}
			states = nextStates;
		}
		String encoding = "";
		for (int state : states) {
			encoding += state;
		}
		return encoding;
	}
}
