import java.util.Arrays;

public class ObjectFall {
	public int howLong(int x, int y, String[] obstacles) {
		Arrays.sort(obstacles);
		int time = y;
		for (int i = obstacles.length - 1; i >= 0; i--) {
			String fields[] = obstacles[i].split(" ");
			int obstacleY = Integer.parseInt(fields[0]);
			int obstacleX1 = Integer.parseInt(fields[1]);
			int obstacleX2 = Integer.parseInt(fields[2]);
			if (y >= obstacleY && x >= obstacleX1 && x <= obstacleX2) {
				x = obstacleX2;
				time += 5;
			}
		}
		return time;
	}
}
