package domain;

public interface IDomainManager {
	public abstract <T extends IEntity> T getEntity(Class<T> type);
}