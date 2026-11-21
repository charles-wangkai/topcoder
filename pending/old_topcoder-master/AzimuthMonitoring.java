public class AzimuthMonitoring {
	public int getAzimuth(String[] instructions) {
		int azimuth = 0;
		for (String instruction : instructions) {
			String fields[] = instruction.split(" ");
			if (fields.length == 1) {
				if (fields[0].equals("LEFT")) {
					azimuth = (azimuth + 270) % 360;
				} else if (fields[0].equals("RIGHT")) {
					azimuth = (azimuth + 90) % 360;
				} else if (fields[0].equals("HALT")) {
					break;
				}
			} else if (fields.length == 2) {
				if (fields[0].equals("TURN")) {
					azimuth = (azimuth + 180) % 360;
				} else if (fields[0].equals("LEFT")) {
					int x = Integer.parseInt(fields[1]);
					azimuth = (azimuth - x + 360) % 360;
				} else if (fields[0].equals("RIGHT")) {
					int x = Integer.parseInt(fields[1]);
					azimuth = (azimuth + x) % 360;
				}
			}
		}
		return azimuth;
	}
}
