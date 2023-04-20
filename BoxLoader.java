import java.util.stream.IntStream;

public class BoxLoader {
  public int mostItems(int boxX, int boxY, int boxZ, int itemX, int itemY, int itemZ) {
    return IntStream.of(
            computeItemNum(boxX, boxY, boxZ, itemX, itemY, itemZ),
            computeItemNum(boxX, boxY, boxZ, itemX, itemZ, itemY),
            computeItemNum(boxX, boxY, boxZ, itemY, itemX, itemZ),
            computeItemNum(boxX, boxY, boxZ, itemY, itemZ, itemX),
            computeItemNum(boxX, boxY, boxZ, itemZ, itemX, itemY),
            computeItemNum(boxX, boxY, boxZ, itemZ, itemY, itemX))
        .max()
        .getAsInt();
  }

  int computeItemNum(int box1, int box2, int box3, int unit1, int unit2, int unit3) {
    return (box1 / unit1) * (box2 / unit2) * (box3 / unit3);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, int p3, int p4, int p5, boolean hasAnswer, int p6) {
    System.out.print(
        "Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5);
    System.out.println("]");
    BoxLoader obj;
    int answer;
    obj = new BoxLoader();
    long startTime = System.currentTimeMillis();
    answer = obj.mostItems(p0, p1, p2, p3, p4, p5);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p6);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p6;
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
    int p2;
    int p3;
    int p4;
    int p5;
    int p6;

    // ----- test 0 -----
    p0 = 100;
    p1 = 98;
    p2 = 81;
    p3 = 3;
    p4 = 5;
    p5 = 7;
    p6 = 7560;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 10;
    p1 = 10;
    p2 = 10;
    p3 = 9;
    p4 = 9;
    p5 = 11;
    p6 = 0;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 201;
    p1 = 101;
    p2 = 301;
    p3 = 100;
    p4 = 30;
    p5 = 20;
    p6 = 100;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 913;
    p1 = 687;
    p2 = 783;
    p3 = 109;
    p4 = 93;
    p5 = 53;
    p6 = 833;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 6;
    p1 = 5;
    p2 = 4;
    p3 = 3;
    p4 = 2;
    p5 = 1;
    p6 = 20;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
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