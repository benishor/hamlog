package hamlog.service.impl;

import hamlog.domain.User;
import hamlog.dto.UserDto;
import hamlog.repository.UserRepository;
import hamlog.service.UserService;
import hamlog.service.exceptions.DuplicateUserException;
import hamlog.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring Data Jpa implementation of the UserService.
 *
 * @author Adrian Scripcă
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(UserDto userDto) throws DuplicateUserException {

		if (userDto == null) {
			throw new IllegalArgumentException("Provided userDto cannot be null");
		}

		User user = new User();
		user.setCallsign(userDto.getCallsign());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		try {
			userRepository.save(user);
			return user;
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateUserException(e);
		}
	}

	@Override
	@Transactional
	public User delete(Long id) throws UserNotFoundException {
		User deleted = userRepository.findOne(id);
		if (deleted != null) {
			userRepository.delete(deleted);
			return deleted;
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByCallsign(String callsign) {
		return userRepository.findByCallsign(callsign);
	}

	@Override
	@Transactional
	public User update(UserDto updated) throws UserNotFoundException, DuplicateUserException {
		User user = userRepository.findOne(updated.getId());
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			try {
				user.setFirstName(updated.getFirstName());
				user.setLastName(updated.getLastName());
				user.setCallsign(updated.getCallsign());
				user.setPassword(updated.getPassword());
				userRepository.save(user);
				return user;
			} catch (DuplicateKeyException e) {
				throw new DuplicateUserException(e);
			}
		}
	}
}
