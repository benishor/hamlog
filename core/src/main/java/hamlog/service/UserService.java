package hamlog.service;

import hamlog.domain.User;
import hamlog.dto.UserDto;
import hamlog.service.exceptions.DuplicateUserException;
import hamlog.service.exceptions.UserNotFoundException;

import java.util.List;

/**
 * Declares methods used to obtain and modify user information.
 *
 * @author Adrian Scripcă
 */
public interface UserService {

	/**
	 * Creates a new user filled with the provided data.
	 *
	 * @param userDto data of the user to be created
	 * @return the created user
	 * @throws DuplicateUserException   if the user to be created already exists
	 * @throws IllegalArgumentException if the provided user information is <code>null</code>
	 */
	User create(UserDto userDto) throws DuplicateUserException;

	/**
	 * Deletes a user identified by the provided id.
	 *
	 * @param id the id of the user to be deleted
	 * @return the deleted user
	 * @throws hamlog.service.exceptions.UserNotFoundException
	 *          if the matching user cannot be found
	 */
	User delete(Long id) throws UserNotFoundException;

	/**
	 * Returns a list containing all users.
	 *
	 * @return a list of all users
	 */
	List<User> findAll();

	/**
	 * Retrieves the user with the provided id or <code>null</code> if no matching user can be found.
	 *
	 * @param id the id of the user to be retrieved
	 * @return the user with the given id or <code>null</code> if no match found
	 */
	User findById(Long id);

	/**
	 * Retrieves the user with the provided callsign or <code>null</code> if no matching user can be found.
	 *
	 * @param callsign the callsign of the user to be retrieved
	 * @return the user with the given callsign or <code>null</code> if no match found
	 */
	User findByCallsign(String callsign);

	/**
	 * Updates the information of a user.
	 *
	 * @param updated the information of the updated user
	 * @return the updated user
	 * @throws UserNotFoundException  if no user is found with the given id
	 * @throws DuplicateUserException if the update would create a duplicate user
	 */
	User update(UserDto updated) throws UserNotFoundException, DuplicateUserException;
}
