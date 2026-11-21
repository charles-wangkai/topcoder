import java.util.HashMap;
import java.util.Map;

public class CityMap {
	public String getLegend(String[] cityMap, int[] POIs) {
		Map<Character, Integer> poi2count = new HashMap<Character, Integer>();
		for (String row : cityMap) {
			for (int i = 0; i < row.length(); i++) {
				char poi = row.charAt(i);
				if (poi != '.') {
					if (!poi2count.containsKey(poi)) {
						poi2count.put(poi, 0);
					}
					poi2count.put(poi, poi2count.get(poi) + 1);
				}
			}
		}

		Map<Integer, Character> count2poi = new HashMap<Integer, Character>();
		poi2count.forEach((poi, count) -> count2poi.put(count, poi));

		String legend = "";
		for (int count : POIs) {
			legend += count2poi.get(count);
		}
		return legend;
	}
}
