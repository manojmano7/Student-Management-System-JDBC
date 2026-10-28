	package daoimpl;
	import java.util.List;
	
	import connection.ConnectionFactory;
	
	import java.util.*;
	import java.sql.*;
	
	import dao.StudentDAO;
	import dto.student;
	public class StudentDAOImpl implements StudentDAO {
	
		@Override
		public void addStudent(student student) {
			try {
				Connection con=ConnectionFactory.getConnection();
				
				
				String q="insert into student values(?,?,?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(q);
				
				pstmt.setInt(1, student.getstudentid());
				pstmt.setString(2,student.getname());
				pstmt.setString(3,student.getemail());
				pstmt.setString(4,student.getphone());
				pstmt.setInt(5,student.getage());
				pstmt.setInt(6,student.getCourseid());				
				pstmt.execute();
				System.out.println("details inserted successfully");
				
					
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public List getAllStudent() {
			List<student> list=new ArrayList<>();
			try {
				Connection con=ConnectionFactory.getConnection();
				
				Statement stmt=con.createStatement();
				String q="select * from student";
				
				ResultSet res=stmt.executeQuery(q);
				
				while(res.next()) {
					student s=new student(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
					list.add(s);
				}
				
			}
			catch(Exception e)
			{
				
			}
			return list;
		}
	
		@Override
		public student getStudentById(int id) {
			student s=null;
			try {
				Connection con=ConnectionFactory.getConnection();
				
				String q="select  * from student where student_id=?";
				PreparedStatement pstmt=con.prepareStatement(q);
				
				pstmt.setInt(1, id);
				ResultSet res=pstmt.executeQuery();
				
				if(res.next()) {
					s=new student(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return s;
		}
	
		@Override
		public void updateStudent(student student) {
			try {
				Connection con=ConnectionFactory.getConnection();
				String q="update student set name=?,email=?,phone=?,age=?,course_id=? where student_id=?";
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1,student.getname());
				pstmt.setString(2,student.getemail());
				pstmt.setString(3, student.getphone());
				pstmt.setInt(4, student.getage());
				pstmt.setInt(6, student.getstudentid());
				pstmt.setInt(5,student.getCourseid());
				
				pstmt.execute();
				System.out.println("updated successfully");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public void deleteStudent(int id) {
			try {
				Connection con=ConnectionFactory.getConnection();
				String q="delete from student where student_id=?";
				
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setInt(1, id);
				
				pstmt.execute();
				System.out.println("deleted successfully");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public student searchByName(String name) {
			student s=null;
			try {
				Connection con=ConnectionFactory.getConnection();
				String q="select * from student where name=?";
				
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1, name);
				ResultSet res = pstmt.executeQuery();
				
				if(res.next()) {
					s=new student(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return s;
		}
	
		@Override
		public List searchByAgeRange(int minAge, int maxAge) {
			List<student> list=new ArrayList<>();
			
			try {
				Connection con=ConnectionFactory.getConnection();
				
				String q="select * from student where age between ? and ?";
				PreparedStatement pstmt=con.prepareStatement(q);
				
				pstmt.setInt(1, minAge);
				pstmt.setInt(2, maxAge);
				
				ResultSet res=pstmt.executeQuery();
				while(res.next()) {
					student s=new student(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
					list.add(s);
				}
				
			}
			catch(Exception e) {
				
			}
			return list;
		}
	
		@Override
		public int countStudent() {
			try {
				Connection con=ConnectionFactory.getConnection();
				
				String q="select count(name) from student";
				Statement stmt=con.createStatement();
				ResultSet res=stmt.executeQuery(q);
				
				while(res.next()) {
					return res.getInt(1);
					
				}
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			return 0;
			
			
			
		}

		@Override
		public void getStudentWithCourseId(int studentid) {
			try {
				Connection con=ConnectionFactory.getConnection();
				
				String q = "SELECT s.student_id, s.name, s.email, s.phone, s.age, "
		                 + "c.course_id, c.course_name, c.duration, c.fees "
		                 + "FROM student s "
		                 + "JOIN course c ON s.course_id = c.course_id "
		                 + "WHERE s.student_id = ?";
				
				PreparedStatement pstmt=con.prepareStatement(q);
				
				pstmt.setInt(1, studentid);
				
				ResultSet res=pstmt.executeQuery();
				
				if(res.next()) {
					System.out.println("student is : "+res.getInt("student_id"));
					System.out.println("student name is : "+res.getString("name"));
					System.out.println("student email is : "+res.getString("email"));
					System.out.println("student phone is : "+res.getString("phone"));
					System.out.println("student  age is : "+res.getString("age"));
					System.out.println("<------------------------------------->");
					System.out.println("Course ID  : " + res.getInt("course_id"));
		            System.out.println("Course     : " + res.getString("course_name"));
		            System.out.println("Duration   : " + res.getString("duration"));
		            System.out.println("Fees       : " + res.getDouble("fees"));
				}
				else {
					System.out.println("student not found");
				}
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		

		@Override
		public void getStudentAlongWithParent(int studentid){
		    try {
		        Connection con = ConnectionFactory.getConnection();

		        String q = "SELECT s.student_id, s.name, s.email, s.phone, s.age, "
		                + "p.parent_id, p.parent_name, p.parent_email, p.parent_phone "
		                + "FROM student s "
		                + "JOIN parent p ON s.student_id = p.student_id "
		                + "WHERE s.student_id = ?";

		        PreparedStatement pstmt = con.prepareStatement(q);

		        pstmt.setInt(1, studentid);

		        ResultSet res = pstmt.executeQuery();

		        if(res.next()) {

		            System.out.println("Student ID    : " + res.getInt("student_id"));
		            System.out.println("Student Name  : " + res.getString("name"));
		            System.out.println("Student Email : " + res.getString("email"));
		            System.out.println("Student Phone : " + res.getString("phone"));
		            System.out.println("Student Age   : " + res.getInt("age"));

		            System.out.println("<------------------------------------->");

		            System.out.println("Parent ID    : " + res.getInt("parent_id"));
		            System.out.println("Parent Name  : " + res.getString("parent_name"));
		            System.out.println("Parent Email : " + res.getString("parent_email"));
		            System.out.println("Parent Phone : " + res.getString("parent_phone"));

		        } else {
		            System.out.println("Student or parent details not found");
		        }

		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}

		@Override
		public void getStudentsByCourseId(int courseId) {
			try {
				Connection con = ConnectionFactory.getConnection();
				String q="SELECT s.student_id, s.name, s.email, s.phone, s.age, "
						+"FROM student s"
						+"JOIN course c ON c.course_id=s.course_id"
						+"where student_id=?";
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
	}
