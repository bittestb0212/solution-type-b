package problem03;

public class Money {

	private int amount;

	public int getAmount() {
		return this.amount;
	}

	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		return new Money(this.amount + money.getAmount());
	}

	public Money minus(Money money) {
		return new Money(this.amount - money.getAmount());
	}

	public Money multiply(Money money) {
		return new Money(this.amount * money.getAmount());
	}

	public Money devide(Money money) {
		Money result = null;
		try {
			result = new Money(this.amount / money.getAmount());
		} catch (ArithmeticException e) {
			System.out.println("0 나누기 예외 발생");
		}
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		Money compare = (Money) obj;
		if (this.amount == compare.amount) {
			return true;
		} else
			return false;

	}
}