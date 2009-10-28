package h3.state;

public class BLServiceStoreState extends DataStoreState {
	private Class itemClass;

	public BLServiceStoreState(Class itemClass) {
		setItemClass(itemClass);
	}

	public Class getItemClass() {
		return itemClass;
	}

	public void setItemClass(Class itemClass) {
		this.itemClass = itemClass;
	}
	
}
