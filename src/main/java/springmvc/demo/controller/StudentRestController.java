package springmvc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import springmvc.demo.model.Student;

/**
 * restcontroller does not need responsebody attribute
 * controller ... needs
 * there is added jackson xml format library - outputs are depended on header accept type
 * json/xml
 * produces - output format, consumes - input format
 * @author pavel
 *
 */
//@Controller
@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE) //MediaType.APPLICATION_XML_VALUE
public class StudentRestController {
	
	/**
	 * mediatype xml or json determine output format
	 * @return
	 */
	// response body means result for page
	//@ResponseBody
	//@RequestMapping(value="/students", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) //MediaType.APPLICATION_XML_VALUE
	@RequestMapping(value="/students", method=RequestMethod.GET) //MediaType.APPLICATION_XML_VALUE
	public List<Student> getStudentsList() {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Kaja", "Piloun", "123465", 25, null));
		list.add(new Student("Paja", "Pilouna", "123465", 25, null));
		list.add(new Student("Vaja", "Pilounen", "123465", 25, null));
		
		return list;
	}

	// hasnt responsebody, must have at least response code
	@ResponseStatus(code=HttpStatus.OK)
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void update() {
		System.out.println("StudentRestController.Update()_________");
	}
	
	@RequestMapping(value="/set", method=RequestMethod.GET)
	public ResponseEntity<Void> set() {
		System.out.println("StudentRestController.set()_________");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
