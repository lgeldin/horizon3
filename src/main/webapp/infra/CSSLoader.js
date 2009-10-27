Infra.classes.CSSLoader = Ext.extend(Object,{
	styles : [],
	_loadCss : function(cssStr,id) {
		this.ensureUnique(id);
		var S = document.createElement('style');
		S.type = 'text/css';
		var T = cssStr;
		if (Ext.isIE) {
			S.styleSheet.cssText = T
		}
		else {
			T = document.createTextNode(T)
			S.appendChild(T);
		}
		if (id != null)
			S.id = id;
		var head = document.getElementsByTagName("head")[0]
		head.appendChild(S); //document.body
		this.styles.push({id:id,element:S});
		return S;
	},


	ensureUnique : function(id) {
		if (id!=null) {
			for (var i=0;i<this.styles.length;i++) {
				if (this.styles[i].id==id) {
					var el = this.styles[i].element;
					el.parentNode.removeChild(el);
					this.styles.splice(i,1);
					return;
				}
			}
		}
	},
	
	
	jsonToCSS : function(rules) {
		var result = "";
		for (var i=0;i<rules.length;i++) {
			var rule = rules[i];
			var selectors = rule.selectors;
			var selectorStr = selectors.join(', ');
			
			var attrs = rule.attributes;
			var ruleStr = selectorStr + " { ";
			for (var key in attrs) {
				ruleStr += key + ":" + attrs[key] + "; ";
			}
			ruleStr += "} ";
			result += ruleStr;
		}
		return result;
	},
	
	loadCSS : function(css) {
		this._loadCss(this.jsonToCSS(css.rules),css.id)
	}

})
Infra.util.CSS = new Infra.classes.CSSLoader();