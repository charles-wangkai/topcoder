public class KiwiJuiceEasy {
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId,
			int[] toId) {
		for (int i = 0; i < fromId.length; i++) {
			int pour = Math.min(bottles[fromId[i]], capacities[toId[i]]
					- bottles[toId[i]]);
			bottles[fromId[i]] -= pour;
			bottles[toId[i]] += pour;
		}
		return bottles;
	}
}
