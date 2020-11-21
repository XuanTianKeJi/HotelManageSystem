package domain;

public class EmployeeDomain {
	String EmployeeId;
	String EmployeeName;
	int EmployeeSex;
	int EmployeeAge;
	String Id;
	String HireDate;
	String Position;
	String Phone;
	String Password;
	
	public EmployeeDomain() {
		
	}

	public EmployeeDomain(String employeeId, String employeeName, int employeeSex, int employeeAge, String id,
			String hireDate, String position, String phone, String password) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmployeeSex = employeeSex;
		EmployeeAge = employeeAge;
		Id = id;
		HireDate = hireDate;
		Position = position;
		Phone = phone;
		Password = password;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public int getEmployeeSex() {
		return EmployeeSex;
	}

	public void setEmployeeSex(int employeeSex) {
		EmployeeSex = employeeSex;
	}

	public int getEmployeeAge() {
		return EmployeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		EmployeeAge = employeeAge;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getHireDate() {
		return HireDate;
	}

	public void setHireDate(String hireDate) {
		HireDate = hireDate;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
