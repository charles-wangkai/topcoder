import java.util.ArrayList;

public class RabbitStepping {
	double expected = 0;
	double singlePossibility;

	public double getExpected(String field, int r) {
		singlePossibility = 1.0 / C(field.length(), r);
		search(field, new int[r], 0);
		return expected;
	}

	int C(int n, int m) {
		if (m * 2 > n) {
			return C(n, n - m);
		}
		int result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		for (int i = 1; i <= m; i++) {
			result /= i;
		}
		return result;
	}

	void search(String field, int[] positions, int index) {
		if (index == positions.length) {
			expected += singlePossibility * calcRemainRabbits(field, positions);
			return;
		}
		for (int i = (index == 0) ? 0 : (positions[index - 1] + 1); i < field
				.length(); i++) {
			positions[index] = i;
			search(field, positions, index + 1);
		}
	}

	int calcRemainRabbits(String field, int[] positions) {
		ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();
		for (int position : positions) {
			rabbits.add(new Rabbit(position, -1));
		}
		while (field.length() > 2) {
			ArrayList<Rabbit> nextRabbits = new ArrayList<Rabbit>();
			for (Rabbit rabbit : rabbits) {
				int nextPosition;
				if (rabbit.position == 0) {
					nextPosition = 1;
				} else if (rabbit.position >= field.length() - 2) {
					nextPosition = rabbit.position - 1;
				} else {
					char color = field.charAt(rabbit.position);
					if (color == 'W') {
						nextPosition = rabbit.position - 1;
					} else if (color == 'B') {
						nextPosition = rabbit.position + 1;
					} else { // color == 'R'
						if (rabbit.prev < 0) {
							nextPosition = rabbit.position - 1;
						} else {
							nextPosition = rabbit.prev;
						}
					}
				}
				nextRabbits.add(new Rabbit(nextPosition, rabbit.position));
				removeDuplicate(nextRabbits, field.length());
				rabbits = nextRabbits;
			}
			field = field.substring(0, field.length() - 1);
		}
		return rabbits.size();
	}

	void removeDuplicate(ArrayList<Rabbit> rabbits, int size) {
		int[] counts = new int[size];
		for (Rabbit rabbit : rabbits) {
			counts[rabbit.position]++;
		}
		for (int i = 0; i < rabbits.size(); i++) {
			if (counts[rabbits.get(i).position] > 1) {
				rabbits.remove(i);
				i--;
			}
		}
	}
}

class Rabbit {
	int position;
	int prev;

	public Rabbit(int position, int prev) {
		this.position = position;
		this.prev = prev;
	}
}