Ext.namespace("Infra.classes")
Ext.namespace("Infra.util")

Infra.classes.ThreadManager = Ext.extend(Object,{
	threads:[],
	constructor : function() {
		
	},
	addThread : function(thread) {
		threads.push(thread);
		
	}
});

Infra.classes.SimpleThread = Ext.extend(Object,{
	constructor : function() {
	
	}
})
Infra.util.Thread = new Infra.classes.ThreadManager();