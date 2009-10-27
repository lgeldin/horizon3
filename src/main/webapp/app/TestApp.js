 Ext.onReady(function() {
 	if (!window.console) window.console = {log:function(){}}
 	var fixLayout = function() { 
 		var t;
 		var totalWidth = window.innerWidth || (Ext.getBody().getWidth()-4);
 		var totalHeight = window.innerHeight || (Ext.getBody().getHeight()-4);
 		var leftPaneWidth = Math.round(totalWidth*0.3);
 		t = Ext.fly("left_pane");
 		t.setWidth(leftPaneWidth);
 		t.setHeight(totalHeight);
 		t = Ext.fly("center_pane");
 		t.setWidth(totalWidth - leftPaneWidth);
 		t.setHeight(totalHeight);
 		t.setLeft(leftPaneWidth)
 	}
 	fixLayout();
 	Ext.EventManager.on(window,"resize",fixLayout);
 	//if (!window.console)
 	//	window.console = {log:alert}
	console.log("Loaded");
	Infra.util.JSLoader.load('./infra/CSSLoader.js')
	Infra.util.JSLoader.load('./infra/ThreadManager.js')
 });
 

INJECTED = {} 
callme = function() {
	Infra.util.JSLoader.load('/H3/retriever',function(result) {
		console.log(result)
		//Infra.util.CSS.loadCSS(result)
		
	})
}
