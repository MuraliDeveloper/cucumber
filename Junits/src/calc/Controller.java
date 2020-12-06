package calc;

public class Controller {

	Service service;
	
	public Controller(Service service) {
		super();
		this.service = service;
	}
	

	public Controller() {
		super();
	}

	public String process(Person p) throws ServiceException{
		String status ="failure";
		if(!p.getAccess().equals("admin"))
			return "invalid access";
p.setAccess("z");
		boolean regStatus = false;
		try{
			regStatus = service.processRegistration(p);
		}catch(ServiceException exception){
			 regStatus = false;
			 status = exception.getErr();
		}
		
		if(regStatus)
			return "success";
		else 
			return status;
	}

}
