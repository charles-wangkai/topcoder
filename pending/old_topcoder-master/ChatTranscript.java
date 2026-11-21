public class ChatTranscript {
	public int howMany(String[] transcript, String name) {
		int count = 0;
		for (String line : transcript) {
			if (line.startsWith(name + ":")) {
				count++;
			}
		}
		return count;
	}
}
