package das.soumyadipd.system.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import das.soumyadipd.system.login.interfaces.ApplicationLogIn;
import das.soumyadipd.system.login.interfaces.LoginHelper;

public class LogInUsingContext implements ApplicationLogIn {

	private static final Logger LOG = Logger.getLogger(LogInUsingContext.class);

	private ApplicationContext loginContext = null;

	private static LogInUsingContext instance = null;

	private LogInUsingContext() {
		loadLoginContext();
	}

	public static LogInUsingContext getInstance() {
		if (instance == null) {
			instance = new LogInUsingContext();
		}
		return instance;
	}

	private void loadLoginContext() {
		if (loginContext == null) {
			loginContext = new ClassPathXmlApplicationContext("login-context.xml");
			LOG.debug("Login context loaded successfully");
		}
	}

	@Override
	public boolean isValidCredentials(String userId, String password) {
		if (userId == null || password == null) {
			return false;
		}
		if (StringUtils.equals(password, loginContext.getBean("contextBasedLogInHelper", LoginHelper.class).getPassword(userId))) {
			return true;
		}
		return false;
	}

}
