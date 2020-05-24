package customException;

@SuppressWarnings("serial")
public class BuyerWithDebtException extends Exception{
	
	private String buyerName;
	private double debt;
	
	public BuyerWithDebtException(String buyerName, double debt) {
		this.debt = debt;
		this.buyerName = buyerName;
	}

	public double getDebt() {
		return debt;
	}
	
	public String getMessage() {
		return buyerName + "can not buy because has a debt of: " + debt;
	}
}
