({
	details:INJECTED,
	
	constructor : function() {
	},

	doOpenScreen1 : function() {
		loadScreen('screen1',this.details);
	},

	doOpenScreen2 : function() {
		loadScreen('screen2',this.details);
	},
	
	doReload : function() {
		loadScreen('mainScreen');
	}	
	
})