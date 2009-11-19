package h3.tags;


import org.apache.commons.jelly.TagLibrary;

public class H3TagLib extends TagLibrary{
	public H3TagLib() {
		registerTag("screen", SimpleGUITag.class);
		registerTag("panel", SimpleGUITag.class);
		registerTag("tabs", TabsGUITag.class);
		registerTag("table", TableTag.class);
		registerTag("col", TableColumnTag.class);
		
		registerTag("dataStores", SimpleGUITag.class);
		registerTag("javaStore", JavaStoreTag.class);
		registerTag("blStore", BLServiceStoreTag.class);
	
		registerTag("filter", FilterTag.class);
		registerTag("filterField", FilterFieldTag.class);
		
	}
}
