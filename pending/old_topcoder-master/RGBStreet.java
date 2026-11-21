public class RGBStreet {
	public int estimateCost(String[] houses) {
		int costs[] = new int[3];
		for (String house : houses) {
			String fields[] = house.split(" ");
			int current[] = new int[3];
			for (int i = 0; i < current.length; i++) {
				current[i] = Integer.parseInt(fields[i]);
			}
			int nextCosts[] = new int[3];
			for (int i = 0; i < nextCosts.length; i++) {
				nextCosts[i] = current[i]
						+ Math.min(costs[(i + 1) % 3], costs[(i + 2) % 3]);
			}
			costs = nextCosts;
		}
		return Math.min(Math.min(costs[0], costs[1]), costs[2]);
	}
}
