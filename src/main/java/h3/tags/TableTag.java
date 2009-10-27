package h3.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class TableTag extends SimpleGUITag {
	private List<Map> columns = new ArrayList<Map>();
	public void addColumn(Map<String, Object> column) {
		columns.add(column);
	}

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		super.doTag(arg0);
		this.getAttrs().put("columns", this.columns);
		this.getAttrs().put("xtype", "grid");
	}
}
