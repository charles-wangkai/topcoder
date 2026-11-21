import java.util.ArrayList;

public class IndicatorMotionReverse {
	final String STATES = "|/-N";

	public String getMinProgram(String[] actions) {
		String states = "";
		for (String action : actions) {
			states += action;
		}
		String instructions = "";
		for (int i = 0; i < states.length() - 1; i++) {
			instructions += getInstruction(states.charAt(i),
					states.charAt(i + 1));
		}
		char instruction = 0;
		int repeat = -1;
		ArrayList<Instruction_Repeat> irs = new ArrayList<Instruction_Repeat>();
		for (int i = 0; i <= instructions.length(); i++) {
			if (i < instructions.length()
					&& instructions.charAt(i) == instruction) {
				repeat++;
			} else {
				if (repeat > 0) {
					irs.add(new Instruction_Repeat(instruction, repeat));
				}
				if (i < instructions.length()) {
					instruction = instructions.charAt(i);
					repeat = 1;
				}
			}
		}
		String result = "";
		for (Instruction_Repeat ir : irs) {
			result += ir.toText();
		}
		if (result.length() > 100) {
			result = result.substring(0, 97) + "...";
		}
		return result;
	}

	char getInstruction(char before, char after) {
		int beforeIndex = getStateIndex(before);
		int afterIndex = getStateIndex(after);
		if ((beforeIndex - 1 + STATES.length()) % STATES.length() == afterIndex) {
			return 'L';
		} else if ((beforeIndex + 1) % STATES.length() == afterIndex) {
			return 'R';
		} else if (beforeIndex == afterIndex) {
			return 'S';
		} else {
			return 'F';
		}
	}

	int getStateIndex(char state) {
		return STATES.indexOf(state);
	}
}

class Instruction_Repeat {
	char instruction;
	int repeat;

	public Instruction_Repeat(char instruction, int repeat) {
		this.instruction = instruction;
		this.repeat = repeat;
	}

	String toText() {
		final int REPEAT_LIMIT = 99;
		String text = "";
		int remain = repeat;
		while (remain > 0) {
			int current = Math.min(remain, REPEAT_LIMIT);
			text = String.format("%c%02d%s", instruction, current, text);
			remain -= current;
		}
		return text;
	}
}