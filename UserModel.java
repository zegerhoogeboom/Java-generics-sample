package domain;

public class UserModel implements IUserModel {

	@Override
	public IUser getCurrentlyLoggedInUser() {
		return new User();
	}
}
