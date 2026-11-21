import java.util.stream.IntStream;

public class KeyDungeonDiv2 {
	public int countDoors(int[] doorR, int[] doorG, int[] keys) {
		return (int) IntStream
				.range(0, doorR.length)
				.filter(i -> Math.max(0, doorR[i] - keys[0])
						+ Math.max(0, doorG[i] - keys[1]) <= keys[2]).count();
	}
}
