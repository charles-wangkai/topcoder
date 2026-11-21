public class DegreesToRadians {
	public double convertToRadians(int degrees, int minutes, int seconds) {
		return (degrees + minutes / 60.0 + seconds / 3600.0) * Math.PI / 180;
	}
}
