package hamlog.repository;

import hamlog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian Scripcă
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCallsign(String callsign);
}