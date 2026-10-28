package daoimpl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import dao.CourseDAO;
import dto.Course;


public class CourseDAOImpl implements CourseDAO {

	@Override
	public void addCourse(Course course) {
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="insert into course values(?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1,course.getCourseId());
			pstmt.setString(2,course.getCourseName());
			pstmt.setString(3,course.getDuration());
			pstmt.setDouble(4, course.getFees());
			
			pstmt.execute();
			System.out.println("data inserted successfully");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List getAllCourse() {
		List<Course> list=new ArrayList<>();
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="select * from course";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(q);
			
			while(res.next()) {
				Course c=new Course(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4));
				list.add(c);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Course getCourseById(int id) {
		Course c=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="select * from course where course_id=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				 c=new Course(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateCourse(Course course) {
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="update course set course_name=?,duration=?,fees=? where course_id=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setString(1,course.getCourseName());
			pstmt.setString(2, course.getDuration());
			pstmt.setDouble(3, course.getFees());
			pstmt.setInt(4, course.getCourseId());
			
			pstmt.execute();
			System.out.println("upated successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCourse(int id) {
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="delete from course where course_id=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			pstmt.execute();
			System.out.println("deleted Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Course searchByName(String name) {
		Course c=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="select * from course where course_name=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, name);
			
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				c=new Course(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List searchByDuration(String duration) {
		List<Course> list=new ArrayList<>();
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="select * from course where duration=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, duration);
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				Course c=new Course(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4));
				list.add(c);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List searchByFeeRange(double min, double max) {
		List<Course> list=new ArrayList<>();
		try {
			Connection con=ConnectionFactory.getConnection();
			String q="select * from course where fees between ? and ?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setDouble(1, min);
			pstmt.setDouble(2,max);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				Course c=new Course(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4));
				list.add(c);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countCourses() {
		// TODO Auto-generated method stub
		return 0;
	}

}
