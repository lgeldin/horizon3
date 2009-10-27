package h3.state;

import java.util.HashMap;
import java.util.Map;

public class StateHolder {
	private Map<String,BaseState> states = new HashMap<String, BaseState>();
	public BaseState getState(String screenName) {
		BaseState state = states.get(screenName);
		if (state==null) {
			try {
				state = (BaseState) Class.forName("app."+screenName+".State").newInstance();
				states.put(screenName, state);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return state;
	}
}
