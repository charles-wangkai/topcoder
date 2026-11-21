public class bloggoShortcuts {
	public String expand(String text) {
		String result = "";
		while (true) {
			int beginI = text.indexOf('_');
			int beginB = text.indexOf('*');
			if (beginI < 0 && beginB < 0) {
				result += text;
				break;
			}
			char tag;
			int begin;
			int end;
			if (beginI >= 0 && (beginB < 0 || beginI < beginB)) {
				tag = 'i';
				begin = beginI;
				end = text.indexOf('_', beginI + 1);
			} else {
				tag = 'b';
				begin = beginB;
				end = text.indexOf('*', beginB + 1);
			}
			result += text.substring(0, begin) + "<" + tag + ">"
					+ text.substring(begin + 1, end) + "</" + tag + ">";
			text = text.substring(end + 1);
		}
		return result;
	}
}
