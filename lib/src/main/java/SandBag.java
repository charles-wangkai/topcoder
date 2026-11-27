import java.util.Arrays;

public class SandBag {
  static final int THRESHOLD = 3;

  public int minNumber(int x, int y, String[] map) {
    int row = map.length;
    int col = map[0].length();

    int gridSize = row * col;

    int result = Integer.MAX_VALUE;
    for (int bag1 = 0; bag1 <= gridSize; ++bag1) {
      for (int bag2 = bag1; bag2 <= gridSize; ++bag2) {
        for (int bag3 = bag2; bag3 <= gridSize; ++bag3) {
          for (int bag4 = bag3; bag4 <= gridSize; ++bag4) {
            int[] bags = {bag1, bag2, bag3, bag4};

            if (check(x, y, map, bags)) {
              result = Math.min(result, Arrays.stream(bags).map(bag -> (bag == 0) ? 0 : 1).sum());
            }
          }
        }
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  boolean check(int x, int y, String[] map, int[] bags) {
    int row = map.length;
    int col = map[0].length();

    int[][] elevations = new int[row][col];
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        elevations[r][c] = map[r].charAt(c) - '0';
      }
    }

    if (elevations[y][x] >= THRESHOLD) {
      return true;
    }

    for (int bag : bags) {
      if (bag != 0) {
        int r = (bag - 1) / col;
        int c = (bag - 1) % col;

        if (r == y && c == x) {
          return false;
        }

        elevations[r][c] = Integer.MAX_VALUE;
      }
    }

    boolean[][] flooded = new boolean[row][col];
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        if ((r == 0 || r == row - 1 || c == 0 || c == col - 1)
            && elevations[r][c] < THRESHOLD
            && !flooded[r][c]) {
          fill(flooded, elevations, r, c);
        }
      }
    }

    return !flooded[y][x];
  }

  void fill(boolean[][] flooded, int[][] elevations, int r, int c) {
    int row = flooded.length;
    int col = flooded[0].length;

    flooded[r][c] = true;

    for (int dr = -1; dr <= 1; ++dr) {
      for (int dc = -1; dc <= 1; ++dc) {
        int adjR = r + dr;
        int adjC = c + dc;
        if (adjR >= 0
            && adjR < row
            && adjC >= 0
            && adjC < col
            && elevations[adjR][adjC] < THRESHOLD
            && !flooded[adjR][adjC]) {
          fill(flooded, elevations, adjR, adjC);
        }
      }
    }
  }
}
