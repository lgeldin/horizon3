Ext.namespace("Infra.classes")
Ext.namespace("Infra.util")

Infra.classes.JSLoader = Ext.extend(Object,{
	load : function(url,callback) {
		Ext.Ajax.request({
			url: url,//'./src/SampleClass.js'
			success: function(conn) {
				var $$$result$$$;
				eval("$$$result$$$ = " + conn.responseText);
				if (callback)
					callback($$$result$$$);
			}
		});
	}
});

Infra.util.JSLoader = new Infra.classes.JSLoader();