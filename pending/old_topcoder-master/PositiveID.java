import java.util.Arrays;
import java.util.HashSet;

public class PositiveID {
	public int maximumFacts(String[] suspects) {
		@SuppressWarnings("unchecked")
		HashSet<String> characteristics[] = new HashSet[suspects.length];
		for (int i = 0; i < characteristics.length; i++) {
			characteristics[i] = new HashSet<String>(Arrays.asList(suspects[i]
					.split(",")));
		}
		int result = 0;
		for (int i = 0; i < characteristics.length; i++) {
			for (int j = i + 1; j < characteristics.length; j++) {
				int common = 0;
				for (String characteristic : characteristics[i]) {
					if (characteristics[j].contains(characteristic)) {
						common++;
					}
				}
				result = Math.max(result, common);
			}
		}
		return result;
	}
}
