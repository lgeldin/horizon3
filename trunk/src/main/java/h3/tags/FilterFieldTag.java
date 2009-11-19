package h3.tags;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class FilterFieldTag extends SimpleGUITag {
	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		FilterTag t = (FilterTag)this.getParent();
		t.addField((String) this.getAttrs().get("id"));
	}
}
