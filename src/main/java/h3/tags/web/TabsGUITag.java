package h3.tags.web;

import h3.state.BaseState;
import h3.state.TabsState;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class TabsGUITag extends SimpleGUITag {

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		// TODO Auto-generated method stub
		super.doTag(arg0);
		getAttrs().put("xtype", "tabpanel");
		BaseState state = (BaseState) this.getContext().getVariable("screenState");
		if (getAttrs().containsKey("id")) {
			String tabsId = (String) getAttrs().get("id");
			TabsState tabsState = (TabsState) state.getWidgetState(tabsId);
			if (tabsState!=null && tabsState.getCurrTab()!=null) {
				getAttrs().put("activeTab" , tabsState.getCurrTab());
			}
			state.setWidgetState(tabsId, new TabsState());
		}
	}

}
