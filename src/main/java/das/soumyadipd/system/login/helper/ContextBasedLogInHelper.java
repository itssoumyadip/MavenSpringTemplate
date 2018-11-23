package das.soumyadipd.system.login.helper;

import java.util.Map;

import das.soumyadipd.system.login.interfaces.LoginHelper;

public class ContextBasedLogInHelper implements LoginHelper{

	private Map<String, String> userMap;

	public void setUserMap(Map<String, String> userMap) {
		this.userMap = userMap;
	}

	@Override
	public String getPassword(String userId) {
		return userMap.get(userId);
	}

}
