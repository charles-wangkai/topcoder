import java.util.HashSet;
import java.util.Set;

public class TopFox {
	public int possibleHandles(String familyName, String givenName) {
		Set<String> handles = new HashSet<String>();
		for (int i = 1; i <= familyName.length(); i++) {
			for (int j = 1; j <= givenName.length(); j++) {
				handles.add(familyName.substring(0, i)
						+ givenName.substring(0, j));
			}
		}
		return handles.size();
	}
}
