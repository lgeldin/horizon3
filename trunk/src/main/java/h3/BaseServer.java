package h3;

import h3.state.StateHolder;

import org.directwebremoting.annotations.RemoteProxy;

public class BaseServer<T> {
	private StateHolder stateHolder;
	private String screenName;
	
	public BaseServer() {
		this.screenName = this.getClass().getAnnotation(RemoteProxy.class).name();
	}
	
	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

	public StateHolder getStateHolder() {
		return stateHolder;
	}
	
	public T getState() {
		return (T)this.getStateHolder().getState(this.screenName);
	}
	
	
}
