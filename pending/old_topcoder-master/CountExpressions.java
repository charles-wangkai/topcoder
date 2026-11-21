public class CountExpressions {
	public int calcExpressions(int x, int y, int val) {
		final Operator operators[] = { new Addition(), new Subtraction(),
				new Multiplication() };
		int answer = 0;
		int numbers[] = new int[4];
		int operatorIndices[] = new int[3];
		for (int pos1 = 0; pos1 < numbers.length; pos1++) {
			for (int pos2 = pos1 + 1; pos2 < numbers.length; pos2++) {
				for (int i = 0; i < numbers.length; i++) {
					if (i == pos1 || i == pos2) {
						numbers[i] = x;
					} else {
						numbers[i] = y;
					}
				}
				for (operatorIndices[0] = 0; operatorIndices[0] < operators.length; operatorIndices[0]++) {
					for (operatorIndices[1] = 0; operatorIndices[1] < operators.length; operatorIndices[1]++) {
						for (operatorIndices[2] = 0; operatorIndices[2] < operators.length; operatorIndices[2]++) {
							int result = operators[operatorIndices[2]].operate(
									operators[operatorIndices[1]].operate(
											operators[operatorIndices[0]]
													.operate(numbers[0],
															numbers[1]),
											numbers[2]), numbers[3]);
							if (result == val) {
								answer++;
							}
						}
					}
				}
			}
		}
		return answer;
	}
}

interface Operator {
	int operate(int x, int y);
}

class Addition implements Operator {
	public int operate(int x, int y) {
		return x + y;
	}
}

class Subtraction implements Operator {
	public int operate(int x, int y) {
		return x - y;
	}
}

class Multiplication implements Operator {
	public int operate(int x, int y) {
		return x * y;
	}
}