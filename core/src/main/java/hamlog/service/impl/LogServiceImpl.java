package hamlog.service.impl;

import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.repository.LogBookRepository;
import hamlog.repository.UserRepository;
import hamlog.service.LogService;
import hamlog.service.exceptions.DuplicateLogBookException;
import hamlog.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
@Service
@Transactional(readOnly = true)
public class LogServiceImpl implements LogService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LogBookRepository logBookRepository;

	@Override
	public LogBook createLogBookForUser(LogBookDto logBookDto, Long userId) throws UserNotFoundException, DuplicateLogBookException {
		User user = userRepository.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			try {
				LogBook logBook = new LogBook();
				logBook.setName(logBookDto.getName());
				logBook.setOwner(user);
				logBookRepository.save(logBook);
				return logBook;
			} catch (DataIntegrityViolationException e) {
				throw new DuplicateLogBookException(e);
			}
		}
	}

	@Override
	public List<LogBook> getLogBooksForUser(Long userId) {
		return logBookRepository.findLogbooksForUser(userId);
	}
}
