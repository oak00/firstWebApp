package person.Osman.login;

import org.springframework.stereotype.Service;


// Dependency injection
@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
	}

}