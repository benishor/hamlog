package hamlog.service.exceptions;

/**
 * Base class for all service generated exceptions.
 *
 * @author Adrian Scripcă
 */
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
