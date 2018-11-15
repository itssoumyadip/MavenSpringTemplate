package das.soumyadipd.system.login;

import das.soumyadipd.system.login.interfaces.ApplicationLogIn;

public class LogInUsingDatabase implements ApplicationLogIn {

	@Override
	public boolean isValidCredentials(String userId, String password) {
		return false;
	}

}
