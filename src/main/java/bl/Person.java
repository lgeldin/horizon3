package bl;

import java.util.Date;

public class Person {
	private String name;
	private String lastName;
	private Date birthDate;
	private Integer height;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(String name, String lastName, Date birthDate, Integer height) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
}
