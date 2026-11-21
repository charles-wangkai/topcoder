import java.util.HashMap;

public class MorselikeCode {
	public String decrypt(String[] library, String message) {
		HashMap<String, Character> sequence2char = new HashMap<String, Character>();
		for (String element : library) {
			sequence2char.put(element.substring(2), element.charAt(0));
		}
		String decoded = "";
		String fields[] = message.split(" ");
		for (String field : fields) {
			if (sequence2char.containsKey(field)) {
				decoded += sequence2char.get(field);
			} else {
				decoded += "?";
			}
		}
		return decoded;
	}
}
