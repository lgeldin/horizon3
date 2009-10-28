package app.screen2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import h3.BaseServer;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;

import bl.BLService;

@RemoteProxy(name = "screen2", 
		creator = SpringCreator.class, 
		creatorParams = @Param(name = "beanName", value = "screen2"))
public class Server extends BaseServer<State>{
	private BLService blService;
	@RemoteMethod
	public void callme() {

	}
	
	public Collection getDataForDS1() {
		Collection data = new ArrayList();
		Map row;

		row = new HashMap();
		row.put("col1", "123");
		row.put("col2", "456");
		data.add(row);
		
		row = new HashMap();
		row.put("col1", "Nice");
		row.put("col2", "OK!!!");
		data.add(row);

		return data;
	}

	public void setBlService(BLService blService) {
		this.blService = blService;
	}
	
}
