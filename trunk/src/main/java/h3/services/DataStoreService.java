package h3.services;

import h3.BaseServer;
import h3.state.BaseState;
import h3.state.DataStoreState;
import h3.state.StateHolder;
import h3.state.TabsState;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

@RemoteProxy(creator = SpringCreator.class, creatorParams = @Param(name = "beanName", value = "dataStoreService"))
public class DataStoreService implements BeanFactoryAware {
	private BeanFactory factory;
	private StateHolder stateHolder;

	@RemoteMethod
	public Object getData(String screen, String storeId) {
		BaseState screenState = stateHolder.getState(screen);
		DataStoreState storeState = (DataStoreState) screenState
				.getWidgetState(storeId);
		BaseServer server = (BaseServer) factory.getBean(screen);
		return storeState.getData(server);

	}

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

}
