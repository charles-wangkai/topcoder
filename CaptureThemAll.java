import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CaptureThemAll {
  static final int SIZE = 8;

  public int fastKnight(String knight, String rook, String queen) {
    return Math.min(computeDistance(knight, rook), computeDistance(knight, queen))
        + computeDistance(rook, queen);
  }

  int computeDistance(String begin, String end) {
    Point beginPoint = new Point(begin);
    Point endPoint = new Point(end);

    int[][] distances = new int[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      Arrays.fill(distances[r], -1);
    }
    distances[beginPoint.r][beginPoint.c] = 0;

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(beginPoint);
    while (true) {
      Point head = queue.poll();
      if (head.r == endPoint.r && head.c == endPoint.c) {
        return distances[endPoint.r][endPoint.c];
      }

      for (int rOffset = -2; rOffset <= 2; ++rOffset) {
        for (int cOffset = -2; cOffset <= 2; ++cOffset) {
          if (Math.abs(rOffset) * Math.abs(cOffset) == 2) {
            int nextR = head.r + rOffset;
            int nextC = head.c + cOffset;
            if (nextR >= 0
                && nextR < SIZE
                && nextC >= 0
                && nextC < SIZE
                && distances[nextR][nextC] == -1) {
              distances[nextR][nextC] = distances[head.r][head.c] + 1;
              queue.offer(new Point(nextR, nextC));
            }
          }
        }
      }
    }
  }

  class Point {
    int r;
    int c;

    Point(String s) {
      r = s.charAt(1) - '1';
      c = s.charAt(0) - 'a';
    }

    Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, String p2, boolean hasAnswer, int p3) {
    System.out.print(
        "Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"" + "," + "\"" + p2
            + "\"");
    System.out.println("]");
    CaptureThemAll obj;
    int answer;
    obj = new CaptureThemAll();
    long startTime = System.currentTimeMillis();
    answer = obj.fastKnight(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p3);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p3;
    }
    if (!res) {
      System.out.println("DOESN'T MATCH!!!!");
    } else if ((endTime - startTime) / 1000.0 >= 2) {
      System.out.println("FAIL the timeout");
      res = false;
    } else if (hasAnswer) {
      System.out.println("Match :-)");
    } else {
      System.out.println("OK, but is it right?");
    }
    System.out.println("");
    return res;
  }

  public static void main(String[] args) {
    boolean all_right;
    all_right = true;

    String p0;
    String p1;
    String p2;
    int p3;

    // ----- test 0 -----
    p0 = "a1";
    p1 = "b3";
    p2 = "c5";
    p3 = 2;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "b1";
    p1 = "c3";
    p2 = "a3";
    p3 = 3;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "a1";
    p1 = "a2";
    p2 = "b2";
    p3 = 6;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "a5";
    p1 = "b7";
    p2 = "e4";
    p3 = 3;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "h8";
    p1 = "e2";
    p2 = "d2";
    p3 = 6;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
    // ------------------

    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
