package das.soumyadipd.system.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import das.soumyadipd.beans.User;
import das.soumyadipd.system.login.helper.ContextBasedLogInHelper;
import das.soumyadipd.system.login.interfaces.ApplicationLogIn;

public class LogInUsingContext implements ApplicationLogIn {

	private static final Logger LOG = Logger.getLogger(LogInUsingContext.class);

	private ApplicationContext loginContext = null;

	private static LogInUsingContext instance = null;

	private ContextBasedLogInHelper helper = new ContextBasedLogInHelper();

	private LogInUsingContext() {
		loadLoginContext();
		loadUsers();
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

	private void loadUsers() {
		int count = 1;
		while (count > 0) {
			String beanId = "user" + count;
			try {
				helper.addUser((User) loginContext.getBean(beanId));
				count++;
			} catch (Exception e) {
				break;
			}
		}
		LOG.debug("User Data loaded successfully");
	}

	@Override
	public boolean isValidCredentials(String userId, String password) {
		if (userId == null || password == null) {
			return false;
		}
		if (StringUtils.equals(password, helper.getPassword(userId))) {
			return true;
		}
		return false;
	}

}
