package domain;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class DomainManagerTest extends TestCase {
	
	@Rule
	private ExpectedException exception = ExpectedException.none();

	@Test
	public void testGotUserInterface() {
		IDomainManager manager = new DomainManager();
		IUser user = manager.getEntity(User.class);
		assertTrue(user instanceof IUser);
	}
	
	@Test
	public void testUserReturnsCorrectMessage() {
		IDomainManager manager = new DomainManager();
		IUser user = manager.getEntity(User.class);
		assertEquals("Hi!", user.sayHi());
	}
	
	@Test
	public void testGetEntityWithoutDefaultConstructorThrowsException() {
		IDomainManager manager = new DomainManager();
		
		exception.expect(InstantiationException.class);
		Product product = manager.getEntity(Product.class);
		assertTrue(product == null);
	}
}
