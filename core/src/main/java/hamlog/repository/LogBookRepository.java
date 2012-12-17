package hamlog.repository;

import hamlog.domain.LogBook;
import hamlog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
@Repository
public interface LogBookRepository extends JpaRepository<LogBook, Long> {

	List<LogBook> findByOwnerOrderByNameAsc(User owner);
}
