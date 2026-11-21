public class HiddenMessage {
	public String getMessage(String text) {
		String fields[] = text.split(" ");
		String message = "";
		for (String field : fields) {
			if (!field.equals("")) {
				message += field.charAt(0);
			}
		}
		return message;
	}
}
