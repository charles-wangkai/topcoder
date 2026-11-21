import java.util.stream.IntStream;

public class FauxPalindromes {

	public String classifyIt(String word) {
		System.out.println(compress(word));
		if (isPalindrome(word)) {
			return "PALINDROME";
		} else if (isPalindrome(compress(word))) {
			return "FAUX";
		} else {
			return "NOT EVEN FAUX";
		}
	}

	boolean isPalindrome(String word) {
		return new StringBuilder(word).reverse().toString().equals(word);
	}

	String compress(String word) {
		return IntStream
				.range(0, word.length())
				.filter((i) -> i == 0 || word.charAt(i) != word.charAt(i - 1))
				.collect(StringBuilder::new,
						(sb, i) -> sb.append(word.charAt(i)),
						StringBuilder::append).toString();
	}
}
