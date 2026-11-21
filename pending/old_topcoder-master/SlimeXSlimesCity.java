import java.util.ArrayList;

public class SlimeXSlimesCity {
	public int merge(int[] population) {
		int cityNameNum = 0;
		for (int i = 0; i < population.length; i++) {
			if (canBeCityName(population, i)) {
				cityNameNum++;
			}
		}
		return cityNameNum;
	}

	boolean canBeCityName(int[] population, int index) {
		ArrayList<Long> numbers = new ArrayList<Long>();
		numbers.add((long) population[index]);
		for (int i = 0; i < population.length; i++) {
			if (i != index) {
				numbers.add((long) population[i]);
			}
		}
		while (numbers.size() > 1) {
			boolean found = false;
			for (int i = 1; i < numbers.size(); i++) {
				if (numbers.get(i) <= numbers.get(0)) {
					numbers.set(0, numbers.get(0) + numbers.get(i));
					numbers.remove(i);
					found = true;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}
}
