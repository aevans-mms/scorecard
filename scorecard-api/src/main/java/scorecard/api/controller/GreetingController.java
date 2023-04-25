package scorecard.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController
{
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getGreeting()
	{
		String greeting = "Hi, this is a simple application to manage test cases!";
		return greeting;
	}
}
