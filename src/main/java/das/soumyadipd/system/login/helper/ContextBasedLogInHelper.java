package das.soumyadipd.system.login.helper;

import java.util.HashMap;
import java.util.Map;

import das.soumyadipd.beans.User;

public class ContextBasedLogInHelper {

	private Map<String, String> userMap = null;

	public ContextBasedLogInHelper() {
		userMap = new HashMap<String, String>();
	}

	public Map<String, String> getUserMap() {
		return userMap;
	}

	public void addUser(User user) {
		userMap.put(user.getUserName(), user.getPassword());
	}

	public String getPassword(String userId) {
		return userMap.get(userId);
	}

}
