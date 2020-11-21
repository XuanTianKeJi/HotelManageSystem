package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.EmployeeDomain;
import entity.Employee;
import service.EmployeeService;

@RequestMapping("/system")
@Controller
public class UserController {
	@Autowired
	EmployeeService ems;

	// 用户登录
	@RequestMapping("/login")
	public String login() {
		return "/system/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(ModelMap map, String id, String password,HttpSession session) {
		EmployeeDomain ed = ems.queryEmployeeById(id);
		Employee e = new Employee(ed.getEmployeeId(),ed.getEmployeeName(),ed.getEmployeeSex(),ed.getEmployeeAge(),ed.getId(),ed.getHireDate(),ed.getPosition(),ed.getPhone(),ed.getPassword());
		if (e != null) {
			String myuserName = e.getEmployeeId();
			String mypassword = e.getPassword();

			if (myuserName.equals(id) && mypassword.equals(password)) {
				//设置session
				session.setAttribute("loginEmployee", e);
				return "/system/index";
			}
			map.put("loginMessage", "密码错误！");
			return "/system/login";
		} else {
			map.put("loginMessage", "Id或密码错误！");
			return "/system/login";
		}
	}
}
