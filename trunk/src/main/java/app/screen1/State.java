package app.screen1;

import h3.state.BaseState;
import h3.state.TabsState;

public class State extends BaseState{
	private TabsState myTabs;

	public void setMyTabs(TabsState myTabs) {
		this.myTabs = myTabs;
	}

	public TabsState getMyTabs() {
		return myTabs;
	}
}
