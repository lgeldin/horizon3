package h3.services;

import h3.BaseServer;
import h3.state.BLServiceStoreState;
import h3.state.BaseState;
import h3.state.DataStoreState;
import h3.state.JavaMethodStoreState;
import h3.state.StateHolder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import bl.BLService;

@RemoteProxy(creator = SpringCreator.class, creatorParams = @Param(name = "beanName", value = "dataStoreService"))
public class DataStoreService implements BeanFactoryAware {
	private BeanFactory factory;
	private StateHolder stateHolder;
	private BLService blService;

	@RemoteMethod
	public Object getData(String screen, String storeId) {
		BaseState screenState = stateHolder.getState(screen);
		DataStoreState storeState = (DataStoreState) screenState
				.getWidgetState(storeId);
		return retrieveData(storeState, screen);

	}

	@RemoteMethod
	public void setData(String screen, String storeId, Map json, Map data) {
		BaseState screenState = stateHolder.getState(screen);
		DataStoreState storeState = (DataStoreState) screenState
				.getWidgetState(storeId);
		if (storeState instanceof BLServiceStoreState) {
			updateData((BLServiceStoreState) storeState, json, data);
		}
	}

	private void updateData(BLServiceStoreState state, Map json, Map data) {
		Collection<Object> col = blService.createCriteria(state.getItemClass())
				.invoke();
		List<Map> result = new ArrayList<Map>();
		for (Object o : col) {
			try {
				Map item = BeanUtils.describe(o);

				if (item.equals(json)) {
					BeanUtils.populate(o, data);
					return;
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Object retrieveData(DataStoreState state, String screen) {
		if (state instanceof JavaMethodStoreState) {
			return javaStateRetriever((JavaMethodStoreState) state, screen);
		} else if (state instanceof BLServiceStoreState) {
			return blServiceRetriever((BLServiceStoreState) state);
		}
		return null;
	}

	private Object blServiceRetriever(BLServiceStoreState state) {
		Collection<Object> col = blService.createCriteria(state.getItemClass())
				.invoke();
		List<Map> result = new ArrayList<Map>();
		for (Object o : col) {
			Map row = null;
			try {
				row = BeanUtils.describe(o);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (row != null) {
				boolean matches = true;
				if (state.getFilterState() != null) {
					for (Map.Entry<String,Object> entry:((Map<String,Object>)row).entrySet()) {
						
						
						String fltr = state.getFilterState().getFieldState(entry.getKey());
						if (fltr!=null) {
							if (entry.getValue()==null)
								matches = false;
							else 
								matches = String.valueOf(entry.getValue()).toLowerCase().contains(fltr.toLowerCase());
						}
					}
				} 
				
				if (matches)
					result.add(row);
				
			}
		}
		return result;
	}

	private Object javaStateRetriever(JavaMethodStoreState state, String screen) {
		BaseServer server = (BaseServer) factory.getBean(screen);
		try {
			return server.getClass().getMethod(state.getMethodName()).invoke(
					server);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}

	public void setStateHolder(StateHolder stateHolder) {
		this.stateHolder = stateHolder;
	}

	public void setBlService(BLService blService) {
		this.blService = blService;
	}

}
