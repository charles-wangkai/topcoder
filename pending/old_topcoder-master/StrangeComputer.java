public class StrangeComputer {
	public int setMemory(String mem) {
		int operationNum = 0;
		char bit = '0';
		for (int i = 0; i < mem.length(); i++) {
			if (mem.charAt(i) != bit) {
				operationNum++;
				bit = (char) ('0' + '1' - bit);
			}
		}
		return operationNum;
	}
}
