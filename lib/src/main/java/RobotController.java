import java.util.ArrayDeque;
import java.util.Deque;

public class RobotController {
  static final int SIZE = 5;
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public int execute(String program) {
    int r = 0;
    int c = 0;
    int direction = 1;
    Deque<Integer> stack = new ArrayDeque<>();
    int index = 0;
    while (true) {
      if (index == program.length()) {
        return encode(r, c);
      }

      char instruction = program.charAt(index);
      int nextR = r;
      int nextC = c;
      if (instruction == 'F') {
        nextR += R_OFFSETS[direction];
        nextC += C_OFFSETS[direction];

        ++index;
      } else if (instruction == 'B') {
        nextR -= R_OFFSETS[direction];
        nextC -= C_OFFSETS[direction];

        ++index;
      } else if (instruction == 'L') {
        direction = Math.floorMod(direction - 1, R_OFFSETS.length);

        ++index;
      } else if (instruction == 'R') {
        direction = (direction + 1) % R_OFFSETS.length;

        ++index;
      } else if (instruction == ':') {
        ++index;
      } else if (instruction == 'J') {
        stack.push(index + 1);

        while (index != program.length() && program.charAt(index) != ':') {
          ++index;
        }
        if (index == program.length()) {
          return encode(r, c);
        }
      } else {
        if (stack.isEmpty()) {
          return encode(r, c);
        }

        index = stack.pop();
      }

      if (nextR >= 0 && nextR < SIZE && nextC >= 0 && nextC < SIZE) {
        r = nextR;
        c = nextC;
      }
    }
  }

  int encode(int r, int c) {
    return r * SIZE + c;
  }
}
