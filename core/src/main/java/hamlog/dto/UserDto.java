package hamlog.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A DTO object that is used to transport information to and from GUI.
 *
 * @author Adrian Scripcă
 * @see hamlog.domain.User
 */
public class UserDto {

	private Long id;
	private String callsign;
	private String password;
	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"id=" + id +
				", callsign='" + callsign + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
