import java.util.HashSet;

public class TheBoringStoreDivTwo {
	public String find(String J, String B) {
		HashSet<Pieces> piecesJ = cut(J, new PrefixChecker());
		HashSet<Pieces> piecesB = cut(B, new SuffixChecker());
		String result = "";
		for (Pieces onePiecesJ : piecesJ) {
			for (Pieces onePiecesB : piecesB) {
				String[] plates1 = { onePiecesJ.first + onePiecesB.first,
						onePiecesJ.second + onePiecesB.first };
				String[] plates2 = { onePiecesJ.second + onePiecesB.second,
						onePiecesJ.first + onePiecesB.second };
				for (int i = 0; i < plates1.length; i++) {
					String plate1 = plates1[i];
					String plate2 = plates2[i];
					if (plate1.equals(plate2)
							&& (plate1.length() > result.length() || (plate1
									.length() == result.length() && plate1
									.compareTo(result) < 0))) {
						result = plate1;
					}
				}
			}
		}
		return result;
	}

	HashSet<Pieces> cut(String str, Checker checker) {
		HashSet<Pieces> pieces = new HashSet<Pieces>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String first = str.substring(i, j);
				for (int p = j; p < str.length(); p++) {
					for (int q = p + 1; q <= str.length(); q++) {
						String second = str.substring(p, q);
						if (checker.check(first, second)) {
							pieces.add(new Pieces(first, second));
						}
					}
				}
			}
		}
		return pieces;
	}
}

class Pieces {
	String first;
	String second;

	Pieces(String first, String second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int hashCode() {
		return first.hashCode() * second.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Pieces other = (Pieces) obj;
		return first.equals(other.first) && second.equals(other.second);
	}
}

interface Checker {
	boolean check(String str1, String str2);
}

class PrefixChecker implements Checker {
	public boolean check(String str1, String str2) {
		return str1.startsWith(str2) || str2.startsWith(str1);
	}
}

class SuffixChecker implements Checker {
	public boolean check(String str1, String str2) {
		return str1.endsWith(str2) || str2.endsWith(str1);
	}
}
