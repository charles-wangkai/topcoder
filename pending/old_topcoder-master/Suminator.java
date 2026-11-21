import java.util.Stack;

public class Suminator {
	public int findMissing(int[] program, int wantedResult) {
		int missingIndex = -1;
		for (int i = 0;; i++) {
			if (program[i] == -1) {
				missingIndex = i;
				break;
			}
		}

		program[missingIndex] = 0;
		if (execute(program).number == wantedResult) {
			return 0;
		}

		program[missingIndex] = -1;
		Result result = execute(program);
		if (!result.containsMissing) {
			if (result.number == wantedResult) {
				return 1;
			} else {
				return -1;
			}
		} else {
			long missing = wantedResult - result.number;
			if (missing > 0) {
				return (int) missing;
			} else {
				return -1;
			}
		}
	}

	Result execute(int[] program) {
		Stack<Result> stack = new Stack<Result>();
		for (int element : program) {
			if (element == 0) {
				Result prev1 = pop(stack);
				Result prev2 = pop(stack);
				stack.push(Result.add(prev1, prev2));
			} else if (element == -1) {
				stack.push(new Result(0, true));
			} else {
				stack.push(new Result(element, false));
			}
		}
		return stack.pop();
	}

	Result pop(Stack<Result> stack) {
		if (stack.isEmpty()) {
			return new Result(0, false);
		}
		return stack.pop();
	}
}

class Result {
	long number;
	boolean containsMissing;

	Result(long number, boolean containsMissing) {
		this.number = number;
		this.containsMissing = containsMissing;
	}

	static Result add(Result result1, Result result2) {
		return new Result(result1.number + result2.number,
				result1.containsMissing || result2.containsMissing);
	}
}