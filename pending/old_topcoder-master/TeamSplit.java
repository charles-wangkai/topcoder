
import java.util.Arrays;

public class TeamSplit {

    public int difference(int[] strengths) {
        Arrays.sort(strengths);
        int diff = 0;
        for (int i = strengths.length - 1; i >= 0; i -= 2) {
            diff += strengths[i];
            if (i >= 1) {
                diff -= strengths[i - 1];
            }
        }
        return Math.abs(diff);
    }
}
