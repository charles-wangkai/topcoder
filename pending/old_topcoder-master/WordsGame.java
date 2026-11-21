public class WordsGame {
	public int minimumSwaps(String[] grid, String word) {
		int minSwap = Integer.MAX_VALUE;
		int length = word.length();
		String wordKey = generateKey(word);
		for (int i = 0; i < length; i++) {
			String[] lines = { concat(grid, i, 0, 0, 1),
					concat(grid, 0, i, 1, 0) };
			for (String line : lines) {
				String lineKey = generateKey(line);
				if (lineKey.equals(wordKey)) {
					int swap = calcSwap(line, word);
					minSwap = Math.min(minSwap, swap);
				}
			}
		}
		return minSwap == Integer.MAX_VALUE ? -1 : minSwap;
	}

	String concat(String[] grid, int beginX, int beginY, int offsetX,
			int offsetY) {
		String result = "";
		for (int x = beginX, y = beginY; x < grid.length && y < grid.length; x += offsetX, y += offsetY) {
			result += grid[x].charAt(y);
		}
		return result;
	}

	String generateKey(String str) {
		int[] counts = new int['z' - 'A' + 1];
		for (int i = 0; i < str.length(); i++) {
			counts[str.charAt(i) - 'A']++;
		}
		String key = "";
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				key += counts[i] + "" + (char) (i + 'A');
			}
		}
		return key;
	}

	int calcSwap(String line, String word) {
		int swap = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = line.indexOf(ch, i);
			if (index != i) {
				line = swapChars(line, i, index);
				swap++;
			}
		}
		return swap;
	}

	String swapChars(String str, int index1, int index2) {
		return str.substring(0, index1) + str.charAt(index2)
				+ str.substring(index1 + 1, index2) + str.charAt(index1)
				+ str.substring(index2 + 1);
	}
}
