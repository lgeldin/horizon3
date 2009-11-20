//JSON containing client methods and components
({
	//mytbl:INJECTED,
	myButton:INJECTED,
	myTabs : INJECTED,
	tab1 : INJECTED,
	
	constructor : function() {
		this.val = 5;
	},
	
	
	doMyClick : function() {
		var rowId = this.mytbl.getCurrentRow();
		this.getRemote().doSomething(rowId);			
	},
	
	
	doButtonClick1 : function() {
		console.log(123 + " " + this.val);
		this.val++;
		if (this.val==9) {
			this.myButton.disable();
		}
		//console.log(this.myButton);
	},
	
	doButtonClick2 : function() {
		this.myButton.enable();
	},

	doButtonClick3 : function() {
		loadScreen('screen2');
	},
	
	doRemote : function() {
		this.remote.callme(this.val,this.remoteCallback.createDelegate(this));
	},
	
	remoteCallback : function(result) {
		alert(this.val + "^2 = " + result);
	},
	
	doReload : function() {
		loadScreen('screen1');
	},
	
	doOpenMain : function() {
		loadScreen("mainScreen");
	},
	doGetCurrTab : function() {
		this.remote.currTab(function(t) {alert(t)});
	},
	doReport : function() {
		window.open("report?screen=screen1")
	}
})