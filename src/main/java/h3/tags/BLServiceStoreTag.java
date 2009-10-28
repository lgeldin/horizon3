package h3.tags;

import h3.state.BLServiceStoreState;
import h3.state.BaseState;
import h3.state.JavaMethodStoreState;
import h3.state.TabsState;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class BLServiceStoreTag extends SimpleGUITag {
	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		BaseState state = (BaseState) this.getContext().getVariable("screenState");
		if (getAttrs().containsKey("id")) {
			String itemClassName = (String) getAttrs().get("itemClass");
			Class itemClass = null;
			try {
				itemClass = Class.forName(itemClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			state.setWidgetState((String) getAttrs().get("id"), 
					new BLServiceStoreState(itemClass));
		}
	}
}
