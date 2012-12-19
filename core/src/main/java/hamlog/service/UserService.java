package hamlog.service;

import hamlog.domain.User;

import java.util.List;

public interface UserService {

	User add(User user);

	List<User> getAllUsers();

    void delete(User user);
}
