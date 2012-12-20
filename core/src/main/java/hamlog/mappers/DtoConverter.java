package hamlog.mappers;

import hamlog.domain.LogBook;
import hamlog.domain.User;
import hamlog.dto.LogBookDto;
import hamlog.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains methods for converting between domain model objects and DTOs.
 *
 * @author Adrian Scripcă
 */
public class DtoConverter {

	private static final Logger logger = LoggerFactory.getLogger(DtoConverter.class);

	// DTO -> USER

	public static UserDto convert(User user) {
		return convert(user, new UserDto());
	}

	public static UserDto convert(User user, UserDto userDto) {
		userDto.setId(user.getId());
		userDto.setCallsign(user.getCallsign());
		userDto.setPassword(user.getPassword());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		return userDto;
	}

	// USER -> DTO

	public static User convert(UserDto userDto) {
		return convert(userDto, new User());
	}

	public static User convert(UserDto userDto, User user) {
		user.setId(userDto.getId());
		user.setCallsign(userDto.getCallsign());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		return user;
	}

	// LOGBOOK -> DTO

	public static LogBookDto convert(LogBook logBook) {
		return convert(logBook, new LogBookDto());
	}

	public static LogBookDto convert(LogBook logBook, LogBookDto logBookDto) {
		logBookDto.setId(logBook.getId());
		logBookDto.setName(logBook.getName());
		return logBookDto;
	}

	// DTO -> LOGBOOK

	public static LogBook convert(LogBookDto logBookDto) {
		return convert(logBookDto, new LogBook());
	}

	public static LogBook convert(LogBookDto logBookDto, LogBook logBook) {
		logBook.setId(logBookDto.getId());
		logBook.setName(logBookDto.getName());
		return logBook;
	}
}
