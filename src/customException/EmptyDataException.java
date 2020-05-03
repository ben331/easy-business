package customException;

@SuppressWarnings("serial")
public class EmptyDataException extends Exception {
	
	private String emptyFields;

	public EmptyDataException(String emptyFields) {
		super();
		this.emptyFields = emptyFields;
	}
	
	public String getEmptyFields() {
		return emptyFields;
	}
	
	@Override
	public String getMessage() {
		return "There are empty fields: "+emptyFields;
	}
}
