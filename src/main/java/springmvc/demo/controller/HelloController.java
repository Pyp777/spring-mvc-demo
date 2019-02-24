package springmvc.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/greet")
public class HelloController {

	// Done by ModelAndView or Model as param	
	@RequestMapping("/mv1")
	public ModelAndView indexMV1() {
		ModelAndView model =new ModelAndView("index");
		model.addObject("app", "tralala");
		return model;
	}
	
	// mapping params
	@RequestMapping("/mv2")
	public ModelAndView indexMV2(@RequestParam Map<String, String> params) {
		
		String name = params.get("name");
		
		ModelAndView model =new ModelAndView("index");
		model.addObject("app", "tralala");
		return model;
	}

	/**
	 * Done by ModelAndView or Model as param
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/{user}")
	public String index(@PathVariable String user, Model model) {
		model.addAttribute("app", user);
		return "index";
	}

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

}