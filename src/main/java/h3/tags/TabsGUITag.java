package h3.tags;

import h3.state.BaseState;
import h3.state.TabsState;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
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
			state.setWidgetState((String) getAttrs().get("id"), new TabsState());
		}
	}

}
