package domain;

public class DomainManager implements IDomainManager {

	@Override
	public <T extends IDomain> T getEntity(Class<T> type) {
		try {
			return (T) type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}