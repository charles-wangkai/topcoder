public class OfficeParking {
	public int spacesUsed(String[] events) {
		int maxUsed = 0;
		int used = 0;
		for (String event : events) {
			if (event.endsWith("arrives")) {
				used++;
				maxUsed = Math.max(maxUsed, used);
			} else {
				used--;
			}
		}
		return maxUsed;
	}
}
