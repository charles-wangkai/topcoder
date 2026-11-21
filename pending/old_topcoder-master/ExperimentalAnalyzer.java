import java.util.ArrayList;

public class ExperimentalAnalyzer {
	public int[] getPredictors(String[] data) {
		Variable variables[] = new Variable[data[0].split(" ").length - 1];
		for (int i = 0; i < variables.length; i++) {
			variables[i] = new Variable();
		}
		for (String oneData : data) {
			String fields[] = oneData.split(" ");
			int outcome = Integer.parseInt(fields[0]);
			for (int i = 0; i < variables.length; i++) {
				int value = Integer.parseInt(fields[i + 1]);
				variables[i].min[outcome] = Math.min(variables[i].min[outcome],
						value);
				variables[i].max[outcome] = Math.max(variables[i].max[outcome],
						value);
			}
		}
		ArrayList<Integer> predictors = new ArrayList<Integer>();
		for (int i = 0; i < variables.length; i++) {
			if (variables[i].min[0] != Integer.MAX_VALUE
					&& variables[i].min[1] != Integer.MAX_VALUE
					&& (variables[i].min[0] > variables[i].max[1] || variables[i].min[1] > variables[i].max[0])) {
				predictors.add(i + 1);
			}
		}
		int result[] = new int[predictors.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = predictors.get(i);
		}
		return result;
	}
}

class Variable {
	int min[] = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
	int max[] = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
}