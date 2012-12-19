import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.dto.UserDto;
import hamlog.service.LogService;
import hamlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String... args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
		UserService userService = applicationContext.getBean(UserService.class);
		LogService logService = applicationContext.getBean(LogService.class);

		UserDto userDto = createUserDto();
		User user = userService.create(userDto);

		logService.createLogBookForUser(createLogBookDto("First logbook"), user.getId());
		logService.createLogBookForUser(createLogBookDto("Second logbook"), user.getId());
		logService.createLogBookForUser(createLogBookDto("Third logbook"), user.getId());

		for (User owner : userService.findAll()) {
			System.out.println(owner);
			for (LogBook logBook : logService.getLogBooksForUser(owner.getId())) {
				System.out.println(logBook);
			}
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
