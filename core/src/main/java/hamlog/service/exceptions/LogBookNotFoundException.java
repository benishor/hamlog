package hamlog.service.exceptions;

/**
 * Used to indicate that a LogBook could not be found for the given data.
 *
 * @author Adrian Scripcă
 */
public class LogBookNotFoundException extends ServiceException {

	public LogBookNotFoundException() {
	}

	public LogBookNotFoundException(String message) {
		super(message);
	}

	public LogBookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogBookNotFoundException(Throwable cause) {
		super(cause);
	}
}
