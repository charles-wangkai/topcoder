public class KidsWordGame {
	public int getCheater(String[] first, String[] second, String[] third) {
		String words[][] = { first, second, third };
		int number = first.length + second.length + third.length;
		String previous = first[0];
		for (int i = 1; i < number; i++) {
			String current = words[i % 3][i / 3];
			if (current.length() != previous.length() + 1
					|| (!current.startsWith(previous) && !current
							.endsWith(previous))) {
				return (i - 1) % 3 + 1;
			}
			previous = current;
		}
		return -1;
	}
}
