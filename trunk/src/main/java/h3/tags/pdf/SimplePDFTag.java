package h3.tags.pdf;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jelly.DynaTag;
import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;

public class SimplePDFTag extends TagSupport implements DynaTag {
	private Map<String, Object> attrs = new HashMap<String, Object>();

	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		getBody().run(this.getContext(), arg0);
	}

	public Class getAttributeType(String arg0) throws JellyTagException {
		return Object.class;
	}

	public void setAttribute(String arg0, Object arg1) throws JellyTagException {
		attrs.put(arg0, arg1);
	}

	public Map<String, Object> getAttrs() {
		return attrs;
	}
}
