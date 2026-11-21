import java.math.BigInteger;

public class Conglutination {
	public String split(String conglutination, int expectation) {
		for (int i = 1; i <= conglutination.length() - 1; i++) {
			String part1 = conglutination.substring(0, i);
			String part2 = conglutination.substring(i);
			if (new BigInteger(part1).add(new BigInteger(part2)).equals(
					new BigInteger(expectation + ""))) {
				return part1 + "+" + part2;
			}
		}
		return "";
	}
}
