public class OrderedNim {
	public String winner(int[] layout) {
		boolean aliceWin = true;
		for (int stone : layout) {
			if (stone > 1) {
				return getWinner(aliceWin);
			}
			aliceWin = !aliceWin;
		}
		aliceWin = !aliceWin;
		return getWinner(aliceWin);
	}

	String getWinner(boolean aliceWin) {
		return aliceWin ? "Alice" : "Bob";
	}
}
