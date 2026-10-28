package main;

import java.util.List;
import java.util.Scanner;

import daoimpl.CourseDAOImpl;
import daoimpl.ParentDAOImpl;
import daoimpl.StudentDAOImpl;
import dto.Course;
import dto.Parent;
import dto.student;

public class StudentManagement {
 public static void main(String [] args) {
	 System.out.println("<------------STUDENT TABLE------------>");
	 System.out.println("enter 1 to add student");
	 System.out.println("enter 2 to get all student");
	 System.out.println("enter 3 to get student by id");
	 System.out.println("enter 4 to update student");
	 System.out.println("enter 5 to delete student");
	 System.out.println("enter 6 to search by name");
	 System.out.println("enter 7 to search by ageRange");
	 System.out.println("enter 8 to count student");
	 
	 System.out.println("<---------------COURSE TABLE----------->");
	 System.out.println("enter 9 to add course");
	 System.out.println("enter 10 to get all course");
	 System.out.println("enter 11 to get course by id");
	 System.out.println("enter 12 to update course");
	 System.out.println("enter 13 to delete course");
	 System.out.println("enter 14 to search by name");
	 System.out.println("enter 15 to search by duration");
	 System.out.println("enter 16 to search by fees");
	 
	 System.out.println("<-----------------JOINS-------------------->");
	 System.out.println("enter 17 to get student details along with course detail");
	 System.out.println("enter 18 to add parent details");
	 System.out.println("enter 19 to get student details along with parent");
	 
	 
	 Scanner sc=new Scanner(System.in);
	 System.out.println("enter your choice");
	 int choice=sc.nextInt();
	 
	 StudentDAOImpl sdao=new StudentDAOImpl();
	 CourseDAOImpl cdao=new CourseDAOImpl();
	 ParentDAOImpl pdao=new ParentDAOImpl();
	 switch(choice) {
	 case 1:{
		 
				System.out.println("enter student id");
				int id=sc.nextInt();
				
				System.out.println("enter student name");
				String name=sc.next();
				
				System.out.println("enter email address");
				String email=sc.next();
				
				System.out.println("enter phone number");
				String phone=sc.next();
				
				System.out.println("enter age");
				int age=sc.nextInt();
				
				System.out.println("available course");
				List<Course> l=cdao.getAllCourse();
				
				for(Course c:l) {
					System.out.println(c.getCourseId()+" "+
									   c.getCourseName()+" "+
							           c.getDuration()+" "+
									   c.getFees());
				}
				System.out.println("which course do you want to choose");
				System.out.println("enter course id");
				int courseid=sc.nextInt();
				
				student s=new student(id,name,email,phone,age,courseid);
				
				sdao.addStudent(s);
				break;
				
				
	 
	 }
	 case 2:{
		 List<student> l=sdao.getAllStudent();
		 
		 for(student s:l) {
			 System.out.println(s.getstudentid()+" "+s.getname()+" "+s.getemail()+" "+s.getphone()+" "+s.getage()+" "+s.getCourseid());
		
		 }
		 break;
	 }
	 case 3:{
		 System.out.println("enter student id to search");
		 int id=sc.nextInt();
		 
		 student sres=sdao.getStudentById(id);
		 System.out.println(sres.getstudentid()+" "+sres.getname()+" "+sres.getemail()+" "+sres.getphone()+" "+sres.getage()+" "+sres.getCourseid());
	 break;
	 }
	 case 4:{
		 System.out.println("enter id to update");
		 int id=sc.nextInt();
		 
		 System.out.println("enter new name");
		 String name=sc.next();
		 
		 System.out.println("enter new email");
		 String email=sc.next();
		 
		 System.out.println("enter new phone number");
		 String phone=sc.next();
		 
		 System.out.println("enter new age");
		 int age=sc.nextInt();
		 
		 System.out.println("enter new course id");
		 int courseid=sc.nextInt();
		 
		 student s=new student(id,name,email,phone,age,courseid);
		 sdao.updateStudent(s);
		 
		 break;
		 
	 }
	 case 5:{
		 System.out.println("enter student id to delete");
		 int id=sc.nextInt();
		 
		 sdao.deleteStudent(id);
		 break;
	 }
	 case 6:{
		 System.out.println("enter name to search");
		 String name=sc.next();
		 
		 student sres=sdao.searchByName(name);
		 System.out.println(sres.getstudentid()+" "+sres.getname()+" "+sres.getemail()+" "+sres.getphone()+" "+sres.getage()+" "+sres.getCourseid());
		 break;
		 
	 }
	 
	 case 7:{
		 System.out.println("enter age start value");
		 int sage=sc.nextInt();
		 
		 System.out.println("enter age end value");
		 int eage=sc.nextInt();
		 
		 List<student> l=sdao.searchByAgeRange(sage, eage);
		 for(student s:l) {
			 System.out.println(s.getstudentid()+" "+s.getname()+" "+s.getemail()+" "+s.getphone()+" "+s.getage()+" "+s.getCourseid());
		 }
		 break;
		 
	 }
	 case 8:{
		 int count=sdao.countStudent();
		 System.out.println(count);
		 break;
	 }
	 case 9:{
		 System.out.println("enter course id");
		 int id=sc.nextInt();
		 
		 System.out.println("enter course name");
		 String name=sc.next();
		 
		 System.out.println("enter course duration");
		 String duration=sc.next();
		 
		 System.out.println("enter course fees");
		 double fees=sc.nextDouble();
		 
		 Course c=new Course(id,name,duration,fees);
		 cdao.addCourse(c);
		 
	 }
	 case 10:{
		 List<Course> l=cdao.getAllCourse();
		 for(Course c:l) {
			 System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration()+" "+c.getFees());
		 }
	 }
	 case 11:{
		 System.out.println("enter course id to search");
		 int id=sc.nextInt();
		 
		 Course cres=cdao.getCourseById(id);
		 System.out.println(cres.getCourseId()+" "+cres.getCourseName()+" "+cres.getDuration()+" "+cres.getFees());
	 }
	 case 12:{
		 System.out.println("enter id to update");
		 int id=sc.nextInt();
		 
		 System.out.println("enter new course name");
		 String name=sc.next();
		 
		 System.out.println("enter new duration");
		 String duration=sc.next();
		 
		 System.out.println("enter new fees");
		 double fees=sc.nextDouble();
		 
		 Course c=new Course(id,name,duration,fees);
		 cdao.updateCourse(c);
		 
	 }
	 case 13:{
		 System.out.println("enter course id to Delete");
		 int id=sc.nextInt();
		 
		 cdao.deleteCourse(id);
	 }
	 case 14:{
		 System.out.println("enter name to search");
		 String name=sc.next();
		 Course cres=cdao.searchByName(name);
		 System.out.println(cres.getCourseId()+" "+cres.getCourseName()+" "+cres.getDuration()+" "+cres.getFees());
	 }
	 case 15:{
		 System.out.println("enter duration to search");
		 String duration=sc.next();
		 
		 List<Course> l=cdao.searchByDuration(duration);
		 for(Course c:l) {
			 System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration()+" "+c.getFees());
		 }
	 }
	 case 16:{
		 System.out.println("enter min fees");
		 double min=sc.nextDouble();
		 
		 System.out.println("enter max fees");
		 double max=sc.nextDouble();
		 
		 List<Course> l=cdao.searchByFeeRange(min, max);
		 for(Course c:l) {
			 System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration()+" "+c.getFees());
		 }
	 }
	 case 17:{
		 System.out.println("enter student id to search");
		 int id=sc.nextInt();
		 sdao.getStudentWithCourseId(id);
		 break;
	 }
	 
	 case 18:{
		 System.out.println("enter parent id");
			int id=sc.nextInt();
			
			System.out.println("enter parent name");
			String name=sc.next();
			
			System.out.println("enter  parent email address");
			String email=sc.next();
			
			System.out.println("enter parent phone number");
			int phone=sc.nextInt();
			
			System.out.println("enter student id");
			int sid=sc.nextInt();
			
			Parent p=new Parent(id,name,email,phone,sid);
			pdao.addParent(p);
			
			
	 }
	 case 19:{
		 System.out.println("enter student id");
		 int id=sc.nextInt();
		 
		 sdao.getStudentAlongWithParent(id);
		 break;
	 }
	 
	 }








 }
}
