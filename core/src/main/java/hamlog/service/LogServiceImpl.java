package hamlog.service;

import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.repository.LogBookRepository;
import hamlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Transactional
	public LogBook addLogToUser(LogBook logBook, User user) {
		if (logBook == null) {
			throw new IllegalArgumentException("Logbook cannot be null");
		}

		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}

		logBook.setOwner(user);
		logBookRepository.save(logBook);

		return logBook;
	}

	@Override
	public List<LogBook> getUserLogs(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		return logBookRepository.findByOwnerOrderByNameAsc(user);
	}
}
