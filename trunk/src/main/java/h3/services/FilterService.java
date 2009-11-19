package h3.services;

import java.util.Map;

import h3.state.BaseState;
import h3.state.DataStoreState;
import h3.state.FilterState;
import h3.state.StateHolder;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;

@RemoteProxy(creator = SpringCreator.class, creatorParams = @Param(name = "beanName", value = "filterService"))
public class FilterService {
	private StateHolder stateHolder;

	@RemoteMethod
	public void applyData(String screen, String filterId, String storeId,
			Map<String, String> params) {
		BaseState screenState = stateHolder.getState(screen);
		DataStoreState storeState = (DataStoreState) screenState
				.getWidgetState(storeId);
		
		
		FilterState filterState = (FilterState) screenState.getWidgetState(filterId);
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			filterState.setFieldState(entry.getKey(), entry.getValue());
		}
		
		storeState.setFilter(filterState);
	}

	public StateHolder getStateHolder() {
		return stateHolder;
	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}
}
