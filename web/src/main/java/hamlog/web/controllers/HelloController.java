package hamlog.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @author Adrian Scripca
 */
@Controller
public class HelloController {

	@RequestMapping(value = "/hamlog", method = RequestMethod.GET)
	public String showWelcome(ModelMap model, Principal principal) {

		String username = principal.getName();
		model.addAttribute("message", "Spring Security Custom Form Example");
		model.addAttribute("username", username);

		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}
}
