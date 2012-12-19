package hamlog.service;

import hamlog.domain.User;
import hamlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User add(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user.getId());
    }
}
