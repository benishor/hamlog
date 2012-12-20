package hamlog.service.impl;

import hamlog.domain.LogBook;
import hamlog.domain.LogEntry;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.mappers.DtoConverter;
import hamlog.repository.LogBookRepository;
import hamlog.repository.LogEntryRepository;
import hamlog.repository.UserRepository;
import hamlog.service.LogService;
import hamlog.service.exceptions.DuplicateLogBookException;
import hamlog.service.exceptions.LogBookNotFoundException;
import hamlog.service.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
@Service
@Transactional(readOnly = true)
public class LogServiceImpl implements LogService {

	private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LogBookRepository logBookRepository;
	@Autowired
	private LogEntryRepository logEntryRepository;

	@Override
	public LogBook createLogBookForUser(LogBookDto logBookDto, Long userId) throws UserNotFoundException, DuplicateLogBookException {
		logger.info("Creating logbook with details {} for user with id {}", logBookDto, userId);

		User user = userRepository.findOne(userId);
		if (user == null) {
			logger.info("User with id {} not found", userId);
			throw new UserNotFoundException();
		} else {
			try {
				LogBook logBook = DtoConverter.convert(logBookDto);
				logBook.setOwner(user);
				logBookRepository.save(logBook);
				logger.info("Logbook created with id {}", logBook.getId());
				return logBook;
			} catch (DataIntegrityViolationException e) {
				logger.warn("Failed to create logbook. Reason: {}", e.getMessage());
				throw new DuplicateLogBookException(e);
			}
		}
	}

	@Override
	public List<LogBook> getLogBooksForUser(Long userId) {
		return logBookRepository.findLogbooksForUser(userId);
	}

	@Override
	public LogEntry addEntryToLogBook(LogEntry logEntry, Long logBookId) throws LogBookNotFoundException {
		if (logEntry == null) {
			throw new IllegalArgumentException("Provided logEntry cannot be null");
		}
		if (logBookId == null) {
			throw new IllegalArgumentException("Provided logBookId cannot be null");
		}

		LogBook logBook = logBookRepository.findOne(logBookId);
		if (logBook != null) {
			logEntry.setLogBook(logBook);
			logEntryRepository.save(logEntry);
			return logEntry;
		} else {
			throw new LogBookNotFoundException("LogBook with id " + logBookId + " could not be found");
		}
	}
}
