import java.util.Arrays;

public class FoxAndVacation {
	public int maxCities(int total, int[] d) {
		Arrays.sort(d);
		int visitedNum = 0;
		for (int stay : d) {
			if (total < stay) {
				break;
			}
			total -= stay;
			visitedNum++;
		}
		return visitedNum;
	}
}
