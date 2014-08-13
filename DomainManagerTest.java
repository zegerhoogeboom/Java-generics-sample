package domain;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import domain.non_implemented_interface.NonImplementedInterface;

public class DomainManagerTest extends TestCase {
	
	@Rule
	private ExpectedException exception = ExpectedException.none();

	private IDomainManager manager;
	
	private NonImplementedInterface nonImpl;
	
	protected void setUp() throws Exception {
		manager = new DomainManager();
	}
	
	@Test
	public void testGotUserInterface() {
		IUser user = manager.getEntity(User.class);
		assertTrue(user instanceof IUser);
	}
	
	@Test
	public void testUserReturnsCorrectMessage() {
		IUser user = manager.getEntity(User.class);
		assertEquals("Hi!", user.sayHi());
	}
	
//	@Test
//	public void testGetEntityWithoutDefaultConstructorThrowsException() {
//		exception.expect(InstantiationException.class);
//		Product product = manager.getEntity(Product.class);
//		assertTrue(product == null);
//	}
}
