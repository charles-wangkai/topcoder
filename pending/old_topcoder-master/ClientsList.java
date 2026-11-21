import java.util.Arrays;

public class ClientsList {
	public String[] dataCleanup(String[] names) {
		Name nameList[] = new Name[names.length];
		for (int i = 0; i < nameList.length; i++) {
			if (names[i].contains(", ")) {
				String fields[] = names[i].split(", ");
				nameList[i] = new Name(fields[1], fields[0]);
			} else {
				String fields[] = names[i].split(" ");
				nameList[i] = new Name(fields[0], fields[1]);
			}
		}
		Arrays.sort(nameList);
		String result[] = new String[nameList.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = nameList[i].first + " " + nameList[i].last;
		}
		return result;
	}
}

class Name implements Comparable<Name> {
	String first;
	String last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public int compareTo(Name other) {
		int cmp = last.compareTo(other.last);
		if (cmp == 0) {
			return first.compareTo(other.first);
		} else {
			return cmp;
		}
	}
}