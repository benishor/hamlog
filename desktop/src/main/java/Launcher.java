import hamlog.domain.Band;
import hamlog.domain.LogBook;
import hamlog.domain.LogEntry;
import hamlog.domain.Mode;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.dto.UserDto;
import hamlog.repository.LogEntryRepository;
import hamlog.service.LogService;
import hamlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.criteria.Order;
import java.util.Date;
import java.util.List;

public class Launcher {

	public static void main(String... args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
		UserService userService = applicationContext.getBean(UserService.class);
		LogService logService = applicationContext.getBean(LogService.class);

		LogEntryRepository logEntryRepository = applicationContext.getBean(LogEntryRepository.class);

		UserDto userDto = createUserDto();
		User user = userService.create(userDto);

		LogBook log = logService.createLogBookForUser(createLogBookDto("First logbook"), user.getId());
		for (int i = 0; i < 11; i++) {
			LogEntry entry = new LogEntry();
			entry.setCallsign("YO8SS");
			entry.setStartDate(new Date());
			entry.setBand(Band.HF_40M);
			entry.setMyMode(Mode.CW);
			entry.setHisMode(Mode.CW);
			entry.setRstReceived("599");
			entry.setRstSent("599");
			entry.setLogBook(log);

			logService.addEntryToLogBook(entry, log.getId());
		}

//		List<LogEntry> entries = logEntryRepository.findLogEntriesForLogBook(log.getId());
//		for (LogEntry entry : entries) {
//			System.out.println(entry);
//		}

		final PageRequest pageRequest = new PageRequest(0, 2, new Sort(Sort.Direction.ASC, "startDate"));
		Page<LogEntry> entryPage = logEntryRepository.findLogEntriesForLogBook(log.getId(), pageRequest);
		for (LogEntry entry : entryPage.getContent()) {
			System.out.println(entry);
		}





		userService.delete(user.getId());
	}

	private static LogBookDto createLogBookDto(String name) {
		LogBookDto logBook = new LogBookDto();
		logBook.setName(name);
		return logBook;
	}

	private static UserDto createUserDto() {
		UserDto user = new UserDto();
		user.setCallsign("YO6SSW");
		user.setFirstName("Adrian");
		user.setLastName("Scripcă");
		user.setPassword("parolă");
		return user;
	}
}
