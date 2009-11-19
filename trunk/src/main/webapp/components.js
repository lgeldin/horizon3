Ext.ns("Ext.ux");
Ext.ux.Filter = Ext.extend(Ext.Component, {
    initComponent: function(){
        Ext.ux.Filter.superclass.initComponent.call(this);
    },
    doApply: function(){
        var params = {};
        this.el.select("input").each(function(input){
            params[input.dom.name] = input.dom.value;
        })
        var store = Ext.StoreMgr.get(this.store);
        FilterService.applyData(this.screenName, this.id, this.store, params, function(){
            store.reload();
        });
    },
    onRender: function(ct, position){
        if (!this.template) {
            this.template = new Ext.XTemplate('', '<div style="border:1px solid blue;margin-bottom:10px;">', 'Filter:<br/>', '<tpl for=".">', '{.}<br/><input name="{.}"/><br/>', '</tpl>', '<button type="button">apply</button>', '</div>');
        }
        var targs = this.initialConfig.fields;
        var el;
        if (position) {
            el = this.template.insertBefore(position, targs, true);
        }
        else {
            el = this.template.append(ct, targs, true);
        }
        el.select("button").first().on("click", this.doApply.createDelegate(this));
        this.el = el;
        x = this;
    }
    
});
Ext.reg('filter', Ext.ux.Filter);
