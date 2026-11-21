import java.util.Arrays;

public class Bonuses {
	public int[] getDivision(int[] points) {
		int n = points.length;
		int total = 0;
		Employee employees[] = new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i] = new Employee(i, points[i]);
			total += points[i];
		}
		Arrays.sort(employees);
		int rest = 100;
		for (int i = 0; i < n; i++) {
			employees[i].percentage = employees[i].point * 100 / total;
			rest -= employees[i].percentage;
		}
		for (int i = 0; i < rest; i++) {
			employees[i].percentage++;
		}
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			result[employees[i].index] = employees[i].percentage;
		}
		return result;
	}
}

class Employee implements Comparable<Employee> {
	int index;
	int point;
	int percentage;

	Employee(int theIndex, int thePoint) {
		this.index = theIndex;
		this.point = thePoint;
	}

	public int compareTo(Employee another) {
		if (this.point != another.point) {
			return another.point - this.point;
		} else {
			return this.index - another.index;
		}
	}
}