package hamlog.web.forms;

import hamlog.domain.Band;
import hamlog.domain.Mode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Adrian Scripcă
 */
public class AddQsoForm {

	@NotEmpty
	private String callsign;
	@NotNull
	private Band band;
	@NotNull
	private Mode myMode;
	@NotNull
	private Mode hisMode;
	@NotNull
	private Date startDate = new Date();
	@NotEmpty
	private String rstSent;
	@NotEmpty
	private String rstReceived;
	@NotNull
	private String operator;
	@NotNull
	private String qth;

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public Mode getMyMode() {
		return myMode;
	}

	public void setMyMode(Mode myMode) {
		this.myMode = myMode;
	}

	public Mode getHisMode() {
		return hisMode;
	}

	public void setHisMode(Mode hisMode) {
		this.hisMode = hisMode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getRstSent() {
		return rstSent;
	}

	public void setRstSent(String rstSent) {
		this.rstSent = rstSent;
	}

	public String getRstReceived() {
		return rstReceived;
	}

	public void setRstReceived(String rstReceived) {
		this.rstReceived = rstReceived;
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

	@Override
	public String toString() {
		return "AddQsoForm{" +
				"callsign='" + callsign + '\'' +
				", band=" + band +
				", myMode='" + myMode + '\'' +
				", hisMode='" + hisMode + '\'' +
				", startDate=" + startDate +
				", rstSent='" + rstSent + '\'' +
				", rstReceived='" + rstReceived + '\'' +
				", operator='" + operator + '\'' +
				", qth='" + qth + '\'' +
				'}';
	}
}
