package springmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * https://youtu.be/1jV338r0MDI
 * @author pavel
 *
 */
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}