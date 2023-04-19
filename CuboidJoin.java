import java.util.stream.IntStream;

public class CuboidJoin {
  public long totalVolume(int[] cuboids) {
    Cuboid[] cuboidArray =
        IntStream.range(0, cuboids.length / 6)
            .mapToObj(
                i ->
                    new Cuboid(
                        cuboids[i * 6],
                        cuboids[i * 6 + 1],
                        cuboids[i * 6 + 2],
                        cuboids[i * 6 + 3],
                        cuboids[i * 6 + 4],
                        cuboids[i * 6 + 5]))
            .toArray(Cuboid[]::new);

    long result = 0;
    for (int mask = 1; mask < 1 << cuboidArray.length; ++mask) {
      int sign = -1;
      int minX = Integer.MIN_VALUE;
      int maxX = Integer.MAX_VALUE;
      int minY = Integer.MIN_VALUE;
      int maxY = Integer.MAX_VALUE;
      int minZ = Integer.MIN_VALUE;
      int maxZ = Integer.MAX_VALUE;
      for (int i = 0; i < cuboidArray.length; ++i) {
        if (((mask >> i) & 1) == 1) {
          sign *= -1;

          minX = Math.max(minX, cuboidArray[i].x1);
          maxX = Math.min(maxX, cuboidArray[i].x2);
          minY = Math.max(minY, cuboidArray[i].y1);
          maxY = Math.min(maxY, cuboidArray[i].y2);
          minZ = Math.max(minZ, cuboidArray[i].z1);
          maxZ = Math.min(maxZ, cuboidArray[i].z2);
        }
      }

      result +=
          sign * Math.max(0L, maxX - minX) * Math.max(0, maxY - minY) * Math.max(0, maxZ - minZ);
    }

    return result;
  }

  class Cuboid {
    int x1;
    int y1;
    int z1;
    int x2;
    int y2;
    int z2;

    Cuboid(int x1, int y1, int z1, int x2, int y2, int z2) {
      this.x1 = x1;
      this.y1 = y1;
      this.z1 = z1;
      this.x2 = x2;
      this.y2 = y2;
      this.z2 = z2;
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, long p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    CuboidJoin obj;
    long answer;
    obj = new CuboidJoin();
    long startTime = System.currentTimeMillis();
    answer = obj.totalVolume(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p1);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p1;
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

    int[] p0;
    long p1;

    // ----- test 0 -----
    p0 = new int[] {0, 0, 0, 1, 1, 1};
    p1 = 1L;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2};
    p1 = 2L;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {0, 0, 0, 4, 4, 4, 0, 0, 0, 1, 1, 1};
    p1 = 64L;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {-5000, -5000, -5000, 5000, 5000, 5000};
    p1 = 1000000000000L;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[] {0, 0, 0, 1, 2, 3, 5, 5, 5, 6, 6, 6};
    p1 = 7L;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new int[] {};
    p1 = 0L;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = new int[] {0, 0, 0, 1, 1, 0};
    p1 = 0L;
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
