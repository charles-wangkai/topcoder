import java.util.PriorityQueue;

public class Lottery {
    public static String[] sortByOdds(String[] rules) {
        PriorityQueue<Element> elements = new PriorityQueue<Element>();
        for (int i = 0; i < rules.length; i++) {
            String str[] = rules[i].split(":");
            String name = str[0];
            str = str[1].split(" ");
            int choices = Integer.parseInt(str[1]);
            int blanks = Integer.parseInt(str[2]);
            boolean sorted = (str[3].charAt(0) == 'T');
            boolean unique = (str[4].charAt(0) == 'T');
            long possible;
            if (sorted == false && unique == false) {
                possible = 1;
                for (int j = 0; j < blanks; j++) {
                    possible *= choices;
                }
            } else if (sorted == false && unique == true) {
                possible = P(choices, blanks);
            } else if (sorted == true && unique == false) {
                int coef[][] = new int[blanks + 1][];
                for (int j = 1; j <= blanks; j++) {
                    coef[j] = new int[j + 2];
                    if (j == 1) {
                        coef[1][1] = 1;
                    } else {
                        for (int k = 1; k <= j; k++) {
                            coef[j][k] = coef[j - 1][k - 1] + coef[j - 1][k];
                        }
                    }
                }
                possible = 0;
                for (int j = 1; j <= blanks; j++) {
                    possible += coef[blanks][j] * C(choices, j);
                }
            } else {
                possible = C(choices, blanks);
            }
            elements.offer(new Element(name, possible));
        }
        String results[] = new String[rules.length];
        for (int i = 0; i < results.length; i++) {
            Element head = elements.poll();
            results[i] = head.name;
        }
        return results;
    }

    static long P(int a, int b) {
        long result = 1;
        for (int i = a; i > a - b; i--) {
            result *= i;
        }
        return result;
    }

    static long C(int a, int b) {
        long result = P(a, b);
        for (int i = 2; i <= b; i++) {
            result /= i;
        }
        return result;
    }

    static class Element implements Comparable<Element> {
        String name;
        long possible;

        public Element(String theName, long thePossible) {
            this.name = theName;
            this.possible = thePossible;
        }

        public int compareTo(Element another) {
            if (this.possible < another.possible) {
                return -1;
            } else if (this.possible > another.possible) {
                return 1;
            } else {
                return this.name.compareTo(another.name);
            }
        }
    }
}
