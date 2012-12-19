package hamlog.repository;

import hamlog.domain.LogBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
@Repository
public interface LogBookRepository extends JpaRepository<LogBook, Long> {

	@Query("SELECT l FROM LogBook l WHERE l.owner.id = :userId ORDER BY l.name asc")
	List<LogBook> findLogbooksForUser(@Param("userId") Long userId);
}
