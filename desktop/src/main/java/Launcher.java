import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.service.LogService;
import hamlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String... args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
		UserService userService = applicationContext.getBean(UserService.class);
		LogService logService = applicationContext.getBean(LogService.class);

		User user = createUser();
		userService.add(user);

		logService.addLogToUser(createLogBook("First logbook"), user);
		logService.addLogToUser(createLogBook("Second logbook"), user);
		logService.addLogToUser(createLogBook("Third logbook"), user);

		for (User owner : userService.getAllUsers()) {
			System.out.println(owner);
            for (LogBook logBook : logService.getUserLogs(owner)) {
                System.out.println(logBook);
            }
		}

        userService.delete(user);
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
