package bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockBLService implements BLService{
	private Map<Class,List> data = new HashMap<Class,List>();
	public MockBLService() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("AAA","BBB",new Date(),160));
		persons.add(new Person("CCC","DDD",new Date(),180));
		persons.add(new Person("Hello","World",new Date(),180));
		persons.add(new Person("Very","Nice",new Date(),180));
		data.put(Person.class, persons);
		// TODO Auto-generated constructor stub
	}
	public Criteria createCriteria(Class t) {
		return new MockCriteria(data.get(t));
	}

}
