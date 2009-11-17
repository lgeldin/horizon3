package h3;

import h3.state.StateHolder;
import h3.tags.H3TagLib;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.JellyException;
import org.apache.commons.jelly.XMLOutput;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.xml.sax.InputSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GUIRetrievingServlet extends AbstractController{//extends HttpServlet {
	private StateHolder stateHolder;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		final String screen = req.getParameter("screen");
		PrintWriter writer = resp.getWriter();

		writer.write("{ layout : ");
		renderLayout(screen, writer);
		writer.write(" , \n");
		writer.write("client : \n");
		renderClientJS(screen, writer);
		writer.write(" , \n");
		writer.write("remoteCreator : function(" + screen +") {");
		renderDwr(req, resp, writer, screen);
		writer.write("}\n");
		writer.write(" , \n");
		writer.write(" styles : ");
		renderClientStyles(screen, writer);
		writer.write("}\n");
		return null;
	}

	private void renderDwr(HttpServletRequest req, HttpServletResponse resp,PrintWriter writer,
			final String screen) throws ServletException, IOException {
		HttpServletRequest req2 = new HttpServletRequestWrapper(req) {
			
			@Override
			public String getPathInfo() {
				return "/interface/"+screen+".js";
			}
		};//new FakeHttpServletRequest();//
		HttpServletResponse resp2 = new HttpServletResponseWrapper(resp);
		req.getRequestDispatcher("/dwr/interface/" + screen + ".js").include(req2, resp2);
		writer.write("\n"+screen+"._path = '"+ req.getContextPath() +"/dwr';\n");
	}

	private void renderClientJS(String screen, PrintWriter writer)
			throws IOException {
		InputStream jsStream = this.getClass().getClassLoader().getResourceAsStream("app/"+screen+"/client.js");
		IOUtils.copy(new InputStreamReader(jsStream), writer);
	}
	private void renderClientStyles(String screen, PrintWriter writer)
			throws IOException {
		InputStream jsStream = this.getClass().getClassLoader().getResourceAsStream("app/"+screen+"/style.js");
		IOUtils.copy(new InputStreamReader(jsStream), writer);
	}

	private void renderLayout(String screen, PrintWriter writer)
			throws IOException {
		Object state = stateHolder.getState(screen);

		
		InputStream layoutStream = this.getClass().getClassLoader().getResourceAsStream("app/"+screen+"/layout.xml");
		InputStream dataStoresStream = this.getClass().getClassLoader().getResourceAsStream("app/"+screen+"/dataStores.xml");
	    JellyContext context = new JellyContext();
	    Map m = new HashMap();
	    Collection v = new ArrayList();
	    m.put("items", v);
        context.setVariable("v", m);
        context.setVariable("items", v);
        context.setVariable("screenState", state);
        //context.setVariable("y", new TryMe());
        context.registerTagLibrary("h3", H3TagLib.class.getName());
	    XMLOutput xmlOutput = XMLOutput.createDummyXMLOutput();
	    //System.out.println(Class.class.getResourceAsStream("a.xml"));
	    try {
			context.runScript(new InputSource(layoutStream) , xmlOutput);
			if (dataStoresStream!=null)
				context.runScript(new InputSource(dataStoresStream) , xmlOutput);
			
		} catch (JellyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xmlOutput.flush();	

        
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		
		String str = gson.toJson(m);

		writer.write(str);
	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

	public StateHolder getStateHolder() {
		return stateHolder;
	}

}
