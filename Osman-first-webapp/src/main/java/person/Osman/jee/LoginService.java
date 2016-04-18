package person.Osman.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("Osman") && password.equals("password");
	}

}