package h3.state;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.PropertyUtils;

public class BaseState {
	private HashMap<String, BaseWidgetState> states = new HashMap<String,BaseWidgetState>();
	public BaseWidgetState getWidgetState(String widgetId) {
		return states.get(widgetId);
	}
	
	public void setWidgetState(String widgetId,BaseWidgetState widgetState) {
		states.put(widgetId, widgetState);
		try {
			PropertyUtils.setProperty(this, widgetId,widgetState);
		} catch (IllegalAccessException e) {
			System.out.println("Can't set a property " + widgetId + "\t" + e.getClass().getSimpleName());
		} catch (InvocationTargetException e) {
			System.out.println("Can't set a property " + widgetId + "\t" + e.getClass().getSimpleName());
		} catch (NoSuchMethodException e) {
			System.out.println("Can't set a property " + widgetId + "\t" + e.getClass().getSimpleName());
		}

	}
}
