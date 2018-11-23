package das.soumyadipd.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import das.soumyadipd.commandforms.UserLogInCommandForm;
import das.soumyadipd.system.login.LogInUsingContext;
import das.soumyadipd.system.login.interfaces.ApplicationLogIn;

@Controller
@RequestMapping(value = "/web/auth")
public class LogInController {

	private static final Logger LOG = Logger.getLogger(LogInController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		LOG.debug("Log In Page Requested");
		return "login";

	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@Validated UserLogInCommandForm form, Model model) {

		ApplicationLogIn login = LogInUsingContext.getInstance();

		if (!login.isValidCredentials(form.getUserName(), form.getPassword())) {
			LOG.error("Login failed");
			model.addAttribute("errorMessage", "Either invalid User Name or invalid password provided");
			return "loginError";
		}

		model.addAttribute("userName", form.getUserName());

		return "user";

	}
}
