public class BitwiseEquations {
	public long kthPlusOrSolution(int x, int k) {
		String binaryX = Integer.toBinaryString(x);
		String binaryK = Integer.toBinaryString(k);
		String binaryY = "";
		while (!binaryK.equals("")) {
			if (binaryX.endsWith("1")) {
				binaryY = "0" + binaryY;
			} else {
				binaryY = binaryK.charAt(binaryK.length() - 1) + binaryY;
				binaryK = binaryK.substring(0, binaryK.length() - 1);
			}
			if (!binaryX.equals("")) {
				binaryX = binaryX.substring(0, binaryX.length() - 1);
			}
		}
		return Long.parseLong(binaryY, 2);
	}
}
