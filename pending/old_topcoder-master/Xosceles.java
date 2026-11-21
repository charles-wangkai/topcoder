public class Xosceles {
	public String[] draw(int xCount) {
		int n = (int) Math.sqrt(xCount);
		if (n * n != xCount && n * (n + 1) != xCount) {
			return new String[0];
		}
		String rows[] = new String[n];
		int spaceNum = n - 1;
		int xNum;
		if (n * n == xCount) {
			xNum = 1;
		} else {
			xNum = 2;
		}
		for (int i = 0; i < rows.length; i++) {
			rows[i] = "";
			rows[i] = append(rows[i], '.', spaceNum);
			rows[i] = append(rows[i], 'X', xNum);
			rows[i] = append(rows[i], '.', spaceNum);
			spaceNum--;
			xNum += 2;
		}
		return rows;
	}

	String append(String str, char ch, int times) {
		String result = str;
		for (int i = 0; i < times; i++) {
			result += ch;
		}
		return result;
	}
}
