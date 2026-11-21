public class ContiguousCacheEasy {
	public int bytesRead(int n, int k, int[] addresses) {
		int base = 0;
		int read = 0;
		for (int address : addresses) {
			if (address < base) {
				read += Math.min(base - address, k);
				base = address;
			} else if (address > base + k - 1) {
				read += Math.min(address - k + 1 - base, k);
				base = address - k + 1;
			}
		}
		return read;
	}
}
