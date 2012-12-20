package hamlog.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * A container of log entries for a given user.
 */
@Entity
public class LogBook implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private User owner;
	@OneToMany(mappedBy = "logBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LogEntry> logEntries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<LogEntry> getLogEntries() {
		return logEntries;
	}

	@Override
	public String toString() {
		return "LogBook{" +
				"id=" + id +
				", name='" + name + '\'' +
				", owner=" + owner +
				'}';
	}
}
