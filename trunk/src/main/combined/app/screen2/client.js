//JSON containing client methods and components
({
	//mytbl:INJECTED,
	myButton:INJECTED,
	
	ds1 : INJECTED,
	
	constructor : function() {
		this.val = 5;
		
		// @todo: TEMPORARY
		/*
		this.ds1 = new Ext.data.JsonStore({
			fields: ['col1', 'col2']
    	});
		this.ds1.loadData([
			{col1:'111',col2:'222'},
			{col1:'333',col2:'444'}
			]);
			*/
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
		alert("ok");
		alert(this.myButton);
		console.log(this.myButton)
	},
	
	openScreen1 : function() {
		loadScreen("screen1");
		console.log(arguments)
	},
	
	doReload : function() {
		loadScreen("screen2");
	}
})