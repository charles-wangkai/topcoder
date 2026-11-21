import java.util.ArrayList;
import java.util.Arrays;

public class CustomerStatistics {
	public String[] reportDuplicates(String[] customerNames) {
		Arrays.sort(customerNames);
		ArrayList<String> result = new ArrayList<String>();
		int sameLength = 1;
		for (int i = 1; i <= customerNames.length; i++) {
			if (i < customerNames.length
					&& customerNames[i].equals(customerNames[i - 1])) {
				sameLength++;
			} else {
				if (sameLength > 1) {
					result.add(customerNames[i - 1] + " " + sameLength);
					sameLength = 1;
				}
			}
		}
		return result.toArray(new String[0]);
	}
}
