package h3.state;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class FilterState extends BaseWidgetState{
	private Map<String,String> filterFields = new HashMap<String, String>();

	public String getFieldState(String name) {
		return filterFields.get(name);
	}
	
	public void setFieldState(String name,String value) {
		if (StringUtils.isEmpty(value))
			filterFields.put(name, null);
		else
			filterFields.put(name, value);
	}
}
