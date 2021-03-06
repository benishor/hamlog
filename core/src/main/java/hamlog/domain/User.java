package hamlog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * An user that uses the application.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String callsign;
    private String password;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<LogBook> logBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", callsign='" + callsign + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
