public class TaroString {
	public String getAnswer(String S) {
		return S.chars().filter(ch -> "CAT".indexOf(ch) >= 0).mapToObj(ch -> (char) ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().equals("CAT")
						? "Possible" : "Impossible";
	}
}
