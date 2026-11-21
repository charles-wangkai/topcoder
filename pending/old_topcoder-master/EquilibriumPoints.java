public class EquilibriumPoints {
	public double[] getPoints(int[] x, int[] m) {
		final double EPSILON = 1E-9;
		double points[] = new double[x.length - 1];
		for (int i = 0; i < points.length; i++) {
			double min = x[i];
			double max = x[i + 1];
			double middle;
			while (true) {
				middle = (min + max) / 2;
				if (max - min <= EPSILON) {
					break;
				}
				double leftGravitation = calcGravitation(x, m, middle, 0, i);
				double rightGravitation = calcGravitation(x, m, middle, i + 1,
						x.length - 1);
				if (leftGravitation < rightGravitation) {
					max = middle;
				} else {
					min = middle;
				}
			}
			points[i] = middle;
		}
		return points;
	}

	double calcGravitation(int x[], int m[], double point, int beginIndex,
			int endIndex) {
		double gravitation = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			gravitation += m[i] / square(point - x[i]);
		}
		return gravitation;
	}

	double square(double number) {
		return number * number;
	}
}
