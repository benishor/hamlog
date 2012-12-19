package hamlog.service.exceptions;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author Adrian Scripcă
 */
public class DuplicateUserException extends ServiceException {

	public DuplicateUserException() {
	}

	public DuplicateUserException(String message) {
		super(message);
	}

	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserException(Throwable cause) {
		super(cause);
	}
}

