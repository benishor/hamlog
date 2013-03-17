package hamlog.web.listeners;

/**
 * @author Adrian Scripca
 */

import hamlog.domain.Band;
import hamlog.domain.LogBook;
import hamlog.domain.LogEntry;
import hamlog.domain.Mode;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.dto.UserDto;
import hamlog.mappers.DtoConverter;
import hamlog.repository.LogEntryRepository;
import hamlog.service.LogService;
import hamlog.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class ApplicationBootstrapListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	public ApplicationBootstrapListener() {
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

	public void contextInitialized(ServletContextEvent sce) {
//		final WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//		UserService userService = applicationContext.getBean(UserService.class);
//		LogService logService = applicationContext.getBean(LogService.class);
//		LogEntryRepository logEntryRepository = applicationContext.getBean(LogEntryRepository.class);
//
//		UserDto userDto = createUserDto();
//		User user = userService.create(userDto);
//
//		LogBook log = logService.createLogBookForUser(createLogBookDto("First logbook"), user.getId());
//		for (int i = 0; i < 11; i++) {
//			LogEntry entry = new LogEntry();
//			entry.setCallsign("YO8SS");
//			entry.setStartDate(new Date());
//			entry.setBand(Band.HF_40M);
//			entry.setMyMode(Mode.CW);
//			entry.setHisMode(Mode.CW);
//			entry.setRstReceived("599");
//			entry.setRstSent("599");
//			entry.setLogBook(log);
//
//			logService.addEntryToLogBook(entry, log.getId());
//		}
//
//		final PageRequest pageRequest = new PageRequest(0, 2, new Sort(Sort.Direction.ASC, "startDate"));
//		Page<LogEntry> entryPage = logEntryRepository.findLogEntriesForLogBook(log.getId(), pageRequest);
//		for (LogEntry entry : entryPage.getContent()) {
//			System.out.println(entry);
//		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	  /* This method is invoked when the Servlet Context
		 (the Web application) is undeployed or
         Application Server shuts down.
      */
	}

	// -------------------------------------------------------
	// HttpSessionAttributeListener implementation
	// -------------------------------------------------------

	// -------------------------------------------------------
	// HttpSessionListener implementation
	// -------------------------------------------------------
	public void sessionCreated(HttpSessionEvent se) {
	  /* Session is created. */
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	  /* Session is destroyed. */
	}

	public void attributeAdded(HttpSessionBindingEvent sbe) {
	}

	public void attributeRemoved(HttpSessionBindingEvent sbe) {

	}

	public void attributeReplaced(HttpSessionBindingEvent sbe) {
	}
}
