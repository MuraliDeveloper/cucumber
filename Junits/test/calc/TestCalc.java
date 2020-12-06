package calc;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalc {

	Service c = new Service();
	
	@Before
	public void setup(){
		
	}
	
	@After
	public void after(){
		
	}
	
	@BeforeClass
	public static void onetim(){
		
	}
	
	@AfterClass
	public static void afterOneTim(){
		
	}
	
	@Test
	public void testValid() {
		int res = c.div(20, 10);
		Assert.assertEquals("Invalid division result", 2, res);
	}
	
	@Test
	public void testInValid() {
		int res = c.div(10, 0);
		
		Assert.assertEquals("Invalid division result", 99999, res);
	
	}
	
	@Test
	public void testInValidCity() {
		boolean check = c.checkCity("xyz");
		Assert.assertFalse("expectinm false.",check);
	}
	@Test
	public void testbangalore() {
		boolean check = c.checkCity("bangalore");
		Assert.assertTrue("expecting true.",check);
	}
	@Test
	public void testhyderabad() {
		boolean check = c.checkCity("hyderabad");
		Assert.assertTrue("expecting true.",check);
	}
	@Test
	public void testChennai() {
		boolean check = c.checkCity("chennai");
		Assert.assertTrue("expecting true.",check);
	}
	
	@Test
	public void testNull() {
		boolean check = c.checkCity(null);
		Assert.assertFalse("expecting false.",check);
	}
	
	@Test
	public void testblank() {
		boolean check = c.checkCity("");
		Assert.assertFalse("expecting false.",check);
	}
}