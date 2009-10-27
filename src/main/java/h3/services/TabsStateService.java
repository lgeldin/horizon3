package h3.services;

import h3.state.BaseState;
import h3.state.StateHolder;
import h3.state.TabsState;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;

@RemoteProxy(creator = SpringCreator.class, creatorParams = @Param(name = "beanName", value = "tabsStateService"))
public class TabsStateService {
	private StateHolder stateHolder;

	@RemoteMethod
	public void updateTabsState(String screen, String tabPanel, String tabId) {
		BaseState screenState = stateHolder.getState("screen1");
		TabsState tabsState = (TabsState) screenState.getWidgetState(tabPanel);
		tabsState.setCurrTab(tabId);
	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

	public StateHolder getStateHolder() {
		return stateHolder;
	}

}
