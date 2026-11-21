import java.util.ArrayList;

public class AverageProblem {
	public int numberOfParticipants(String[] marks) {
		ArrayList<Integer> oneThousandthes = new ArrayList<Integer>();
		for (String oneMarks : marks) {
			String fields[] = oneMarks.split(" ");
			for (String field : fields) {
				oneThousandthes.add(Integer.parseInt(field
						.replaceAll("\\.", "")));
			}
		}
		for (int participant = 1;; participant++) {
			boolean valid = true;
			for (int oneThousandth : oneThousandthes) {
				if (divideToCeil(participant * oneThousandth, 1000) * 1000
						/ participant != oneThousandth) {
					valid = false;
					break;
				}
			}
			if (valid) {
				return participant;
			}
		}
	}

	int divideToCeil(int a, int b) {
		return a / b + (a % b == 0 ? 0 : 1);
	}
}
