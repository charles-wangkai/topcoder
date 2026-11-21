import java.util.HashMap;

public class PirateTreasure {
	public double getDistance(int[] steps, String[] directions) {
		HashMap<String, double[]> direction2offsetXY = new HashMap<String, double[]>();
		double sqrtHalf = Math.sqrt(2) / 2;
		direction2offsetXY.put("NORTH", new double[] { 0, 1 });
		direction2offsetXY.put("SOUTH", new double[] { 0, -1 });
		direction2offsetXY.put("EAST", new double[] { 1, 0 });
		direction2offsetXY.put("WEST", new double[] { -1, 0 });
		direction2offsetXY
				.put("NORTHEAST", new double[] { sqrtHalf, sqrtHalf });
		direction2offsetXY.put("NORTHWEST",
				new double[] { -sqrtHalf, sqrtHalf });
		direction2offsetXY.put("SOUTHEAST",
				new double[] { sqrtHalf, -sqrtHalf });
		direction2offsetXY.put("SOUTHWEST",
				new double[] { -sqrtHalf, -sqrtHalf });
		double x = 0;
		double y = 0;
		for (int i = 0; i < steps.length; i++) {
			double offsetXY[] = direction2offsetXY.get(directions[i]);
			x += offsetXY[0] * steps[i];
			y += offsetXY[1] * steps[i];
		}
		return Math.sqrt(x * x + y * y);
	}
}
