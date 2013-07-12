package hamlog.web.controllers;

import hamlog.domain.Band;
import hamlog.domain.Mode;
import hamlog.web.forms.AddQsoForm;
import hamlog.web.forms.DatePropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

/**
 * @author Adrian Scripcă
 */
@Controller
@RequestMapping(value = "/addqso")
public class QsoController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DatePropertyEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAddQsoForm(ModelMap model, Principal principal) {
		AddQsoForm form = new AddQsoForm(); // set defaults if necessary
		model.put("addQsoForm", form);
		model.put("modeList", Mode.values());
		model.put("bandList", Band.values());
		return "addqso";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processAddQso(@Valid AddQsoForm addQsoForm, BindingResult result, ModelMap model, Principal principal) {
		if (result.hasErrors()) {
			model.put("modeList", Mode.values());
			model.put("bandList", Band.values());
			return "addqso";
		}

		model.put("addQsoForm", addQsoForm);
		return "addqsosuccess";
	}
}
