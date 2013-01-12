package addressManagement;

import static addressManagement.Address.*;
import static addressManagement.Person.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import addressManagement.Address;
import addressManagement.Person;

public class PersonTest {
	
	/**
	 * Will execute before the start of all tests
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Address adress1 = new Address("MaiStreet", "128735", "NY");
		Person person1 = new Person("benny", "long", adress1);
		fail("Not yet implemented");
	}

	/**
	 * Will execute the method after all test have finished
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		fail("Not yet implemented");
	}

	/**
	 * Will execute the method before each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		fail("Not yet implemented");
	}

	/**
	 * Will execute the method, after each test
	 */
	@After
	public void tearDown() throws Exception {
		fail("Not yet implemented");
	}

	/**
	 * Idetifies the method as a test method
	 */
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * Will ignore the test method
	 */
	@Ignore
	public void ignore(){
		fail("Not yet implemented");
	}
	
	/**
	 * Fails, if the method does not throw the named exception
	 */
	@Test(expected = Exception.class)
	public void exceptionClass(){
		fail("Not yet implemented");
	}
	
	/**
	 * Fails, if the method takes longer than 100milliseconds
	 */
	@Test(timeout=100)
	public void testTimeout(){
		fail("Not yet implemented");
	}
}
