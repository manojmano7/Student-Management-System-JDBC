package dao;

import dto.Course;
import java.util.*;

public interface CourseDAO {
	void addCourse(Course course);
	List getAllCourse();
	Course getCourseById(int id);
	void updateCourse(Course course);
	void deleteCourse(int id);
	Course searchByName(String name);
	List searchByDuration(String duration);
	List searchByFeeRange(double min,double max);
	int countCourses();
	
}
