public class ParameterSubstitution {
	public String processParams(String code, String[] params) {
		return substitute(code, params, params.length);
	}

	String substitute(String code, String params[], int sequence) {
		if (sequence == 0) {
			return code;
		}
		String parts[] = code.split("\\$" + sequence, -1);
		for (int i = 0; i < parts.length; i++) {
			parts[i] = substitute(parts[i], params, sequence - 1);
		}
		return join(parts, params[sequence - 1]);
	}

	String join(String parts[], String middle) {
		String result = "";
		for (int i = 0; i < parts.length; i++) {
			if (i != 0) {
				result += middle;
			}
			result += parts[i];
		}
		return result;
	}
}
