import java.util.ArrayList;

public class CasketOfStarEasy {
	public int maxEnergy(int[] weight) {
		ArrayList<Integer> weights = new ArrayList<Integer>();
		for (int oneWeight : weight) {
			weights.add(oneWeight);
		}
		return maxEnergy(weights);
	}

	int maxEnergy(ArrayList<Integer> weights) {
		int maxE = 0;
		for (int i = 1; i < weights.size() - 1; i++) {
			int generated = weights.get(i - 1) * weights.get(i + 1);
			int weight = weights.remove(i);
			maxE = Math.max(maxE, generated + maxEnergy(weights));
			weights.add(i, weight);
		}
		return maxE;
	}
}
