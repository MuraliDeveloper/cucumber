package calc;

public class Service {

	public int div(int a, int b) {
		if (b == 0)
			return 99999;
		return a / b;
	}

	public boolean checkCity(String city) {
		if (!isValidCity(city)) {
			return false;
		}
		return true;
	}

	private boolean isValidCity(String city) {
		return ("bangalore".equalsIgnoreCase(city) || "hyderabad".equalsIgnoreCase(city)
				|| "chennai".equalsIgnoreCase(city));
	}

	public boolean processRegistration(Person person) throws ServiceException {
		if (person.getAge() < 18) {
			throw new ServiceException("Age should be > 18");
		}
		
		String city = person.getCity();
		if (!isValidCity(city)) {
			throw new ServiceException("Invalid city");
		}

		return true;
	}
}
