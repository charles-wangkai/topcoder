import java.util.ArrayList;
import java.util.Collections;

public class Prank {
	public int[] realWeight(int apparentGain) {
		ArrayList<Integer> realWeights = new ArrayList<Integer>();
		for (int i = 1; i * i < apparentGain; i++) {
			if (apparentGain % i == 0) {
				int gain = apparentGain / i;
				if ((i + gain) % 2 == 0) {
					realWeights.add((i + gain) / 2);
				}
			}
		}
		Collections.sort(realWeights);
		int result[] = new int[realWeights.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = realWeights.get(i);
		}
		return result;
	}
}
