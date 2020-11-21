package entity;

public class Employee {
	String employeeId;
	String employeeName;
	int employeeSex;
	int employeeAge;
	String id;
	String hireDate;
	String position;
	String phone;
	String password;
	
	public Employee() {
		
	}

	public Employee(String employeeId, String employeeName, int employeeSex, int employeeAge, String id,
			String hireDate, String position, String phone, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSex = employeeSex;
		this.employeeAge = employeeAge;
		this.id = id;
		this.hireDate = hireDate;
		this.position = position;
		this.phone = phone;
		this.password = password;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(int employeeSex) {
		this.employeeSex = employeeSex;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
