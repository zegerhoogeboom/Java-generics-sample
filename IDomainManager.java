package domain;

public interface IDomainManager {
	<T extends IEntity> T getEntity(Class<T> type);
}