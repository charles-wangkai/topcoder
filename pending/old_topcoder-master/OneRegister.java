import java.util.LinkedList;
import java.util.Queue;

public class OneRegister {
	public String getProgram(int s, int t) {
		Queue<Element> queue = new LinkedList<Element>();
		queue.offer(new Element(s, ""));
		while (!queue.isEmpty()) {
			Element head = queue.poll();
			if (head.number == t) {
				return head.instructions;
			}
			Operator[] operators = { new Multiplication(), new Addition(),
					new Division() };
			for (Operator operator : operators) {
				if (operator instanceof Division
						&& !head.instructions.equals("")) {
					continue;
				}
				long nextNumber = operator.getResult(head.number);
				if (nextNumber != head.number && nextNumber <= t) {
					queue.offer(new Element((int) nextNumber, head.instructions
							+ operator.getInstruction()));
				}
			}
		}
		return ":-(";
	}
}

class Element {
	int number;
	String instructions;

	public Element(int number, String instructions) {
		this.number = number;
		this.instructions = instructions;
	}
}

interface Operator {
	char getInstruction();

	long getResult(int operand);
}

class Addition implements Operator {
	@Override
	public char getInstruction() {
		return '+';
	}

	@Override
	public long getResult(int operand) {
		return operand + operand;
	}
}

class Multiplication implements Operator {
	@Override
	public char getInstruction() {
		return '*';
	}

	@Override
	public long getResult(int operand) {
		return (long) operand * operand;
	}
}

class Division implements Operator {
	@Override
	public char getInstruction() {
		return '/';
	}

	@Override
	public long getResult(int operand) {
		return operand / operand;
	}
}