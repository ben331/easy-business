package customException;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception{
	
	public static final double MIN_VALUE_CASH = 50000;
	private double attempedSpending;
	private double cash;
	
	public InsufficientBalanceException(double attempedSpending, double cash) {
		this.attempedSpending = attempedSpending; 
		this.cash = cash;
	}

	public double getAttempedSpending() {
		return attempedSpending;
	}
	
	@Override
	public String getMessage() {
		return "Attempt of spend "+ attempedSpending + ". When the cash is "+ cash
				+".\n\n Remember cash can not be less than "+ MIN_VALUE_CASH;
	}

	public double getCash() {
		return cash;
	}
}
