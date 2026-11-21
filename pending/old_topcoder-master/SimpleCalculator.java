public class SimpleCalculator {
	public int calculate(String input) {
		Operation operations[] = { new Addition(), new Subtraction(),
				new Multiplication(), new Division() };
		for (int i = 0;; i++) {
			int index = input.indexOf(operations[i].getOperator());
			if (index >= 0) {
				int a = Integer.parseInt(input.substring(0, index));
				int b = Integer.parseInt(input.substring(index + 1));
				return operations[i].operate(a, b);
			}
		}
	}
}

interface Operation {
	char getOperator();

	int operate(int a, int b);
}

class Addition implements Operation {
	public char getOperator() {
		return '+';
	}

	public int operate(int a, int b) {
		return a + b;
	}
}

class Subtraction implements Operation {
	public char getOperator() {
		return '-';
	}

	public int operate(int a, int b) {
		return a - b;
	}
}

class Multiplication implements Operation {
	public char getOperator() {
		return '*';
	}

	public int operate(int a, int b) {
		return a * b;
	}
}

class Division implements Operation {
	public char getOperator() {
		return '/';
	}

	public int operate(int a, int b) {
		return a / b;
	}
}