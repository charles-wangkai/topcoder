public class BoxesOfBooks {
	public int boxes(int[] weights, int maxWeight) {
		int boxNum = 0;
		int rest = -1;
		for (int weight : weights) {
			if (weight > rest) {
				rest = maxWeight;
				boxNum++;
			}
			rest -= weight;
		}
		return boxNum;
	}
}
