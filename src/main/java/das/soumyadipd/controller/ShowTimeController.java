package das.soumyadipd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/web/time")
public class ShowTimeController {

	private static final Logger LOG = Logger.getLogger(ShowTimeController.class);
	
	@RequestMapping(value = "/showTime", method = RequestMethod.GET)
	public String showTime(Locale locale, Model model) {
		
		LOG.debug("Show time Page Requested, locale = " + locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "showTime";
		
	}
}
