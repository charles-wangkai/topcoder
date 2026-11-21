public class InboxCleanup {
	public int fewestClicks(String messages, int low, int high) {
		int minClick = Integer.MAX_VALUE;
		for (int msgPerPage = low; msgPerPage <= high; msgPerPage++) {
			int click = 0;
			for (int begin = 0, end = msgPerPage;; begin += msgPerPage, end += msgPerPage) {
				click += getClickOnPage(messages.substring(begin,
						Math.min(end, messages.length())));
				if (end >= messages.length()) {
					break;
				}
				click++;
			}
			minClick = Math.min(minClick, click);
		}
		return minClick;
	}

	int getClickOnPage(String messages) {
		int deleteCount = 0;
		for (int i = 0; i < messages.length(); i++) {
			if (messages.charAt(i) == 'D') {
				deleteCount++;
			}
		}
		return (deleteCount > 0 ? 1 : 0)
				+ Math.min(deleteCount, 1 + messages.length() - deleteCount);
	}
}
