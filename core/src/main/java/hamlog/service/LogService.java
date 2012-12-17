package hamlog.service;

import hamlog.domain.LogBook;
import hamlog.domain.User;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
public interface LogService {

	LogBook addLogToUser(LogBook logBook, User user);

	List<LogBook> getUserLogs(User user);
}
