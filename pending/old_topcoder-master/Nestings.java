import java.util.Stack;

public class Nestings {
	public int howDeep(String nested) {
		int deep = 0;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < nested.length(); i++) {
			char ch = nested.charAt(i);
			if (Character.isLetter(ch)) {
				continue;
			}
			if (ch == '<'
					|| ch == '('
					|| ch == '['
					|| ch == '{'
					|| (ch == '/' && i + 1 < nested.length() && nested
							.charAt(i + 1) == '*')) {
				stack.push(ch);
				deep = Math.max(deep, stack.size());
			} else if (!stack.empty()
					&& ((ch == '>' && stack.peek() == '<')
							|| (ch == ')' && stack.peek() == '(')
							|| (ch == ']' && stack.peek() == '[')
							|| (ch == '}' && stack.peek() == '{') || (ch == '*'
							&& i + 1 < nested.length()
							&& nested.charAt(i + 1) == '/' && stack.peek() == '/'))) {
				stack.pop();
			} else {
				return -1;
			}
			if (ch == '/' || ch == '*') {
				i++;
			}
		}
		if (!stack.empty()) {
			return -1;
		} else {
			return deep;
		}
	}
}
