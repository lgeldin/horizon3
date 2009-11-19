package h3.state;


public class DataStoreState extends BaseWidgetState {

	private FilterState filterState;
	public void setFilter(FilterState filterState) {
		this.filterState = filterState;
	}
	public FilterState getFilterState() {
		return filterState;
	}
	public void setFilterState(FilterState filterState) {
		this.filterState = filterState;
	}
}
