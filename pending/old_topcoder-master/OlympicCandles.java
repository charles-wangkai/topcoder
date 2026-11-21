import java.util.ArrayList;
import java.util.Collections;

public class OlympicCandles {
	public int numberOfNights(int[] candles) {
		ArrayList<Integer> restCandles = new ArrayList<Integer>();
		for (int candle : candles) {
			restCandles.add(candle);
		}
		for (int night = 1;; night++) {
			if (restCandles.size() < night) {
				return night - 1;
			}
			Collections.sort(restCandles);
			for (int i = restCandles.size() - 1; i >= restCandles.size()
					- night; i--) {
				restCandles.set(i, restCandles.get(i) - 1);
			}
			for (int i = 0; i < restCandles.size(); i++) {
				if (restCandles.get(i) == 0) {
					restCandles.remove(i);
					i--;
				}
			}
		}
	}
}
