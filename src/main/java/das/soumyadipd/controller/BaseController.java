package das.soumyadipd.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/web")
public class BaseController {

	private static final Logger LOG = Logger.getLogger(BaseController.class);

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String index(Model model) {

		LOG.debug("Index Page Requested");
		return "index";

	}

}
