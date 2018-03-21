package ch.hslu.ad.sw05.N1.Aufg1;

public class AccountTask implements Runnable {
	private final int amount;
	private final BankAccount from;
	private final BankAccount to;

	public AccountTask(final int amount, final BankAccount from, final BankAccount to) {
		this.amount = amount;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		final int amountToTransfer = 1;
		for (int i = 0; i < (this.amount + 1); i++) {
			this.from.transfer(this.to, amountToTransfer);
		}
	}

}
