package app.mainScreen;

import h3.BaseServer;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;

@RemoteProxy(name = "mainScreen", 
		creator = SpringCreator.class, 
		creatorParams = @Param(name = "beanName", value = "mainScreen"))
public class Server extends BaseServer<State>{

	@RemoteMethod
	public int callme(int i) {
		return i*i;
	}
	
	@RemoteMethod
	public String currTab() {
		return getState().getMyTabs().getCurrTab();
	}

}
