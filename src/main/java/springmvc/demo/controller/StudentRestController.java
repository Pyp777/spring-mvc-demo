package springmvc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.demo.model.Student;

@Controller
public class StudentRestController {
	// without response body its not working
	@ResponseBody
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getStudentsList() {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Kaja", "Piloun", "123465", 25, null));
		list.add(new Student("Paja", "Pilouna", "123465", 25, null));
		list.add(new Student("Vaja", "Pilounen", "123465", 25, null));
		
		return list;
	}
	

}
