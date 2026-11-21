import java.util.Arrays;

public class Badgers {
	public int feedMost(int[] hunger, int[] greed, int totalFood) {
		Badger[] badgers = new Badger[hunger.length];
		for (int i = 0; i < badgers.length; i++) {
			badgers[i] = new Badger(hunger[i], greed[i]);
		}
		int feedNum = 1;
		while (feedNum <= badgers.length) {
			Arrays.sort(badgers);
			int total = 0;
			for (int i = 0; i < feedNum; i++) {
				total += badgers[i].eat;
			}
			if (total > totalFood) {
				break;
			}
			for (Badger badger : badgers) {
				badger.eat += badger.greed;
			}
			feedNum++;
		}
		feedNum--;
		return feedNum;
	}
}

class Badger implements Comparable<Badger> {
	int eat;
	int greed;

	public Badger(int eat, int greed) {
		this.eat = eat;
		this.greed = greed;
	}

	public int compareTo(Badger other) {
		return eat - other.eat;
	}
}