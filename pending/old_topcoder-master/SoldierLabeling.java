public class SoldierLabeling {
	public int count(int n, int lowerBound, int upperBound) {
		int min = (int) Math.pow(10, lowerBound - 1);
		int max = Math.min((int) Math.pow(10, upperBound) - 1, n);
		return (max >= min) ? (max - min + 1) : 0;
	}
}
