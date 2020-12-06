package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestValidatePerson {

	Service service = new Service();
	Person p ;
	
	@Before
	public void setup(){
		p = new Person("user1", 19, "hyderabad", "admin", null,null);
	}
	
	@Test
	public void testValid() throws ServiceException { 
		boolean res = service.processRegistration(p);
		Assert.assertEquals("expected succeesul validation",true, res);
		Assert.assertTrue("expected succeesul validation", res);
	}
	
	@Test(expected= ServiceException.class,timeout=1000)
	public void testInvValidAge() throws ServiceException { 
		p.setAge(15);
		service.processRegistration(p);
	}
	
	@Test(expected= ServiceException.class)
	public void testInValidACity() throws ServiceException { 
		p.setCity("xyz");;
		service.processRegistration(p);
	}
	
	@Test(expected= ServiceException.class)
	public void testInValidCityNull() throws ServiceException { 
		p.setCity(null);;
		service.processRegistration(p);
	}

}
