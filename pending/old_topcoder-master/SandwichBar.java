import java.util.Arrays;
import java.util.HashSet;

public class SandwichBar {
	public int whichOrder(String[] available, String[] orders) {
		HashSet<String> ingredients = new HashSet<String>(
				Arrays.asList(available));
		for (int i = 0; i < orders.length; i++) {
			String fields[] = orders[i].split(" ");
			boolean found = true;
			for (String field : fields) {
				if (!ingredients.contains(field)) {
					found = false;
					break;
				}
			}
			if (found) {
				return i;
			}
		}
		return -1;
	}
}
