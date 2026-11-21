public class ContestWinner {
	public int getWinner(int[] events) {
		int solved[] = new int[1000001];
		int maxSolved = -1;
		int winner = -1;
		for (int event : events) {
			solved[event]++;
			if (solved[event] > maxSolved) {
				maxSolved = solved[event];
				winner = event;
			}
		}
		return winner;
	}
}
