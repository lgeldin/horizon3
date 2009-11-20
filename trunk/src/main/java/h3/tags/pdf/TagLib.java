package h3.tags.pdf;


import org.apache.commons.jelly.TagLibrary;

public class TagLib extends TagLibrary{
	public TagLib() {
		registerTag("screen", ScreenTag.class);
		registerTag("panel", PanelTag.class);
		registerTag("tabs", SimplePDFTag.class);
		registerTag("table", TableTag.class);
		registerTag("col", TableColumnTag.class);
		
		registerTag("dataStores", SimplePDFTag.class);
		registerTag("javaStore", SimplePDFTag.class);
		registerTag("blStore", SimplePDFTag.class);
	
		registerTag("filter", SimplePDFTag.class);
		registerTag("filterField", SimplePDFTag.class);
	}
}
