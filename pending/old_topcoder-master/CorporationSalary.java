public class CorporationSalary {
	public long totalSalary(String[] relations) {
		long salaries[] = new long[relations.length];
		for (int i = 0; i < salaries.length; i++) {
			search(relations, salaries, i);
		}
		long salaryTotal = 0;
		for (long salary : salaries) {
			salaryTotal += salary;
		}
		return salaryTotal;
	}

	void search(String relations[], long salaries[], int index) {
		if (salaries[index] == 0) {
			for (int j = 0; j < relations.length; j++) {
				if (relations[index].charAt(j) == 'Y') {
					search(relations, salaries, j);
					salaries[index] += salaries[j];
				}
			}
			if (salaries[index] == 0) {
				salaries[index] = 1;
			}
		}
	}
}
