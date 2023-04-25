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
		String greeting = "Hi, this is the Scorecard REST API!";

		greeting += """
			<br>
			<a href="scorecard.html">Scorecard</a>
			<br>
			<a href="testcases.html">Testcases</a>
				""";
		return greeting;
	}
}
