package hamlog.service;

import hamlog.domain.User;
import hamlog.dto.UserDto;
import hamlog.service.exceptions.DuplicateUserException;
import hamlog.service.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
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

	@Test
	public void testFindById() throws Exception {
		User user = userService.create(createUserDto());
		User retrievedUser = userService.findById(user.getId());
		assertThat(retrievedUser, is(equalTo(user)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindById_NullArgument() throws Exception {
		userService.findById(null);
	}

	@Test
	public void testFindById_NoMatch() throws Exception {
		User retrievedUser = userService.findById(1L);
		assertThat(retrievedUser, is(nullValue()));
	}

	@Test
	public void testDelete() throws Exception {
		User user = userService.create(createUserDto());
		assertThat(userService.findById(user.getId()), is(notNullValue()));

		userService.delete(user.getId());
		assertThat(userService.findById(user.getId()), is(nullValue()));
	}

	@Test
	public void testFindByCallsign() throws Exception {
		User user = userService.create(createUserDto());
		User retrievedUser = userService.findByCallsign(user.getCallsign());
		assertThat(retrievedUser, is(equalTo(user)));
	}

	@Test
	public void testFindByCallsign_CaseInsensitiveMatch() throws Exception {
		User user = userService.create(createUserDto());
		User retrievedUser = userService.findByCallsign(user.getCallsign().toLowerCase());
		assertThat(retrievedUser, is(equalTo(user)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByCallsign_NullArgument() throws Exception {
		userService.findByCallsign(null);
	}

	@Test
	public void testFindByCallsign_NoMatch() throws Exception {
		User retrievedUser = userService.findByCallsign("no-such-callsign");
		assertThat(retrievedUser, is(nullValue()));
	}

	@Test
	public void testUpdate() throws Exception {
		UserDto userDto = createUserDto();
		User user = userService.create(userDto);
		userDto.setId(user.getId());

		userDto.setFirstName("updated-first-name");
		userService.update(userDto);

		User retrievedUser = userService.findById(user.getId());
		assertThat(retrievedUser.getFirstName(), is(equalTo("updated-first-name")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdate_NullArgument() throws Exception {
		userService.update(null);
	}

	@Test(expected = UserNotFoundException.class)
	public void testUpdate_UserNotFound() throws Exception {
		UserDto userDto = createUserDto();
		userDto.setId(1L);
		userService.update(userDto);
	}

	@Test(expected = DuplicateUserException.class)
	public void testUpdate_DuplicateUser() throws Exception {
		// Create first user
		UserDto userDto = createUserDto();
		userService.create(userDto);

		// Create second user
		String firstCallsign = userDto.getCallsign();
		userDto.setCallsign("YO8SSW");

		User secondUser = userService.create(userDto);
		userDto.setId(secondUser.getId());

		// Attempt to update second user
		userDto.setCallsign(firstCallsign);
		User updatedUser = userService.update(userDto);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDelete_NullArgument() throws Exception {
		userService.delete(null);
	}

	@Test
	public void testFindAll() throws Exception {
		UserDto userDto = createUserDto();
		userService.create(userDto);
		assertThat(userService.findAll().size(), is(1));

		userDto.setCallsign("YO8SSW");
		userService.create(userDto);
		assertThat(userService.findAll().size(), is(2));
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
