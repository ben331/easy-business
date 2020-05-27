package customException;

@SuppressWarnings("serial")
public class DoubleRegistrationException extends Exception{
	
	private String repeatedId;
	
	private String list;

	public DoubleRegistrationException(String repeatedId, String list) {
		this.repeatedId=repeatedId;
		this.list = list;
	}
	
	@Override
	public String getMessage() {
		return "Person with id: " + repeatedId + ", is already registered in " + list + " list";
	}

	public String getRepeatedId() {
		return repeatedId;
	}

}
