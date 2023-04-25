package scorecard.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController
{
	@RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorObject> handleError(HttpServletRequest request)
	{
		int statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		HttpStatus status = HttpStatus.valueOf(statusCode);

		Object type = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
		String exceptionType = String.valueOf(type);

		String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

		ErrorObject error = new ErrorObject() {{ status=status; type=type; message=message; }};
		return new ResponseEntity<ErrorObject>(error, status);
	}

	class ErrorObject
	{
		public HttpStatus status;
		public String type;
		public String message;
	}
}
