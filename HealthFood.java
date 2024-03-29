import java.util.Arrays;
import java.util.stream.IntStream;

public class HealthFood {
  public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
    return Arrays.stream(dietPlans)
        .mapToInt(
            dietPlan ->
                IntStream.range(0, protein.length)
                    .boxed()
                    .min(
                        (i1, i2) -> {
                          int calorie1 = computeCalorie(protein[i1], carbs[i1], fat[i1]);
                          int calorie2 = computeCalorie(protein[i2], carbs[i2], fat[i2]);

                          for (char criteria : dietPlan.toCharArray()) {
                            if (criteria == 'C' && carbs[i1] != carbs[i2]) {
                              return -Integer.compare(carbs[i1], carbs[i2]);
                            } else if (criteria == 'c' && carbs[i1] != carbs[i2]) {
                              return Integer.compare(carbs[i1], carbs[i2]);
                            } else if (criteria == 'P' && protein[i1] != protein[i2]) {
                              return -Integer.compare(protein[i1], protein[i2]);
                            } else if (criteria == 'p' && protein[i1] != protein[i2]) {
                              return Integer.compare(protein[i1], protein[i2]);
                            } else if (criteria == 'F' && fat[i1] != fat[i2]) {
                              return -Integer.compare(fat[i1], fat[i2]);
                            } else if (criteria == 'f' && fat[i1] != fat[i2]) {
                              return Integer.compare(fat[i1], fat[i2]);
                            } else if (criteria == 'T' && calorie1 != calorie2) {
                              return -Integer.compare(calorie1, calorie2);
                            } else if (criteria == 't' && calorie1 != calorie2) {
                              return Integer.compare(calorie1, calorie2);
                            }
                          }

                          return Integer.compare(i1, i2);
                        })
                    .get())
        .toArray();
  }

  int computeCalorie(int p, int c, int f) {
    return p * 5 + c * 5 + f * 9;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int[] p1, int[] p2, String[] p3, boolean hasAnswer, int[] p4) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p1[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p2[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p3.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p3[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    HealthFood obj;
    int[] answer;
    obj = new HealthFood();
    long startTime = System.currentTimeMillis();
    answer = obj.selectMeals(p0, p1, p2, p3);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p4.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p4[i]);
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(answer[i]);
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p4.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p4[i]) {
            res = false;
          }
        }
      }
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
    int[] p1;
    int[] p2;
    String[] p3;
    int[] p4;

    // ----- test 0 -----
    p0 = new int[] {3, 4};
    p1 = new int[] {2, 8};
    p2 = new int[] {5, 2};
    p3 = new String[] {"P", "p", "C", "c", "F", "f", "T", "t"};
    p4 = new int[] {1, 0, 1, 0, 0, 1, 1, 0};
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {3, 4, 1, 5};
    p1 = new int[] {2, 8, 5, 1};
    p2 = new int[] {5, 2, 4, 4};
    p3 = new String[] {"tFc", "tF", "Ftc"};
    p4 = new int[] {3, 2, 0};
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {18, 86, 76, 0, 34, 30, 95, 12, 21};
    p1 = new int[] {26, 56, 3, 45, 88, 0, 10, 27, 53};
    p2 = new int[] {93, 96, 13, 95, 98, 18, 59, 49, 86};
    p3 =
        new String[] {
          "f", "Pt", "PT", "fT", "Cp", "C", "t", "", "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"
        };
    p4 = new int[] {2, 6, 6, 2, 4, 4, 5, 0, 5, 5, 6, 6, 3, 5, 6};
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
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
