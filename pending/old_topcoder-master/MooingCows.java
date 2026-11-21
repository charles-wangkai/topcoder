import java.util.ArrayList;

public class MooingCows {
	public int dissatisfaction(String[] farmland) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i = 0; i < farmland.length; i++) {
			for (int j = 0; j < farmland[0].length(); j++) {
				if (farmland[i].charAt(j) == 'C') {
					x.add(i);
					y.add(j);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < x.size(); i++) {
			int sum = 0;
			for (int j = 0; j < x.size(); j++) {
				sum += (x.get(i) - x.get(j)) * (x.get(i) - x.get(j))
						+ (y.get(i) - y.get(j)) * (y.get(i) - y.get(j));
			}
			result = Math.min(result, sum);
		}
		return result;
	}
}
