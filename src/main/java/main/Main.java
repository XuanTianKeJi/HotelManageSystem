package main;

import utils.DBUtil;

public class Main {
	public static void main(String[] args) {
//		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HotelDateBase";
//        String userName="sqlServer";
//        String userPwd="123456";
//         try
//       {
//           Class.forName(driverName);
//           Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
//           System.out.println("success!");
//        }
//         catch(Exception e)
//      {
//           e.printStackTrace();
//           System.out.print("fail!");
//      }
		
		
		DBUtil d = new DBUtil();
		
		d.executeProcedure("{call AddOneRoom(?,?,?,?)}", new Object[]{"O002","单人间","未入住",100});
	}
}
