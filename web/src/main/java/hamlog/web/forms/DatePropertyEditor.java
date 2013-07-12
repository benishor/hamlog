package hamlog.web.forms;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Adrian Scripcă
 */
public class DatePropertyEditor extends PropertyEditorSupport {

	public static String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Override
	public String getAsText() {
		return dateFormat.format(getValue());
	}

	@Override
	public void setAsText(String text) {
		try {
			Date result = dateFormat.parse(text);
			setValue(result);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
