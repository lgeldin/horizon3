package h3.tags;

import h3.state.TabsState;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.jelly.DynaTag;
import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;

public class SimpleGUITag extends TagSupport implements DynaTag {
	private Map<String, Object> attrs = new HashMap<String, Object>();

	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		Collection v1 = (Collection) this.getContext().getVariable("items");
		Collection items = new ArrayList();
		this.getContext().setVariable("items", items);
		getBody().run(this.getContext(), arg0);
		this.getContext().setVariable("items", v1);

		if (items.size() > 0)
			attrs.put("items", items);

		v1.add(attrs);
	}

	public Class getAttributeType(String arg0) throws JellyTagException {
		//if (arg0.equals("width"))
		//	return Integer.class;
		return Object.class;
	}

	public void setAttribute(String arg0, Object arg1) throws JellyTagException {
		attrs.put(arg0, arg1);

	}

	public Map<String, Object> getAttrs() {
		return attrs;
	}
	
	
}
