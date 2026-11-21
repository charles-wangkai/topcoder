import java.util.TreeSet;

public class SquareDigits {
    public static int smallestResult(int param0) {
        int result=0;
        while (T(result).contains(param0)==false) {
            result++;
        }
        return result;
    }

    static TreeSet<Integer> T(int number) {
        TreeSet<Integer> set=new TreeSet<Integer>();
        while (true) {
            number=S(number);
            if (set.contains(number)==true) {
                break;
            }
            set.add(number);
        }
        return set;
    }

    static int S(int number) {
        int result=0;
        while (number>0) {
            int digit=number%10;
            result+=digit*digit;
            number/=10;
        }
        return result;
    }
}
