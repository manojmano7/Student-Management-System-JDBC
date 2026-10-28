package daoimpl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

import connection.ConnectionFactory;
import dao.ParentDAO;
import dto.Parent;
public class ParentDAOImpl implements ParentDAO{

	@Override
	public void addParent(Parent p) {
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="insert into parent values(?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1,p.getParent_id());
			pstmt.setString(2, p.getName());
			pstmt.setString(3,p.getEmail());
			pstmt.setInt(4, p.getPhone());
			pstmt.setInt(5, p.getStudent_id());
			
			pstmt.execute();
			System.out.println("data inserted Successfully");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
