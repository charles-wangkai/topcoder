public class ThirtyOne {
	public int findWinner(String[] hands) {
		int winner = -1;
		int maxPointMultiply10 = -1;
		for (int i = 0; i < hands.length; i++) {
			String fields[] = hands[i].split(" ");
			int pointMultiply10;
			if (fields[0].equals(fields[1]) && fields[1].equals(fields[2])) {
				pointMultiply10 = 305;
			} else {
				int countA = 0;
				pointMultiply10 = 0;
				for (String field : fields) {
					char card = field.charAt(0);
					if (card == 'A') {
						countA++;
						pointMultiply10++;
					} else if (field.equals("10") || card == 'J' || card == 'Q'
							|| card == 'K') {
						pointMultiply10 += 10;
					} else {
						pointMultiply10 += card - '0';
					}
				}
				while (pointMultiply10 <= 21 && countA > 0) {
					pointMultiply10 += 10;
					countA--;
				}
				pointMultiply10 *= 10;
			}
			if (pointMultiply10 > maxPointMultiply10) {
				maxPointMultiply10 = pointMultiply10;
				winner = i;
			}
		}
		return winner;
	}
}
