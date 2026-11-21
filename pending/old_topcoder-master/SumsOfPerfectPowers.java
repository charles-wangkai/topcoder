import java.util.ArrayList;
import java.util.Collections;

public class SumsOfPerfectPowers {
	public int howMany(int lowerBound, int upperBound) {
		ArrayList<Integer> perfectPowers = new ArrayList<Integer>();
		perfectPowers.add(0);
		perfectPowers.add(1);
		for (long i = 2; i * i <= upperBound; i++) {
			long perfectPower = i * i;
			while (perfectPower <= upperBound) {
				perfectPowers.add((int) perfectPower);
				perfectPower *= i;
			}
		}
		Collections.sort(perfectPowers);
		boolean solutions[] = new boolean[upperBound + 1];
		for (int i = 0; i < perfectPowers.size(); i++) {
			int perfectPower1 = perfectPowers.get(i);
			for (int j = i; j < perfectPowers.size(); j++) {
				int perfectPower2 = perfectPowers.get(j);
				int sum = perfectPower1 + perfectPower2;
				if (sum > upperBound) {
					break;
				}
				if (sum >= lowerBound) {
					solutions[sum] = true;
				}
			}
		}
		int result = 0;
		for (int i = lowerBound; i <= upperBound; i++) {
			if (solutions[i]) {
				result++;
			}
		}
		return result;
	}
}
