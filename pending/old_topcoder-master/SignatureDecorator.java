public class SignatureDecorator {
	public String applyDecoration(String name, String[] commands,
			String[] decorations) {
		String result = name;
		for (int i = 0; i < commands.length; i++) {
			if (commands[i].equals("prepend")) {
				result = decorations[i] + result;
			} else if (commands[i].equals("append")) {
				result += decorations[i];
			} else {
				result = decorations[i] + result
						+ new StringBuffer(decorations[i]).reverse().toString();
			}
		}
		return result;
	}
}
