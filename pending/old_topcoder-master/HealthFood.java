public class HealthFood {
	public int[] selectMeals(int[] protein, int[] carbs, int[] fat,
			String[] dietPlans) {
		int selected[] = new int[dietPlans.length];
		for (int i = 0; i < selected.length; i++) {
			for (int j = 1; j < protein.length; j++) {
				if (betterThan(protein, carbs, fat, dietPlans[i], j,
						selected[i])) {
					selected[i] = j;
				}
			}
		}
		return selected;
	}

	boolean betterThan(int protein[], int carbs[], int fat[], String dietPlan,
			int meal1, int meal2) {
		for (int i = 0; i < dietPlan.length(); i++) {
			char criteria = dietPlan.charAt(i);
			if (criteria == 'C' || criteria == 'c') {
				if (carbs[meal1] == carbs[meal2]) {
					continue;
				}
				if (criteria == 'C') {
					return carbs[meal1] > carbs[meal2];
				} else {
					return carbs[meal1] < carbs[meal2];
				}
			} else if (criteria == 'P' || criteria == 'p') {
				if (protein[meal1] == protein[meal2]) {
					continue;
				}
				if (criteria == 'P') {
					return protein[meal1] > protein[meal2];
				} else {
					return protein[meal1] < protein[meal2];
				}
			} else if (criteria == 'F' || criteria == 'f') {
				if (fat[meal1] == fat[meal2]) {
					continue;
				}
				if (criteria == 'F') {
					return fat[meal1] > fat[meal2];
				} else {
					return fat[meal1] < fat[meal2];
				}
			} else {
				int calorie1 = calcCalorie(protein[meal1], carbs[meal1],
						fat[meal1]);
				int calorie2 = calcCalorie(protein[meal2], carbs[meal2],
						fat[meal2]);
				if (calorie1 == calorie2) {
					continue;
				}
				if (criteria == 'T') {
					return calorie1 > calorie2;
				} else {
					return calorie1 < calorie2;
				}
			}
		}
		return false;
	}

	int calcCalorie(int protein, int carbs, int fat) {
		return protein * 5 + carbs * 5 + fat * 9;
	}
}
