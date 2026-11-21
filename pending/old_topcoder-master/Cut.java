import java.util.ArrayList;
import java.util.Collections;

public class Cut {
	public int getMaximum(int[] eelLengths, int maxCuts) {
		ArrayList<Integer> tens = new ArrayList<Integer>();
		ArrayList<Integer> nonTens = new ArrayList<Integer>();
		for (int eelLength : eelLengths) {
			if (eelLength % 10 == 0) {
				tens.add(eelLength);
			} else {
				nonTens.add(eelLength);
			}
		}
		Collections.sort(tens);
		int number = 0;
		for (int ten : tens) {
			int cutNeeded = ten / 10 - 1;
			int cutActual = Math.min(cutNeeded, maxCuts);
			number += cutActual;
			maxCuts -= cutActual;
			if (cutActual == cutNeeded) {
				number++;
			}
		}
		if (maxCuts > 0) {
			Collections.sort(nonTens);
			for (int i = nonTens.size() - 1; i >= 0; i--) {
				int cutTotal = nonTens.get(i) / 10;
				int cutActual = Math.min(cutTotal, maxCuts);
				number += cutActual;
				maxCuts -= cutActual;
				if (maxCuts == 0) {
					break;
				}
			}
		}
		return number;
	}
}
