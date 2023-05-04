import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BikeRace {
  public String[] eliminated(int track, String[] name, int[] start, int[] speed) {
    List<Elimination> eliminations = new ArrayList<>();
    for (int i = 0; i < name.length; ++i) {
      for (int j = i + 1; j < name.length; ++j) {
        Elimination elimination = computeElimination(track, name, start, speed, i, j);
        if (elimination != null) {
          eliminations.add(elimination);
        }
      }
    }

    Collections.sort(
        eliminations,
        Comparator.comparing(
                (Elimination elimination) -> elimination.time,
                (r1, r2) -> Long.compare((long) r1.numer * r2.denom, (long) r2.numer * r1.denom))
            .thenComparing(elimination -> elimination.name));

    Set<String> eliminated = new HashSet<>();
    List<String> result = new ArrayList<>();
    for (Elimination elimination : eliminations) {
      if (!eliminated.contains(elimination.name) && !eliminated.contains(elimination.by)) {
        result.add(elimination.name);
        eliminated.add(elimination.name);
      }
    }

    return result.toArray(String[]::new);
  }

  Elimination computeElimination(
      int track, String[] name, int[] start, int[] speed, int index1, int index2) {
    Elimination elimination =
        computeEliminationForNotStart(track, name, start, speed, index1, index2);
    if (elimination != null) {
      return elimination;
    }

    elimination = computeEliminationForNotStart(track, name, start, speed, index2, index1);
    if (elimination != null) {
      return elimination;
    }

    elimination = computeEliminationForBothStart(track, name, start, speed, index1, index2);
    if (elimination != null) {
      return elimination;
    }

    elimination = computeEliminationForBothStart(track, name, start, speed, index2, index1);
    if (elimination != null) {
      return elimination;
    }

    return null;
  }

  Elimination computeEliminationForNotStart(
      int track, String[] name, int[] start, int[] speed, int backIndex, int frontIndex) {
    if (start[backIndex] < start[frontIndex]
        && track <= (start[frontIndex] - start[backIndex]) * speed[backIndex]) {
      return new Elimination(
          new Rational(start[backIndex] * speed[backIndex] + track, speed[backIndex]),
          name[frontIndex],
          name[backIndex]);
    }

    return null;
  }

  Elimination computeEliminationForBothStart(
      int track, String[] name, int[] start, int[] speed, int backIndex, int frontIndex) {
    if (speed[backIndex] > speed[frontIndex]) {
      int distance =
          (start[backIndex] < start[frontIndex])
              ? (track - (start[frontIndex] - start[backIndex]) * speed[backIndex])
              : ((start[backIndex] - start[frontIndex]) * speed[frontIndex]);

      return new Elimination(
          new Rational(
              distance
                  + Math.max(start[backIndex], start[frontIndex])
                      * (speed[backIndex] - speed[frontIndex]),
              speed[backIndex] - speed[frontIndex]),
          name[frontIndex],
          name[backIndex]);
    }

    return null;
  }

  class Elimination {
    Rational time;
    String name;
    String by;

    Elimination(Rational time, String name, String by) {
      this.time = time;
      this.name = name;
      this.by = by;
    }
  }

  class Rational {
    int numer;
    int denom;

    Rational(int numer, int denom) {
      this.numer = numer;
      this.denom = denom;
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, String[] p1, int[] p2, int[] p3, boolean hasAnswer, String[] p4) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p1[i] + "\"");
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
      System.out.print(p3[i]);
    }
    System.out.print("}");
    System.out.println("]");
    BikeRace obj;
    String[] answer;
    obj = new BikeRace();
    long startTime = System.currentTimeMillis();
    answer = obj.eliminated(p0, p1, p2, p3);
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
        System.out.print("\"" + p4[i] + "\"");
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + answer[i] + "\"");
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p4.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (!answer[i].equals(p4[i])) {
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

    int p0;
    String[] p1;
    int[] p2;
    int[] p3;
    String[] p4;

    // ----- test 0 -----
    p0 = 4800;
    p1 = new String[] {"A", "B", "C"};
    p2 = new int[] {0, 100, 180};
    p3 = new int[] {30, 30, 30};
    p4 = new String[] {"C"};
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 3000;
    p1 = new String[] {"BO", "JO", "AL"};
    p2 = new int[] {10, 0, 15};
    p3 = new int[] {12, 2, 10};
    p4 = new String[] {"JO", "AL"};
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 3000;
    p1 = new String[] {"BOBO", "JOHNNY", "ANNA"};
    p2 = new int[] {67, 0, 15};
    p3 = new int[] {50, 45, 3};
    p4 = new String[] {"BOBO", "ANNA"};
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 3000;
    p1 = new String[] {"B", "J", "A"};
    p2 = new int[] {66, 0, 15};
    p3 = new int[] {50, 45, 3};
    p4 = new String[] {"A", "J"};
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 5000;
    p1 = new String[] {"TOM", "TOMMY", "BILL", "SPEEDY", "JIMMY"};
    p2 = new int[] {100, 120, 110, 0, 1000};
    p3 = new int[] {50, 50, 50, 50, 50};
    p4 = new String[] {"BILL", "JIMMY", "TOM", "TOMMY"};
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = 4999;
    p1 =
        new String[] {
          "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T",
          "U", "V", "Z", "X", "Y", "W", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK",
          "AL", "AM", "AN", "AO", "AP", "AR", "AS", "AT", "AU", "AV", "AZ", "AX", "AY", "AW"
        };
    p2 =
        new int[] {
          100, 200, 300, 400, 299, 289, 133, 900, 999, 1, 2, 3, 4, 5, 6, 7, 8, 9, 211, 298, 297,
          708, 709, 501, 502, 503, 504, 505, 506, 507, 601, 602, 603, 604, 605, 606, 607, 608, 609,
          610, 611, 701, 702, 703, 704, 705, 706, 707
        };
    p3 =
        new int[] {
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
          26, 27, 28, 29, 30, 31, 32, 33, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 4
        };
    p4 =
        new String[] {
          "K", "L", "M", "N", "O", "P", "R", "S", "B", "C", "H", "AB", "AC", "AD", "AE", "AF", "AG",
          "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AR", "AS", "AT", "AU", "AV", "AW",
          "AX", "AY", "AZ", "D", "E", "F", "G", "I", "J", "V", "W", "X", "Y", "Z", "T"
        };
    all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
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