public class MixtureDensity {
	public double getDensity(String[] ingredients) {
		int totalMass = 0;
		int totalVolume = 0;
		for (String ingredient : ingredients) {
			String fields[] = ingredient.split(", ");
			int volume = Integer.parseInt(fields[0].split(" ")[0]);
			int mass = Integer.parseInt(fields[1].split(" ")[1]);
			totalMass += mass;
			totalVolume += volume;
		}
		return (double) totalMass / totalVolume;
	}
}
