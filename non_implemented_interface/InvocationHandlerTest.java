package domain.non_implemented_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import junit.framework.TestCase;

import org.junit.Test;

import domain.DomainManager;
import domain.IUser;
import domain.IUserModel;

public class InvocationHandlerTest extends TestCase {
	InvocationHandler handler;
	
	NonImplementedInterface proxy;
	
	protected void setUp() throws Exception {
		handler = new InvocationHandlerImpl(new DomainManager());
		proxy = (NonImplementedInterface) Proxy.newProxyInstance(
	            NonImplementedInterface.class.getClassLoader(),
	            new Class[] { NonImplementedInterface.class },
	            handler);
	};
	
	@Test
	public void testGetUserShouldReturnIUserInterface() {
		IUser user = proxy.getUserEntity();
		assertTrue(user instanceof IUser);
	}
	
	@Test
	public void testUserMethodsShouldBeCallable() {
		IUser user = proxy.getUserEntity();
		String hi = user.sayHi();
		assertEquals("Hi!", hi);
	}
	@Test
	public void testGetUserModelShouldReturnIUserModel() {
		IUserModel userModel = proxy.getUserModel();
		assertTrue(userModel instanceof IUserModel);
	}
	
	@Test
	public void testUserModelMethodsShouldBeCallable() {
		IUserModel userModel = proxy.getUserModel();
		IUser user = userModel.getCurrentlyLoggedInUser();
		assertEquals("Hi!", user.sayHi());
	}
}
