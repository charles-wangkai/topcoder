import java.util.Arrays;
import java.util.HashSet;

public class UserName {
	public String newMember(String[] existingNames, String newName) {
		HashSet<String> existing = new HashSet<String>(
				Arrays.asList(existingNames));
		if (!existing.contains(newName)) {
			return newName;
		}
		for (int i = 1;; i++) {
			String name = newName + i;
			if (!existing.contains(name)) {
				return name;
			}
		}
	}
}
