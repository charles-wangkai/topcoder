public class Whisper {
	public String toWhom(String[] usernames, String typed) {
		typed = typed.toLowerCase();
		if (!typed.startsWith("/msg ")) {
			return "not a whisper";
		}
		typed = typed.substring(5);
		String match = null;
		for (int i = 0; i < usernames.length; i++) {
			if (typed.startsWith(usernames[i].toLowerCase() + " ")
					&& (match == null || usernames[i].length() > match.length())) {
				match = usernames[i];
			}
		}
		if (match != null) {
			return match;
		} else {
			return "user is not logged in";
		}
	}
}
