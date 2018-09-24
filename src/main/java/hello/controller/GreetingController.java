package hello.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(HttpServletRequest request,
			@RequestParam(value = "name", defaultValue = "World") String name) {
		Principal principal = request.getUserPrincipal();
		if (principal != null)
			name = principal.getName();
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
