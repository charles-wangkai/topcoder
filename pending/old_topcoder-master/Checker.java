import java.util.TreeSet;

public class Checker {
	public boolean CheckData(String[] lovers) {
		if (lovers.length < 2 || lovers.length > 20) {
			return false;
		}
		TreeSet<String> left = new TreeSet<String>();
		TreeSet<String> right = new TreeSet<String>();
		for (int i = 0; i < lovers.length; i++) {
			if (lovers[i].length() > 40) {
				return false;
			}
			int pos = lovers[i].indexOf(" LOVES ");
			if (pos == -1) {
				return false;
			}
			String name1 = lovers[i].substring(0, pos);
			String name2 = lovers[i].substring(pos + " LOVES ".length());
			if (name1.indexOf(' ') != -1 || name2.indexOf(' ') != -1) {
				return false;
			}
			if (name1.equals("") || name2.equals("")) {
				return false;
			}
			if (name1.equals(name2)) {
				return false;
			}
			if (!checkName(name1) || !checkName(name2)) {
				return false;
			}
			left.add(name1);
			if (right.contains(name1)) {
				right.remove(name1);
			}
			if (!left.contains(name2)) {
				right.add(name2);
			}
		}
		if (!right.isEmpty()) {
			return false;
		}
		return true;
	}

	boolean checkName(String name) {
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (ch != '-' && (ch < 'A' || ch > 'Z')) {
				return false;
			}
		}
		return true;
	}
}
