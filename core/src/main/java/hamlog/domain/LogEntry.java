package hamlog.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Model of a QSO log.
 */
@Entity
public class LogEntry implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String callsign;
	private Date startDate;
	private Date endDate;
	private String frequency;
	private Band band;
	private Mode myMode;
	private Mode hisMode;
	private String rstReceived;
	private String rstSent;
	private String operator;
	private String qth;
	private String comments;
	private String contestCode;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(nullable = false)
	private LogBook logBook;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Mode getMyMode() {
		return myMode;
	}

	public void setMyMode(Mode mode) {
		this.myMode = mode;
	}

	public Mode getHisMode() {
		return hisMode;
	}

	public void setHisMode(Mode hisMode) {
		this.hisMode = hisMode;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public String getRstReceived() {
		return rstReceived;
	}

	public void setRstReceived(String rstReceived) {
		this.rstReceived = rstReceived;
	}

	public String getRstSent() {
		return rstSent;
	}

	public void setRstSent(String rstSent) {
		this.rstSent = rstSent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getQth() {
		return qth;
	}

	public void setQth(String qth) {
		this.qth = qth;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContestCode() {
		return contestCode;
	}

	public void setContestCode(String contestCode) {
		this.contestCode = contestCode;
	}

	public LogBook getLogBook() {
		return logBook;
	}

	public void setLogBook(LogBook logBook) {
		this.logBook = logBook;
	}

	@Override
	public String toString() {
		return "LogEntry{" +
				"id=" + id +
				", callsign='" + callsign + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", frequency='" + frequency + '\'' +
				", band=" + band +
				", myMode='" + myMode + '\'' +
				", hisMode='" + hisMode + '\'' +
				", rstReceived='" + rstReceived + '\'' +
				", rstSent='" + rstSent + '\'' +
				", operator='" + operator + '\'' +
				", qth='" + qth + '\'' +
				", comments='" + comments + '\'' +
				", contestCode='" + contestCode + '\'' +
				'}';
	}
}
