package hamlog.service.exceptions;

/**
 * @author Adrian Scripcă
 */
public class DuplicateLogBookException extends ServiceException {

	public DuplicateLogBookException() {
	}

	public DuplicateLogBookException(String message) {
		super(message);
	}

	public DuplicateLogBookException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateLogBookException(Throwable cause) {
		super(cause);
	}
}
