public class SantaGifts {
	public String[] distribute(String[] gifts, int N) {
		String children[] = new String[N];
		for (int i = 0; i < children.length; i++) {
			children[i] = "";
		}
		for (int i = 0; i < Math.min(gifts.length, N * 4); i++) {
			append(children, i % N, gifts[i]);
		}
		return children;
	}

	void append(String children[], int index, String gift) {
		if (!children[index].equals("")) {
			children[index] += " ";
		}
		children[index] += gift;
	}
}