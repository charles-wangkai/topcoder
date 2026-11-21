public class AverageCandyLifetime {
	public double getAverage(int[] eatenCandies) {
		int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int total = 0;
		int lifetime = 0;
		int candyNum = 0;
		for (int i = 0; i < eatenCandies.length; i++) {
			lifetime += daysInMonth[i];
			total += eatenCandies[i] * lifetime;
			candyNum += eatenCandies[i];
		}
		return (double) total / candyNum;
	}
}
