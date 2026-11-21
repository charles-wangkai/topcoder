import java.util.HashSet;

public class CDPlayer {
	public int isRandom(String[] songlist, int n) {
		String songs = "";
		for (String oneSonglist : songlist) {
			songs += oneSonglist;
		}
		for (int i = 0; i < Math.min(n, songs.length()); i++) {
			if (isValid(songs, n, i)) {
				return i;
			}
		}
		return -1;
	}

	boolean isValid(String songs, int n, int first) {
		HashSet<Character> total = new HashSet<Character>();
		for (int begin = first - n, end = first; begin < songs.length(); begin += n, end += n) {
			HashSet<Character> current = new HashSet<Character>();
			String part = songs.substring(Math.max(0, begin),
					Math.min(songs.length(), end));
			for (int i = 0; i < part.length(); i++) {
				char ch = part.charAt(i);
				if (current.contains(ch)) {
					return false;
				}
				current.add(ch);
			}
			for (char ch : current) {
				total.add(ch);
			}
			if (total.size() > n) {
				return false;
			}
		}
		return true;
	}
}
