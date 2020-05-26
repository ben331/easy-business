package customException;

@SuppressWarnings("serial")
public class SaleOfExpiredProductException extends Exception{
	
	private int code;

	public int getCode() {
		return code;
	}

	public SaleOfExpiredProductException(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return "Attemp of sale a expired product. \n\nCode product: "+code;
	}
}
