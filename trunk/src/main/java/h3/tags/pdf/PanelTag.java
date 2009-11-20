package h3.tags.pdf;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;

public class PanelTag extends SimplePDFTag {

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		if (getAttrs().containsKey("title")) {
			Paragraph string = new Paragraph((String)getAttrs().get("title"));
			
			Document doc = (Document) getContext().getVariable("document");
			//doc.newPage();
			string.setSpacingBefore(20);
			try {
				doc.add(string);
			} catch (DocumentException e) {
				throw new JellyTagException(e);
			}
		}
		super.doTag(arg0);
	}
}
