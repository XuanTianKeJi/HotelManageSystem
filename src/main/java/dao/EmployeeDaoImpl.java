package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.EmployeeDomain;
import utils.DBUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	DBUtil dbUtil;

	/**
	 * 通过员工id查询单个员工
	 */
	public EmployeeDomain queryEmployeeById(String id) {
		// TODO Auto-generated method stub
		ResultSet rs = dbUtil.executeProcedure("{call SelectOneEmployee(?)}", new Object[] { id });
		EmployeeDomain e = null;
		try {
			if (rs.next()) {
				e = new EmployeeDomain(rs.getString("EmployeeId"), rs.getString("EmployeeName"), rs.getInt("EmployeeSex"),
						rs.getInt("EmployeeAge"), rs.getString("Id"), rs.getString("HireDate"),
						rs.getString("Position"), rs.getString("Phone"), rs.getString("Password"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return e;
	}

}
