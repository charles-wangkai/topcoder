public class BallAndHats {
	public int getHat(String hats, int numSwaps) {
		int ballSpot = hats.indexOf('o');
		if (numSwaps == 0) {
			return ballSpot;
		}
		if (ballSpot % 2 == numSwaps % 2) {
			return 0;
		} else {
			return 1;
		}
	}
}
