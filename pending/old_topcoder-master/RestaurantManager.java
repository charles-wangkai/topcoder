import java.util.Arrays;

public class RestaurantManager {
	public int allocateTables(int[] tables, int[] groupSizes, int[] arrivals,
			int[] departures) {
		Arrays.sort(tables);
		int tableTimes[] = new int[tables.length];
		int turnAway = 0;
		for (int i = 0; i < groupSizes.length; i++) {
			boolean allocated = false;
			for (int j = 0; j < tables.length; j++) {
				if (tables[j] >= groupSizes[i] && arrivals[i] >= tableTimes[j]) {
					tableTimes[j] = departures[i];
					allocated = true;
					break;
				}
			}
			if (!allocated) {
				turnAway += groupSizes[i];
			}
		}
		return turnAway;
	}
}
