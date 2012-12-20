package hamlog.repository;

import hamlog.domain.LogEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adrian Scripcă
 */
@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

	@Query("SELECT e FROM LogEntry e WHERE e.logBook.id = :logBookId ORDER BY e.startDate asc")
	List<LogEntry> findLogEntriesForLogBook(@Param("logBookId") Long logBookId);

	@Query("SELECT e FROM LogEntry e WHERE e.logBook.id = :logBookId ORDER BY e.startDate asc")
	Page<LogEntry> findLogEntriesForLogBook(@Param("logBookId") Long logBookId, Pageable pageable);
}
