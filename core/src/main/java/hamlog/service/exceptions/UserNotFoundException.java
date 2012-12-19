package hamlog.service.exceptions;

import hamlog.service.exceptions.ServiceException;

/**
 * @author Adrian Scripcă
 */
public class UserNotFoundException extends ServiceException {

	public UserNotFoundException() {
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
}
