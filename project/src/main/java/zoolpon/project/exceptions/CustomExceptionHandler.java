package zoolpon.project.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {

		List<String> validationErrorMessages = new ArrayList<>();

		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		for (ConstraintViolation<?> violation : violations) {
			String message = "Invalid value " + violation.getInvalidValue() + " for " + violation.getPropertyPath()
					+ " : " +

					violation.getMessage();
			validationErrorMessages.add(message);
		}

		return new ResponseEntity<Object>(new WebApiError("Input is invalid", validationErrorMessages),
				HttpStatus.BAD_REQUEST);

	}
	
	

}
