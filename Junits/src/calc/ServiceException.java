package calc;

public class ServiceException extends Exception {

	 //private ErrorEnum err;
	 
	private String err;
	
	 public ServiceException(String err) {
		super();
		this.err = err;
	}

	public String getErr() {
		return err;
	}

}
