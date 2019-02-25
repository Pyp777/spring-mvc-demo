package springmvc.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	// response status, so it not runs
	//@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler( org.springframework.validation.BindException.class)
	protected String handleException(org.springframework.validation.BindException objException, Model model)
	{
		System.out.println("StudentController.handleException()_______");
		model.addAttribute("message", "Zleeee " + objException.getBindingResult());
		return "student";
	}

}
