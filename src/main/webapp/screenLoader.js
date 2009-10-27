INJECTED = {} 

tabChangedHandler = function(tabPanel,tab,screen) {
	TabsStateService.updateTabsState(screen,tabPanel.id,tab.id)
}

loadStore = function(item,client,screenName) {
	if (client[item.store] && client[item.store] != INJECTED)
		return client[item.store];
	var fields = [];
	for (var i=0;i<item.columns.length;i++) {
		fields.push(item.columns[i].dataIndex);
	}

	var store = new Ext.data.JsonStore({fields: fields});
	DataStoreService.getData(screenName, item.store,function(data) {
		store.loadData(data);
	});
	return store;

	 

}
preRenderItem = function(item,client,screenName) {
	if (item.handler)
		item.handler = client[item.handler].createDelegate(client)
		
	if (item.xtype == "tabpanel") {
		if (!item.listeners)
			item.listeners = {};
		item.listeners.tabchange = tabChangedHandler.createDelegate(null,[screenName],true);
	}
	
	if (item.xtype == "grid") {
		item.store = loadStore(item,client,screenName);
	}
	
	if (item.items) {
		for (var i=0;i<item.items.length;i++) {
			preRenderItem(item.items[i],client,screenName);
		}
	}
}

prepareClient = function(clientDef) {
	var TmpCls = Ext.extend(Object,clientDef);
	
	return new TmpCls(); 
}

injectElements = function(clientObj) {
	for (var key in clientObj) {
		if (clientObj[key] == INJECTED) {
			clientObj[key] = Ext.ComponentMgr.get(key);
		}
	}
}

loadStyles = function(rules) {
	var css = {
		id:'screenRules',
		rules:rules
	}
	Infra.util.CSS.loadCSS(css);
}

/*
var S = document.createElement('script');
S.id = "tmp1"
S.src="about:blank"
S.text="t = function() {\n alert(123);\n}"
var head = document.getElementsByTagName("head")[0]
head.appendChild(S);
*/
loadScreen = function(scr,container) {
	if (!container)
		container = Ext.ComponentMgr.get("viewPort");
	Infra.util.JSLoader.load('/H3/retriever?screen='+scr,function(result) {
		window.lastResult = result;
		with(container) {
			removeAll();
			var layoutItem = result.layout.items[0];
			var clientObj = prepareClient(result.client);
			preRenderItem(layoutItem,clientObj,scr);
			var t = add(layoutItem);
			injectElements(clientObj);
			clientObj.remote = {};
			//result.remoteCreator.apply(window,[clientObj.remote]);
			result.remoteCreator(clientObj.remote);
			loadStyles(result.styles)
			doLayout();
		}
	})
}
