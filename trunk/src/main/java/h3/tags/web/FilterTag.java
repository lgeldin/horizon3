package h3.tags.web;

import h3.state.BaseState;
import h3.state.FilterState;
import h3.state.TabsState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class FilterTag extends SimpleGUITag{
	private List<String> fields = new ArrayList<String>();
	public void addField(String field) {
		fields.add(field);
	}

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		super.doTag(arg0);
		this.getAttrs().put("fields", this.fields);
		this.getAttrs().put("xtype", "filter");
		
		String filterId = (String) getAttrs().get("id");
		BaseState state = (BaseState) this.getContext().getVariable("screenState");
		FilterState filterState = (FilterState) state.getWidgetState(filterId);
		if (filterState == null) {
			filterState = new FilterState();
			state.setWidgetState(filterId, filterState);
		}
		
		for (String field:this.fields) {
			filterState.setFieldState(filterId, null);
		}
	}
}
