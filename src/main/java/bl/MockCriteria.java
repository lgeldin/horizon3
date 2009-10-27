package bl;

import java.util.Collection;

public class MockCriteria implements Criteria {
	private Collection data;

	public MockCriteria(Collection data) {
		this.data = data;
	}
	
	public Collection invoke() {
		return this.data;
	}
}
