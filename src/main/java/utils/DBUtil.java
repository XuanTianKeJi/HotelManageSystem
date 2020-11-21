package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
/**
 * 
 * @author hyb
 *
 */
@Component
public class DBUtil {
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=HotelDateBase";
	String userName = "sqlServer";
	String userPwd = "123456";
	Connection dbConn = null;
	Statement sta = null;
	PreparedStatement psta = null;
	java.sql.CallableStatement csta = null;
	ResultSet rs = null;
/**
 * 构造方法 获取连接
 */
	public DBUtil() {
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @author hyb
	 * @Description 关闭所有连接
	 * @date 2020年11月20日 下午9:56:15void
	 */
	public void closeAll() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(csta != null) {
			try {
				csta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(dbConn != null) {
			try {
				dbConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @author hyb
	 * @Description 查询
	 * @date 2020年11月20日 下午10:04:36
	 *       @param sql
	 *       @param columnNames
	 *       @returnResultSet
	 */
	public ResultSet excuteQuery(String sql,String columnNames[]) {
		try {
			PreparedStatement psta = dbConn.prepareStatement(sql, columnNames);
			rs = psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 
	 * @author hyb
	 * @Description 增删改
	 * @date 2020年11月20日 下午10:04:51
	 *       @param sql
	 *       @param columnNamesvoid
	 */
	public void excuteUpdate(String sql,String columnNames[]) {
		try {
			PreparedStatement psta = dbConn.prepareStatement(sql, columnNames);
			psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @author hyb
	 * @Description 调用存储过程，无输出参数
	 * @date 2020年11月20日 下午10:17:05
	 *       @param sql
	 *       @param input
	 *       @returnResultSet
	 */
	public ResultSet executeProcedure(String sql,Object input[]) {
		try {
			csta = dbConn.prepareCall(sql);
			int i = 1;//设置输入参数的下标
			for(Object o:input) {//设置输入参数
				csta.setObject(i, o);
				i++;
			}
			rs =csta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
