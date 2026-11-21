public class Execution {
	int pos;
	String program;

	public long analyze(String[] code) {
		program = "";
		for (int i = 0; i < code.length; i++) {
			program += code[i];
		}
		program = program.replaceAll(" ", "");
		pos=0;
		return count();
	}

	long count() {
		long total = 0;
		while (pos < program.length() && program.charAt(pos)!='}') {
			if (program.charAt(pos) == 'f') {
				total += countFor();
			} else {
				total++;
				pos += 6;
			}
		}
		if (pos < program.length() && program.charAt(pos)=='}') {
			pos++;
		}
		return total;
	}

	long countFor() {
		int temp = program.indexOf(')', pos);
		long times = Long.parseLong(program.substring(pos + 4, temp));
		pos=temp+2;
		return times * count();
	}
}
