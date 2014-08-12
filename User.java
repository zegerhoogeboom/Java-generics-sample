package domain;

public class User extends Entity implements IUser {

	public User(){};
	
	@Override
	public String sayHi() {
		return "Hi!";
	}
}
