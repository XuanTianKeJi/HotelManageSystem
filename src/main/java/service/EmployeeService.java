package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmployeeDaoImpl;
import domain.EmployeeDomain;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDaoImpl emp;
	public EmployeeDomain queryEmployeeById(String id) {
		return emp.queryEmployeeById(id);
	};
}
