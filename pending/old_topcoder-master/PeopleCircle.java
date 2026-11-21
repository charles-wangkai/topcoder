import java.util.LinkedList;

public class PeopleCircle {
	public String order(int numMales, int numFemales, int K) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < numMales + numFemales; i++) {
			result.append('M');
		}
		LinkedList<Integer> circle = new LinkedList<Integer>();
		for (int i = 0; i < result.length(); i++) {
			circle.add(i);
		}
		int pos = 0;
		for (int i = 0; i < numFemales; i++) {
			int nextPos = (pos + K - 1) % circle.size();
			int index = circle.remove(nextPos);
			result.setCharAt(index, 'F');
			if (!circle.isEmpty()) {
				pos = nextPos % circle.size();
			}
		}
		return result.toString();
	}
}
