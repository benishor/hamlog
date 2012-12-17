import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.service.LogService;
import hamlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Launcher {

	public static void main(String... args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
		UserService userService = applicationContext.getBean(UserService.class);
		LogService logService = applicationContext.getBean(LogService.class);

		User newUser = createUser();
		userService.add(newUser);

		logService.addLogToUser(createLogBook("First logbook"), newUser);
		logService.addLogToUser(createLogBook("Second logbook"), newUser);
		logService.addLogToUser(createLogBook("Third logbook"), newUser);

		for (User user : userService.getAllUsers()) {
			System.out.println(user);
			System.out.println(logService.getUserLogs(user));
		}
	}

	private static LogBook createLogBook(String name) {
		LogBook logBook = new LogBook();
		logBook.setName(name);
		return logBook;
	}

	private static User createUser() {
		User newUser = new User();
		newUser.setCallsign("YO6SSW");
		newUser.setFirstName("Adrian");
		newUser.setLastName("Scripcă");
		newUser.setPassword("parolă");
		return newUser;
	}
}
