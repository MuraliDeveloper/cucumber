package calc;

public class Person {

	String name ;
	int age  ;
	String city ;
	String userType;
	String desc;
	String password;
	String access;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Person(String name, int age, String city, String userType,String desc,String password) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.userType = userType;
		this.desc = desc;
		this.password=password;
	}
	public Person() {
		super();
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	

}
