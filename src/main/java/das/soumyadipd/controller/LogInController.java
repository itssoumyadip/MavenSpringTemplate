package das.soumyadipd.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import das.soumyadipd.beans.User;

@Controller
public class LogInController {

	private static final Logger LOG = Logger.getLogger(LogInController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		LOG.debug("Log In Page Requested");
		return "login";

	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@Validated User user, Model model) {
		
		if(!(StringUtils.equals(user.getUserName(), "soumyadip") || StringUtils.equals(user.getUserName(), "aparajita"))){
			LOG.error("Invalid user name provided");
			model.addAttribute("errorMessage", " Invalid User Name provided");
			return "loginError";
		}
		
		if(StringUtils.equals(user.getUserName(), "soumyadip")){
			if(!StringUtils.equals(user.getPassword(), "test1")){
				LOG.error("Invalid Password provided for the user: " + user.getUserName());
				model.addAttribute("errorMessage", "Invalid Password provided for the user: " + user.getUserName());
				return "loginError";
			}
		}
		
		if(StringUtils.equals(user.getUserName(), "aparajita")){
			if(!StringUtils.equals(user.getPassword(), "test2")){
				LOG.error("Invalid Password provided for the user: " + user.getUserName());
				model.addAttribute("errorMessage", "Invalid Password provided for the user: " + user.getUserName());
				return "loginError";
			}
		}
		
		model.addAttribute("userName", user.getUserName());
		
		return "user";
		
	}
}
