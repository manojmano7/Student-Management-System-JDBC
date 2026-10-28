package dao;


import java.util.*;

import dto.student;

public interface StudentDAO {
		void addStudent(student student);
		List getAllStudent();
		student getStudentById(int id);
		void updateStudent(student student);
		void deleteStudent(int id);
		student searchByName(String name);
		List searchByAgeRange(int minAge,int maxAge);
		int countStudent();
		void getStudentWithCourseId(int studentid);
		void getStudentsByCourseId(int courseId);
		void getStudentAlongWithParent(int studentid);
		
}
