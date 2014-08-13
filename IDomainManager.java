package domain;

public interface IDomainManager {
	<T extends IDomain> T getEntity(Class<T> type);
}