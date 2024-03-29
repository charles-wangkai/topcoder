public class WaterLevel {
  public double netAmt(int evapNormal, int evapFlood, int[] rain) {
    double amount = 0;
    for (int r : rain) {
      if (amount > 0) {
        if (r >= evapFlood) {
          amount += r - evapFlood;
        } else {
          double backTime = amount / (evapFlood - r);
          if (backTime >= 1) {
            amount -= evapFlood - r;
          } else {
            amount = 0;

            if (r < evapNormal) {
              amount -= (1 - backTime) * (evapNormal - r);
            }
          }
        }
      } else {
        if (r <= evapNormal) {
          amount -= evapNormal - r;
        } else {
          double backTime = -amount / (r - evapNormal);
          if (backTime >= 1) {
            amount += r - evapNormal;
          } else {
            amount = 0;

            if (r > evapFlood) {
              amount += (1 - backTime) * (r - evapFlood);
            }
          }
        }
      }
    }

    return amount;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int[] p2, boolean hasAnswer, double p3) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p2[i]);
    }
    System.out.print("}");
    System.out.println("]");
    WaterLevel obj;
    double answer;
    obj = new WaterLevel();
    long startTime = System.currentTimeMillis();
    answer = obj.netAmt(p0, p1, p2);
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
      res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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

    int p0;
    int p1;
    int[] p2;
    double p3;

    // ----- test 0 -----
    p0 = 20;
    p1 = 40;
    p2 = new int[] {0, 60, 0, 0};
    p3 = -35.0D;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 20;
    p1 = 39;
    p2 = new int[] {0, 60};
    p3 = 10.5D;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 20;
    p1 = 40;
    p2 = new int[] {0};
    p3 = -20.0D;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 200;
    p1 = 800;
    p2 = new int[] {0, 600};
    p3 = 0.0D;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
