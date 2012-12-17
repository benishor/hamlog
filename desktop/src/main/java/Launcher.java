import hamlog.domain.User;
import hamlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Launcher {

	public static void main(String... args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
		UserService userService = applicationContext.getBean(UserService.class);

		User newUser = createUser();
		userService.add(newUser);
		System.out.println(newUser);

		List<User> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
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
