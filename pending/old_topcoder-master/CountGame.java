public class CountGame {
	public int howMany(int maxAdd, int goal, int next) {
		int say = (goal - next + 1) % (maxAdd + 1);
		if (say == 0) {
			return -1;
		} else {
			return say;
		}
	}
}
