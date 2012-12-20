package hamlog.service;

import hamlog.domain.LogBook;
import hamlog.domain.LogEntry;
import hamlog.dto.LogBookDto;
import hamlog.service.exceptions.DuplicateLogBookException;
import hamlog.service.exceptions.LogBookNotFoundException;
import hamlog.service.exceptions.UserNotFoundException;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
public interface LogService {

	/**
	 * Creates a logbook with the provided data and attaches it to the user with the provided id. After creation, the logbook is returned to the caller.
	 *
	 * @param logBookDto the logbook details
	 * @param userId     the id of the user who will own the newly created logbook
	 * @return the newly created logbook
	 * @throws UserNotFoundException     if the user with the provided id cannot be found
	 * @throws DuplicateLogBookException if a logbook duplicate is detected for the same user
	 */
	LogBook createLogBookForUser(LogBookDto logBookDto, Long userId) throws UserNotFoundException, DuplicateLogBookException;

	/**
	 * Retrieves a list of all logbooks owned by the user with the provided id. If no matches are found, an empty list is returned.
	 *
	 * @param userId the id of the user whose logbooks are to be returned.
	 * @return a list containing all logbooks owned by the provided user, or an empty list if no matches exist.
	 */
	List<LogBook> getLogBooksForUser(Long userId);

	/**
	 * Adds the current entry to the logbook with given id.
	 *
	 * @param logEntry  the QSO to be logged
	 * @param logBookId the id of the logbook this entry should be added to
	 * @return the updated QSO
	 * @throws LogBookNotFoundException if the logbook with the given id could not be found
	 */
	LogEntry addEntryToLogBook(LogEntry logEntry, Long logBookId) throws LogBookNotFoundException;
}
