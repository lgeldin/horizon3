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
}
