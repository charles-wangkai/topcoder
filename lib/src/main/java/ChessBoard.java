import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ChessBoard {
  static final int SIZE = 8;
  static final int[] R_OFFSETS = {-2, -2, -1, 1, 2, 2, 1, -1};
  static final int[] C_OFFSETS = {-1, 1, 2, 2, 1, -1, -2, -2};

  public int getMinMoves(String pos) {
    int[] fields =
        Arrays.stream(pos.split(" "))
            .filter(s -> !s.isEmpty())
            .mapToInt(Integer::parseInt)
            .toArray();
    int startingR = fields[0] - 1;
    int startingC = fields[1] - 1;
    int destinationR = fields[2] - 1;
    int destinationC = fields[3] - 1;

    int[][] distances = new int[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      Arrays.fill(distances[r], -1);
    }
    distances[startingR][startingC] = 0;

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(startingR, startingC));

    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r + R_OFFSETS[i];
        int adjC = head.c + C_OFFSETS[i];
        if (adjR >= 0 && adjR < SIZE && adjC >= 0 && adjC < SIZE && distances[adjR][adjC] == -1) {
          distances[adjR][adjC] = distances[head.r][head.c] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    return distances[destinationR][destinationC];
  }

  record Point(int r, int c) {}
}
