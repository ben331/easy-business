package model;

@SuppressWarnings("serial")
public class SaleOfExpiredProductException extends Exception{
	
	private String code;
	
	private int expiredDays;

	public String getCode() {
		return code;
	}

	public int getExpiredDays() {
		return expiredDays;
	}

	public SaleOfExpiredProductException(String code, int expiredDays) {
		this.code = code;
		this.expiredDays = expiredDays;
	}
	
	@Override
	public String getMessage() {
		return "Attemp of sale a expired product. \n\nCode product: "+code+"\nExpired days: "+expiredDays;
	}
}
