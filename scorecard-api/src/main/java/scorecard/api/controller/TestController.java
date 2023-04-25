package scorecard.api.controller;

import com.google.gson.Gson;
import scorecard.api.model.TestCase;
import scorecard.api.model.TestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController
{
	static Long testId = Long.valueOf(0);

	public static Long nextTestId()
	{
		return ++testId;
	}

	private Gson gson = new Gson();

	Map<Long, TestCase> testCases = new HashMap<>(){{

		TestCase testCase =TestCase.create("sample test case");
		put(testCase.getId(), testCase);
	}};

	Map<TestCase, TestResult> testResults = new HashMap<>();

	@GetMapping("/testcases")
	public ResponseEntity<Map<Long, TestCase>> listTestCases()
	{
		return ResponseEntity.ok(testCases);
	}

	@GetMapping(value = "/testcases/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCase> getTest(@PathVariable(value="id") String testId)
	{
		TestCase testCase = testCases.get(Long.valueOf(testId));

		if (testCase == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(testCase);
	}

	@PostMapping(value = "/testcases", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCase> postTest(HttpServletRequest request, @RequestBody TestCase testCase) throws URISyntaxException
	{
		testCase.setId(nextTestId());
		testCases.put(testCase.getId(), testCase);
		URI testCaseURI = new URI(request.getRequestURI() + "/" + testCase.getId());
		return ResponseEntity.created(testCaseURI).build();
	}

	@PutMapping(value = "/testcases/{id}")
	public ResponseEntity<Map<TestCase, TestResult>> getTestResult(@RequestBody TestCase testCase, boolean passed)
	{
		if (testCases.get(testCase.getId()) == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		testCases.put(testCase.getId(), testCase);

		return ResponseEntity.ok(testResults);
	}
}
