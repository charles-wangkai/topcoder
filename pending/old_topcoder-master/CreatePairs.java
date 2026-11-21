import java.util.ArrayList;
import java.util.Arrays;

public class CreatePairs {
	public int maximalSum(int[] data) {
		Arrays.sort(data);
		ArrayList<Integer> negatives = new ArrayList<Integer>();
		ArrayList<Integer> positives = new ArrayList<Integer>();
		int sum = 0;
		boolean hasZero = false;
		for (int oneData : data) {
			if (oneData < 0) {
				negatives.add(oneData);
			} else if (oneData > 1) {
				positives.add(oneData);
			} else if (oneData == 1) {
				sum++;
			} else {
				hasZero = true;
			}
		}
		if (negatives.size() % 2 != 0) {
			int lastIndex = negatives.size() - 1;
			if (!hasZero) {
				sum += negatives.get(lastIndex);
			}
			negatives.remove(lastIndex);
		}
		if (positives.size() % 2 != 0) {
			sum += positives.remove(0);
		}
		sum += pairProductsSum(negatives) + pairProductsSum(positives);
		return sum;
	}

	int pairProductsSum(ArrayList<Integer> numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.size(); i += 2) {
			sum += numbers.get(i) * numbers.get(i + 1);
		}
		return sum;
	}
}
