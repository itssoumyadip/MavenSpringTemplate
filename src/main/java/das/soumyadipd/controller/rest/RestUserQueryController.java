package das.soumyadipd.controller.rest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import das.soumyadipd.beans.User;

@RestController
@RequestMapping(value = "/api/query")
public class RestUserQueryController {
	
	private static final Logger LOG = Logger.getLogger(RestUserQueryController.class);

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUserDetails(@PathVariable("id") String id){
		
		User user = new User();
		
		user.setUserName(id);
		user.setMessage("Hello!! " + id + ", welcome to MavenSpringTemplate api");
		
		LOG.debug("Returning user details");
		
		return user;
		
	}
	
}
