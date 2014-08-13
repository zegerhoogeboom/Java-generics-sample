package domain.non_implemented_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import domain.DomainManager;
import domain.IDomain;
import domain.IDomainManager;

public class InvocationHandlerImpl implements InvocationHandler {

	final String DOMAIN_PACKAGE = "domain.";
	
	private IDomainManager manager;
	
	public InvocationHandlerImpl(IDomainManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String entityName = "";
		
		if (method.getName().contains("Entity")) {
			entityName = method.getName().replace("get", "").replace("Entity", "");
		} else if (method.getName().contains("Model")) {
			entityName = method.getName().replace("get", "");
		}
		
		Class<IDomain> entity = (Class<IDomain>) Class.forName(DOMAIN_PACKAGE + entityName);
		return manager.getEntity(entity);
	}

	public IDomainManager getManager() {
		return manager;
	}

	public void setManager(IDomainManager manager) {
		this.manager = manager;
	}

}
