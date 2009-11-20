package h3;

import h3.services.DataStoreService;
import h3.state.StateHolder;
import h3.tags.pdf.TagLib;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.JellyException;
import org.apache.commons.jelly.XMLOutput;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.xml.sax.InputSource;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfCreator extends AbstractController {
	private StateHolder stateHolder;
	private DataStoreService storeService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String screen = req.getParameter("screen");
		//PrintWriter writer = resp.getWriter();

		//writer.write("OK" + screen);
		
		
		
		resp.setContentType("application/pdf");
		
		
		Document doc = new Document();
		PdfWriter w = PdfWriter.getInstance(doc, resp.getOutputStream());
		doc.open();
		
		renderLayout(screen, doc);

		
		doc.close();

		return null;
	}

	private void renderLayout(String screen, Document doc)
			throws IOException {
		Object state = stateHolder.getState(screen);

		InputStream layoutStream = this.getClass().getClassLoader()
				.getResourceAsStream("app/" + screen + "/layout.xml");
		JellyContext context = new JellyContext();
		context.setVariable("document", doc);
		context.setVariable("screenState", state);
		context.setVariable("screenName", screen);
        context.setVariable("storeService", storeService);
        
		context.registerTagLibrary("h3", TagLib.class.getName());
		XMLOutput xmlOutput = XMLOutput.createDummyXMLOutput();
		try {
			context.runScript(new InputSource(layoutStream), xmlOutput);
		} catch (JellyException e) {
			e.printStackTrace();
		}
		xmlOutput.flush();

	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

	public StateHolder getStateHolder() {
		return stateHolder;
	}

	public DataStoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(DataStoreService storeService) {
		this.storeService = storeService;
	}
}
