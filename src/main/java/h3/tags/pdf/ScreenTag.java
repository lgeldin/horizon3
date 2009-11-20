package h3.tags.pdf;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;

public class ScreenTag extends SimplePDFTag {

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		Paragraph string = new Paragraph("Screen : "
				+ getContext().getVariable("screenName"));

		Paragraph newLine = new Paragraph("");
		Document doc = (Document) getContext().getVariable("document");
		try {
			doc.add(string);
			doc.add(newLine);
		} catch (DocumentException e) {
			throw new JellyTagException(e);
		}
		super.doTag(arg0);
	}
}
