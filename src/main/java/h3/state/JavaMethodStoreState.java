package h3.state;

import java.lang.reflect.InvocationTargetException;

import h3.BaseServer;

public class JavaMethodStoreState extends DataStoreState{
	private String methodName;

	public JavaMethodStoreState(String string) {
		this.setMethodName(string);
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public Object getData(BaseServer server) {
		try {
			return server.getClass().getMethod(methodName).invoke(server);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
