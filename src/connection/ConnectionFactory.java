package connection;

import java.sql.*;
public class ConnectionFactory {
   private static final String URL="jdbc:mysql://localhost:3306/student_db";
   private static final String USER="root";
   private static final String PASSWORD="root";
   
   public static Connection getConnection() {
	   try {
		   return DriverManager.getConnection(URL,USER,PASSWORD);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   return null;
	   }
   }

}
