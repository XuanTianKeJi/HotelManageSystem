package dao;

import domain.EmployeeDomain;

public interface EmployeeDao {
	public EmployeeDomain queryEmployeeById(String id);
}
