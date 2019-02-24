package springmvc.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc.demo.model.Student;

@Controller
//@RequestMapping("/student")
public class StudentController {
	
	/**
	 * remove field from binding
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("mobile");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		
		//binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
		
	}
	
	
	@ModelAttribute
	public void addCommon(Model model) {
		System.out.println("______StudentController.addCommon()");
		
		model.addAttribute("allmessage", "tralala lalal");
	}

	/**
	 * Done by ModelAndView or Model as param
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/student")
	public String index(@ModelAttribute Student student, Model model) {
		Student student1 = new Student();
		student1.setName("Karel");
		student1.setHobby("Nic");
		student1.setPhone("NA");
		
		model.addAttribute("message", "...");
		model.addAttribute("student1", student1);
		
		return "student";
	}

	/**
	 * post form params as ... parmas
	 * @param name
	 * @param hobby
	 * @param phone
	 * @param model
	 * @return
	 */
	@PostMapping("/student/save")
	public String save(@RequestParam("name") String name, @RequestParam("hobby") String hobby,
			@RequestParam("hobby") String phone, Model model) {
		Student student1 = new Student();
		student1.setName(name);
		student1.setHobby(hobby);
		student1.setPhone(phone);

		model.addAttribute("message", "Success " + student1);
		model.addAttribute("student1", student1);

		return "student";
	}

	/**
	 * post form params as class Student 
	 * @param student
	 * @param model
	 * @return
	 */
	@PostMapping("/student/saveClass")
	public String saveClass(@Valid @ModelAttribute Student student, Model model, BindingResult result) {
		System.out.println("____StudentController.index() " + result);
		
		if (result.hasErrors()) {
			return "student";
		} else 
			model.addAttribute("message", "Success save class " + student);
		
		model.addAttribute("student1", student);

		return "student";
	}
	
	@ExceptionHandler( org.springframework.validation.BindException.class)
	protected String handleException(org.springframework.validation.BindException objException, Model model)
	{
		System.out.println("StudentController.handleException()_______");
		model.addAttribute("message", "Zleeee " + objException.getBindingResult());
		return "student";
	}
	
}