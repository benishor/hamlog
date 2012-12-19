package hamlog.service;

import hamlog.domain.User;
import hamlog.dto.UserDto;
import hamlog.service.exceptions.DuplicateUserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Adrian Scripcă
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/appBootstrap-test.xml")
@Transactional
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testCreateUser() throws Exception {
		User createdUser = userService.create(createUserDto());
		assertThat(createdUser, is(notNullValue()));
		assertThat(createdUser.getId(), is(notNullValue()));
	}

	@Test(expected = DuplicateUserException.class)
	public void testCreateUser_DuplicateUser() throws Exception {
		UserDto userDto = createUserDto();
		userService.create(userDto);
		userService.create(userDto);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateUser_NullArgument() throws Exception {
		userService.create(null);
	}

	private UserDto createUserDto() {
		UserDto userDto = new UserDto();
		userDto.setCallsign("YO6SSW");
		userDto.setPassword("parolica");
		userDto.setFirstName("Adrian");
		userDto.setLastName("Scripcă");
		return userDto;
	}
}
