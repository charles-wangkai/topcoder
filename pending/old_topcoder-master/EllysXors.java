public class EllysXors {
	public long getXor(long L, long R) {
		long result = 0;
		long placeValue = 1;
		while (R >= placeValue) {
			if (countOnes(L, R, placeValue) % 2 != 0) {
				result += placeValue;
			}
			placeValue *= 2;
		}
		return result;
	}

	long countOnes(long lower, long upper, long placeValue) {
		long period = placeValue * 2;
		long periodCount = upper / period - lower / period + 1;
		long oneNum = placeValue * periodCount;

		long offsetLower = lower % period;
		if (offsetLower > placeValue) {
			oneNum -= offsetLower - placeValue;
		}
		long offsetUpper = upper % period;
		oneNum -= Math.min(placeValue, period - 1 - offsetUpper);

		return oneNum;
	}
}
