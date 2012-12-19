package hamlog.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A DTO object that is used to transport information to and from GUI.
 *
 * @author Adrian Scripcă
 * @see hamlog.domain.LogBook
 */
public class LogBookDto {

	private Long id;
	private String name;

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

	@Override
	public String toString() {
		return "LogBookDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
