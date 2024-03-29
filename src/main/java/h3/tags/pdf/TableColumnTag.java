package h3.tags.pdf;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

public class TableColumnTag extends SimplePDFTag {
	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		TableTag t = (TableTag)this.getParent();
		t.addColumn(this.getAttrs());
	}
}
