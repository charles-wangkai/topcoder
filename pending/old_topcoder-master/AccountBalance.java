public class AccountBalance {
	public int processTransactions(int startingBalance, String[] transactions) {
		int balance = startingBalance;
		for (String transaction : transactions) {
			String fields[] = transaction.split(" ");
			int amount = Integer.parseInt(fields[1]);
			if (fields[0].equals("C")) {
				balance += amount;
			} else {
				balance -= amount;
			}
		}
		return balance;
	}
}
