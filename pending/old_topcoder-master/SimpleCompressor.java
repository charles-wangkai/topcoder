public class SimpleCompressor {
	public String uncompress(String toUncompress) {
		String result = "";
		int count = 0;
		int begin = -1;
		int repeat = -1;
		for (int i = 0; i < toUncompress.length(); i++) {
			char ch = toUncompress.charAt(i);
			if (ch == '[') {
				count++;
				if (count == 1) {
					begin = i + 2;
					repeat = toUncompress.charAt(i + 1) - '0';
					i++;
				}
			} else if (ch == ']') {
				count--;
				if (count == 0) {
					String part = uncompress(toUncompress.substring(begin, i));
					for (int j = 0; j < repeat; j++) {
						result += part;
					}
				}
			} else if (count == 0) {
				result += ch;
			}
		}
		return result;
	}
}
