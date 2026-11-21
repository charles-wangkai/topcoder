
public class Straights {

    public int howMany(int[] hand, int k) {
        int straight = 0;
        for (int i = 0; i + k <= hand.length; i++) {
            int product = 1;
            for (int j = 0; j < k; j++) {
                product *= hand[i + j];
            }
            straight += product;
        }
        return straight;
    }
}
