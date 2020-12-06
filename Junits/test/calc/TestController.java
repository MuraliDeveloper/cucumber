package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations.Mock;

public class TestController {
	
	static Controller  controller;
	static Service service;
	
	
	
	@BeforeClass
	public static void oneTime(){
		service =Mockito.mock(Service.class);
		controller = new Controller(service);
	}
	
	
	Person p ;
	@Before
	public void setup(){
		p = new Person("user1", 19, "hyderabad", "admin", null,null);
		p.setAccess("admin");
	}
	
	@Test
	public void testProcess() throws ServiceException {
		
		Mockito.when(service.processRegistration(Mockito.eq(p))).thenReturn(true);
		
		String result = controller.process(p);
		
		Assert.assertEquals("expected success","success", result);
		Mockito.verify(service, Mockito.times(1)).processRegistration(Mockito.eq(p));
	}
	
	@Test
	public void testProcessFail() throws ServiceException {
		Mockito.when(service.processRegistration(Mockito.eq(p))).thenReturn(false);
		
		String result = controller.process(p);
		
		Assert.assertEquals("expected  failure","failure", result);
		Mockito.verify(service, Mockito.times(1)).processRegistration(Mockito.eq(p));
	}
	
	@Test
	public void testProcessException() throws ServiceException {
		Mockito.when(service.processRegistration(Mockito.eq(p)))
		.thenThrow(new ServiceException("invalid age"));
		
		String result = controller.process(p);
		
		Assert.assertEquals("expected  failure","invalid age", result);
		Mockito.verify(service, Mockito.times(1)).processRegistration(Mockito.eq(p));
	}
	
	@Test
	public void testProcessAccessFail() throws ServiceException {
		p.setAccess("test");
		String result = controller.process(p);
		Assert.assertEquals("expected  failure","invalid access", result);
		Mockito.verify(service, Mockito.times(0)).processRegistration(Mockito.eq(p));
	}
}
